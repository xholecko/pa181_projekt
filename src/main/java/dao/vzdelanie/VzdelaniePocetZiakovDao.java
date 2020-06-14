package dao.vzdelanie;

import com.j256.ormlite.dao.Dao;
import entity.vzdelanie.VzdelaniePocetZiakov;
import enums.TypSkoly;

import java.sql.SQLException;
import java.util.List;

/**
 * Class represents:
 * @author xholecko
 */
public interface VzdelaniePocetZiakovDao extends Dao<VzdelaniePocetZiakov,Long> {

    /**
     * @param typSkoly ZAKLADNA_SKOLA,GYMNAZIUM,JAZYKOVA_SKOLA,STREDNA_ODBORNA_SKOLAA
     * @param rok rok (hodnoty od 1996 - 2018) hodnoty rovne ako zadany rok
     * @return zoradeny list casti bratislavy od casti ktora ma najviac ziakov po cast ktora ma najemej ziakov
     * @throws SQLException e
     */
    List<String[]> getPocetZiakovByRokATypSkolySorted(int rok, TypSkoly typSkoly) throws SQLException;
}
