package dao.kultura;

import com.j256.ormlite.dao.BaseDaoImpl;
import com.j256.ormlite.support.ConnectionSource;
import entity.kultura.KulturaPocetZariadeni;
import enums.TypZariadeni;

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
    public List<String[]> getPocetZariadeniByRokATypZariadeniaSorted(int rok, TypZariadeni typZariadeni) throws SQLException {
        return super.queryBuilder().selectRaw("okres").selectRaw("SUM (pocetZariadeni) as pocetZariadenis")
                .groupBy("okres")
                .orderByRaw("pocetZariadenis DESC")
                .where().eq("rok",rok).and().eq("typ",typZariadeni)
                .queryRaw().getResults();
    }
}
