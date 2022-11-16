package at.itkolleg.credentials;

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
     * Mit dieser Klasse delegiert der konkrete Decorator die Arbeiten an die umschlossene konkrete Komponente
     * (= der konkrete Exporter) weiter. Vorher fügt er den Benutzer-Login-Daten aber das Passwort als
     * Passwort-Hash hinzu
     *
     *@param credentialsList ist die zu exportierende Liste an Benutzer-Login-Daten.
     */
    @Override
    public void export(List<Credentials> credentialsList) {

        // Konkrete Dekorierer fügen dem Ergebnis etwas eigenes hinzufügen.
        // 1. Das Passwort der übergebenen Daten Hashen
        // 2. Die veränderten Daten an die eingewrappte konkrete Komponente übergeben

        for(int i = 0;i<credentialsList.size();i++)
        {

            Credentials c = credentialsList.get(i);
            //String hashPwd = c.getPwd();
            String hashPwd = "#####";
            c.setPwd(hashPwd);
        }
        wrappedCredentials.export(credentialsList);
    }



}
