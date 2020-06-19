package cz.pa181.project;

import com.j256.ormlite.jdbc.JdbcPooledConnectionSource;
import com.j256.ormlite.table.TableUtils;
import cz.pa181.project.dao.doprava.DopravaPocetNehodDaoImpl;
import cz.pa181.project.dao.ekonomika.EkonomikaCenyBytovDaoImpl;
import cz.pa181.project.dao.ekonomika.EkonomikaIndexStartnutiaDaoImpl;
import cz.pa181.project.dao.ekonomika.EkonomikaMieraNezamestnanostiDaoImpl;
import cz.pa181.project.dao.infrastruktura.InfrastrukturaPocetPostDaoImpl;
import cz.pa181.project.dao.kultura.KulturaPamatihodnostiDaoImpl;
import cz.pa181.project.dao.kultura.KulturaPocetZariadeniDaoImpl;
import cz.pa181.project.dao.obyvatelstvo.ObyvatelstvoDosiahnuteVzdelanieDaoImpl;
import cz.pa181.project.dao.obyvatelstvo.ObyvatelstvoPocetDaoImpl;
import cz.pa181.project.dao.obyvatelstvo.ObyvatelstvoPrirastokDaoImpl;
import cz.pa181.project.dao.obyvatelstvo.ObyvatelstvoVierovyznanieDaoImpl;
import cz.pa181.project.dao.socialne.SocialneZariadeniaDaoImpl;
import cz.pa181.project.dao.spravodlivost.SpravodlivostTrestneCinyDaoImpl;
import cz.pa181.project.dao.spravodlivost.SpravodlivostTrestneCinyPodVplyvomDaoImpl;
import cz.pa181.project.dao.vzdelanie.VzdelanieInternatyVSDaoImpl;
import cz.pa181.project.dao.vzdelanie.VzdelaniePocetZiakovDaoImpl;
import cz.pa181.project.dao.zdravie.ZdraviePocetLekarovDaoImpl;
import cz.pa181.project.dao.zdravie.ZdraviePocetNemocnicDaoImpl;
import cz.pa181.project.dao.zdravie.ZdraviePocetPoliklinikDaoImpl;
import cz.pa181.project.entity.doprava.DopravaPocetNehod;
import cz.pa181.project.entity.ekonomika.EkonomikaCenyBytov;
import cz.pa181.project.entity.ekonomika.EkonomikaIndexStartnutia;
import cz.pa181.project.entity.ekonomika.EkonomikaMieraNezamestnanosti;
import cz.pa181.project.entity.infrastruktura.InfrastrukturaPocetPost;
import cz.pa181.project.entity.kultura.KulturaPamatihodnosti;
import cz.pa181.project.entity.kultura.KulturaPocetZariadeni;
import cz.pa181.project.entity.obyvatelstvo.ObyvatelstvoDosiahnuteVzdelanie;
import cz.pa181.project.entity.obyvatelstvo.ObyvatelstvoPocet;
import cz.pa181.project.entity.obyvatelstvo.ObyvatelstvoPrirastok;
import cz.pa181.project.entity.obyvatelstvo.ObyvatelstvoVierovyznanie;
import cz.pa181.project.entity.socialne.SocialneZariadenia;
import cz.pa181.project.entity.spravodlivost.SpravodlivostTrestneCiny;
import cz.pa181.project.entity.spravodlivost.SpravodlivostTrestneCinyPodVplyvom;
import cz.pa181.project.entity.vzdelanie.VzdelanieInternatyVS;
import cz.pa181.project.entity.vzdelanie.VzdelaniePocetZiakov;
import cz.pa181.project.entity.zdravie.ZdraviePocetLekarov;
import cz.pa181.project.entity.zdravie.ZdraviePocetNemocnic;
import cz.pa181.project.entity.zdravie.ZdraviePocetPoliklinik;
import cz.pa181.project.enums.Priority;
import cz.pa181.project.enums.TypSkoly;
import cz.pa181.project.enums.TypZariadeni;
import cz.pa181.project.loadData.doprava.DopravaPocetNehodImport;
import cz.pa181.project.loadData.ekonomika.EkonomikaCenyBytovImport;
import cz.pa181.project.loadData.ekonomika.EkonomikaIndexStartnutiaImport;
import cz.pa181.project.loadData.ekonomika.EkonomikaMieraNezamestnanostiImport;
import cz.pa181.project.loadData.infrastruktura.InfrastrukturaPocetPostImport;
import cz.pa181.project.loadData.kultura.KulturaPamatihodnostiImport;
import cz.pa181.project.loadData.kultura.KulturaPocetZariadeniImport;
import cz.pa181.project.loadData.obyvatelstvo.ObyvatelstvoDosiahnuteVzdelanieImport;
import cz.pa181.project.loadData.obyvatelstvo.ObyvatelstvoPocetImport;
import cz.pa181.project.loadData.obyvatelstvo.ObyvatelstvoPrirastokImport;
import cz.pa181.project.loadData.obyvatelstvo.ObyvatelstvoVierovyznanieImport;
import cz.pa181.project.loadData.socialne.SocialneZariadeniaImport;
import cz.pa181.project.loadData.spravodlivost.SpravodlivostTrestneCinyImport;
import cz.pa181.project.loadData.spravodlivost.SpravodlivostTrestneCinyPodVplyvomImport;
import cz.pa181.project.loadData.vzdelanie.VzdelanieInternatyVSImport;
import cz.pa181.project.loadData.vzdelanie.VzdelaniePocetZiakovImport;
import cz.pa181.project.loadData.zdravie.ZdraviePocetLekarovImport;
import cz.pa181.project.loadData.zdravie.ZdraviePocetNemocnicImport;
import cz.pa181.project.loadData.zdravie.ZdraviePocetPoliklinikImport;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Class represents: cz.pa181.project.Main Class
 * @author xholecko
 */
@SpringBootApplication
public class Main  extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(Main.class);
    }

    public static void main(String[] args)  throws SQLException, IOException {
        SpringApplication application = new SpringApplication(Main.class);
        application.run();

        JdbcPooledConnectionSource connectionSource
                = new JdbcPooledConnectionSource("jdbc:postgresql://echo.db.elephantsql.com:5432/iaiikhsz");
        connectionSource.setUsername("iaiikhsz");
        connectionSource.setPassword("qxD5ZWMDSWhxcN9lNSmts2BQeA2UpcgZ");

//        loadDoprava(connectionSource);
//        loadEkonomika(connectionSource);
//        loadInfrastruktura(connectionSource);
//        loadKultura(connectionSource);
//        loadObyvatelstvo(connectionSource);
//        loadSocialne(connectionSource);
//        loadSpravodlivost(connectionSource);
//        loadVzdelania(connectionSource);
//        loadZdravie(connectionSource);
//
//
//        //Delete later
//        testCenyBytov(connectionSource);
//        testApp(connectionSource);
        testDAOs(connectionSource);

        connectionSource.close();
    }

    private static void testDAOs(JdbcPooledConnectionSource connectionSource) throws SQLException {
        DopravaPocetNehodDaoImpl dopravaPocetNehodDao = new DopravaPocetNehodDaoImpl(connectionSource);

        EkonomikaIndexStartnutiaDaoImpl ekonomikaIndexStartnutiaDao = new EkonomikaIndexStartnutiaDaoImpl(connectionSource);
        EkonomikaMieraNezamestnanostiDaoImpl ekonomikaMieraNezamestnanostiDao = new EkonomikaMieraNezamestnanostiDaoImpl(connectionSource);

        InfrastrukturaPocetPostDaoImpl infrastrukturaPocetPostDao = new InfrastrukturaPocetPostDaoImpl(connectionSource);

        KulturaPamatihodnostiDaoImpl kulturaPamatihodnostiDao = new KulturaPamatihodnostiDaoImpl(connectionSource);
        KulturaPocetZariadeniDaoImpl kulturaPocetZariadeniDao = new KulturaPocetZariadeniDaoImpl(connectionSource);

        ObyvatelstvoDosiahnuteVzdelanieDaoImpl obyvatelstvoDosiahnuteVzdelanieDao = new ObyvatelstvoDosiahnuteVzdelanieDaoImpl(connectionSource);
        ObyvatelstvoPocetDaoImpl obyvatelstvoPocetDao = new ObyvatelstvoPocetDaoImpl(connectionSource);
        ObyvatelstvoPrirastokDaoImpl obyvatelstvoPrirastokDao = new ObyvatelstvoPrirastokDaoImpl(connectionSource);
        ObyvatelstvoVierovyznanieDaoImpl obyvatelstvoVierovyznanieDao = new ObyvatelstvoVierovyznanieDaoImpl(connectionSource);

        SocialneZariadeniaDaoImpl socialneZariadeniaDao = new SocialneZariadeniaDaoImpl(connectionSource);

        SpravodlivostTrestneCinyPodVplyvomDaoImpl spravodlivostTrestneCinyPodVplyvomDao = new SpravodlivostTrestneCinyPodVplyvomDaoImpl(connectionSource);
        SpravodlivostTrestneCinyDaoImpl spravodlivostTrestneCinyDao = new SpravodlivostTrestneCinyDaoImpl(connectionSource);

        VzdelanieInternatyVSDaoImpl vzdelanieInternatyVSDao = new VzdelanieInternatyVSDaoImpl(connectionSource);
        VzdelaniePocetZiakovDaoImpl vzdelaniePocetZiakovDao = new VzdelaniePocetZiakovDaoImpl(connectionSource);

        ZdraviePocetLekarovDaoImpl zdraviePocetLekarovDao = new ZdraviePocetLekarovDaoImpl(connectionSource);
        ZdraviePocetNemocnicDaoImpl zdraviePocetNemocnicDao = new ZdraviePocetNemocnicDaoImpl(connectionSource);
        ZdraviePocetPoliklinikDaoImpl zdraviePocetPoliklinikDao = new ZdraviePocetPoliklinikDaoImpl(connectionSource);


        HashMap<String, List<String[]>> map = new HashMap<>();

        map.put("dopravaPocetNehodDao",dopravaPocetNehodDao.getPocetNehodByRokSorted(2020));

        map.put("ekonomikaIndexStartnutiaDao",ekonomikaIndexStartnutiaDao.getIndexStarnutiaByRokSorted(2020));
        map.put("ekonomikaMieraNezamestnanostiDao",ekonomikaMieraNezamestnanostiDao.getMieraNezamestnanostiByRokSorted(2020));

        map.put("infrastrukturaPocetPostDao",infrastrukturaPocetPostDao.getPocetPostByRokSorted(2020));

        map.put("kulturaPamatihodnostiDao",kulturaPamatihodnostiDao.getPamatihodnostiSorted());
        map.put("kulturaPocetZariadeniDaoDIVADLO",kulturaPocetZariadeniDao.getPocetZariadeniByRokATypZariadeniaSorted(2020, TypZariadeni.DIVADLO));
        map.put("kulturaPocetZariadeniDaoGALERIA",kulturaPocetZariadeniDao.getPocetZariadeniByRokATypZariadeniaSorted(2020, TypZariadeni.GALERIA));
        map.put("kulturaPocetZariadeniDaoKINO",kulturaPocetZariadeniDao.getPocetZariadeniByRokATypZariadeniaSorted(2020, TypZariadeni.KINO));
        map.put("kulturaPocetZariadeniDaoMUZEUM",kulturaPocetZariadeniDao.getPocetZariadeniByRokATypZariadeniaSorted(2020, TypZariadeni.MUZEUM));
        map.put("kulturaPocetZariadeniDaoVEDECKA_KNIZNICA",kulturaPocetZariadeniDao.getPocetZariadeniByRokATypZariadeniaSorted(2020, TypZariadeni.VEDECKA_KNIZNICA));
        map.put("kulturaPocetZariadeniDaoVEREJNA_KNIZNICA",kulturaPocetZariadeniDao.getPocetZariadeniByRokATypZariadeniaSorted(2020, TypZariadeni.VEREJNA_KNIZNICA));
        map.put("kulturaPocetZariadeniDaoVOLNY_CAS_MLADEZ",kulturaPocetZariadeniDao.getPocetZariadeniByRokATypZariadeniaSorted(2020, TypZariadeni.VOLNY_CAS_MLADEZ));

        map.put("obyvatelstvoDosiahnuteVzdelanieDao",obyvatelstvoDosiahnuteVzdelanieDao.getDosiahnuteVzdelanieSpoluByRokSorted());
        map.put("obyvatelstvoPrirastokDao",obyvatelstvoPrirastokDao.getPrirastokByRokSorted(2020));
        map.put("obyvatelstvoPocetDao",obyvatelstvoPocetDao.getPocetObyvatelovByRokSorted(2020));
        map.put("obyvatelstvoVierovyznanieDao",obyvatelstvoVierovyznanieDao.getVierovyznanieSorted());

        map.put("socialneZariadeniaDao",socialneZariadeniaDao.getPocetSocialnychZariadeniByRokSorted(2020));

        map.put("spravodlivostTrestneCinyPodVplyvomDao",spravodlivostTrestneCinyPodVplyvomDao.getPocetZistenychTrestnychCinovPodVplyvomByRokSorted(2020));
        map.put("spravodlivostTrestneCinyDao",spravodlivostTrestneCinyDao.getPocetZistenychTrestnychCinovByRokSorted(2020));

        map.put("vzdelanieInternatyVSDaoInternaty",vzdelanieInternatyVSDao.getPocetInternatovByRokSorted(2020));//CHYBA NIE SU DATA V DB
        map.put("vzdelanieInternatyVSDaoLozka",vzdelanieInternatyVSDao.getPocetLozokByRokSorted(2020)); //CHYBA NIE SU DATA V DB
        map.put("vzdelaniePocetZiakovDaoGYMNAZIUM",vzdelaniePocetZiakovDao.getPocetZiakovByRokATypSkolySorted(2020, TypSkoly.GYMNAZIUM));
        map.put("vzdelaniePocetZiakovDaoJAZYKOVA_SKOLA",vzdelaniePocetZiakovDao.getPocetZiakovByRokATypSkolySorted(2020, TypSkoly.JAZYKOVA_SKOLA));
        map.put("vzdelaniePocetZiakovDaoSTREDNA_ODBORNA_SKOLA",vzdelaniePocetZiakovDao.getPocetZiakovByRokATypSkolySorted(2020, TypSkoly.STREDNA_ODBORNA_SKOLA));
        map.put("vzdelaniePocetZiakovDaoZAKLADNA_SKOLA)",vzdelaniePocetZiakovDao.getPocetZiakovByRokATypSkolySorted(2020, TypSkoly.ZAKLADNA_SKOLA));

        map.put("zdraviePocetLekarovDao",zdraviePocetLekarovDao.getPocetLekarovByRokSorted(2020));
        map.put("zdraviePocetNemocnicDao",zdraviePocetNemocnicDao.getPocetNemocnicByRokSorted(2020));
        map.put("zdraviePocetPoliklinikDao",zdraviePocetPoliklinikDao.getPocetPoliklinkByRokSorted(2020));

        List<String> emptyDB = new ArrayList<>();
        for (Map.Entry<String,List<String[]>> entry : map.entrySet()){
            if (entry.getValue().isEmpty()){
                emptyDB.add(entry.getKey());
            }
        }
        if (!emptyDB.isEmpty()){
            System.out.println("Niektore tabulky pravdepodobne neobsahuju ziadne data");
            System.out.println("Pocet chyb: " + emptyDB.size() +" Chyby: " + emptyDB.toString());
        } else {
            System.out.println("OK");
        }
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
        appLogicWinnerTakesAll.addPointsWinnerTakesAll(zdraviePocetNemocnics.getPocetNemocnicByRokSorted(2017), Priority.MUST_HAVE);
        appLogicWinnerTakesAll.addPointsWinnerTakesAll(zdraviePocetLekarovs.getPocetLekarovByRokSorted(2017), Priority.MUST_HAVE);
        appLogicWinnerTakesAll.addPointsWinnerTakesAll(ekonomikaIndexStartnutias.getIndexStarnutiaByRokSorted(2017), Priority.MUST_HAVE);
        appLogicWinnerTakesAll.addPointsWinnerTakesAll(vzdelanieInternatyVS.getPocetInternatovByRokSorted(2017), Priority.MUST_HAVE);
        appLogicWinnerTakesAll.addPointsWinnerTakesAll(infrastrukturaPocetPosts.getPocetPostByRokSorted(2017), Priority.DO_NOT_WANT);
        appLogicWinnerTakesAll.addPointsWinnerTakesAll(kulturaPocetZariadenis.getPocetZariadeniByRokATypZariadeniaSorted(2017, TypZariadeni.DIVADLO), Priority.MUST_HAVE);
        appLogicWinnerTakesAll.addPointsWinnerTakesAll(spravodlivostTrestneCinyPodVplyvoms.getPocetZistenychTrestnychCinovPodVplyvomByRokSorted(2017), Priority.DO_NOT_WANT);
        List<String> result = appLogicWinnerTakesAll.getWinner();

        AppLogic appLogicProportional = new AppLogic();
        appLogicProportional.addPointsProportional(zdraviePocetNemocnics.getPocetNemocnicByRokSorted(2017), Priority.MUST_HAVE);
        appLogicProportional.addPointsProportional(zdraviePocetLekarovs.getPocetLekarovByRokSorted(2017), Priority.MUST_HAVE);
        appLogicProportional.addPointsProportional(ekonomikaIndexStartnutias.getIndexStarnutiaByRokSorted(2017), Priority.MUST_HAVE);
        appLogicProportional.addPointsProportional(vzdelanieInternatyVS.getPocetInternatovByRokSorted(2017), Priority.MUST_HAVE);
        appLogicProportional.addPointsProportional(infrastrukturaPocetPosts.getPocetPostByRokSorted(2017), Priority.DO_NOT_WANT);
        appLogicProportional.addPointsProportional(kulturaPocetZariadenis.getPocetZariadeniByRokATypZariadeniaSorted(2017, TypZariadeni.DIVADLO), Priority.MUST_HAVE);
        appLogicProportional.addPointsProportional(spravodlivostTrestneCinyPodVplyvoms.getPocetZistenychTrestnychCinovPodVplyvomByRokSorted(2017), Priority.DO_NOT_WANT);
        List<String> resultOther = appLogicProportional.getWinner();

        System.out.println("Vysledok - Winner takes all " + result); // Result - BratislavaI (3 points) a BratislavaII (3 points)
        System.out.println("Vysledok - Proporcne " + resultOther); // Result - BratislavaI (44 points) (BratislavaII je az na tretom mieste (38 points))
    }


    ////////////////////// NACITANIE DAT Z DATASETOV /////////////////////
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