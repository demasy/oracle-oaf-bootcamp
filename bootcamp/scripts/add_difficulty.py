"""Add Difficulty ratings (1 to 5 star icons) to a bootcamp README: per module, then per lecture.

The stars are SVG images (bootcamp/assets/difficulty-star.svg): 1 Beginner, 2 Elementary, 3 Intermediate, 4 Advanced, 5 Expert.

Phase 1 covers Building BootCamp 101 only. Add the other courses to RATINGS later.
Run from anywhere:  python3 bootcamp/scripts/add_difficulty.py
The script is idempotent: it stops if the README already has a Difficulty column.
"""
import os
import re
import sys

ROOT = os.path.join(os.path.dirname(os.path.abspath(__file__)), "..", "..")

# rating (number of stars) -> meaning
MEANING = {1: "Beginner", 2: "Elementary", 3: "Intermediate", 4: "Advanced", 5: "Expert"}
STAR = '<img src="{rel}difficulty-star.svg" width="16" height="16" alt="★" align="absmiddle">'

# course -> (README path, module-ID prefix, relative path to the badge, [(module title, stars), ...])
RATINGS = {
    "101": (
        "bootcamp/building/101/README.md",
        "B101",
        "../../assets/",
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
}


def badges(rel, n):
    return STAR.format(rel=rel) * n


def lecture_stars(module_stars, fmt):
    """Video lectures take the module's rating; Lab and Workshop lectures are one star harder (max 5)."""
    return module_stars if fmt == "Video" else min(5, module_stars + 1)


def apply_modules(course):
    path, pre, rel, table = RATINGS[course]
    full = os.path.join(ROOT, path)
    text = open(full).read()
    if "**Difficulty**" in text:
        return 0  # module ratings already added

    # module titles must match the README exactly
    titles = re.findall(r"^## \[\d+\] (.*)$", text, re.M)
    assert titles == [t for t, _ in table], (titles, [t for t, _ in table])

    # 1. index table: header, separator, and one cell per row
    head = "| Section | Module | Title | Path | Lectures |"
    sep = "| :-: | :-- | :-- | :-: | :-: |"
    assert text.count(head) == 1 and text.count(sep) == 1
    text = text.replace(head, "| Section | Module | Title | Path | Difficulty | Lectures |")
    text = text.replace(sep, "| :-: | :-- | :-- | :-: | :-- | :-: |")

    def index_row(m):
        n = int(m.group(2))
        return f"{m.group(1)}{badges(rel, table[n - 1][1])} | {m.group(3)} |"

    text, k = re.subn(
        rf"^(\| \[(\d+)\] \| {pre}-\d{{3}} \| \[.*?\]\(#.*?\) \| \w+ \| )(\d+) \|$",
        index_row, text, flags=re.M,
    )
    assert k == len(table), k

    # 2. module line under each section heading
    def module_line(m):
        n = int(m.group(2))
        return f"{m.group(1)} | **Difficulty:** {badges(rel, table[n - 1][1])}{m.group(3)}"

    text, k = re.subn(
        rf"^(\*\*Module:\*\* {pre}-(\d{{3}}) \| \*\*Path:\*\* \w+)(  )$",
        module_line, text, flags=re.M,
    )
    assert k == len(table), k

    # 3. legend line under the existing Path line
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
