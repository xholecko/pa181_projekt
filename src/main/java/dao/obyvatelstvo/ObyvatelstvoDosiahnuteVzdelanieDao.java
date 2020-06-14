package dao.obyvatelstvo;

import com.j256.ormlite.dao.Dao;
import entity.obyvatelstvo.ObyvatelstvoDosiahnuteVzdelanie;

import java.sql.SQLException;
import java.util.List;

/**
 * Class represents:
 * @author xholecko
 */
public interface ObyvatelstvoDosiahnuteVzdelanieDao  extends Dao<ObyvatelstvoDosiahnuteVzdelanie, Long> {

    /**
     * !!! neberie do uvahy pocet obyvatelov celkovo takze moze byt zavadzajuce !!!
     *
     * @return zoradeny list casti bratislavy od casti v ktorej je najviac obyvatelov s VS po cast kde je najmenej
     * @throws SQLException e
     */
    List<String[]> getDosiahnuteVzdelanieSpoluByRokSorted() throws SQLException;
}
