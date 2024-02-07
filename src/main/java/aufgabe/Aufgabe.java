 package aufgabe;
import java.util.ArrayList;
import java.util.List;

/**
 * Bearbeitung des Aufgabenteils e) der Abiturprüfung 2021 in Informatik
 */
public class Aufgabe {

    public static void main(String[] args) {
        Aufgabe aufgabe = new Aufgabe();
        Sprachengenerator s = aufgabe.new SprachengeneratorJamil();
        System.out.println("Alle Wörter der ovalen Schienenstrecken mit der gewünschten maximalen Länge:");
        s.ermittleOvalSprache(8).forEach(System.out::println);
    }

    abstract class Sprachengenerator {
        abstract List<String> ermittleOvalSprache(int max);
    }

    /**
     * @author Jamil
     */
    class SprachengeneratorJamil extends Sprachengenerator {
        public List<String> ermittleOvalSprache(int max) {
            List<String> generierteWörter = new ArrayList<String>();

            for (int index = 0; index <= max; index++) {
                generierteWörter.add(erzeugeOvaleSchienenanlage(index));
            }

            return generierteWörter;
        }

        public String erzeugeOvaleSchienenanlage(int anzahlGeradeGleise) {
            String rechtskurve = "rr";
            String geradeGleise = "g".repeat(anzahlGeradeGleise);

            StringBuilder wort = new StringBuilder();

            return wort
                    .append(rechtskurve)
                    .append(geradeGleise)
                    .toString()
                    .repeat(2);
        }
    }

    /**
     * @author Daniel
     */
    class SprachengeneratorDaniel extends Sprachengenerator {

        public List<String> ermittleOvalSprache(int maxLänge) {
            // Erstelle eine leere Liste, um die Wörter zu speichern
            List<String> wortListe = new ArrayList<String>();
            // Iteriere von 0 bis zur maximalen Länge
            for (int länge = 0; länge <= maxLänge; länge++) {
                // Erstelle einen leeren String, um die Gleisstrecke zu bilden
                String gleisStrecke = "";
                // Füge laenge-mal ein "g" zum String hinzu
                for (int i = 0; i < länge; i++) {
                    gleisStrecke = gleisStrecke + "g";
                }
                // Füge "rr" am Anfang und am Ende der Gleisstrecke hinzu
                gleisStrecke = "rr" + gleisStrecke;
                // Erstelle ein Wort aus zwei gleichen Gleisstrecken
                String wort = gleisStrecke + gleisStrecke;
                // Füge das Wort zur Liste hinzu
                wortListe.add(wort);
            }
            // Gib die Liste zurück
            return wortListe;
        }
    }
}
