package persons.services;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.SimpleUrlLogoutSuccessHandler;
import org.springframework.stereotype.Service;
import persons.models.Persons;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Service
public class CustomLogoutSuccessHandler extends SimpleUrlLogoutSuccessHandler {

    @Override
    public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response,
                                Authentication authentication) throws IOException, ServletException {

        Object principal = authentication.getPrincipal();
        if (principal instanceof Persons) {
            Persons user = (Persons) principal;
            if( user.getLogin().equals("user") ){
                response.sendRedirect( request.getContextPath() + "/logout/user" );
            }
        }
        response.sendRedirect(  request.getContextPath() + "/" );

    }
}
