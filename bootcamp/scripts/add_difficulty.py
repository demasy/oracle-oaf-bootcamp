"""Add Difficulty ratings (1 to 5 star icons) to the bootcamp READMEs: per module, then per lecture.

The stars are SVG images (bootcamp/assets/difficulty-star.svg):
1 Beginner, 2 Elementary, 3 Intermediate, 4 Advanced, 5 Expert.

Module ratings are kept in RATINGS below (edit them there and re-run on a fresh README).
Lecture rating rule: Video lectures take their module's rating; Lab and Workshop lectures
are one star harder, up to 5.

Run from anywhere:  python3 bootcamp/scripts/add_difficulty.py
Each step skips itself if the README already has it, so the script can be run again safely.
"""
import os
import re

ROOT = os.path.join(os.path.dirname(os.path.abspath(__file__)), "..", "..")

# relative path from each README (two folders deep) to the assets folder
ASSETS = "../../assets/"

# rating (number of stars) -> level name
MEANING = {1: "Beginner", 2: "Elementary", 3: "Intermediate", 4: "Advanced", 5: "Expert"}
STAR = '<img src="{rel}difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle">'

# course -> (README path, module-ID prefix, relative path to the assets folder, [(module title, stars), ...])
RATINGS = {
    "101": (
        "bootcamp/building/101/README.md",
        "B101",
        ASSETS,
        [
            ("BootCamp Orientation and Success Path", 1),
            ("OAF Architecture and MVC Paradigms", 1),
            ("IDE Setup and Project Topology", 1),
            ("Application Module Construction", 1),
            ("View Object Development", 2),
            ("Entity Object and DML Layer", 2),
            ("Declarative Page Layouts", 1),
            ("Reusable UI Components", 2),
            ("Controller Request Processing", 2),
            ("Master-Detail Relationships", 2),
            ("JDeveloper Debugging", 1),
            ("Security Implementation", 2),
            ("Development Standards and Best Practices", 1),
            ("OAF Application Deployment", 2),
            ("Jobs and Positions Management Capstone", 2),
        ],
    ),
    "102": (
        "bootcamp/building/102/README.md",
        "B102",
        ASSETS,
        [
            ("Form Event Handling Lifecycle", 3),
            ("Asynchronous UI via PPR", 3),
            ("List of Values (LOV) Engineering", 3),
            ("Enterprise Exception Framework", 3),
            ("Modal Dialogs and Page Navigation", 3),
            ("Advanced Table Operations", 4),
            ("Dynamic UI Control and Focus", 4),
            ("Advanced Model and Server-Side Features", 4),
            ("Data Formatting and Validation", 3),
            ("Configuration and Defaults", 2),
            ("Layout and Container Regions", 3),
            ("Data Regions, Grids and Charts", 4),
            ("Wizards, Rich Inputs and Configurable Pages", 4),
            ("Flexfields, SPEL and Forms Integration", 4),
            ("Client-Side Scripting and Page Modes", 3),
            ("Files, Documents and Data Exchange", 3),
            ("Navigation, Workflow and Background Processing", 4),
            ("Internationalization, Accessibility and Usability", 3),
            ("Advanced Debugging", 4),
            ("Projects and Final Assessment", 4),
        ],
    ),
    "103": (
        "bootcamp/building/103/README.md",
        "B103",
        ASSETS,
        [
            ("MDS and BC4J Deployment", 4),
            ("AOL Security and Page Registration", 3),
            ("Enterprise Instrumentation and Log Management", 4),
            ("R12.2 Online Patching and Packaging", 5),
            ("Project Setup and Planning", 3),
            ("Store Management Module", 3),
            ("Product and Branch Management", 4),
            ("Sales and Transactions Module", 4),
            ("Advanced Features and Polish", 4),
            ("Deployment and Presentation", 4),
            ("Final Assessment", 4),
            ("Advanced Tables, Grids and Visualization", 5),
            ("Advanced Search and Navigation", 4),
            ("State Management, Back Button and Security", 5),
            ("Security Hardening", 4),
            ("REST and Product Integration", 5),
            ("Portal, Analytics and Service Testing", 4),
        ],
    ),
    "C101": (
        "bootcamp/customizing/101/README.md",
        "C101",
        ASSETS,
        [
            ("Upgrade Preservation Principles", 2),
            ("Personalization Hierarchy and Administration", 3),
            ("Declarative Customization of Pages, Regions and LOVs", 3),
            ("Personalization Migration", 3),
            ("Diagnostics, Translation and Assessment", 3),
        ],
    ),
    "C102": (
        "bootcamp/customizing/102/README.md",
        "C102",
        ASSETS,
        [
            ("Controller and LOV Extensions", 4),
            ("Business Component Extensions", 4),
            ("Substitution and Troubleshooting", 5),
            ("Extension Packaging and R12.2 Synchronization", 5),
            ("Extension Architecture and Standards", 3),
            ("Release, Promotion and Assessment", 3),
        ],
    ),
}


def badges(rel, n):
    return STAR.format(rel=rel) * n


def lecture_stars(module_stars, fmt):
    """Video lectures take the module's rating; Lab and Workshop lectures are one star harder (max 5)."""
    return module_stars if fmt == "Video" else min(5, module_stars + 1)


def apply_modules(course):
    """Difficulty column in the section index (after Path), a value on each module line, and a legend."""
    path, pre, rel, table = RATINGS[course]
    full = os.path.join(ROOT, path)
    text = open(full).read()
    if "**Difficulty**" in text:
        return 0  # module ratings already added

    titles = re.findall(r"^## \[\d+\] (.*)$", text, re.M)
    assert titles == [t for t, _ in table], (titles, [t for t, _ in table])

    # 1. section index: header and separator get one more column right after Path
    lines = text.split("\n")
    h = next(i for i, l in enumerate(lines) if l.startswith("| Section | Module | Title | Path |"))
    cells = [c.strip() for c in lines[h].strip().strip("|").split("|")]
    assert cells[3] == "Path", cells
    cells.insert(4, "Difficulty")
    lines[h] = "| " + " | ".join(cells) + " |"
    sep = [c.strip() for c in lines[h + 1].strip().strip("|").split("|")]
    sep.insert(4, ":--")
    lines[h + 1] = "| " + " | ".join(sep) + " |"
    text = "\n".join(lines)

    def index_row(m):
        n = int(m.group(2))
        return f"{m.group(1)}{badges(rel, table[n - 1][1])} | {m.group(3)}"

    text, k = re.subn(
        rf"^(\| \[(\d+)\] \| {pre}-\d{{3}} \| \[.*?\]\(#.*?\) \| \w+ \| )(.*)$",
        index_row, text, flags=re.M,
    )
    assert k == len(table), k

    # 2. module line under each section heading (Difficulty goes right after Path, before Track)
    def module_line(m):
        n = int(m.group(2))
        return f"{m.group(1)} | **Difficulty:** {badges(rel, table[n - 1][1])}{m.group(3) or ''}{m.group(4)}"

    text, k = re.subn(
        rf"^(\*\*Module:\*\* {pre}-(\d{{3}}) \| \*\*Path:\*\* \w+)( \| \*\*Track:\*\* .*?)?(\s*)$",
        module_line, text, flags=re.M,
    )
    assert k == len(table), k

    # 3. legend: a centred row of 1 to 5 stars with the level names under it, after the Path legend
    legend = (
        "\n**Difficulty**\n\n"
        "| " + " | ".join(badges(rel, n) for n in MEANING) + " |\n"
        "| " + " | ".join([":-:"] * len(MEANING)) + " |\n"
        "| " + " | ".join(f"**{v}**" for v in MEANING.values()) + " |\n"
    )
    text, k = re.subn(r"^(\*\*Path:\*\* Core is.*)$", lambda m: m.group(1) + "\n" + legend, text, count=1, flags=re.M)
    assert k == 1

    open(full, "w").write(text)
    return len(table)


def apply_lectures(course):
    """Add a Difficulty column after Format in every lecture table."""
    path, pre, rel, table = RATINGS[course]
    full = os.path.join(ROOT, path)
    text = open(full).read()
    if "| Format | Difficulty |" in text:
        return 0  # lecture ratings already added
    head = "| Code | Lecture | Format | Resource | Notes |"
    sep = "| :-- | :-------- | :-: | :-- | :---- |"
    assert text.count(head) == len(table) and text.count(sep) == len(table), (text.count(head), text.count(sep))
    text = text.replace(head, "| Code | Lecture | Format | Difficulty | Resource | Notes |")
    text = text.replace(sep, "| :-- | :-------- | :-: | :-- | :-- | :---- |")

    def lecture_row(m):
        module = int(m.group(1))
        return f"{m.group(2)}{m.group(3)} | {badges(rel, lecture_stars(table[module - 1][1], m.group(3)))} | "

    text, k = re.subn(
        rf"^(?=\| {pre}-(\d{{3}})\.\d{{3}} \|)(\| {pre}-\d{{3}}\.\d{{3}} \| .*? \| )(Video|Lab|Workshop) \| ",
        lecture_row, text, flags=re.M,
    )
    open(full, "w").write(text)
    return k


if __name__ == "__main__":
    for c in RATINGS:
        print(c, apply_modules(c), "modules rated,", apply_lectures(c), "lectures rated")
