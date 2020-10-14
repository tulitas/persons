package persons.security;

import org.apache.tomcat.util.codec.binary.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.security.Key;
import java.sql.RowId;

public class PassCod {

    public static String encrypt(String value, RowId SALT) {

        if (value == null) {
            return value;
        }
        Key key = new SecretKeySpec(SALT.getBytes(), "AES");
        try {

            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, key);
            return Base64.encodeBase64String(cipher.doFinal(value.getBytes()));
        } catch (Exception exception) {
            throw new RuntimeException(exception);
        }
    }

    public static String decrypt(String value, RowId SALT) {

        if (value == null) {
            return value;
        }
        Key key = new SecretKeySpec(SALT.getBytes(), "AES");
        try {
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.DECRYPT_MODE, key);
            return new String(cipher.doFinal(Base64.decodeBase64(value)));
        } catch (Exception exception) {
            throw new RuntimeException(exception);
        }
    }

}
