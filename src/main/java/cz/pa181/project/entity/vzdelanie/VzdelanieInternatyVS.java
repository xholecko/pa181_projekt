package cz.pa181.project.entity.vzdelanie;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import cz.pa181.project.dao.vzdelanie.VzdelanieInternatyVSDaoImpl;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

/**
 * Class represents: POČET VYSOKOŠKOLSKÝCH INTERNÁTOV A POČET LÔŽOK
 * https://opendata.bratislava.sk/dataset/show/pocet-vysokoskolskych-internatov-a-pocet-lozok
 * @author xholecko
 */
@Getter
@Setter
@DatabaseTable(tableName = "vzdelanie_internaty_VS", daoClass = VzdelanieInternatyVSDaoImpl.class)
public class VzdelanieInternatyVS {

    @DatabaseField(generatedId = true)
    private long id;

    @DatabaseField(canBeNull = false)
    private String okres;

    @DatabaseField(canBeNull = false)
    private String mestskaCast;

    @DatabaseField(canBeNull = false)
    private int rok;

    @DatabaseField(canBeNull = false)
    private int pocetInternatov;

    @DatabaseField(canBeNull = false)
    private int pocetLozok;

    public VzdelanieInternatyVS(String okres, String mestskaCast, int rok, int pocetInternatov, int pocetLozok) {
        this.okres = okres;
        this.mestskaCast = mestskaCast;
        this.rok = rok;
        this.pocetInternatov = pocetInternatov;
        this.pocetLozok = pocetLozok;
    }

    public VzdelanieInternatyVS() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VzdelanieInternatyVS that = (VzdelanieInternatyVS) o;
        return getRok() == that.getRok() &&
                getPocetInternatov() == that.getPocetInternatov() &&
                getPocetLozok() == that.getPocetLozok() &&
                getOkres().equals(that.getOkres()) &&
                getMestskaCast().equals(that.getMestskaCast());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getOkres(), getMestskaCast(), getRok(), getPocetInternatov(), getPocetLozok());
    }

    @Override
    public String toString() {
        return "VzdelanieInternatyVS{" +
                "id=" + id +
                ", okres='" + okres + '\'' +
                ", mestskaCast='" + mestskaCast + '\'' +
                ", rok='" + rok + '\'' +
                ", pocetInternatov='" + pocetInternatov + '\'' +
                ", pocetLozok='" + pocetLozok + '\'' +
                '}';
    }
}
