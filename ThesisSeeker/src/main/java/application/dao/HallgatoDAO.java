package application.dao;

import application.model.Hallgato;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
public class HallgatoDAO extends JdbcDaoSupport {

    @Autowired
    DataSource dataSource;

    @PostConstruct
    private void initialize() {
        setDataSource(dataSource);
    }

    public List<Hallgato> listHallgato() {
        String sql = "SELECT * FROM szemely,hallgato WHERE szemely.egyetemiAzonosito = hallgato.egyetemiAzonosito";
        List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql);
        List<Hallgato> result = new ArrayList<Hallgato>();
        for (Map<String, Object> row : rows) {
            Hallgato hallgato = new Hallgato();
            hallgato.setEgyetemiAzonosito((String) row.get("egyetemiAzonosito"));
            hallgato.setElotag((String) row.get("elotag"));
            hallgato.setVezeteknev((String) row.get("vezeteknev"));
            hallgato.setKeresztnev((String) row.get("keresztnev"));
            hallgato.setJogviszony((String) row.get("jogviszony"));
            result.add(hallgato);
        }

        return result;
    }


    public List<Map<String, Object>> sajatAdatokListazasa(String username) {
        String sql = "SELECT dolgozat.dolgozatAzonosito AS 'Dolgozat Azonosító', " +
                "dolgozat.cim AS 'Dolgozat Címe', " +
                "dolgozat.vedesEve AS 'Védés Éve', " +
                "kar.karNev AS 'Kar Neve', " +
                "intezet.intezetNev AS 'Intézmény Neve', " +
                "szak.szakAzonosito AS 'Szak Azonosítója', " +
                "szak.szaknev AS 'Szak Neve', " +
                "temavezeto.egyetemiAzonosito AS 'Témavezető Azonosítója', " +
                "szemely.vezeteknev AS 'Témavezető Vezetékneve', " +
                "szemely.keresztnev AS 'Témavezető Keresztnév' " +
                "FROM hallgato " +
                "JOIN dolgozat ON hallgato.egyetemiAzonosito = dolgozat.egyetemiAzonosito " +
                "JOIN szak ON dolgozat.szakAzonosito = szak.szakAzonosito " +
                "JOIN kar ON szak.karNev = kar.karNev " +
                "JOIN szakintezetek ON szak.szakAzonosito = szakintezetek.szakAzonosito " +
                "JOIN intezet ON szakintezetek.intezetNev = intezet.intezetNev " +
                "JOIN vezet ON dolgozat.dolgozatAzonosito = vezet.dolgozatAzonosito " +
                "JOIN temavezeto ON vezet.egyetemiAzonosito = temavezeto.egyetemiAzonosito " +
                "JOIN szemely ON temavezeto.egyetemiAzonosito = szemely.egyetemiAzonosito " +
                "WHERE hallgato.egyetemiAzonosito = ? " +
                "ORDER BY dolgozat.vedesEve DESC";

        return getJdbcTemplate().queryForList(sql, username);
    }
}
