package application.dao;

import application.model.Temavezeto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
public class TemavezetoDAO extends JdbcDaoSupport {

    @Autowired
    DataSource dataSource;

    @PostConstruct
    private void initialize() {
        setDataSource(dataSource);
    }

    public List<Temavezeto> listTemavezeto() {
        String sql = "SELECT * FROM szemely,temavezeto WHERE szemely.egyetemiAzonosito = temavezeto.egyetemiAzonosito";
        List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql);
        List<Temavezeto> result = new ArrayList<Temavezeto>();
        for (Map<String, Object> row : rows) {
            Temavezeto temavezeto = new Temavezeto();
            temavezeto.setEgyetemiAzonosito((String) row.get("egyetemiAzonosito"));
            temavezeto.setMunkakoriBeosztas((String) row.get("munkakoriBeosztas"));
            temavezeto.setSzerepkor((String) row.get("szerepkor"));
            temavezeto.setTanszekNev((String) row.get("tanszekNev"));
            temavezeto.setElotag((String) row.get("elotag"));
            temavezeto.setVezeteknev((String) row.get("vezeteknev"));
            temavezeto.setKeresztnev((String) row.get("keresztnev"));
            result.add(temavezeto);
        }
        return result;
    }

    public List<Temavezeto> listBelsoTemavezeto() {
        String sql = "SELECT * FROM szemely,temavezeto WHERE szerepkor='Belső témavezető' AND szemely.egyetemiAzonosito = temavezeto.egyetemiAzonosito";
        List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql);
        List<Temavezeto> result = new ArrayList<Temavezeto>();
        for (Map<String, Object> row : rows) {
            Temavezeto temavezeto = new Temavezeto();
            temavezeto.setEgyetemiAzonosito((String) row.get("egyetemiAzonosito"));
            temavezeto.setMunkakoriBeosztas((String) row.get("munkakoriBeosztas"));
            temavezeto.setSzerepkor((String) row.get("szerepkor"));
            temavezeto.setTanszekNev((String) row.get("tanszekNev"));
            temavezeto.setElotag((String) row.get("elotag"));
            temavezeto.setVezeteknev((String) row.get("vezeteknev"));
            temavezeto.setKeresztnev((String) row.get("keresztnev"));
            result.add(temavezeto);
        }
        return result;
    }

    public List<Temavezeto> listKulsoTemavezeto() {
        String sql = "SELECT * FROM szemely,temavezeto WHERE szerepkor='Külső témavezető' AND szemely.egyetemiAzonosito = temavezeto.egyetemiAzonosito";
        List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql);
        List<Temavezeto> result = new ArrayList<Temavezeto>();
        for (Map<String, Object> row : rows) {
            Temavezeto temavezeto = new Temavezeto();
            temavezeto.setEgyetemiAzonosito((String) row.get("egyetemiAzonosito"));
            temavezeto.setMunkakoriBeosztas((String) row.get("munkakoriBeosztas"));
            temavezeto.setSzerepkor((String) row.get("szerepkor"));
            temavezeto.setTanszekNev((String) row.get("tanszekNev"));
            temavezeto.setElotag((String) row.get("elotag"));
            temavezeto.setVezeteknev((String) row.get("vezeteknev"));
            temavezeto.setKeresztnev((String) row.get("keresztnev"));
            result.add(temavezeto);
        }
        return result;
    }

    public List<String> listSpecifiedTemavezeto(String dolgozatAzonosito) {
        String sql = "SELECT temavezeto.egyetemiAzonosito FROM temavezeto,dolgozat WHERE dolgozat.dolgozatAzonosito = '" + dolgozatAzonosito + "'" +
                "AND (temavezeto.tanszekNev = dolgozat.tanszekNev AND temavezeto.szerepkor = 'Belső témavezető') " +
                "OR (dolgozat.dolgozatAzonosito = '" + dolgozatAzonosito + "' AND temavezeto.szerepkor = 'Külső témavezető')";
        List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql);
        List<String> result = new ArrayList<String>();
        for (Map<String, Object> row : rows) {
            result.add((String) row.get("egyetemiAzonosito"));
        }
        return result;
    }
}
