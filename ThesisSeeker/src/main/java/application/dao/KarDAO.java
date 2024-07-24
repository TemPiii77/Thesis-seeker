package application.dao;

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
public class KarDAO extends JdbcDaoSupport {

    @Autowired
    DataSource dataSource;

    @PostConstruct
    private void initialize() {
        setDataSource(dataSource);
    }

    public List<Kar> listKar() {
        String sql = "SELECT * FROM kar";
        List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql);
        List<Kar> result = new ArrayList<Kar>();
        for (Map<String, Object> row : rows) {
            Kar kar = new Kar();
            kar.setKarNev((String) row.get("karNev"));
            result.add(kar);
        }
        return result;
    }

    public boolean createKar(Kar kar) {
        String sql = "INSERT INTO kar(karNev) VALUES (?)";
        int res = getJdbcTemplate().update(sql, kar.getKarNev());
        return res == 1;

    }

    public boolean deleteKar(Kar kar) {
        String sql = "DELETE FROM kar WHERE karNev = '" + kar.getKarNev() + "'";
        int res = getJdbcTemplate().update(sql);
        return res == 1;
    }
}
