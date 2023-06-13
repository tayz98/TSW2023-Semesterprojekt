#language: de

Funktionalität: Suchparameter erstellen
  Suchparameter können
  Namen,
  Autor*innen,
  Schlüsselwörter,
  einen Ausleihstatus,
  eine Abfrage, ob ein Buch nach dem gegeben Datum ausgeliehen ist,
  ein Kaufzeitfenster mit "gekauft vor" und "gekauft nach",
  eine Menge, wie oft ein Buch mindestens und maximal ausgeliehen wurde,
  sowie einen Zustand enthalten.

  Szenario: Erstelle Suchparameter mit einem Namen
    Angenommen wir haben die Namen
      | Der Osten: eine westdeutsche Erfindung |
    Wenn damit einen Suchparameter erstellt wird
    Dann soll der Suchparameter die folgenden Namen enthalten
      | Der Osten: eine westdeutsche Erfindung |

  Szenario: Erstelle Suchparameter mit gleichen Namen
    Angenommen wir haben die Namen
      | Der Osten: eine westdeutsche Erfindung |
      | Der Osten: eine westdeutsche Erfindung |
    Wenn damit einen Suchparameter erstellt wird
    Dann soll der Suchparameter die folgenden Namen enthalten
      | Der Osten: eine westdeutsche Erfindung |

  Szenario: Erstelle Suchparameter mit Namen und null
    Angenommen wir haben die Namen
      | Der Osten: eine westdeutsche Erfindung |
      |                                        |
    Wenn damit einen Suchparameter erstellt wird
    Dann soll der Suchparameter die folgenden Namen enthalten
      | Der Osten: eine westdeutsche Erfindung |

  Szenario: Erstelle Suchparameter mit mehreren Namen
    Angenommen wir haben die Namen
      | Der Osten: eine westdeutsche Erfindung |
      | Wie die Saat, so die Ernte             |
    Wenn damit einen Suchparameter erstellt wird
    Dann soll der Suchparameter die folgenden Namen enthalten
      | Der Osten: eine westdeutsche Erfindung |
      | Wie die Saat, so die Ernte             |

  Szenario: Erstelle Suchparameter mit einem/einer Autor/Autorin
    Angenommen wir haben die Autor*innen
      | Dirk Oschmann |
    Wenn damit einen Suchparameter erstellt wird
    Dann soll der Suchparameter folgende Autor*innen enthalten
      | Dirk Oschmann |

  Szenario: Erstelle Suchparameter mit Autor*innen
    Angenommen wir haben die Autor*innen
      | Dirk Oschmann |
      | Donna Leon    |
    Wenn damit einen Suchparameter erstellt wird
    Dann soll der Suchparameter folgende Autor*innen enthalten
      | Dirk Oschmann |
      | Donna Leon    |

  Szenario: Erstelle Suchparameter mit gleichen Autor*innen
    Angenommen wir haben die Autor*innen
      | Dirk Oschmann |
      | Dirk Oschmann |
    Wenn damit einen Suchparameter erstellt wird
    Dann soll der Suchparameter folgende Autor*innen enthalten
      | Dirk Oschmann |

  Szenario: Erstelle Suchparameter mit Autor*innen und null
    Angenommen wir haben die Autor*innen
      | Dirk Oschmann |
      |               |
    Wenn damit einen Suchparameter erstellt wird
    Dann soll der Suchparameter folgende Autor*innen enthalten
      | Dirk Oschmann |

  Szenario: Erstelle Suchparameter mit einem Schlüsselwort
    Angenommen wir haben die Schlüsselwörter
      | Osten |
    Wenn damit einen Suchparameter erstellt wird
    Dann soll der Suchparameter folgende Schlüsselwörter enthalten
      | Osten |

  Szenario: Erstelle Suchparameter mit einem Schlüsselwort und null
    Angenommen wir haben die Schlüsselwörter
      | Osten |
      |       |
    Wenn damit einen Suchparameter erstellt wird
    Dann soll der Suchparameter folgende Schlüsselwörter enthalten
      | Osten |

  Szenario: Erstelle Suchparameter mit mehreren Schlüsselwörtern
    Angenommen wir haben die Schlüsselwörter
      | Osten  |
      | Westen |
      | Saat   |
      | Ernte  |
    Wenn damit einen Suchparameter erstellt wird
    Dann soll der Suchparameter folgende Schlüsselwörter enthalten
      | Osten  |
      | Westen |
      | Saat   |
      | Ernte  |

  Szenario: Erstelle Suchparameter mit gleichen Schlüsselwörtern
    Angenommen wir haben die Schlüsselwörter
      | Osten |
      | Osten |
    Wenn damit einen Suchparameter erstellt wird
    Dann soll der Suchparameter folgende Schlüsselwörter enthalten
      | Osten |

  Szenario: Erstelle Suchparameter mit Ausleihstatus "ausgeliehen"
    Angenommen das Buch soll ausgeliehen sein
    Wenn damit einen Suchparameter erstellt wird
    Dann soll der Suchparameter den Ausleihstatus ausgeliehen enthalten

  Szenario: Erstelle Suchparameter mit Ausleihstatus "nicht ausgeliehen"
    Angenommen das Buch soll nicht ausgeliehen sein
    Wenn damit einen Suchparameter erstellt wird
    Dann soll der Suchparameter den Ausleihstatus nicht ausgeliehen enthalten

  Szenario: Erstelle Suchparameter mit Ausleihstatus und überschreibe diesen
    Angenommen das Buch soll ausgeliehen sein
    Und das Buch soll nicht ausgeliehen sein
    Wenn damit einen Suchparameter erstellt wird
    Dann soll der Suchparameter den Ausleihstatus nicht ausgeliehen enthalten

  Szenario: Erstelle Suchparameter mit Abfrage, ob ein Buch nach dem gegeben Datum ausgeliehen ist
    Angenommen wir fragen ab, ob ein Buch nach dem "23.02.2023" ausgeliehen wurde
    Wenn damit einen Suchparameter erstellt wird
    Dann soll der Suchparameter die Abfrage, ob ein Buch nach dem "23.02.2023" ausgeliehen wurde, enthalten

  Szenario: Erstelle Suchparameter mit Abfrage, ob ein Buch nach dem gegeben Datum ausgeliehen ist und überschreibe den Wert
    Angenommen wir fragen ab, ob ein Buch nach dem "23.02.2023" ausgeliehen wurde
    Und wir fragen ab, ob ein Buch nach dem "24.02.2023" ausgeliehen wurde
    Wenn damit einen Suchparameter erstellt wird
    Dann soll der Suchparameter die Abfrage, ob ein Buch nach dem "24.02.2023" ausgeliehen wurde, enthalten

  Szenario: Erstelle Suchparameter mit Datum, vor dem das Buch gekauft wurde
    Angenommen wir fragen ab, ob ein Buch vor dem "23.02.2023" gekauft wurde
    Wenn damit einen Suchparameter erstellt wird
    Dann soll der Suchparameter das Datum "23.02.2023", vor dem das Buch gekauft wurde, enthalten

  Szenario: Erstelle Suchparameter mit Datum, vor dem das Buch gekauft wurde und überschreiben den Wert
    Angenommen wir fragen ab, ob ein Buch vor dem "23.02.2023" gekauft wurde
    Und wir fragen ab, ob ein Buch vor dem "24.02.2023" gekauft wurde
    Wenn damit einen Suchparameter erstellt wird
    Dann soll der Suchparameter das Datum "24.02.2023", vor dem das Buch gekauft wurde, enthalten

  Szenario: Erstelle Suchparameter mit Datum, nach dem das Buch gekauft wurde
    Angenommen wir fragen ab, ob ein Buch nach dem "23.02.2023" gekauft wurde
    Wenn damit einen Suchparameter erstellt wird
    Dann soll der Suchparameter das Datum "23.02.2023", nach dem das Buch gekauft wurde, enthalten

  Szenario: Erstelle Suchparameter mit Datum, nach dem das Buch gekauft wurde und überschreiben den Wert
    Angenommen wir fragen ab, ob ein Buch nach dem "23.02.2023" gekauft wurde
    Und wir fragen ab, ob ein Buch nach dem "24.02.2023" gekauft wurde
    Wenn damit einen Suchparameter erstellt wird
    Dann soll der Suchparameter das Datum "24.02.2023", nach dem das Buch gekauft wurde, enthalten

  Szenario: Erstelle Suchparameter mit Menge, wie oft ein Buch mindestens ausgeliehen
    Angenommen wir haben die Zahl 2 als Menge wie oft ein Buch mindestens ausgeliehen wurde
    Wenn damit einen Suchparameter erstellt wird
    Dann soll der Suchparameter die Zahl 2 als Menge wie oft ein Buch mindestens ausgeliehen wurde enthalten

  Szenario: Erstelle Suchparameter mit Menge, wie oft ein Buch mindestens ausgeliehen wurde wurde und überschreibe Wert nochmal
    Angenommen wir haben die Zahl 2 als Menge wie oft ein Buch mindestens ausgeliehen wurde
    Und wir haben die Zahl 5 als Menge wie oft ein Buch mindestens ausgeliehen wurde
    Wenn damit einen Suchparameter erstellt wird
    Dann soll der Suchparameter die Zahl 5 als Menge wie oft ein Buch mindestens ausgeliehen wurde enthalten

  Szenario: Erstelle Suchparameter mit Menge, wie oft ein Buch maximal ausgeliehen wurde
    Angenommen wir haben die Zahl 5 als Menge wie oft ein Buch maximal ausgeliehen wurde
    Wenn damit einen Suchparameter erstellt wird
    Dann soll der Suchparameter die Zahl 5 als Menge wie oft ein Buch maximal ausgeliehen wurde enthalten

  Szenario: Erstelle Suchparameter mit Menge, wie oft ein Buch maximal ausgeliehen wurde wurde und überschreibe Wert nochmal
    Angenommen wir haben die Zahl 2 als Menge wie oft ein Buch mindestens ausgeliehen wurde
    Und wir haben die Zahl 5 als Menge wie oft ein Buch maximal ausgeliehen wurde
    Wenn damit einen Suchparameter erstellt wird
    Dann soll der Suchparameter die Zahl 5 als Menge wie oft ein Buch maximal ausgeliehen wurde enthalten

  Szenario: Erstelle Suchparameter mit einem Zustand
    Angenommen wir haben die Zustände
      | BROKEN |
    Wenn damit einen Suchparameter erstellt wird
    Dann soll der Suchparameter die folgenden akzeptierten Zustände enthalten
      | BROKEN |

  Szenario: Erstelle Suchparameter mit einem Zustand und null
    Angenommen wir haben die Zustände
      | BROKEN |
      |        |
    Wenn damit einen Suchparameter erstellt wird
    Dann soll der Suchparameter die folgenden akzeptierten Zustände enthalten
      | BROKEN |

  Szenario: Erstelle Suchparameter mit mehreren Zuständen
    Angenommen wir haben die Zustände
      | BROKEN |
      | BAD    |
    Wenn damit einen Suchparameter erstellt wird
    Dann soll der Suchparameter die folgenden akzeptierten Zustände enthalten
      | BROKEN |
      | BAD    |

  Szenario: Erstelle Suchparameter ohne Werte
    Angenommen wir haben keine Werte
    Wenn damit einen Suchparameter erstellt wird
    Dann soll der Suchparameter keine Werte enthalten

  Szenario: Erstelle Suchparameter mit allen Werten
    Angenommen wir haben die Namen
      | Der Osten: eine westdeutsche Erfindung |
      | Wie die Saat, so die Ernte             |
    Und wir haben die Autor*innen
      | Dirk Oschmann |
      | Donna Leon    |
    Und wir haben die Schlüsselwörter
      | Osten  |
      | Westen |
      | Saat   |
      | Ernte  |
    Und das Buch soll nicht ausgeliehen sein
    Und wir fragen ab, ob ein Buch nach dem "23.02.2023" ausgeliehen wurde
    Und wir fragen ab, ob ein Buch vor dem "30.05.2023" gekauft wurde
    Und wir fragen ab, ob ein Buch nach dem "23.02.2023" gekauft wurde
    Und wir haben die Zahl 2 als Menge wie oft ein Buch mindestens ausgeliehen wurde
    Und wir haben die Zahl 5 als Menge wie oft ein Buch maximal ausgeliehen wurde
    Und wir haben die Zustände
      | BROKEN |
      | BAD    |
    Wenn damit einen Suchparameter erstellt wird
    Dann soll der Suchparameter folgende Werte enthalten
      | names                                  | authors       | keywords | borrowed | borrowedAfter | boughtBefore | boughtAfter | minTimesBorrowed | maxTimesBorrowed | acceptableConditions |
      | Der Osten: eine westdeutsche Erfindung | Dirk Oschmann | Osten    | false    | 23.02.2023    | 30.05.2023   | 23.02.2023  | 2                | 5                | BROKEN               |
      | Wie die Saat, so die Ernte             | Donna Leon    | Westen   |          |               |              |             |                  |                  | BAD                  |
      |                                        |               | Saat     |          |               |              |             |                  |                  |                      |
      |                                        |               | Ernte    |          |               |              |             |                  |                  |                      |