package application.dao;

import application.model.Szakintezetek;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
public class SzakintezetekDAO extends JdbcDaoSupport {

    @Autowired
    DataSource dataSource;

    @PostConstruct
    private void initialize() {
        setDataSource(dataSource);
    }

    public List<Szakintezetek> listSzakintezetek() {
        String sql = "SELECT * FROM szakintezetek";
        List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql);
        List<Szakintezetek> result = new ArrayList<Szakintezetek>();
        for (Map<String, Object> row : rows) {
            Szakintezetek szakintezetek = new Szakintezetek();
            szakintezetek.setSzakAzonosito((String) row.get("szakAzonosito"));
            szakintezetek.setIntezetNev((String) row.get("intezetNev"));
            result.add(szakintezetek);
        }
        return result;
    }

    public boolean createSzakintezet(Szakintezetek szakintezetek) {
        String sql = "INSERT INTO szakintezetek(szakAzonosito,intezetNev) VALUES (?,?)";
        int res = getJdbcTemplate().update(sql, szakintezetek.getSzakAzonosito(), szakintezetek.getIntezetNev());
        return res == 1;
    }

    public boolean deleteSzakintezet(Szakintezetek szakintezetek) {
        String sql = "DELETE FROM szakintezetek WHERE szakAzonosito='" + szakintezetek.getSzakAzonosito() + "' AND intezetNev='" + szakintezetek.getIntezetNev() + "'";
        int res = getJdbcTemplate().update(sql);
        return res == 1;
    }

    public boolean updateSzakintezet(String szakAzonosito, String intezetNev, Szakintezetek szakintezetek) {
        String sql = "UPDATE szakintezetek SET intezetNev='" + szakintezetek.getIntezetNev() + "' WHERE szakAzonosito='" +
                szakAzonosito + "' AND intezetNev='" + intezetNev + "'";
        int res = getJdbcTemplate().update(sql);
        return res == 1;
    }
}
