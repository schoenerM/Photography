# Attribute

Attribute sind Eigenschaften des Objekts. Zum Beispiel ein Objekt Person könnte folgende Eigenschaften haben:
- Vorname
- Nachname
- Sozialversicherungsnummer
- Größe
- Adresse

Welche Attribute in einer Klasse definiert werden, hängen immer davon ab, was im Programm wirklich benötigt wird. So könnte es für ein Programm Sinn machen eine Klasse Person in einem Mieterverwaltungssoftware mit Vorname, Nachname, Adresse, die Höhe der Miete, aber keine Sozialversicherungsnummer zu definieren, während in einer Ärztesoftware die Sozialversicherungsnummer, aber die Höhe der Miete nicht wichtig wären. 

Es macht keinen Sinn Attribute zu definieren, die in weiterer Folge nicht verwendet werden, da diese Speicher umsonst verbrauchen.

Man kann diese als Variablen betrachten, die einem Objekt zugehörig sind und innerhalb dieses verwendet werden. Weiters werden diese innerhalb der Klasse deklariert aber außerhalb von Methoden. Eine weitere wichtige Eigenschaft ist, dass auch sie einen Access Modifier aufweisen können. 

Attribute können dieselben Access Modifier aufweisen, wie Methoden: public, private, default, protected.

Weiters kann auch der Modifier **final** verwendet werden, um eine Konstante zu definieren.

## Java 

```Java
public class Person{
    private final String firstname = "Markus";
    private final String lastname = "Gruber";
    private String address;
}
```
## C# 

```c#

```

Da in diesem Beispiel der Wert von firstname und lastname bereits in Attributsdeklaration definiert wird kann dieser später nicht mehr verändert werden (aufgrund des Modifiers **final**). Alternativ könnte man den Wert erst im Konstruktor setzen (Siehe Beispiel im Kapitel **Konstruktor(en)**). In diesem Falle wird der Wert einmalig.

[Zurück zur Übersicht](README.md)