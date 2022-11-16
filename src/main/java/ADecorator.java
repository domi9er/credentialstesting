import at.itkolleg.credentials.Credentials;
import at.itkolleg.credentials.ExportCredentials;

import java.util.List;

/**
 * Diese Klasse ist der abstrakte Dekorierer. Er hat eine Referenz auf die abstrakte Komponente (Export Credentials)
 * und implementiert genauso wie die konkreten Komponenten deren Schnittstelle. Er gibt sich quasi als Komponente aus.
 *
 *@author Angela Qoku
 *@version 1.0
 */

public abstract class ADecorator implements ExportCredentials {

    private ExportCredentials wrappedCredentials;

    /**
     * Konstruktor des ADecorator. Beim Erstellen des Decorators wird diesem ein konkreter Exporter mitgegeben,
     * an welchen er dann alle Arbeiten delegiert.
     *
     *@param wrappedCredentials ist der konkrete Exporter welcher vom Decorator eingewrapped und um die gewünschte
     *                          Funktion erweitert wird.
     */

    public ADecorator(ExportCredentials wrappedCredentials) {
        this.wrappedCredentials = wrappedCredentials;
    }


    //Der Decorator delegiert die Arbeiten an die konkrete Komponente
    @Override
    public void export(List<Credentials> credentialsList) {
        wrappedCredentials.export(credentialsList);
    }
}
