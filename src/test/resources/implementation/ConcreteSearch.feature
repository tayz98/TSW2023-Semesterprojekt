# language: de
Funktionalität: Suche nach Büchern

  Szenario: Hinzufügen von Büchern zur Suche
    Angenommen folgende Bücher existieren
      | id | name                                | authors                        | keywords                     | boughtDate | borrowedTill | timesBorrowed | condition |
      | 1  | Atlas - Die Geschichten von Pa Salt | Harry Whittaker, Lucinda Riley | Atlas, Pa, Salt, Geschichten | 01.01.2021 | 01.01.2024   | 5             | GOOD      |
      | 2  | Das Cafe ohne Namen                 | Robert Seethaler               | Cafe, Namen                  | 01.02.2021 | 01.01.2024   | 7             | GOOD      |
      | 3  | Wie die Saat, so die Ernte          | Donna Leon                     | Saat, Ernte                  | 01.03.2021 | 01.01.2024   | 2             | BAD       |
    Wenn alle vorhandenen Bücher zur Suche hinzugefügt werden
    Dann sollten die folgenden Bücher für die Suche verfügbar sein
      | id | name                                | authors                        | keywords                     | boughtDate | borrowedTill | timesBorrowed | condition |
      | 1  | Atlas - Die Geschichten von Pa Salt | Harry Whittaker, Lucinda Riley | Atlas, Pa, Salt, Geschichten | 01.01.2021 | 01.01.2024   | 5             | GOOD      |
      | 2  | Das Cafe ohne Namen                 | Robert Seethaler               | Cafe, Namen                  | 01.02.2021 | 01.01.2024   | 7             | GOOD      |
      | 3  | Wie die Saat, so die Ernte          | Donna Leon                     | Saat, Ernte                  | 01.03.2021 | 01.01.2024   | 2             | BAD       |

  Szenario: mehrmaliges Hinzufügen von Büchern zur Suche
    Angenommen folgende Bücher existieren
      | id | name                                | authors                        | keywords                     | boughtDate | borrowedTill | timesBorrowed | condition |
      | 1  | Atlas - Die Geschichten von Pa Salt | Harry Whittaker, Lucinda Riley | Atlas, Pa, Salt, Geschichten | 01.01.2021 | 01.01.2024   | 5             | GOOD      |
      | 2  | Das Cafe ohne Namen                 | Robert Seethaler               | Cafe, Namen                  | 01.02.2021 | 01.01.2024   | 7             | GOOD      |
      | 3  | Wie die Saat, so die Ernte          | Donna Leon                     | Saat, Ernte                  | 01.03.2021 | 01.01.2024   | 2             | BAD       |
    Wenn alle vorhandenen Bücher zur Suche hinzugefügt werden
    Und folgende Bücher existieren
      | id | name                      | authors       | keywords           | boughtDate | borrowedTill | timesBorrowed | condition |
      | 4  | Melody                    | Martin Suter  | Melody             | 01.01.2021 | 01.01.2024   | 5             | GOOD      |
      | 5  | Die Liebe an miesen Tagen | Ewald Arenz   | Liebe, Tagen, mies | 01.02.2021 | 01.01.2024   | 7             | GOOD      |
      | 6  | Eine Frage der Chemie     | Bonnie Garmus | Frage, Chemie      | 01.03.2021 | 01.01.2024   | 2             | BAD       |
    Wenn alle vorhandenen Bücher zur Suche hinzugefügt werden
    Dann sollen die folgenden Bücher für die Suche verfügbar sein
      | id | name                                | authors                        | keywords                     | boughtDate | borrowedTill | timesBorrowed | condition |
      | 1  | Atlas - Die Geschichten von Pa Salt | Harry Whittaker, Lucinda Riley | Atlas, Pa, Salt, Geschichten | 01.01.2021 | 01.01.2024   | 5             | GOOD      |
      | 2  | Das Cafe ohne Namen                 | Robert Seethaler               | Cafe, Namen                  | 01.02.2021 | 01.01.2024   | 7             | GOOD      |
      | 3  | Wie die Saat, so die Ernte          | Donna Leon                     | Saat, Ernte                  | 01.03.2021 | 01.01.2024   | 2             | BAD       |
      | 4  | Melody                              | Martin Suter                   | Melody                       | 01.01.2021 | 01.01.2024   | 5             | GOOD      |
      | 5  | Die Liebe an miesen Tagen           | Ewald Arenz                    | Liebe, Tagen, mies           | 01.02.2021 | 01.01.2024   | 7             | GOOD      |
      | 6  | Eine Frage der Chemie               | Bonnie Garmus                  | Frage, Chemie                | 01.03.2021 | 01.01.2024   | 2             | BAD       |

  Szenario: Hinzufügen von Büchern zur Suche mit gleicher ID in einem Schritt
    Angenommen folgende Bücher existieren
      | id | name                                | authors                        | keywords                     | boughtDate | borrowedTill | timesBorrowed | condition |
      | 1  | Atlas - Die Geschichten von Pa Salt | Harry Whittaker, Lucinda Riley | Atlas, Pa, Salt, Geschichten | 01.01.2021 | 01.01.2024   | 5             | GOOD      |
      | 2  | Das Cafe ohne Namen                 | Robert Seethaler               | Cafe, Namen                  | 01.02.2021 | 01.01.2024   | 7             | GOOD      |
      | 3  | Wie die Saat, so die Ernte          | Donna Leon                     | Saat, Ernte                  | 01.03.2021 | 01.01.2024   | 2             | BAD       |
      | 3  | Wie die Saat, so die Ernte          | Donna Leon                     | Saat, Ernte                  | 01.03.2021 | 01.01.2024   | 2             | BAD       |
    Wenn alle vorhandenen Bücher zur Suche hinzugefügt werden
    Dann soll eine Fehlermeldung ausgegeben werden
    Und es gibt den Fehler, dass ein Buch mit der ID 3 bereits existiert

  Szenario: Hinzufügen von Büchern zur Suche mit gleicher ID in mehreren Schritten
    Angenommen folgende Bücher existieren
      | id | name                                | authors                        | keywords                     | boughtDate | borrowedTill | timesBorrowed | condition |
      | 1  | Atlas - Die Geschichten von Pa Salt | Harry Whittaker, Lucinda Riley | Atlas, Pa, Salt, Geschichten | 01.01.2021 | 01.01.2024   | 5             | GOOD      |
      | 2  | Das Cafe ohne Namen                 | Robert Seethaler               | Cafe, Namen                  | 01.02.2021 | 01.01.2024   | 7             | GOOD      |
      | 3  | Wie die Saat, so die Ernte          | Donna Leon                     | Saat, Ernte                  | 01.03.2021 | 01.01.2024   | 2             | BAD       |
    Wenn alle vorhandenen Bücher zur Suche hinzugefügt werden
    Und folgende Bücher existieren
      | id | name                       | authors    | keywords    | boughtDate | borrowedTill | timesBorrowed | condition |
      | 3  | Wie die Saat, so die Ernte | Donna Leon | Saat, Ernte | 01.03.2021 | 01.01.2024   | 2             | BAD       |
    Wenn alle vorhandenen Bücher zur Suche hinzugefügt werden
    Dann soll eine Fehlermeldung ausgegeben werden
    Und es gibt den Fehler, dass ein Buch mit der ID 3 bereits existiert

  Szenario: Hinzufügen von keinen Büchern zur Suche
    Angenommen es gibt keine Bücher
    Dann sollen in der Suche keine Bücher vorhanden sein

  Szenario: Buch anhand ID abrufen
    Angenommen folgende Bücher existieren
      | id | name                                | authors                        | keywords                     | boughtDate | borrowedTill | timesBorrowed | condition |
      | 1  | Atlas - Die Geschichten von Pa Salt | Harry Whittaker, Lucinda Riley | Atlas, Pa, Salt, Geschichten | 01.01.2021 | 01.01.2024   | 5             | GOOD      |
      | 2  | Das Cafe ohne Namen                 | Robert Seethaler               | Cafe, Namen                  | 01.02.2021 | 01.01.2024   | 7             | GOOD      |
      | 3  | Wie die Saat, so die Ernte          | Donna Leon                     | Saat, Ernte                  | 01.03.2021 | 01.01.2024   | 2             | BAD       |
    Wenn alle vorhandenen Bücher zur Suche hinzugefügt werden
    Und ein Buch mit der ID 2 angefordert wird
    Dann soll folgendes Buch zurückgegeben werden
      | id | name                | authors          | keywords    | boughtDate | borrowedTill | timesBorrowed | condition |
      | 2  | Das Cafe ohne Namen | Robert Seethaler | Cafe, Namen | 01.02.2021 | 01.01.2024   | 7             | GOOD      |

  Szenario: Buch mit ungültiger ID abrufen
    Angenommen folgende Bücher existieren
      | id | name                                | authors                        | keywords                     | boughtDate | borrowedTill | timesBorrowed | condition |
      | 1  | Atlas - Die Geschichten von Pa Salt | Harry Whittaker, Lucinda Riley | Atlas, Pa, Salt, Geschichten | 01.01.2021 | 01.01.2024   | 5             | GOOD      |
      | 2  | Das Cafe ohne Namen                 | Robert Seethaler               | Cafe, Namen                  | 01.02.2021 | 01.01.2024   | 7             | GOOD      |
      | 3  | Wie die Saat, so die Ernte          | Donna Leon                     | Saat, Ernte                  | 01.03.2021 | 01.01.2024   | 2             | BAD       |
    Wenn alle vorhandenen Bücher zur Suche hinzugefügt werden
    Wenn ein Buch mit der ID 4 angefordert wird
    Dann soll kein Buch zurückgegeben werden

  Szenario: Suchparameter in der Suche erstellen
    Angenommen wir haben folgende Werte für den Suchparameter
      | names                                  | authors       | keywords | borrowed | borrowedAfter | boughtBefore | boughtAfter | minTimesBorrowed | maxTimesBorrowed | acceptableConditions |
      | Der Osten: eine westdeutsche Erfindung | Dirk Oschmann | Osten    | false    | 23.02.2023    | 30.05.2022   | 23.02.2020  | 2                | 5                | BROKEN               |
      | Wie die Saat, so die Ernte             | Donna Leon    | Westen   |          |               |              |             |                  |                  | BAD                  |
      |                                        |               | Saat     |          |               |              |             |                  |                  |                      |
      |                                        |               | Ernte    |          |               |              |             |                  |                  |                      |
    Wenn der Suchparameter erstellt wird
    Dann soll der Suchparameter für die Suche folgende Werte enthalten
      | names                                  | authors       | keywords | borrowed | borrowedAfter | boughtBefore | boughtAfter | minTimesBorrowed | maxTimesBorrowed | acceptableConditions |
      | Der Osten: eine westdeutsche Erfindung | Dirk Oschmann | Osten    | false    | 23.02.2023    | 30.05.2022   | 23.02.2020  | 2                | 5                | BROKEN               |
      | Wie die Saat, so die Ernte             | Donna Leon    | Westen   |          |               |              |             |                  |                  | BAD                  |
      |                                        |               | Saat     |          |               |              |             |                  |                  |                      |
      |                                        |               | Ernte    |          |               |              |             |                  |                  |                      |

  Szenario: Suche nach Büchern anhand Suchparametern mit ganzem Titel
    Angenommen folgende Bücher existieren
      | id | name                                      | authors                        | keywords                     | boughtDate | borrowedTill | timesBorrowed | condition |
      | 1  | Atlas - Die Geschichten von Pa Salt       | Harry Whittaker, Lucinda Riley | Atlas, Pa, Salt, Geschichten | 01.01.2021 |              | 70            | BROKEN    |
      | 2  | Das Cafe ohne Namen                       | Robert Seethaler               | Cafe, Namen                  | 01.02.2021 | 01.01.2024   | 7             | GOOD      |
      | 3  | Wie die Saat, so die Ernte                | Donna Leon                     | Saat, Ernte                  | 01.03.2021 | 01.01.2024   | 2             | BAD       |
      | 4  | Melody                                    | Martin Suter                   | Melody                       | 01.01.2021 | 01.01.2024   | 5             | GOOD      |
      | 5  | Die Liebe an miesen Tagen                 | Ewald Arenz                    | Liebe, Tagen, mies           | 01.02.2021 | 01.01.2024   | 7             | GOOD      |
      | 6  | Eine Frage der Chemie                     | Bonnie Garmus                  | Frage, Chemie                | 01.03.2021 | 01.01.2024   | 2             | BAD       |
      | 7  | Blue Skies                                | T.C. Boyle                     | Blue, Skies                  | 05.11.2020 | 01.01.2024   | 52            | BAD       |
      | 8  | Liebe oder Eierlikoer - Fast eine Romanze | Dora Heldt                     | Liebe, Eierlikoer, Romanze   | 01.02.2023 |              | 2             | NEW       |
      | 9  | Der letzte Sessellift                     | John Irving                    | Sessellift                   | 01.03.2023 |              | 1             | NEW       |
      | 10 | Troubadour                                | Martin Walker                  | Troubadour                   | 01.04.2023 | 06.07.2023   | 1             | NEW       |
    Und wir haben folgende Werte für den Suchparameter
      | names                      | authors | keywords | borrowed | borrowedAfter | boughtBefore | boughtAfter | minTimesBorrowed | maxTimesBorrowed | acceptableConditions |
      | Wie die Saat, so die Ernte |         |          |          |               |              |             |                  |                  |                      |
    Wenn alle vorhandenen Bücher zur Suche hinzugefügt werden
    Und der Suchparameter erstellt wird
    Und eine Suche mit den gegebenen Parametern durchgeführt wird
    Dann sollen folgende Bücher gefunden werden
      | id | name                       | authors    | keywords    | boughtDate | borrowedTill | timesBorrowed | condition |
      | 3  | Wie die Saat, so die Ernte | Donna Leon | Saat, Ernte | 01.03.2021 | 01.01.2024   | 2             | BAD       |

  Szenario: Suche nach Büchern anhand Suchparametern mit mehreren Titeln
    Angenommen folgende Bücher existieren
      | id | name                                      | authors                        | keywords                     | boughtDate | borrowedTill | timesBorrowed | condition |
      | 1  | Atlas - Die Geschichten von Pa Salt       | Harry Whittaker, Lucinda Riley | Atlas, Pa, Salt, Geschichten | 01.01.2021 |              | 70            | BROKEN    |
      | 2  | Das Cafe ohne Namen                       | Robert Seethaler               | Cafe, Namen                  | 01.02.2021 | 01.01.2024   | 7             | GOOD      |
      | 3  | Wie die Saat, so die Ernte                | Donna Leon                     | Saat, Ernte                  | 01.03.2021 | 01.01.2024   | 2             | BAD       |
      | 4  | Melody                                    | Martin Suter                   | Melody                       | 01.01.2021 | 01.01.2024   | 5             | GOOD      |
      | 5  | Die Liebe an miesen Tagen                 | Ewald Arenz                    | Liebe, Tagen, mies           | 01.02.2021 | 01.01.2024   | 7             | GOOD      |
      | 6  | Eine Frage der Chemie                     | Bonnie Garmus                  | Frage, Chemie                | 01.03.2021 | 01.01.2024   | 2             | BAD       |
      | 7  | Blue Skies                                | T.C. Boyle                     | Blue, Skies                  | 05.11.2020 | 01.01.2024   | 52            | BAD       |
      | 8  | Liebe oder Eierlikoer - Fast eine Romanze | Dora Heldt                     | Liebe, Eierlikoer, Romanze   | 01.02.2023 |              | 2             | NEW       |
      | 9  | Der letzte Sessellift                     | John Irving                    | Sessellift                   | 01.03.2023 |              | 1             | NEW       |
      | 10 | Troubadour                                | Martin Walker                  | Troubadour                   | 01.04.2023 | 06.07.2023   | 1             | NEW       |
    Und wir haben folgende Werte für den Suchparameter
      | names                      | authors | keywords | borrowed | borrowedAfter | boughtBefore | boughtAfter | minTimesBorrowed | maxTimesBorrowed | acceptableConditions |
      | Wie die Saat, so die Ernte |         |          |          |               |              |             |                  |                  |                      |
      | Blue Skies                 |         |          |          |               |              |             |                  |                  |                      |
    Wenn alle vorhandenen Bücher zur Suche hinzugefügt werden
    Und der Suchparameter erstellt wird
    Und eine Suche mit den gegebenen Parametern durchgeführt wird
    Dann sollen folgende Bücher gefunden werden
      | id | name                       | authors    | keywords    | boughtDate | borrowedTill | timesBorrowed | condition |
      | 3  | Wie die Saat, so die Ernte | Donna Leon | Saat, Ernte | 01.03.2021 | 01.01.2024   | 2             | BAD       |
      | 7  | Blue Skies                 | T.C. Boyle | Blue, Skies | 05.11.2020 | 01.01.2024   | 52            | BAD       |

  Szenario: Suche nach Büchern anhand Suchparametern mit Autor*innen
    Angenommen folgende Bücher existieren
      | id | name                                      | authors                        | keywords                     | boughtDate | borrowedTill | timesBorrowed | condition |
      | 1  | Atlas - Die Geschichten von Pa Salt       | Harry Whittaker, Lucinda Riley | Atlas, Pa, Salt, Geschichten | 01.01.2021 |              | 70            | BROKEN    |
      | 2  | Das Cafe ohne Namen                       | Robert Seethaler               | Cafe, Namen                  | 01.02.2021 | 01.01.2024   | 7             | GOOD      |
      | 3  | Wie die Saat, so die Ernte                | Donna Leon                     | Saat, Ernte                  | 01.03.2021 | 01.01.2024   | 2             | BAD       |
      | 4  | Melody                                    | Martin Suter                   | Melody                       | 01.01.2021 | 01.01.2024   | 5             | GOOD      |
      | 5  | Die Liebe an miesen Tagen                 | Ewald Arenz                    | Liebe, Tagen, mies           | 01.02.2021 | 01.01.2024   | 7             | GOOD      |
      | 6  | Eine Frage der Chemie                     | Bonnie Garmus                  | Frage, Chemie                | 01.03.2021 | 01.01.2024   | 2             | BAD       |
      | 7  | Blue Skies                                | T.C. Boyle                     | Blue, Skies                  | 05.11.2020 | 01.01.2024   | 52            | BAD       |
      | 8  | Liebe oder Eierlikoer - Fast eine Romanze | Dora Heldt                     | Liebe, Eierlikoer, Romanze   | 01.02.2023 |              | 2             | NEW       |
      | 9  | Der letzte Sessellift                     | John Irving                    | Sessellift                   | 01.03.2023 |              | 1             | NEW       |
      | 10 | Troubadour                                | Martin Walker                  | Troubadour                   | 01.04.2023 | 06.07.2023   | 1             | NEW       |
    Und wir haben folgende Werte für den Suchparameter
      | names | authors     | keywords | borrowed | borrowedAfter | boughtBefore | boughtAfter | minTimesBorrowed | maxTimesBorrowed | acceptableConditions |
      |       | Ewald Arenz |          |          |               |              |             |                  |                  |                      |
    Wenn alle vorhandenen Bücher zur Suche hinzugefügt werden
    Und der Suchparameter erstellt wird
    Und eine Suche mit den gegebenen Parametern durchgeführt wird
    Dann sollen folgende Bücher gefunden werden
      | id | name                      | authors     | keywords           | boughtDate | borrowedTill | timesBorrowed | condition |
      | 5  | Die Liebe an miesen Tagen | Ewald Arenz | Liebe, Tagen, mies | 01.02.2021 | 01.01.2024   | 7             | GOOD      |

  Szenario: Suche nach Büchern anhand Suchparametern mit Schlüsselwörtern
    Angenommen folgende Bücher existieren
      | id | name                                      | authors                        | keywords                     | boughtDate | borrowedTill | timesBorrowed | condition |
      | 1  | Atlas - Die Geschichten von Pa Salt       | Harry Whittaker, Lucinda Riley | Atlas, Pa, Salt, Geschichten | 01.01.2021 |              | 70            | BROKEN    |
      | 2  | Das Cafe ohne Namen                       | Robert Seethaler               | Cafe, Namen                  | 01.02.2021 | 01.01.2024   | 7             | GOOD      |
      | 3  | Wie die Saat, so die Ernte                | Donna Leon                     | Saat, Ernte                  | 01.03.2021 | 01.01.2024   | 2             | BAD       |
      | 4  | Melody                                    | Martin Suter                   | Melody                       | 01.01.2021 | 01.01.2024   | 5             | GOOD      |
      | 5  | Die Liebe an miesen Tagen                 | Ewald Arenz                    | Liebe, Tagen, mies           | 01.02.2021 | 01.01.2024   | 7             | GOOD      |
      | 6  | Eine Frage der Chemie                     | Bonnie Garmus                  | Frage, Chemie                | 01.03.2021 | 01.01.2024   | 2             | BAD       |
      | 7  | Blue Skies                                | T.C. Boyle                     | Blue, Skies                  | 05.11.2020 | 01.01.2024   | 52            | BAD       |
      | 8  | Liebe oder Eierlikoer - Fast eine Romanze | Dora Heldt                     | Liebe, Eierlikoer, Romanze   | 01.02.2023 |              | 2             | NEW       |
      | 9  | Der letzte Sessellift                     | John Irving                    | Sessellift                   | 01.03.2023 |              | 1             | NEW       |
      | 10 | Troubadour                                | Martin Walker                  | Troubadour                   | 01.04.2023 | 06.07.2023   | 1             | NEW       |
    Und wir haben folgende Werte für den Suchparameter
      | names | authors | keywords | borrowed | borrowedAfter | boughtBefore | boughtAfter | minTimesBorrowed | maxTimesBorrowed | acceptableConditions |
      |       |         | Liebe    |          |               |              |             |                  |                  |                      |
      |       |         | Tagen    |          |               |              |             |                  |                  |                      |
    Wenn alle vorhandenen Bücher zur Suche hinzugefügt werden
    Und der Suchparameter erstellt wird
    Und eine Suche mit den gegebenen Parametern durchgeführt wird
    Dann sollen folgende Bücher gefunden werden
      | id | name                                      | authors     | keywords                   | boughtDate | borrowedTill | timesBorrowed | condition |
      | 5  | Die Liebe an miesen Tagen                 | Ewald Arenz | Liebe, Tagen, mies         | 01.02.2021 | 01.01.2024   | 7             | GOOD      |
      | 8  | Liebe oder Eierlikoer - Fast eine Romanze | Dora Heldt  | Liebe, Eierlikoer, Romanze | 01.02.2023 |              | 2             | NEW       |

  Szenario: Suche nach Büchern anhand Suchparametern mit aktuell ausgeliehenen Büchern
    Angenommen folgende Bücher existieren
      | id | name                                      | authors                        | keywords                     | boughtDate | borrowedTill | timesBorrowed | condition |
      | 1  | Atlas - Die Geschichten von Pa Salt       | Harry Whittaker, Lucinda Riley | Atlas, Pa, Salt, Geschichten | 01.01.2021 |              | 70            | BROKEN    |
      | 2  | Das Cafe ohne Namen                       | Robert Seethaler               | Cafe, Namen                  | 01.02.2021 | 01.01.2024   | 7             | GOOD      |
      | 3  | Wie die Saat, so die Ernte                | Donna Leon                     | Saat, Ernte                  | 01.03.2021 | 01.01.2024   | 2             | BAD       |
      | 4  | Melody                                    | Martin Suter                   | Melody                       | 01.01.2021 | 01.01.2024   | 5             | GOOD      |
      | 5  | Die Liebe an miesen Tagen                 | Ewald Arenz                    | Liebe, Tagen, mies           | 01.02.2021 | 01.01.2024   | 7             | GOOD      |
      | 6  | Eine Frage der Chemie                     | Bonnie Garmus                  | Frage, Chemie                | 01.03.2021 | 01.01.2024   | 2             | BAD       |
      | 7  | Blue Skies                                | T.C. Boyle                     | Blue, Skies                  | 05.11.2020 | 01.01.2024   | 52            | BAD       |
      | 8  | Liebe oder Eierlikoer - Fast eine Romanze | Dora Heldt                     | Liebe, Eierlikoer, Romanze   | 01.02.2023 |              | 2             | NEW       |
      | 9  | Der letzte Sessellift                     | John Irving                    | Sessellift                   | 01.03.2023 |              | 1             | NEW       |
      | 10 | Troubadour                                | Martin Walker                  | Troubadour                   | 01.04.2023 | 06.07.2023   | 1             | NEW       |
    Und wir haben folgende Werte für den Suchparameter
      | names | authors | keywords | borrowed | borrowedAfter | boughtBefore | boughtAfter | minTimesBorrowed | maxTimesBorrowed | acceptableConditions |
      |       |         |          | true     |               |              |             |                  |                  |                      |
    Wenn alle vorhandenen Bücher zur Suche hinzugefügt werden
    Und der Suchparameter erstellt wird
    Und eine Suche mit den gegebenen Parametern durchgeführt wird
    Dann sollen folgende Bücher gefunden werden
      | id | name                       | authors          | keywords           | boughtDate | borrowedTill | timesBorrowed | condition |
      | 2  | Das Cafe ohne Namen        | Robert Seethaler | Cafe, Namen        | 01.02.2021 | 01.01.2024   | 7             | GOOD      |
      | 3  | Wie die Saat, so die Ernte | Donna Leon       | Saat, Ernte        | 01.03.2021 | 01.01.2024   | 2             | BAD       |
      | 4  | Melody                     | Martin Suter     | Melody             | 01.01.2021 | 01.01.2024   | 5             | GOOD      |
      | 5  | Die Liebe an miesen Tagen  | Ewald Arenz      | Liebe, Tagen, mies | 01.02.2021 | 01.01.2024   | 7             | GOOD      |
      | 6  | Eine Frage der Chemie      | Bonnie Garmus    | Frage, Chemie      | 01.03.2021 | 01.01.2024   | 2             | BAD       |
      | 7  | Blue Skies                 | T.C. Boyle       | Blue, Skies        | 05.11.2020 | 01.01.2024   | 52            | BAD       |
      | 10 | Troubadour                 | Martin Walker    | Troubadour         | 01.04.2023 | 06.07.2023   | 1             | NEW       |

  Szenario: Suche nach Büchern anhand Suchparametern mit aktuell nicht ausgeliehenen Büchern
    Angenommen folgende Bücher existieren
      | id | name                                      | authors                        | keywords                     | boughtDate | borrowedTill | timesBorrowed | condition |
      | 1  | Atlas - Die Geschichten von Pa Salt       | Harry Whittaker, Lucinda Riley | Atlas, Pa, Salt, Geschichten | 01.01.2021 |              | 70            | BROKEN    |
      | 2  | Das Cafe ohne Namen                       | Robert Seethaler               | Cafe, Namen                  | 01.02.2021 | 01.01.2024   | 7             | GOOD      |
      | 3  | Wie die Saat, so die Ernte                | Donna Leon                     | Saat, Ernte                  | 01.03.2021 | 01.01.2024   | 2             | BAD       |
      | 4  | Melody                                    | Martin Suter                   | Melody                       | 01.01.2021 | 01.01.2024   | 5             | GOOD      |
      | 5  | Die Liebe an miesen Tagen                 | Ewald Arenz                    | Liebe, Tagen, mies           | 01.02.2021 | 01.01.2024   | 7             | GOOD      |
      | 6  | Eine Frage der Chemie                     | Bonnie Garmus                  | Frage, Chemie                | 01.03.2021 | 01.01.2024   | 2             | BAD       |
      | 7  | Blue Skies                                | T.C. Boyle                     | Blue, Skies                  | 05.11.2020 | 01.01.2024   | 52            | BAD       |
      | 8  | Liebe oder Eierlikoer - Fast eine Romanze | Dora Heldt                     | Liebe, Eierlikoer, Romanze   | 01.02.2023 |              | 2             | NEW       |
      | 9  | Der letzte Sessellift                     | John Irving                    | Sessellift                   | 01.03.2023 |              | 1             | NEW       |
      | 10 | Troubadour                                | Martin Walker                  | Troubadour                   | 01.04.2023 | 06.07.2023   | 1             | NEW       |
    Und wir haben folgende Werte für den Suchparameter
      | names | authors | keywords | borrowed | borrowedAfter | boughtBefore | boughtAfter | minTimesBorrowed | maxTimesBorrowed | acceptableConditions |
      |       |         |          | false    |               |              |             |                  |                  |                      |
    Wenn alle vorhandenen Bücher zur Suche hinzugefügt werden
    Und der Suchparameter erstellt wird
    Und eine Suche mit den gegebenen Parametern durchgeführt wird
    Dann sollen folgende Bücher gefunden werden
      | id | name                                      | authors                        | keywords                     | boughtDate | borrowedTill | timesBorrowed | condition |
      | 1  | Atlas - Die Geschichten von Pa Salt       | Harry Whittaker, Lucinda Riley | Atlas, Pa, Salt, Geschichten | 01.01.2021 |              | 70            | BROKEN    |
      | 8  | Liebe oder Eierlikoer - Fast eine Romanze | Dora Heldt                     | Liebe, Eierlikoer, Romanze   | 01.02.2023 |              | 2             | NEW       |
      | 9  | Der letzte Sessellift                     | John Irving                    | Sessellift                   | 01.03.2023 |              | 1             | NEW       |

  Szenario: Suche nach Büchern anhand Suchparametern ohne Ausleihstatus
    Angenommen folgende Bücher existieren
      | id | name                                      | authors                        | keywords                     | boughtDate | borrowedTill | timesBorrowed | condition |
      | 1  | Atlas - Die Geschichten von Pa Salt       | Harry Whittaker, Lucinda Riley | Atlas, Pa, Salt, Geschichten | 01.01.2021 |              | 70            | BROKEN    |
      | 2  | Das Cafe ohne Namen                       | Robert Seethaler               | Cafe, Namen                  | 01.02.2021 | 01.01.2024   | 7             | GOOD      |
      | 3  | Wie die Saat, so die Ernte                | Donna Leon                     | Saat, Ernte                  | 01.03.2021 | 01.01.2024   | 2             | BAD       |
      | 4  | Melody                                    | Martin Suter                   | Melody                       | 01.01.2021 | 01.01.2024   | 5             | GOOD      |
      | 5  | Die Liebe an miesen Tagen                 | Ewald Arenz                    | Liebe, Tagen, mies           | 01.02.2021 | 01.01.2024   | 7             | GOOD      |
      | 6  | Eine Frage der Chemie                     | Bonnie Garmus                  | Frage, Chemie                | 01.03.2021 | 01.01.2024   | 2             | BAD       |
      | 7  | Blue Skies                                | T.C. Boyle                     | Blue, Skies                  | 05.11.2020 | 01.01.2024   | 52            | BAD       |
      | 8  | Liebe oder Eierlikoer - Fast eine Romanze | Dora Heldt                     | Liebe, Eierlikoer, Romanze   | 01.02.2023 |              | 2             | NEW       |
      | 9  | Der letzte Sessellift                     | John Irving                    | Sessellift                   | 01.03.2023 |              | 1             | NEW       |
      | 10 | Troubadour                                | Martin Walker                  | Troubadour                   | 01.04.2023 | 06.07.2023   | 1             | NEW       |
    Und wir haben folgende Werte für den Suchparameter
      | names | authors | keywords | borrowed | borrowedAfter | boughtBefore | boughtAfter | minTimesBorrowed | maxTimesBorrowed | acceptableConditions |
      |       |         |          |          |               |              |             |                  |                  |                      |
    Wenn alle vorhandenen Bücher zur Suche hinzugefügt werden
    Und der Suchparameter erstellt wird
    Und eine Suche mit den gegebenen Parametern durchgeführt wird
    Dann sollen folgende Bücher gefunden werden
      | id | name                                      | authors                        | keywords                     | boughtDate | borrowedTill | timesBorrowed | condition |
      | 1  | Atlas - Die Geschichten von Pa Salt       | Harry Whittaker, Lucinda Riley | Atlas, Pa, Salt, Geschichten | 01.01.2021 |              | 70            | BROKEN    |
      | 2  | Das Cafe ohne Namen                       | Robert Seethaler               | Cafe, Namen                  | 01.02.2021 | 01.01.2024   | 7             | GOOD      |
      | 3  | Wie die Saat, so die Ernte                | Donna Leon                     | Saat, Ernte                  | 01.03.2021 | 01.01.2024   | 2             | BAD       |
      | 4  | Melody                                    | Martin Suter                   | Melody                       | 01.01.2021 | 01.01.2024   | 5             | GOOD      |
      | 5  | Die Liebe an miesen Tagen                 | Ewald Arenz                    | Liebe, Tagen, mies           | 01.02.2021 | 01.01.2024   | 7             | GOOD      |
      | 6  | Eine Frage der Chemie                     | Bonnie Garmus                  | Frage, Chemie                | 01.03.2021 | 01.01.2024   | 2             | BAD       |
      | 7  | Blue Skies                                | T.C. Boyle                     | Blue, Skies                  | 05.11.2020 | 01.01.2024   | 52            | BAD       |
      | 8  | Liebe oder Eierlikoer - Fast eine Romanze | Dora Heldt                     | Liebe, Eierlikoer, Romanze   | 01.02.2023 |              | 2             | NEW       |
      | 9  | Der letzte Sessellift                     | John Irving                    | Sessellift                   | 01.03.2023 |              | 1             | NEW       |
      | 10 | Troubadour                                | Martin Walker                  | Troubadour                   | 01.04.2023 | 06.07.2023   | 1             | NEW       |

  Szenario: Suche nach Büchern anhand Suchparametern mit Ausleihdatum
    Angenommen folgende Bücher existieren
      | id | name                                      | authors                        | keywords                     | boughtDate | borrowedTill | timesBorrowed | condition |
      | 1  | Atlas - Die Geschichten von Pa Salt       | Harry Whittaker, Lucinda Riley | Atlas, Pa, Salt, Geschichten | 01.01.2021 |              | 70            | BROKEN    |
      | 2  | Das Cafe ohne Namen                       | Robert Seethaler               | Cafe, Namen                  | 01.02.2021 | 01.01.2024   | 7             | GOOD      |
      | 3  | Wie die Saat, so die Ernte                | Donna Leon                     | Saat, Ernte                  | 01.03.2021 | 01.01.2024   | 2             | BAD       |
      | 4  | Melody                                    | Martin Suter                   | Melody                       | 01.01.2021 | 01.01.2024   | 5             | GOOD      |
      | 5  | Die Liebe an miesen Tagen                 | Ewald Arenz                    | Liebe, Tagen, mies           | 01.02.2021 | 01.01.2024   | 7             | GOOD      |
      | 6  | Eine Frage der Chemie                     | Bonnie Garmus                  | Frage, Chemie                | 01.03.2021 | 01.01.2024   | 2             | BAD       |
      | 7  | Blue Skies                                | T.C. Boyle                     | Blue, Skies                  | 05.11.2020 | 01.01.2024   | 52            | BAD       |
      | 8  | Liebe oder Eierlikoer - Fast eine Romanze | Dora Heldt                     | Liebe, Eierlikoer, Romanze   | 01.02.2023 |              | 2             | NEW       |
      | 9  | Der letzte Sessellift                     | John Irving                    | Sessellift                   | 01.03.2023 |              | 1             | NEW       |
      | 10 | Troubadour                                | Martin Walker                  | Troubadour                   | 01.04.2023 | 06.07.2023   | 1             | NEW       |
    Und wir haben folgende Werte für den Suchparameter
      | names | authors | keywords | borrowed | borrowedAfter | boughtBefore | boughtAfter | minTimesBorrowed | maxTimesBorrowed | acceptableConditions |
      |       |         |          | true     | 07.07.2023    |              |             |                  |                  |                      |
    Wenn alle vorhandenen Bücher zur Suche hinzugefügt werden
    Und der Suchparameter erstellt wird
    Und eine Suche mit den gegebenen Parametern durchgeführt wird
    Dann sollen folgende Bücher gefunden werden
      | id | name                       | authors          | keywords           | boughtDate | borrowedTill | timesBorrowed | condition |
      | 2  | Das Cafe ohne Namen        | Robert Seethaler | Cafe, Namen        | 01.02.2021 | 01.01.2024   | 7             | GOOD      |
      | 3  | Wie die Saat, so die Ernte | Donna Leon       | Saat, Ernte        | 01.03.2021 | 01.01.2024   | 2             | BAD       |
      | 4  | Melody                     | Martin Suter     | Melody             | 01.01.2021 | 01.01.2024   | 5             | GOOD      |
      | 5  | Die Liebe an miesen Tagen  | Ewald Arenz      | Liebe, Tagen, mies | 01.02.2021 | 01.01.2024   | 7             | GOOD      |
      | 6  | Eine Frage der Chemie      | Bonnie Garmus    | Frage, Chemie      | 01.03.2021 | 01.01.2024   | 2             | BAD       |
      | 7  | Blue Skies                 | T.C. Boyle       | Blue, Skies        | 05.11.2020 | 01.01.2024   | 52            | BAD       |

  Szenario: Suche nach Büchern anhand Suchparametern mit Kaufdatum vor bestimmten Datum
    Angenommen folgende Bücher existieren
      | id | name                                      | authors                        | keywords                     | boughtDate | borrowedTill | timesBorrowed | condition |
      | 1  | Atlas - Die Geschichten von Pa Salt       | Harry Whittaker, Lucinda Riley | Atlas, Pa, Salt, Geschichten | 01.01.2021 |              | 70            | BROKEN    |
      | 2  | Das Cafe ohne Namen                       | Robert Seethaler               | Cafe, Namen                  | 01.02.2021 | 01.01.2024   | 7             | GOOD      |
      | 3  | Wie die Saat, so die Ernte                | Donna Leon                     | Saat, Ernte                  | 01.03.2021 | 01.01.2024   | 2             | BAD       |
      | 4  | Melody                                    | Martin Suter                   | Melody                       | 01.01.2021 | 01.01.2024   | 5             | GOOD      |
      | 5  | Die Liebe an miesen Tagen                 | Ewald Arenz                    | Liebe, Tagen, mies           | 01.02.2021 | 01.01.2024   | 7             | GOOD      |
      | 6  | Eine Frage der Chemie                     | Bonnie Garmus                  | Frage, Chemie                | 01.03.2021 | 01.01.2024   | 2             | BAD       |
      | 7  | Blue Skies                                | T.C. Boyle                     | Blue, Skies                  | 05.11.2020 | 01.01.2024   | 52            | BAD       |
      | 8  | Liebe oder Eierlikoer - Fast eine Romanze | Dora Heldt                     | Liebe, Eierlikoer, Romanze   | 01.02.2023 |              | 2             | NEW       |
      | 9  | Der letzte Sessellift                     | John Irving                    | Sessellift                   | 01.03.2023 |              | 1             | NEW       |
      | 10 | Troubadour                                | Martin Walker                  | Troubadour                   | 01.04.2023 | 06.07.2023   | 1             | NEW       |
    Und wir haben folgende Werte für den Suchparameter
      | names | authors | keywords | borrowed | borrowedAfter | boughtBefore | boughtAfter | minTimesBorrowed | maxTimesBorrowed | acceptableConditions |
      |       |         |          |          |               | 01.01.2021   |             |                  |                  |                      |
    Wenn alle vorhandenen Bücher zur Suche hinzugefügt werden
    Und der Suchparameter erstellt wird
    Und eine Suche mit den gegebenen Parametern durchgeführt wird
    Dann sollen folgende Bücher gefunden werden
      | id | name       | authors    | keywords    | boughtDate | borrowedTill | timesBorrowed | condition |
      | 7  | Blue Skies | T.C. Boyle | Blue, Skies | 05.11.2020 | 01.01.2024   | 52            | BAD       |

  Szenario: Suche nach Büchern anhand Suchparametern mit Kaufdatum nach bestimmten Datum
    Angenommen folgende Bücher existieren
      | id | name                                      | authors                        | keywords                     | boughtDate | borrowedTill | timesBorrowed | condition |
      | 1  | Atlas - Die Geschichten von Pa Salt       | Harry Whittaker, Lucinda Riley | Atlas, Pa, Salt, Geschichten | 01.01.2021 |              | 70            | BROKEN    |
      | 2  | Das Cafe ohne Namen                       | Robert Seethaler               | Cafe, Namen                  | 01.02.2021 | 01.01.2024   | 7             | GOOD      |
      | 3  | Wie die Saat, so die Ernte                | Donna Leon                     | Saat, Ernte                  | 01.03.2021 | 01.01.2024   | 2             | BAD       |
      | 4  | Melody                                    | Martin Suter                   | Melody                       | 01.01.2021 | 01.01.2024   | 5             | GOOD      |
      | 5  | Die Liebe an miesen Tagen                 | Ewald Arenz                    | Liebe, Tagen, mies           | 01.02.2021 | 01.01.2024   | 7             | GOOD      |
      | 6  | Eine Frage der Chemie                     | Bonnie Garmus                  | Frage, Chemie                | 01.03.2021 | 01.01.2024   | 2             | BAD       |
      | 7  | Blue Skies                                | T.C. Boyle                     | Blue, Skies                  | 05.11.2020 | 01.01.2024   | 52            | BAD       |
      | 8  | Liebe oder Eierlikoer - Fast eine Romanze | Dora Heldt                     | Liebe, Eierlikoer, Romanze   | 01.02.2023 |              | 2             | NEW       |
      | 9  | Der letzte Sessellift                     | John Irving                    | Sessellift                   | 01.03.2023 |              | 1             | NEW       |
      | 10 | Troubadour                                | Martin Walker                  | Troubadour                   | 01.04.2023 | 06.07.2023   | 1             | NEW       |
    Und wir haben folgende Werte für den Suchparameter
      | names | authors | keywords | borrowed | borrowedAfter | boughtBefore | boughtAfter | minTimesBorrowed | maxTimesBorrowed | acceptableConditions |
      |       |         |          |          |               |              | 31.12.2021  |                  |                  |                      |
    Wenn alle vorhandenen Bücher zur Suche hinzugefügt werden
    Und der Suchparameter erstellt wird
    Und eine Suche mit den gegebenen Parametern durchgeführt wird
    Dann sollen folgende Bücher gefunden werden
      | id | name                                      | authors       | keywords                   | boughtDate | borrowedTill | timesBorrowed | condition |
      | 8  | Liebe oder Eierlikoer - Fast eine Romanze | Dora Heldt    | Liebe, Eierlikoer, Romanze | 01.02.2023 |              | 2             | NEW       |
      | 9  | Der letzte Sessellift                     | John Irving   | Sessellift                 | 01.03.2023 |              | 1             | NEW       |
      | 10 | Troubadour                                | Martin Walker | Troubadour                 | 01.04.2023 | 06.07.2023   | 1             | NEW       |

  Szenario: Suche nach Büchern anhand Suchparametern mit einer Mindestanzahl an Ausleihen
    Angenommen folgende Bücher existieren
      | id | name                                      | authors                        | keywords                     | boughtDate | borrowedTill | timesBorrowed | condition |
      | 1  | Atlas - Die Geschichten von Pa Salt       | Harry Whittaker, Lucinda Riley | Atlas, Pa, Salt, Geschichten | 01.01.2021 |              | 70            | BROKEN    |
      | 2  | Das Cafe ohne Namen                       | Robert Seethaler               | Cafe, Namen                  | 01.02.2021 | 01.01.2024   | 7             | GOOD      |
      | 3  | Wie die Saat, so die Ernte                | Donna Leon                     | Saat, Ernte                  | 01.03.2021 | 01.01.2024   | 2             | BAD       |
      | 4  | Melody                                    | Martin Suter                   | Melody                       | 01.01.2021 | 01.01.2024   | 5             | GOOD      |
      | 5  | Die Liebe an miesen Tagen                 | Ewald Arenz                    | Liebe, Tagen, mies           | 01.02.2021 | 01.01.2024   | 7             | GOOD      |
      | 6  | Eine Frage der Chemie                     | Bonnie Garmus                  | Frage, Chemie                | 01.03.2021 | 01.01.2024   | 2             | BAD       |
      | 7  | Blue Skies                                | T.C. Boyle                     | Blue, Skies                  | 05.11.2020 | 01.01.2024   | 52            | BAD       |
      | 8  | Liebe oder Eierlikoer - Fast eine Romanze | Dora Heldt                     | Liebe, Eierlikoer, Romanze   | 01.02.2023 |              | 2             | NEW       |
      | 9  | Der letzte Sessellift                     | John Irving                    | Sessellift                   | 01.03.2023 |              | 1             | NEW       |
      | 10 | Troubadour                                | Martin Walker                  | Troubadour                   | 01.04.2023 | 06.07.2023   | 1             | NEW       |
    Und wir haben folgende Werte für den Suchparameter
      | names | authors | keywords | borrowed | borrowedAfter | boughtBefore | boughtAfter | minTimesBorrowed | maxTimesBorrowed | acceptableConditions |
      |       |         |          |          |               |              |             | 10               |                  |                      |
    Wenn alle vorhandenen Bücher zur Suche hinzugefügt werden
    Und der Suchparameter erstellt wird
    Und eine Suche mit den gegebenen Parametern durchgeführt wird
    Dann sollen folgende Bücher gefunden werden
      | id | name                                | authors                        | keywords                     | boughtDate | borrowedTill | timesBorrowed | condition |
      | 1  | Atlas - Die Geschichten von Pa Salt | Harry Whittaker, Lucinda Riley | Atlas, Pa, Salt, Geschichten | 01.01.2021 |              | 70            | BROKEN    |
      | 7  | Blue Skies                          | T.C. Boyle                     | Blue, Skies                  | 05.11.2020 | 01.01.2024   | 52            | BAD       |

  Szenario: Suche nach Büchern anhand Suchparametern mit einer Maximalanzahl an Ausleihen
    Angenommen folgende Bücher existieren
      | id | name                                      | authors                        | keywords                     | boughtDate | borrowedTill | timesBorrowed | condition |
      | 1  | Atlas - Die Geschichten von Pa Salt       | Harry Whittaker, Lucinda Riley | Atlas, Pa, Salt, Geschichten | 01.01.2021 |              | 70            | BROKEN    |
      | 2  | Das Cafe ohne Namen                       | Robert Seethaler               | Cafe, Namen                  | 01.02.2021 | 01.01.2024   | 7             | GOOD      |
      | 3  | Wie die Saat, so die Ernte                | Donna Leon                     | Saat, Ernte                  | 01.03.2021 | 01.01.2024   | 2             | BAD       |
      | 4  | Melody                                    | Martin Suter                   | Melody                       | 01.01.2021 | 01.01.2024   | 5             | GOOD      |
      | 5  | Die Liebe an miesen Tagen                 | Ewald Arenz                    | Liebe, Tagen, mies           | 01.02.2021 | 01.01.2024   | 7             | GOOD      |
      | 6  | Eine Frage der Chemie                     | Bonnie Garmus                  | Frage, Chemie                | 01.03.2021 | 01.01.2024   | 2             | BAD       |
      | 7  | Blue Skies                                | T.C. Boyle                     | Blue, Skies                  | 05.11.2020 | 01.01.2024   | 52            | BAD       |
      | 8  | Liebe oder Eierlikoer - Fast eine Romanze | Dora Heldt                     | Liebe, Eierlikoer, Romanze   | 01.02.2023 |              | 2             | NEW       |
      | 9  | Der letzte Sessellift                     | John Irving                    | Sessellift                   | 01.03.2023 |              | 1             | NEW       |
      | 10 | Troubadour                                | Martin Walker                  | Troubadour                   | 01.04.2023 | 06.07.2023   | 1             | NEW       |
    Und wir haben folgende Werte für den Suchparameter
      | names | authors | keywords | borrowed | borrowedAfter | boughtBefore | boughtAfter | minTimesBorrowed | maxTimesBorrowed | acceptableConditions |
      |       |         |          |          |               |              |             |                  | 6                |                      |
    Wenn alle vorhandenen Bücher zur Suche hinzugefügt werden
    Und der Suchparameter erstellt wird
    Und eine Suche mit den gegebenen Parametern durchgeführt wird
    Dann sollen folgende Bücher gefunden werden
      | id | name                                      | authors       | keywords                   | boughtDate | borrowedTill | timesBorrowed | condition |
      | 3  | Wie die Saat, so die Ernte                | Donna Leon    | Saat, Ernte                | 01.03.2021 | 01.01.2024   | 2             | BAD       |
      | 4  | Melody                                    | Martin Suter  | Melody                     | 01.01.2021 | 01.01.2024   | 5             | GOOD      |
      | 6  | Eine Frage der Chemie                     | Bonnie Garmus | Frage, Chemie              | 01.03.2021 | 01.01.2024   | 2             | BAD       |
      | 8  | Liebe oder Eierlikoer - Fast eine Romanze | Dora Heldt    | Liebe, Eierlikoer, Romanze | 01.02.2023 |              | 2             | NEW       |
      | 9  | Der letzte Sessellift                     | John Irving   | Sessellift                 | 01.03.2023 |              | 1             | NEW       |
      | 10 | Troubadour                                | Martin Walker | Troubadour                 | 01.04.2023 | 06.07.2023   | 1             | NEW       |

  Szenario: Suche nach Büchern anhand Suchparametern mit Zuständen
    Angenommen folgende Bücher existieren
      | id | name                                      | authors                        | keywords                     | boughtDate | borrowedTill | timesBorrowed | condition |
      | 1  | Atlas - Die Geschichten von Pa Salt       | Harry Whittaker, Lucinda Riley | Atlas, Pa, Salt, Geschichten | 01.01.2021 |              | 70            | BROKEN    |
      | 2  | Das Cafe ohne Namen                       | Robert Seethaler               | Cafe, Namen                  | 01.02.2021 | 01.01.2024   | 7             | GOOD      |
      | 3  | Wie die Saat, so die Ernte                | Donna Leon                     | Saat, Ernte                  | 01.03.2021 | 01.01.2024   | 2             | BAD       |
      | 4  | Melody                                    | Martin Suter                   | Melody                       | 01.01.2021 | 01.01.2024   | 5             | GOOD      |
      | 5  | Die Liebe an miesen Tagen                 | Ewald Arenz                    | Liebe, Tagen, mies           | 01.02.2021 | 01.01.2024   | 7             | GOOD      |
      | 6  | Eine Frage der Chemie                     | Bonnie Garmus                  | Frage, Chemie                | 01.03.2021 | 01.01.2024   | 2             | BAD       |
      | 7  | Blue Skies                                | T.C. Boyle                     | Blue, Skies                  | 05.11.2020 | 01.01.2024   | 52            | BAD       |
      | 8  | Liebe oder Eierlikoer - Fast eine Romanze | Dora Heldt                     | Liebe, Eierlikoer, Romanze   | 01.02.2023 |              | 2             | NEW       |
      | 9  | Der letzte Sessellift                     | John Irving                    | Sessellift                   | 01.03.2023 |              | 1             | NEW       |
      | 10 | Troubadour                                | Martin Walker                  | Troubadour                   | 01.04.2023 | 06.07.2023   | 1             | NEW       |
    Und wir haben folgende Werte für den Suchparameter
      | names | authors | keywords | borrowed | borrowedAfter | boughtBefore | boughtAfter | minTimesBorrowed | maxTimesBorrowed | acceptableConditions |
      |       |         |          |          |               |              |             |                  |                  | BROKEN               |
      |       |         |          |          |               |              |             |                  |                  | NEW                  |
    Wenn alle vorhandenen Bücher zur Suche hinzugefügt werden
    Und der Suchparameter erstellt wird
    Und eine Suche mit den gegebenen Parametern durchgeführt wird
    Dann sollen folgende Bücher gefunden werden
      | id | name                                      | authors                        | keywords                     | boughtDate | borrowedTill | timesBorrowed | condition |
      | 1  | Atlas - Die Geschichten von Pa Salt       | Harry Whittaker, Lucinda Riley | Atlas, Pa, Salt, Geschichten | 01.01.2021 |              | 70            | BROKEN    |
      | 8  | Liebe oder Eierlikoer - Fast eine Romanze | Dora Heldt                     | Liebe, Eierlikoer, Romanze   | 01.02.2023 |              | 2             | NEW       |
      | 9  | Der letzte Sessellift                     | John Irving                    | Sessellift                   | 01.03.2023 |              | 1             | NEW       |
      | 10 | Troubadour                                | Martin Walker                  | Troubadour                   | 01.04.2023 | 06.07.2023   | 1             | NEW       |

  Szenario: Suche nach Büchern anhand Suchparametern mit Wörtern im Namen
    Angenommen folgende Bücher existieren
      | id | name                                      | authors                        | keywords                     | boughtDate | borrowedTill | timesBorrowed | condition |
      | 1  | Atlas - Die Geschichten von Pa Salt       | Harry Whittaker, Lucinda Riley | Atlas, Pa, Salt, Geschichten | 01.01.2021 |              | 70            | BROKEN    |
      | 2  | Das Cafe ohne Namen                       | Robert Seethaler               | Cafe, Namen                  | 01.02.2021 | 01.01.2024   | 7             | GOOD      |
      | 3  | Wie die Saat, so die Ernte                | Donna Leon                     | Saat, Ernte                  | 01.03.2021 | 01.01.2024   | 2             | BAD       |
      | 4  | Melody                                    | Martin Suter                   | Melody                       | 01.01.2021 | 01.01.2024   | 5             | GOOD      |
      | 5  | Die Liebe an miesen Tagen                 | Ewald Arenz                    | Liebe, Tagen, mies           | 01.02.2021 | 01.01.2024   | 7             | GOOD      |
      | 6  | Eine Frage der Chemie                     | Bonnie Garmus                  | Frage, Chemie                | 01.03.2021 | 01.01.2024   | 2             | BAD       |
      | 7  | Blue Skies                                | T.C. Boyle                     | Blue, Skies                  | 05.11.2020 | 01.01.2024   | 52            | BAD       |
      | 8  | Liebe oder Eierlikoer - Fast eine Romanze | Dora Heldt                     | Liebe, Eierlikoer, Romanze   | 01.02.2023 |              | 2             | NEW       |
      | 9  | Der letzte Sessellift                     | John Irving                    | Sessellift                   | 01.03.2023 |              | 1             | NEW       |
      | 10 | Troubadour                                | Martin Walker                  | Troubadour                   | 01.04.2023 | 06.07.2023   | 1             | NEW       |
    Und wir haben folgende Werte für den Suchparameter
      | names | authors | keywords | borrowed | borrowedAfter | boughtBefore | boughtAfter | minTimesBorrowed | maxTimesBorrowed | acceptableConditions |
      | die   |         |          |          |               |              |             |                  |                  |                      |
    Wenn alle vorhandenen Bücher zur Suche hinzugefügt werden
    Und der Suchparameter erstellt wird
    Und eine Suche mit den gegebenen Parametern durchgeführt wird
    Dann sollen folgende Bücher gefunden werden
      | id | name                                | authors                        | keywords                     | boughtDate | borrowedTill | timesBorrowed | condition |
      | 1  | Atlas - Die Geschichten von Pa Salt | Harry Whittaker, Lucinda Riley | Atlas, Pa, Salt, Geschichten | 01.01.2021 |              | 70            | BROKEN    |
      | 3  | Wie die Saat, so die Ernte          | Donna Leon                     | Saat, Ernte                  | 01.03.2021 | 01.01.2024   | 2             | BAD       |
      | 5  | Die Liebe an miesen Tagen           | Ewald Arenz                    | Liebe, Tagen, mies           | 01.02.2021 | 01.01.2024   | 7             | GOOD      |

  Szenario: Suche nach Büchern anhand Suchparametern mit Wörtern mit unterschiedlicher Groß- und Kleinschreibung
    Angenommen folgende Bücher existieren
      | id | name                                      | authors                        | keywords                     | boughtDate | borrowedTill | timesBorrowed | condition |
      | 1  | Atlas - Die Geschichten von Pa Salt       | Harry Whittaker, Lucinda Riley | Atlas, Pa, Salt, Geschichten | 01.01.2021 |              | 70            | BROKEN    |
      | 2  | Das Cafe ohne Namen                       | Robert Seethaler               | Cafe, Namen                  | 01.02.2021 | 01.01.2024   | 7             | GOOD      |
      | 3  | Wie die Saat, so die Ernte                | Donna Leon                     | Saat, Ernte                  | 01.03.2021 | 01.01.2024   | 2             | BAD       |
      | 4  | Melody                                    | Martin Suter                   | Melody                       | 01.01.2021 | 01.01.2024   | 5             | GOOD      |
      | 5  | Die Liebe an miesen Tagen                 | Ewald Arenz                    | Liebe, Tagen, mies           | 01.02.2021 | 01.01.2024   | 7             | GOOD      |
      | 6  | Eine Frage der Chemie                     | Bonnie Garmus                  | Frage, Chemie                | 01.03.2021 | 01.01.2024   | 2             | BAD       |
      | 7  | Blue Skies                                | T.C. Boyle                     | Blue, Skies                  | 05.11.2020 | 01.01.2024   | 52            | BAD       |
      | 8  | Liebe oder Eierlikoer - Fast eine Romanze | Dora Heldt                     | Liebe, Eierlikoer, Romanze   | 01.02.2023 |              | 2             | NEW       |
      | 9  | Der letzte Sessellift                     | John Irving                    | Sessellift                   | 01.03.2023 |              | 1             | NEW       |
      | 10 | Troubadour                                | Martin Walker                  | Troubadour                   | 01.04.2023 | 06.07.2023   | 1             | NEW       |
    Und wir haben folgende Werte für den Suchparameter
      | names | authors | keywords | borrowed | borrowedAfter | boughtBefore | boughtAfter | minTimesBorrowed | maxTimesBorrowed | acceptableConditions |
      | die   | HARRY   |          |          |               |              |             |                  |                  |                      |
    Wenn alle vorhandenen Bücher zur Suche hinzugefügt werden
    Und der Suchparameter erstellt wird
    Und eine Suche mit den gegebenen Parametern durchgeführt wird
    Dann sollen folgende Bücher gefunden werden
      | id | name                                | authors                        | keywords                     | boughtDate | borrowedTill | timesBorrowed | condition |
      | 1  | Atlas - Die Geschichten von Pa Salt | Harry Whittaker, Lucinda Riley | Atlas, Pa, Salt, Geschichten | 01.01.2021 |              | 70            | BROKEN    |


  Szenario: Suche nach Büchern anhand zusammengesetztem Suchparameter
    Angenommen folgende Bücher existieren
      | id | name                                      | authors                        | keywords                     | boughtDate | borrowedTill | timesBorrowed | condition |
      | 1  | Atlas - Die Geschichten von Pa Salt       | Harry Whittaker, Lucinda Riley | Atlas, Pa, Salt, Geschichten | 01.01.2021 |              | 70            | BROKEN    |
      | 2  | Das Cafe ohne Namen                       | Robert Seethaler               | Cafe, Namen                  | 01.02.2021 | 01.01.2024   | 7             | GOOD      |
      | 3  | Wie die Saat, so die Ernte                | Donna Leon                     | Saat, Ernte                  | 01.03.2021 | 01.01.2024   | 2             | BAD       |
      | 4  | Melody                                    | Martin Suter                   | Melody                       | 01.01.2021 | 01.01.2024   | 5             | GOOD      |
      | 5  | Die Liebe an miesen Tagen                 | Ewald Arenz                    | Liebe, Tagen, mies           | 01.02.2021 | 01.01.2024   | 7             | GOOD      |
      | 6  | Eine Frage der Chemie                     | Bonnie Garmus                  | Frage, Chemie                | 01.03.2021 | 01.01.2024   | 2             | BAD       |
      | 7  | Blue Skies                                | T.C. Boyle                     | Blue, Skies                  | 05.11.2020 | 01.01.2024   | 52            | BAD       |
      | 8  | Liebe oder Eierlikoer - Fast eine Romanze | Dora Heldt                     | Liebe, Eierlikoer, Romanze   | 01.02.2023 |              | 2             | NEW       |
      | 9  | Der letzte Sessellift                     | John Irving                    | Sessellift                   | 01.03.2023 |              | 1             | NEW       |
      | 10 | Troubadour                                | Martin Walker                  | Troubadour                   | 01.04.2023 | 06.07.2023   | 1             | NEW       |
    Und wir haben folgende Werte für den Suchparameter
      | names | authors | keywords | borrowed | borrowedAfter | boughtBefore | boughtAfter | minTimesBorrowed | maxTimesBorrowed | acceptableConditions |
      |       | Martin  |          | true     | 01.01.2020    | 01.05.2023   | 01.01.2020  | 1                | 10               | GOOD                 |
      |       |         |          |          |               |              |             |                  |                  | NEW                    |
    Wenn alle vorhandenen Bücher zur Suche hinzugefügt werden
    Und der Suchparameter erstellt wird
    Und eine Suche mit den gegebenen Parametern durchgeführt wird
    Dann sollen folgende Bücher gefunden werden
      | id | name       | authors       | keywords   | boughtDate | borrowedTill | timesBorrowed | condition |
      | 4  | Melody     | Martin Suter  | Melody     | 01.01.2021 | 01.01.2024   | 5             | GOOD      |
      | 10 | Troubadour | Martin Walker | Troubadour | 01.04.2023 | 06.07.2023   | 1             | NEW       |




  Szenario: Suche nach Büchern mit Zeitüberschreitung
    Angenommen folgende Bücher existieren
      | id | name   | authors    | keywords | boughtDate | borrowedTill | timesBorrowed | condition |
      | 1  | Buch A | Max        | a, b     | 01.01.2021 | 01.01.2024   | 5             | GOOD      |
      | 2  | Buch B | Max, Peter | c        | 01.02.2021 | 01.01.2024   | 7             | GOOD      |
      | 3  | Buch C | Peter      | b, c     | 01.03.2021 | 01.01.2024   | 2             | BAD       |
    Wenn eine Suche mit dem folgenden Parametern durchgeführt wird
      | name | authors | keywords | borrowed | borrowedAfter | boughtBefore | boughtAfter | minTimesBorrowed | maxTimesBorrowed | acceptableConditions |
      |      | Simon   |          |          |               |              |             |                  |                  |                      |
    Dann sollte eine TimeLimitExceededException geworfen werden

  Szenario: Erstellen eines Suchparameters
    Wenn ein Suchparameter erstellt wird
    Dann sollte eine Instanz von SearchParameter.Builder zurückgegeben werden

  Szenario: Durchführen einer Suche mit einem Suchparameter und Rückgabe der Suchhistorie
    Angenommen folgende Bücher existieren
      | id | name   | authors    | keywords | boughtDate | borrowedTill | timesBorrowed | condition |
      | 1  | Buch A | Max        | a, b     | 01.01.2021 | 01.01.2024   | 5             | GOOD      |
      | 2  | Buch B | Max, Peter | c        | 01.02.2021 | 01.01.2024   | 7             | GOOD      |
      | 3  | Buch C | Peter      | b, c     | 01.03.2021 | 01.01.2024   | 2             | BAD       |
    Und wir haben folgende Werte für den Suchparameter
      | name   | authors | keywords | borrowed | borrowedAfter | boughtBefore | boughtAfter | minTimesBorrowed | maxTimesBorrowed | acceptableConditions |
      | Buch B |         |          |          |               |              |             |                  |                  |                      |
    Wenn eine Suche mit den gegebenen Parametern durchgeführt wird
    Dann sollen folgende Bücher gefunden werden
      | id | name   | authors    | keywords | boughtDate | borrowedTill | timesBorrowed | condition |
      | 2  | Buch B | Max, Peter | c        | 01.02.2021 | 01.01.2024   | 7             | GOOD      |
    Und in der Suchhistorie soll folgender Suchparameter gespeichert sein
      | name   | authors | keywords | borrowed | borrowedAfter | boughtBefore | boughtAfter | minTimesBorrowed | maxTimesBorrowed | acceptableConditions |
      | Buch B |         |          |          |               |              |             |                  |                  |                      |
    Und in der Suchhistorie sollen folgende Bücher gefunden werden
      | id | name   | authors    | keywords | boughtDate | borrowedTill | timesBorrowed | condition |
      | 2  | Buch B | Max, Peter | c        | 01.02.2021 | 01.01.2024   | 7             | GOOD      |
