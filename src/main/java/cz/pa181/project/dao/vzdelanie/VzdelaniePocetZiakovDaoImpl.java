package cz.pa181.project.dao.vzdelanie;

import com.j256.ormlite.dao.BaseDaoImpl;
import com.j256.ormlite.support.ConnectionSource;
import cz.pa181.project.entity.vzdelanie.VzdelaniePocetZiakov;
import cz.pa181.project.enums.TypSkoly;

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
    public List<String[]> getPocetZiakovByRokATypSkolySorted(int rok, TypSkoly typSkoly) throws SQLException {
        return super.queryBuilder().selectRaw("okres").selectRaw("SUM (pocetZiakov) as pocetZiakovs")
                .groupBy("okres")
                .orderByRaw("pocetZiakovs DESC")
                .where().eq("rok",rok).and().eq("typ",typSkoly)
                .queryRaw().getResults();
    }
}
