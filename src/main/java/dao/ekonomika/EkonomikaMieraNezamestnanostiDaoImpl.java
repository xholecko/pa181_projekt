package dao.ekonomika;

import com.j256.ormlite.dao.BaseDaoImpl;
import com.j256.ormlite.support.ConnectionSource;
import entity.ekonomika.EkonomikaMieraNezamestnanosti;

import java.sql.SQLException;
/**
 * Class represents:
 * @author xholecko
 */
public class EkonomikaMieraNezamestnanostiDaoImpl extends BaseDaoImpl<EkonomikaMieraNezamestnanosti, Long> implements EkonomikaMieraNezamestnanostiDao{
    public EkonomikaMieraNezamestnanostiDaoImpl(ConnectionSource connectionSource) throws SQLException {
        super(connectionSource, EkonomikaMieraNezamestnanosti.class);
    }
}
