package dao.infrastruktura;

import com.j256.ormlite.dao.BaseDaoImpl;
import com.j256.ormlite.support.ConnectionSource;
import entity.infrastruktura.InfrastrukturaPocetPost;

import java.sql.SQLException;
/**
 * Class represents:
 * @author xholecko
 */
public class InfrastrukturaPocetPostDaoImpl extends BaseDaoImpl<InfrastrukturaPocetPost, Long> implements InfrastrukturaPocetPostDao {
    public InfrastrukturaPocetPostDaoImpl(ConnectionSource connectionSource) throws SQLException {
        super(connectionSource, InfrastrukturaPocetPost.class);
    }
}
