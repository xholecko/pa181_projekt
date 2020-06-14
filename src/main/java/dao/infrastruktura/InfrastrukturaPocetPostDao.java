package dao.infrastruktura;

import com.j256.ormlite.dao.Dao;
import entity.infrastruktura.InfrastrukturaPocetPost;

import java.sql.SQLException;
import java.util.List;

/**
 * Class represents:
 * @author xholecko
 */
public interface InfrastrukturaPocetPostDao extends Dao<InfrastrukturaPocetPost, Long> {

    /**
     *
     * @param rok rok (hodnoty od 1996 - 2018) hodnoty rovne ako zadany rok
     * @return zoradeny list casti bratislavy od casti ktora ma najviac post po cast ktora ma najemnej post
     * @throws SQLException e
     */
    List<String[]> getPocetPostByRokSorted(int rok) throws SQLException;
}
