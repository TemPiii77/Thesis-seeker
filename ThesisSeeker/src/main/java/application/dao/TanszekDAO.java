package application.dao;

import application.model.Tanszek;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
public class TanszekDAO extends JdbcDaoSupport {

    @Autowired
    DataSource dataSource;

    @PostConstruct
    private void initialize() {
        setDataSource(dataSource);
    }

    public List<Tanszek> listTanszek() {
        String sql = "SELECT * FROM tanszek ORDER BY tanszekNev ASC";
        List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql);
        List<Tanszek> result = new ArrayList<Tanszek>();
        for (Map<String, Object> row : rows) {
            Tanszek tanszek = new Tanszek();
            tanszek.setTanszekNev((String) row.get("tanszekNev"));
            tanszek.setIntezetNev((String) row.get("intezetNev"));
            result.add(tanszek);
        }
        return result;
    }

    public boolean createTanszek(Tanszek tanszek) {
        String sql = "INSERT INTO tanszek(tanszekNev,intezetNev) VALUES (?,?)";
        int res = getJdbcTemplate().update(sql, tanszek.getTanszekNev(), tanszek.getIntezetNev());
        return res == 1;
    }

    public boolean updateTanszek(Tanszek tanszek) {
        String sql = "UPDATE tanszek SET intezetNev='" + tanszek.getIntezetNev() + "' WHERE tanszekNev='" + tanszek.getTanszekNev() + "'";
        int res = getJdbcTemplate().update(sql);
        return res == 1;
    }

    public boolean deleteTanszek(String tanszekNev) {
        String sql = "DELETE FROM tanszek WHERE tanszekNev = '" + tanszekNev + "'";
        int res = getJdbcTemplate().update(sql);
        return res == 1;
    }

    public List<Tanszek> listSpecifiedTanszek(String szakAzonosito) {
        String sql = "SELECT tanszek.tanszekNev FROM szakintezetek,tanszek WHERE szakintezetek.szakAzonosito = '" + szakAzonosito + "' " +
                " AND szakintezetek.intezetNev = tanszek.intezetNev ORDER BY tanszekNev ASC";
        List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql);
        List<Tanszek> result = new ArrayList<Tanszek>();
        for (Map<String, Object> row : rows) {
            Tanszek tanszek = new Tanszek();
            tanszek.setTanszekNev((String) row.get("tanszekNev"));
            result.add(tanszek);
        }
        return result;
    }
}
