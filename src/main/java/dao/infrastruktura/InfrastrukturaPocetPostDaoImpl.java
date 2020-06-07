package dao.infrastruktura;

import com.j256.ormlite.dao.BaseDaoImpl;
import com.j256.ormlite.support.ConnectionSource;
import entity.infrastruktura.InfrastrukturaPocetPost;

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
    public List<String[]> getPocetPostByOkres(int rok) throws SQLException {
        return super.queryBuilder().selectRaw("okres").selectRaw("SUM (pocetPost) as pocetPosts")
                .groupBy("okres")
                .orderByRaw("pocetPosts DESC")
                .where().eq("rok",rok)
                .queryRaw().getResults();
    }
}
