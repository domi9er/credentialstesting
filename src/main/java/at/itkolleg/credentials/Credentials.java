package at.itkolleg.credentials;

import java.util.Objects;

public class Credentials {

    private String host;
    private static String pwd;
    private String user;

    public Credentials(String host, String pwd, String user) {
        this.host = host;
        this.pwd = pwd;
        this.user = user;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Credentials that = (Credentials) o;
        return Objects.equals(host, that.host) && Objects.equals(pwd, that.pwd) && Objects.equals(user, that.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(host, pwd, user);
    }
}
