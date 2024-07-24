package application.dao;

import application.model.Vezet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
public class VezetDAO extends JdbcDaoSupport {

    @Autowired
    DataSource dataSource;

    @PostConstruct
    private void initialize() {
        setDataSource(dataSource);
    }

    public List<Vezet> listVezet() {
        String sql = "SELECT * FROM vezet";
        List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql);
        List<Vezet> result = new ArrayList<Vezet>();
        for (Map<String, Object> row : rows) {
            Vezet vezet = new Vezet();
            vezet.setDolgozatAzonosito((int) row.get("dolgozatAzonosito"));
            vezet.setEgyetemiAzonosito((String) row.get("egyetemiAzonosito"));
            result.add(vezet);
        }
        return result;
    }

    public boolean deleteVezet(Vezet vezet) {
        String sql = "DELETE FROM vezet WHERE dolgozatAzonosito='" + vezet.getDolgozatAzonosito() + "' AND egyetemiAzonosito='" + vezet.getEgyetemiAzonosito() + "'";
        int res = getJdbcTemplate().update(sql);
        return res == 1;
    }

    public boolean createVezet(Vezet vezet) {
        if (countTemavezeto(vezet) == 0 && (belsoTemavezeto(vezet) || kulsoTemavezeto(vezet))) {
            String sql = "INSERT INTO vezet(dolgozatAzonosito,egyetemiAzonosito) VALUES (?,?)";
            int res = getJdbcTemplate().update(sql, vezet.getDolgozatAzonosito(), vezet.getEgyetemiAzonosito());

            return res == 1;
        }
        return false;
    }

    public boolean updateVezet(int dolgozatAzonosito, String egyetemiAzonosito) {
        Vezet vezet = new Vezet(dolgozatAzonosito, egyetemiAzonosito);
        if (belsoTemavezeto(vezet)) {
            String teszt = "DELETE FROM vezet WHERE " +
                    "egyetemiAzonosito = (SELECT vezet.egyetemiAzonosito FROM vezet,temavezeto " +
                    "WHERE temavezeto.szerepkor = 'Belső témavezető'" +
                    "AND vezet.egyetemiAzonosito = temavezeto.egyetemiAzonosito AND dolgozatAzonosito = '" + dolgozatAzonosito + "')";
            int res2 = getJdbcTemplate().update(teszt);
        }
        if (kulsoTemavezeto(vezet)) {
            String teszt = "DELETE FROM vezet WHERE " +
                    "egyetemiAzonosito = (SELECT vezet.egyetemiAzonosito FROM vezet,temavezeto " +
                    "WHERE temavezeto.szerepkor = 'Külső témavezető'" +
                    "AND vezet.egyetemiAzonosito = temavezeto.egyetemiAzonosito AND dolgozatAzonosito = '" + dolgozatAzonosito + "')";
            int res2 = getJdbcTemplate().update(teszt);
        }
        createVezet(vezet);

        return false;
    }

    public int countTemavezeto(Vezet vezet) {
        Integer cnt = getJdbcTemplate().queryForObject(
                "SELECT count(*) FROM vezet,temavezeto WHERE vezet.egyetemiAzonosito = temavezeto.egyetemiAzonosito" +
                        " AND vezet.dolgozatAzonosito=? AND temavezeto.szerepkor = (SELECT szerepkor FROM temavezeto " +
                        "WHERE temavezeto.egyetemiAzonosito = ?)", Integer.class, vezet.getDolgozatAzonosito(), vezet.getEgyetemiAzonosito());
        return cnt;
    }

    public boolean belsoTemavezeto(Vezet vezet) {
        Integer cnt = getJdbcTemplate().queryForObject(
                "SELECT count(*) FROM temavezeto WHERE temavezeto.egyetemiAzonosito = ? AND temavezeto.szerepkor = 'Belső témavezető'",
                Integer.class, vezet.getEgyetemiAzonosito());
        return cnt == 1;
    }

    public boolean kulsoTemavezeto(Vezet vezet) {
        Integer cnt = getJdbcTemplate().queryForObject(
                "SELECT count(*) FROM temavezeto WHERE temavezeto.egyetemiAzonosito = ? AND temavezeto.szerepkor = 'Külső témavezető'",
                Integer.class, vezet.getEgyetemiAzonosito());
        return cnt == 1;
    }
}
