package entity.vzdelanie;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import dao.vzdelanie.VzdelaniePocetSkolDaoImpl;
import dao.vzdelanie.VzdelaniePocetZiakovDaoImpl;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;
/**
 * Class represents: SPOJENIE DATASETOV POČET ZIAKOV: ZAKLADNA_SKOLA,GYMNAZIUM,JAZYKOVA_SKOLA,STREDNA_ODBORNA_SKOLA
 * https://opendata.bratislava.sk/dataset/show/pocet-zakladnych-skol-a-pocet-ziakov-zakladnych-skol---rocnik
 * https://opendata.bratislava.sk/dataset/show/pocet-gymnazii-a-pocet-ziakov-gymnazii
 * https://opendata.bratislava.sk/dataset/show/pocet-strednych-odbornych-skol-a-pocet-ziakov-strednych-odbornych-skol
 * https://opendata.bratislava.sk/dataset/show/pocet-sukromnych-jazykovych-skol-a-pocet-ziakov-v-sukromnych-jazykovych-skolach
 * @author xholecko
 */
@Getter
@Setter
@DatabaseTable(tableName = "vzdelanie_pocet_ziakov", daoClass = VzdelaniePocetZiakovDaoImpl.class)
public class VzdelaniePocetZiakov {

    @DatabaseField(generatedId = true)
    private long id;

    @DatabaseField(canBeNull = false)
    private String okres;

    @DatabaseField(canBeNull = false)
    private String mestskaCast;

    @DatabaseField(canBeNull = false)
    private String rok;

    @DatabaseField(canBeNull = false)
    private String pocetZiakov;

    @DatabaseField(canBeNull = false)
    private String typ;

    public VzdelaniePocetZiakov(String okres, String mestskaCast, String rok, String pocetZiakov, String typ) {
        this.okres = okres;
        this.mestskaCast = mestskaCast;
        this.rok = rok;
        this.pocetZiakov = pocetZiakov;
        this.typ = typ;
    }

    public VzdelaniePocetZiakov() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VzdelaniePocetZiakov that = (VzdelaniePocetZiakov) o;
        return getOkres().equals(that.getOkres()) &&
                getMestskaCast().equals(that.getMestskaCast()) &&
                getRok().equals(that.getRok()) &&
                getPocetZiakov().equals(that.getPocetZiakov()) &&
                getTyp().equals(that.getTyp());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getOkres(), getMestskaCast(), getRok(), getPocetZiakov(), getTyp());
    }

    @Override
    public String toString() {
        return "VzdelaniePocetZiakov{" +
                "id=" + id +
                ", okres='" + okres + '\'' +
                ", mestskaCast='" + mestskaCast + '\'' +
                ", rok='" + rok + '\'' +
                ", pocetZiakov='" + pocetZiakov + '\'' +
                ", typ='" + typ + '\'' +
                '}';
    }
}
