package services;

import com.google.inject.Inject;
import models.Student;
import models.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import repository.StudentRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class StudentService {

    private static final Logger LOGGER = LoggerFactory.getLogger(StudentService.class);
    private final StudentRepository studentRepository;

    @Inject
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    /**
     *
     * @return
     */
    public Student createStudent(Student student) {
        Student createdStudent = studentRepository.createStudent(student);
        return createdStudent;
    }

    /**
     *
     * @return
     */
    public Student getStudent() {
        return null;
    }

    public List<Student> getStudentsByDepartment(UUID departmentId) {
        ArrayList<Student> students = new ArrayList<>();
        return students;
    }

    public Student getStudent(UUID id)
    {
        return ImmutableStudent.builder().build();
    }

    public Student updateStudentById( UUID studentID , Student studentDetails ) { ;
        return studentDetails;
    }

}
