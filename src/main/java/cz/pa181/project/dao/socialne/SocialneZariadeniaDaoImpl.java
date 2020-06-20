package cz.pa181.project.dao.socialne;

import com.j256.ormlite.dao.BaseDaoImpl;
import com.j256.ormlite.support.ConnectionSource;
import cz.pa181.project.entity.socialne.SocialneZariadenia;

import java.sql.SQLException;
import java.util.List;

public class SocialneZariadeniaDaoImpl extends BaseDaoImpl<SocialneZariadenia, Long> implements SocialneZariadeniaDao {
    public SocialneZariadeniaDaoImpl(ConnectionSource connectionSource) throws SQLException {
        super(connectionSource, SocialneZariadenia.class);
    }

    @Override
    public List<String[]> getPocetSocialnychZariadeniByRokSorted(int rok) throws SQLException {
        int maxRok = getMaxRok();
        if (rok > maxRok){
            rok = maxRok;
        }
        return super.queryBuilder().selectRaw("okres").selectRaw("SUM(\"pocet\") as pocets")
                .groupBy("okres")
                .orderByRaw("pocets DESC")
                .where().eq("rok",rok)
                .queryRaw().getResults();
    }

    private int getMaxRok() throws SQLException{
        String tmp = super.queryBuilder().selectRaw("MAX(\"rok\") as maxRok").queryRaw().getResults().get(0)[0];
        return Integer.parseInt(tmp);
    }
}
