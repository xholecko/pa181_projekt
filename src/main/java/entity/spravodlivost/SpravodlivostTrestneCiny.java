package entity.spravodlivost;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import dao.socialne.SocialneZariadeniaDaoImpl;
import dao.spravodlivost.SpravodlivostTrestneCinyDaoImpl;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

/**
 * Class represents: POČET ZISTENÝCH, OBJASNENÝCH A DODATOČNE OBJASNENÝCH TRESTNÝCH ČINOV
 * https://opendata.bratislava.sk/dataset/show/pocet-zistenych-objasnenych-a-dodatocne-objasnenych-trestnych-cinov
 * @author xholecko
 */
@Getter
@Setter
@DatabaseTable(tableName = "spravodlivost_trestne_ciny", daoClass = SpravodlivostTrestneCinyDaoImpl.class)
public class SpravodlivostTrestneCiny {

    @DatabaseField(generatedId = true)
    private long id;

    @DatabaseField(canBeNull = false)
    private String okres;

    @DatabaseField(canBeNull = false)
    private String rok;

    @DatabaseField(canBeNull = false)
    private String pocetDodatocneObjasnenych;

    @DatabaseField(canBeNull = false)
    private String pocetObjasnenych;

    @DatabaseField(canBeNull = false)
    private String pocetZistenych;

    public SpravodlivostTrestneCiny(String okres, String rok, String pocetDodatocneObjasnenych, String pocetObjasnenych, String pocetZistenych) {
        this.okres = okres;
        this.rok = rok;
        this.pocetDodatocneObjasnenych = pocetDodatocneObjasnenych;
        this.pocetObjasnenych = pocetObjasnenych;
        this.pocetZistenych = pocetZistenych;
    }

    public SpravodlivostTrestneCiny() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SpravodlivostTrestneCiny that = (SpravodlivostTrestneCiny) o;
        return getOkres().equals(that.getOkres()) &&
                getRok().equals(that.getRok()) &&
                getPocetDodatocneObjasnenych().equals(that.getPocetDodatocneObjasnenych()) &&
                getPocetObjasnenych().equals(that.getPocetObjasnenych()) &&
                getPocetZistenych().equals(that.getPocetZistenych());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getOkres(), getRok(), getPocetDodatocneObjasnenych(), getPocetObjasnenych(), getPocetZistenych());
    }

    @Override
    public String toString() {
        return "SpravodlivostTrestneCiny{" +
                "id=" + id +
                ", okres='" + okres + '\'' +
                ", rok='" + rok + '\'' +
                ", pocetDodatocneObjasnenych='" + pocetDodatocneObjasnenych + '\'' +
                ", pocetObjasnenych='" + pocetObjasnenych + '\'' +
                ", pocetZistenych='" + pocetZistenych + '\'' +
                '}';
    }
}
