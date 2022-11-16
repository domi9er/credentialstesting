package at.itkolleg.credentials;

import java.nio.charset.StandardCharsets;
import java.util.List;

public class HashDecorator implements ExportCredentials{

    protected Credentials credentials;

    public HashDecorator(Credentials credentials)
    {
        this.credentials = credentials;
    }

    public String stringHash(String originalString)
    {
        Object Hashing = null;
        String sha256hex = Hashing.sha256()
                .hashString(originalString, StandardCharsets.UTF_8)
                .toString();

        return sha256hex;
    }


    @Override
    public void export(List<Credentials> credentialsList) {
        String exportString = "";
        for(int i = 0;i<credentialsList.size();i++)
        {
            Credentials credentials = credentialsList.get(i);
            exportString += credentials.getHost() +";"+ credentials.getUser() +";"+ stringHash(credentials.getPwd());
            if(i < credentialsList.size()-1)
            {
                exportString += "\n";
            }
        }
        System.out.println(exportString);
    }
}
