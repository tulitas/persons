package persons.security;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.security.NoSuchAlgorithmException;

public class PasswordCoder {

//    private byte[] hashedPassword;
//    private byte[] salt;
    private String existingPassword;

    public PasswordCoder(String password) throws NoSuchAlgorithmException {
//        try {
//            MessageDigest md = MessageDigest.getInstance("SHA-512");
//            byte[] messageDigest = md.digest(password.getBytes());
//            BigInteger no = new BigInteger(1, messageDigest);
//            existingPassword = no.toString(16);
//            hashedPassword = md.digest(password.getBytes(UTF_8));

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        existingPassword = encoder.encode(password);



//        }

//        catch (NoSuchAlgorithmException e) {
//            throw new RuntimeException(e);
//        }


    }

//    public byte[] getHashedPassword() {
//        return hashedPassword;
//    }
//
//    public void setHashedPassword(byte[] hashedPassword) {
//        this.hashedPassword = hashedPassword;
//    }
//
//    public byte[] getSalt() {
//        return salt;
//    }
//
//    public void setSalt(byte[] salt) {
//        this.salt = salt;
//    }

    public String getExistingPassword() {
        return existingPassword;
    }

    public void setExistingPassword(String existingPassword) {
        this.existingPassword = existingPassword;
    }
}
