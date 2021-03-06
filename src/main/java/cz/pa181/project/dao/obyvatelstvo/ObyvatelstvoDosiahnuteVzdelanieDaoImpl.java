package cz.pa181.project.dao.obyvatelstvo;

import com.j256.ormlite.dao.BaseDaoImpl;
import com.j256.ormlite.support.ConnectionSource;
import cz.pa181.project.entity.obyvatelstvo.ObyvatelstvoDosiahnuteVzdelanie;

import java.sql.SQLException;
import java.util.List;

/**
 * Class represents:
 * @author xholecko
 */
public class ObyvatelstvoDosiahnuteVzdelanieDaoImpl extends BaseDaoImpl<ObyvatelstvoDosiahnuteVzdelanie, Long> implements ObyvatelstvoDosiahnuteVzdelanieDao {
    public ObyvatelstvoDosiahnuteVzdelanieDaoImpl(ConnectionSource connectionSource) throws SQLException {
        super(connectionSource, ObyvatelstvoDosiahnuteVzdelanie.class);
    }

    @Override
    public List<String[]> getDosiahnuteVzdelanieSpoluByRokSorted() throws SQLException {
        return super.queryBuilder().selectRaw("okres").selectRaw("SUM(\"pocetSpolu\") as pocetSpolus")
                .groupBy("okres")
                .orderByRaw("pocetSpolus DESC")
                .queryRaw().getResults();
    }
}
