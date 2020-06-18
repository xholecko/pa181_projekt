package cz.pa181.project.dao.spravodlivost;

import com.j256.ormlite.dao.Dao;
import cz.pa181.project.entity.spravodlivost.SpravodlivostTrestneCiny;

import java.sql.SQLException;
import java.util.List;

/**
 * Class represents:
 * @author xholecko
 */
public interface SpravodlivostTrestneCinyDao extends Dao<SpravodlivostTrestneCiny,Long> {

    /**
     *
     * @param rok rok (hodnoty od 2016 - 2018) hodnoty rovne ako zadany rok
     * @return zoradeny list casti bratislavy podla poctu trestnych cinov od casti kde je nejemenej trestnych cinov po cost kde je najviac
     * @throws SQLException e
     */
    List<String[]> getPocetZistenychTrestnychCinovByRokSorted(int rok) throws SQLException;
}
