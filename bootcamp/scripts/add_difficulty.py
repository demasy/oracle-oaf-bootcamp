"""Add a per-module Difficulty rating (badge plus label) to a bootcamp README.

Ratings 1, 2 and 3 map to Awareness (blue check), Standard (orange star) and Master (red diamond).

Phase 1 covers Building BootCamp 101 only. Add the other courses to RATINGS later.
Run from anywhere:  python3 bootcamp/scripts/add_difficulty.py
The script is idempotent: it stops if the README already has a Difficulty column.
"""
import os
import re
import sys

ROOT = os.path.join(os.path.dirname(os.path.abspath(__file__)), "..", "..")

# rating -> (badge file name, label, meaning)
LEVELS = {1: ("awareness", "Awareness", "Introductory"), 2: ("standard", "Standard", "Intermediate"), 3: ("master", "Master", "Advanced")}
BADGE = '<img src="{rel}difficulty-{name}.svg" width="16" height="16" alt="{label}" align="absmiddle"> {label}'

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
    name, label, _ = LEVELS[n]
    return BADGE.format(rel=rel, name=name, label=label)


def apply(course):
    path, pre, rel, table = RATINGS[course]
    full = os.path.join(ROOT, path)
    text = open(full).read()
    if "Difficulty" in text:
        sys.exit(f"{path}: already has a Difficulty column, nothing to do")

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
        "\n**Difficulty** (rated per module)\n\n"
        f"| {badges(rel, 1)} | {badges(rel, 2)} | {badges(rel, 3)} |\n"
        "| :-- | :-- | :-- |\n"
        f"| {LEVELS[1][2]} | {LEVELS[2][2]} | {LEVELS[3][2]} |\n"
    )
    text, k = re.subn(r"^(\*\*Path:\*\* Core is.*)$", lambda m: m.group(1) + "\n" + legend, text, count=1, flags=re.M)
    assert k == 1

    open(full, "w").write(text)
    return len(table)


if __name__ == "__main__":
    for c in RATINGS:
        print(c, apply(c), "modules rated")
