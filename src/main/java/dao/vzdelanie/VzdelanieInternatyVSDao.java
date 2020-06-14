package dao.vzdelanie;

import com.j256.ormlite.dao.Dao;
import entity.vzdelanie.VzdelanieInternatyVS;

import java.sql.SQLException;
import java.util.List;

/**
 * Class represents:
 * @author xholecko
 */
public interface VzdelanieInternatyVSDao extends Dao<VzdelanieInternatyVS,Long> {


    //MYSLIM ZE POCET LOZOK JE VYSTIZNEJSIE V TOMTO PRIPADE - BRATISLAVA 4 ma len 5 intrakov a vyse 10k lozok kym BRATISLAVA 1 ma 10 intrakov a nieco vyse 3k lozok
    /**
     *
     * @param rok rok (hodnoty od 1996 - 2018) hodnoty rovne ako zadany rok
     * @return zoradeny list casti bratislavy podla poctu lozok na internatoch od najvacsieho po najmensi
     * @throws SQLException e
     */
    List<String[]> getPocetLozokByRok(int rok) throws SQLException;


    /**
     *
     * @param rok rok (hodnoty od 1996 - 2018) hodnoty rovne ako zadany rok
     * @return zoradeny list casti bratislavy podla poctu internatov od najvacsieho po najmensi
     * @throws SQLException e
     */
    List<String[]> getPocetInternatovByRokSorted(int rok) throws SQLException;
}
