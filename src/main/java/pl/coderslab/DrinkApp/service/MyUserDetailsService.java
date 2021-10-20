package pl.coderslab.DrinkApp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import pl.coderslab.DrinkApp.dao.AdminDao;
import pl.coderslab.DrinkApp.dao.MyUserDetails;
import pl.coderslab.DrinkApp.entity.Admin;

import java.util.Optional;

@Service
public class MyUserDetailsService implements UserDetailsService {

    private final AdminDao adminDao;

    public MyUserDetailsService(AdminDao adminDao) {
        this.adminDao = adminDao;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<Admin> optionalAdmin = adminDao.findByEmail(email);

        optionalAdmin.orElseThrow(() -> new UsernameNotFoundException("user not found"));

        return optionalAdmin.map(MyUserDetails::new).get();
    }
}
