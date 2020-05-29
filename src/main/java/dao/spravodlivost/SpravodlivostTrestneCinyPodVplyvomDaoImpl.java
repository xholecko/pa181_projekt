package dao.spravodlivost;

import com.j256.ormlite.dao.BaseDaoImpl;
import com.j256.ormlite.support.ConnectionSource;
import entity.spravodlivost.SpravodlivostTrestneCinyPodVplyvom;

import java.sql.SQLException;
/**
 * Class represents:
 * @author xholecko
 */
public class SpravodlivostTrestneCinyPodVplyvomDaoImpl extends BaseDaoImpl<SpravodlivostTrestneCinyPodVplyvom, Long> implements SpravodlivostTrestneCinyPodVplyvomDao {
    public SpravodlivostTrestneCinyPodVplyvomDaoImpl(ConnectionSource connectionSource) throws SQLException {
        super(connectionSource, SpravodlivostTrestneCinyPodVplyvom.class);
    }
}
