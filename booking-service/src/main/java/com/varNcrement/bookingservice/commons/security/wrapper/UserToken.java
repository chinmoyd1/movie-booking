package com.varNcrement.bookingservice.commons.security.wrapper;

import io.jsonwebtoken.Jwts;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.Base64;
import java.util.Collection;
import java.util.List;

import static java.util.stream.Collectors.toList;

@Component
public class UserToken implements UserDetails {

    private static final Logger logger = LoggerFactory.getLogger(UserToken.class);

    private String userName;
    private List<String> roles;

    @Value("${security.jwt.token.secret-key}")
    private String secretKey;

    @PostConstruct
    protected void init() {
        secretKey = Base64.getEncoder().encodeToString(secretKey.getBytes());
    }

    public UserDetails loadUserDetailsFromToken(String token) {
        this.userName = getUsername(token);
        this.roles = getRole(token);
        return this;
    }

    public String getUsername(String token) {
        logger.debug("Getting Username from Token Passed.");
        return Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody().getSubject();
    }

    public List<String> getRole(String token) {
        logger.debug("Getting Roles from Token Passed.");
        String raw_roles = Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody().get("roles").toString();
        return Arrays.stream(raw_roles.split(",")).map(s->{
                                                        if(s.contains("[")){
                                                            s = s.replace("[","");
                                                        }if(s.contains("]")){
                                                            s = s.replace("]","");
                                                        }
                                                        return "ROLE_"+s.trim();
                                                        }).collect(toList());
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.roles.stream().map(SimpleGrantedAuthority::new).collect(toList());
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public String getUsername() {
        return userName;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

}
