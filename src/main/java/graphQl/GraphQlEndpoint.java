package graphQl;

import graphql.execution.ExecutionStrategy;
import graphql.execution.instrumentation.Instrumentation;
import graphql.schema.GraphQLSchema;
import com.coxautodev.graphql.tools.SchemaParser;
import graphql.servlet.ExecutionStrategyProvider;
import graphql.servlet.GraphQLSchemaProvider;
import graphql.servlet.GraphQLServletListener;
import graphql.servlet.SimpleGraphQLServlet;
import repository.LogementRepository;
import repository.RendezVousRepository;

import javax.servlet.annotation.WebServlet;
import java.util.List;

@WebServlet(urlPatterns = "/graphql")
public class GraphQlEndpoint extends SimpleGraphQLServlet {


     public static LogementRepository logementRepository = new LogementRepository();
       public static RendezVousRepository rendezVousRepository = new RendezVousRepository();


    public GraphQlEndpoint() {
        super(buildSchema());
    }


    public static GraphQLSchema buildSchema(){
        return SchemaParser.newParser()
                 .file("schema.graphqls")
                .resolvers(new QueryApi(rendezVousRepository, logementRepository) , new MutatuionApi(rendezVousRepository, logementRepository))
                .build()
                .makeExecutableSchema() ;
    }
}
