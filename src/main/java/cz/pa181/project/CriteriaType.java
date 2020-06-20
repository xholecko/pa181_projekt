package cz.pa181.project;

public enum CriteriaType {
    KulturaPamatihodnosti(1),
    KulturaZariadenia(2),
    CenyBytov(3),
    Internaty(4),

    private final int number;

    private CriteriaType(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}
