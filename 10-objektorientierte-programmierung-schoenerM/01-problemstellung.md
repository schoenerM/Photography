# Problemstellung: Wozu wurden die Konzepte Klasse und Objekt ins Leben gerufen?

Bisher haben wir gelernt mit Variablen von primitiven Datentypen, mit Strings, mit Arrays und mit verschiedenen Listen und Maps/Dictionary zu arbeiten. Weiters haben wir gelernt Methoden zu erstellen.

Mit diesen Mitteln kommen wir aber schnell an folgende Grenze: Was mache ich, wenn ich zum Beispiel mehrere Personen, E-Mails oder Nachrichten in einem Chatprogramm verwalten möchte? Wie speichere ich die Daten, damit ich immer weiß, welche Daten zusammen gehören.

Mit den bisherigen Mitteln, wäre es möglicherweise so zu lösen:

```Java
// Java 
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Initialize a list of lists to hold strings
        List<List<String>> list = new ArrayList<>();

        // Create and populate the first person's details
        List<String> person1 = new ArrayList<>();
        person1.add("Peter");
        person1.add("Müller");
        person1.add("Hauptstraße 5, 4020 Linz");
        // Add the first person to the list of lists
        list.add(person1);

        // Create and populate the second person's details
        List<String> person2 = new ArrayList<>();
        person2.add("Petra");
        person2.add("Maier");
        person2.add("Landtraße 12, 4020 Linz");
        // Add the second person to the list of lists
        list.add(person2);
    }
}

```

```csharp
// C# 

using System.Collections.Generic;

class Program
{
    static void Main(string[] args)
    {
        // Initialize a list of lists to hold strings
        List<List<string>> list = new List<List<string>>();

        // Create and populate the first person's details
        List<string> person1 = new List<string> {"Peter","Müller","Hauptstraße 5, 4020 Linz"};
        // Add the first person to the list of lists
        list.Add(person1);

        // Create and populate the second person's details
        List<string> person2 = new List<string> {"Petra", "Maier", "Landtraße 12, 4020 Linz"};
        // Add the second person to the list of lists
        list.Add(person2);
    }
}

```

Wie man merkt, ist das zwar umsetzbar, aber um diese Liste sinnvoll verwenden zu können, muss man wissen, an welcher Position in der Liste der Vorname, der Nachname bzw. die Adresse sich befinden. Das ist fehleranfällig, insbesondere, wenn man nachträglich etwas an der Struktur ändern muss.

Weiters stellt sich auch die Frage: woher weiß ich, was ich mit einer Person machen darf. Was sind die Fähigkeiten einer Person?

Mit den bisherigen Mitteln ist es mit Methoden umsetzbar, allerdings besteht kein Zusammenhang zwischen der Person und ihren Fähigkeiten. 

In diesem Kapitel kommen die Konzepte von Klassen und Objekten ins Spiel. Mit diesen 2 Konzepten haben wir die Möglichkeit, eine Variable zu definieren, in der alle zusammengehörigen Eigenschaften (Attribute) zusammengefasst werden. Weiters definiert diese Variable nicht nur die Eigenschaften, sondern auch die Fähigkeiten (Methoden) an, die mit dieser Variable verwendet werden können.

So haben wir in einem Objekt immer alle Eigenschaften und alle Fähigkeiten (was das Objekt tun darf) des Objekts zusammengefasst. 

Zurück zur [Startseite](README.md)