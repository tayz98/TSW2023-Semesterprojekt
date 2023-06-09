#language: de

  Funktionalität: Suchparameter erstellen
    Suchparameter können
    Namen,
    Autoren,
    Schlüsselwörter,
    einen Ausleihstatus,
    eine Abfrage, ob ein Buch nach dem gegeben Datum ausgeliehen ist,
    ein Kaufzeitfenster,
    eine Menge, wie oft ein Buch ausgeliehen wurden ist,
    sowie einen Zustand enthalten.


  Szenario: Es wird nur der Name/die Namen zur Erstellung angegeben.
    Angenommen wir haben die Namen "Max, Otto, Johannes"
    Wenn damit versucht wird, ein Suchparameter zu erstellen
    Dann soll das möglich sein

    Szenario: Es wird nur der Autor/die Autoren zur Erstellung angegeben.
      Angenommen wir haben die Autoren "Thomas, Peter"
      Wenn damit versucht wird, ein Suchparameter zu erstellen
      Dann soll das möglich sein

    Szenario: Es werden nur Schlüsselwörter zur Erstellung angegeben.
      Angenommen wir haben die Schlüsselwörter "Banane, Apfel, Baum"
      Wenn damit versucht wird, ein Suchparameter zu erstellen
      Dann soll das möglich sein

    Szenario: Es wird nur ein Ausleihstatus zur Erstellung angegeben.
      Angenommen wir haben den Ausleihstatus true
      Wenn damit versucht wird, ein Suchparameter zu erstellen
      Dann soll das möglich sein

    Szenario: Es wird nur eine Abfrage
              ob ein Buch nach dem gegeben Datum ausgeliehen ist,
              zur Erstellung angegeben.
      Angenommen wir fragen ab, ob ein Buch nach dem "23.02.2023" erstellt wurde
      # Und wir haben das heutige Datum
      Wenn damit versucht wird, ein Suchparameter zu erstellen
      Dann soll das möglich sein

    Szenario: Es wird nur ein Kaufzeitfenster zur Erstellung angegeben.
      Angenommen wir haben ein Kaufzeitfenster
      Wenn damit versucht wird, ein Suchparameter zu erstellen
      Dann soll das möglich sein

      Szenario: Es wird nur die Menge,
                wie oft ein Buch ausgeliehen wurden ist,
                zur Erstellung angegeben
      Angenommen wir haben die Zahl 2 als Menge wie oft ein Buch ausgeliehen wurde
        Wenn damit versucht wird, ein Suchparemeter zu erstellen
        Dann soll das möglich sein

        Szenario: Es wird nur der Buchzustand angegeben zur Erstellung angegeben.
          Angenommen wir haben den Buchzustand "BROKEN"
          Wenn damit versucht wird, ein Suchparameter zu erstellen
          Dann soll das möglich sein
