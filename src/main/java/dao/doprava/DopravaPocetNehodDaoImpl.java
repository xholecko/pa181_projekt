package dao.doprava;

import com.j256.ormlite.dao.BaseDaoImpl;
import com.j256.ormlite.dao.GenericRawResults;
import com.j256.ormlite.stmt.PreparedQuery;
import com.j256.ormlite.support.ConnectionSource;
import entity.doprava.DopravaPocetNehod;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * Class represents:
 * @author xholecko
 */
public class DopravaPocetNehodDaoImpl extends BaseDaoImpl<DopravaPocetNehod, Long> implements DopravaPocetNehodDao {
    public DopravaPocetNehodDaoImpl(ConnectionSource connectionSource) throws SQLException {
        super(connectionSource, DopravaPocetNehod.class);
    }

    @Override
    public List<DopravaPocetNehod> findByOkres(String okres) throws SQLException {
        return super.queryForEq("okres", okres);
    }

    @Override
    public List<DopravaPocetNehod> findByRok(int rok) throws SQLException {
        return super.queryForEq("rok", rok);
    }

    @Override
    public List<String[]> getPocetNehodByRok(int rok) throws SQLException{
        return super.queryBuilder().selectRaw("okres").selectRaw("SUM (pocetNehod) as pocetNehods")
                .groupBy("okres")
                .orderByRaw("pocetNehods")
                .where().ge("rok",rok)
                .queryRaw().getResults();
    }
}
