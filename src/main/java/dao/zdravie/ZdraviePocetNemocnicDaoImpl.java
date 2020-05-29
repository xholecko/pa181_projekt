package dao.zdravie;

import com.j256.ormlite.dao.BaseDaoImpl;
import com.j256.ormlite.support.ConnectionSource;
import entity.zdravie.ZdraviePocetNemocnic;

import java.sql.SQLException;
/**
 * Class represents:
 * @author xholecko
 */
public class ZdraviePocetNemocnicDaoImpl extends BaseDaoImpl<ZdraviePocetNemocnic, Long> implements ZdraviePocetNemocnicDao {
    public ZdraviePocetNemocnicDaoImpl(ConnectionSource connectionSource) throws SQLException {
        super(connectionSource, ZdraviePocetNemocnic.class);
    }
}
