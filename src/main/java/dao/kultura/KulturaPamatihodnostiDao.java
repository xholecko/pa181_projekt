package dao.kultura;

import com.j256.ormlite.dao.Dao;
import entity.kultura.KulturaPamatihodnosti;

import java.sql.SQLException;
import java.util.List;

/**
 * Class represents:
 * @author xholecko
 */
public interface KulturaPamatihodnostiDao extends Dao<KulturaPamatihodnosti, Long> {

    /**
     *
     * @return zoradeny list casti bratislavy od casti ktora ma najviac pamatihodnosti po cast ktora ma najmenej
     * @throws SQLException e
     */
    List<String[]> getPamatihodnostiByRok() throws SQLException;
    //TODO
}
