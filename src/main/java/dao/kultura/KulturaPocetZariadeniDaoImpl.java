package dao.kultura;

import com.j256.ormlite.dao.BaseDaoImpl;
import com.j256.ormlite.support.ConnectionSource;
import entity.kultura.KulturaPocetZariadeni;

import java.sql.SQLException;
/**
 * Class represents:
 * @author xholecko
 */
public class KulturaPocetZariadeniDaoImpl extends BaseDaoImpl<KulturaPocetZariadeni, Long> implements KulturaPocetZariadeniDao{
    public KulturaPocetZariadeniDaoImpl(ConnectionSource connectionSource) throws SQLException {
        super(connectionSource, KulturaPocetZariadeni.class);
    }
}
