package entity.ekonomika;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import dao.ekonomika.EkonomikaCenyBytovDaoImpl;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

/**
 * Class represents: Sklada sa z dvoch grafov - ceny bytov podla typu a ceny bytov podla poctu izieb - spojenie do jednej tabulky
 * http://www.trh.sk/statistiky-cien-nehnutelnosti/bratislava-i-stare-mesto.html
 * @author xholecko
 */

@Getter
@Setter
@DatabaseTable(tableName = "ekonomika_ceny_bytov", daoClass = EkonomikaCenyBytovDaoImpl.class)
public class EkonomikaCenyBytov {
    @DatabaseField(generatedId = true)
    private long id;

    @DatabaseField(canBeNull = false)
    private String okres;

    @DatabaseField(canBeNull = false)
    private int rok;

    @DatabaseField(canBeNull = false)
    private int tyzden;

    @DatabaseField(canBeNull = false)
    private int bytm2;

    @DatabaseField(canBeNull = false)
    private int domm2;

    @DatabaseField(canBeNull = false)
    private int novostavbam2;

    @DatabaseField(canBeNull = false)
    private int pozemokm2;

    @DatabaseField(canBeNull = false)
    private int garsonkam2;

    @DatabaseField(canBeNull = false)
    private int jednoIzbovym2;

    @DatabaseField(canBeNull = false)
    private int dvojIzbovym2;

    @DatabaseField(canBeNull = false)
    private int trojIzbovym2;

    @DatabaseField(canBeNull = false)
    private int stvorAViacIzbovym2;

    public EkonomikaCenyBytov(String okres, int rok, int tyzden, int bytm2, int domm2, int novostavbam2, int pozemokm2, int garsonkam2, int jednoIzbovym2, int dvojIzbovym2, int trojIzbovym2, int stvorAViacIzbovym2) {
        this.okres = okres;
        this.rok = rok;
        this.tyzden = tyzden;
        this.bytm2 = bytm2;
        this.domm2 = domm2;
        this.novostavbam2 = novostavbam2;
        this.pozemokm2 = pozemokm2;
        this.garsonkam2 = garsonkam2;
        this.jednoIzbovym2 = jednoIzbovym2;
        this.dvojIzbovym2 = dvojIzbovym2;
        this.trojIzbovym2 = trojIzbovym2;
        this.stvorAViacIzbovym2 = stvorAViacIzbovym2;
    }

    public EkonomikaCenyBytov() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EkonomikaCenyBytov that = (EkonomikaCenyBytov) o;
        return getRok() == that.getRok() &&
                getTyzden() == that.getTyzden() &&
                getBytm2() == that.getBytm2() &&
                getDomm2() == that.getDomm2() &&
                getNovostavbam2() == that.getNovostavbam2() &&
                getPozemokm2() == that.getPozemokm2() &&
                getGarsonkam2() == that.getGarsonkam2() &&
                getJednoIzbovym2() == that.getJednoIzbovym2() &&
                getDvojIzbovym2() == that.getDvojIzbovym2() &&
                getTrojIzbovym2() == that.getTrojIzbovym2() &&
                getStvorAViacIzbovym2() == that.getStvorAViacIzbovym2() &&
                Objects.equals(getOkres(), that.getOkres());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getOkres(), getRok(), getTyzden(), getBytm2(), getDomm2(), getNovostavbam2(), getPozemokm2(), getGarsonkam2(), getJednoIzbovym2(), getDvojIzbovym2(), getTrojIzbovym2(), getStvorAViacIzbovym2());
    }

    @Override
    public String toString() {
        return "EkonomikaCenyBytov{" +
                "id=" + id +
                ", okres='" + okres + '\'' +
                ", rok=" + rok +
                ", tyzden=" + tyzden +
                ", bytm2=" + bytm2 +
                ", domm2=" + domm2 +
                ", novostavbam2=" + novostavbam2 +
                ", pozemokm2=" + pozemokm2 +
                ", garsonkam2=" + garsonkam2 +
                ", jednoIzbovym2=" + jednoIzbovym2 +
                ", dvojIzbovym2=" + dvojIzbovym2 +
                ", trojIzbovym2=" + trojIzbovym2 +
                ", stvorAViacIzbovym2=" + stvorAViacIzbovym2 +
                '}';
    }
}
