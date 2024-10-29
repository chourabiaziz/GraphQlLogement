package graphQl;

import com.coxautodev.graphql.tools.GraphQLRootResolver;
import entite.Logement;
import entite.RendezVous;
import repository.LogementRepository;
import repository.RendezVousRepository;

import java.util.List;

public class MutatuionApi implements GraphQLRootResolver {

    RendezVousRepository rendezVousRepository;
    LogementRepository logementRepository;

    public MutatuionApi(RendezVousRepository rendezVousRepository, LogementRepository logementRepository) {
        this.rendezVousRepository = rendezVousRepository;
        this.logementRepository = logementRepository;

    }

    public RendezVous createRendezVous(int id, String date, String heure, int refLog, String num) {

        Logement logement = logementRepository.getLogementsByReference(refLog);
        RendezVous rendezVous = new RendezVous(id, date, heure, logement, num);
        rendezVousRepository.addRendezVous(rendezVous);
        return rendezVous;
    }

}
