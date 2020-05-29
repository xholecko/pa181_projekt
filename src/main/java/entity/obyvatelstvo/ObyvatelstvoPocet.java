package entity.obyvatelstvo;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import dao.obyvatelstvo.ObyvatelstvoPocetDaoImpl;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

/**
 * Class represents: POČET OBYVATEĽOV
 * https://opendata.bratislava.sk/dataset/show/obyvpocet
 * @author xholecko
 */
@Getter
@Setter
@DatabaseTable(tableName = "obyvatelstvo_pocet", daoClass = ObyvatelstvoPocetDaoImpl.class)
public class ObyvatelstvoPocet {

    @DatabaseField(generatedId = true)
    private long id;

    @DatabaseField(canBeNull = false)
    private String okres;

    @DatabaseField(canBeNull = false)
    private String mestskaCast;

    @DatabaseField(canBeNull = false)
    private String rok;

    @DatabaseField(canBeNull = false)
    private String pocetObyvatelov;

    public ObyvatelstvoPocet(String okres, String mestskaCast, String rok, String pocetObyvatelov) {
        this.okres = okres;
        this.mestskaCast = mestskaCast;
        this.rok = rok;
        this.pocetObyvatelov = pocetObyvatelov;
    }

    public ObyvatelstvoPocet() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ObyvatelstvoPocet that = (ObyvatelstvoPocet) o;
        return getOkres().equals(that.getOkres()) &&
                getMestskaCast().equals(that.getMestskaCast()) &&
                getRok().equals(that.getRok()) &&
                getPocetObyvatelov().equals(that.getPocetObyvatelov());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getOkres(), getMestskaCast(), getRok(), getPocetObyvatelov());
    }

    @Override
    public String toString() {
        return "ObyvatelstvoPocet{" +
                "id=" + id +
                ", okres='" + okres + '\'' +
                ", mestskaCast='" + mestskaCast + '\'' +
                ", rok='" + rok + '\'' +
                ", pocetObyvatelov='" + pocetObyvatelov + '\'' +
                '}';
    }
}
