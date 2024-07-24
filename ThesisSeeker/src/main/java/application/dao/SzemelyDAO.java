package application.dao;

import application.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository

public class SzemelyDAO extends JdbcDaoSupport {
    @Autowired
    BCryptPasswordEncoder passwordEncoder;

    @Autowired
    DataSource dataSource;

    @PostConstruct
    private void initialize() {
        setDataSource(dataSource);
    }

    public boolean insertHallgato(Hallgato hallgato) {
        String sql = "INSERT INTO szemely(egyetemiAzonosito, elotag, vezeteknev, keresztnev, jelszo, jogosultsag ) VALUES (?, ?, ?, ?, ?, ?)";
        if (hallgato.getJelszo().equals(hallgato.getJelszoUjra())) {
            int res = getJdbcTemplate().update(sql, hallgato.getEgyetemiAzonosito(), hallgato.getElotag(), hallgato.getVezeteknev(),
                    hallgato.getKeresztnev(), passwordEncoder.encode(hallgato.getPassword()), "ROLE_HALLGATO");
            sql = "INSERT INTO hallgato(egyetemiAzonosito,jogviszony) VALUES (?, ?)";
            getJdbcTemplate().update(sql, hallgato.getEgyetemiAzonosito(), "aktív");

            return res == 1;
        }
        return false;
    }

    public boolean insertTemavezeto(Temavezeto temavezeto) {
        String sql = "INSERT INTO szemely(egyetemiAzonosito, elotag, vezeteknev, keresztnev, jelszo, jogosultsag ) VALUES (?, ?, ?, ?, ?, ?)";
        if (temavezeto.getJelszo().equals(temavezeto.getJelszoUjra())) {
            int res = getJdbcTemplate().update(sql, temavezeto.getEgyetemiAzonosito(), temavezeto.getElotag(), temavezeto.getVezeteknev(),
                    temavezeto.getKeresztnev(), passwordEncoder.encode(temavezeto.getPassword()), temavezeto.getJogosultsag());
            if (temavezeto.getTanszekNev().equals("nincs")) {
                sql = "INSERT INTO temavezeto(egyetemiAzonosito, munkakoriBeosztas, szerepkor) VALUES (?, ?, ?)";
                getJdbcTemplate().update(sql, temavezeto.getEgyetemiAzonosito(), temavezeto.getMunkakoriBeosztas(), temavezeto.getSzerepkor());
            } else {
                sql = "INSERT INTO temavezeto(egyetemiAzonosito, munkakoriBeosztas, szerepkor, tanszekNev) VALUES (?, ?, ?, ?)";
                getJdbcTemplate().update(sql, temavezeto.getEgyetemiAzonosito(), temavezeto.getMunkakoriBeosztas(), temavezeto.getSzerepkor(), temavezeto.getTanszekNev());
            }
            return res == 1;
        }
        return false;
    }

    public boolean insertAdmin(Adminisztrator adminisztrator) {
        String sql = "INSERT INTO szemely(egyetemiAzonosito, elotag, vezeteknev, keresztnev, jelszo, jogosultsag ) VALUES (?, ?, ?, ?, ?, ?)";
        if (adminisztrator.getJelszo().equals(adminisztrator.getJelszoUjra())) {
            int res = getJdbcTemplate().update(sql, adminisztrator.getEgyetemiAzonosito(), adminisztrator.getElotag(), adminisztrator.getVezeteknev(),
                    adminisztrator.getKeresztnev(), passwordEncoder.encode(adminisztrator.getPassword()), "ROLE_ADMIN");
            sql = "INSERT INTO adminisztrator(egyetemiAzonosito,munkakoriBeosztas) VALUES (?, ?)";
            getJdbcTemplate().update(sql, adminisztrator.getEgyetemiAzonosito(), adminisztrator.getMunkakoriBeosztas());

            return res == 1;
        }
        return false;
    }

    public boolean deleteSzemely(String egyetemiAzonosito) {
        String sql = "DELETE FROM szemely WHERE egyetemiAzonosito = '" + egyetemiAzonosito + "'";
        int res = getJdbcTemplate().update(sql);
        return res == 1;
    }

    public boolean updateHallgato(Hallgato hallgato) {
        String sql;
        if (hallgato.getJogviszony().equals("aktív")) {
            sql = "UPDATE hallgato SET jogviszony='inaktív' WHERE egyetemiAzonosito='" + hallgato.getEgyetemiAzonosito() + "'";
        } else {
            sql = "UPDATE hallgato SET jogviszony='aktív' WHERE egyetemiAzonosito='" + hallgato.getEgyetemiAzonosito() + "'";
        }
        int res = getJdbcTemplate().update(sql);
        return res == 1;
    }

    public boolean updateAdmin(Adminisztrator adminisztrator) {
        String sql = "UPDATE adminisztrator SET munkakoriBeosztas='" + adminisztrator.getMunkakoriBeosztas() + "' WHERE egyetemiAzonosito='" +
                adminisztrator.getEgyetemiAzonosito() + "'";
        int res = getJdbcTemplate().update(sql);
        return res == 1;
    }

    public boolean updateBelsoTV(Temavezeto temavezeto) {
        String sql = "UPDATE temavezeto SET munkakoriBeosztas='" + temavezeto.getMunkakoriBeosztas() + "', tanszekNev='" +
                temavezeto.getTanszekNev() + "' WHERE egyetemiAzonosito='" + temavezeto.getEgyetemiAzonosito() + "'";
        int res = getJdbcTemplate().update(sql);
        return res == 1;
    }

    public boolean updateSzemely(Szemely szemely) {
        String sql = "UPDATE szemely SET elotag='" + szemely.getElotag() + "', vezeteknev='" + szemely.getVezeteknev() + "' , keresztnev='" + szemely.getKeresztnev()
                + "' , jelszo='" + passwordEncoder.encode(szemely.getJelszo()) + "' WHERE egyetemiAzonosito='" + szemely.getEgyetemiAzonosito() + "'";

        int res = getJdbcTemplate().update(sql);
        return res == 1;
    }

    public Szemely getszemelyByEgyetemiAzonosito(String felhasznalonev) {
        String sql = "SELECT * FROM szemely WHERE egyetemiAzonosito=?";
        List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql, felhasznalonev);

        List<Szemely> result = new ArrayList<Szemely>();
        for (Map<String, Object> row : rows) {
            Szemely szemely = new Szemely();
            szemely.setEgyetemiAzonosito((String) row.get("egyetemiAzonosito"));
            szemely.setElotag((String) row.get("elotag"));
            szemely.setVezeteknev((String) row.get("vezeteknev"));
            szemely.setKeresztnev((String) row.get("keresztnev"));
            szemely.setJelszo((String) row.get("jelszo"));
            szemely.setJogosultsag((String) row.get("jogosultsag"));
            result.add(szemely);
        }
        return result.get(0);
    }

    public List<Szemely> listSzemely() {
        String sql = "SELECT * FROM szemely";
        List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql);
        List<Szemely> result = new ArrayList<Szemely>();
        for (Map<String, Object> row : rows) {
            Szemely szemely = new Szemely();
            szemely.setEgyetemiAzonosito((String) row.get("egyetemiAzonosito"));
            szemely.setElotag((String) row.get("elotag"));
            szemely.setVezeteknev((String) row.get("vezeteknev"));
            szemely.setKeresztnev((String) row.get("keresztnev"));
            szemely.setJelszo((String) row.get("jelszo"));
            szemely.setJogosultsag((String) row.get("jogosultsag"));
            result.add(szemely);
        }
        return result;
    }
}
