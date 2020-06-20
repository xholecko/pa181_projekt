package cz.pa181.project.entity.zdravie;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import cz.pa181.project.dao.zdravie.ZdraviePocetLekarovDaoImpl;
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
    private int rok;

    @DatabaseField(canBeNull = false)
    private int lekarDospeli;

    @DatabaseField(canBeNull = false)
    private int lekarDeti;

    @DatabaseField(canBeNull = false)
    private int stomatolog;

    @DatabaseField(canBeNull = false)
    private int gynekolog;

    @DatabaseField(canBeNull = false)
    private int specialista;

    public ZdraviePocetLekarov(String okres, String mestskaCast, int rok, int lekarDospeli, int lekarDeti, int stomatolog, int gynekolog, int specialista) {
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
        return getRok() == that.getRok() &&
                getLekarDospeli() == that.getLekarDospeli() &&
                getLekarDeti() == that.getLekarDeti() &&
                getStomatolog() == that.getStomatolog() &&
                getGynekolog() == that.getGynekolog() &&
                getSpecialista() == that.getSpecialista() &&
                getOkres().equals(that.getOkres()) &&
                getMestskaCast().equals(that.getMestskaCast());
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
