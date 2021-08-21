# OA Framework File Standards

<br>

### Name Length Limit


| File Type                        | Maximum Length/Characters   | Notes|
| :-                               | :------:           | :------| 
| Java Files                       | 50    |If inner classes are used, the concatenated inner class name with the outer class name may not exceed 50 characters.        |
| OA Extension Component XML Files | 50    |OA Extension includes page, region, attribute set and package |
| BC4J XML Files                   | 30    |        |

> OA Extension Component XML Files: You must try to use common abbreviations like "Emp" for "Employee," "Num" for "Number ," "Desc" for "Description" and so on whenever possible. Do not sacrifice clarity for brevity. If the abbreviation cannot be understood by the average consultant or customer, do not abbreviate.

> The first letter in every word should be capitalized except where standard, upper case suffixes are required as described below. Note that approved abbreviations and acronyms should also use the initial capitalization scheme.

<br>

### Standard File Suffix Abbreviation

| Suffix          | Object Type               | Example|
| :-:             | :--------                 | :--------   | 
| PG              | Page Defintion            | StoreCreatePG   |
| RN              | Shared Region Defintion   |     |
| LOV             | Share List of Values (LOV) Definition   |     |
| \<Table Name\>  | Attribute Set Package     |     |
| \<Module Name\> | UI Component Package      |     |
| AM              | Application Module        |     |
| VO              | View Object               |     |
| VL              | View Link                 |     |
| EO              | Entity Object             |     |
| AO              | Association Object        |     |
| CO              | Controller                |     |
| VAM             | Validation Application Module   |     |
| VVO             | Validation View Object   |     |
| PVO             | Property View Object     |     |
| Expert          | Entity Expert            |     |

