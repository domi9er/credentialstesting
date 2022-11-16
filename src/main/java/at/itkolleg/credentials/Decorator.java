package at.itkolleg.credentials;

/**
 * This class is a base Decorator
 *
 * @Author Sonja
 * @Version 1.0
 * @Param credentials is
 */

public abstract class Decorator implements ExportCredentials{
    private final Credentials credentials;
    protected  CsvExporter csvExporter = new CsvExporter();




    protected Decorator (Credentials credentials) {
        this.credentials = credentials;
        csvExporter = new CsvExporter();
    }

    public void hash (String pwd){
        credentials.getPwd();
    }


}
