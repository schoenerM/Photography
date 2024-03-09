# Attribute

Attribute sind Eigenschaften des Objekts. Zum Beispiel ein Objekt `Person` könnte folgende Eigenschaften haben:
- Vorname
- Nachname
- Adresse
- Telefonnummer
- Geburtstdatum
- Sozialversicherungsnummer

Welche Attribute in einer Klasse definiert werden, hängt immer davon ab, was im Programm wirklich benötigt wird. So könnte es für ein Programm Sinn machen eine Klasse Person in einer Mieterverwaltungssoftware mit Vorname, Nachname, Adresse, die Höhe der Miete, aber keine Sozialversicherungsnummer zu definieren, während in einer Ärztesoftware die Sozialversicherungsnummer gebraucht wird, aber die Höhe der Miete nicht wichtig wären. 

Es macht keinen Sinn Attribute zu definieren, die in weiterer Folge nicht verwendet werden, da diese Speicher umsonst verbrauchen.

Man kann Attribute als Variablen betrachten, die einem Objekt zugehörig sind und innerhalb der Instanz dieses Objekts verwendet werden. Weiters werden diese innerhalb der Klasse deklariert aber außerhalb von Methoden. Eine weitere wichtige Eigenschaft ist, dass auch sie einen Access Modifier aufweisen können. 

Attribute können dieselben Access Modifier aufweisen, wie Methoden: `public`, `private`, `default`, `protected`.

Weiters kann auch der Modifier `final` verwendet werden, um eine Konstante zu definieren.

Die Attributnamen sind laut Namingconvention sowohl in Java als auch in C# in CamelCase zu definieren. Also der erste Buchstabe ist klein und wenn der Name aus mehreren Worten besteht, wird der erste Buchstabe der weiteren Worte im Namen groß geschrieben. 

```Java
// Java
public class Person{
    private final String firstname = "Markus";
    private final String lastname = "Gruber";
    private String address;
}
```

```csharp
// C# 
public class Person{
    private readonly string firstname = "Markus";
    private readonly string lastname = "Gruber";
    private string address;
}
```

Da in diesem Beispiel der Wert von `firstname` und `lastname` bereits in der Attributsdeklaration definiert wird kann dieser später nicht mehr verändert werden (aufgrund des Modifiers `final`/`readonly`). Alternativ könnte man den Wert erst im Konstruktor setzen (Siehe Beispiel im Kapitel `Konstruktor(en)`). Danach ist dieser Wert nicht mehr veränderbar.

[Zurück zur Übersicht](README.md)