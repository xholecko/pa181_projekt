package dao.obyvatelstvo;

import com.j256.ormlite.dao.BaseDaoImpl;
import com.j256.ormlite.support.ConnectionSource;
import entity.obyvatelstvo.ObyvatelstvoPocet;

import java.sql.SQLException;
/**
 * Class represents:
 * @author xholecko
 */
public class ObyvatelstvoPocetDaoImpl extends BaseDaoImpl<ObyvatelstvoPocet, Long> implements ObyvatelstvoPocetDao {
    public ObyvatelstvoPocetDaoImpl(ConnectionSource connectionSource) throws SQLException {
        super(connectionSource, ObyvatelstvoPocet.class);
    }
}
