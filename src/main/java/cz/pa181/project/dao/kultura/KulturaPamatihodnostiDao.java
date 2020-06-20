package cz.pa181.project.dao.kultura;

import com.j256.ormlite.dao.Dao;
import cz.pa181.project.entity.kultura.KulturaPamatihodnosti;

import java.sql.SQLException;
import java.util.List;

/**
 * Class represents:
 * @author xholecko
 */
public interface KulturaPamatihodnostiDao extends Dao<KulturaPamatihodnosti, Long> {

    /**
     * Dataset niekedy vrati ako mestsku cast nejaku nekorektnu hodnotu napr "-", tychto zaznamov je minimum
     * a ako okres v Importe som im nastavil "undefined", s tymi zaznamami sa nebude pocitat a vo finalnom zozname nebudu
     *
     * @return zoradeny list casti bratislavy od casti ktora ma najviac pamatihodnosti po cast ktora ma najmenej
     * @throws SQLException e
     */
    List<String[]> getPamatihodnostiSorted() throws SQLException;

}
