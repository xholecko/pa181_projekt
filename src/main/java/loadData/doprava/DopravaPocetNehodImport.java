package loadData.doprava;
import com.j256.ormlite.jdbc.JdbcPooledConnectionSource;
import dao.doprava.DopravaPocetNehodDaoImpl;
import entity.doprava.DopravaPocetNehod;

import java.io.*;
import java.net.URL;
import java.sql.SQLException;


/**
 * Class represents:
 * @author xholecko
 */
public class DopravaPocetNehodImport {
    private static final String URL = "https://opendata.bratislava.sk/dataset/download/pocet-dopravnych-nehod-v-cestnej-doprave/1";

    public void getDopravaPocetNehod(JdbcPooledConnectionSource connectionSource){
        try {
            URL url = new URL(URL);
            BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream(), "Windows-1250"));
            String line = br.readLine();
            String cvsSplitBy = ";";
            DopravaPocetNehodDaoImpl dao = new DopravaPocetNehodDaoImpl(connectionSource);
            while ((line = br.readLine()) != null && !line.startsWith(";")){
                String[] fields = line.split(cvsSplitBy);
                DopravaPocetNehod entity = new DopravaPocetNehod(fields[0],
                        fields[1].equals("") ? 0 : Integer.parseInt(fields[1].replaceAll("\\s+", "")),
                        fields[2].equals("") ? 0 : Integer.parseInt(fields[2].replaceAll("\\s+", "")));
                dao.createIfNotExists(entity);
            }
            br.close();
        } catch (IOException | SQLException e) {
            e.printStackTrace();
        }
    }
}
