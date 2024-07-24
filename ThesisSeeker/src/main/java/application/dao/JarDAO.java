package application.dao;

import application.model.Dolgozat;
import application.model.Jar;
import application.model.Kar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
public class JarDAO extends JdbcDaoSupport {

    @Autowired
    DataSource dataSource;

    @PostConstruct
    private void initialize() {
        setDataSource(dataSource);
    }

    public List<Jar> listJar() {
        String sql = "SELECT * FROM jar";
        List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql);
        List<Jar> result = new ArrayList<Jar>();
        for (Map<String, Object> row : rows) {
            Jar jar = new Jar();
            jar.setSzakAzonosito((String) row.get("szakAzonosito"));
            jar.setEgyetemiAzonosito((String) row.get("egyetemiAzonosito"));
            jar.setKezdesSzemesztere((String) row.get("kezdesSzemesztere"));
            jar.setVegzesSzemesztere((String) row.get("vegzesSzemesztere"));
            jar.setDiplomaSorszama((String) row.get("diplomaSorszama"));
            result.add(jar);
        }
        return result;
    }

    public boolean deleteJar(Jar jar) {
        String sql = "DELETE FROM jar WHERE szakAzonosito='" + jar.getSzakAzonosito() + "' AND egyetemiAzonosito='" + jar.getEgyetemiAzonosito() + "'";
        int res = getJdbcTemplate().update(sql);
        return res == 1;
    }

    public boolean createJar(Jar jar) {
        String sql = "INSERT INTO jar(szakAzonosito, egyetemiAzonosito, kezdesSzemesztere, vegzesSzemesztere, diplomaSorszama) VALUES (?,?,?,?,?)";
        int res = getJdbcTemplate().update(sql, jar.getSzakAzonosito(), jar.getEgyetemiAzonosito(), jar.getKezdesSzemesztere(),
                jar.getVegzesSzemesztere(), jar.getDiplomaSorszama());
        return res == 1;
    }

    public boolean updateJar(Jar jar) {
        String sql = "UPDATE jar SET kezdesSzemesztere='" + jar.getKezdesSzemesztere() + "', vegzesSzemesztere='" +
                jar.getVegzesSzemesztere() + "', diplomaSorszama='" + jar.getDiplomaSorszama() + "' WHERE szakAzonosito='" +
                jar.getSzakAzonosito() + "' AND egyetemiAzonosito='" + jar.getEgyetemiAzonosito() + "'";
        int res = getJdbcTemplate().update(sql);
        return res == 1;
    }
}
