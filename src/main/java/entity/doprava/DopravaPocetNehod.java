package entity.doprava;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import dao.doprava.DopravaPocetNehodDaoImpl;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

/**
 * Class represents: POČET DOPRAVNÝCH NEHÔD V CESTNEJ DOPRAVE
 * https://opendata.bratislava.sk/dataset/show/pocet-dopravnych-nehod-v-cestnej-doprave
 * @author xholecko
 */
@Getter
@Setter
@DatabaseTable(tableName = "doprava_pocet_nehod", daoClass = DopravaPocetNehodDaoImpl.class)
public class DopravaPocetNehod {
    @DatabaseField(generatedId = true)
    private long id;

    @DatabaseField(canBeNull = false)
    private String okres;

    @DatabaseField(canBeNull = false)
    private int rok;

    @DatabaseField(canBeNull = false)
    private int pocetNehod;

    public DopravaPocetNehod(String okres, int rok, int pocetNehod) {
        this.okres = okres;
        this.rok = rok;
        this.pocetNehod = pocetNehod;
    }

    public DopravaPocetNehod() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DopravaPocetNehod that = (DopravaPocetNehod) o;
        return getId() == that.getId() &&
                getRok() == that.getRok() &&
                getPocetNehod() == that.getPocetNehod() &&
                getOkres().equals(that.getOkres());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getOkres(), getRok(), getPocetNehod());
    }

    @Override
    public String toString() {
        return "DopravaPocetNehod{" +
                "id=" + id +
                ", okres='" + okres + '\'' +
                ", rok='" + rok + '\'' +
                ", pocetNehod='" + pocetNehod + '\'' +
                '}';
    }
}
