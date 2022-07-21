package francescoribatti.esameengim.Controller;

import francescoribatti.esameengim.model.Articolo;
import francescoribatti.esameengim.model.Ordine;
import francescoribatti.esameengim.model.TariffaCorriere;
import francescoribatti.esameengim.model.repository.ArticoloRepository;
import francescoribatti.esameengim.model.repository.OrdineRepository;
import francescoribatti.esameengim.model.repository.TariffaCorriereRepository;
import francescoribatti.esameengim.payload.TariffaOrdiniPayload;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin("*")
public class Controller {

    @GetMapping("/articoli")
    public List<Articolo> articoli(){
        return ArticoloRepository.getArticoli();
    }

    @GetMapping("/ordini")
    public List<Ordine> ordini(){
        return OrdineRepository.getOrdini();
    }

    @GetMapping("/tariffe")
    public List<TariffaCorriere> tariffe(){
        return TariffaCorriereRepository.getTariffe();
    }

}

