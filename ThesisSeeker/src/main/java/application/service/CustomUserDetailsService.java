package application.service;

import application.dao.SzemelyDAO;
import application.model.Szemely;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;


public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private SzemelyDAO szemelyDAO;

    @Override
    public UserDetails loadUserByUsername(String egyetemiAzonosito) throws UsernameNotFoundException {
        Szemely szemely = szemelyDAO.getszemelyByEgyetemiAzonosito(egyetemiAzonosito);
        if (szemely == null) {
            throw new UsernameNotFoundException("User not found");
        }
        return szemely;
    }
}