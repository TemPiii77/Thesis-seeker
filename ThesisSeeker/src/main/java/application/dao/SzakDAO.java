package application.dao;

import application.model.Szak;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
public class SzakDAO extends JdbcDaoSupport {

    @Autowired
    DataSource dataSource;

    @PostConstruct
    private void initialize() {
        setDataSource(dataSource);
    }

    public List<Szak> listSzak() {
        String sql = "SELECT * FROM szak";
        List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql);
        List<Szak> result = new ArrayList<Szak>();
        for (Map<String, Object> row : rows) {
            Szak szak = new Szak();
            szak.setSzakAzonosito((String) row.get("szakAzonosito"));
            szak.setSzaknev((String) row.get("szaknev"));
            szak.setKarNev((String) row.get("karNev"));
            result.add(szak);
        }
        return result;
    }

    public boolean createSzak(Szak szak) {
        String sql = "INSERT INTO szak(szakAzonosito,szaknev,karNev) VALUES (?,?,?)";
        int res = getJdbcTemplate().update(sql, szak.getSzakAzonosito(), szak.getSzaknev(), szak.getKarNev());
        return res == 1;
    }

    public boolean deleteSzak(String szakAzonosito) {
        String sql = "DELETE FROM szak WHERE szakAzonosito = '" + szakAzonosito + "'";
        int res = getJdbcTemplate().update(sql);
        return res == 1;
    }

    public boolean updateSzak(Szak szak) {
        String sql = "UPDATE szak SET szaknev='" + szak.getSzaknev() + "', karNev='" + szak.getKarNev() + "' WHERE szakAzonosito='" + szak.getSzakAzonosito() + "'";
        int res = getJdbcTemplate().update(sql);
        return res == 1;
    }

    public List<Szak> listSpecifiedSzak(String egyetemiAzonosito) {
        String sql = "SELECT szak.szakAzonosito, szak.szaknev FROM szak,jar WHERE jar.egyetemiAzonosito = '" +
                egyetemiAzonosito + "' AND szak.szakAzonosito = jar.szakAzonosito";
        List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql);
        List<Szak> result = new ArrayList<Szak>();
        for (Map<String, Object> row : rows) {
            Szak szak = new Szak();
            szak.setSzakAzonosito((String) row.get("szakAzonosito"));
            szak.setSzaknev((String) row.get("szaknev"));
            result.add(szak);
        }
        return result;
    }
}
