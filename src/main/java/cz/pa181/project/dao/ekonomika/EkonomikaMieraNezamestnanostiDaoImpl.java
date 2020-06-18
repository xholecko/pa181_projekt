package cz.pa181.project.dao.ekonomika;

import com.j256.ormlite.dao.BaseDaoImpl;
import com.j256.ormlite.support.ConnectionSource;
import cz.pa181.project.entity.ekonomika.EkonomikaMieraNezamestnanosti;

import java.sql.SQLException;
import java.util.List;

/**
 * Class represents:
 * @author xholecko
 */
public class EkonomikaMieraNezamestnanostiDaoImpl extends BaseDaoImpl<EkonomikaMieraNezamestnanosti, Long> implements EkonomikaMieraNezamestnanostiDao{
    public EkonomikaMieraNezamestnanostiDaoImpl(ConnectionSource connectionSource) throws SQLException {
        super(connectionSource, EkonomikaMieraNezamestnanosti.class);
    }


    @Override
    public List<String[]> getMieraNezamestnanostiByRokSorted(int rok) throws SQLException {
        return super.queryBuilder().selectRaw("okres").selectRaw("AVG (miera) as mieras")
                .groupBy("okres")
                .orderByRaw("mieras")
                .where().ge("rok",rok)
                .queryRaw().getResults();
    }
}
