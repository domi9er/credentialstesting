package at.itkolleg.credentials;

import com.google.common.hash.Hashing;

import java.nio.charset.StandardCharsets;
import java.util.List;

/**
 * Diese Klasse ist der konkrete Dekorierer. Er implementiert eine spezielle Dekoration. In dem Fall soll das Passwort als
 * Passwort-Hash anstatt als Klartext dargestellt werden.
 *
 * @author Angela Qoku
 * @version 16.11.2022
 */

public class HashDecorator extends ADecorator{

    /**
     * Super Konstruktor des HashDecorator. Dieser holt sich den konkreten Exporter aus der Oberklasse
     *
     * @param wrappedCredentials ist der konkrete Exporter welcher vom Decorator umschlossen und um die gewünschte
     *                           Funktion erweitert wird.
     */
    public HashDecorator(ExportCredentials wrappedCredentials) {
        super(wrappedCredentials);
    }


    /**
     * In dieser Klasse fügt der konkrete Dekorierer den Benutzer-Login-Daten die gehashten Passwörter hinzu.
     * Er holt sich die ursprünglichen Passwörter, übergibt sie an die hashing Methode und schreibt die
     * Ergebnisse als neue Passwörter wieder in die Benutzer-Login-Daten.
     *
     * Dann delegiert der konkrete Decorator die restlichen Arbeiten an den veränderten Daten
     * an die umschlossene konkrete Komponente (= der konkrete Exporter) weiter.
     *
     * @param credentialsList ist die zu exportierende Liste an Benutzer-Login-Daten.
     */
    @Override
    public void export(List<Credentials> credentialsList) {

        // Konkrete Dekorierer fügen dem Ergebnis etwas eigenes hinzufügen.
        // 1. Das Passwort der übergebenen Daten Hashen
        // 2. Die veränderten Daten an die eingewrappte konkrete Komponente übergeben

        for(int i = 0;i<credentialsList.size();i++)
        {
            Credentials c = credentialsList.get(i);
            // Benutzerpasswort an hashing Methode übergeben und gehashtes Passwort in Variable speichern
            String hashPwd = hashMethod(c.getPwd());

            //gehashtes Passwort als Passwort wieder in die Benutzerdaten schreiben
            c.setPwd(hashPwd);
        }
        wrappedCredentials.export(credentialsList);
    }

    /**
     * In dieser Klasse wird der als Parameter übergebene String mit dem Hasing-Algorithmus SHA256 gehasht und
     * das Ergebnis wird dann zurückgegeben.
     *
     * @param hashString ist der zu hashende String.
     * @return sha256hex ist der fertige gehashte String
     */
    public String hashMethod(String hashString) {

        //Den übergebenen String mit Hasing-Algorithmus SHA256 hashen
        String sha256hex = Hashing.sha256()
                .hashString(hashString, StandardCharsets.UTF_8)
                .toString();

        return sha256hex;
    }
}
