# Aufgabenstellungen

## Aufgabe 1: verkettete Liste
Wie auch Arrays ist die verkettete Liste eine lineare Datenstruktur, allerdings besteht die verkettete Liste aus einzelnen Elementen (Nodes) die durch Zeiger miteinander verbunden sind.

![LinkedList](img/Linkedlist.png)

Um die Liste zu implementieren benötigst du 2 Klassen. Die Klasse Node (im Bild A, B, ..) hat ein Attribut '''value''' (z.B.: vom Typ String) und einen Zeiger vom Typ '''Node''' auf das nächste Element. Die zweite Klasse ist die Liste selbst. Hier implementieren wir alle Funktionen die unsere Liste haben soll.

Folgene Funktionalität sollte unsere Liste zumindest haben:
(Siehe auch Java List Interface: https://docs.oracle.com/javase/8/docs/api/java/util/List.html)

```java
 void    add(E e) // fügt ein Element ans Ende der Liste hinzu
 boolean add(int index, E element) // fügt ein Element an der Position 'index' in die Liste hinzu und gibt einen boolean zurück, der besagt, ob das Hinzufügen funktioniert hat
 int     size() // gibt die Anzahl der Element in der Liste aus
 E       get(int index) // gibt das Element an der Position 'index' aus
 E       remove(int index) // löscht das Element an der Position 'index' aus der Liste
```

Zusätzlich:

```java
 String  toString() // Gibt einen String aus, der die Liste ansprechend darstellt
```

Für diese Aufgabe benötigst du KEINE anderen Datenstrukturen (Arrays, ArrayList, etc.).

Hier ein einfaches Beispiel für die Grundstruktur: https://www.geeksforgeeks.org/linked-list-set-1-introduction/

**Bonus:** Du kannst deine Liste mit Generics(https://www.geeksforgeeks.org/generics-in-java/) implementieren, sodass der Typ des gespeicherte Wertes **value**, beim erstellen der Liste dynamisch angegeben werden kann.

### Abnahmekriterien

- Das Programm ist in verschiedenen Klassen strukturiert
- Die Klassen wurden sinnvoll benannt
- Die Klassenmethoden sind thematisch passend zur Klasse
- Das Programm funtkioniert und entspricht der Angabe
- Die toString-Methode überschreibt die Methode der Klasse Object
- Das Programm entspricht den Clean-Code-Anforderungen
- TN kann seinen:ihren Code erklären
- TN hat seinen:ihren Code in GitHub eingecheckt


## Aufgabe 2: doppelt verkettete Liste
Eine doppelt verkettete Liste ist eine Reihe von Elementen (auch Knoten/Nodes genannt), die durch zwei Zeiger miteinander verbunden sind. Zusätzlich zu einem Zeiger, der auf das nächste Element zeigt gibt es einen, der auf das vorhergehende Element zeigt. Eine doppelt verkettete Liste kann man also in beide Richtungen durchlaufen. Die Operationen auf einer doppelt verketteten Liste sind analog zu denen einer einfach verketteten Liste.

![Double LinkedList](img/doubleLinkedList.png)

Folgende Funktionalität sollte unsere Liste zumindest haben:
(Siehe auch Java List Interface: https://docs.oracle.com/javase/8/docs/api/java/util/List.html)

```java
// Java
 void    add(E e); // fügt ein Element ans Ende der Liste hinzu
 boolean add(int index, E element); // fügt ein Element an der Position 'index' in die Liste hinzu und gibt einen boolean zurück, der besagt, ob das Hinzufügen funktioniert hat
 int     size(); // gibt die Anzahl der Element in der Liste aus
 E       get(int index); // gibt das Element an der Position 'index' aus
 E       remove(int index); // löscht das Element an der Position 'index' aus der Liste
```

```csharp
// C# 
 void    Add(E e); // fügt ein Element ans Ende der Liste hinzu
 bool Add(int index, E element); // fügt ein Element an der Position 'index' in die Liste hinzu und gibt einen boolean zurück, der besagt, ob das Hinzufügen funktioniert hat
 int     Size(); // gibt die Anzahl der Element in der Liste aus
 E       Get(int index); // gibt das Element an der Position 'index' aus
 E       Remove(int index); // löscht das Element an der Position 'index' aus der Liste
```

Zusätzlich:
```java
// Java
 String  toString(); // Gibt einen String aus, der die Liste ansprechend darstellt
 String  toStringReverse(); // Gibt einen String aus, der die Liste rückwärts ansprechend darstellt
```

```csharp
// C# 
 string  ToString(); // Gibt einen String aus, der die Liste ansprechend darstellt
 string  ToStringReverse(); // Gibt einen String aus, der die Liste rückwärts ansprechend darstellt
```

Wie auch bei der einfach verketteten Liste kannst du gerne `Generics` verwenden.

### Abnahmekriterien

- Das Programm ist in verschiedenen Klassen strukturiert
- Die Klassen wurden sinnvoll benannt
- Die Klassenmethoden sind thematisch passend zur Klasse
- Das Programm funtkioniert und entspricht der Angabe
- Die toString-Methode überschreibt die Methode der Klasse Object
- Das Programm entspricht den Clean-Code-Anforderungen
- TN kann seinen:ihren Code erklären
- TN hat seinen:ihren Code in GitHub eingecheckt

## Aufgabe 3: Fotografie

Implementiere die Klassen `Camera` und `Lens`. Eine Kamera besitzt einige Eigenschaften - eine Marke `brand`, eine Anzahl an MegaPixeln `megaPixels`, eine Display Größe `displaySize` und ein boolsches Flag, welches ausdrückt ob die Kamera schwarz-weiß oder Farb-Fotos aufnimmt `colored`. Außerdem besitzt eine Kamera ein Objektiv `Lens`, welches eine minimale und maximale Brennweite besitzt.

Verwende bei allen Variablen `getter & setter`. Füge beim Setzen der Brennweiten eines Objektivs bzw. beim Konstruieren eines Objektivs einen Check hinzu, dass die maximale Brennweite immer größer sein muss als die angegebene minimale Brennweite.

Implementiere *statische* Zählervariablen für die Kamera und für das Objektiv, die mitzählen, wie viele Instanzen einer Klasse angelegt wurden.

Lege in der Main Klasse mehrere Kameras an und wechsle auch auf mindestens einer das Objektiv. Überschreibe die `toString()` Methoden beider Klassen.

### Abnahmekriterien

- Das Programm funtkioniert und entspricht der Angabe
- Die toString-Methode überschreibt die Methode der Klasse Object
- Das Programm entspricht den Clean-Code-Anforderungen
- TN kann erklären, wozu Getter und Setter Sinn machen
- TN kann seinen:ihren Code erklären
- TN hat seinen:ihren Code in GitHub eingecheckt

## Aufgabe 4: Stack

Implementiere einen IntStack! Ein Stack ist ein Stapel, der immer die Dinge zuerst abarbeitet, die er zuletzt bekommen hat: nach dem ''Last in first out''-Prinzip. Die Klasse `Stack` sollte folgende Methoden haben:

- `void push(int newElement)`: fügt ein neues Element oben in den Stack ein
- `int size()`: gibt die Anzahl der Elemente im Stack zurück
- `int pop()`: gibt das letzte Elemente des Stacks zurück und entfernt dieses vom Stack
- `int peek()`: gibt das letzte Elemente des Stacks zurück ohne den Stack zu modifizieren
- `int[] pop(int n)`: gibt die letzten n Elemente des Stacks zurück und entfernt diese vom Stack

Wird auf einen leeren Stack `pop()` oder `peek()` aufgerufen sollte eine Fehlermeldung ausgegeben werden.

Leg in der `main`-Methode einen Stack an und schreibe ein paar Beispiel-Verwendungen.

**Tip:** Für die Implementation kannst du deine doppelt verkettete Liste aus dem letzten Modul verwenden!!! Lege ein Klassen-Attribut von deiner Liste an NICHT von der Node!!!!

### Abnahmekriterien

- Das Programm funtkioniert und entspricht der Angabe
- Die geforderten Methoden sind implementiert
- TN kann erklären, warum es Sinn macht seine:ihre Implementierung der doppelt verketteten Liste wieder zu verwenden
- Das Programm entspricht den Clean-Code-Anforderungen
- TN kann seinen:ihren Code erklären
- TN hat seinen:ihren Code in GitHub eingecheckt

## Aufgabe 5: Queue


Implementiere einen IntQueue! Eine Queue ist eine Schlange, wie eine Warteschlange, in der immer Elemente in der Reihenfolge abgearbeitet werden wie sie aufgenommen werden - dem ''First in first out'' Prinzip. Die Klasse Queue sollte folgende Methoden haben:

- `void enqueue(int newElement)`: fügt ein neues Element hinten in die Schlange ein
- `int size()`:  gibt die Anzahl der Elemente in der Queue zurück
- `int dequeue()`: gibt das erste Elemente der Schlange zurück und entfernt dieses daraus
- `int[] dequeue(int n)`: gibt die ersten n Elemente der Schlange zurück und entfernt diese daraus

Leg in der Main Methode eine Queue an und schreib ein paar Beispiel-Verwendungen.

**Tip:** Für die Implementation kannst du deine doppelt Verkettete Liste aus dem letzten Modul verwenden!!! Lege ein Klassen-Attribut von deiner Liste an NICHT von der Node!!!!

### Abnahmekriterien

- Das Programm funtkioniert und entspricht der Angabe
- Die geforderten Methoden sind implementiert
- TN kann erklären, warum es Sinn macht seine:ihre Implementierung der doppelt verketteten Liste wieder zu verwenden
- Das Programm entspricht den Clean-Code-Anforderungen
- TN kann seinen:ihren Code erklären
- TN hat seinen:ihren Code in GitHub eingecheckt


[Zurück zur Übersicht](README.md)