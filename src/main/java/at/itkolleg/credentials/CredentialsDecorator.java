package at.itkolleg.credentials;


import java.util.List;

public class CredentialsDecorator implements ExportCredentials {

    protected Credentials pwdHashed;

    /**
     * Implementiert ExportCredentials
     * Erzeugt Variable für Gehashtes Passwort
     * @param pwdHashed
     */
    public CredentialsDecorator(Credentials pwdHashed) {
        this.pwdHashed = pwdHashed;
    }


    @Override
    public void export(List<Credentials> credentialsList) {

    }
}
