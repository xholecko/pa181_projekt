package dao.zdravie;

import com.j256.ormlite.dao.BaseDaoImpl;
import com.j256.ormlite.support.ConnectionSource;

import entity.zdravie.ZdraviePocetLekarov;

import java.sql.SQLException;
/**
 * Class represents:
 * @author xholecko
 */
public class ZdraviePocetLekarovDaoImpl extends BaseDaoImpl<ZdraviePocetLekarov, Long> implements ZdraviePocetLekarovDao {
    public ZdraviePocetLekarovDaoImpl(ConnectionSource connectionSource) throws SQLException {
        super(connectionSource, ZdraviePocetLekarov.class);
    }
}
