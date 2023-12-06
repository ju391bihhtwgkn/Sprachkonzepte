# Aufgabe 1.1

**Regex:**

according to java.util.Formatter:

**%[argument_index$][flags][width][.precision]conversion**

- The optional argument_index is a decimal integer indicating the position of the argument in the argument list. The first argument is referenced by "1$", the second by "2$", etc.

- The optional flags is a set of characters that modify the output format. The set of valid flags depends on the conversion.

- The optional width is a positive decimal integer indicating the minimum number of characters to be written to the output.

- The optional precision is a non-negative decimal integer usually used to restrict the number of characters. The specific behavior depends on the conversion.

- The required conversion is a character indicating how the argument should be formatted. The set of valid conversions for a given argument depends on the argument's data type.

Da für Date/Time Conversions auf ein 't' oder 'T' ein weiterer Buchstabe folgt wird dies gesondert behandelt.

Um die Übersicht zu behalten wird für jede Kategorie ein Regulärer Ausdruck erstellt:

````
    private static String getFormatterRegex() {
        String argumentIndexRegex = "%(\\d+\\$)?";
        String flagsRegex = "([-#+ 0,(]*)";
        String widthRegex = "(\\d+)?";
        String precisionRegex = "(\\.\\d+)?";
        String conversionRegex = "[a-zA-Z%]";

        String timeSpecifierRegex = "[tT]([a-zA-Z])";

        return argumentIndexRegex + flagsRegex + widthRegex + precisionRegex + "(" + timeSpecifierRegex + "|" + conversionRegex + ")";
    }
````

**Input**
````
xxx %d yyy%n
xxx% 012d yyy%%
xxx%1$d yyy
%1$0+(32.10fyyy
Wochentag: %tA Uhrzeit: %tT 
````

**Output**
````
TEXT("xxx ")FORMAT("%d")TEXT(" yyy")FORMAT("%n")
TEXT("xxx")FORMAT("% 012d")TEXT(" yyy")FORMAT("%%")
TEXT("xxx")FORMAT("%1$d")TEXT(" yyy")
FORMAT("%1$0+(32.10f")TEXT("yyy")
TEXT("Wochentag: ")FORMAT("%tA")TEXT(" Uhrzeit: ")FORMAT("%tT")
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

# Aufgabe 2.1
Die folgende Sprache soll eine Reisedatenbeschreibung verstehen, die zb. wie folgt aussieht

### Beispiel 1 
````
DepartureDate: 1/3/23
TripTitle: [Beach Holiday.]
City:    [Miami]
Country: [United States]
ReturnDate: 3/04/2023

````
Für den Lexer wurden dafür die jeweiligen Bezeichnungen als Token beschrieben.
Die Einträge werden durch eckige Klammern erkannt, und können beliebig viele Zeichen enthalten.
Das Datum besteht aus einem Tag einem Monat und einem Jahr, welche über '/' getrennt werden.

Im Parser setzt man nun die Bestandteile zusammen und fächert die Subkategorien weiter auf.
Die Regel multiline dient dazu das Dokument weiterzuführen bzw. über ein NEWLINE die values zu trennen.

````
start: line EOF;
line: value multiline;
multiline: NEWLINE value multiline | NEWLINE value;
value: (TITLE ( DATE | ENTRY ));
````


Anschliessend wurde mit den Antlr-tools der Ableitungsbaum generiert mit dem Befehl

````
antlr4-parse .\TripLexer.g4 .\TripParser.g4 trip -gui ".\example.txt"
````

#### Beispiel 1 (example.txt)
![Beispiel1](aufgabe_02+03/example.svg)

#### Beispiel 2 (example2.txt)
![Beispiel2](aufgabe_02+03/example2.svg)



# Aufgabe 2.2

Zuerst wurde der Java Lexer, Parser und Listener mit dem folgenden Befehl aus der Grammatik generiert:

````
antlr4 .\TripLexer.g4 .\TripParser.g4
````

Anschließend wurden die einzelnen Klassen erstellt die von der abstrakten Klasse "Trip" erben.
- Line
- Multiline
- Value

### TripToAst:
Der Lexer liest einen CharStream welcher dann dem Parser übergeben wird.
Durch den Parser wird der Parsetree erstellt und dem TripBuilder übergeben.

### TripBuilder:
Insgesamt dient der TripBuilder dazu, den Parsebaum zu durchlaufen und die darin enthaltenen Informationen in Form von 
Trip-Objekten zu strukturieren. 
Dabei wird ein Stack verwendet, um temporäre Trip-Objekte zu verwalten, während der Parsebaum durchlaufen wird.
Er verarbeitet verschiedene Parser-Regeln wie "Value", "Line" und "Multiline" welche in den Exitfunktionen aufgegriffen 
und verarbeitet werden.
Dies ermöglicht die Erstellung eines hierarchisch strukturierten Objekts, das den analysierten Inhalt repräsentiert.




# Aufgabe 3.1
Die statische Semantik ist durch die Methode 'staticSemanticTest' in TripToAst umgesetzt.

Es wird überprüft ob die Entries eine Länge von min 5 - max 50 Zeichen haben.


# Aufgabe 3.2
Die dynamische Semantik ist durch die Methode 'dynamicSemanticTest' in TripToAst umgesetzt.

Wenn mind. zwei Daten im Text gefunden werden, wird überprüft ob das erste Datum zeitlich vor dem zweiten Datum liegt.





# Aufgabe 5

## Aufgabe 5a
1. Matching der 2 Listen:

````
Regel:
p(Liste1-Value). 	zb. p([X,Y,Z]).

Abfrage:
?-p(Liste2-Value).	zb. ?-p([john,likes,fish]). => X = john, Y = likes, Z = fish
````

2. Die Fakultät muss die Zahl N rekursiv mit N-1 multiplizieren:
````
fakultaet(N, Ergebnis) :-
    N > 0,
    N_minus_1 is N - 1,
    fakultaet(N_minus_1, Ergebnis_minus_1),
    Ergebnis is N * Ergebnis_minus_1.

?-fakultaet(3, X).
Ergebnis = 6
````

3. Funktion zum Konkatenieren von zwei Listen
````
append([],L,L).
append([H|T1],L,[H|T2]) :- append(T1,L,T2).
````
append(X, Y, [1,2,3,4]).
berechnet alle Möglichkeiten die die Ergebnisliste ausgeben:
````
X = [],
Y = [1, 2, 3, 4]
X = [1],
Y = [2, 3, 4]
X = [1, 2],
Y = [3, 4]
X = [1, 2, 3],
Y = [4]
X = [1, 2, 3, 4],
Y = []
````

append(X, [1,2,3,4], Z).
berechnet alle Möglichkeiten wenn Liste X mit Liste [1,2,3,4] appended wird.
````
X = [],
Z = [1, 2, 3, 4]
X = [_1368],
Z = [_1368, 1, 2, 3, 4]
X = [_1368, _1374],
Z = [_1368, _1374, 1, 2, 3, 4]
X = [_1368, _1374, _1380],
Z = [_1368, _1374, _1380, 1, 2, 3, 4]
...
````
unendlich viele Möglichkeiten


## Aufgabe 5b
Summenberechnung einer Liste ebenfalls rekursiv wie bei Fakultät:
````
sum([], 0).
sum([Head|Tail], Sum) :-
    sum(Tail, TailSum),
    Sum is Head + TailSum.
````

Beispielausgabe:

````
?-sum([2, 3, 40, 5], Result).
Result = 50
````


## Aufgabe 5c

Gegebene Fakten:
````
zug(konstanz, 08.39, offenburg, 10.59).
zug(konstanz, 08.39, karlsruhe, 11.49).
zug(konstanz, 08.53, singen, 09.26).
zug(singen, 09.37, stuttgart, 11.32).
zug(offenburg, 11.27, mannheim, 12.24).
zug(karlsruhe, 12.06, mainz, 13.47).
zug(stuttgart, 11.51, mannheim, 12.28).
zug(mannheim, 12.39, mainz, 13.18). 
````
Die Abfrage soll am Ende so gemacht werden:
````
?-verbindung(konstanz, 8.00, mainz, Reiseplan)
````
Um nun eine direkte Verbindung zu finden wie zb Konstanz - Offenburg wird folgendes Prädikat verwendet:

````
verbindung(Start, Abfahrtszeit, Ziel, Reiseplan) :-
    zug(Start, Abfahrt, Ziel, Ankunft),
    Abfahrt > Abfahrtszeit,
    Reiseplan = [Start, Abfahrt, Ziel, Ankunft].
````

Um Zwischenziele verwenden zu können muss ein weiteres Prädikat hinzugefügt werden, welches verbindung rekursiv aufruft und die bestehende Reise weitergibt, damit der "Fahrplan" nicht verloren geht.
````
verbindung(Start, Abfahrtszeit, Ziel, Reiseplan) :-
    zug(Start, Abfahrt, Zwischenziel, Ankunft),
    Abfahrt > Abfahrtszeit,
    Reiseplan = [(Start, Abfahrt, Zwischenziel, Ankunft) | Reise],
    verbindung(Zwischenziel, Ankunft, Ziel, Reise).
````

Die Abfrage gibt anschließend 3 Möglichkeiten aus. Bei dem vierten Versuch kommt ein false da keine Möglichkeiten mehr gefunden werden.
````
?-verbindung(konstanz, 8.00, mainz, Reiseplan)
Reiseplan = [(konstanz,8.39,offenburg,10.59), (offenburg,11.27,mannheim,12.24), mannheim, 12.39, mainz, 13.18]
Reiseplan = [(konstanz,8.39,karlsruhe,11.49), karlsruhe, 12.06, mainz, 13.47]
Reiseplan = [(konstanz,8.53,singen,9.26), (singen,9.37,stuttgart,11.32), (stuttgart,11.51,mannheim,12.28), mannheim, 12.39, mainz, 13.18]
false
````