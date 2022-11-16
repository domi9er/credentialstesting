package at.itkolleg.credentials;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Credentials> credentialsList = new ArrayList<>();
        credentialsList.add(new Credentials("www.gmx.at","123zuesss", "a.iller"));
        credentialsList.add(new Credentials("www.hotmail.com","asdfjköljk", "corban.nerum"));
        credentialsList.add(new Credentials("www.xyz.net","9fas8dfu9ee", "bobba.fett"));
        credentialsList.add(new Credentials("www.testitest.test","askjdkslhhf", "manuel.payer"));
        ExportCredentials exportCredentials =  new HashDecorator(new CsvExporter()); //Dem Decorator wird der Exporter übergeben
        exportCredentials.export(credentialsList);
    }
}
