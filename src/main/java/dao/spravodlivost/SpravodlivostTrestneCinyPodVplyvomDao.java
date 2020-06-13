package dao.spravodlivost;

import com.j256.ormlite.dao.Dao;
import entity.spravodlivost.SpravodlivostTrestneCinyPodVplyvom;

import java.sql.SQLException;
import java.util.List;

/**
 * Class represents:
 * @author xholecko
 */
public interface SpravodlivostTrestneCinyPodVplyvomDao extends Dao<SpravodlivostTrestneCinyPodVplyvom,Long> {

    /**
     *
     * @param rok rok (hodnoty od 2016 - 2018) hodnoty rovne ako zadany rok
     * @return zoradeny list casti bratislavy podla poctu trestnych cinov pod vplyvom drog alebo alkoholu od casti kde je nejemenej trestnych cinov po cost kde je najviac
     * @throws SQLException e
     */
    List<String[]> getPocetZistenychTrestnychCinovPodVplyvomByRok(int rok) throws SQLException;
}
