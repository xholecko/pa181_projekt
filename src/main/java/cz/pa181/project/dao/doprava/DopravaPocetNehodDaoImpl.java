package cz.pa181.project.dao.doprava;

import com.j256.ormlite.dao.BaseDaoImpl;
import com.j256.ormlite.support.ConnectionSource;
import cz.pa181.project.entity.doprava.DopravaPocetNehod;

import java.sql.SQLException;
import java.util.List;

/**
 * Class represents:
 * @author xholecko
 */
public class DopravaPocetNehodDaoImpl extends BaseDaoImpl<DopravaPocetNehod, Long> implements DopravaPocetNehodDao {
    public DopravaPocetNehodDaoImpl(ConnectionSource connectionSource) throws SQLException {
        super(connectionSource, DopravaPocetNehod.class);
    }

    @Override
    public List<String[]> getPocetNehodByRokSorted(int rok) throws SQLException{
        int maxRok = getMaxRok();
        if (rok > maxRok){
            rok = maxRok;
        }
        return super.queryBuilder().selectRaw("okres").selectRaw("SUM(\"pocetNehod\") as pocetNehods")
                .groupBy("okres")
                .orderByRaw("pocetNehods")
                .where().ge("rok",rok)
                .queryRaw().getResults();
    }

    private int getMaxRok() throws SQLException{
        String tmp = super.queryBuilder().selectRaw("MAX(\"rok\") as maxRok").queryRaw().getResults().get(0)[0];
        return Integer.parseInt(tmp);
    }
}
