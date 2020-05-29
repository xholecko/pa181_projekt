package entity.ekonomika;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import dao.doprava.DopravaPocetNehodDaoImpl;
import dao.ekonomika.EkonomikaIndexStartnutiaDaoImpl;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

/**
 * Class represents: INDEX STARNUTIA
 * https://opendata.bratislava.sk/dataset/show/index-starnutia
 * @author xholecko
 */
@Getter
@Setter
@DatabaseTable(tableName = "ekonomika_index_starnutia", daoClass = EkonomikaIndexStartnutiaDaoImpl.class)
public class EkonomikaIndexStartnutia {

    @DatabaseField(generatedId = true)
    private long id;

    @DatabaseField(canBeNull = false)
    private String okres;

    @DatabaseField(canBeNull = false)
    private String mestskaCast;

    @DatabaseField(canBeNull = false)
    private int rok;

    @DatabaseField(canBeNull = false)
    private double indexStarnutia;

    public EkonomikaIndexStartnutia(String okres, String mestskaCast, int rok, double indexStarnutia) {
        this.okres = okres;
        this.mestskaCast = mestskaCast;
        this.rok = rok;
        this.indexStarnutia = indexStarnutia;
    }

    public EkonomikaIndexStartnutia() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EkonomikaIndexStartnutia that = (EkonomikaIndexStartnutia) o;
        return getRok() == that.getRok() &&
                Double.compare(that.getIndexStarnutia(), getIndexStarnutia()) == 0 &&
                getOkres().equals(that.getOkres()) &&
                getMestskaCast().equals(that.getMestskaCast());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getOkres(), getMestskaCast(), getRok(), getIndexStarnutia());
    }

    @Override
    public String toString() {
        return "EkonomikaIndexStartnutia{" +
                "id=" + id +
                ", okres='" + okres + '\'' +
                ", mestskaCast='" + mestskaCast + '\'' +
                ", rok='" + rok + '\'' +
                ", indexStarnutia='" + indexStarnutia + '\'' +
                '}';
    }
}
