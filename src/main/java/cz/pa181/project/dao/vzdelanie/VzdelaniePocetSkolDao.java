package cz.pa181.project.dao.vzdelanie;

import com.j256.ormlite.dao.Dao;
import cz.pa181.project.entity.vzdelanie.VzdelaniePocetSkol;

/**
 * Class represents:
 * @author xholecko
 */
public interface VzdelaniePocetSkolDao extends Dao<VzdelaniePocetSkol,Long> {

    //podobne ako internaty myslim ze je nam tento dataset zbytocny lebo viac vypovedne je pocet ziakov ako pocet skol
}
