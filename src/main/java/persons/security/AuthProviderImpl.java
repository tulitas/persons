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
        System.out.println("Entered login and login from BD is  -> " + login + " " + persons);
//        String pas = personsRepository.getPassword();
//        System.out.println("entered pernon password is " + pas);
        String password = authentication.getCredentials().toString();
        if (persons == null) {
            throw new UsernameNotFoundException("User not found");
        }

        if (!password.equals(persons.getPassword())) {
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