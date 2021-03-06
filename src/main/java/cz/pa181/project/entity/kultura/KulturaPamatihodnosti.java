package cz.pa181.project.entity.kultura;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import cz.pa181.project.dao.kultura.KulturaPamatihodnostiDaoImpl;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

/**
 * Class represents: SPOJENIE DATASETOV CELOMESTSKÝ ZOZNAM PAMÄTIHODNOSTÍ MESTA BRATISLAVY
 * https://opendata.bratislava.sk/dataset/show/celomestsky-zoznam-pamatihodnosti-mesta-bratislavy
 * @author xholecko
 */
@Getter
@Setter
@DatabaseTable(tableName = "kultura_pamatihodnosti", daoClass = KulturaPamatihodnostiDaoImpl.class)
public class KulturaPamatihodnosti {

    @DatabaseField(generatedId = true)
    private long id;

    @DatabaseField(canBeNull = false)
    private String okres;

    @DatabaseField(canBeNull = false)
    private String mestskaCast;

    @DatabaseField(canBeNull = false)
    private String nazovPamatihodnosti;

    @DatabaseField(canBeNull = false)
    private String typ;

    public KulturaPamatihodnosti(String okres, String mestskaCast, String nazovPamatihodnosti, String typ) {
        this.okres = okres;
        this.mestskaCast = mestskaCast;
        this.nazovPamatihodnosti = nazovPamatihodnosti;
        this.typ = typ;
    }

    public KulturaPamatihodnosti() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        KulturaPamatihodnosti that = (KulturaPamatihodnosti) o;
        return getId() == that.getId() &&
                getOkres().equals(that.getOkres()) &&
                getMestskaCast().equals(that.getMestskaCast()) &&
                getNazovPamatihodnosti().equals(that.getNazovPamatihodnosti()) &&
                getTyp().equals(that.getTyp());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getOkres(), getMestskaCast(), getNazovPamatihodnosti(), getTyp());
    }

    @Override
    public String toString() {
        return "KulturaPamatihodnosti{" +
                "id=" + id +
                ", okres='" + okres + '\'' +
                ", mestskaCast='" + mestskaCast + '\'' +
                ", nazovPamatihodnosti='" + nazovPamatihodnosti + '\'' +
                ", typ='" + typ + '\'' +
                '}';
    }
}
