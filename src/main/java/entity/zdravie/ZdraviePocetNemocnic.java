package entity.zdravie;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import dao.zdravie.ZdraviePocetNemocnicDaoImpl;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;
/**
 * Class represents: POČET NEMOCNIC
 * https://opendata.bratislava.sk/dataset/show/pocet-poliklinik-a-nemocnic
 * @author xholecko
 */
@Getter
@Setter
@DatabaseTable(tableName = "zdravie_pocet_nemocnic", daoClass = ZdraviePocetNemocnicDaoImpl.class)
public class ZdraviePocetNemocnic {

    @DatabaseField(generatedId = true)
    private long id;

    @DatabaseField(canBeNull = false)
    private String okres;

    @DatabaseField(canBeNull = false)
    private String mestskaCast;

    @DatabaseField(canBeNull = false)
    private int rok;

    @DatabaseField(canBeNull = false)
    private int pocetPoliklinik;

    public ZdraviePocetNemocnic(String okres, String mestskaCast, int rok, int pocetPoliklinik) {
        this.okres = okres;
        this.mestskaCast = mestskaCast;
        this.rok = rok;
        this.pocetPoliklinik = pocetPoliklinik;
    }

    public ZdraviePocetNemocnic() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ZdraviePocetNemocnic that = (ZdraviePocetNemocnic) o;
        return getRok() == that.getRok() &&
                getPocetPoliklinik() == that.getPocetPoliklinik() &&
                getOkres().equals(that.getOkres()) &&
                getMestskaCast().equals(that.getMestskaCast());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getOkres(), getMestskaCast(), getRok(), getPocetPoliklinik());
    }

    @Override
    public String toString() {
        return "ZdraviePocetNemocnic{" +
                "id=" + id +
                ", okres='" + okres + '\'' +
                ", mestskaCast='" + mestskaCast + '\'' +
                ", rok='" + rok + '\'' +
                ", pocetPoliklinik='" + pocetPoliklinik + '\'' +
                '}';
    }
}
