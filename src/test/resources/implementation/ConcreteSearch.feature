# language: de
Funktionalität: Suche nach Büchern

  Szenario: Hinzufügen von Büchern zur Suche
    Angenommen folgende Bücher existieren
      | id | name   | authors    | keywords | boughtDate | borrowedTill | timesBorrowed | condition |
      | 1  | Buch A | Max        | a, b     | 01.01.2021 | 01.01.2024   | 5             | GOOD      |
      | 2  | Buch B | Max, Peter | c        | 01.02.2021 | 01.01.2024   | 7             | GOOD      |
      | 3  | Buch C | Peter      | b, c     | 01.03.2021 | 01.01.2024   | 2             | BAD       |
    Wenn alle vorhandenen Bücher zur Suche hinzugefügt werden
    Dann sollten die folgenden Bücher für die Suche verfügbar sein
      | id | name   | authors    | keywords | boughtDate | borrowedTill | timesBorrowed | condition |
      | 1  | Buch A | Max        | a, b     | 01.01.2021 | 01.01.2024   | 5             | GOOD      |
      | 2  | Buch B | Max, Peter | c        | 01.02.2021 | 01.01.2024   | 7             | GOOD      |
      | 3  | Buch C | Peter      | b, c     | 01.03.2021 | 01.01.2024   | 2             | BAD       |

  Szenario: mehrmaliges Hinzufügen von Büchern zur Suche
    Angenommen folgende Bücher existieren
      | id | name   | authors    | keywords | boughtDate | borrowedTill | timesBorrowed | condition |
      | 1  | Buch A | Max        | a, b     | 01.01.2021 | 01.01.2024   | 5             | GOOD      |
      | 2  | Buch B | Max, Peter | c        | 01.02.2021 | 01.01.2024   | 7             | GOOD      |
      | 3  | Buch C | Peter      | b, c     | 01.03.2021 | 01.01.2024   | 2             | BAD       |
    Wenn alle vorhandenen Bücher zur Suche hinzugefügt werden
    Und folgende Bücher existieren
      | id | name   | authors    | keywords | boughtDate | borrowedTill | timesBorrowed | condition |
      | 4  | Buch D | Max        | a, b     | 01.01.2021 | 01.01.2024   | 5             | GOOD      |
      | 5  | Buch E | Max, Peter | c        | 01.02.2021 | 01.01.2024   | 7             | GOOD      |
      | 6  | Buch F | Peter      | b, c     | 01.03.2021 | 01.01.2024   | 2             | BAD       |
    Wenn alle vorhandenen Bücher zur Suche hinzugefügt werden
    Dann sollen die folgenden Bücher für die Suche verfügbar sein
      | id | name   | authors    | keywords | boughtDate | borrowedTill | timesBorrowed | condition |
      | 1  | Buch A | Max        | a, b     | 01.01.2021 | 01.01.2024   | 5             | GOOD      |
      | 2  | Buch B | Max, Peter | c        | 01.02.2021 | 01.01.2024   | 7             | GOOD      |
      | 3  | Buch C | Peter      | b, c     | 01.03.2021 | 01.01.2024   | 2             | BAD       |
      | 4  | Buch D | Max        | a, b     | 01.01.2021 | 01.01.2024   | 5             | GOOD      |
      | 5  | Buch E | Max, Peter | c        | 01.02.2021 | 01.01.2024   | 7             | GOOD      |
      | 6  | Buch F | Peter      | b, c     | 01.03.2021 | 01.01.2024   | 2             | BAD       |

  Szenario: Hinzufügen von Büchern zur Suche mit gleicher ID in einem Schritt
    Angenommen folgende Bücher existieren
      | id | name   | authors    | keywords | boughtDate | borrowedTill | timesBorrowed | condition |
      | 1  | Buch A | Max        | a, b     | 01.01.2021 | 01.01.2024   | 5             | GOOD      |
      | 2  | Buch B | Max, Peter | c        | 01.02.2021 | 01.01.2024   | 7             | GOOD      |
      | 3  | Buch C | Peter      | b, c     | 01.03.2021 | 01.01.2024   | 2             | BAD       |
      | 3  | Buch D | Hans       | b, c     | 07.02.2020 | 01.01.2024   | 15            | BAD       |
    Wenn alle vorhandenen Bücher zur Suche hinzugefügt werden
    Dann soll eine Fehlermeldung ausgegeben werden
    Und es gibt den Fehler, dass ein Buch mit der ID 3 bereits existiert

  Szenario: Hinzufügen von Büchern zur Suche mit gleicher ID in mehreren Schritten
    Angenommen folgende Bücher existieren
      | id | name   | authors    | keywords | boughtDate | borrowedTill | timesBorrowed | condition |
      | 1  | Buch A | Max        | a, b     | 01.01.2021 | 01.01.2024   | 5             | GOOD      |
      | 2  | Buch B | Max, Peter | c        | 01.02.2021 | 01.01.2024   | 7             | GOOD      |
      | 3  | Buch C | Peter      | b, c     | 01.03.2021 | 01.01.2024   | 2             | BAD       |
    Wenn alle vorhandenen Bücher zur Suche hinzugefügt werden
    Und folgende Bücher existieren
      | id | name   | authors | keywords | boughtDate | borrowedTill | timesBorrowed | condition |
      | 3  | Buch C | Peter   | b, c     | 01.03.2021 | 01.01.2024   | 2             | BAD       |
    Wenn alle vorhandenen Bücher zur Suche hinzugefügt werden
    Dann soll eine Fehlermeldung ausgegeben werden
    Und es gibt den Fehler, dass ein Buch mit der ID 3 bereits existiert

  Szenario: Hinzufügen von keinen Büchern zur Suche
    Angenommen es gibt keine Bücher
    Dann sollen in der Suche keine Bücher vorhanden sein

  Szenario: Buch anhand ID abrufen
    Angenommen folgende Bücher existieren
      | id | name   | authors    | keywords | boughtDate | borrowedTill | timesBorrowed | condition |
      | 1  | Buch A | Max        | a, b     | 01.01.2021 | 01.01.2024   | 5             | GOOD      |
      | 2  | Buch B | Max, Peter | c        | 01.02.2021 |              | 7             | GOOD      |
      | 3  | Buch C | Peter      | b, c     | 01.03.2021 | 01.01.2024   | 2             | BAD       |
    Wenn alle vorhandenen Bücher zur Suche hinzugefügt werden
    Und ein Buch mit der ID 2 angefordert wird
    Dann soll folgendes Buch zurückgegeben werden
      | id | name   | authors    | keywords | boughtDate | borrowedTill | timesBorrowed | condition |
      | 2  | Buch B | Max, Peter | c        | 01.02.2021 |              | 7             | GOOD      |

  Szenario: Buch mit ungültiger ID abrufen
    Angenommen folgende Bücher existieren
      | id | name   | authors    | keywords | boughtDate | borrowedTill | timesBorrowed | condition |
      | 1  | Buch A | Max        | a, b     | 01.01.2021 | 01.01.2024   | 5             | GOOD      |
      | 2  | Buch B | Max, Peter | c        | 01.02.2021 | 01.01.2024   | 7             | GOOD      |
      | 3  | Buch C | Peter      | b, c     | 01.03.2021 | 01.01.2024   | 2             | BAD       |
    Wenn ein Buch mit der ID 4 angefordert wird
    Dann soll kein Buch zurückgegeben werden

  Szenario: Suchparameter in der Suche erstellen
    Angenommen wir haben folgende Werte für den Suchparameter
      | name                                   | authors       | keywords | borrowed | borrowedAfter | boughtBefore | boughtAfter | minTimesBorrowed | maxTimesBorrowed | acceptableConditions |
      | Der Osten: eine westdeutsche Erfindung | Dirk Oschmann | Osten    | false    | 23.02.2023    | 30.05.2022   | 23.02.2020  | 2                | 5                | BROKEN               |
      | Wie die Saat, so die Ernte             | Donna Leon    | Westen   |          |               |              |             |                  |                  | BAD                  |
      |                                        |               | Saat     |          |               |              |             |                  |                  |                      |
      |                                        |               | Ernte    |          |               |              |             |                  |                  |                      |
    Wenn der Suchparameter erstellt wird
    Dann soll der Suchparameter für die Suche folgende Werte enthalten
      | name                                   | authors       | keywords | borrowed | borrowedAfter | boughtBefore | boughtAfter | minTimesBorrowed | maxTimesBorrowed | acceptableConditions |
      | Der Osten: eine westdeutsche Erfindung | Dirk Oschmann | Osten    | false    | 23.02.2023    | 30.05.2022   | 23.02.2020  | 2                | 5                | BROKEN               |
      | Wie die Saat, so die Ernte             | Donna Leon    | Westen   |          |               |              |             |                  |                  | BAD                  |
      |                                        |               | Saat     |          |               |              |             |                  |                  |                      |
      |                                        |               | Ernte    |          |               |              |             |                  |                  |                      |

  Szenario: Suche nach Büchern anhand Suchparametern
    Angenommen folgende Bücher existieren
      | id | name   | authors    | keywords | boughtDate | borrowedTill | timesBorrowed | condition |
      | 1  | Buch A | Max        | a, b     | 01.01.2021 | 01.01.2024   | 5             | GOOD      |
      | 2  | Buch B | Max, Peter | c        | 01.02.2021 | 01.01.2024   | 7             | GOOD      |
      | 3  | Buch C | Peter      | b, c     | 01.03.2021 | 01.01.2024   | 2             | BAD       |
    Und wir haben folgende Werte für den Suchparameter
      | name   | authors | keywords | borrowed | borrowedAfter | boughtBefore | boughtAfter | minTimesBorrowed | maxTimesBorrowed | acceptableConditions |
      | Buch B | Max     | c        | true     | 01.01.2020    | 01.01.2022   | 01.01.2020  | 5                | 10               | GOOD                 |
      |        |         |          |          |               |              |             |                  |                  | BAD                  |
    Wenn eine Suche mit den gegebenen Parametern durchgeführt wird
    Dann sollen folgende Bücher gefunden werden
      | id | name   | authors    | keywords | boughtDate | borrowedTill | timesBorrowed | condition |
      | 2  | Buch B | Max, Peter | c        | 01.02.2021 | 01.01.2024   | 7             | GOOD      |


  Szenario: Suche nach Büchern anhand von Suchparametern ALT
    Angenommen folgende Bücher existieren
      | id | name   | authors    | keywords | boughtDate | borrowedTill | timesBorrowed | condition |
      | 1  | Buch A | Max        | a, b     | 01.01.2021 | 01.01.2024   | 5             | GOOD      |
      | 2  | Buch B | Max, Peter | c        | 01.02.2021 | 01.01.2024   | 7             | GOOD      |
      | 3  | Buch C | Peter      | b, c     | 01.03.2021 | 01.01.2024   | 2             | BAD       |
    Wenn eine Suche mit dem folgenden Parametern durchgeführt wird
      | name   | authors | keywords | isBorrowed | borrowedAfterDate | boughtAfterDate | boughtBeforeDate | minBorrowCount | maxBorrowCount | conditionList |
      | Buch B | Max     | c        | true       | 01.01.2020        | 01.01.2020      | 01.01.2020       | 5              | 10             | GOOD,NEW      |
    Dann sollen folgende Bücher gefunden werden
      | id | name   | authors    | keywords | boughtDate | borrowedTill | timesBorrowed | condition |
      | 2  | Buch B | Max, Peter | c        | 01.02.2021 | 01.01.2024   | 7             | GOOD      |

  Szenario: Suche nach Büchern mit Zeitüberschreitung
    Angenommen folgende Bücher existieren
      | id | name   | authors    | keywords | boughtDate | borrowedTill | timesBorrowed | condition |
      | 1  | Buch A | Max        | a, b     | 01.01.2021 | 01.01.2024   | 5             | GOOD      |
      | 2  | Buch B | Max, Peter | c        | 01.02.2021 | 01.01.2024   | 7             | GOOD      |
      | 3  | Buch C | Peter      | b, c     | 01.03.2021 | 01.01.2024   | 2             | BAD       |
    Wenn eine Suche mit dem folgenden Parametern durchgeführt wird
      | name | authors | keywords | borrowed | isBorrowed | borrowedAfterDate | boughtAfterDate | boughtBeforeDate | minBorrowCount | maxBorrowCount | conditionList |
      |      | Simon   |          |          |            |                   |                 |                  |                |                |               |
    Dann sollte eine TimeLimitExceededException geworfen werden

  Szenario: Erstellen eines Suchparameters
    Wenn ein Suchparameter erstellt wird
    Dann sollte eine Instanz von SearchParameter.Builder zurückgegeben werden

    # TODO Nochmal überarbeiten, sodass dieser Testfall mehr Sinn ergibt
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
