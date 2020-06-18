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
        return super.queryBuilder().selectRaw("okres").selectRaw("AVG (prirastok) as prirastoks")
                .groupBy("okres")
                .orderByRaw("prirastoks")
                .where().eq("rok",rok)
                .queryRaw().getResults();
    }
}
