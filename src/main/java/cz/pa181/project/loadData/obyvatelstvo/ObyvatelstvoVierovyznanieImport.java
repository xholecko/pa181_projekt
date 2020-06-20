package cz.pa181.project.loadData.obyvatelstvo;

import com.j256.ormlite.jdbc.JdbcPooledConnectionSource;
import cz.pa181.project.dao.obyvatelstvo.ObyvatelstvoVierovyznanieDaoImpl;
import cz.pa181.project.entity.obyvatelstvo.ObyvatelstvoVierovyznanie;

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
                int ineVyznania = calculateIne(fields);
                ObyvatelstvoVierovyznanie entity = new ObyvatelstvoVierovyznanie(
                        fields[3].replaceAll("\\s+",""),fields[5],
                        fields[8].equals("") ? 0 : Integer.parseInt(fields[8].replaceAll("\\s+", "")),
                        fields[9].equals("") ? 0 : Integer.parseInt(fields[9].replaceAll("\\s+", "")),
                        fields[10].equals("") ? 0 : Integer.parseInt(fields[10].replaceAll("\\s+", "")),
                        fields[20].equals("") ? 0 : Integer.parseInt(fields[20].replaceAll("\\s+", "")),
                        ineVyznania,
                        fields[27].equals("") ? 0 : Integer.parseInt(fields[27].replaceAll("\\s+", "")),
                        fields[29].equals("") ? 0 : Integer.parseInt(fields[29].replaceAll("\\s+", "")));
                dao.createIfNotExists(entity);
            }
            br.close();
        } catch (IOException | SQLException e) {
            e.printStackTrace();
        }
    }
    private int calculateIne(String[] fields){
        int val = 0;
        for (int i = 11; i < fields.length - 1; i++){
            if (i != 27 && i != 20) {
                if (fields[i] != null && !fields[i].equals("")) {
                    val += Integer.parseInt(fields[i].replaceAll("\\s+", ""));
                }
            }
        }
        return val;

    }
}
