package dao.vzdelanie;

import com.j256.ormlite.dao.BaseDaoImpl;
import com.j256.ormlite.support.ConnectionSource;
import entity.vzdelanie.VzdelanieInternatyVS;

import java.sql.SQLException;
/**
 * Class represents:
 * @author xholecko
 */
public class VzdelanieInternatyVSDaoImpl extends BaseDaoImpl<VzdelanieInternatyVS, Long> implements VzdelanieInternatyVSDao {
    public VzdelanieInternatyVSDaoImpl(ConnectionSource connectionSource) throws SQLException {
        super(connectionSource, VzdelanieInternatyVS.class);
    }
}
