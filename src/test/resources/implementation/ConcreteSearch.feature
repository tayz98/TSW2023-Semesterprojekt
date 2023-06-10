# language: de
Funktionalität: Suche nach Büchern

# TODO: Brauchen wir die?
"""
  Szenario: Peter sucht nach dem Buch mit dem Titel "Beispieltitel"
    Angenommen wir haben ein Buch mit dem Titel "Beispieltitel"
    Und das Buch wurde noch nicht verliehen
    Dann soll er sich das Buch ausleihen können

  Szenario: Marvin such nach dem Buch mit dem Titel "Hallo"
    Angenommen wir haben ein Buch mit dem Titel "Hallo"
    Und das Buch wurde bereits verliehen
    Dann soll er sich das Buch nicht ausleihen können
"""

  Szenario: Hinzufügen von Büchern zur Suche
    Angenommen folgende Bücher existieren
      | id | name   | authors   | keywords | boughtDate | borrowedTill | timesBorrowed | condition |
      | 1  | Buch A | Max       | a,b      | 2021-01-01 | 2024-01-01   | 5             | GOOD      |
      | 2  | Buch B | Max,Peter | c        | 2021-02-01 | 2024-01-01   | 7             | GOOD      |
      | 3  | Buch C | Peter     | b,c      | 2021-03-01 | 2024-01-01   | 2             | BAD       |
    Wenn alle vorhandenen Bücher zur Suche hinzugefügt werden
    Dann sollten die folgenden Bücher für die Suche verfügbar sein
      | id | name   | authors   | keywords | boughtDate | borrowedTill | timesBorrowed | condition |
      | 1  | Buch A | Max       | a,b      | 2021-01-01 | 2024-01-01   | 5             | GOOD      |
      | 2  | Buch B | Max,Peter | c        | 2021-02-01 | 2024-01-01   | 7             | GOOD      |
      | 3  | Buch C | Peter     | b,c      | 2021-03-01 | 2024-01-01   | 2             | BAD       |

  Szenario: Buch anhand ID abrufen
    Angenommen folgende Bücher existieren
      | id | name   | authors   | keywords | boughtDate | borrowedTill | timesBorrowed | condition |
      | 1  | Buch A | Max       | a,b      | 2021-01-01 | 2024-01-01   | 5             | GOOD      |
      | 2  | Buch B | Max,Peter | c        | 2021-02-01 | 2024-01-01   | 7             | GOOD      |
      | 3  | Buch C | Peter     | b,c      | 2021-03-01 | 2024-01-01   | 2             | BAD       |
    Wenn alle vorhandenen Bücher zur Suche hinzugefügt werden
    Und ein Buch mit der ID 2 angefordert wird
    Dann sollte das Buch mit der ID 2 zurückgegeben werden

  Szenario: Buch mit ungültiger ID abrufen
    Wenn ein Buch mit der ID 0 angefordert wird
    Dann sollte null zurückgegeben werden für eine nicht vorhandene Buch-ID

  Szenario: Suche nach Büchern anhand von Suchparametern
    Angenommen folgende Bücher existieren
      | id | name   | authors   | keywords | boughtDate | borrowedTill | timesBorrowed | condition |
      | 1  | Buch A | Max       | a,b      | 2021-01-01 | 2024-01-01   | 5             | GOOD      |
      | 2  | Buch B | Max,Peter | c        | 2021-02-01 | 2024-01-01   | 7             | GOOD      |
      | 3  | Buch C | Peter     | b,c      | 2021-03-01 | 2024-01-01   | 2             | BAD       |
    Wenn eine Suche mit dem folgenden Parametern durchgeführt wird
      | names | authors | keywords | isBorrowed | borrowedAfterDate | boughtAfterDate | boughtBeforeDate | minBorrowCount | maxBorrowCount | conditionList |
      |       | Max     | c        |            |                   |                 |                  |                |                |               |
    Dann sollten die folgenden Bücher gefunden werden
      | id | name   | authors   | keywords | boughtDate | borrowedTill | timesBorrowed | condition |
      | 2  | Buch B | Max,Peter | c        | 2021-02-01 | 2024-01-01   | 7             | GOOD      |

  Szenario: Suche nach Büchern mit Zeitüberschreitung
    Angenommen folgende Bücher existieren
      | id | name   | authors   | keywords | boughtDate | borrowedTill | timesBorrowed | condition |
      | 1  | Buch A | Max       | a,b      | 2021-01-01 | 2024-01-01   | 5             | GOOD      |
      | 2  | Buch B | Max,Peter | c        | 2021-02-01 | 2024-01-01   | 7             | GOOD      |
      | 3  | Buch C | Peter     | b,c      | 2021-03-01 | 2024-01-01   | 2             | BAD       |
    Wenn eine Suche mit dem folgenden Parametern durchgeführt wird
      | names | authors | keywords | borrowed | isBorrowed | borrowedAfterDate | boughtAfterDate | boughtBeforeDate | minBorrowCount | maxBorrowCount | conditionList |
      |       | Simon   |          |          |            |                   |                 |                  |                |                |               |
    Dann sollte eine TimeLimitExceededException geworfen werden

  Szenario: Erstellen eines Suchparameters
    Wenn ein Suchparameter erstellt wird
    Dann sollte eine Instanz von SearchParameter.Builder zurückgegeben werden

    # TODO Überarbeiten
  """
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
    """