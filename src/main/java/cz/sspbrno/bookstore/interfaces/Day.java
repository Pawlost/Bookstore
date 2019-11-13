package cz.sspbrno.bookstore.interfaces;

public enum Day {
    PONDELI("Pondělí", 1),
    UTERY("Úterý", 2),
    STREDA("Středa", 3),
    CTVRTEK("Čtvrtek", 4),
    PATEK("Pátek", 5),
    SOBOTA("Sobota", 6),
    NEDELE("Neděle", 0);

    public final String name;
    public final int index;

    private Day(String name, int index){
        this.name = name;
        this.index = index;
    }
}
