package cz.pa181.project.dao.spravodlivost;

import com.j256.ormlite.dao.BaseDaoImpl;
import com.j256.ormlite.support.ConnectionSource;
import cz.pa181.project.entity.spravodlivost.SpravodlivostTrestneCinyPodVplyvom;

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
    public List<String[]> getPocetZistenychTrestnychCinovPodVplyvomByRokSorted(int rok) throws SQLException {
        int maxRok = getMaxRok();
        if (rok > maxRok){
            rok = maxRok;
        }
        return super.queryBuilder().selectRaw("okres").selectRaw("SUM(\"pocetTrestnychCinovAlkohol\" + \"pocetTrestnychCinovDrogy\") as pocetTrestnychCinovs")
                .groupBy("okres")
                .orderByRaw("pocetTrestnychCinovs")
                .where().like("rok","%" + rok + "%")
                .queryRaw().getResults();
    }

    private int getMaxRok() throws SQLException{
        String tmp = super.queryBuilder().selectRaw("MAX(\"rok\") as maxRok").queryRaw().getResults().get(0)[0];
        return Integer.parseInt(tmp);
    }
}
