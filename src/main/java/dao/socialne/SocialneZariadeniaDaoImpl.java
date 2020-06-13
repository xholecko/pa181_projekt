package dao.socialne;

import com.j256.ormlite.dao.BaseDaoImpl;
import com.j256.ormlite.support.ConnectionSource;
import entity.socialne.SocialneZariadenia;

import java.sql.SQLException;
import java.util.List;

public class SocialneZariadeniaDaoImpl extends BaseDaoImpl<SocialneZariadenia, Long> implements SocialneZariadeniaDao {
    public SocialneZariadeniaDaoImpl(ConnectionSource connectionSource) throws SQLException {
        super(connectionSource, SocialneZariadenia.class);
    }

    @Override
    public List<String[]> getPocetSocialnychZariadeniByRok(int rok) throws SQLException {
        return super.queryBuilder().selectRaw("okres").selectRaw("SUM (pocet) as pocets")
                .groupBy("okres")
                .orderByRaw("pocets DESC")
                .where().eq("rok",rok)
                .queryRaw().getResults();
    }
}
