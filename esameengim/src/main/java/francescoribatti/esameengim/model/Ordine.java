package francescoribatti.esameengim.model;

public class Ordine {
    private int id;
    private int numero;
    private String data;

    public Ordine(int id, int numero, String data) {
        this.id = id;
        this.numero = numero;
        this.data = data;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Ordine{" +
                "id=" + id +
                ", numero Ordine: '" + numero + '\'' +
                ", data: " + data +
                '}';
    }
}
