package francescoribatti.esameengim.payload;

import francescoribatti.esameengim.model.Ordine;
import francescoribatti.esameengim.model.TariffaCorriere;
import francescoribatti.esameengim.model.repository.OrdineRepository;
import francescoribatti.esameengim.model.repository.TariffaCorriereRepository;

import java.util.List;

public class TariffaOrdiniPayload extends Ordine {

    private Ordine ordine;

    public TariffaOrdiniPayload(int id, int numero, String data, Ordine ordine) {
        super(id, numero, data);
        this.ordine = ordine;
    }

    public Ordine getOrdine() {
        return ordine;
    }

    public void setOrdine(Ordine ordine) {
        this.ordine = ordine;
    }

    /**
     * Trova la tariffa più convenite di un corriere
     * in base al peso dell'ordine
     * @param peso peso complessivo dell'ordine
     * @return  La tariffa più conveniente
     */
    public static TariffaCorriere tariffaConveniente(double peso){
        TariffaCorriere tariffaParsimoniosa = null;
        List<TariffaCorriere> tariffeEcoPerPeso = TariffaCorriereRepository.getTariffePerPeso(peso);
        for (TariffaCorriere tariffa : tariffeEcoPerPeso) {
            do {
                tariffaParsimoniosa = tariffa;
            }
            while (tariffa.getCosto() < tariffaParsimoniosa.getCosto());{
                tariffaParsimoniosa = tariffa;
            }
        }
        return tariffaParsimoniosa;
    }

    /**
     * Calcola la tariffa più conveniente per un ordine
     * @param id_ordine ID dell'ordine
     * @return tariffa più conveniente di un ordine
     */
    public double tariffaEconomica(int id_ordine){

        double pesoOrdine = OrdineRepository.getPesoOrdine(id_ordine);
        TariffaCorriere tariffaEconomica = TariffaOrdiniPayload.tariffaConveniente(pesoOrdine);
        double prezzoTariffaConveniente = tariffaEconomica.getCosto();

        return prezzoTariffaConveniente;
    }
}
