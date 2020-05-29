package entity.vzdelanie;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import dao.vzdelanie.VzdelanieInternatyVSDaoImpl;
import dao.vzdelanie.VzdelaniePocetSkolDaoImpl;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;
/**
 * Class represents: SPOJENIE DATASETOV POČET SKOL: ZAKLADNA_SKOLA,GYMNAZIUM,JAZYKOVA_SKOLA,STREDNA_ODBORNA_SKOLA
 * https://opendata.bratislava.sk/dataset/show/pocet-zakladnych-skol-a-pocet-ziakov-zakladnych-skol---rocnik
 * https://opendata.bratislava.sk/dataset/show/pocet-gymnazii-a-pocet-ziakov-gymnazii
 * https://opendata.bratislava.sk/dataset/show/pocet-strednych-odbornych-skol-a-pocet-ziakov-strednych-odbornych-skol
 * https://opendata.bratislava.sk/dataset/show/pocet-sukromnych-jazykovych-skol-a-pocet-ziakov-v-sukromnych-jazykovych-skolach
 * @author xholecko
 */
@Getter
@Setter
@DatabaseTable(tableName = "vzdelanie_pocet_skol", daoClass = VzdelaniePocetSkolDaoImpl.class)
public class VzdelaniePocetSkol {

    @DatabaseField(generatedId = true)
    private long id;

    @DatabaseField(canBeNull = false)
    private String okres;

    @DatabaseField(canBeNull = false)
    private String mestskaCast;

    @DatabaseField(canBeNull = false)
    private String rok;

    @DatabaseField(canBeNull = false)
    private String pocetSkol;

    @DatabaseField(canBeNull = false)
    private String typ;

    public VzdelaniePocetSkol(String okres, String mestskaCast, String rok, String pocet, String typ) {
        this.okres = okres;
        this.mestskaCast = mestskaCast;
        this.rok = rok;
        this.pocetSkol = pocet;
        this.typ = typ;
    }

    public VzdelaniePocetSkol() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VzdelaniePocetSkol that = (VzdelaniePocetSkol) o;
        return getOkres().equals(that.getOkres()) &&
                getMestskaCast().equals(that.getMestskaCast()) &&
                getRok().equals(that.getRok()) &&
                getPocetSkol().equals(that.getPocetSkol()) &&
                getTyp().equals(that.getTyp());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getOkres(), getMestskaCast(), getRok(), getPocetSkol(), getTyp());
    }

    @Override
    public String toString() {
        return "VzdelaniePocetSkol{" +
                "id=" + id +
                ", okres='" + okres + '\'' +
                ", mestskaCast='" + mestskaCast + '\'' +
                ", rok='" + rok + '\'' +
                ", pocetSkol='" + pocetSkol + '\'' +
                ", typ='" + typ + '\'' +
                '}';
    }
}
