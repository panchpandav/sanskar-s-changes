package repository;

import com.google.inject.Inject;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import mapper.StudentMapper;
import models.ImmutableStudent;
import models.Student;
import org.bson.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.UUID;

public class StudentRepository {
    private static final Logger LOGGER = LoggerFactory.getLogger(StudentRepository .class);
    private final MongoCollection<Document> collection;
    private final StudentMapper studentMapper;
    private final MongoDatabase database;

    @Inject
    public StudentRepository(MongoDatabase database, StudentMapper studentMapper) {
        this.database = database;
        this.studentMapper = studentMapper;
        this.collection=database.getCollection("student");
    }


    public Student createStudent(Student student) {
        student = ImmutableStudent.copyOf(student).withId(UUID.randomUUID());
        System.out.println(student);
        Document document = studentMapper.studentToDocument(student);
        collection.insertOne(document);
        return studentMapper.documentToStudent(document);
    }
}
