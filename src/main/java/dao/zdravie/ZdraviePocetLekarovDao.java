package dao.zdravie;

import com.j256.ormlite.dao.Dao;
import entity.zdravie.ZdraviePocetLekarov;

import java.sql.SQLException;
import java.util.List;

/**
 * Class represents:
 * @author xholecko
 */
public interface ZdraviePocetLekarovDao extends Dao<ZdraviePocetLekarov,Long> {

    /**
     *
     * @param rok rok (hodnoty od 1996 - 2017) hodnoty rovne ako zadany rok
     * @return zoradeny list casti bratislavy podla poctu lekarov od najviac po najmenej
     * @throws SQLException e
     */
    List<String[]> getPocetLekarovByRokSorted(int rok) throws SQLException;
}
