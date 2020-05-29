package dao.obyvatelstvo;

import com.j256.ormlite.dao.BaseDaoImpl;
import com.j256.ormlite.support.ConnectionSource;
import entity.obyvatelstvo.ObyvatelstvoVierovyznanie;

import java.sql.SQLException;
/**
 * Class represents:
 * @author xholecko
 */
public class ObyvatelstvoVierovyznanieDaoImpl extends BaseDaoImpl<ObyvatelstvoVierovyznanie, Long> implements ObyvatelstvoVierovyznanieDao {
    public ObyvatelstvoVierovyznanieDaoImpl(ConnectionSource connectionSource) throws SQLException {
        super(connectionSource, ObyvatelstvoVierovyznanie.class);
    }
}
