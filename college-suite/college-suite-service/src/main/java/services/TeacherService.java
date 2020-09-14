package services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import models.*;

public class TeacherService {
    private static final Logger LOGGER = LoggerFactory.getLogger(TeacherService.class);
    
    public Teacher createTeacher(Teacher teacher)
    {
    	return teacher;
    }
    
    public Teacher getTeacher(UUID id){
        return ImmutableTeacher.builder().build();
    }
    
    public Teacher updateTeacher(UUID id, Teacher teacher){
        return teacher;
    }

    public List<Teacher> getTeachersByDepartment(UUID departmentId) {
        ArrayList<Teacher> teachers = new ArrayList<>();
        return teachers;
    }
}
