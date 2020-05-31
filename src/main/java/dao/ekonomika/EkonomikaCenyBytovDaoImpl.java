package dao.ekonomika;

import com.j256.ormlite.dao.BaseDaoImpl;
import com.j256.ormlite.support.ConnectionSource;
import entity.ekonomika.EkonomikaCenyBytov;

import java.sql.SQLException;

/**
 * Class represents:
 * @author xholecko
 */
public class EkonomikaCenyBytovDaoImpl   extends BaseDaoImpl<EkonomikaCenyBytov, Long> implements EkonomikaCenyBytovDao {
    public EkonomikaCenyBytovDaoImpl(ConnectionSource connectionSource) throws SQLException {
        super(connectionSource, EkonomikaCenyBytov.class);
    }
}
