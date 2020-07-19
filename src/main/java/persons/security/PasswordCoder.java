package persons.security;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

import static java.nio.charset.StandardCharsets.UTF_8;

public class PasswordCoder {

    private byte[] hashedPassword;
    private byte[] salt;
    private String hashtext;

    public PasswordCoder(String password) throws NoSuchAlgorithmException {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-512");
            byte[] messageDigest = md.digest(password.getBytes());
            BigInteger no = new BigInteger(1, messageDigest);
            hashtext = no.toString(16);
            hashedPassword = md.digest(password.getBytes(UTF_8));
//            while (hashtext.length() < 32)

                System.out.println("hash text from login page " + hashtext);
//            System.out.println("hashed password " + hashedPassword);



            // return the HashText

        }

        // For specifying wrong message digest algorithms
        catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }


    }

//        SecureRandom random = new SecureRandom();
//        salt = new byte[16];
//        random.nextBytes(salt);
//        MessageDigest md = MessageDigest.getInstance("SHA-512");
//        md.update(salt);
//        hashedPassword = md.digest(password.getBytes(UTF_8));


    public byte[] getHashedPassword() {
        return hashedPassword;
    }

    public void setHashedPassword(byte[] hashedPassword) {
        this.hashedPassword = hashedPassword;
    }

    public byte[] getSalt() {
        return salt;
    }

    public void setSalt(byte[] salt) {
        this.salt = salt;
    }

    public String getHashtext() {
        return hashtext;
    }

    public void setHashtext(String hashtext) {
        this.hashtext = hashtext;
    }
}
