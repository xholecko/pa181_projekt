package dao.vzdelanie;

import com.j256.ormlite.dao.Dao;
import entity.vzdelanie.VzdelaniePocetSkol;
import enums.TypSkoly;
import enums.TypZariadeni;

import java.sql.SQLException;
import java.util.List;

/**
 * Class represents:
 * @author xholecko
 */
public interface VzdelaniePocetSkolDao extends Dao<VzdelaniePocetSkol,Long> {

    //podobne ako internaty myslim ze je nam tento dataset zbytocny lebo viac vypovedne je pocet ziakov ako pocet skol
}
