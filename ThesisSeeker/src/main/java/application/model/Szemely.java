package application.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.*;

public class Szemely implements UserDetails {

    String egyetemiAzonosito;
    String elotag;
    String vezeteknev;
    String keresztnev;
    String jelszo;
    String jelszoUjra;
    String jogosultsag;

    public Szemely() {}

    public Szemely(String egyetemiAzonosito, String elotag, String vezeteknev, String keresztnev, String jelszo, String jelszoUjra) {
        this.setEgyetemiAzonosito(egyetemiAzonosito);
        this.setElotag(elotag);
        this.setVezeteknev(vezeteknev);
        this.setKeresztnev(keresztnev);
        this.setJelszo(jelszo);
        this.setJelszo(jelszoUjra);
    }

    public Szemely(String egyetemiAzonosito, String elotag, String vezeteknev, String keresztnev, String jelszo, String jelszoUjra, String jogosultsag) {
        this.egyetemiAzonosito = egyetemiAzonosito;
        this.elotag = elotag;
        this.vezeteknev = vezeteknev;
        this.keresztnev = keresztnev;
        this.jelszo = jelszo;
        this.jelszoUjra = jelszoUjra;
        this.jogosultsag = jogosultsag;
    }

    public String getEgyetemiAzonosito() {
        return egyetemiAzonosito;
    }

    public void setEgyetemiAzonosito(String egyetemiAzonosito) {
        this.egyetemiAzonosito = egyetemiAzonosito;
    }

    public String getElotag() {
        return elotag;
    }

    public void setElotag(String elotag) {
        this.elotag = elotag;
    }

    public String getVezeteknev() {
        return vezeteknev;
    }

    public void setVezeteknev(String vezeteknev) {
        this.vezeteknev = vezeteknev;
    }

    public String getKeresztnev() {
        return keresztnev;
    }

    public void setKeresztnev(String keresztnev) {
        this.keresztnev = keresztnev;
    }

    public String getJelszo() {
        return jelszo;
    }

    public void setJelszo(String jelszo) {
        this.jelszo = jelszo;
    }

    public String getJelszoUjra() {
        return jelszoUjra;
    }

    public void setJelszoUjra(String jelszoUjra) {
        this.jelszoUjra = jelszoUjra;
    }

    public String getJogosultsag() {
        return jogosultsag;
    }

    public void setJogosultsag(String jogosultsag) {
        this.jogosultsag = jogosultsag;
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

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        Set<GrantedAuthority> authorities = new HashSet<GrantedAuthority>();
        authorities.add(new SimpleGrantedAuthority(this.jogosultsag));
        return authorities;
    }

    @Override
    public String getPassword() {
        return this.jelszo;
    }

    @Override
    public String getUsername() {
        return this.egyetemiAzonosito;
    }
}
