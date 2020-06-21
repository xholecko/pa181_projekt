package cz.pa181.project.dao.obyvatelstvo;

import com.j256.ormlite.dao.BaseDaoImpl;
import com.j256.ormlite.support.ConnectionSource;
import cz.pa181.project.entity.obyvatelstvo.ObyvatelstvoPocet;

import java.sql.SQLException;
import java.util.List;

/**
 * Class represents:
 * @author xholecko
 */
public class ObyvatelstvoPocetDaoImpl extends BaseDaoImpl<ObyvatelstvoPocet, Long> implements ObyvatelstvoPocetDao {
    public ObyvatelstvoPocetDaoImpl(ConnectionSource connectionSource) throws SQLException {
        super(connectionSource, ObyvatelstvoPocet.class);
    }

    @Override
    public List<String[]> getPocetObyvatelovByRokSorted(int rok) throws SQLException {
        int maxRok = getMaxRok();
        if (rok > maxRok){
            rok = maxRok;
        }
        return super.queryBuilder().selectRaw("okres").selectRaw("SUM(\"pocetObyvatelov\") as pocetObyvatelovs")
                .groupBy("okres")
                .orderByRaw("pocetObyvatelovs")
                .where().eq("rok",rok)
                .queryRaw().getResults();
    }
    private int getMaxRok() throws SQLException{
        String tmp = super.queryBuilder().selectRaw("MAX(\"rok\") as maxRok").queryRaw().getResults().get(0)[0];
        return Integer.parseInt(tmp);
    }
}
