import io.dropwizard.lifecycle.Managed;
import com.mongodb.Mongo;

public class MongoDBManager implements Managed {
    private Mongo mongo;

    public MongoDBManager(Mongo mongo) {
        this.mongo = mongo;
    }

    public void start() throws Exception {
    }

    public void stop() throws Exception {
        mongo.close();
    }
}
