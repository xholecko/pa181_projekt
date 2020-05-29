package entity.zdravie;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import dao.zdravie.ZdraviePocetLekarovDaoImpl;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;
/**
 * Class represents: PRAKTICKÍ LEKÁRI A ŠPECIALISTI
 * https://opendata.bratislava.sk/dataset/show/prakticki-lekari-a-specialisti
 * @author xholecko
 */
@Getter
@Setter
@DatabaseTable(tableName = "zdravie_pocet_lekarov", daoClass = ZdraviePocetLekarovDaoImpl.class)
public class ZdraviePocetLekarov {

    @DatabaseField(generatedId = true)
    private long id;

    @DatabaseField(canBeNull = false)
    private String okres;

    @DatabaseField(canBeNull = false)
    private String mestskaCast;

    @DatabaseField(canBeNull = false)
    private String rok;

    @DatabaseField(canBeNull = false)
    private String lekarDospeli;

    @DatabaseField(canBeNull = false)
    private String lekarDeti;

    @DatabaseField(canBeNull = false)
    private String stomatolog;

    @DatabaseField(canBeNull = false)
    private String gynekolog;

    @DatabaseField(canBeNull = false)
    private String specialista;

    public ZdraviePocetLekarov(String okres, String mestskaCast, String rok, String lekarDospeli, String lekarDeti, String stomatolog, String gynekolog, String specialista) {
        this.okres = okres;
        this.mestskaCast = mestskaCast;
        this.rok = rok;
        this.lekarDospeli = lekarDospeli;
        this.lekarDeti = lekarDeti;
        this.stomatolog = stomatolog;
        this.gynekolog = gynekolog;
        this.specialista = specialista;
    }

    public ZdraviePocetLekarov() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ZdraviePocetLekarov that = (ZdraviePocetLekarov) o;
        return getOkres().equals(that.getOkres()) &&
                getMestskaCast().equals(that.getMestskaCast()) &&
                getRok().equals(that.getRok()) &&
                getLekarDospeli().equals(that.getLekarDospeli()) &&
                getLekarDeti().equals(that.getLekarDeti()) &&
                getStomatolog().equals(that.getStomatolog()) &&
                getGynekolog().equals(that.getGynekolog()) &&
                getSpecialista().equals(that.getSpecialista());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getOkres(), getMestskaCast(), getRok(), getLekarDospeli(), getLekarDeti(), getStomatolog(), getGynekolog(), getSpecialista());
    }

    @Override
    public String toString() {
        return "ZdraviePocetLekarov{" +
                "id=" + id +
                ", okres='" + okres + '\'' +
                ", mestskaCast='" + mestskaCast + '\'' +
                ", rok='" + rok + '\'' +
                ", lekarDospeli='" + lekarDospeli + '\'' +
                ", lekarDeti='" + lekarDeti + '\'' +
                ", stomatolog='" + stomatolog + '\'' +
                ", gynekolog='" + gynekolog + '\'' +
                ", specialista='" + specialista + '\'' +
                '}';
    }
}
