# Konstruktor(en)

Der Konstruktor ist die "Methode", die aufgrufen wird, wenn der Befehl `new` verwendet wird, also, wenn ein Objekt instanziert wird. Eine Klasse darf mehrere Konstruktoren aufweisen, die ähnlich den Methoden sich in unterschiedlichen Signaturen unterscheiden müssen.

Konstruktoren sind dazu da, das Objekt zu initialisieren. Initialisieren bedeutet nicht nur, dass die Attribute einen Wert bekommen. Mit einem Konstruktor kann man auch zB eine Datenbankverbindung öffnen, um in den Methoden damit arbeiten zu können. In einer Logging-Klasse könnte man bei der Instanzierung des Objekts zum Beispiel die entsprechende Datei anlegen... 

Sollte in der Klasse kein Konstruktor vorhanden sein, wird implizit ein "leerer" Konstruktor für die Instanzierung eines Objekts angenommen: Es wird der Konstruktor der Klasse Object aufgerufen, von der alle Klassen erben. Dieser Konstruktor erzeugt ein Objekt von der angegebenen Klasse, macht sonst aber nichts. 

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

In diesem Beispiel wurde kein Konstruktor definiert, so wird der Default-Konstruktor verwendet.

Bei der Instanzierung eines Objekts, da kein Konstruktor definiert ist, bekommen die Attribute folgende Werte: firstname = "Markus", lastname = "Gruber", address = null. 

Man könnte die Klasse `Person` mit demselben Effekt folgendermaßen definieren:

```Java
// Java
public class Person{
    private final String firstname;
    private final String lastname;
    private String address;

    public Person() {
        this.firstname = "Markus";
        this.lastname = "Gruber";
    }
}
```
```csharp
// C# 
public class Person{
    private readonly string firstname;
    private readonly string lastname;
    private string address;

    public Person() {
        this.firstname = "Markus";
        this.lastname = "Gruber";
    }
}
```

Das zweite Beispiel zeigt eine andere Methode, Defaultwerte beim Instanzieren eines Objekts festzulegen. 

> [!IMPORTANT]
> Wird ein Konstruktor definiert, kommt der Default-Konstruktor nicht mehr zur Anwendung egal, ob ein Konstruktor mit derselben Signatur oder mit einer anderen Signatur erstellt wurde.

An diesem Beispiel erkennt man, woraus ein Konstruktor besteht:
- **Access Modifier**: `public`, `default` oder `protected` (private macht für einen Konstruktor keinen Sinn)
- **Name der Klasse**: Der Konstruktor heißt immer genauso wie die Klasse selbst.
- **Parameter**: Konstruktoren können mit oder ohne Parameter erstellt werden.
- wichtig ist anzumerken, dass der Konstruktor im Gegensatz zu einer Methode keinen Datentyp also keinen Rückgabewert hat!

Hier ein weiteres Beispiel mit Überlagerung des Konstruktors:

```Java
// Java
public class Person{
    private String firstname;
    private String lastname;
    private String address;

    public Person(){
        this.firstname = "Markus";
        this.lastname = "Gruber";
    }

    public Person(String firstname, String lastname){
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public Person(String firstname, String lastname, String address){
        this.firstname = firstname;
        this.lastname = lastname;
        this.address = address;
    }
}
```

```csharp
public class Person
{
    private readonly string firstname;
    private readonly string lastname;
    private string address;

    // Default constructor
    public Person()
    {
        this.firstname = "Markus";
        this.lastname = "Gruber";
    }

    // Constructor with firstname and lastname
    public Person(string firstname, string lastname)
    {
        this.firstname = firstname;
        this.lastname = lastname;
    }

    // Constructor with firstname, lastname, and address
    public Person(string firstname, string lastname, string address)
    {
        this.firstname = firstname;
        this.lastname = lastname;
        this.address = address;
    }
}

```

In diesem Beispiel sehen wir 3 Konstruktoren, die sich darin unterscheiden, wie viele Parameter mitgeschickt werden. Welche Konstruktoren man definiert hängt von den Anwendungsfällen, die man abdecken möchte und auch davon ab, ob die definierten Attribute private sind und ob für diese privaten Attribute Setter definiert sind. Es gilt jedenfalls die Regel: man definiert nur jene Konstruktoren, die man tatsächlich braucht. 

[Zurück zur Übersicht](README.md)