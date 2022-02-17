public class Ausfluge {
    private Long id;
    private String reisezihl;
    private int preis;
    private int max_anz;
    private int anzahl;

    /**
    Constructor
     */
    public Ausfluge(Long id, String reisezihl, int preis, int max_anz, int anzahl){
        this.id = id;
        this.reisezihl = reisezihl;
        this.preis = preis;
        this.max_anz = max_anz;
        this.anzahl = anzahl;
    }

    public Long getId() {
        return id;
    }

    public int getAnzahl() {
        return anzahl;
    }

    public int getPreis() {
        return preis;
    }

    public int getMax_anz() {
        return max_anz;
    }

    public String getReisezahl() {
        return reisezihl;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setAnzahl(int anzahl) {
        this.anzahl = anzahl;
    }

    public void setPreis(int preis) {
        this.preis = preis;
    }

    public void setMax_anz(int max_anz) {
        this.max_anz = max_anz;
    }

    public void setReisezahl(String reisezihl) {
        this.reisezihl = reisezihl;
    }

    @Override
    public String toString() {
        return "Ausfluge{" +
                "id=" + id +
                ", reisezahl=" + reisezihl +
                ", preis=" + preis +
                ", max_anz=" + max_anz +
                ", anzahl=" + anzahl +
                '}';
    }

    /**
     * @param object other object we are comparing to
     * @return 1 if true, -1 if false
     */
    public int kleiner(Ausfluge object) {
        if (anzahl < object.getAnzahl())
            return 1;
        else
            return -1;
    }
}
