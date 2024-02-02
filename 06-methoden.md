# Methoden

Methoden haben wir bereits in einem früheren Kapitel gelernt. Zu diesem Zeitpunkt hast du aber noch nicht gewusst, dass wir immer in Klassen arbeiten, wenn wir programmieren. Das ganze Wissen, das du bisher erworben hast, ist weiterhin gültig. Dieses Wissen erweitern wir jetzt.

Wie schon erwähnt, wenn du eine Klasse deklarierst, erbt diese Klasse automatisch von der "Urklasse" Object. Das Thema Vererbung schauen wir uns in einem späteren Kapitel im Detail an. Hier konzentrieren wir uns lediglich auf einige Methoden, welche von der Klasse Object vererbt werden.

Die Klasse Object beinhaltet u.a. folgende Methoden:
- **toString()**: wird aufgerufen, um das Objekt in ein String zu verwandeln, z.B. in einer Consolenausgabe. Standardmäßig liefert diese Methode die Speicheradresse, der in der Instanzvariable gespeichert ist.
- **equals()**: wird aufgerufen, wenn 2 Objekte miteinander verglichen werden sollen. Diese Methode definiert, wie der Vergleich erfolgen soll.

Das bedeutet, dass diese Methoden in jedem Objekt bereitstehen. Bei der Vererbung besteht die Möglichkeit diese Methode zu überschreiben. Der Sinn dahinter ist:
- bei der **toString()**-Methode ist es oft nicht zielführend, die Speicheradresse auszugeben. Es kann durchaus sinnvoller sein, einige der oder alle Daten im Objekt textuell auszugeben. 
- bei der **equals()**-Methode könnte man definieren, wie der Vergleiche zweier Objekte derselben Klasse miteinander verglichen werden sollen.

## Die Methode toString()

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

    @Override
    public String toString(){
        return firstname + " " + lastname;
    }
}
```

### C# 

```c#

```

Hier liefert die toString-Methode statt der Speicheradresse Daten aus dem Objekt: Vor- und Nachname. Das Überschreiben erfolgt durch die Annotation **@Override** oberhalb der Methodendeklaration. Diese Annotation verhindert, dass ein Fehler beim Kompilieren entsteht, weil 2 Methoden dieselbe Signatur haben.

## Die Methode equals()

In der Methode **equals()** ist definiert, wie 2 Objekte von derselben Klasse (oder einer von dieser Klasse vererbten Klasse) miteinander verglichen werden sollen. 

Aber wozu eine equals()-Methode, wenn es doch den Gleichheitsoperator "**==**" gibt?

Der Gleichheitsoperator ist gut geeignet, um Variablen von primitiven Datentypen bzw. Strings miteinander zu vergleichen. Sollen aber 2 Objekte miteinander verglichen werden, bezieht sich der Operator "**==**" aber auf die Adresse auf den Speicherplatz, die in der Variable gespeichert ist. Es stellt sich also die Frage, was man möchte:
- möchte ich herausfinden, ob es sich um ein und dasselbe Objekt handelt. In diesem Falle ist "**==**" gut geeignet
- möchte man aber herausfinden, ob der Inhalt derselbe ist, ist "**==**" nicht geeignet.

So wurde die Methode **equals()** für Objekte definiert, um diesen Anwendungsfall abzudecken.

In unserem obigen Beispiel könnten wir die Klasse folgendermaßen erweitern:

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

        //handelt es sich, um eine Instanz der Klasse Person oder einer Klasse, die von Person erbt?
        if (!(object instanceof Person)){
            return false;
        }

        //wenn das Object eine Instanz von der Klasse Person ist, vergleiche die einzelnen Attribute miteinander
        Person person = (Person) object;
        return (this.firstname == person.firstname && this.lastname == person.lastname && person.email == this.email);
    }
}
```

### C# 

```c#

```


Zurück zur [Startseite](README.md)
