package cz.pa181.project.entity.ekonomika;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import cz.pa181.project.dao.ekonomika.EkonomikaMieraNezamestnanostiDaoImpl;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

/**
 * Class represents: MIERA EVIDOVANEJ NEZAMESTNANOSTI (V %)
 * https://opendata.bratislava.sk/dataset/show/miera-evidovanej-nezamestnanosti-v
 * @author xholecko
 */
@Getter
@Setter
@DatabaseTable(tableName = "ekonomika_miera_nezamestnanosti", daoClass = EkonomikaMieraNezamestnanostiDaoImpl.class)
public class EkonomikaMieraNezamestnanosti {

    @DatabaseField(generatedId = true)
    private long id;

    @DatabaseField(canBeNull = false)
    private String okres;

    @DatabaseField(canBeNull = false)
    private String rok;

    @DatabaseField(canBeNull = false)
    private double miera;

    public EkonomikaMieraNezamestnanosti(String okres, String rok, double miera) {
        this.okres = okres;
        this.rok = rok;
        this.miera = miera;
    }

    public EkonomikaMieraNezamestnanosti() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EkonomikaMieraNezamestnanosti that = (EkonomikaMieraNezamestnanosti) o;
        return Double.compare(that.getMiera(), getMiera()) == 0 &&
                getOkres().equals(that.getOkres()) &&
                getRok().equals(that.getRok());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getOkres(), getRok(), getMiera());
    }

    @Override
    public String toString() {
        return "EkonomikaMieraNezamestnanosti{" +
                "id=" + id +
                ", okres='" + okres + '\'' +
                ", rok='" + rok + '\'' +
                ", miera='" + miera + '\'' +
                '}';
    }
}
