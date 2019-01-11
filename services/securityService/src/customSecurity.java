/*Generated by WaveMaker Studio*/


import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.AuthenticationException;

import com.wavemaker.runtime.security.AuthRequestContext;
import com.wavemaker.runtime.security.WMCustomAuthenticationManager;
import com.wavemaker.runtime.security.WMUser;

import org.springframework.security.core.AuthenticationException;

public class customSecurity implements WMCustomAuthenticationManager {

 private static final Logger logger=LoggerFactory.getLogger(customSecurity.class);

 public WMUser authenticate(AuthRequestContext authRequestContext) throws AuthenticationException {
        String username = authRequestContext.getUsername();
        logger.info(username);
        if (username.equals("user1") && authRequestContext.getPassword().equals("user1")) {
            return new WMUser(username, authRequestContext.getPassword(), new ArrayList<String>());
        } else {
            throw new BadCredentialsException("User " + username + " not found");
        }
    }
}