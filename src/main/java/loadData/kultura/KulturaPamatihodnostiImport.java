package loadData.kultura;


import com.j256.ormlite.jdbc.JdbcPooledConnectionSource;
import dao.kultura.KulturaPamatihodnostiDaoImpl;
import entity.kultura.KulturaPamatihodnosti;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Class represents:
 * @author xholecko
 */
public class KulturaPamatihodnostiImport {
    private static final String URL_BYVANIE = "https://opendata.bratislava.sk/dataset/download/celomestsky-zoznam-pamatihodnosti-mesta-bratislavy/1";
    private static final String URL_DOPRAVA = "https://opendata.bratislava.sk/dataset/download/celomestsky-zoznam-pamatihodnosti-mesta-bratislavy/2";
    private static final String URL_LUDOVA_KULTURA = "https://opendata.bratislava.sk/dataset/download/celomestsky-zoznam-pamatihodnosti-mesta-bratislavy/3";
    private static final String URL_POMNIKY = "https://opendata.bratislava.sk/dataset/download/celomestsky-zoznam-pamatihodnosti-mesta-bratislavy/4";
    private static final String URL_PRIEMYSEL = "https://opendata.bratislava.sk/dataset/download/celomestsky-zoznam-pamatihodnosti-mesta-bratislavy/5";
    private static final String URL_SAKRALNE_PAMATIHODNOSTI = "https://opendata.bratislava.sk/dataset/download/celomestsky-zoznam-pamatihodnosti-mesta-bratislavy/6";
    private static final String URL_VOJENSKE_PAMATIHODNOSTI = "https://opendata.bratislava.sk/dataset/download/celomestsky-zoznam-pamatihodnosti-mesta-bratislavy/7";
    private static final String URL_ZAHRADY_PARKY = "https://opendata.bratislava.sk/dataset/download/celomestsky-zoznam-pamatihodnosti-mesta-bratislavy/8";
    private static final String URL_ZDRAVOTNICTVO_SKOLSTVO = "https://opendata.bratislava.sk/dataset/download/celomestsky-zoznam-pamatihodnosti-mesta-bratislavy/9";
    private static final String URL_INE = "https://opendata.bratislava.sk/dataset/download/celomestsky-zoznam-pamatihodnosti-mesta-bratislavy/10";

    private final HashMap<String, String> mestskeCasti = new HashMap<>();
    private final ArrayList<String>  typy = new ArrayList<>();


    public void getKulturaPamatihodnosti(JdbcPooledConnectionSource connectionSource){
        setTypy();
        setMestskeCasti();
        try {
            KulturaPamatihodnostiDaoImpl dao = new KulturaPamatihodnostiDaoImpl(connectionSource);

            for(String val : typy) {
                java.net.URL url = new URL(val);
                BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream(), "Windows-1250"));
                String line = br.readLine();
                String cvsSplitBy = ";";
                while ((line = br.readLine()) != null && !line.startsWith(";")){
                    String[] fields = line.split(cvsSplitBy);
                    KulturaPamatihodnosti entity = new KulturaPamatihodnosti(mestskaCastToOkres(fields[4]),fields[4],fields[2],fields[0]);
                    dao.createIfNotExists(entity);
                }
                br.close();
            }
        } catch (IOException | SQLException e) {
            e.printStackTrace();
        }
    }

    private void setTypy(){
        typy.add(URL_BYVANIE);
        typy.add(URL_DOPRAVA);
        typy.add(URL_LUDOVA_KULTURA);
        typy.add(URL_POMNIKY);
        typy.add(URL_PRIEMYSEL);
        typy.add(URL_SAKRALNE_PAMATIHODNOSTI);
        typy.add(URL_VOJENSKE_PAMATIHODNOSTI);
        typy.add(URL_ZAHRADY_PARKY);
        typy.add(URL_ZDRAVOTNICTVO_SKOLSTVO);
        typy.add(URL_INE);
    }

    private void setMestskeCasti(){
        mestskeCasti.put("Staré mesto","BratislavaI");
        mestskeCasti.put("Ružinov","BratislavaII");
        mestskeCasti.put("Vrakuňa","BratislavaII");
        mestskeCasti.put("Podunajské biskupice","BratislavaII");
        mestskeCasti.put("Nové mesto","BratislavaIII");
        mestskeCasti.put("Rača","BratislavaIII");
        mestskeCasti.put("Vajnory","BratislavaIII");
        mestskeCasti.put("Karlova ves","BratislavaIV");
        mestskeCasti.put("Dúbravka","BratislavaIV");
        mestskeCasti.put("Lamač","BratislavaIV");
        mestskeCasti.put("Devín","BratislavaIV");
        mestskeCasti.put("Devínska nová ves","BratislavaIV");
        mestskeCasti.put("Záhorská bystrica","BratislavaIV");
        mestskeCasti.put("Petržalka","BratislavaV");
        mestskeCasti.put("Jarovce","BratislavaV");
        mestskeCasti.put("Rusovce","BratislavaV");
        mestskeCasti.put("Čunovo","BratislavaV");
    }


    // V datasete sa nachadza niekolko zaznamov kde mestska cast je "-" alebi nieco neidentifikovatelne
    // Zaznamov je to asi len 15 z celkoveho poctu cca 350 takze to realne nijako data nesprzni,
    // tieto zaznamy budu mat oznacenie mestskej casti ako "undefined"
    // v dao som vyfiltroval tieto zaznamy takze to vrati iba korektne zaznamy
    private String mestskaCastToOkres(String mestskaCast){
        String result = "undefined";
        for (Map.Entry<String, String> entry : mestskeCasti.entrySet()) {
            if (mestskaCast.toLowerCase().contains(entry.getKey().toLowerCase())){
                result = entry.getValue();
                break;
            }
        }
//        if (result.equals("undefined")){
//            System.out.println(mestskaCast);
//        }
        return result;
    }
}
