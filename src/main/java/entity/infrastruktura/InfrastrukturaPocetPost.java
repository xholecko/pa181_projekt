package entity.infrastruktura;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import dao.infrastruktura.InfrastrukturaPocetPostDaoImpl;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

/**
 * Class represents: POČET PÔŠT
 * https://opendata.bratislava.sk/dataset/show/pocet-post
 * @author xholecko
 */
@Getter
@Setter
@DatabaseTable(tableName = "infrastruktura_pocet_post", daoClass = InfrastrukturaPocetPostDaoImpl.class)
public class InfrastrukturaPocetPost {

    @DatabaseField(generatedId = true)
    private long id;

    @DatabaseField(canBeNull = false)
    private String okres;

    @DatabaseField(canBeNull = false)
    private String mestskaCast;

    @DatabaseField(canBeNull = false)
    private String rok;

    @DatabaseField(canBeNull = false)
    private String pocetPost;

    public InfrastrukturaPocetPost(String okres, String mestskaCast, String rok, String pocetPost) {
        this.okres = okres;
        this.mestskaCast = mestskaCast;
        this.rok = rok;
        this.pocetPost = pocetPost;
    }

    public InfrastrukturaPocetPost() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InfrastrukturaPocetPost that = (InfrastrukturaPocetPost) o;
        return getOkres().equals(that.getOkres()) &&
                getMestskaCast().equals(that.getMestskaCast()) &&
                getRok().equals(that.getRok()) &&
                getPocetPost().equals(that.getPocetPost());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getOkres(), getMestskaCast(), getRok(), getPocetPost());
    }

    @Override
    public String toString() {
        return "InfrastrukturaPocetPost{" +
                "id=" + id +
                ", okres='" + okres + '\'' +
                ", mestskaCast='" + mestskaCast + '\'' +
                ", rok='" + rok + '\'' +
                ", pocetPost='" + pocetPost + '\'' +
                '}';
    }
}
