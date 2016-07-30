package by.htp.liblary.security;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collection;

/**
 * Created by meco on 08.07.2016.
 */
public class AuthenticationSuccessHandlerImpl implements AuthenticationSuccessHandler {
    private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();
    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {

        boolean isUser=false;
        boolean isAdmin=false;
        String pagePath=null;

        Collection<? extends GrantedAuthority> authorities=authentication.getAuthorities();
        for(GrantedAuthority grantedAuthority:authorities){
            if(grantedAuthority.getAuthority().equals("admin")){
                isAdmin=true;
                break;
            }else if(grantedAuthority.getAuthority().equals("user")){
                isUser=true;
                break;
            }
        }
        if(isAdmin){
            pagePath="/logina";
        }else if(isUser){
            pagePath="/user_page";
        }
        redirectStrategy.sendRedirect(httpServletRequest,httpServletResponse,pagePath);



    }
}
