package application.dao;

import application.model.Adminisztrator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
public class AdminDAO extends JdbcDaoSupport {

    @Autowired
    DataSource dataSource;

    @PostConstruct
    private void initialize() {
        setDataSource(dataSource);
    }

    public List<Adminisztrator> listAdmin() {
        String sql = "SELECT * FROM szemely,adminisztrator WHERE szemely.egyetemiAzonosito = adminisztrator.egyetemiAzonosito";
        List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql);
        List<Adminisztrator> result = new ArrayList<Adminisztrator>();
        for (Map<String, Object> row : rows) {
            Adminisztrator adminisztrator = new Adminisztrator();
            adminisztrator.setEgyetemiAzonosito((String) row.get("egyetemiAzonosito"));
            adminisztrator.setMunkakoriBeosztas((String) row.get("munkakoriBeosztas"));
            adminisztrator.setElotag((String) row.get("elotag"));
            adminisztrator.setVezeteknev((String) row.get("vezeteknev"));
            adminisztrator.setKeresztnev((String) row.get("keresztnev"));
            result.add(adminisztrator);
        }
        return result;
    }
}
