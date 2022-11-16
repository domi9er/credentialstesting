package at.itkolleg.credentials;
import at.itkolleg.credentials.Credentials;
import at.itkolleg.credentials.ExportCredentials;
import java.util.List;

/**
 * Diese Klasse ist der abstrakte Dekorierer. Er hat eine Referenz auf die abstrakte Komponente (Export Credentials)
 * und implementiert genauso wie die konkreten Komponenten deren Schnittstelle. Er gibt sich quasi als Komponente aus.
 *
 * @author Angela Qoku
 * @version 16.11.2022
 */

public abstract class ADecorator implements ExportCredentials {

    protected ExportCredentials wrappedCredentials;

    /**
     * Konstruktor des ADecorator. Beim Erstellen des Decorators wird diesem ein konkreter Exporter mitgegeben,
     * an welchen er dann alle Arbeiten delegiert.
     *
     * @param wrappedCredentials ist der konkrete Exporter welcher vom Decorator umschlossen und um die gewünschte
     *                          Funktion erweitert wird.
     */

    public ADecorator(ExportCredentials wrappedCredentials) {
        this.wrappedCredentials = wrappedCredentials;
    }


    /**
     * Mit dieser Klasse delegiert der Decorator die Arbeiten an die konkrete Komponente (= der konkrete Exporter)
     *
     * @param credentialsList ist die zu exportierende Liste an Benutzer-Login-Daten.
     */
    @Override
    public void export(List<Credentials> credentialsList) {
        //Der Decorator delegiert die Arbeiten an die konkrete Komponente.
        //Zusätzliche Verhaltensweisen können in Konkreten Decorateuren hinzugefügt werden
        wrappedCredentials.export(credentialsList);
    }
}
