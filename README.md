# FSE-Test 1

Git, Maven, Mikroarchitektur

## 1) Gegeben
Gegeben ist eine Applikation, die Benutzer-Login-Daten (Credentials) exportieren kann. 

Repository-URL der Applikation: https://github.com/clander/credentialstesting

## 2) Funktionale Anforderungen
Die bestehende Applikation ist mit der Zusatzfunktionalität zum Export der Benutzer-Login-Daten mit Passwort-Hash anstelle des Passworts in Klartext zu erweitern.

## 3) Nicht-Funktionale Anforderungen
### 3.1) Decorator-Pattern
Die Erweiterung muss unter Verwendung des Decorator-Patterns erfolgen.

https://de.wikipedia.org/wiki/Decorator

Die bestehende Applikation darf nicht verändert werden. 

Die Anwendung des Hashing-Decorators muss in der Main-Methode demonstriert werden.

### 3.2) Hashing-Algorithmus / Hashing Bibliothek
Als Hashing-Bibliothek muss folgende Bibliothek zum Einsatz kommen:

```xml
<dependency>
    <groupId>com.google.guava</groupId>
    <artifactId>guava</artifactId>
    <version>31.0.1-jre</version>
</dependency>
```

Als Hasing-Algorithmus muss SHA256 zum Einsatz kommen. Die Verwendung sieht wie folgt aus:

```java
String sha256hex = Hashing.sha256()
.hashString(originalString, StandardCharsets.UTF_8)
.toString();
```

### 3.3) Dokumentation
Alle neu erstellen Klassen und Methoden müssen mit JavaDoc-Kommentaren und sinnvollen Kommentaren an wichtigen Codestellen dokumentiert werden.

### 3.4) Git
Der gesamte Entwicklungsprozess muss unter Verwendung von Git und GitHub begleitet werden. 

#### Laufende Arbeit
- Jeder Kandidat / jede Kandidatin meldet sich auf GitHub an und forked das Ausgangsprojekt in ein eigenes Repo: https://docs.github.com/en/get-started/quickstart/fork-a-repo#forking-a-repository
- Dann wird der Fork für die lokale Bearbeitung geklont: https://docs.github.com/en/get-started/quickstart/fork-a-repo#cloning-your-forked-repository.
- Danach beginnt die Arbeit bezüglich Implementierung des Decorator-Patterns. 
    - Zur Dokumentation des Entwidcklungsprozesses sind laufend Commits durchzuführen. Laufend bedeutet zumindest nach jeder Teilimplementierung für das Muster (z.B nach jeder Klassenimplementierung).
    - Zur Sicherung des Fortschritts sind laufend Pushes auf das eigene Remote-GitHub-Repo durchzuführen.

#### Abgabe
- Am Ende des Tests wird ein finaler Push in das eigene Remote-Repo durchgeführt.
- Dann folgt ein Pull-Request auf das Ausgangsrepo https://github.com/clander/credentialstesting
    - Beim Erstellen des Pull-Requests ist als Zielbranch im Target-Repository der Branch mit deinem Namen des Kandidaten zu wählen. 
    - Dieser Pull-Request gilt als Testabgabe. 

Hinweis: Ein kurzes Video zu Forking und Pull-Requests gibt es hier: https://www.youtube.com/watch?v=nT8KGYVurIU
