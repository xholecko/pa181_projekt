package cz.pa181.project.dao.kultura;

import com.j256.ormlite.dao.BaseDaoImpl;
import com.j256.ormlite.support.ConnectionSource;
import cz.pa181.project.entity.kultura.KulturaPamatihodnosti;

import java.sql.SQLException;
import java.util.List;

/**
 * Class represents:
 * @author xholecko
 */
public class KulturaPamatihodnostiDaoImpl extends BaseDaoImpl<KulturaPamatihodnosti, Long> implements KulturaPamatihodnostiDao {
    public KulturaPamatihodnostiDaoImpl(ConnectionSource connectionSource) throws SQLException {
        super(connectionSource, KulturaPamatihodnosti.class);
    }
    @Override
    public List<String[]> getPamatihodnostiSorted() throws SQLException {
        return super.queryBuilder().selectRaw("okres").selectRaw("COUNT(\"okres\") as pocetOkresov")
                .groupBy("okres")
                .orderByRaw("pocetOkresov DESC")
                .where().not().eq("okres","undefined")
                .queryRaw().getResults();
    }
}
