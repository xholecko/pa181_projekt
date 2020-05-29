package entity.spravodlivost;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import dao.spravodlivost.SpravodlivostTrestneCinyDaoImpl;
import dao.spravodlivost.SpravodlivostTrestneCinyPodVplyvomDaoImpl;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

/**
 * Class represents: POČET TRESTNÝCH ČINOV A POČET STÍHANÝCH A VYŠETROVANÝCH OSÔB S VPLYVOM ALKOHOLU A DROG
 * https://opendata.bratislava.sk/dataset/show/pocet-trestnych-cinov-a-pocet-stihanych-a-vysetrovanych-osob-s-vplyvom-alkoholu-a-drog
 * @author xholecko
 */
@Getter
@Setter
@DatabaseTable(tableName = "spravodlivost_trestne_ciny_pod_vplyvom", daoClass = SpravodlivostTrestneCinyPodVplyvomDaoImpl.class)
public class SpravodlivostTrestneCinyPodVplyvom {

    @DatabaseField(generatedId = true)
    private long id;

    @DatabaseField(canBeNull = false)
    private String okres;

    @DatabaseField(canBeNull = false) // Rok je aj v inom formate ako int (01/2018 - 06/2018)
    private String rok;

    @DatabaseField(canBeNull = false)
    private int pocetTrestnychCinovAlkohol;

    @DatabaseField(canBeNull = false)
    private int pocetTrestnychCinovDrogy;

    @DatabaseField(canBeNull = false)
    private int pocetStihanychAlkohol;

    @DatabaseField(canBeNull = false)
    private int pocetStihanychDrogy;

    public SpravodlivostTrestneCinyPodVplyvom(String okres, String rok, int pocetTrestnychCinovAlkohol, int pocetTrestnychCinovDrogy, int pocetStihanychAlkohol, int pocetStihanychDrogy) {
        this.okres = okres;
        this.rok = rok;
        this.pocetTrestnychCinovAlkohol = pocetTrestnychCinovAlkohol;
        this.pocetTrestnychCinovDrogy = pocetTrestnychCinovDrogy;
        this.pocetStihanychAlkohol = pocetStihanychAlkohol;
        this.pocetStihanychDrogy = pocetStihanychDrogy;
    }

    public SpravodlivostTrestneCinyPodVplyvom() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SpravodlivostTrestneCinyPodVplyvom that = (SpravodlivostTrestneCinyPodVplyvom) o;
        return getPocetTrestnychCinovAlkohol() == that.getPocetTrestnychCinovAlkohol() &&
                getPocetTrestnychCinovDrogy() == that.getPocetTrestnychCinovDrogy() &&
                getPocetStihanychAlkohol() == that.getPocetStihanychAlkohol() &&
                getPocetStihanychDrogy() == that.getPocetStihanychDrogy() &&
                getOkres().equals(that.getOkres()) &&
                getRok().equals(that.getRok());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getOkres(), getRok(), getPocetTrestnychCinovAlkohol(), getPocetTrestnychCinovDrogy(), getPocetStihanychAlkohol(), getPocetStihanychDrogy());
    }

    @Override
    public String toString() {
        return "SpravodlivostTrestneCinyPodVplyvom{" +
                "id=" + id +
                ", okres='" + okres + '\'' +
                ", rok='" + rok + '\'' +
                ", pocetTrestnychCinovAlkohol='" + pocetTrestnychCinovAlkohol + '\'' +
                ", pocetTrestnychCinovDrogy='" + pocetTrestnychCinovDrogy + '\'' +
                ", pocetStihanychAlkohol='" + pocetStihanychAlkohol + '\'' +
                ", pocetStihanychDrogy='" + pocetStihanychDrogy + '\'' +
                '}';
    }
}
