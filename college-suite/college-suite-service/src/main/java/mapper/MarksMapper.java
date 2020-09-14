package mapper;

import models.Marks;
import org.bson.Document;
import models.ImmutableMarks;
import java.util.*;

public class MarksMapper {
    public Marks documentToMarks(Document marksDocument) {

        return ImmutableMarks.builder()
                .id(UUID.fromString(marksDocument.getString("_id")))
                .marks(marksDocument.getInteger("marks"))
                //.subjectIds(marksDocument.getString("subjectId"))
                .build();
    }

    public Document marksToDocument(Marks marks) {
        Map<String, Object> map = new HashMap<>();
        map.put("_id", marks.getId().toString());
        map.put("marks", marks.getMarks());
      //  map.put("subjectId",marks.getSubjectIds().listIterator().toString());
        return new Document(map);
    }
}
