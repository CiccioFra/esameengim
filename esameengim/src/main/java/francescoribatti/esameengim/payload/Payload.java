package francescoribatti.esameengim.payload;

import francescoribatti.esameengim.model.Ordine;
import francescoribatti.esameengim.model.TariffaCorriere;
import francescoribatti.esameengim.model.repository.TariffaCorriereRepository;

import java.util.List;

public class Payload extends Ordine {

    private Ordine ordine;

    public Payload(int id, int numero, String data, Ordine ordine) {
        super(id, numero, data);
        this.ordine = ordine;
    }

    public Ordine getOrdine() {
        return ordine;
    }

    public void setOrdine(Ordine ordine) {
        this.ordine = ordine;
    }

    public static TariffaCorriere tariffaConveniente(double peso, int xx){
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
}
