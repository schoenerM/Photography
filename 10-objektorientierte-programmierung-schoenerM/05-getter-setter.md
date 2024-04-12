# Getter und Setter

In den letzten Beispielen sind alle Attribute immer als `private` definiert. Also sind diese nur innerhalb der Klasse erreichbar.

Warum sollte man Attribute als `private` definieren? Es wäre doch einfacher, diese als public zu definieren. So könnte die aufrufende Klasse direkt auf die Attribute zugreifen und diese direkt setzen. 

Wir stehen vor der Frage, darf immer jeder Inhalt in ein Attribut hinein? 

Der Inhalt eines Attributs wird ja bereits durch den Datentyp eingeschränkt. Es gibt jedoch viele Fälle, in denen der Wertebereich noch weiter eingeschränkt werden soll. 

Typische Beispiele sind:
- E-Mailadresse: diese müssen einem bestimmten Format entsprechen.
- PLZ: darf in Österreich nur aus Zahlen bestehen, in England sind aber auch Buchstaben erlaubt
- Vorname, Nachname: dürfen lediglich aus Buchstaben, Leerzeichen und Bindestriche bestehen
- ...

Manchmal ist es auch so, dass die Änderung eines Attributs, die Änderung eines anderen Attributs notwendig macht. 

Genau für solche Fälle, macht es Sinn das entsprechende Attribute als private zu definieren und diesen nur über `Konstrukturen` oder, wenn diese im Nachgang gesetzt werden dürfen, über einen `Setter` zu setzen.

## Was ist ein Setter?

Ein `Setter` ist eine Methode, welche den Wert eines Attributs setzt und vorher einen Plausisbilitätscheck (entspricht der übergebene Wert den Regeln für dieses Attributs) des eingegebenen Wertes macht. 

Ein anderer Anwendungsfall für ein Setter ist, dass der Setter nicht nur den Wert des entsprechenden Attributs setzt, sondern auch andere Parameter beeinflusst.

Ein Setter, der den Wert einfach setzt, ohne diesen zu prüfen, macht wenig Sinn (Code ohne Mehrwert). In diesem Fall kann es sinnvoll, das Attribut als public, default oder protected zu definieren. 

Ob man Attribute immer `private` definiert und immer einen Setter schreibt oder jene Attribute, die kein Plausibilitätscheck oder andere Verarbeitung im Setter benötigen als z.B. public gesetzt werden dürfen ist eher eine philosophische Diskussion und hängt meist von einer Coding Convention in der eigenen Firma ab. 

In der CODERS.BAY definieren wir, dass alle Attribute als `private` definiert werden sollen.

Sie werden fragen, warum der Plausibilitätscheck nicht in der aufrufenden Klasse gemacht werden kann. Der Grund ist der, dass die Klasse, die hier definiert wird, alles selbst beinhalten soll, was zu dem Thema gehört. Das Attribut gehört zur Klasse, somit gehört der Plausibilitätscheck auch zu dieser Klasse, genauso wie die Verarbeitung der Attribute in Methoden (mehr im nächsten Kapitel). 

## Wie definiert man einen Setter?

Die Coding Conventions in Java und C# unterscheiden sich hier:

In Java lautet die Regel: der Setter soll `set<Attributname>` heißen. Also wenn das Attribut `firstname` heißt, soll der Setter `setFirstname` heißen. ACHTUNG! Der erste Buchstabe des Attributnamen wird groß geschrieben, also wieder CamelCase!

```Java
import org.apache.commons.validator.routines.EmailValidator;

public class Person{
    private final String firstname;
    private final String lastname;
    private String email;

    public Person(String firstname, String lastname){
      this.firstname = firstname;
      this.lastname = lastname;
    }

    public setEmail(String email){
      if (EmailValidator.getInstance().isValid(email)){
        this.email = email;
      }
    }
}
```

In C# lautet die Regel anders: wenn das Attribut `email` heißt, wird der Setter mit einem neuen Attribut `Email` definiert, der einen Block `set` beinhaltet. Das folgende Beispiel erklärt dies deutlicher:

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
        set{ email = new MailAddress(value, firstname + " " + lastname); } // Setter des Attributs `email`
    }
}
```

In diesem Beispiel haben wir ein Attribut `email`. Dessen Wert wird durch den Setter `Email` gesetzt. Ein wesentlicher Unterschied zu Java ist, dass hier der übergebene Wert immer `value` lautet. 

Der Setter stellt durch die Erstellung einer Instanz der Klasse `MailAddress` mit dem Wert `value` sicher, dass sich darin eine gültige Email-Adresse befindet.

## Was ist ein Getter?

Wenn ein Attribut als private bzw. der AccessModifier nicht public ist und das Attribut muss dennoch öffentlich ausgelesen werden können, verwendet man einen Getter. 

Seine einzige Aufgabe ist das Ausgeben des Variablenwertes. 

## Wie definiert man ein Getter?

Ähnlich wie beim Setter gilt in Java die Regel: Der Getter soll `get<Attributname>` lauten. Also wenn das Attribut `firstname` heißt, soll der Getter `getFirstname` heißen. ACHTUNG! Der erste Buchstabe des Attributnamen wird groß geschrieben!

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
}
```

Wie für den Setter wird der Getter des Attributs `email` in C# durch den Block `get` im Attribut `Email` definiert.

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
}
```

> [!IMPORTANT]
> In IntelliJ kannst du dir Getter & Setter durch Drücken von `Alt+Einfg` generieren lassen

## Das Schlüsselwort `this`

Wie man aus den bisherigen Beispielen bereits entnehmen kann, gibt es innerhalb von Java-Klassen ein Schlüsselwort: `this`.

Um es zu erklären, holen wir zunächst ein Bisschen auf. Die Geschichte fängt an mit der Instanzierung eines Objekts mit dem Schlüsselwort `new`. Um dies machen zu können, benötigen wir eine Klasse. Innerhalb dieser Klasse verwenden wir das Schlüsselwort `this` und es ist nichts anderes als eine Referenz auf das Objekt, in dem wir uns gerade befinden.

`this` verwendet man sehr häufig in Setters, da man so den Parameter des Setters so nennen kann, wie das Attribut selbst, das damit gesetzt wird. `this` stellt hier sicher, dass man wie im obigen Beispiel den Wert des Parameters `email` in das Attribut `email` des Objekts: `this.email` ist das Attribut, `email` ist der übergebene Parameter.

Das Schlüsselwort `this` hat auch einen anderen Vorteil: der:ie Leser:in erkennt auf einem Blick, dass es sich um die aktuelle Instanz der Klasse handelt. 

Mit ihm kann man alle Attribute, Getter, Setter und Methoden der Klasse aufrufen. Dies erfolgt mit:
- `this.attributname`
- `this.getAttributname()`
- `this.setAttributname()`
- `this.methode()`

[Zurück zur Übersicht](README.md)