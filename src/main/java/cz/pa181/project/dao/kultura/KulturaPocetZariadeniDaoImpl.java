package cz.pa181.project.dao.kultura;

import com.j256.ormlite.dao.BaseDaoImpl;
import com.j256.ormlite.support.ConnectionSource;
import cz.pa181.project.entity.kultura.KulturaPocetZariadeni;
import cz.pa181.project.enums.TypZariadeni;

import java.sql.SQLException;
import java.util.List;

/**
 * Class represents:
 * @author xholecko
 */
public class KulturaPocetZariadeniDaoImpl extends BaseDaoImpl<KulturaPocetZariadeni, Long> implements KulturaPocetZariadeniDao{
    public KulturaPocetZariadeniDaoImpl(ConnectionSource connectionSource) throws SQLException {
        super(connectionSource, KulturaPocetZariadeni.class);
    }

    @Override
    public List<String[]> getPocetZariadeniByRokSorted(int rok) throws SQLException {
        int maxRok = getMaxRok();
        if (rok > maxRok){
            rok = maxRok;
        }
        return super.queryBuilder().selectRaw("okres").selectRaw("SUM(\"pocetZariadeni\") as pocetZariadenis")
                .groupBy("okres")
                .orderByRaw("pocetZariadenis DESC")
                .where().eq("rok",rok)
                .queryRaw().getResults();
    }

    @Override
    public List<String[]> getPocetZariadeniByRokATypZariadeniaSorted(int rok, TypZariadeni typZariadeni) throws SQLException {
        int maxRok = getMaxRok();
        if (rok > maxRok){
            rok = maxRok;
        }
        return super.queryBuilder().selectRaw("okres").selectRaw("SUM(\"pocetZariadeni\") as pocetZariadenis")
                .groupBy("okres")
                .orderByRaw("pocetZariadenis DESC")
                .where().eq("rok",rok).and().eq("typ",typZariadeni)
                .queryRaw().getResults();
    }

    private int getMaxRok() throws SQLException{
        String tmp = super.queryBuilder().selectRaw("MAX(\"rok\") as maxRok").queryRaw().getResults().get(0)[0];
        return Integer.parseInt(tmp);
    }
}
