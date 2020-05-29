package dao.obyvatelstvo;

import com.j256.ormlite.dao.BaseDaoImpl;
import com.j256.ormlite.support.ConnectionSource;
import entity.obyvatelstvo.ObyvatelstvoDosiahnuteVzdelanie;

import java.sql.SQLException;
/**
 * Class represents:
 * @author xholecko
 */
public class ObyvatelstvoDosiahnuteVzdelanieDaoImpl extends BaseDaoImpl<ObyvatelstvoDosiahnuteVzdelanie, Long> implements ObyvatelstvoDosiahnuteVzdelanieDao {
    public ObyvatelstvoDosiahnuteVzdelanieDaoImpl(ConnectionSource connectionSource) throws SQLException {
        super(connectionSource, ObyvatelstvoDosiahnuteVzdelanie.class);
    }
}
