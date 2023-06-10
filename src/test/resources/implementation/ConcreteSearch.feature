# language: de
Funktionalität: Suche nach Büchern

  Hintergrund:
  Angenommen eine Instanz von ConcreteSearch existiert

  Szenario: Peter sucht nach dem Buch mit dem Titel "Beispieltitel"
    Angenommen wir haben ein Buch mit dem Titel "Beispieltitel"
    Und das Buch wurde noch nicht verliehen
    Dann soll er sich das Buch ausleihen können

  Szenario: Marvin such nach dem Buch mit dem Titel "Hallo"
    Angenommen wir haben ein Buch mit dem Titel "Hallo"
    Und das Buch wurde bereits verliehen
    Dann soll er sich das Buch nicht ausleihen können

  Szenario: Hinzufügen von Büchern zur Suche
    Angenommen es werden existierende folgende Bücher
    Wenn Bücher zur Suche hinzugefügt werden
    Dann sollten die Bücher für die Suche verfügbar sein

  Szenario: Buch anhand ID abrufen
    Angenommen ein Buch mit der ID {id} existiert
    Wenn ein Buch mit der ID {id} angefordert wird
    Dann sollte das Buch mit der ID {id} zurückgegeben werden

  Szenario: Buch mit ungültiger ID abrufen
    Wenn ein Buch mit der ID {id} angefordert wird
    Dann sollte null zurückgegeben werden für eine nicht vorhandene Buch-ID

  Szenario: Suche nach Büchern anhand von Suchparametern
    Angenommen folgende Bücher existieren
      | id | name   | authors | keywords     | boughtDate | timesBorrowed | condition |
      | 1  | Buch A | Autor A | Keyword A    | 2021-01-01 | 5             | GOOD      |
      | 2  | Buch B | Autor B | Keyword B    | 2021-02-01 | 7             | GOOD      |
      | 3  | Buch C | Autor C | Keyword A, B | 2021-03-01 | 2             | BAD       |
    Wenn eine Suche mit dem Parameter durchgeführt wird
      | Suchbegriff |
      | Keyword A   |
    Dann sollten die folgenden Bücher gefunden werden
      | id | name   | authors | keywords     | boughtDate | timesBorrowed | condition |
      | 1  | Buch A | Autor A | Keyword A    | 2021-01-01 | 5             | GOOD      |
      | 3  | Buch C | Autor C | Keyword A, B | 2021-03-01 | 2             | BAD       |

  Szenario: Suche nach Büchern mit Zeitüberschreitung
    Angenommen folgende Bücher existieren
      | id | name   | authors | keywords     | boughtDate | timesBorrowed | condition |
      | 1  | Buch A | Autor A | Keyword A    | 2021-01-01 | 5             | GOOD      |
      | 2  | Buch B | Autor B | Keyword B    | 2021-02-01 | 7             | GOOD      |
      | 3  | Buch C | Autor C | Keyword A, B | 2021-03-01 | 2             | BAD       |
    Wenn eine Suche mit dem Parameter durchgeführt wird:
      | Suchbegriff |
      | Keyword Z   |
    Dann sollte eine TimeLimitExceededException geworfen werden

  Szenario: Erstellen eines Suchparameters
    Wenn ein Suchparameter erstellt wird
    Dann sollte eine Instanz von SearchParameter.Builder zurückgegeben werden

  Szenario: Anzeigen der Suchhistorie
    Angenommen folgende Suchhistorie existiert:
      | Suchbegriff | Gefundene Bücher |
      | Keyword A   | Buch A           |
      | Keyword B   | Buch B           |
    Wenn die Suchhistorie angezeigt wird
    Dann sollte die Suchhistorie zurückgegeben werden
      | Suchbegriff | Gefundene Bücher |
      | Keyword A   | Buch A           |
      | Keyword B   | Buch B           |