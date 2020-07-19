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

    private PasswordCoder passwordCoder;
    @Autowired
    PersonsRepository personsRepository;


    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String login = authentication.getName();
        Persons persons = personsRepository.getLogin(login);



        if (persons == null) {
            throw new UsernameNotFoundException("User not found");
        }
        String password = authentication.getCredentials().toString();
        try {
             passwordCoder = new PasswordCoder(password);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        System.out.println("Entered  login  and password  -> " + login + " " + password);
        System.out.println("coded entered pass and from BD " + passwordCoder.getHashedPassword()+ " " + persons.getPassword());
        if (!passwordCoder.getHashedPassword().equals(persons.getPassword())) {
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
