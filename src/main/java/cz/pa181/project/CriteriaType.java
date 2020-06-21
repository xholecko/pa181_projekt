package cz.pa181.project;

public enum CriteriaType {
    KulturaPamatihodnosti(1),
    KulturaZariadenia(2),
    CenyBytov(3),
    Internaty(4),
    PocetZiakov(5),
    ZdravotnickeZariadenia(6),
    SocialneZaraiadenia(7),
    Posty(8),
    DosiahnuteVzdelanie(9),
    Vierovyznania(10),
    Prirastok(11),
    Obyvatelstvo(12),
    Nezamestnanost(13),
    Krminalita(14),
    PocetNehod(15);


    private final int number;

    private CriteriaType(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}
