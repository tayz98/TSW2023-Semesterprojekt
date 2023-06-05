# language: de
  Funktionalität: Nach einem Buch suchen
    Eine Suche muss mind. ein Buch ausgeben
    Sonst null.

  Szenario: Peter sucht nach dem Buch mit dem Titel "Beispieltitel"
    Angenommen wir haben ein Buch mit dem Titel "Beispieltitel"
    Und das Buch wurde noch nicht verliehen
    Dann soll er sich das Buch ausleihen können

    Szenario: Marvin such nach dem Buch mit dem Titel "Hallo"
      Angenommen wir haben ein Buch mit dem Titel "Hallo"
      Und das Buch wurde bereits verliehen
      Dann soll er sich das Buch nicht ausleihen können
