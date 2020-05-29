package entity.socialne;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import dao.obyvatelstvo.ObyvatelstvoVierovyznanieDaoImpl;
import dao.socialne.SocialneZariadeniaDaoImpl;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

/**
 * Class represents: POČET SOCIÁLNYCH ZARIADENÍ
 * https://opendata.bratislava.sk/dataset/show/pocet-socialnych-zariadenii
 * @author xholecko
 */
@Getter
@Setter
@DatabaseTable(tableName = "socialne_zariadenia", daoClass = SocialneZariadeniaDaoImpl.class)
public class SocialneZariadenia {

    @DatabaseField(generatedId = true)
    private long id;

    @DatabaseField(canBeNull = false)
    private String okres;

    @DatabaseField(canBeNull = false)
    private String rok;

    @DatabaseField(canBeNull = false)
    private String pocet;

    public SocialneZariadenia(String okres, String rok, String pocet) {
        this.okres = okres;
        this.rok = rok;
        this.pocet = pocet;
    }

    public SocialneZariadenia() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SocialneZariadenia that = (SocialneZariadenia) o;
        return getOkres().equals(that.getOkres()) &&
                getRok().equals(that.getRok()) &&
                getPocet().equals(that.getPocet());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getOkres(), getRok(), getPocet());
    }

    @Override
    public String toString() {
        return "SocialneZariadenia{" +
                "id=" + id +
                ", okres='" + okres + '\'' +
                ", rok='" + rok + '\'' +
                ", pocet='" + pocet + '\'' +
                '}';
    }
}
