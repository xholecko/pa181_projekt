package dao.socialne;

import com.j256.ormlite.dao.BaseDaoImpl;
import com.j256.ormlite.support.ConnectionSource;
import entity.socialne.SocialneZariadenia;

import java.sql.SQLException;

public class SocialneZariadeniaDaoImpl extends BaseDaoImpl<SocialneZariadenia, Long> implements SocialneZariadeniaDao {
    public SocialneZariadeniaDaoImpl(ConnectionSource connectionSource) throws SQLException {
        super(connectionSource, SocialneZariadenia.class);
    }
}
