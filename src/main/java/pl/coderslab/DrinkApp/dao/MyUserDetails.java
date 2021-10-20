package pl.coderslab.DrinkApp.dao;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import pl.coderslab.DrinkApp.entity.Admin;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MyUserDetails implements UserDetails {


    private String login;
    private String password;

    private List<GrantedAuthority> authorities;

    public MyUserDetails(Admin admin) {
        this.login = admin.getEmail();
        this.password = admin.getPassword();
        this.authorities = Stream.of("ROLE_ADMIN").map(SimpleGrantedAuthority::new).collect(Collectors.toList());
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return login;
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
