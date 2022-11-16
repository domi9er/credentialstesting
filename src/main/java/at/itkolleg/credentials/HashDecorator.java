package at.itkolleg.credentials;

import java.util.List;

public class HashDecorator implements ExportCredentials{

    protected Credentials credentials;

    public HashDecorator(Credentials credentials)
    {
        this.credentials = credentials;
    }

    public String stringHash(String originalString)
    {
        String sha256hex = Hashing.sha256()
                .hashString(originalString, StandardCharsets.UTF_8)
                .toString();

        return String;
    }


    @Override
    public void export(List<Credentials> credentialsList) {

    }
}
