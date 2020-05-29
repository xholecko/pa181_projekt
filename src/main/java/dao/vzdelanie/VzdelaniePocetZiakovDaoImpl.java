package dao.vzdelanie;

import com.j256.ormlite.dao.BaseDaoImpl;
import com.j256.ormlite.support.ConnectionSource;
import entity.vzdelanie.VzdelaniePocetZiakov;

import java.sql.SQLException;
/**
 * Class represents:
 * @author xholecko
 */
public class VzdelaniePocetZiakovDaoImpl extends BaseDaoImpl<VzdelaniePocetZiakov, Long> implements VzdelaniePocetZiakovDao {
    public VzdelaniePocetZiakovDaoImpl(ConnectionSource connectionSource) throws SQLException {
        super(connectionSource, VzdelaniePocetZiakov.class);
    }
}
