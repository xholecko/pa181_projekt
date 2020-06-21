package cz.pa181.project.dao.kultura;

import com.j256.ormlite.dao.Dao;
import cz.pa181.project.entity.kultura.KulturaPocetZariadeni;
import cz.pa181.project.enums.TypZariadeni;

import java.sql.SQLException;
import java.util.List;

/**
 * Class represents:
 * @author xholecko
 */
public interface KulturaPocetZariadeniDao extends Dao<KulturaPocetZariadeni, Long> {
    /**
     * @param rok rok (hodnoty od 2015 - 2018) hodnoty rovne ako zadany rok
     * @return zoradeny list casti Bratislavy od casti s najvacsim poctom zariadeni po cast ktora ma najmenej
     * @throws SQLException e
     */
    List<String[]> getPocetZariadeniByRokSorted(int rok) throws SQLException;

    /**
     * @param typZariadeni DIVADLO,GALERIA,MUZEUM,KINO,VOLNY_CAS_MLADEZ,VEDECKA_KNIZNICA,VEREJNA_KNIZNICA
     * @param rok rok (hodnoty od 2015 - 2018) hodnoty rovne ako zadany rok
     * @return zoradeny list casti bratislavy od casti ktora ma zariadeni daneho typu po cast ktora ma najmenej
     * @throws SQLException e
     */
    List<String[]> getPocetZariadeniByRokATypZariadeniaSorted(int rok, TypZariadeni typZariadeni) throws SQLException;
}
