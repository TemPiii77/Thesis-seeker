package application.dao;

import application.model.Intezet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
public class IntezetDAO extends JdbcDaoSupport {

    @Autowired
    DataSource dataSource;

    @PostConstruct
    private void initialize() {
        setDataSource(dataSource);
    }

    public List<Intezet> listIntezet() {
        String sql = "SELECT * FROM intezet";
        List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql);
        List<Intezet> result = new ArrayList<Intezet>();
        for (Map<String, Object> row : rows) {
            Intezet intezet = new Intezet();
            intezet.setIntezetNev((String) row.get("intezetNev"));
            intezet.setKarNev((String) row.get("karNev"));
            result.add(intezet);
        }
        return result;
    }

    public boolean createIntezet(Intezet intezet) {
        String sql = "INSERT INTO intezet(intezetNev,karNev) VALUES (?,?)";
        int res = getJdbcTemplate().update(sql, intezet.getIntezetNev(), intezet.getKarNev());
        return res == 1;
    }

    public boolean updateIntezet(Intezet intezet) {
        String sql = "UPDATE intezet SET karNev='" + intezet.getKarNev() + "' WHERE intezetNev='" + intezet.getIntezetNev() + "'";
        int res = getJdbcTemplate().update(sql);
        return res == 1;
    }

    public boolean deleteIntezet(String intezetNev) {
        String sql = "DELETE FROM intezet WHERE intezetNev = '" + intezetNev + "'";
        int res = getJdbcTemplate().update(sql);
        return res == 1;
    }
}
