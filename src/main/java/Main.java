import com.j256.ormlite.jdbc.JdbcPooledConnectionSource;
import com.j256.ormlite.table.TableUtils;
import dao.ekonomika.EkonomikaCenyBytovDaoImpl;
import dao.ekonomika.EkonomikaIndexStartnutiaDaoImpl;
import dao.infrastruktura.InfrastrukturaPocetPostDaoImpl;
import dao.kultura.KulturaPocetZariadeniDaoImpl;
import dao.spravodlivost.SpravodlivostTrestneCinyPodVplyvomDaoImpl;
import dao.vzdelanie.VzdelanieInternatyVSDaoImpl;
import dao.zdravie.ZdraviePocetLekarovDaoImpl;
import dao.zdravie.ZdraviePocetNemocnicDaoImpl;
import entity.doprava.DopravaPocetNehod;
import entity.ekonomika.EkonomikaCenyBytov;
import entity.ekonomika.EkonomikaIndexStartnutia;
import entity.ekonomika.EkonomikaMieraNezamestnanosti;
import entity.infrastruktura.InfrastrukturaPocetPost;
import entity.kultura.KulturaPamatihodnosti;
import entity.kultura.KulturaPocetZariadeni;
import entity.obyvatelstvo.ObyvatelstvoDosiahnuteVzdelanie;
import entity.obyvatelstvo.ObyvatelstvoPocet;
import entity.obyvatelstvo.ObyvatelstvoPrirastok;
import entity.obyvatelstvo.ObyvatelstvoVierovyznanie;
import entity.socialne.SocialneZariadenia;
import entity.spravodlivost.SpravodlivostTrestneCiny;
import entity.spravodlivost.SpravodlivostTrestneCinyPodVplyvom;
import entity.vzdelanie.VzdelanieInternatyVS;
import entity.vzdelanie.VzdelaniePocetSkol;
import entity.vzdelanie.VzdelaniePocetZiakov;
import entity.zdravie.ZdraviePocetLekarov;
import entity.zdravie.ZdraviePocetNemocnic;
import entity.zdravie.ZdraviePocetPoliklinik;
import enums.Priority;
import enums.TypZariadeni;
import loadData.doprava.DopravaPocetNehodImport;
import loadData.ekonomika.EkonomikaCenyBytovImport;
import loadData.ekonomika.EkonomikaIndexStartnutiaImport;
import loadData.ekonomika.EkonomikaMieraNezamestnanostiImport;
import loadData.infrastruktura.InfrastrukturaPocetPostImport;
import loadData.kultura.KulturaPamatihodnostiImport;
import loadData.kultura.KulturaPocetZariadeniImport;
import loadData.obyvatelstvo.ObyvatelstvoDosiahnuteVzdelanieImport;
import loadData.obyvatelstvo.ObyvatelstvoPocetImport;
import loadData.obyvatelstvo.ObyvatelstvoPrirastokImport;
import loadData.obyvatelstvo.ObyvatelstvoVierovyznanieImport;
import loadData.socialne.SocialneZariadeniaImport;
import loadData.spravodlivost.SpravodlivostTrestneCinyImport;
import loadData.spravodlivost.SpravodlivostTrestneCinyPodVplyvomImport;
import loadData.vzdelanie.VzdelanieInternatyVSImport;
import loadData.vzdelanie.VzdelaniePocetSkolImport;
import loadData.vzdelanie.VzdelaniePocetZiakovImport;
import loadData.zdravie.ZdraviePocetLekarovImport;
import loadData.zdravie.ZdraviePocetNemocnicImport;
import loadData.zdravie.ZdraviePocetPoliklinikImport;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

/**
 * Class represents: Main Class
 * @author xholecko
 */
public class Main {

    public static void main(String[] args) throws SQLException, IOException {
        JdbcPooledConnectionSource connectionSource
                = new JdbcPooledConnectionSource("jdbc:h2:mem:myDb");
        loadDoprava(connectionSource);
        loadEkonomika(connectionSource);
        loadInfrastruktura(connectionSource);
        loadKultura(connectionSource);
        loadObyvatelstvo(connectionSource);
        loadSocialne(connectionSource);
        loadSpravodlivost(connectionSource);
        loadVzdelania(connectionSource);
        loadZdravie(connectionSource);


        //Delete later
        testDao(connectionSource);
        testCenyBytov(connectionSource);
        testApp(connectionSource);
        System.out.println("OK");


        connectionSource.close();
    }

    private static void testDao(JdbcPooledConnectionSource connectionSource) throws SQLException {
        ZdraviePocetNemocnicDaoImpl dao = new ZdraviePocetNemocnicDaoImpl(connectionSource);

        //kazda implementovana metoda v DAO vrati pri zadani validnych parametrov zoradeny zoznam o velkosti 5
        //napr v tomto pripade to vrati {[" Bratislava II","6"],[" Bratislava I","5"],[" Bratislava III","4"],[" Bratislava V","2"],[" Bratislava IV","0"]}
        List<String[]> tmp = dao.getPocetNemocnicByRok(2017);

        String okres = tmp.get(0)[0]; // " BratislavaII"
        String hodnota = tmp.get(0)[1]; // "6"

        System.out.println(tmp);
        System.out.println(okres);
        System.out.println(hodnota);
    }


    private static void testCenyBytov(JdbcPooledConnectionSource connectionSource) throws SQLException {
        EkonomikaCenyBytovDaoImpl ekonomikaCenyBytovDao = new EkonomikaCenyBytovDaoImpl(connectionSource);
        String cenaBytovBlavaI = ekonomikaCenyBytovDao.getPriemernuCenuBytovByOkres("BratislavaI");
        System.out.println(cenaBytovBlavaI);
    }


    //Rovnako zadane priority ale rozne typy prepocitavania
    private static void testApp(JdbcPooledConnectionSource connectionSource) throws SQLException {
        ZdraviePocetNemocnicDaoImpl zdraviePocetNemocnics = new ZdraviePocetNemocnicDaoImpl(connectionSource);
        ZdraviePocetLekarovDaoImpl zdraviePocetLekarovs = new ZdraviePocetLekarovDaoImpl(connectionSource);
        EkonomikaIndexStartnutiaDaoImpl ekonomikaIndexStartnutias = new EkonomikaIndexStartnutiaDaoImpl(connectionSource);
        VzdelanieInternatyVSDaoImpl vzdelanieInternatyVS = new VzdelanieInternatyVSDaoImpl(connectionSource);
        InfrastrukturaPocetPostDaoImpl infrastrukturaPocetPosts = new InfrastrukturaPocetPostDaoImpl(connectionSource);
        KulturaPocetZariadeniDaoImpl kulturaPocetZariadenis = new KulturaPocetZariadeniDaoImpl(connectionSource);
        SpravodlivostTrestneCinyPodVplyvomDaoImpl spravodlivostTrestneCinyPodVplyvoms = new SpravodlivostTrestneCinyPodVplyvomDaoImpl(connectionSource);

        AppLogic appLogicWinnerTakesAll = new AppLogic();
        appLogicWinnerTakesAll.addPointsWinnerTakesAll(zdraviePocetNemocnics.getPocetNemocnicByRok(2017), Priority.MUST_HAVE);
        appLogicWinnerTakesAll.addPointsWinnerTakesAll(zdraviePocetLekarovs.getPocetLekarovByRok(2017), Priority.MUST_HAVE);
        appLogicWinnerTakesAll.addPointsWinnerTakesAll(ekonomikaIndexStartnutias.getIndexStarnutiaByRok(2017), Priority.MUST_HAVE);
        appLogicWinnerTakesAll.addPointsWinnerTakesAll(vzdelanieInternatyVS.getPocetInternatovByRok(2017), Priority.MUST_HAVE);
        appLogicWinnerTakesAll.addPointsWinnerTakesAll(infrastrukturaPocetPosts.getPocetPostByRok(2017), Priority.DO_NOT_WANT);
        appLogicWinnerTakesAll.addPointsWinnerTakesAll(kulturaPocetZariadenis.getPocetZariadeniByRokATypZariadenia(2017, TypZariadeni.DIVADLO), Priority.MUST_HAVE);
        appLogicWinnerTakesAll.addPointsWinnerTakesAll(spravodlivostTrestneCinyPodVplyvoms.getPocetZistenychTrestnychCinovPodVplyvomByRok(2017), Priority.DO_NOT_WANT);
        List<String> result = appLogicWinnerTakesAll.getWinner();

        AppLogic appLogicProportional = new AppLogic();
        appLogicProportional.addPointsProportional(zdraviePocetNemocnics.getPocetNemocnicByRok(2017), Priority.MUST_HAVE);
        appLogicProportional.addPointsProportional(zdraviePocetLekarovs.getPocetLekarovByRok(2017), Priority.MUST_HAVE);
        appLogicProportional.addPointsProportional(ekonomikaIndexStartnutias.getIndexStarnutiaByRok(2017), Priority.MUST_HAVE);
        appLogicProportional.addPointsProportional(vzdelanieInternatyVS.getPocetInternatovByRok(2017), Priority.MUST_HAVE);
        appLogicProportional.addPointsProportional(infrastrukturaPocetPosts.getPocetPostByRok(2017), Priority.DO_NOT_WANT);
        appLogicProportional.addPointsProportional(kulturaPocetZariadenis.getPocetZariadeniByRokATypZariadenia(2017, TypZariadeni.DIVADLO), Priority.MUST_HAVE);
        appLogicProportional.addPointsProportional(spravodlivostTrestneCinyPodVplyvoms.getPocetZistenychTrestnychCinovPodVplyvomByRok(2017), Priority.DO_NOT_WANT);
        List<String> resultOther = appLogicProportional.getWinner();

        System.out.println("Vysledok - Winner takes all " + result); // Result - BratislavaI (3 points) a BratislavaII (3 points)
        System.out.println("Vysledok - Proporcne " + resultOther); // Result - BratislavaI (44 points) (BratislavaII je az na tretom mieste (38 points))
    }

    private static void loadDoprava(JdbcPooledConnectionSource connectionSource) throws SQLException {
        TableUtils.createTableIfNotExists(connectionSource, DopravaPocetNehod.class);
        DopravaPocetNehodImport dopravaPocetNehodImport = new DopravaPocetNehodImport();
        dopravaPocetNehodImport.getDopravaPocetNehod(connectionSource);
    }

    private static void loadEkonomika(JdbcPooledConnectionSource connectionSource) throws SQLException {
        TableUtils.createTableIfNotExists(connectionSource, EkonomikaIndexStartnutia.class);
        EkonomikaIndexStartnutiaImport ekonomikaIndexStartnutiaImport = new EkonomikaIndexStartnutiaImport();
        ekonomikaIndexStartnutiaImport.getEkonomikaIndexStartnutia(connectionSource);

        TableUtils.createTableIfNotExists(connectionSource, EkonomikaMieraNezamestnanosti.class);
        EkonomikaMieraNezamestnanostiImport ekonomikaMieraNezamestnanostiImport = new EkonomikaMieraNezamestnanostiImport();
        ekonomikaMieraNezamestnanostiImport.getEkonomikaMieraNezamestnanosti(connectionSource);

        TableUtils.createTableIfNotExists(connectionSource, EkonomikaCenyBytov.class);
        EkonomikaCenyBytovImport ekonomikaCenyBytovImport = new EkonomikaCenyBytovImport();
        ekonomikaCenyBytovImport.getEkonomikaCenyBytov(connectionSource);
    }

    private static void loadInfrastruktura(JdbcPooledConnectionSource connectionSource) throws SQLException {
        TableUtils.createTableIfNotExists(connectionSource, InfrastrukturaPocetPost.class);
        InfrastrukturaPocetPostImport infrastrukturaPocetPostImport = new InfrastrukturaPocetPostImport();
        infrastrukturaPocetPostImport.getInfrastrukturaPocetPost(connectionSource);
    }

    private static void loadKultura(JdbcPooledConnectionSource connectionSource) throws SQLException {
        TableUtils.createTableIfNotExists(connectionSource, KulturaPocetZariadeni.class);
        KulturaPocetZariadeniImport kulturaZariadeniaVolnyCasImport = new KulturaPocetZariadeniImport();
        kulturaZariadeniaVolnyCasImport.getKulturaPocetZariadeni(connectionSource);

        TableUtils.createTableIfNotExists(connectionSource, KulturaPamatihodnosti.class);
        KulturaPamatihodnostiImport kulturaPamatihodnostiImport = new KulturaPamatihodnostiImport();
        kulturaPamatihodnostiImport.getKulturaPamatihodnosti(connectionSource);
    }

    private static void loadObyvatelstvo(JdbcPooledConnectionSource connectionSource) throws SQLException {
        TableUtils.createTableIfNotExists(connectionSource, ObyvatelstvoVierovyznanie.class);
        ObyvatelstvoVierovyznanieImport obyvatelstvoVierovyznanieImport = new ObyvatelstvoVierovyznanieImport();
        obyvatelstvoVierovyznanieImport.getObyvatelstvoVierovyznanie(connectionSource);

        TableUtils.createTableIfNotExists(connectionSource, ObyvatelstvoPocet.class);
        ObyvatelstvoPocetImport obyvatelstvoPocetImport = new ObyvatelstvoPocetImport();
        obyvatelstvoPocetImport.getObyvatelstvoPocet(connectionSource);

        TableUtils.createTableIfNotExists(connectionSource, ObyvatelstvoPrirastok.class);
        ObyvatelstvoPrirastokImport obyvatelstvoPrirastokImport = new ObyvatelstvoPrirastokImport();
        obyvatelstvoPrirastokImport.getObyvatelstvoPrirastok(connectionSource);

        TableUtils.createTableIfNotExists(connectionSource, ObyvatelstvoDosiahnuteVzdelanie.class);
        ObyvatelstvoDosiahnuteVzdelanieImport obyvatelstvoDosiahnuteVzdelanieImport = new ObyvatelstvoDosiahnuteVzdelanieImport();
        obyvatelstvoDosiahnuteVzdelanieImport.getObyvatelstvoDosiahnuteVzdelanie(connectionSource);
    }

    private static void loadSocialne(JdbcPooledConnectionSource connectionSource) throws SQLException {
        TableUtils.createTableIfNotExists(connectionSource, SocialneZariadenia.class);
        SocialneZariadeniaImport socialneZariadeniaImport = new SocialneZariadeniaImport();
        socialneZariadeniaImport.getSocialneZariadenia(connectionSource);
    }

    private static void loadVzdelania(JdbcPooledConnectionSource connectionSource) throws SQLException {
        TableUtils.createTableIfNotExists(connectionSource, VzdelaniePocetSkol.class);
        VzdelaniePocetSkolImport vzdelaniePocetSkolImport = new VzdelaniePocetSkolImport();
        vzdelaniePocetSkolImport.getVzdelaniePocetSkol(connectionSource);

        TableUtils.createTableIfNotExists(connectionSource, VzdelaniePocetZiakov.class);
        VzdelaniePocetZiakovImport vzdelaniePocetZiakovImport = new VzdelaniePocetZiakovImport();
        vzdelaniePocetZiakovImport.getVzdelaniePocetZiakov(connectionSource);

        TableUtils.createTableIfNotExists(connectionSource, VzdelanieInternatyVS.class);
        VzdelanieInternatyVSImport vzdelanieInternatyVSImport = new VzdelanieInternatyVSImport();
        vzdelanieInternatyVSImport.getVzdelanieInternatyVS(connectionSource);
    }

    private static void loadSpravodlivost(JdbcPooledConnectionSource connectionSource) throws SQLException {
        TableUtils.createTableIfNotExists(connectionSource, SpravodlivostTrestneCiny.class);
        SpravodlivostTrestneCinyImport spravodlivostTrestneCinyImport = new SpravodlivostTrestneCinyImport();
        spravodlivostTrestneCinyImport.getSpravodlivostTrestneCiny(connectionSource);

        TableUtils.createTableIfNotExists(connectionSource, SpravodlivostTrestneCinyPodVplyvom.class);
        SpravodlivostTrestneCinyPodVplyvomImport spravodlivostTrestneCinyPodVplyvomImport = new SpravodlivostTrestneCinyPodVplyvomImport();
        spravodlivostTrestneCinyPodVplyvomImport.getSpravodlivostTrestneCinyPodVplyvom(connectionSource);
    }

    private static void loadZdravie(JdbcPooledConnectionSource connectionSource) throws SQLException {
        TableUtils.createTableIfNotExists(connectionSource, ZdraviePocetLekarov.class);
        ZdraviePocetLekarovImport zdraviePocetLekarovImport = new ZdraviePocetLekarovImport();
        zdraviePocetLekarovImport.getZdraviePocetLekarov(connectionSource);

        TableUtils.createTableIfNotExists(connectionSource, ZdraviePocetPoliklinik.class);
        ZdraviePocetPoliklinikImport zdraviePocetPoliklinikImport = new ZdraviePocetPoliklinikImport();
        zdraviePocetPoliklinikImport.getZdraviePocetPoliklinik(connectionSource);

        TableUtils.createTableIfNotExists(connectionSource, ZdraviePocetNemocnic.class);
        ZdraviePocetNemocnicImport zdraviePocetNemocnicImport = new ZdraviePocetNemocnicImport();
        zdraviePocetNemocnicImport.getZdraviePocetNemocnic(connectionSource);
    }
}