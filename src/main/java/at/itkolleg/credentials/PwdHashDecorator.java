package at.itkolleg.credentials;

import java.util.List;

public class PwdHashDecorator extends Decorator {

    protected PwdHashDecorator(Credentials credentials) {
        super(credentials);
    }

    @Override
    public void export(List<Credentials> credentialsList) {

    }

    @Override
    public void hash(String pwd) {
        super.hash(pwd);

    }




}
