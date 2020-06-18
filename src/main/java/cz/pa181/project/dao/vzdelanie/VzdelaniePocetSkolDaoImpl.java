package cz.pa181.project.dao.vzdelanie;

import com.j256.ormlite.dao.BaseDaoImpl;
import com.j256.ormlite.support.ConnectionSource;
import cz.pa181.project.entity.vzdelanie.VzdelaniePocetSkol;

import java.sql.SQLException;
/**
 * Class represents:
 * @author xholecko
 */
public class VzdelaniePocetSkolDaoImpl extends BaseDaoImpl<VzdelaniePocetSkol, Long> implements VzdelaniePocetSkolDao {
    public VzdelaniePocetSkolDaoImpl(ConnectionSource connectionSource) throws SQLException {
        super(connectionSource, VzdelaniePocetSkol.class);
    }
}
