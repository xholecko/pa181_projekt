package entity.kultura;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import dao.kultura.KulturaPocetZariadeniDaoImpl;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;
/**
 * Class represents: SPOJENIE DATASETOV POČET ZARIADENÍ: Divadlo, Galerie, Muzea, Kina, Vedecke kniznice, Verejne kniznice, Volny cas deti a mladez (kniznice su bez poctu kniznych jednotiek)
 * https://opendata.bratislava.sk/dataset/show/pocet-divadiel
 * https://opendata.bratislava.sk/dataset/show/pocet-galerii
 * https://opendata.bratislava.sk/dataset/show/pocet-muzei
 * https://opendata.bratislava.sk/dataset/show/pocet-premietacich-sal
 * https://opendata.bratislava.sk/dataset/show/pocet-vedeckych-kniznic-a-pocet-kniznicnych-jednotiek
 * https://opendata.bratislava.sk/dataset/show/pocet-verejnych-kniznic-a-pocet-kniznicnych-jednotiek
 * https://opendata.bratislava.sk/dataset/show/pocet-zariadeni-na-volny-cas-a-zaujmovu-cinnost-pre-deti-a-mladez
 * @author xholecko
 */
@Getter
@Setter
@DatabaseTable(tableName = "kultura_pocet_zariadeni", daoClass = KulturaPocetZariadeniDaoImpl.class)
public class KulturaPocetZariadeni {

    @DatabaseField(generatedId = true)
    private long id;

    @DatabaseField(canBeNull = false)
    private String okres;

    @DatabaseField(canBeNull = false)
    private String mestskaCast;

    @DatabaseField(canBeNull = false)
    private String rok;

    @DatabaseField(canBeNull = false)
    private String pocetZariadeni;

    @DatabaseField(canBeNull = false)
    private String typ;

    public KulturaPocetZariadeni(String okres, String mestskaCast, String rok, String pocetZariadeni, String typ) {
        this.okres = okres;
        this.mestskaCast = mestskaCast;
        this.rok = rok;
        this.pocetZariadeni = pocetZariadeni;
        this.typ = typ;
    }

    public KulturaPocetZariadeni() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        KulturaPocetZariadeni that = (KulturaPocetZariadeni) o;
        return getOkres().equals(that.getOkres()) &&
                getMestskaCast().equals(that.getMestskaCast()) &&
                getRok().equals(that.getRok()) &&
                getPocetZariadeni().equals(that.getPocetZariadeni()) &&
                getTyp().equals(that.getTyp());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getOkres(), getMestskaCast(), getRok(), getPocetZariadeni(), getTyp());
    }

    @Override
    public String toString() {
        return "KulturaPocetZariadeni{" +
                "id=" + id +
                ", okres='" + okres + '\'' +
                ", mestskaCast='" + mestskaCast + '\'' +
                ", rok='" + rok + '\'' +
                ", pocetZariadeni='" + pocetZariadeni + '\'' +
                ", typ='" + typ + '\'' +
                '}';
    }
}
