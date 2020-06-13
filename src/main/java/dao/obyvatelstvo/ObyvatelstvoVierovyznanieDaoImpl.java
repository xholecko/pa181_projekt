package dao.obyvatelstvo;

import com.j256.ormlite.dao.BaseDaoImpl;
import com.j256.ormlite.support.ConnectionSource;
import entity.obyvatelstvo.ObyvatelstvoVierovyznanie;

import java.sql.SQLException;
import java.util.List;

/**
 * Class represents:
 * @author xholecko
 */
public class ObyvatelstvoVierovyznanieDaoImpl extends BaseDaoImpl<ObyvatelstvoVierovyznanie, Long> implements ObyvatelstvoVierovyznanieDao {
    public ObyvatelstvoVierovyznanieDaoImpl(ConnectionSource connectionSource) throws SQLException {
        super(connectionSource, ObyvatelstvoVierovyznanie.class);
    }

    @Override
    public List<String[]> getVierovyznanieByRok() throws SQLException {
        return super.queryBuilder().selectRaw("okres").selectRaw("AVG ((100.0 / spolu) * (spolu - ateisti)) as pocetVeriacichVPercentachs")
                .groupBy("okres")
                .orderByRaw("pocetVeriacichVPercentachs DESC")
                .queryRaw().getResults();
    }
}
