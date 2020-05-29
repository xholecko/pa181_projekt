package dao.zdravie;

import com.j256.ormlite.dao.BaseDaoImpl;
import com.j256.ormlite.support.ConnectionSource;
import entity.zdravie.ZdraviePocetPoliklinik;

import java.sql.SQLException;
/**
 * Class represents:
 * @author xholecko
 */
public class ZdraviePocetPoliklinikDaoImpl extends BaseDaoImpl<ZdraviePocetPoliklinik, Long> implements ZdraviePocetPoliklinikDao {
    public ZdraviePocetPoliklinikDaoImpl(ConnectionSource connectionSource) throws SQLException {
        super(connectionSource, ZdraviePocetPoliklinik.class);
    }
}
