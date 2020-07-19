package persons.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.BadSqlGrammarException;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import persons.models.Persons;
import persons.repositories.PersonsRepository;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

@Component
public class AuthProviderImpl implements AuthenticationProvider {


    @Autowired
    PersonsRepository personsRepository;


    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {

        String login = authentication.getName();
        Persons persons = personsRepository.getLogin(login);
        String password = authentication.getCredentials().toString();
        PasswordCoder passwordCoder = null;
        try {
            passwordCoder = new PasswordCoder(password);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        String ss = passwordCoder.getHashtext();
        String bb = persons.getPassword();
        if (persons == null) {
            throw new UsernameNotFoundException("User not found");
        }
        if (bb.equals(ss)) {
            System.out.println("dddddd");
        }
//
//        System.out.println(" password from BD " +  " " + persons.getPassword());
//        System.out.println("hash text print from auth prov  " +  " " + passwordCoder.getHashtext());
        System.out.println(persons.getPassword() + "\n" + passwordCoder.getHashtext());

        if (!persons.getPassword().equals(passwordCoder.getHashtext())) {
            throw new BadCredentialsException("Bad credential");

        }


        List<GrantedAuthority> authorities = new ArrayList<>();

        return new UsernamePasswordAuthenticationToken(persons, null, authorities);
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return aClass.equals(UsernamePasswordAuthenticationToken.class);
    }

}
