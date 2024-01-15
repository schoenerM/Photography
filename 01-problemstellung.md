# Problemstellung: Wozu wurden die Konzepte Klasse und Objekt ins Leben gerufen?

Bisher haben wir gelernt mit Variablen von primitiven Datentypen, mit Strings, mit Arrays und mit verschiedenen Listen und Maps zu arbeiten. Weiters haben wir gelernt Methoden zu erstellen.

Mit diesen Mitteln kommen wir aber schnell an folgende Grenze: Was mache ich, wenn ich zum Beispiel mehrere Personen, E-Mails oder Nachrichten in einem Chatprogramm verwalten möchte? Wie speichere ich die Daten, damit ich immer weiß, welche Daten zusammen gehören.

Mit den bisherigen Mitteln, wäre es möglicherweise so zu lösen:

## Java

```Java
import java.util.ArrayList;
import java.util.List;

List<List<String>> list = new ArrayList<List>();
List<String> person1 = new ArrayList<>(),

person1.add("Peter");
person1.add("Müller");
person1.add("Hauptstraße 5, 4020 Linz");
list.add(person1);

person2.add("Peter");
person2.add("Müller");
person2.add("Hauptstraße 5, 4020 Linz");
list.add(person2);
```

## C#

```c#

```

Wie du merkst, ist das zwar umsetzbar, aber um diese Liste sinnvoll verwenden zu können, muss man wissen, an welcher Position in der Liste der Vorname, der Nachname bzw. die Adresse sich befinden. Das ist fehleranfällig, insbesondere, wenn man nachträglich etwas an der Struktur ändern muss.

Weiters stellt sich auch die Frage: woher weiß ich, was ich mit einer Person machen darf. Was sind die Fähigkeiten einer Person?

Mit den bisherigen Mitteln ist es mit Methoden umsetzbar, allerdings besteht kein Zusammenhang zwischen der Person und ihren Fähigkeiten. 

Hier kommen die Konzepte von Klassen und Objekten ins Spiel. Mit diesen 2 Konzepten haben wir die Möglichkeit eine Variable zu definieren, in der alle zusammengehörigen Eigenschaften (Attribute) zusammengefasst werden. Weiters definiert diese Variable nicht nur die Eigenschaften, sondern auch die Fähigkeiten (Methoden) an, die mit dieser Variable verwendet werden können.

So haben wir in einem Objekt immer alle Eigenschaften dieses Objekts und alle Fähigkeiten (was das Objekt tun darf) zusammengefasst. 