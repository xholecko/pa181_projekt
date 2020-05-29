package entity.obyvatelstvo;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import dao.obyvatelstvo.ObyvatelstvoVierovyznanieDaoImpl;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

/**
 * Class represents: POČET OBYVATEĽOV PODĽA NÁBOŽENSKÉHO VYZNANIA V ZÁKLADNÝCH SÍDELNÝCH JEDNOTKÁCH - ANONYMIZOVANÉ
 * DataSet upraveny zmenseny pocet fieldov
 * https://opendata.bratislava.sk/dataset/show/pocet-obyvatelov-podla-nabozenskeho-vyznania-v-zakladnych-sidelnych-jednotkach-anonymizovane
 * @author xholecko
 */
@Getter
@Setter
@DatabaseTable(tableName = "obyvatelstvo_vierovyznanie", daoClass = ObyvatelstvoVierovyznanieDaoImpl.class)
public class ObyvatelstvoVierovyznanie {

    @DatabaseField(generatedId = true)
    private long id;

    @DatabaseField(canBeNull = false)
    private String okres;

    @DatabaseField(canBeNull = false)
    private String mestskaCast;

    @DatabaseField(canBeNull = false)
    private String rimskokatolici;

    @DatabaseField(canBeNull = false)
    private String evanjelici;

    @DatabaseField(canBeNull = false)
    private String greckokatolici;

    @DatabaseField(canBeNull = false)
    private String zidia;

    @DatabaseField(canBeNull = false)
    private String ine;

    @DatabaseField(canBeNull = false)
    private String ateisti;

    @DatabaseField(canBeNull = false)
    private String spolu;

    public ObyvatelstvoVierovyznanie(String okres, String mestskaCast, String rimskokatolici, String evanjelici, String greckokatolici, String zidia, String ine, String ateisti, String spolu) {
        this.okres = okres;
        this.mestskaCast = mestskaCast;
        this.rimskokatolici = rimskokatolici;
        this.evanjelici = evanjelici;
        this.greckokatolici = greckokatolici;
        this.zidia = zidia;
        this.ine = ine;
        this.ateisti = ateisti;
        this.spolu = spolu;
    }

    public ObyvatelstvoVierovyznanie() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ObyvatelstvoVierovyznanie that = (ObyvatelstvoVierovyznanie) o;
        return getOkres().equals(that.getOkres()) &&
                getMestskaCast().equals(that.getMestskaCast()) &&
                Objects.equals(getRimskokatolici(), that.getRimskokatolici()) &&
                Objects.equals(getEvanjelici(), that.getEvanjelici()) &&
                Objects.equals(getGreckokatolici(), that.getGreckokatolici()) &&
                Objects.equals(getZidia(), that.getZidia()) &&
                Objects.equals(getIne(), that.getIne()) &&
                Objects.equals(getAteisti(), that.getAteisti()) &&
                Objects.equals(getSpolu(), that.getSpolu());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getOkres(), getMestskaCast(), getRimskokatolici(), getEvanjelici(), getGreckokatolici(), getZidia(), getIne(), getAteisti(), getSpolu());
    }

    @Override
    public String toString() {
        return "ObyvatelstvoVierovyznanie{" +
                "id=" + id +
                ", okres='" + okres + '\'' +
                ", mestskaCast='" + mestskaCast + '\'' +
                ", rimskokatolici='" + rimskokatolici + '\'' +
                ", evanjelici='" + evanjelici + '\'' +
                ", greckokatolici='" + greckokatolici + '\'' +
                ", zidia='" + zidia + '\'' +
                ", ine='" + ine + '\'' +
                ", ateisti='" + ateisti + '\'' +
                ", spolu='" + spolu + '\'' +
                '}';
    }
}
