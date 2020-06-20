package cz.pa181.project.entity.obyvatelstvo;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import cz.pa181.project.dao.obyvatelstvo.ObyvatelstvoPocetDaoImpl;
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
    private int rok;

    @DatabaseField(canBeNull = false)
    private int pocetObyvatelov;

    public ObyvatelstvoPocet(String okres, String mestskaCast, int rok, int pocetObyvatelov) {
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
        return getRok() == that.getRok() &&
                getPocetObyvatelov() == that.getPocetObyvatelov() &&
                getOkres().equals(that.getOkres()) &&
                getMestskaCast().equals(that.getMestskaCast());
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
