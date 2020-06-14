package dao.obyvatelstvo;

import com.j256.ormlite.dao.Dao;
import entity.obyvatelstvo.ObyvatelstvoVierovyznanie;

import java.sql.SQLException;
import java.util.List;

/**
 * Class represents:
 * @author xholecko
 */
public interface ObyvatelstvoVierovyznanieDao extends Dao<ObyvatelstvoVierovyznanie,Long> {

    /**
     * Tiez trochu skreslene pocita iba s ludmi ktori su zaratani celkovo a ateistmi v tomto datasete cisla preto vychadzaju o dost vyssie ako myslim ze to je v skutocnosti no myslim ze s tym mozme aj napriek tomu pracovat
     *
     * @return zoradeny list casti bratislavy podla poctu veriacich, od casti kde je najviac veriacich po cast kde je najmenej veriacich
     * @throws SQLException e
     */
    List<String[]> getVierovyznanieByRokSorted() throws SQLException;
}
