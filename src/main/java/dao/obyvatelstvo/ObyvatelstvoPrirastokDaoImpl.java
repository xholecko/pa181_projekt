package dao.obyvatelstvo;

import com.j256.ormlite.dao.BaseDaoImpl;
import com.j256.ormlite.support.ConnectionSource;
import entity.obyvatelstvo.ObyvatelstvoPrirastok;

import java.sql.SQLException;
/**
 * Class represents:
 * @author xholecko
 */
public class ObyvatelstvoPrirastokDaoImpl extends BaseDaoImpl<ObyvatelstvoPrirastok, Long> implements ObyvatelstvoPrirastokDao {
    public ObyvatelstvoPrirastokDaoImpl(ConnectionSource connectionSource) throws SQLException {
        super(connectionSource, ObyvatelstvoPrirastok.class);
    }
}
