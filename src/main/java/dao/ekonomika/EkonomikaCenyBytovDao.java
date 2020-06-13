package dao.ekonomika;

import com.j256.ormlite.dao.Dao;
import entity.ekonomika.EkonomikaCenyBytov;

import java.sql.SQLException;

/**
 * Class represents:
 * @author xholecko
 */
public interface EkonomikaCenyBytovDao extends Dao<EkonomikaCenyBytov, Long> {



    /**
     *
     * @param okres Bratislava I, Bratislava II, Bratislava III, Bratislava IV, Bratislava V
     * @return Priemernu cenu bytov v zadanom okrese pre aktualny tyzden v roku
     * @throws SQLException e
     */
    String getPriemernuCenuBytovByOkres(String okres) throws SQLException;
}
