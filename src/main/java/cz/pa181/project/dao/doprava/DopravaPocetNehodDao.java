package cz.pa181.project.dao.doprava;

import com.j256.ormlite.dao.Dao;
import cz.pa181.project.entity.doprava.DopravaPocetNehod;

import java.sql.SQLException;
import java.util.List;
/**
 * Class represents:
 * @author xholecko
 */
public interface DopravaPocetNehodDao extends Dao<DopravaPocetNehod, Long> {
    /**
     *
     * @param rok rok (hodnoty od 2012 - 2018) hodnoty vacsie alebo rovne ako zadany rok
     * @return zoradeny list casti bratislavy od casti ktora ma najmenej nehod po tu cast ktora ma najviac nehod za dane obdobie
     * @throws SQLException e
     */
    List<String[]> getPocetNehodByRokSorted(int rok) throws SQLException;

}
