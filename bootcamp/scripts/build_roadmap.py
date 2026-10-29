#!/usr/bin/env python3
"""Draw the OAF roadmap: roadmap/building-1..3.svg, roadmap/customizing-1..2.svg, roadmap/legend.svg and roadmap/README.md.

Run from anywhere:  python3 bootcamp/scripts/build_roadmap.py

Everything comes from the course READMEs (bootcamp/courses/*/*/README.md): a Section becomes a yellow node,
its Lectures become the boxes in a card next to it. A lecture's level comes from the Difficulty stars of its
section: 1-2 stars Foundation, 3 Core, 4 Advanced, 5 Expert.
"""
import os
import re
import textwrap
from html import escape

os.chdir(os.path.join(os.path.dirname(os.path.abspath(__file__)), "..", ".."))

COURSES = [
    # roadmap, step, code, readme-dir, level, prefix
    ("Building", 1, "OAF-B-101", "building/101", "Beginner", "B101"),
    ("Building", 2, "OAF-B-102", "building/102", "Advanced", "B102"),
    ("Building", 3, "OAF-B-103", "building/103", "Ninja", "B103"),
    ("Customizing", 1, "OAF-C-101", "customizing/101", "Beginner", "C101"),
    ("Customizing", 2, "OAF-C-102", "customizing/102", "Advanced", "C102"),
]
LEVELS = ["Foundation", "Core", "Advanced", "Expert"]
LEVEL_COLOR = {"Foundation": "#3B6FE0", "Core": "#7C3AED", "Advanced": "#4E7A1E", "Expert": "#D43A2F"}
FONT = "'Segoe UI', -apple-system, 'Helvetica Neue', Helvetica, Arial, sans-serif"

W = 1100
CARD_W, NODE_W, NODE_X = 380, 200, 450
LEFT_X, RIGHT_X = 20, 700
SPINE = W // 2


def level_of(stars):
    return LEVELS[0] if stars <= 2 else LEVELS[1] if stars == 3 else LEVELS[2] if stars == 4 else LEVELS[3]


def parse(directory, prefix):
    text = open(f"bootcamp/courses/{directory}/README.md", encoding="utf-8").read()
    goals = re.findall(r"^- (.+)$", text[text.index("## Course Goals"):text.index("## ", text.index("## Course Goals") + 5)], re.M)
    sections = []
    for m in re.finditer(r"^## \[(\d+)\] (.*)$", text, re.M):
        end = re.search(r"^## \[", text[m.end():], re.M)
        body = text[m.end(): m.end() + end.start()] if end else text[m.end():]
        stars = body.split("**Difficulty:**")[1].split("\n")[0].count("<img")
        lectures = []
        for r in re.finditer(rf"^\| ({prefix}-\d{{3}}\.\d{{3}}) \| (.*?) \| (Video|Lab|Workshop) \| ((?:<img[^>]*>)+) \|", body, re.M):
            lectures.append({"code": r.group(1), "title": r.group(2), "format": r.group(3), "stars": stars, "level": level_of(stars)})
        sections.append({"n": int(m.group(1)), "code": f"{prefix}-{int(m.group(1)):03d}", "title": m.group(2), "stars": stars, "lectures": lectures})
    return {"goals": goals, "sections": sections}


def focus_of(code):
    for line in open("README.md", encoding="utf-8"):
        if line.startswith(f"| {code} |"):
            return line.rstrip().rstrip("|").split("|")[-1].strip()
    return ""


def t(x, y, s, size=14, weight=400, fill="#111111", anchor="middle", extra=""):
    return f'<text x="{x}" y="{y}" font-size="{size}" font-weight="{weight}" fill="{fill}" text-anchor="{anchor}"{extra}>{escape(str(s))}</text>'


def lines(x, y, s, width, size=14, lh=18, **kw):
    out = []
    for i, ln in enumerate(textwrap.wrap(s, width)):
        out.append(t(x, y + i * lh, ln, size, **kw))
    return "".join(out), len(textwrap.wrap(s, width))


def badge(cx, cy, level):
    col = LEVEL_COLOR[level]
    mark = ('<path d="M%.1f,%.1f L%.1f,%.1f L%.1f,%.1f" fill="none" stroke="#FFFFFF" stroke-width="2.4" stroke-linecap="round" stroke-linejoin="round"/>'
            % (cx - 5.5, cy + 0.5, cx - 1.5, cy + 4.5, cx + 5.5, cy - 3.5)) if level != "Expert" else \
        f'<path d="M{cx} {cy - 6}l6 6-6 6-6-6z" fill="#FFFFFF"/>'
    return f'<circle cx="{cx}" cy="{cy}" r="12" fill="{col}" stroke="#FFFFFF" stroke-width="2"/>' + mark


def item_box(x, y, lec, w):
    body, n = lines(x + w / 2 + 6, y + 21, lec["title"], 41, 14, 17, weight=400)
    h = 16 + n * 17 + 4
    svg = (f'<rect x="{x}" y="{y}" width="{w}" height="{h}" rx="6" fill="#F7E4A8" stroke="#111111" stroke-width="2"/>'
           + badge(x + 2, y + h / 2, lec["level"]) + body)
    return svg, h


def card(x, y, sec, show_from=0, max_items=None):
    inner_x, inner_w = x + 16, CARD_W - 32
    items = sec["lectures"]
    parts, cy = [], y + 38
    title = f'{sec["code"]} · {len(items)} lectures' if max_items is None else f'{sec["code"]}'
    for lec in items:
        s, h = item_box(inner_x + 8, cy, lec, inner_w - 8)
        parts.append(s)
        cy += h + 12
    h_total = cy - y + 4
    box = (f'<rect x="{x}" y="{y}" width="{CARD_W}" height="{h_total}" rx="12" fill="#FFFFFF" stroke="#111111" stroke-width="2"/>'
           + t(x + CARD_W / 2, y + 24, title, 15, 400))
    return box + "".join(parts), h_total


def node(y_center, sec):
    ttl, n = lines(SPINE, 0, sec["title"], 20, 15, 18, weight=400)
    h = max(48, n * 18 + 22)
    top = y_center - h / 2
    ttl, _ = lines(SPINE, top + 24, sec["title"], 20, 15, 18, weight=400)
    return (f'<rect x="{NODE_X}" y="{top}" width="{NODE_W}" height="{h}" rx="6" fill="#FDFD6C" stroke="#111111" stroke-width="2.5"/>' + ttl), h


def connector(side, card_y, card_h, node_cy):
    cy = card_y + card_h / 2
    if side == "L":
        x1, x2 = LEFT_X + CARD_W, NODE_X
    else:
        x1, x2 = RIGHT_X, NODE_X + NODE_W
    mx = (x1 + x2) / 2
    return f'<path d="M{x1} {cy:.1f} C{mx} {cy:.1f} {mx} {node_cy:.1f} {x2} {node_cy:.1f}" fill="none" stroke="#3B6FE0" stroke-width="2.5" stroke-dasharray="1 6" stroke-linecap="round"/>'


def draw_step(roadmap, step, code, level, data, total_steps, next_code):
    secs = data["sections"]
    n_lec = sum(len(s["lectures"]) for s in secs)
    goal = data["goals"][0]
    ready = data["goals"][-1]
    parts = []
    y_left = y_right = 270
    prev_bottom = 250
    node_parts, card_parts, conn_parts = [], [], []
    for i, sec in enumerate(secs):
        side = "L" if i % 2 == 0 else "R"
        cx = LEFT_X if side == "L" else RIGHT_X
        cs, ch = card(cx, 0, sec)
        nd, nh = node(0, sec)
        y_side = y_left if side == "L" else y_right
        top = max(y_side, prev_bottom + 26 + nh / 2 - ch / 2)
        cs, ch = card(cx, top, sec)
        ncy = top + ch / 2
        nd, nh = node(ncy, sec)
        card_parts.append(cs)
        node_parts.append(nd)
        conn_parts.append(connector(side, top, ch, ncy))
        if side == "L":
            y_left = top + ch + 24
        else:
            y_right = top + ch + 24
        prev_bottom = ncy + nh / 2
    bottom = max(y_left, y_right, prev_bottom) + 8
    H = int(bottom + 120)
    spine = f'<line x1="{SPINE}" y1="20" x2="{SPINE}" y2="{bottom + 30:.0f}" stroke="#3B6FE0" stroke-width="5"/>'
    # header
    hx, hw = SPINE - 330, 660
    desc, dn = lines(SPINE, 152, goal, 78, 14, 18)
    rdy, rn = lines(SPINE, 152 + dn * 18 + 8, "Ready for the next step when you can: " + ready[0].lower() + ready[1:], 88, 12.5, 16, fill="#57606a")
    hh = 152 + dn * 18 + 8 + rn * 16 + 12 - 70
    header = (f'<rect x="{hx}" y="70" width="{hw}" height="{hh}" rx="14" fill="#FFFFFF" stroke="#555555" stroke-width="3"/>'
              f'<rect x="{hx + 16}" y="86" width="{hw - 32}" height="40" rx="6" fill="#111111"/>'
              + t(SPINE, 113, f"Oracle OAF {roadmap} BootCamp · {level}", 20, 400, "#FFFFFF") + desc + rdy)
    pill = (f'<rect x="{SPINE - 60}" y="52" width="120" height="30" rx="15" fill="#4A72D8" stroke="#FFFFFF" stroke-width="3"/>'
            + t(SPINE, 73, f"STEP {step} OF {total_steps}", 13, 700, "#FFFFFF", extra=' letter-spacing="1.5"'))
    nxt = ""
    if next_code:
        by = bottom + 36
        nxt = (f'<rect x="{SPINE - 130}" y="{by}" width="260" height="44" rx="22" fill="#111111"/>'
               + t(SPINE, by + 28, f"Next step: {next_code}", 16, 700, "#F3D45A"))
    else:
        by = bottom + 36
        nxt = (f'<rect x="{SPINE - 130}" y="{by}" width="260" height="44" rx="22" fill="#111111"/>'
               + t(SPINE, by + 28, "End of this roadmap", 16, 700, "#F3D45A"))
    alt = f"Oracle OAF {roadmap} roadmap, step {step} of {total_steps}, {code} {level}: {len(secs)} sections and {n_lec} lectures."
    svg = (f'<svg xmlns="http://www.w3.org/2000/svg" width="{W}" height="{H}" viewBox="0 0 {W} {H}" font-family="{FONT}" role="img" aria-label="{escape(alt)}">'
           f'<rect x="0" y="0" width="{W}" height="{H}" fill="#F8F9FC"/>' + spine + "".join(conn_parts) + header + pill
           + "".join(card_parts) + "".join(node_parts) + nxt + "</svg>\n")
    return svg


def draw_legend():
    parts = ['<rect x="2" y="2" width="696" height="60" rx="12" fill="#FFFFFF" stroke="#111111" stroke-width="2"/>']
    x = 34
    for lv in LEVELS:
        parts.append(badge(x, 32, lv))
        parts.append(t(x + 24, 38, lv, 16, 400, anchor="start"))
        x += 170
    return (f'<svg xmlns="http://www.w3.org/2000/svg" width="700" height="64" viewBox="0 0 700 64" font-family="{FONT}" role="img" '
            f'aria-label="Legend: Foundation, Core, Advanced, Expert">' + "".join(parts) + "</svg>\n")


def stars(n):
    return "★" * n


def main():
    os.makedirs("roadmap", exist_ok=True)
    data = {c[2]: parse(c[3], c[5]) for c in COURSES}
    open("roadmap/legend.svg", "w", encoding="utf-8").write(draw_legend())
    totals = {}
    for road in ("Building", "Customizing"):
        steps = [c for c in COURSES if c[0] == road]
        for i, (r, step, code, d, level, pre) in enumerate(steps):
            nxt = steps[i + 1][2] if i + 1 < len(steps) else None
            svg = draw_step(r, step, code, level, data[code], len(steps), nxt)
            open(f"roadmap/{r.lower()}-{step}.svg", "w", encoding="utf-8").write(svg)
    md = ["# Oracle Application Framework (OAF) Roadmap", "",
          "A learning roadmap for Oracle E-Business Suite OAF developers. It has two roadmaps, **Building** and **Customizing**. Each roadmap is a short path of steps, and every step is one course of the [Oracle OAF BootCamp](../README.md). Each step lists the sections and lectures of its course, and every lecture has a level.", "",
          "Every picture is drawn by [build_roadmap.py](../bootcamp/scripts/build_roadmap.py) from the course READMEs, so the roadmap always matches the courses. See the [capability index](../bootcamp/capabilities/CAPABILITIES.md) for the topics by area.", "",
          "<br>", "", "## Contents", "",
          "- [How to read the roadmap](#how-to-read-the-roadmap)",
          "- [Building roadmap](#building-roadmap)"]
    for c in COURSES:
        if c[0] == "Building":
            md.append(f"  - [Step {c[1]}: {c[4]} ({c[2]})](#building-step-{c[1]}-{c[4].lower()}-{c[2].lower()})")
    md.append("- [Customizing roadmap](#customizing-roadmap)")
    for c in COURSES:
        if c[0] == "Customizing":
            md.append(f"  - [Step {c[1]}: {c[4]} ({c[2]})](#customizing-step-{c[1]}-{c[4].lower()}-{c[2].lower()})")
    md += ["", "<br>", "", "## How to read the roadmap", "",
           "Each picture has a blue line down the middle. A yellow box on the line is a **section** of the course. The white card next to it lists the **lectures** of that section, in course order. Each lecture shows its name and a level badge. The level comes from the Difficulty rating of the lecture's section: 1 to 2 stars is Foundation, 3 is Core, 4 is Advanced and 5 is Expert.", "",
           '<img src="legend.svg" width="700" alt="Legend: Foundation, Core, Advanced, Expert">', "",
           "Every picture has a text version under **Topics as text**, which also shows each lecture's format (Video, Lab or Workshop).", "", "<br>", ""]
    for road, blurb, path in (
            ("Building", "Build OAF pages, business components and applications, from the first page to production.", "levels-building.svg"),
            ("Customizing", "Personalize and extend delivered Oracle E-Business Suite pages without breaking upgrades. Customizing 101 follows Building 101, and Customizing 102 follows Building 102.", "levels-customizing.svg")):
        steps = [c for c in COURSES if c[0] == road]
        md += [f"## {road} Roadmap", "", f"**Path:** " + " → ".join(c[4] for c in steps), "", blurb, "",
               f'<img src="../bootcamp/assets/{path}" width="520" alt="{road} path: ' + ", ".join(f"{c[2]} {c[4]}" for c in steps) + '">', "",
               "| Step | Course | Level | Sections | Lectures | Focus |", "| --: | :-- | :-: | :-: | :-: | :-- |"]
        for r, step, code, d, level, pre in steps:
            secs = data[code]["sections"]
            md.append(f"| {step} | [{code}](#{road.lower()}-step-{step}-{level.lower()}-{code.lower()}) | {level} | {len(secs)} | {sum(len(s['lectures']) for s in secs)} | {focus_of(code)} |")
        md += ["", "<br>", ""]
        for r, step, code, d, level, pre in steps:
            dd = data[code]
            n_lec = sum(len(s["lectures"]) for s in dd["sections"])
            md += [f"### {road} Step {step}: {level} ({code})", "",
                   f"Step {step} of {len(steps)} · [{code} course](../bootcamp/courses/{d}/README.md) · {len(dd['sections'])} sections · {n_lec} lectures", "",
                   f"![{road} step {step}: {level}]({road.lower()}-{step}.svg)", "",
                   "<details>", "<summary>Topics as text</summary>", ""]
            for s in dd["sections"]:
                md.append(f"- **{s['code']} {s['title']}** (Difficulty {stars(s['stars'])})")
                for lec in s["lectures"]:
                    md.append(f"  - {lec['title']} ({lec['format']}, {lec['level']})")
            md += ["", "</details>", "", "<br>", ""]
    open("roadmap/README.md", "w", encoding="utf-8").write("\n".join(md))
    for code, dd in data.items():
        n = sum(len(s["lectures"]) for s in dd["sections"])
        split = {lv: sum(1 for s in dd["sections"] for l in s["lectures"] if l["level"] == lv) for lv in LEVELS}
        print(code, len(dd["sections"]), "sections", n, "lectures", split)


if __name__ == "__main__":
    main()
