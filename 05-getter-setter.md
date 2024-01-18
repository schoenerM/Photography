# Getter und Setter

Warum sollte man Attribute als private definieren? Es wäre doch einfacher, diese als public zu definieren. So könnte die aufrufende Klasse direkt auf die Attribute zugreifen und diese direkt setzen. 

Das stellt uns vor der Frage, darf immer jeder Inhalt in ein Attribut hinein? Der Inhalt eines Attributs wird ja bereits durch den Datentyp eingeschränkt. Es gibt jedoch viele Fälle, in denen der Wertbereich noch weiter eingeschränkt werden soll. Typische Beispiele sind:
- E-Mailadresse: diese müssen einem bestimmten Format entsprechen.
- PLZ: darf in Österreich nur aus Zahlen bestehen, in England sind aber auch Buchstaben erlaubt
- Vorname, Nachname: dürfen lediglich aus Buchstaben und Bindestriche bestehen
- ...

Manchmal ist es auch so, dass die Änderung eines Attributs, die Änderung eines anderen Attributs bedeutet. 

Genau für solche Fälle, macht es Sinn das entsprechende Attribute als private zu definieren und diesen nur über Konstrukturen oder, wenn diese im Nachgang gesetzt werden dürfen, über einen Setter zu setzen.

## Was ist ein Setter?

Ein Setter ist eine Methode, welche den Wert eines Attributs setzt und vorher einen Plausisbilitätscheck des eingegebenen Wertes macht. Ein anderer Anwendungsfall für ein Setter ist, dass der Setter nicht nur den Wert des entsprechenden Attributs setzt, sondern auch andere Parameter beeinflusst.

Ein Setter, der den Wert einfach setzt, ohne diesen zu prüfen, macht wenig Sinn (Code ohne Mehrwert). In diesem Fall ist es sinnvoll, das Attribut als public, default oder protected zu definieren.

Sie werden fragen, warum der Plausibilitätscheck nicht in der aufrufenden Klasse gemacht werden kann. Der Grund ist der, dass die Klasse, die hier definiert wird, alles selbst beinhalten soll, was zu dem Thema gehört. Sprich, das Attribut gehört zur Klasse, somit gehört der Plausibilitätscheck auch zu dieser Klasse, genauso wie die Verarbeitung der Attribute in Methoden (mehr im nächsten Kapitel).

## Wie definiert man ein Setter?

Grundsätzlich lautet die Regel: Wenn das Attribut **Attribut1** heißt, soll der Setter **set<Attributname>** heißen, also **setAttribut1**. ACHTUNG! Der erste Buchstabe des Attributnamen wird groß geschrieben!

### Java 

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
### C# 

```c#

```

## Was ist ein Getter?

Wenn ein Attribut als private bzw. der AccessModifier nicht public ist und das Attribut muss dennoch öffentlich ausgelesen werden können, steht die Möglichkeit zur Verfügung einen Getter zu verwenden. 

Seine einzige Aufgabe ist eben das Ausgeben des Variablenwertes. 

## Wie definiert man ein Getter?

Ähnlich wie beim Setter gilt die Regel: Wenn das Attribut **Attribut1** heißt, soll der Setter **get<Attributname>** heißen, also **getAttribut1**. ACHTUNG! Der erste Buchstabe des Attributnamen wird groß geschrieben!

### Java 

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

### C# 

```c#

```

> [!IMPORTANT]
> In IntelliJ kannst du dir Getter & Setter durch Drücken von **Alt+Einfg** generieren lassen

## das Schlüsselwort *this*

Wie du aus den bisherigen Beispielen bereits entnehmen konntest, gibt es innerhalb von Klassen ein Schlüsselwort: **this**.

Um es zu erklären, holen wir zunächst ein Bisschen auf. Die Geschichte fängt an mit der Instanzierung eines Objekts mit dem Schlüsselwort **new**. Um dies machen zu können, benötigen wir eine Klasse. Innerhalb dieser Klasse verwenden wir das Schlüsselwort **this** und es ist nichts anderes als eine Referenz auf das Objekt, in dem wir uns gerade befinden.

**this** verwendet man sehr häufig in Setters, da man so den Parameter des Setters so nennen kann, wie das Attribut, das damit gesetzt wird und **this** stellt sicher, dass man wie im obigen Beispiel den Wert des Parameters *email* in das Attribut *email* des Objekts: **this.email** ist das Attribut, **email** ist der Parameter.

Das Schlüsselwort **this** hat auch einen anderen Vorteil: der\*ie Leser\*in erkennt auf einem Blick, dass es sich um das Objekt handelt, in dem das Programm sich befindet. 

Mit ihm kann man alle Attribute, Getter, Setter und Methoden der Klasse aufrufen. Dies erfolgt mit:
- **this.attributname**
- **this.getAttributname()**
- **this.setAttributname()**
- **this.methode()**

[Zurück zur Übersicht](README.md)