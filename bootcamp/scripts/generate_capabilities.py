import os
os.chdir(os.path.join(os.path.dirname(os.path.abspath(__file__)),"..",".."))
import re,collections,csv,html
LV={"B101":"Dev 101","B102":"Dev 102","B103":"Dev 103","C101":"Cust 101","C102":"Cust 102"}
rows=[]
for f,pre in (("building/101","B101"),("building/102","B102"),("building/103","B103"),("customizing/101","C101"),("customizing/102","C102")):
    for m in re.finditer(rf"^\| ({pre}-\d{{3}}\.\d{{3}}) \| (.*?) \| (?:Video|Lab|Workshop) \| .*? \| (.*) \|$",open(f'bootcamp/courses/{f}/README.md').read(),re.M): rows.append((m.group(1),m.group(2),m.group(3)))
def hit(k,text):
    return bool(re.search(k[2:],text)) if k.startswith("r:") else k in text
CAP={"Architecture":[("MVC pattern",["r:\\bmvc\\b","model, view"]),("BC4J (business components)",["bc4j"]),("UIX and MDS metadata",["r:\\buix\\b","r:\\bmds\\b"]),("JDeveloper and OA Extension",["jdeveloper"]),("State and connection management (AM pooling, retention, passivation)",["pooling","retention","passivation"]),("Enterprise performance (resource swapping and caching)",["swapping","caching"]),("OAF terminology and page anatomy",["oaf terminology","page anatomy"]),("OAF in context (when to use, EBS integration)",["when and why to use oaf","with e-business suite"]),("Layered application architecture",["layered application architecture"]),("System catalog views",["system catalog views"]),("Database layer (_B and _TL tables)",["database layer"]),("Object-oriented reuse",["shared validation rules","reuse across"])],
"Model Layer":[("Entity objects",["entity object"]),("View objects, bind variables and criteria",["bind variables"]),("View links",["view link"]),("Application modules and OADBTransaction",["oadbtransaction","application module"]),("PL/SQL entity objects",["pl/sql entity"]),("Polymorphic entity objects",["polymorphic"]),("Validation view objects",["validation view object"]),("Multi-Org (operating unit) context",["multi-org"]),("View object query performance",["tuning view object"]),("Programmatic view objects",["programmatic view objects","dynamic view objects","attributes to view objects"]),("Entity expert validation",["entity expert"]),("Updatable and read-only view objects",["updatable view objects","read-only view objects"]),("Attribute validation and primary keys",["attribute validation","data validations"]),("SQL and PL/SQL calls from OAF",["executing sql","pl/sql functions"]),("Master-detail pages",["master-detail"]),("Entity associations",["entity associations"]),("Cross-attribute validation",["cross-attribute"])],
"View":[("Pages and regions",["pages and regions"]),("messageComponentLayout",["messagecomponentlayout"]),("Stack, flow, table, row and cell layouts",["flow layout","tablelayout","cellformat"]),("Advanced tables",["advanced table"]),("HGrid and tree",["hgrid"]),("Train and wizards",["r:\\btrains?\\b"]),("Shuttle",["shuttle"]),("Sub tabs and navigation components",["subtab","hide/show","navigation components"]),("Panel splitter and layered layout",["splitter"]),("Auto-repeating layout",["auto-repeating"]),("Bulleted list",["bulleted"]),("Flexible layout and configurable pages",["flexible"]),("Masonry layout",["masonry"]),("Infotiles",["infotile"]),("Charts and graphs",["chart"]),("Gantt charts",["gantt"]),("Accordions",["accordion"]),("LOV auto-completion, dependent LOV and look-ahead",["look-ahead","dependent","lov action"]),("Smart poplists (LOV choice)",["lov choice","poplists"]),("Lookup codes and value sets",["lookup codes","value sets"]),("Date picker and calendar fields",["date picker"]),("Switcher",["switcher"]),("Rich text, color picker and rating bar",["rich text"]),("Flexfields (DFF and KFF)",["flexfield"]),("Attribute sets and CSS",["attribute sets"]),("Look-and-feel standards",["look-and-feel"]),("Shared regions and pages",["shared regions"]),("Images, spacers and separators",["spacers"]),("Form parameters and includes",["form parameters","servletinclude"]),("Buttons and button bars",["button bars"]),("Breadcrumbs and menus",["breadcrumbs"]),("Query region, list search and saved search",["list search","query region"]),("Quick search",["quick search"]),("Standard web widgets",["standard web widgets"]),("Dynamic item properties (SPEL)",["r:\\bspel\\b"]),("Advanced layout and content container regions",["advanced layout region","content container"]),("Layered layout modes (redirect and form submission)",["redirect mode"]),("CRUD pages (query, create, update, delete)",["store query page","store create page","store update page","store delete page","drill-down page"]),("Rich table features (resize, reorder, freeze, detach)",["rich table interactions"]),("Table columns, totals and row selection",["column groups","total rows","singleselection","row selection"]),("Section headers, hide/show regions and footers",["hide/show region","content footers","page footer"]),("Form inputs and selection controls (radio, checkbox, spin box)",["radio groups","checkboxes","spin boxes"]),("Text and display items",["static text","rawtext"]),("Popups",["popups"]),("Attachment mapping",["entitymap","categorymap"])],
"Controller Layer":[("processRequest (GET)",["get requests","processrequest"]),("processFormRequest (POST)",["processformrequest","form submissions"]),("Partial page rendering (PPR)",["partial page rendering","r:\\bppr\\b"]),("Page context and web bean API",["pagecontext"]),("Parameter passing",["parameter"]),("Programmatic beans",["web beans programmatically","items programmatically","regions programmatically","pages programmatically","button programmatically"]),("Dialog pages",["dialog pages"]),("Dynamic focus and bean properties",["focus"]),("Table row actions",["table rows","batch actions","rows programmatically"]),("JavaScript",["javascript"]),("Back button",["back button"]),("Deep links",["deep link"]),("Declarative page flows",["declarative page flows"]),("Session parameters and user state",["session parameters"]),("Read-only pages and page modes",["read-only page"]),("Common controller patterns",["common controller patterns"]),("processFormData",["processformdata"]),("Controller classes (OAControllerImpl)",["oacontrollerimpl"])],
"Integration":[("Attachments",["attachments"]),("File upload and download",["upload","downloading files"]),("Import and export data",["import data","export data"]),("Export to Excel and PDF",["excel","exporting table"]),("Workflow and notifications",["workflow","notification"]),("Oracle Forms interoperability",["oracle forms"]),("REST and web services",["rest servlet","web services"]),("Portal and portlets",["portlet"]),("Concurrent requests",["concurrent"]),("OBIEE analytics",["obiee"]),("XML Publisher and BI Publisher output",["bi publisher"]),("Web ADI integration",["web adi"]),("Programmatic concurrent request submission",["concurrentrequest api"]),("Embedded JET and third-party content",["third-party web"]),("Business events",["business event"]),("BSO tester",["r:\\bbso\\b"]),("External SOAP and REST services",["external soap"])],
"Security":[("Function security",["function security"]),("Data security",["data security"]),("Authentication and authorization",["authentication"]),("XSS scanning",["r:\\bxss\\b"]),("AntiSamy filtering",["antisamy"]),("Virus scanning",["virus"]),("Frame busting",["frame busting"]),("Built-in protection against HTML tampering",["tampering"]),("Page access tracking",["page access tracking"])],
"Errors and diagnostics":[("OAException and severities",["severit","oaexception"]),("Bundled exceptions",["bundle"]),("Debugger and logging",["debugger","logging"]),("About This Page",["about this page"]),("OAInfo.jsp",["oainfo"]),("FND_LOG and writeDiagnostics",["fnd_log","writediagnostics"]),("SQL trace (event 10046)",["10046"]),("Log purge (FNDLGPRG)",["fndlgprg"]),("Advanced debugging techniques",["advanced debugging techniques","demasy-oaf"])],
"Personalization":[("Customization concepts",["extension and modification"]),("Personalization levels",["personalization levels"]),("Personalization precedence (user level highest)",["highest precedence"]),("Durable personalizations",["preserving personalizations","durable personalization"]),("Region injection",["injecting regions"]),("LOV personalization",["personalizing lovs"]),("XMLExporter and XMLImporter",["xmlexporter","xmlimporter"]),("Translated personalizations",["translated personalizations"]),("End-user and declarative page personalization",["end-user personalizations","declarative page personalizations","implementing personalizations"]),("MDS content inspection",["inspecting mds content"])],
"Extension":[("Controller extension",["extending controllers"]),("View object extension",["extending view objects"]),("Entity object extension",["extending entity objects"]),("Application module extension",["extending application modules"]),("Substitution and JPX",["substitution","jpx"]),("LOV extension",["extending lovs"]),("Extension touchpoints and Oracle page extensions",["extension touchpoints","extensions for oracle pages"])],
"Deployment":[("Deployment to EBS",["deployment"]),("adop and R12.2 patching",["r:\\badop\\b"]),("adcgnjar and customall.jar",["adcgnjar"]),("AOL functions, menus and responsibilities",["form function","responsibilit"]),("Scripted deployment",["scripted","repeatable"]),("Environment promotion",["promoting customizations","promotion"])],
"Framework":[("Accessibility",["accessib"]),("Accelerator (hot) keys",["hot key"]),("Screen reader support",["screen reader"]),("Enhanced save model",["save model"]),("Profile options",["profile options"]),("Default values",["default values"]),("Context-sensitive help",["context-sensitive help"])],
"Localization":[("Multi-language support",["multiple languages","multi-language"]),("Right-to-left layouts",["right-to-left"]),("Timezones",["timezone"]),("Date formats",["formatting dates"]),("Number and currency formats",["formatting numbers"])],
"OA Framework Standards":[("Why development standards matter",["development standards"]),("Coding standards and naming conventions",["coding standards"]),("Oracle, project and industry standards",["industry standards"]),("File types and package naming",["files and packages"]),("Directory structure ($JAVA_TOP)",["directory structure"]),("Workspace and project organization",["workspace"]),("Code management and version control",["import and export utilities","version control"]),("Common page patterns",["page patterns"]),("Extension standards",["extension standards"]),("Custom code placement",["placing custom code"]),("Server-side best practices",["server-side best practices"]),("Unit and automated testing",["unit testing"]),("Code quality and standards compliance",["code quality"]),("Project documentation and delivery",["writing documentation","deploying to production","presenting the project"]),("Mentoring and code review",["code review"])]}
codes={r[0] for r in rows}
PREFER={"Popups":["navigation components"],"AntiSamy filtering":["hardening input","cross-site"],"Sub tabs and navigation components":["sub tab","navigation components"],"Page access tracking":["page access","tracking"]}
GROUPS={"View Layer: Layout Containers":['Pages and regions', 'messageComponentLayout', 'Stack, flow, table, row and cell layouts', 'Panel splitter and layered layout', 'Layered layout modes (redirect and form submission)', 'Auto-repeating layout', 'Bulleted list', 'Flexible layout and configurable pages', 'Masonry layout', 'Advanced layout and content container regions', 'Section headers, hide/show regions and footers'],
"View Layer: Navigation and Page Structure":['Sub tabs and navigation components', 'Train and wizards', 'Shuttle', 'Accordions', 'Popups', 'Breadcrumbs and menus', 'Look-and-feel standards', 'Attribute sets and CSS', 'Shared regions and pages', 'Switcher'],
"View Layer: Tables, Search and Visualization":["Advanced tables","Table columns, totals and row selection","Rich table features (resize, reorder, freeze, detach)","HGrid and tree","Infotiles","Charts and graphs","Gantt charts","Query region, list search and saved search","Quick search","CRUD pages (query, create, update, delete)"],
"View Layer: Widgets, Items and Forms":["Standard web widgets","Form inputs and selection controls (radio, checkbox, spin box)","Text and display items","Images, spacers and separators","Buttons and button bars","Form parameters and includes","LOV auto-completion, dependent LOV and look-ahead","Smart poplists (LOV choice)","Lookup codes and value sets","Date picker and calendar fields","Rich text, color picker and rating bar","Flexfields (DFF and KFF)","Dynamic item properties (SPEL)","Attachment mapping"]}
view=dict((n,(n,k)) for n,k in CAP.pop("View"))
assert sorted(view)==sorted(x for g in GROUPS.values() for x in g),(set(view)^set(x for g in GROUPS.values() for x in g))
NEW={}
for a,its in CAP.items():
    NEW[a]=its
    if a=="Model Layer":
        for g,names in GROUPS.items(): NEW[g]=[view[n] for n in names]
CAP=NEW
SPLITS={"Architecture":{"Concepts and Layers":["MVC pattern","UIX and MDS metadata","OAF terminology and page anatomy","OAF in context (when to use, EBS integration)","Layered application architecture","Object-oriented reuse"],"Runtime and Data Foundations":["BC4J (business components)","JDeveloper and OA Extension","State and connection management (AM pooling, retention, passivation)","Enterprise performance (resource swapping and caching)","Database layer (_B and _TL tables)","System catalog views"]},
"Model Layer":{"Business Components":["Entity objects","View objects, bind variables and criteria","Updatable and read-only view objects","View links","Application modules and OADBTransaction","Master-detail pages","Entity associations","Polymorphic entity objects","Multi-Org (operating unit) context","View object query performance"],"Validation and Server-Side Logic":["Validation view objects","Entity expert validation","Attribute validation and primary keys","Cross-attribute validation","SQL and PL/SQL calls from OAF","PL/SQL entity objects","Programmatic view objects"]},
"Controller Layer":{"Request Processing":["processRequest (GET)","processFormRequest (POST)","Partial page rendering (PPR)","Page context and web bean API","Common controller patterns","processFormData","Controller classes (OAControllerImpl)"],"State and Navigation":["Parameter passing","Session parameters and user state","Dialog pages","Back button","Deep links","Declarative page flows"],"Dynamic and Programmatic UI":["Programmatic beans","Dynamic focus and bean properties","Table row actions","JavaScript","Read-only pages and page modes"]},
"Integration":{"Files and Data Exchange":["Attachments","File upload and download","Import and export data","Export to Excel and PDF","XML Publisher and BI Publisher output","Web ADI integration"],"Services and APIs":["REST and web services","BSO tester","External SOAP and REST services","Embedded JET and third-party content"],"EBS Products and Processes":["Workflow and notifications","Business events","Oracle Forms interoperability","Portal and portlets","Concurrent requests","Programmatic concurrent request submission","OBIEE analytics"]},
"OA Framework Standards":{"Coding and Naming Standards":["Why development standards matter","Coding standards and naming conventions","Oracle, project and industry standards","File types and package naming","Directory structure ($JAVA_TOP)","Common page patterns"],"Project and Code Management":["Workspace and project organization","Code management and version control","Project documentation and delivery","Mentoring and code review"],"Quality and Extension Practice":["Extension standards","Custom code placement","Server-side best practices","Unit and automated testing","Code quality and standards compliance"]}}
PARENTS=["View Layer"]+list(SPLITS)
NEW={}
for a,its in CAP.items():
    if a in SPLITS:
        byname=dict((n,(n,k)) for n,k in its); flat=[x for g in SPLITS[a].values() for x in g]
        assert sorted(byname)==sorted(flat) and len(flat)==len(set(flat)),(a,set(byname)^set(flat))
        for g,names in SPLITS[a].items(): NEW[f"{a}: {g}"]=[byname[n] for n in names]
    else: NEW[a]=its
CAP=NEW
ORDER=["Architecture","Model Layer","View Layer","Controller Layer","Framework","Localization","Integration","Security","Errors and diagnostics","Personalization","Extension","Deployment","OA Framework Standards"]
def _parent(area):
    h=area.split(": ",1)[0]
    return h if h in PARENTS else area
assert sorted({_parent(a) for a in CAP})==sorted(ORDER),(set(_parent(a) for a in CAP)^set(ORDER))
CAP=dict(sorted(CAP.items(),key=lambda kv:ORDER.index(_parent(kv[0]))))
def split_area(area):
    if ": " in area:
        h,t=area.split(": ",1)
        if h in PARENTS: return h,t
    return None,area
COMP={"Pages and regions":["page","pageLayout","attributeSet","package"],"messageComponentLayout":["messageComponentLayout","messageLayout","labeledFieldLayout","defaultSingleColumn","defaultDoubleColumn"],"Stack, flow, table, row and cell layouts":["stackLayout","flowLayout","rowLayout","tableLayout","cellFormat"],"Panel splitter and layered layout":["panelSplitter","layeredLayout"],"Bulleted list":["bulletedList"],"Flexible layout and configurable pages":["flexibleLayout","flexibleContent","flexibleContentList"],"Advanced layout and content container regions":["contentContainer","richContainer"],"Section headers, hide/show regions and footers":["header","hideShowHeader","footer","contentFooter"],"Sub tabs and navigation components":["subTabLayout","subTabBar","hideShowSubTabLayout"],"Train and wizards":["train"],"Shuttle":["shuttle"],"Popups":["popUp"],"Breadcrumbs and menus":["menu","menuItem","breadcrumbs","locator","navigationBar"],"Buttons and button bars":["button","submitButton","resetButton","selectionButton","exportButton","link","pageButtonBar"],
"Advanced tables":["table","advancedTable"],"Table columns, totals and row selection":["columnGroup","sortableHeader","totalRow","addTableRow","singleSelection","multipleSelection"],"HGrid and tree":["HGrid","tree","nodeDef","childNode"],"Infotiles":["infotile"],"Charts and graphs":["graphTable","graph","graphData"],"Gantt charts":["Gantt"],
"Form inputs and selection controls (radio, checkbox, spin box)":["messageTextInput","messageChoice","messageLovChoice","messageRadioButton","messageRadioGroup","messageCheckBox","messageSpinBox"],"Text and display items":["styledText","formattedText","instructionText","messageStyledText","staticStyledText","rawText"],"Images, spacers and separators":["image","spacer","separator","tip"],"Form parameters and includes":["formParameter","formValue","servletInclude","urlInclude"],"LOV auto-completion, dependent LOV and look-ahead":["listOfValues","messageLovInput","lovMap","lovActionButton","lovActionMap"],"Rich text, color picker and rating bar":["richTextEditor","colorPicker","messageRatingBar"],"Flexfields (DFF and KFF)":["flex","flexMap"],"Attachment mapping":["attachmentTable","attachmentLink","attachmentImage","messageInlineAttachment","entityMap","categoryMap","primaryKey"],"File upload and download":["messageFileUpload","messageDownload"],"Dialog pages":["dialogPage"]}
allcap={n for its in CAP.values() for n,_ in its}
assert all(k in allcap for k in COMP),[k for k in COMP if k not in allcap]
out=["# Oracle OAF BootCamp Capabilities","","Every OAF capability covered by the five courses, with its Level, the courses that teach it and up to five lectures (lectures that name the capability come first).","","**Courses:** [Dev 101](../courses/building/101/README.md), [Dev 102](../courses/building/102/README.md), [Dev 103](../courses/building/103/README.md), [Cust 101](../courses/customizing/101/README.md), [Cust 102](../courses/customizing/102/README.md).","","**Level** shows how advanced a capability is, taken from the lowest course that teaches it.","","| <img src=\"../assets/level-foundation.svg\" width=\"20\" height=\"20\" alt=\"Foundation\" align=\"absmiddle\"> **Foundation** | <img src=\"../assets/level-core.svg\" width=\"20\" height=\"20\" alt=\"Core\" align=\"absmiddle\"> **Core** | <img src=\"../assets/level-advanced.svg\" width=\"20\" height=\"20\" alt=\"Advanced\" align=\"absmiddle\"> **Advanced** | <img src=\"../assets/level-expert.svg\" width=\"20\" height=\"20\" alt=\"Expert\" align=\"absmiddle\"> **Expert** |","| :-: | :-: | :-: | :-: |","","**Courses** lists every course that teaches the capability.",""]
# Level: Foundation (Dev 101), Core (Dev 102, Cust 101), Advanced (Dev 103, Cust 102), Expert (Advanced, only in 5-star modules)
LEVELS=["Foundation","Core","Advanced","Expert"]
RANK={"B101":0,"B102":1,"C101":1,"B103":2,"C102":2}
EXPERT_MODULES={"B103-004","B103-012","B103-014","B103-016","C102-003","C102-004"}
# capabilities whose lectures sit late only because earlier lectures do not name them
OVERRIDES={"CRUD pages (query, create, update, delete)":"Foundation"}
def level_of(name,lectures):
    if name in OVERRIDES: return OVERRIDES[name]
    base=min(RANK[c[:4]] for c in lectures)
    if base==2 and all(c[:8] in EXPERT_MODULES for c in lectures if RANK[c[:4]]==2): return "Expert"
    return LEVELS[base]
LEVEL_COUNT=collections.Counter()
body=[];total=0;checks=[];summ=[]
csv_rows=[]
seen_parents=set()
for area,items in CAP.items():
    par,sub=split_area(area)
    if par:
        if par not in seen_parents:
            body+=[f"## {par}",""]; seen_parents.add(par)
        body+=[f"### {sub}","","| Capability | Level | Courses | Lectures |","| :-- | :-: | :-- | :-- |"]
    else:
        body+=[f"## {area}","","| Capability | Level | Courses | Lectures |","| :-- | :-: | :-- | :-- |"]
    for name,kws in items:
        nh=sorted([c for c,n,no in rows if any(hit(k,n.lower()) for k in kws)],key=lambda c:(-int(any(p in [r for r in rows if r[0]==c][0][1].lower() for p in PREFER.get(name,[]))),-sum(hit(k,[r for r in rows if r[0]==c][0][1].lower()) for k in kws)))
        ot=sorted([c for c,n,no in rows if c not in nh and any(hit(k,(n+" "+no).lower()) for k in kws)],key=lambda c:-int(any(p in ([r for r in rows if r[0]==c][0][1]+" "+[r for r in rows if r[0]==c][0][2]).lower() for p in PREFER.get(name,[]))))
        allh=nh+ot; assert allh,name
        top=allh[:5]; lv=[LV[p] for p in LV if any(c.startswith(p) for c in allh)]
        level=level_of(name,allh); LEVEL_COUNT[level]+=1
        icon=f'<img src="../assets/level-{level.lower()}.svg" width="20" height="20" alt="{level}" title="{level}" align="absmiddle">'
        csv_rows.append([f"CAP-{total+1:03d}",par or area,sub if par else '',name,level,len(lv),*[int(any(c.startswith(p) for c in allh)) for p in LV],len(allh),'; '.join(lv),'; '.join(sorted(allh))])
        body.append(f"| {name} | {icon} | {', '.join(lv)} | {', '.join(top)} |"); total+=1; checks.append((name,kws,top))
    summ.append((area,len(items))); body.append("")
def _anchor(h):
    return "#"+re.sub(r"[^\w\- ]","",h.lower()).replace(" ","-")
def _summ_rows():
    rows_=[];done=set()
    for a,n in summ:
        par,sub=split_area(a)
        if par:
            if par not in done:
                rows_.append(f"| **[{par}]({_anchor(par)})** | **{sum(x for b,x in summ if split_area(b)[0]==par)}** |"); done.add(par)
            rows_.append(f"| ↳ [{sub}]({_anchor(sub)}) | {n} |")
        else: rows_.append(f"| [{a}]({_anchor(a)}) | {n} |")
    return rows_
GROUPNAME={"Layout containers":["Pages and regions","messageComponentLayout","Stack, flow, table, row and cell layouts","Panel splitter and layered layout","Flexible layout and configurable pages","Advanced layout and content container regions","Section headers, hide/show regions and footers"],
"Data presentation":["Bulleted list","Advanced tables","Table columns, totals and row selection","HGrid and tree","Infotiles"],
"Navigation and page flow":["Sub tabs and navigation components","Train and wizards","Breadcrumbs and menus"],
"Input and item controls":["Form inputs and selection controls (radio, checkbox, spin box)","Text and display items","Images, spacers and separators","Buttons and button bars","Form parameters and includes","LOV auto-completion, dependent LOV and look-ahead","Rich text, color picker and rating bar","Flexfields (DFF and KFF)","Shuttle","Popups","Dialog pages"],
"Attachment and file controls":["Attachment mapping","File upload and download"],
"Analytics and charts":["Charts and graphs","Gantt charts"]}
_g_of={n:g for g,ns in GROUPNAME.items() for n in ns}
assert sorted(_g_of)==sorted(COMP) and sum(len(v) for v in GROUPNAME.values())==len(COMP),(set(_g_of)^set(COMP))
_ci=[(n,_g_of[n]) for its in CAP.values() for n,_ in its if n in COMP]
_ci.sort(key=lambda x:list(GROUPNAME).index(x[1]))
_ci_rows=[]; _last=None
for _i,(n,g) in enumerate(_ci,1):
    _nums='<br>'.join(f"C{_i:02d}.{_j:03d}" for _j in range(1,len(COMP[n])+1))
    _ci_rows.append(f"| C{_i:02d} | {g if g!=_last else ''} | {n} | {_nums} | {'<br>'.join(COMP[n])} |"); _last=g
assert len(_ci_rows)==len(COMP)
# Statistics: two SVG charts (stacked bars per area by level, bars per course) built from csv_rows
LEVEL_COLOR={"Foundation":"#8E96A3","Core":"#CDA94A","Advanced":"#D4763A","Expert":"#C0353A"}
STAT_W=560
def _t(x,y,t,size=14,weight=400,fill="#24292f",anchor="start"):
    return f'<text x="{x}" y="{y}" font-size="{size}" font-weight="{weight}" fill="{fill}" text-anchor="{anchor}">{html.escape(str(t))}</text>'
def _svg(h,parts):
    return (f'<svg xmlns="http://www.w3.org/2000/svg" width="{STAT_W}" height="{h}" viewBox="0 0 {STAT_W} {h}" font-family="-apple-system,\'Segoe UI\',Helvetica,Arial,sans-serif">'
            f'<rect x="1" y="1" width="{STAT_W-2}" height="{h-2}" rx="12" fill="#ffffff" stroke="#d0d7de"/>'+"".join(parts)+'</svg>\n')
_by_area={}
for _r in csv_rows: _by_area.setdefault(_r[1],collections.Counter())[_r[4]]+=1
_areas=sorted(_by_area.items(),key=lambda kv:-sum(kv[1].values()))
_n_sub=len({(_r[1],_r[2]) for _r in csv_rows if _r[2]})
_parts=[_t(24,46,"Capabilities per area",22,700)]
for _x,_n,_l in ((24,len(_areas),"areas"),(110,_n_sub,"sub-areas"),(220,total,"capabilities")):
    _parts+=[_t(_x,100,_n,36,700),_t(_x,124,_l,14,400,"#57606a")]
_lx=24
for _lvl,_w in zip(LEVELS,(105,70,95,75)):
    _parts+=[f'<rect x="{_lx}" y="140" width="14" height="14" rx="2" fill="{LEVEL_COLOR[_lvl]}"/>',_t(_lx+20,152,_lvl,14,400,"#57606a")]; _lx+=_w+20
_x0=190; _scale=(STAT_W-24-_x0-50)/max(sum(c.values()) for _,c in _areas)
for _i,(_a,_c) in enumerate(_areas):
    _y=180+_i*34; _x=_x0
    _parts.append(_t(178,_y+17,_a,14,600,"#24292f","end"))
    for _lvl in LEVELS:
        _w=_c[_lvl]*_scale
        if _w: _parts.append(f'<rect x="{_x:.1f}" y="{_y}" width="{_w:.1f}" height="24" fill="{LEVEL_COLOR[_lvl]}"><title>{html.escape(_a)}: {_c[_lvl]} {_lvl}</title></rect>'); _x+=_w
    _parts.append(_t(_x+8,_y+17,sum(_c.values()),14,400,"#57606a"))
open('bootcamp/assets/stats-areas.svg','w',encoding='utf-8').write(_svg(180+len(_areas)*34+16,_parts))
_cn=[(LV[_p],sum(_r[6+_k] for _r in csv_rows)) for _k,_p in enumerate(LV)]
_parts=[_t(24,46,"Capabilities by course",22,700)]; _cs=(STAT_W-24-112-130)/max(n for _,n in _cn)
for _i,(_nm,_n) in enumerate(_cn):
    _y=76+_i*40
    _parts+=[_t(100,_y+18,_nm,14,600,"#24292f","end"),f'<rect x="112" y="{_y}" width="{_n*_cs:.1f}" height="26" fill="#2F66D6"/>',_t(112+_n*_cs+8,_y+18,f"{_n} ({round(100*_n/total)}%)",14,400,"#57606a")]
open('bootcamp/assets/stats-courses.svg','w',encoding='utf-8').write(_svg(76+len(_cn)*40+12,_parts))
_alt1=html.escape(f"Capabilities per area by level: {len(_areas)} areas, {_n_sub} sub-areas, {total} capabilities. "+"; ".join(f"{a} {sum(c.values())}" for a,c in _areas),quote=True)
_alt2=html.escape("Capabilities by course: "+"; ".join(f"{n} {k}" for n,k in _cn),quote=True)
STATS_MD=[f'<img src="../assets/stats-areas.svg" width="{STAT_W}" alt="{_alt1}">',"",f'<img src="../assets/stats-courses.svg" width="{STAT_W}" alt="{_alt2}">']
# Building 101 only: capability statistics for the course README (two SVG charts)
def _course_stats(code,readme,tag):
    caps=[r for r in csv_rows if any(c.startswith(code) for c in r[13].split("; "))]
    text=open(readme,encoding="utf-8").read()
    titles=dict(re.findall(r"^## \[(\d+)\] (.*)$",text,re.M))
    n_lect=re.findall(rf"^\| {code}-\d{{3}}\.\d{{3}} \|",text,re.M)
    mods=collections.Counter()
    for r in caps:
        for c in r[13].split("; "):
            if c.startswith(code): mods[int(c[5:8])]+=1
    areas=collections.Counter(r[1] for r in caps)
    a=sorted(areas.items(),key=lambda kv:-kv[1])
    parts=[_t(24,46,"Capabilities per area",22,700)]
    for x,n,l in ((24,len(caps),"capabilities"),(160,len(a),"areas"),(250,len(mods),"modules"),(360,len(n_lect),"lectures")):
        parts+=[_t(x,100,n,36,700),_t(x,124,l,14,400,"#57606a")]
    scale=(STAT_W-24-190-50)/a[0][1]
    for i,(nm,n) in enumerate(a):
        y=150+i*34
        parts+=[_t(178,y+17,nm,14,600,"#24292f","end"),f'<rect x="190" y="{y}" width="{n*scale:.1f}" height="24" fill="#2F66D6"/>',_t(190+n*scale+8,y+17,n,14,400,"#57606a")]
    open(f"bootcamp/assets/stats-{tag}-areas.svg","w",encoding="utf-8").write(_svg(150+len(a)*34+16,parts))
    parts=[_t(24,46,"Capabilities per module",22,700)]
    m=sorted(mods.items()); scale=(STAT_W-24-280-50)/max(n for _,n in m)
    for i,(k,n) in enumerate(m):
        y=76+i*34; full=f"{k}. {titles[str(k)]}"; lab=full if len(full)<=36 else full[:35]+"…"
        parts+=[f'<text x="268" y="{y+17}" font-size="13" font-weight="600" fill="#24292f" text-anchor="end"><title>{html.escape(full)}</title>{html.escape(lab)}</text>',f'<rect x="280" y="{y}" width="{n*scale:.1f}" height="24" fill="#2F66D6"/>',_t(280+n*scale+8,y+17,n,14,400,"#57606a")]
    open(f"bootcamp/assets/stats-{tag}-modules.svg","w",encoding="utf-8").write(_svg(76+len(m)*34+16,parts))
    return len(caps),len(a),len(mods),len(n_lect)
for _code,_dir in (("B101","building/101"),("B102","building/102"),("B103","building/103"),("C101","customizing/101"),("C102","customizing/102")):
    print(_code,"stats (capabilities, areas, modules, lectures):",_course_stats(_code,f"bootcamp/courses/{_dir}/README.md",_code.lower()))
out+=["<table>","<tr><th align=\"left\">Summary</th><th align=\"left\">Statistics</th></tr>","<tr><td valign=\"top\">","","| Area | Capabilities |","| :-- | :-: |"]+_summ_rows()+[f"| **Total** | **{total}** |","","</td><td valign=\"top\">","",*STATS_MD,"","</td></tr>","</table>","",*body,"## UI Component Layout Index","","Bean-level OAF component names for each capability that has them, grouped by OAF component category. Look up the lectures in the capability's row.","","| # | Group | Capability | # | Component |","| :-- | :-- | :-- | :-- | :-- |",*_ci_rows,"","## Notes","","- A capability counts as covered when a lecture name or note names it. This shows where a topic is taught, not how deeply.","- The list is built from the capability catalogs supplied for this course, not from an official Oracle list.","- Levels are derived from where lectures name each capability (a few basics are set by hand), so they are not an official Oracle grading.","- The content has not been reviewed by an instructor.",""]
open('bootcamp/capabilities/CAPABILITIES.md','w').write("\n".join(out))
with open('bootcamp/capabilities/capabilities.csv','w',newline='',encoding='utf-8') as f:
    w=csv.writer(f); w.writerow(["id","area","sub_area","capability","level","course_count",*[LV[p].replace(' ','_').lower() for p in LV],"lecture_count","courses","lectures"]); w.writerows(csv_rows)
bad=[(n,c) for n,k,top in checks for c in top if c not in codes or not any(hit(x,(r[1]+" "+r[2]).lower()) for x in k for r in rows if r[0]==c)]
print("capabilities",total,"| bad",bad,"| lines",len(out))
