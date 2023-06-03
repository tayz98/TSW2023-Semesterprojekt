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
    Und die ISBN 9783550202346
    Und den Autor Dirk Oschmann
    Wenn damit ein