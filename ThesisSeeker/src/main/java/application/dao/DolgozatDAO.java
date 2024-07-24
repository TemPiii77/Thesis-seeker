package application.dao;

import application.model.Dolgozat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
public class DolgozatDAO extends JdbcDaoSupport {

    @Autowired
    DataSource dataSource;

    @PostConstruct
    private void initialize() {
        setDataSource(dataSource);
    }

    public List<Dolgozat> listDolgozat() {
        String sql = "SELECT * FROM dolgozat";
        List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql);
        List<Dolgozat> result = new ArrayList<Dolgozat>();
        for (Map<String, Object> row : rows) {
            Dolgozat dolgozat = new Dolgozat();
            dolgozat.setDolgozatAzonosito((int) row.get("dolgozatAzonosito"));
            dolgozat.setCim((String) row.get("cim"));
            dolgozat.setBeadasEve((String) row.get("beadasEve"));
            dolgozat.setVedesEve((String) row.get("vedesEve"));
            dolgozat.setVedesErdemjegye((int) row.get("vedesErdemjegye"));
            dolgozat.setEgyetemiAzonosito((String) row.get("egyetemiAzonosito"));
            dolgozat.setSzakAzonosito((String) row.get("szakAzonosito"));
            dolgozat.setTanszekNev((String) row.get("tanszekNev"));
            result.add(dolgozat);
        }
        return result;
    }

    public boolean deleteDolgozat(int dolgozatAzonosito) {
        String sql = "DELETE FROM dolgozat WHERE dolgozatAzonosito = '" + dolgozatAzonosito + "'";
        int res = getJdbcTemplate().update(sql);
        return res == 1;
    }

    public boolean createDolgozat(Dolgozat dolgozat) {
        String sql = "INSERT INTO dolgozat(cim, beadasEve, vedesEve, vedesErdemjegye, egyetemiAzonosito, szakAzonosito, tanszekNev) VALUES (?,?,?,?,?,?,?)";
        int res = getJdbcTemplate().update(sql, dolgozat.getCim(), dolgozat.getBeadasEve(), dolgozat.getVedesEve(),
                dolgozat.getVedesErdemjegye(), dolgozat.getEgyetemiAzonosito(), dolgozat.getSzakAzonosito(), dolgozat.getTanszekNev());
        return res == 1;
    }

    public boolean updateDolgozat(Dolgozat dolgozat) {
        String sql = "UPDATE dolgozat SET cim='" + dolgozat.getCim() + "', beadasEve='" + dolgozat.getBeadasEve() + "' " +
                ", vedesEve='" + dolgozat.getVedesEve() + "' , vedesErdemjegye='" + dolgozat.getVedesErdemjegye() + "' " +
                ", egyetemiAzonosito='" + dolgozat.getEgyetemiAzonosito() + "' , szakAzonosito='" + dolgozat.getSzakAzonosito() + "' " +
                ", tanszekNev='" + dolgozat.getTanszekNev() + "' WHERE dolgozatAzonosito='" + dolgozat.getDolgozatAzonosito() + "'";
        int res = getJdbcTemplate().update(sql);
        return res == 1;
    }

    public List<Map<String, Object>> melyikTemavezetohozHanyDolgozatFelevente() {

        String sql = "SELECT dolgozat.beadasEve AS 'Beadás éve', temavezeto.egyetemiAzonosito AS 'Témavezető egyetemi azonosítója', " +
                "COUNT(*) AS 'Dolgozatok száma' " +
                "FROM temavezeto, dolgozat, vezet " +
                "WHERE dolgozat.dolgozatAzonosito = vezet.dolgozatAzonosito AND temavezeto.egyetemiAzonosito = vezet.egyetemiAzonosito " +
                "GROUP BY beadasEve, temavezeto.egyetemiAzonosito " +
                "ORDER BY beadasEve";

        return getJdbcTemplate().queryForList(sql);
    }

    public List<Map<String, Object>> tanszekenkentHanyDolgozatFelevente() {

        String sql = "SELECT dolgozat.tanszekNev AS 'Tanszék neve', dolgozat.beadasEve AS 'Beadás éve', COUNT(*) AS 'Dolgozatok száma' " +
                "FROM temavezeto, dolgozat, vezet " +
                "WHERE dolgozat.dolgozatAzonosito = vezet.dolgozatAzonosito AND temavezeto.egyetemiAzonosito = vezet.egyetemiAzonosito " +
                "AND temavezeto.szerepkor = 'Belső témavezető'" +
                "GROUP BY dolgozat.tanszekNev, dolgozat.beadasEve " +
                "ORDER BY dolgozat.tanszekNev, dolgozat.beadasEve";

        return getJdbcTemplate().queryForList(sql);
    }

    public List<Map<String, Object>> temavezetonekHanyHallgatojaVedettSikeresenFelevente(String egyetemiAzonosito) {

        String sql = "SELECT temavezeto.egyetemiAzonosito AS 'Témavezető egyetemi azonosítója', dolgozat.vedesEve AS 'Védés éve', COUNT(*) AS 'Dolgozatok száma' " +
                "FROM temavezeto, dolgozat, vezet " +
                "WHERE dolgozat.dolgozatAzonosito = vezet.dolgozatAzonosito AND temavezeto.egyetemiAzonosito = vezet.egyetemiAzonosito " +
                "AND dolgozat.vedesErdemjegye IN (2,3,4,5) AND temavezeto.egyetemiAzonosito = '" + egyetemiAzonosito + "'" +
                "GROUP BY dolgozat.vedesEve, temavezeto.egyetemiAzonosito " +
                "ORDER BY dolgozat.vedesEve ";

        return getJdbcTemplate().queryForList(sql);
    }

    public List<Dolgozat> listTemavezetoDolgozat(String egyetemiAzonosito) {
        String sql = "SELECT * FROM dolgozat, temavezeto,vezet WHERE temavezeto.egyetemiAzonosito = '" + egyetemiAzonosito + "' " +
                "AND vezet.egyetemiAzonosito = '" + egyetemiAzonosito + "' AND vezet.dolgozatAzonosito = dolgozat.dolgozatAzonosito";
        List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql);
        List<Dolgozat> result = new ArrayList<Dolgozat>();
        for (Map<String, Object> row : rows) {
            Dolgozat dolgozat = new Dolgozat();
            dolgozat.setDolgozatAzonosito((int) row.get("dolgozatAzonosito"));
            dolgozat.setCim((String) row.get("cim"));
            dolgozat.setBeadasEve((String) row.get("beadasEve"));
            dolgozat.setVedesEve((String) row.get("vedesEve"));
            dolgozat.setVedesErdemjegye((int) row.get("vedesErdemjegye"));
            dolgozat.setEgyetemiAzonosito((String) row.get("egyetemiAzonosito"));
            dolgozat.setSzakAzonosito((String) row.get("szakAzonosito"));
            dolgozat.setTanszekNev((String) row.get("tanszekNev"));
            result.add(dolgozat);
        }
        return result;
    }

    public boolean updateDolgozatCime(Dolgozat dolgozat) {
        String sql = "UPDATE dolgozat SET cim='" + dolgozat.getCim() + "' WHERE dolgozatAzonosito='" + dolgozat.getDolgozatAzonosito() + "'";
        int res = getJdbcTemplate().update(sql);
        return res == 1;
    }
}
