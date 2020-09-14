package services;
import models.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.*;


public class SemesterService {
    private static final Logger LOGGER = LoggerFactory.getLogger(SemesterService.class);

    public Semester createSemester(Semester semester)
    {
        return semester;
    }
    public Semester updateSemester(UUID Id,Semester semester) {
        return semester;
    }

    public Semester getSemester(UUID Id) {
            return ImmutableSemester.builder().build();
    }
}
