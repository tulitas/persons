package persons.security;

import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;
import persons.models.Persons;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

import static java.nio.charset.StandardCharsets.UTF_8;

public class PasswordCoder {

    private byte[] hashedPassword;

    public PasswordCoder(String password) throws NoSuchAlgorithmException {


        SecureRandom random = new SecureRandom();
        byte[] salt = new byte[16];
        random.nextBytes(salt);
        MessageDigest md = MessageDigest.getInstance("SHA-512");
        md.update(salt);
        hashedPassword = md.digest(password.getBytes(UTF_8));

    }


    public byte[] getHashedPassword() {
        return hashedPassword;
    }

    public void setHashedPassword(byte[] hashedPassword) {
        this.hashedPassword = hashedPassword;
    }
}
