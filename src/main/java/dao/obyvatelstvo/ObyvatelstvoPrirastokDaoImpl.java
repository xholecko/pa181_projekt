package dao.obyvatelstvo;

import com.j256.ormlite.dao.BaseDaoImpl;
import com.j256.ormlite.support.ConnectionSource;
import entity.obyvatelstvo.ObyvatelstvoPrirastok;

import java.sql.SQLException;
import java.util.List;

/**
 * Class represents:
 * @author xholecko
 */
public class ObyvatelstvoPrirastokDaoImpl extends BaseDaoImpl<ObyvatelstvoPrirastok, Long> implements ObyvatelstvoPrirastokDao {
    public ObyvatelstvoPrirastokDaoImpl(ConnectionSource connectionSource) throws SQLException {
        super(connectionSource, ObyvatelstvoPrirastok.class);
    }

    @Override
    public List<String[]> getPrirastokByRokSorted(int rok) throws SQLException {

        return super.queryBuilder().selectRaw("okres").selectRaw("SUM (prirastok) as prirastoks")
                .groupBy("okres")
                .orderByRaw("prirastoks DESC")
                .where().eq("rok",rok)
                .queryRaw().getResults();
    }
}
