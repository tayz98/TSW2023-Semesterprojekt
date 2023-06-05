#language: de

Funktionalität: Bücher erstellen
  Ein Buch muss eine eindeutige Identifikationsnummer, sowie
  einen Namen,
  mindestens einen Autor,
  eine beliebige Anzahl an Schlüsselwörtern,
  ein Rückgabedatum, falls sie ausgeliehen sind,
  einen Zähler, wie oft sie ausgeliehen wurden,
  ein Datum, an dem sie gekauft wurden,
  und einen Zustand haben.
  Sonst wird eine Exception geworfen.

  Szenario: Es wird das Buch "Der Osten: eine westdeutsche Erfindung" erstellt.
    Angenommen wir haben den Titel "Der Osten: eine westdeutsche Erfindung"
    Und die ISBN 978355020
    Und den Autor "Dirk Oschmann"
    Und die Autor*innen ""Autor 1", "Autor 2", Autor 3""
    Und die Liste von Autor*innen
      | Sören |
      | Alex  |
      | Felix |
    Und die Schlagwörter ""Erfindung", "Osten""
    Und das Kaufdatum "21.05.2002"
    Und das Ausleihdatum "30.06.2023"
    Und den Zustand "BROKEN"
    Und 3 Ausleihen