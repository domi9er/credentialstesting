package at.itkolleg.credentials;

import java.nio.charset.StandardCharsets;



/**
 * author: Nicole
 * Version: 1.0
 */

// Hashing-Algorithmus
public abstract class Hashing implements ExportCredentials{
    private Object originalString;

    String sha256hex = Hashing.sha256()
            .hashString(originalString, StandardCharsets.UTF_8)
            .toString();

    private static Object sha256() {
        return null;
    }
}
