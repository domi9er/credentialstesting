package at.itkolleg.credentials;

import com.google.common.hash.Hashing;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

/**
 * Diese Klasse repräsentiert einen Decorator, dessen Aufgabe es ist das Passwort an einem Objekt aus einer ArrayListe mittels
 * der Methode export(), welche die Klasse vom Interface ExportCredentials implementiert.
 */
public class HashDecorator implements ExportCredentials{

    protected ExportCredentials credentials;

    /**
     * Konstruktor, der ein Objekt vom Typ ExportCredentials erstellt und der mitgegebene Wert wird auf die globale Variable gesetzt
     * @param credentials
     */
    public HashDecorator(ExportCredentials credentials)
    {
        this.credentials = credentials;
    }

    /**
     * Methode, die einen String benötigt und diesen String dann durch eine Hash Funktion in einen Hash umwandelt
     * @param originalString
     * @return
     */
    public String stringHash(String originalString)
    {

        String sha256hex = Hashing.sha256()
                .hashString(originalString, StandardCharsets.UTF_8)
                .toString();

        return sha256hex;
    }

    /**
     * Überschriebene Methode, die vom Interface ExportCredentials kommt. Der Array wird durch iteriert und die einzelnen
     * Getter Methoden werden an der ArrayList aufgerufen. Die Iterierung endet, wenn der letzte Eintrag der Liste erreicht wurde.
     * @param credentialsList
     */
    @Override
    public void export(List<Credentials> credentialsList) {

        List<Credentials> HashedList = new ArrayList<>();

        for(int i = 0;i<credentialsList.size();i++)
        {
            Credentials credentials = credentialsList.get(i);
            Credentials newCred = new Credentials(credentials.getHost(), credentials.getUser(), stringHash(credentials.getPwd()));
            HashedList.add(newCred);
        }

        this.credentials.export(HashedList);
    }
}
