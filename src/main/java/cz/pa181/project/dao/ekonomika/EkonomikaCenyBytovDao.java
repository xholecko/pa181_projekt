package cz.pa181.project.dao.ekonomika;

import com.j256.ormlite.dao.Dao;
import cz.pa181.project.entity.ekonomika.EkonomikaCenyBytov;

import java.sql.SQLException;
import java.util.List;

/**
 * Class represents:
 * @author xholecko
 */
public interface EkonomikaCenyBytovDao extends Dao<EkonomikaCenyBytov, Long> {

    /**
     *
     * @return zoradeny list casti Bratislavy podle priemerne ceny bytov pre aktualny tyzden v roku od nejnizsi po nejvyssi
     * @throws SQLException e
     */
    List<String[]> getPriemernuCenuBytovSorted() throws SQLException;

    /**
     *
     * @param okres Bratislava I, Bratislava II, Bratislava III, Bratislava IV, Bratislava V
     * @return Priemernu cenu bytov v zadanom okrese pre aktualny tyzden v roku
     * @throws SQLException e
     */
    String getPriemernuCenuBytovByOkres(String okres) throws SQLException;
}
