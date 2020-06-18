package cz.pa181.project.dao.ekonomika;

import com.j256.ormlite.dao.Dao;
import cz.pa181.project.entity.ekonomika.EkonomikaMieraNezamestnanosti;

import java.sql.SQLException;
import java.util.List;

/**
 * Class represents:
 * @author xholecko
 */
public interface EkonomikaMieraNezamestnanostiDao extends Dao<EkonomikaMieraNezamestnanosti, Long> {

    /**
     *
     * @param rok rok (hodnoty od 2001 - 2018) hodnoty vacsie alebo rovne ako zadany rok
     * @return zoradeny list casti bratislavy od casti ktora ma najnizsiu priemernu nezamestnanost po cast ktora ma najvyssiu nezamestnanost
     * @throws SQLException e
     */
    List<String[]> getMieraNezamestnanostiByRokSorted(int rok) throws SQLException;
}
