package mapper;
import models.ImmutableStudent;
import models.Student;
import org.bson.Document;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class StudentMapper {
    public Student documentToStudent(Document studentDocument) {
        return ImmutableStudent.builder()
                .id(UUID.fromString(studentDocument.getString("_id")))
                .firstName(studentDocument.getString("firstName"))
                .lastName(studentDocument.getString("lastName"))
                .email(studentDocument.getString("email"))
                .semesterId(UUID.fromString(studentDocument.getString("semesterId")))
                .build();
    }

    public Document studentToDocument(Student student) {
        Map<String, Object> map = new HashMap<>();
        map.put("_id", student.getId().toString());
        map.put("firstName", student.getFirstName());
        map.put("lastName", student.getLastName());
        map.put("email", student.getEmail());
        map.put("semesterId", student.getSemesterId().toString());

        return new Document(map);
    }

}
