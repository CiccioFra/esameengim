package francescoribatti.esameengim.model;

/**
 * Classe per creare l'stanza/oggetto TariffaCorriere
 */
public class TariffaCorriere {
    private int id;
    private String nomeCorriere;
    private String nomeTariffa;
    private double pesoMax;
    private double costo;

    public TariffaCorriere(int id, String nomeCorriere, String nomeTariffa, double pesoMax, double costo) {
        this.id = id;
        this.nomeCorriere = nomeCorriere;
        this.nomeTariffa = nomeTariffa;
        this.pesoMax = pesoMax;
        this.costo = costo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomeCorriere() {
        return nomeCorriere;
    }

    public void setNomeCorriere(String nomeCorriere) {
        this.nomeCorriere = nomeCorriere;
    }

    public String getNomeTariffa() {
        return nomeTariffa;
    }

    public void setNomeTariffa(String nomeTariffa) {
        this.nomeTariffa = nomeTariffa;
    }

    public double getPesoMax() {
        return pesoMax;
    }

    public void setPesoMax(double pesoMax) {
        this.pesoMax = pesoMax;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    @Override
    public String toString() {
        return "Tariffa del Corriere{" +
                "id=" + id +
                ", nome Corriere: '" + nomeCorriere + '\'' +
                ", Tariffa: " + nomeTariffa +
                ", peso Max: " + pesoMax +
                ", costo: " + costo + "¢" +
                '}';
    }
}
