package cz.pa181.project.dao.zdravie;

import com.j256.ormlite.dao.BaseDaoImpl;
import com.j256.ormlite.support.ConnectionSource;

import cz.pa181.project.entity.zdravie.ZdraviePocetLekarov;

import java.sql.SQLException;
import java.util.List;

/**
 * Class represents:
 * @author xholecko
 */
public class ZdraviePocetLekarovDaoImpl extends BaseDaoImpl<ZdraviePocetLekarov, Long> implements ZdraviePocetLekarovDao {
    public ZdraviePocetLekarovDaoImpl(ConnectionSource connectionSource) throws SQLException {
        super(connectionSource, ZdraviePocetLekarov.class);
    }

    @Override
    public List<String[]> getPocetLekarovByRokSorted(int rok) throws SQLException {
        int maxRok = getMaxRok();
        if (rok > maxRok){
            rok = maxRok;
        }
        return super.queryBuilder().selectRaw("okres").selectRaw("SUM (\"lekarDospeli\" + \"lekarDeti\" + " +
                "\"stomatolog\" + \"gynekolog\" + \"specialista\") as pocetLekarov")
                .groupBy("okres")
                .orderByRaw("pocetLekarov DESC")
                .where().eq("rok",rok)
                .queryRaw().getResults();
    }
    private int getMaxRok() throws SQLException{
        String tmp = super.queryBuilder().selectRaw("MAX(\"rok\") as maxRok").queryRaw().getResults().get(0)[0];
        return Integer.parseInt(tmp);
    }
}
