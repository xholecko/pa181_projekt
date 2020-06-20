package cz.pa181.project.dao.infrastruktura;

import com.j256.ormlite.dao.BaseDaoImpl;
import com.j256.ormlite.support.ConnectionSource;
import cz.pa181.project.entity.infrastruktura.InfrastrukturaPocetPost;

import java.sql.SQLException;
import java.util.List;

/**
 * Class represents:
 * @author xholecko
 */
public class InfrastrukturaPocetPostDaoImpl extends BaseDaoImpl<InfrastrukturaPocetPost, Long> implements InfrastrukturaPocetPostDao {
    public InfrastrukturaPocetPostDaoImpl(ConnectionSource connectionSource) throws SQLException {
        super(connectionSource, InfrastrukturaPocetPost.class);
    }


    @Override
    public List<String[]> getPocetPostByRokSorted(int rok) throws SQLException {
        int maxRok = getMaxRok();
        if (rok > maxRok){
            rok = maxRok;
        }
        return super.queryBuilder().selectRaw("okres").selectRaw("SUM(\"pocetPost\") as pocetPosts")
                .groupBy("okres")
                .orderByRaw("pocetPosts DESC")
                .where().eq("rok",rok)
                .queryRaw().getResults();
    }
    private int getMaxRok() throws SQLException{
        String tmp = super.queryBuilder().selectRaw("MAX(\"rok\") as maxRok").queryRaw().getResults().get(0)[0];
        return Integer.parseInt(tmp);
    }
}
