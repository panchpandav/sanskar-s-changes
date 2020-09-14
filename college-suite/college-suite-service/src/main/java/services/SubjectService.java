package services;
import models.Subject;
import org.slf4j.Logger;
import models.ImmutableSubject;
import org.slf4j.LoggerFactory;
import java.util.*;
public class SubjectService{

    private static final Logger LOGGER = LoggerFactory.getLogger(SubjectService.class);
    /**
     *
     * @return
     */
    public Subject createSubject(Subject subject)
    {
        return subject;

    }
    public Subject getSubject(UUID id) {
        return ImmutableSubject.builder().build();
    }

    public Subject updateSubject(UUID id,Subject subject)
    {
        /**
         * logic for update
         */
        return subject;

    }
}
