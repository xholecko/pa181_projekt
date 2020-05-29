package loadData.ekonomika;

import com.j256.ormlite.jdbc.JdbcPooledConnectionSource;
import dao.ekonomika.EkonomikaIndexStartnutiaDaoImpl;
import entity.ekonomika.EkonomikaIndexStartnutia;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.sql.SQLException;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

/**
 * Class represents:
 * @author xholecko
 */
public class EkonomikaIndexStartnutiaImport {
    private static final String URL = "https://opendata.bratislava.sk/dataset/download/index-starnutia/1";

    public void getEkonomikaIndexStartnutia(JdbcPooledConnectionSource connectionSource){
        try {
            java.net.URL url = new URL(URL);
            BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream(), "Windows-1250"));
            String line = br.readLine();
            String cvsSplitBy = ";";
            EkonomikaIndexStartnutiaDaoImpl dao = new EkonomikaIndexStartnutiaDaoImpl(connectionSource);

            while ((line = br.readLine()) != null && !line.startsWith(";")){
                String[] fields = line.split(cvsSplitBy);
                NumberFormat format = NumberFormat.getInstance(Locale.FRANCE);
                Number number = format.parse(fields[3]);
                double val = number.doubleValue();
                EkonomikaIndexStartnutia entity = new EkonomikaIndexStartnutia(fields[0],fields[1],
                        fields[2].equals("") ? 0 : Integer.parseInt(fields[2].replaceAll("\\s+", "")), val);

                dao.createIfNotExists(entity);
            }
            br.close();
        } catch (IOException | SQLException | ParseException e) {
            e.printStackTrace();
        }
    }
}
