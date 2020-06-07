package dao.spravodlivost;

import com.j256.ormlite.dao.BaseDaoImpl;
import com.j256.ormlite.support.ConnectionSource;
import entity.spravodlivost.SpravodlivostTrestneCinyPodVplyvom;

import java.sql.SQLException;
import java.util.List;

/**
 * Class represents:
 * @author xholecko
 */
public class SpravodlivostTrestneCinyPodVplyvomDaoImpl extends BaseDaoImpl<SpravodlivostTrestneCinyPodVplyvom, Long> implements SpravodlivostTrestneCinyPodVplyvomDao {
    public SpravodlivostTrestneCinyPodVplyvomDaoImpl(ConnectionSource connectionSource) throws SQLException {
        super(connectionSource, SpravodlivostTrestneCinyPodVplyvom.class);
    }

    @Override
    public List<String[]> getPocetZistenychTrestnychCinovPodVplyvomByOkres(int rok) throws SQLException {
        return super.queryBuilder().selectRaw("okres").selectRaw("SUM (pocetTrestnychCinovAlkohol + pocetTrestnychCinovDrogy) as pocetTrestnychCinovs")
                .groupBy("okres")
                .orderByRaw("pocetTrestnychCinovs")
                .where().like("rok","%" + rok + "%")
                .queryRaw().getResults();
    }
}
