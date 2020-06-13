package dao.vzdelanie;

import com.j256.ormlite.dao.BaseDaoImpl;
import com.j256.ormlite.support.ConnectionSource;
import entity.vzdelanie.VzdelanieInternatyVS;

import java.sql.SQLException;
import java.util.List;

/**
 * Class represents:
 * @author xholecko
 */
public class VzdelanieInternatyVSDaoImpl extends BaseDaoImpl<VzdelanieInternatyVS, Long> implements VzdelanieInternatyVSDao {
    public VzdelanieInternatyVSDaoImpl(ConnectionSource connectionSource) throws SQLException {
        super(connectionSource, VzdelanieInternatyVS.class);
    }

    @Override
    public List<String[]> getPocetLozokByRok(int rok) throws SQLException {
        return super.queryBuilder().selectRaw("okres").selectRaw("SUM (pocetLozok) as pocetLozoks")
                .groupBy("okres")
                .orderByRaw("pocetLozoks DESC")
                .where().eq("rok",rok)
                .queryRaw().getResults();
    }

    @Override
    public List<String[]> getPocetInternatovByRok(int rok) throws SQLException {
        return super.queryBuilder().selectRaw("okres").selectRaw("SUM (pocetInternatov) as pocetInternatovs")
                .groupBy("okres")
                .orderByRaw("pocetInternatovs DESC")
                .where().eq("rok",rok)
                .queryRaw().getResults();
    }
}
