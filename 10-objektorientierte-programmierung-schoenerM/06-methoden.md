# Methoden

Methoden haben wir bereits in einem früheren Kapitel kennengelernt. Zu diesem Zeitpunkt haben wir aber noch nicht gewusst, dass wir immer in Klassen arbeiten, wenn wir programmieren. Das ganze Wissen, das wir bisher erworben haben, ist jedoch weiterhin gültig. Dieses Wissen erweitern wir jetzt.

Wenn man eine Klasse deklariert, erbt diese Klasse automatisch von der "Urklasse" `Object` in Java bzw. `object` in C#. Das Thema Vererbung werden wir uns in einem späteren Kapitel näher erläutern. Hier konzentrieren wir uns lediglich auf einige Methoden, welche von der Klasse `Object`/`object` vererbt werden.

Die Klasse `Object`/`object` beinhaltet u.a. folgende wichtige Methoden:
- `toString()`/`ToString()`: wird aufgerufen, um das Objekt in ein String umzuwandeln, z.B. in einer Consolenausgabe. Standardmäßig (aus der Implementierung aus der `Object`-/`object`-Klasse) liefert diese Methode die Speicheradresse, wo die Instanzvariable gespeichert ist.
- `equals()`/`Equals()`: wird aufgerufen, wenn 2 Objekte miteinander verglichen werden sollen. Diese Methode definiert, wie der Vergleich erfolgen soll.

Das bedeutet, dass diese Methoden in jedem Objekt bereitstehen. Bei der Vererbung besteht die Möglichkeit diese Methoden zu überschreiben. Der Sinn dahinter ist:
- bei der `toString()`-/`ToString()`-Methode ist es oft nicht zielführend, die Speicheradresse auszugeben. Es kann durchaus sinnvoller sein, einige der oder alle Daten im Objekt textuell auszugeben. 
- bei der `equals()`-/`Equals`-Methode könnte man definieren, wie der Vergleich zweier Objekte derselben Klasse miteinander erfolgen soll. Im Beispiel unten könnten wir definieren: Wenn der Vorname und der Nachname gleich sind, dann handelt es sich um dieselbe Person.

## Die Methode `toString()`/`ToString()`

```Java
// Java
import org.apache.commons.validator.routines.EmailValidator;

public class Person{
    private final String firstname;
    private final String lastname;
    private String email;

    public Person(String firstname, String lastname){
      this.firstname = firstname;
      this.lastname = lastname;
    }

    public void setEmail(String email){
      if (EmailValidator.getInstance().isValid(email)){
        this.email = email;
      }
    }

    public String getEmail(){
      return this.email;
    }

    @Override
    public String toString(){
        return firstname + " " + lastname;
    }
}
```

Hier liefert die toString-Methode statt der Speicheradresse Daten aus dem Objekt: Vor- und Nachname. Das Überschreiben erfolgt in Java durch die Annotation **@Override** oberhalb der Methodendeklaration. Diese Annotation verhindert, dass ein Fehler beim Kompilieren entsteht, weil 2 Methoden dieselbe Signatur haben.


```csharp
// C# 
using System.Net.Mail;

public class Person
{
    private readonly string firstname;
    private readonly string lastname;
    private MailAddress email;

    public Person(string firstname, string lastname)
    {
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public MailAddress Email {
        get{ return this.email; } // Getter des Attributs `email`
        set{ this.email = new MailAddress(value, this.firstname + " " + this.lastname); }
    }

    public override string ToString(){
      return this.firstname + " " + this.lastname;
    }
}
```

Hier liefert die ToString-Methode statt der Speicheradresse Daten aus dem Objekt: Vor- und Nachname. Das Überschreiben erfolgt in C# durch den Modifier `override` innerhalb der Methodendeklaration. Dieser Modifiers verhindert, dass ein Fehler beim Kompilieren entsteht, weil 2 Methoden dieselbe Signatur haben.

## Die Methode equals()

In der Methode `equals()`/`Equals()` ist definiert, wie 2 Objekte von derselben Klasse (oder einer von dieser Klasse vererbten Klasse) miteinander verglichen werden sollen. 

Aber wozu eine equals()-Methode, wenn es doch den Gleichheitsoperator `==` gibt?

Der Gleichheitsoperator ist gut geeignet, um Variablen von primitiven Datentypen bzw. Strings miteinander zu vergleichen. Sollen aber 2 Objekte miteinander verglichen werden, bezieht sich der Operator `==` aber auf die Adresse zum Speicherplatz, wo die Variable gespeichert ist. Es stellt sich also die Frage, was man möchte:
- möchte ich herausfinden, ob es sich um ein und dasselbe Objekt handelt. In diesem Falle ist `==` gut geeignet.
- möchte man aber herausfinden, ob der Inhalt derselbe ist, ist `==` nicht geeignet.

So wurde die Methode `equals()`/`Equals()` für Objekte definiert, um diesen Anwendungsfall abzudecken.

Wir könnten unser obiges Beispiel folgendermaßen erweitern:

### Java

```Java
// Java
import org.apache.commons.validator.routines.EmailValidator;

public class Person{
    private final String firstname;
    private final String lastname;
    private String email;

    public Person(String firstname, String lastname){
      this.firstname = firstname;
      this.lastname = lastname;
    }

    public void setEmail(String email){
      if (EmailValidator.getInstance().isValid(email)){
        this.email = email;
      }
    }

    public String getEmail(){
      return this.email;
    }

    @Override
    public String toString(){
        return firstname + " " + lastname;
    }

    @Override
    public boolean equals(Object object){

        //handelt es sich und exakt dasselbe Objekt?
        if ( object == this){
            return true;
        }

        //handelt es sich, um keine Instanz der Klasse Person oder einer Klasse, die von Person erbt?
        if (!(object instanceof Person)){
            return false;
        }

        //wenn das Object eine Instanz von der Klasse Person ist, vergleiche die einzelnen Attribute miteinander
        Person person = (Person) object;
        return (this.firstname == person.firstname && this.lastname == person.lastname && person.email == this.email);
    }
}
```

```csharp
// C# 
using System.Net.Mail;

public class Person
{
    private readonly string firstname;
    private readonly string lastname;
    private MailAddress email;

    public Person(string firstname, string lastname)
    {
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public MailAddress Email {
        get{ return this.email; } // Getter des Attributs `email`
        set{ this.email = new MailAddress(value, this.firstname + " " + this.lastname); }
    }

    public override string ToString(){
      return this.firstname + " " + this.lastname;
    }

    public override bool Equals(object obj)
    {
        // If the object is the same instance, return true
        if (Object.ReferenceEquals(this, obj))
        {
            return true;
        }

        // If the object is not a Person or is null, return false
        if (!(obj is Person))
        {
            return false;
        }

        // Cast the object to Person and compare each attribute
        Person person = (Person)obj;
        return firstname == person.firstname && lastname == person.lastname && email == person.email;
    }
}
```


Zurück zur [Startseite](README.md)
