package entity.obyvatelstvo;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import dao.obyvatelstvo.ObyvatelstvoPrirastokDaoImpl;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

/**
 * Class represents: CELKOVÝ PRÍRASTOK/ÚBYTOK OBYVATEĽSTVA
 * https://opendata.bratislava.sk/dataset/show/celkovy-prirastok-ubytok-obyvatelstva
 * @author xholecko
 */
@Getter
@Setter
@DatabaseTable(tableName = "obyvatelstvo_prirastok", daoClass = ObyvatelstvoPrirastokDaoImpl.class)
public class ObyvatelstvoPrirastok {

    @DatabaseField(generatedId = true)
    private long id;

    @DatabaseField(canBeNull = false)
    private String okres;

    @DatabaseField(canBeNull = false)
    private String mestskaCast;

    @DatabaseField(canBeNull = false)
    private String rok;

    @DatabaseField(canBeNull = false)
    private String mesiac;

    @DatabaseField(canBeNull = false)
    private String prirastok;

    public ObyvatelstvoPrirastok(String okres, String mestskaCast, String rok, String mesiac, String prirastok) {
        this.okres = okres;
        this.mestskaCast = mestskaCast;
        this.rok = rok;
        this.mesiac = mesiac;
        this.prirastok = prirastok;
    }

    public ObyvatelstvoPrirastok() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ObyvatelstvoPrirastok that = (ObyvatelstvoPrirastok) o;
        return getOkres().equals(that.getOkres()) &&
                getMestskaCast().equals(that.getMestskaCast()) &&
                getRok().equals(that.getRok()) &&
                getMesiac().equals(that.getMesiac()) &&
                getPrirastok().equals(that.getPrirastok());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getOkres(), getMestskaCast(), getRok(), getMesiac(), getPrirastok());
    }

    @Override
    public String toString() {
        return "ObyvatelstvoPrirastok{" +
                "id=" + id +
                ", okres='" + okres + '\'' +
                ", mestskaCast='" + mestskaCast + '\'' +
                ", rok='" + rok + '\'' +
                ", mesiac='" + mesiac + '\'' +
                ", prirastok='" + prirastok + '\'' +
                '}';
    }
}
