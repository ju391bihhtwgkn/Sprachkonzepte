Autoren: Julian Bihl, Tobias Mack
Gruppe 8
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

So kann bereits vor Laufzeit geklärt werden ob ein Fehler auftritt.

# Aufgabe 3.2
Die dynamische Semantik ist durch die Methode 'dynamicSemanticTest' in TripToAst umgesetzt.

Hier findet keine Überprüfung in dem Sinne statt, sondern eine Astverarbeitung, also wird dies erst zur Laufzeit durchgeführt.

Statischer Teil der Semantikprüfung:
- Wenn mind. zwei Daten im Text gefunden werden, wird überprüft ob das erste Datum zeitlich vor dem zweiten Datum liegt. 

Dynamischer Teil der Semantikprüfung:
- eine weitere Verarbeitung des Asts wird durchgeführt:
Die Daten werden in das importierte Datumsformat SimpleDateFormat weiterverarbeitet und die Funktion gibt ein Objekt des Typs Date zurück. Funktioniert das nicht kommt es zu einer ParseException.

# Aufgabe 4

## Aufgabe 4a

Das Aufrufen der einzelnen Methoden in Zeile 19-21 sind eindeutig im Proceduralen Stil. Sie akzeptieren
Argumente als Parameter und mutieren diese als Seiteneffekt. Die einzelnen Methoden sind wiederrum
ebenfalls stark Procedural durch die Verwendung von 
Schleifen und bedingten Anweisungen um auf Daten 
zuzugreifen und sie zu ändern.

## Aufgabe 4b)

Das auf den funktionalen Stil umgeänderte Programm:

````
public final class Functional {
    private Functional() { }

    private static final int MIN_LENGTH = 20;

    public static void main(String[] args) throws IOException {
        var input = Paths.get(args[0]);

        long start = System.nanoTime();

        int n = Files.lines(input)
            .filter(line -> !line.isEmpty())
            .filter(line -> line.length() >= MIN_LENGTH)
            .mapToInt(String::length)
            .sum();
        
    
        
        long stop = System.nanoTime();

        System.out.printf("result = %d (%d microsec)%n", n, (stop - start) / 1000);
    }
}

````

## Aufgabe 4c)

Um das Laufzeitverhalten zu überprüfen haben wir mehrmals mit geringer, mittlere und hoher Zeilenanzahl getestet.

Bei kleinen Testdaten ist die Procedurale implementierung deutlich schneller. Das könnte am Overhead des Streams liegen,
bei welchem viele temporäre Objekte erstellt und wieder freigeben werden müssen. Je größer die Testdaten werden umso
schneller wird das Funktionale Programm im Vergleich zum Proceduralen. Eine Erklärung sind die Anzahl der
Durchläufe der Daten. Das Procedurale durchläuft die
Daten mehrmals. Einmal zum Lesen der Zeilen, zum Entfernen der leeren Zeilen und zum Entfernen der
zu kurzen Zeilen. Das Funktionale Programm widerrum zu einmal.

Zum anderen könnte die Verwendung
der LinkedList die Laufzeit erhöhen. Weil die Entfernung von vielen Elementen zeitaufwändig sein kann, da die LinkedList jedes mal neu Organisiert werden muss. Das Procedurale braucht vermutlich bei
großer Datenmenge mehr Speicher, da alle Daten gleichzeitig im Speicher gehalten werden. Beim 
Funktionalen, wird durch Streams die lazy Verarbeitung
ermöglicht wobei die Daten erst verarbeitet werden,
wenn man sie braucht.

````
Testgröße:  355 Zeilen
Procedural: 8848 microsec
Funktional: 17380 microsec

Testgröße:  2000 Zeilen
Procedural: 27725 microsec
Funktional: 18017 microsec

Testgröße:  10000 Zeilen
Procedural: 300007 microsec
Funktional: 22326 microsec
````

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
unendlich viele sinnfreie Möglichkeiten

mit Verwendung von Cut vermeidbar:
````
append([],L,L) :- !.
append([H|T1],L,[H|T2]) :- append(T1,L,T2).
````


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
Die Abfrage soll wie folgend aussehen:
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

# Aufgabe 6

Um eine Html-Datei im richtigen Format für beliebige 
Java-Klassen -Interfaces zu generieren haben wir eine
Stringtemplategroup-Datei mit den Templates aufgabe6, classInfo und interfaceInto erstellt.

```
delimiters "$", "$"

aufgabe06(list) ::= <<
<!DOCTYPE html>
<html lang="de">
    <head>
        <style type="text/css">
        th, td { border-bottom: thin solid; padding: 4px; text-align: left; }
        td { font-family: monospace }
        </style>
    </head>
    <body>
        <h1>Sprachkonzepte, Aufgabe 6</h1>
        $list:classInfo(); separator="\n"$
    </body>
</html>
>>

classInfo(c) ::= <<
<h2>$if(c.isInterface)$interface $else$class $endif$$c.name$:</h2>
    <table>
        <tr>
            $if(c.isInterface)$
                <th>Methods</th>
            $else$
                <th>Interface</th>
                <th>Methods</th>
            $endif$
        </tr>
            $c.interfaces:interfaceInfo(); separator="\n"$
    </table>
<br>
>>

interfaceInfo(i)::= <<
<tr>
    $if(c.isInterface)$
        <td>$i.methods :{ m | $m$ <br>}$</td>
    $else$
        <td valign=top>$i.name$</td>
        <td>$i.methods :{ m | $m$ <br>}$</td>
    $endif$
</tr>
>>
```

Die Klassen ClassInfo und InterfaceInfo wurden erstellt
um die notwendigen Informationen der Java-Klassen und -Interfaces bereitzustellen.

```
final class ClassInfo {
	public final String name;
	public LinkedList<InterfaceInfo> interfaces;
	public boolean isInterface;

	public ClassInfo(Class<?> c) {
		this.name = c.getName();
		this.interfaces = new LinkedList<>();
		this.isInterface = false;

		if (c.isInterface()) {
			this.isInterface = true;
			var currentInterface = new InterfaceInfo(c.getName());
			for (var m : c.getMethods()) {
				var parameterTypes = Arrays.stream(m.getParameterTypes())
						.map(Class::getName)
						.collect(Collectors.joining(", "));
				currentInterface.methods
						.add(m.getReturnType().getName() + " " + m.getName() + "(" + parameterTypes + ")");
			}
			this.interfaces.add(currentInterface);
		} else {
			for (var i : c.getInterfaces()) {
				var currentInterface = new InterfaceInfo(i.getName());

				for (var j : i.getMethods()) {
					var parameterTypes = Arrays.stream(j.getParameterTypes())
							.map(Class::getName)
							.collect(Collectors.joining(", "));
					currentInterface.methods
							.add(j.getReturnType().getName() + " " + j.getName() + "(" + parameterTypes + ")");
				}

				this.interfaces.add(currentInterface);
			}
		}
	}

}

final class InterfaceInfo {

	public final String name;
	public final LinkedList<String> methods;

	public InterfaceInfo(String name) {
		this.name = name;
		this.methods = new LinkedList<>();
	}
}
```


# Aufgabe 7
Das Python Programm ruft die API feiertage-api.de mit den Parametern Jahr und Bundesland=Baden-Württemberg auf.
Dabei werden die Feiertage die im JSON format ankommen mit dem aktuellen Datum abgeglichen und gefiltert sodass die nächsten Feiertage mit Wochentag ausgegeben werden.
Die Ausgabe sieht wie folgt aus:
```
Es sind 12 Feiertage in diesem Jahr übrig.
Die nächsten 3 Feiertage sind:

Gründonnerstag am 2024-03-28 (Thursday)
Karfreitag am 2024-03-29 (Friday)
Ostermontag am 2024-04-01 (Monday)
```

Typische Eigenschaften von Scriptsprachen die hier verwendet wurden sind:

- Syntax ist generell sehr einfach gehalten -> hohe Abstraktion auch durch Nutzung externer Bibliotheken
- eine deklarationsfreie Syntax, sprich eine implizite Deklaration von Namen und eine dynamische Typisierung
- automatische Speicherverwaltung, es wurde keine manuelle über gc o.Ä. benutzt
- zeilenweise Interpretation, vor allem in Verbindung mit JupyterNotebook hilfreich für Entwicklungsprozess
- Umgang mit Strings vereinfacht: variablen können in string eingefügt werden:
```
    api_url = f"https://feiertage-api.de/api/?jahr={year}&nur_land={bundesland}"
```
