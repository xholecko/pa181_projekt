package entity.ekonomika;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import dao.ekonomika.EkonomikaMieraNezamestnanostiDaoImpl;
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
    private String miera;

    public EkonomikaMieraNezamestnanosti(String okres, String rok, String miera) {
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
        return getOkres().equals(that.getOkres()) &&
                getRok().equals(that.getRok()) &&
                getMiera().equals(that.getMiera());
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
