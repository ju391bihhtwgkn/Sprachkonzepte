# Aufgabe 1.1

**Regex:**\
````
%+.{0,1}[\w\d$_-§"/(),=+-]*[.\d]*[dfegs]*
````

````
%+                       Einer oder mehr % 
.{0,1}                   ein Char außer newline,  hiermit fängt man ein Whitespace ab welches auf ein % folgt 
[\w\d$_-§"/()=+-]*       eine Zeichenfolge von Special Characters, Wörtern, Zahlen 
[.\d]*                   fängt eine Floating Number ab falls existent 
[dfegs]*                 Endet mit einem Precision Specifier falls existent 
````
# Aufgabe 1.2
Für den Lexer haben wir eine Rule Clock die den Token für eine Zeitangabe erkennt und an den Parser weitergeben kann.
Weitere fragment Rules bauen die Logik des Uhrzeitformats auf.\
````
Clock: Normal | Noon | Midnight ;                 es gibt 3 Möglichkeiten wie eine Uhrzeit aussieht

fragment Normal: Hour ':' Minute ' ' Meridiem ;   Normal ist eine Uhrzeit die in Stunde:Minute und Tageszeitangabe a.m p.m. aufgeteilt wird
fragment Noon: 'Noon' | '12 noon' ;               Bei Noon gibt es die zwei aufgeführten Optionen
fragment Midnight: 'Midnight' | '12 midnight' ;   Bei Midnight gibt es die zwei aufgeführten Optionen

fragment Hour: '1'[0-2]|'0'[1-9] ;                Stunde beginnt entweder mit einer 1 und es folgt 0-2 oder sie beginnt mit einer 0 und es folgt eine 1-9
fragment Minute: [0-5][0-9] ;                     Bei der Minute kann die erste Ziffer nur eine 0-5 sein. 
fragment Meridiem: 'p.m.' | 'a.m.' ;              Bei Meridiem gibt es die zwei aufgeführten Optionen

WS: [ \t\r\n]+ -> channel(HIDDEN);                WS soll nicht als Token angezeigt werden.
````

### Testdaten in test.txt
````
12 noon
09:12 p.m.
Midnight
````
### Test
````
java -cp ".;antlr-4.13.1-complete.jar" org.antlr.v4.gui.TestRig Time tokens -tokens "test.txt"
````
### Ergebnis
````
[@0,0:6='12 noon',<Clock>,1:0]
[@1,7:8='\r\n',<WS>,channel=1,1:7]
[@2,9:18='09:12 p.m.',<Clock>,2:0]
[@3,19:20='\r\n',<WS>,channel=1,2:10]
[@4,21:28='Midnight',<Clock>,3:0]
[@5,29:28='<EOF>',<EOF>,3:8]
````


