import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.Singleton;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;


public class CollegeSuiteServiceModule extends AbstractModule {
    private final CollegeSuiteServiceConfiguration config;

    public CollegeSuiteServiceModule(CollegeSuiteServiceConfiguration config) {
        this.config = config;
    }

    @Override
    protected void configure() {
        // No need to specify simple bindings. Guice figures these out for itself.
    }

    @Provides
    @Singleton
    private MongoClient providesMongoClient() {
        MongoClient mongoClient = MongoClients.create(
                "mongodb+srv://admin123:ejz2545EJ@testcluster-lceti.mongodb.net/collegesuite?retryWrites=true&w=majority");
        return mongoClient;
    }

    @Provides
    @Singleton
    private MongoDatabase providesMongoDatabase(MongoClient mongoClient) {
        MongoDatabase database = mongoClient.getDatabase("collegesuite");
        return database;
    }

}
