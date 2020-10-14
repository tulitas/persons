package persons.security;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.security.NoSuchAlgorithmException;

public class PasswordCoder {


    private String existingPassword;

    public PasswordCoder(String password) throws NoSuchAlgorithmException {


        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        existingPassword = encoder.encode(password);

    }

    public String getExistingPassword() {
        return existingPassword;
    }

    public void setExistingPassword(String existingPassword) {
        this.existingPassword = existingPassword;
    }
}
