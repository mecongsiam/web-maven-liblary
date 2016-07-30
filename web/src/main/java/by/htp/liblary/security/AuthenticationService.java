package by.htp.liblary.security;

import by.htp.liblary.entity.User;
import by.htp.liblary.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by meco on 08.07.2016.
 */
@Service("authenticationService")
public class AuthenticationService implements UserDetailsService{
    @Autowired
    private IUserService userService;


    @Override
    public CustomUser loadUserByUsername(String login) throws UsernameNotFoundException {
       User user=userService.getUserByLogin(login);

        System.out.println(user.getRole()+" "+user.getLogin());
        if(user==null){
            System.out.println("GGGGGAAAVVVVV");
        }
        List<GrantedAuthority> grantedAuthorities=new ArrayList<>();
        grantedAuthorities.add(new SimpleGrantedAuthority(user.getRole()));

        return new CustomUser(user,true,true,true,true,grantedAuthorities);
    }



}
