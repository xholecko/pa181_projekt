package dao.doprava;

import com.j256.ormlite.dao.Dao;
import entity.doprava.DopravaPocetNehod;

import java.sql.SQLException;
import java.util.List;
/**
 * Class represents:
 * @author xholecko
 */
public interface DopravaPocetNehodDao extends Dao<DopravaPocetNehod, Long> {

    List<DopravaPocetNehod> findByOkres(String okres) throws SQLException;

    List<DopravaPocetNehod> findByRok(int rok) throws SQLException;

    List<DopravaPocetNehod> findByRokVacsiRovny(int rok) throws SQLException;

}
