# Aufgabe 1.1

**Regex:**\
 %+.{0,1}[\w\d$_-§"/(),=+-]*[.\d]*[dfegs]*

%+                       Einer oder mehr % \
.{0,1}                   ein Char außer newline,  hiermit fängt man ein Whitespace ab welches auf ein % folgt \
[\w\d$_-§"/()=+-]*       eine Zeichenfolge von Special Characters, Wörtern, Zahlen \
[.\d]*                   fängt eine Floating Number ab falls existent \
[dfegs]*                 Endet mit einem Precision Specifier falls existent \

# Aufgabe 1.2
