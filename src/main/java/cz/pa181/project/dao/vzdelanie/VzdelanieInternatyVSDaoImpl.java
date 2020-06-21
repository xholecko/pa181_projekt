package cz.pa181.project.dao.vzdelanie;

import com.j256.ormlite.dao.BaseDaoImpl;
import com.j256.ormlite.support.ConnectionSource;
import cz.pa181.project.entity.vzdelanie.VzdelanieInternatyVS;

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
    public List<String[]> getPocetLozokByRokSorted(int rok) throws SQLException {
        int maxRok = getMaxRok();
        if (rok > maxRok){
            rok = maxRok;
        }
        return super.queryBuilder().selectRaw("okres").selectRaw("SUM(\"pocetLozok\") as pocetLozoks")
                .groupBy("okres")
                .orderByRaw("pocetLozoks DESC")
                .where().eq("rok",rok)
                .queryRaw().getResults();
    }

    @Override
    public List<String[]> getPocetInternatovByRokSorted(int rok) throws SQLException {
        int maxRok = getMaxRok();
        if (rok > maxRok){
            rok = maxRok;
        }
        return super.queryBuilder().selectRaw("okres").selectRaw("SUM (\"pocetInternatov\") as pocetInternatovs")
                .groupBy("okres")
                .orderByRaw("pocetInternatovs DESC")
                .where().eq("rok",rok)
                .queryRaw().getResults();
    }

    private Integer getMaxRok() throws SQLException{
        String tmp = super.queryBuilder().selectRaw("MAX(\"rok\") as maxRok").queryRaw().getResults().get(0)[0];
        return Integer.parseInt(tmp);
    }
}
