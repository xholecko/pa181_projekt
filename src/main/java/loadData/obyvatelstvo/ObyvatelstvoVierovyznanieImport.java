package loadData.obyvatelstvo;

import com.j256.ormlite.jdbc.JdbcPooledConnectionSource;
import dao.obyvatelstvo.ObyvatelstvoVierovyznanieDaoImpl;
import entity.obyvatelstvo.ObyvatelstvoVierovyznanie;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.sql.SQLException;

/**
 * Class represents:
 * @author xholecko
 */
public class ObyvatelstvoVierovyznanieImport {
    private static final String URL = "https://opendata.bratislava.sk/dataset/download/pocet-obyvatelov-podla-nabozenskeho-vyznania-v-zakladnych-sidelnych-jednotkach-anonymizovane/1";

    public void getObyvatelstvoVierovyznanie(JdbcPooledConnectionSource connectionSource){
        try {
            java.net.URL url = new URL(URL);
            BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream(), "Windows-1250"));
            String line = br.readLine();
            line = br.readLine();
            String cvsSplitBy = ";";
            ObyvatelstvoVierovyznanieDaoImpl dao = new ObyvatelstvoVierovyznanieDaoImpl(connectionSource);
            while ((line = br.readLine()) != null && !line.startsWith(";")){
                String[] fields = line.split(cvsSplitBy);
                String ine = calculateIne(fields);
                ObyvatelstvoVierovyznanie entity = new ObyvatelstvoVierovyznanie(fields[3],fields[5],fields[8],fields[9],fields[10],fields[20],ine,fields[27],fields[29]);
                dao.createIfNotExists(entity);
            }
            br.close();
        } catch (IOException | SQLException e) {
            e.printStackTrace();
        }
    }
    private String calculateIne(String[] fields){
        Integer val = 0;
        for (int i = 11; i < fields.length - 1; i++){
            if (i != 27 && i != 20) {
                if (fields[i] != null && !fields[i].equals("")) {
                    val += Integer.parseInt(fields[i].replaceAll("\\s+", ""));
                }
            }
        }
        return val.toString();

    }
}
