package dao.ekonomika;

import com.j256.ormlite.dao.Dao;
import entity.doprava.DopravaPocetNehod;
import entity.ekonomika.EkonomikaIndexStartnutia;

import java.sql.SQLException;
import java.util.List;

/**
 * Class represents:
 * @author xholecko
 */
public interface EkonomikaIndexStartnutiaDao extends Dao<EkonomikaIndexStartnutia, Long> {

    /**
     * Index starnutia (Sauvyho index) – vyjadruje počet osôb v poproduktívnom veku (65+ rokov) pripadajúci na 100 osôb v predproduktívnom veku (0 – 14 rokov).
     * @param rok rok (hodnoty od 1996 - 2018) hodnoty vacsie alebo rovne ako zadany rok
     * @return zoradeny list casti bratislavy od casti ktora ma najnizsi priemerny index starnutia po casti ktora ma najvyssi priemerny index starnutia
     * @throws SQLException e
     */
    List<String[]> getIndexStarnutiaByRok(int rok) throws SQLException;
}
