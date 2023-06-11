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
    Und die Identifikationsnummer 1
    Und den Autor "Dirk Oschmann"
    Und die Schlagwörter "Erfindung, Osten"
    Und das Kaufdatum "23.02.2023"
    Und das Ausleihdatum "30.06.2023"
    Und den Zustand NEW
    Und 3 Ausleihen
    Wenn damit ein Buch erstellt wird
    Dann soll das Buch existieren

  Szenario: Es wird das Buch "Der Osten: eine westdeutsche Erfindung" ohne Identifikationsnummer erstellt.
    Angenommen wir haben den Titel "Der Osten: eine westdeutsche Erfindung"
    Und den Autor "Dirk Oschmann"
    Und die Schlagwörter "Erfindung", Osten""
    Und das Kaufdatum "23.02.2023"
    Und das Ausleihdatum "30.06.2023"
    Und den Zustand NEW
    Und 3 Ausleihen
    Wenn damit ein Buch erstellt wird
    Dann soll das Buch nicht existieren
    Und es wird eine Fehlermeldung ausgegeben

  Szenario: Es wird das Buch "Der Osten: eine westdeutsche Erfindung" ohne Autor erstellt.
    Angenommen wir haben den Titel "Der Osten: eine westdeutsche Erfindung"
    Und die Identifikationsnummer 1
    Und die Schlagwörter "Erfindung", Osten""
    Und das Kaufdatum "23.02.2023"
    Und das Ausleihdatum "30.06.2023"
    Und den Zustand NEW
    Und 3 Ausleihen
    Wenn damit ein Buch erstellt wird
    Dann soll das Buch nicht existieren
    Und es wird eine Fehlermeldung ausgegeben

  Szenario: Es wird das Buch "Der Osten: eine westdeutsche Erfindung" ohne Kaufdatum erstellt.
    Angenommen wir haben den Titel "Der Osten: eine westdeutsche Erfindung"
    Und die Identifikationsnummer 1
    Und den Autor "Dirk Oschmann"
    Und die Schlagwörter "Erfindung, Osten"
    Und das Ausleihdatum "30.06.2023"
    Und den Zustand NEW
    Und 3 Ausleihen
    Wenn damit ein Buch erstellt wird
    Dann soll das Buch nicht existieren
    Und es wird eine Fehlermeldung ausgegeben

  Szenario: Es wird das Buch "Der Osten: eine westdeutsche Erfindung" ohne Ausleihdatum erstellt.
    Angenommen wir haben den Titel "Der Osten: eine westdeutsche Erfindung"
    Und die Identifikationsnummer 1
    Und den Autor "Dirk Oschmann"
    Und die Schlagwörter "Erfindung", Osten""
    Und das Kaufdatum "23.02.2023"
    Und den Zustand NEW
    Und 3 Ausleihen
    Wenn damit ein Buch erstellt wird
    Dann soll das Buch existieren

  Szenario: Es wird das Buch "Der Osten: eine westdeutsche Erfindung" ohne Zustand erstellt.
    Angenommen wir haben den Titel "Der Osten: eine westdeutsche Erfindung"
    Und die Identifikationsnummer 1
    Und den Autor "Dirk Oschmann"
    Und die Schlagwörter "Erfindung", Osten""
    Und das Kaufdatum "23.02.2023"
    Und das Ausleihdatum "30.06.2023"
    Und 3 Ausleihen
    Wenn damit ein Buch erstellt wird
    Dann soll das Buch nicht existieren
    Und es wird eine Fehlermeldung ausgegeben

  Szenario: Es wird das Buch "Der Osten: eine westdeutsche Erfindung" ohne Ausleihen erstellt.
    Angenommen wir haben den Titel "Der Osten: eine westdeutsche Erfindung"
    Und die Identifikationsnummer 1
    Und den Autor "Dirk Oschmann"
    Und die Schlagwörter "Erfindung", Osten""
    Und das Kaufdatum "23.02.2023"
    Und das Ausleihdatum "30.06.2023"
    Und den Zustand NEW
    Wenn damit ein Buch erstellt wird
    Dann soll das Buch existieren

  Szenario: Es wird das Buch "Der Osten: eine westdeutsche Erfindung" mit negativer ISBN erstellt.
    Angenommen wir haben den Titel "Der Osten: eine westdeutsche Erfindung"
    Und die Identifikationsnummer -1
    Und den Autor "Dirk Oschmann"
    Und die Schlagwörter "Erfindung", Osten""
    Und das Kaufdatum "23.02.2023"
    Und das Ausleihdatum "30.06.2023"
    Und den Zustand NEW
    Und 3 Ausleihen
    Wenn damit ein Buch erstellt wird
    Dann soll das Buch nicht existieren
    Und es wird eine Fehlermeldung ausgegeben

  Szenario: Es wird das Buch "Der Osten: eine westdeutsche Erfindung" mit einer Liste von Autor*innen erstellt.
    Angenommen wir haben den Titel "Der Osten: eine westdeutsche Erfindung"
    Und die Identifikationsnummer 1
    Und die Autor*innen "Dirk Oschmann, Sören Zacharias, Alexander Nachtigal, Felix Müller"
    Und die Schlagwörter "Erfindung, "Osten"
    Und das Kaufdatum "23.02.2023"
    Und das Ausleihdatum "30.06.2023"
    Und den Zustand NEW
    Und 3 Ausleihen
    Wenn damit ein Buch erstellt wird
    Dann soll das Buch existieren

  Szenario: Es wird das Buch "Der Osten: eine westdeutsche Erfindung" mit Zahlen als Autor*innen erstellt.
    Angenommen wir haben den Titel "Der Osten: eine westdeutsche Erfindung"
    Und die Identifikationsnummer 1
    Und die Autor*innen ""1", "2", "3", "4"""
    Und die Schlagwörter "Erfindung, Osten""
    Und das Kaufdatum "23.02.2023"
    Und das Ausleihdatum "30.06.2023"
    Und den Zustand NEW
    Und 3 Ausleihen
    Wenn damit ein Buch erstellt wird
    Dann soll das Buch nicht existieren
    Und es wird eine Fehlermeldung ausgegeben

  Szenario: Es wird das Buch "Der Osten: eine westdeutsche Erfindung" mit Kaufdatum in der Zukunft erstellt.
    Angenommen wir haben den Titel "Der Osten: eine westdeutsche Erfindung"
    Und die Identifikationsnummer 1
    Und den Autor "Dirk Oschmann"
    Und die Schlagwörter "Erfindung, Osten"
    Und das Kaufdatum "23.02.2024"
    Und das Ausleihdatum "30.06.2023"
    Und den Zustand NEW
    Und 3 Ausleihen
    Wenn damit ein Buch erstellt wird
    Dann soll das Buch nicht existieren
    Und es wird eine Fehlermeldung ausgegeben

  Szenario: Es wird das Buch "Der Osten: eine westdeutsche Erfindung" mit negativer Anzahl an Ausleihen erstellt.
    Angenommen wir haben den Titel "Der Osten: eine westdeutsche Erfindung"
    Und die Identifikationsnummer 1
    Und den Autor "Dirk Oschmann"
    Und die Schlagwörter "Erfindung, Osten"
    Und das Kaufdatum "23.02.2023"
    Und das Ausleihdatum "30.06.2023"
    Und den Zustand NEW
    Und -3 Ausleihen
    Wenn damit ein Buch erstellt wird
    Dann soll das Buch nicht existieren
    Und es wird eine Fehlermeldung ausgegeben

  Szenario: Es wird das Buch "Der Osten: eine westdeutsche Erfindung" mit einem Schlagwort erstellt.
    Angenommen wir haben den Titel "Der Osten: eine westdeutsche Erfindung"
    Und die Identifikationsnummer 1
    Und den Autor "Dirk Oschmann"
    Und das Schlagwort "Osten"
    Und das Kaufdatum "23.02.2023"
    Und das Ausleihdatum "30.06.2023"
    Und den Zustand NEW
    Und 3 Ausleihen
    Wenn damit ein Buch erstellt wird
    Dann soll das Buch existieren

  Szenario: Es wird das Buch "Der Osten: eine westdeutsche Erfindung" mit Kaufdatum vor dem ersten Buchdruck 1454 erstellt.
    Angenommen wir haben den Titel "Der Osten: eine westdeutsche Erfindung"
    Und die Identifikationsnummer 1
    Und den Autor "Dirk Oschmann"
    Und die Schlagwörter "Erfindung, Osten"
    Und das Kaufdatum "01.01.1453"
    Und das Ausleihdatum "30.06.2023"
    Und den Zustand NEW
    Und 3 Ausleihen
    Wenn damit ein Buch erstellt wird
    Dann soll das Buch nicht existieren
    Und es wird eine Fehlermeldung ausgegeben

  Szenario: Es wird das Buch "Der Osten: eine westdeutsche Erfindung" erstellt und auf Werte überprüft.
    Angenommen wir haben den Titel "Der Osten: eine westdeutsche Erfindung"
    Und die Identifikationsnummer 1
    Und den Autor "Dirk Oschmann"
    Und die Schlagwörter "Erfindung, Osten"
    Und das Kaufdatum "23.02.2023"
    Und das Ausleihdatum "30.06.2023"
    Und den Zustand NEW
    Und 3 Ausleihen
    Wenn damit ein Buch erstellt wird
    Dann soll das Buch existieren
    Und der Titel "Der Osten: eine westdeutsche Erfindung" angelegt sein
    Und die Identifikationsnummer 1 angelegt sein
    Und der Autor "Dirk Oschmann" angelegt sein
    Und die Schlagwörter "Erfindung, Osten" angelegt sein
    Und das Kaufdatum "23.02.2023" angelegt sein
    Und das Ausleihdatum "30.06.2023" angelegt sein
    Und der Zustand NEW angelegt sein
    Und 3 Ausleihen angelegt sein

  Szenario: Es wird das Buch "Der Osten: eine westdeutsche Erfindung" mit unrealistischer Anzahl an Ausleihen erstellt.
    Angenommen wir haben den Titel "Der Osten: eine westdeutsche Erfindung"
    Und die Identifikationsnummer 1
    Und den Autor "Dirk Oschmann"
    Und die Schlagwörter "Erfindung, Osten"
    Und das Kaufdatum "23.02.2023"
    Und das Ausleihdatum "30.06.2023"
    Und den Zustand NEW
    Und 150 Ausleihen
    Wenn damit ein Buch erstellt wird
    Dann soll das Buch nicht existieren
    Und es wird eine Fehlermeldung ausgegeben