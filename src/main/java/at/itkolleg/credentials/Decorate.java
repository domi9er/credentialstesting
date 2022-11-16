package at.itkolleg.credentials;

import com.google.common.hash.Hashing;

import java.nio.charset.StandardCharsets;
import java.util.List;

public class Decorate {

    public Decorate(Credentials pwd) {

        super(pwd);
    }

    public String export () {
        return super.export() + decorateHash();
    }
    private String decorateHash() {
        String pwdHashed = Hashing.sha256()
                .hashString(pwd, StandardCharsets.UTF_8)
                .toString();
        return pwdHashed;
    }
    @Override
    public void export(List<Credentials> credentialsList) {

    }
}