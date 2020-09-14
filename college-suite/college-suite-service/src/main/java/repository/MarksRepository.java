package repository;

import com.google.inject.Inject;
import com.mongodb.BasicDBObject;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import mapper.MarksMapper;
import models.Marks;
import org.bson.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import models.ImmutableMarks;
import java.util.UUID;
import static com.mongodb.client.model.Filters.eq;

public class MarksRepository {
    private static final Logger LOGGER = LoggerFactory.getLogger(StudentRepository .class);
    private final MongoCollection<Document> collection;
    private final MarksMapper marksMapper;
    private final MongoDatabase database;

    @Inject
    public MarksRepository(MongoDatabase database, MarksMapper marksMapper) {
        this.database = database;
        this.marksMapper = marksMapper;
        this.collection=database.getCollection("marks");
    }


    public Marks addMarks(Marks marks) {
        marks = ImmutableMarks.copyOf(marks).withId(UUID.randomUUID());
        Document document = marksMapper.marksToDocument(marks);
        if(document == null){
            return null;
        }
        collection.insertOne(document);
        return marksMapper.documentToMarks(document);
    }

    public Marks getMarks(UUID id) {
        BasicDBObject query = new BasicDBObject();
        query.put("_id", new BasicDBObject("$eq", id.toString()));
        Document document = (Document) collection.find(query).first();
        if (document==null){
            return null;
        }
        return marksMapper.documentToMarks(document);
    }

    public Marks updateMarks(UUID id, Marks mark) {
        mark = ImmutableMarks.copyOf(mark).withId(id);
        Document document = marksMapper.marksToDocument(mark);
        if(getMarks(id)!=null)
        {
            collection.updateOne(eq("_id", id.toString()), new Document("$set", document));
            return marksMapper.documentToMarks(document);
        }
        return null;
    }

    }
