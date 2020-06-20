package cz.pa181.project.entity.socialne;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import cz.pa181.project.dao.socialne.SocialneZariadeniaDaoImpl;
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
    private int rok;

    @DatabaseField(canBeNull = false)
    private int pocet;

    public SocialneZariadenia(String okres, int rok, int pocet) {
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
        return getRok() == that.getRok() &&
                getPocet() == that.getPocet() &&
                getOkres().equals(that.getOkres());
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
