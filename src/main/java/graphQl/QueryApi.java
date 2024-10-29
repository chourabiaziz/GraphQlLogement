package graphQl;

import com.coxautodev.graphql.tools.GraphQLRootResolver;
import entite.Logement;
import entite.RendezVous;
import repository.LogementRepository;
import repository.RendezVousRepository;

import java.util.List;

public class QueryApi implements GraphQLRootResolver {


    RendezVousRepository rendezVousRepository ;
    LogementRepository logementRepository ;
    public  QueryApi() {}


    public QueryApi(RendezVousRepository rendezVousRepository, LogementRepository logementRepository) {
        this.rendezVousRepository = rendezVousRepository;
        this.logementRepository = logementRepository;
    }

    public List<RendezVous> getAllRdv () {
        return rendezVousRepository.getListeRendezVous();
    }

    public List<Logement> getAllLog () {
        return logementRepository.getAllLogements();
    }
    public Logement getLogementById (int id) {
        return logementRepository.getLogementsByReference(id);
    }


}
