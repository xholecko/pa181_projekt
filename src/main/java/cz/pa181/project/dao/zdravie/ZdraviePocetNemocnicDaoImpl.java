package cz.pa181.project.dao.zdravie;

import com.j256.ormlite.dao.BaseDaoImpl;
import com.j256.ormlite.support.ConnectionSource;
import cz.pa181.project.entity.zdravie.ZdraviePocetNemocnic;

import java.sql.SQLException;
import java.util.List;

/**
 * Class represents:
 * @author xholecko
 */
public class ZdraviePocetNemocnicDaoImpl extends BaseDaoImpl<ZdraviePocetNemocnic, Long> implements ZdraviePocetNemocnicDao {
    public ZdraviePocetNemocnicDaoImpl(ConnectionSource connectionSource) throws SQLException {
        super(connectionSource, ZdraviePocetNemocnic.class);
    }

    @Override
    public List<String[]> getPocetNemocnicByRokSorted(int rok) throws SQLException {
        return super.queryBuilder().selectRaw("okres").selectRaw("SUM (pocetNemocnic) as pocetNemocnics")
                .groupBy("okres")
                .orderByRaw("pocetNemocnics DESC")
                .where().eq("rok",rok)
                .queryRaw().getResults();
    }
}
