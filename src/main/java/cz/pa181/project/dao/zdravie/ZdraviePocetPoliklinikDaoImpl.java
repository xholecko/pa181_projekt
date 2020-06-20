package cz.pa181.project.dao.zdravie;

import com.j256.ormlite.dao.BaseDaoImpl;
import com.j256.ormlite.support.ConnectionSource;
import cz.pa181.project.entity.zdravie.ZdraviePocetPoliklinik;

import java.sql.SQLException;
import java.util.List;

/**
 * Class represents:
 * @author xholecko
 */
public class ZdraviePocetPoliklinikDaoImpl extends BaseDaoImpl<ZdraviePocetPoliklinik, Long> implements ZdraviePocetPoliklinikDao {
    public ZdraviePocetPoliklinikDaoImpl(ConnectionSource connectionSource) throws SQLException {
        super(connectionSource, ZdraviePocetPoliklinik.class);
    }

    @Override
    public List<String[]> getPocetPoliklinkByRokSorted(int rok) throws SQLException {
        int maxRok = getMaxRok();
        if (rok > maxRok){
            rok = maxRok;
        }
        return super.queryBuilder().selectRaw("okres").selectRaw("SUM(\"pocetPoliklinik\") as pocetPolikliniks")
                .groupBy("okres")
                .orderByRaw("pocetPolikliniks DESC")
                .where().eq("rok",rok)
                .queryRaw().getResults();
    }
    private int getMaxRok() throws SQLException{
        String tmp = super.queryBuilder().selectRaw("MAX(\"rok\") as maxRok").queryRaw().getResults().get(0)[0];
        return Integer.parseInt(tmp);
    }
}
