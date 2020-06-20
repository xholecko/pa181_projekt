package cz.pa181.project.entity.obyvatelstvo;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import cz.pa181.project.dao.obyvatelstvo.ObyvatelstvoVierovyznanieDaoImpl;
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
    private int rimskokatolici;

    @DatabaseField(canBeNull = false)
    private int evanjelici;

    @DatabaseField(canBeNull = false)
    private int greckokatolici;

    @DatabaseField(canBeNull = false)
    private int zidia;

    @DatabaseField(canBeNull = false)
    private int ine;

    @DatabaseField(canBeNull = false)
    private int ateisti;

    @DatabaseField(canBeNull = false)
    private int spolu;

    public ObyvatelstvoVierovyznanie(String okres, String mestskaCast, int rimskokatolici, int evanjelici, int greckokatolici, int zidia, int ine, int ateisti, int spolu) {
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
        return getRimskokatolici() == that.getRimskokatolici() &&
                getEvanjelici() == that.getEvanjelici() &&
                getGreckokatolici() == that.getGreckokatolici() &&
                getZidia() == that.getZidia() &&
                getIne() == that.getIne() &&
                getAteisti() == that.getAteisti() &&
                getSpolu() == that.getSpolu() &&
                getOkres().equals(that.getOkres()) &&
                getMestskaCast().equals(that.getMestskaCast());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getMestskaCast(), getRimskokatolici(), getEvanjelici(), getGreckokatolici(), getZidia(), getIne(), getAteisti(), getSpolu());
    }

    @Override
    public String toString() {
        return "ObyvatelstvoVierovyznanie{" +
                "id=" + id +
                ", okres='" + okres + '\'' +
                ", mestskaCast='" + mestskaCast + '\'' +
                ", rimskokatolici=" + rimskokatolici +
                ", evanjelici=" + evanjelici +
                ", greckokatolici=" + greckokatolici +
                ", zidia=" + zidia +
                ", ine=" + ine +
                ", ateisti=" + ateisti +
                ", spolu=" + spolu +
                '}';
    }
}
