package dao.socialne;

import com.j256.ormlite.dao.Dao;
import entity.socialne.SocialneZariadenia;

import java.sql.SQLException;
import java.util.List;

/**
 * Class represents:
 * @author xholecko
 */
public interface SocialneZariadeniaDao extends Dao<SocialneZariadenia,Long> {

    /**
     *
     * @param rok rok (hodnoty od 2016 - 2018) hodnoty rovne ako zadany rok
     * @return zoradeny list casti bratislavy podla poctu trestnych cinov, od casti ktora ma najmensi pocet trestnych cinov po tu ktora ma najvyssi pocet
     * @throws SQLException e
     */
    List<String[]> getPocetSocialnychZariadeniByRokSorted(int rok) throws SQLException;
}
