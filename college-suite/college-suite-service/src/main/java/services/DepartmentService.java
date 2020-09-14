package services;

import models.Department;
import models.ImmutableDepartment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class DepartmentService {
    private static final Logger LOGGER = LoggerFactory.getLogger(DepartmentService.class);

    /**
     * @return
     */
    public Department createDepartment(Department department) {


        return department;
    }


    public Department updateDepartment(UUID id, Department department) {

        return department;
    }

    public List<Department> getDepartments(UUID collegeID) {
        ArrayList<Department> departments = new ArrayList<>();
        return departments;
    }

    public Department getDepartment(UUID id){
        return ImmutableDepartment.builder().build();
    }
}
