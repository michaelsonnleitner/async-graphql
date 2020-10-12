package at.raiffeisen.graphql;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionException;

import javax.inject.Inject;

import org.eclipse.microprofile.graphql.GraphQLApi;
import org.eclipse.microprofile.graphql.Query;
import org.eclipse.microprofile.graphql.Source;

@GraphQLApi
public class PersonResource {

    @Inject
    BackendService backendService;

    @Query
    public CompletableFuture<Person> getPerson(long id) throws InterruptedException {
        return CompletableFuture.supplyAsync(() -> backendService.getPerson(id));
    }


    public CompletableFuture<List<Adress>> getAdresses(@Source Person p) throws InterruptedException {
        return CompletableFuture.supplyAsync(() -> backendService.getAdressesForPerson(p.id));
    }

    public CompletableFuture<List<DetailAdress>> getDetailAdresses(@Source List<Adress> adresses) throws InterruptedException {
        return CompletableFuture.supplyAsync(() -> {
            List<CompletableFuture<DetailAdress>> completableFutures = new ArrayList<>();
            for (Adress adress : adresses) {
                completableFutures.add(CompletableFuture.supplyAsync(() -> backendService.getDetailAdressesForAdress(adress.id)));
            }
            CompletableFuture<Void> combinedFuture = CompletableFuture.allOf(completableFutures.toArray(new CompletableFuture[0]));
            try {
                combinedFuture.get();
            } catch (Exception e) {
                throw new CompletionException(e);
            }
            List<DetailAdress> ret = new ArrayList<>();
            completableFutures.forEach(adress -> {
                try {
                    ret.add(adress.get());
                } catch (Exception e) {
                    throw new CompletionException(e);
                }
            });
            return ret;
        });
    }

    public CompletableFuture<List<Phonenumber>> getPhonenumbers(@Source Person p) throws InterruptedException {
        return CompletableFuture.supplyAsync(() -> backendService.getPhonenumbersForPerson(p.id));
    }
}
