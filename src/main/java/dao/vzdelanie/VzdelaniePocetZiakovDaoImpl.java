package dao.vzdelanie;

import com.j256.ormlite.dao.BaseDaoImpl;
import com.j256.ormlite.support.ConnectionSource;
import entity.vzdelanie.VzdelaniePocetZiakov;
import enums.TypSkoly;

import java.sql.SQLException;
import java.util.List;

/**
 * Class represents:
 * @author xholecko
 */
public class VzdelaniePocetZiakovDaoImpl extends BaseDaoImpl<VzdelaniePocetZiakov, Long> implements VzdelaniePocetZiakovDao {
    public VzdelaniePocetZiakovDaoImpl(ConnectionSource connectionSource) throws SQLException {
        super(connectionSource, VzdelaniePocetZiakov.class);
    }

    @Override
    public List<String[]> getPocetZiakovByRokATypSkoly(int rok, TypSkoly typSkoly) throws SQLException {
        return super.queryBuilder().selectRaw("okres").selectRaw("SUM (pocetZiakov) as pocetZiakovs")
                .groupBy("okres")
                .orderByRaw("pocetZiakovs DESC")
                .where().eq("rok",rok).and().eq("typ",typSkoly)
                .queryRaw().getResults();
    }
}
