package dao.ekonomika;

import com.j256.ormlite.dao.BaseDaoImpl;
import com.j256.ormlite.support.ConnectionSource;
import entity.ekonomika.EkonomikaIndexStartnutia;

import java.sql.SQLException;
/**
 * Class represents:
 * @author xholecko
 */
public class EkonomikaIndexStartnutiaDaoImpl  extends BaseDaoImpl<EkonomikaIndexStartnutia, Long> implements EkonomikaIndexStartnutiaDao {
    public EkonomikaIndexStartnutiaDaoImpl(ConnectionSource connectionSource) throws SQLException {
        super(connectionSource, EkonomikaIndexStartnutia.class);
    }
}
