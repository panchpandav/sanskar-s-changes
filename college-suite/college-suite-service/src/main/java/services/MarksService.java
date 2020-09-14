package services;

import com.google.inject.Inject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import models.Marks;
import repository.MarksRepository;
import java.util.UUID;

public class MarksService {
    private static final Logger LOGGER = LoggerFactory.getLogger(MarksService.class);

    private MarksRepository marksRepository;

    @Inject
    public MarksService(MarksRepository marksRepository){this.marksRepository = marksRepository;}


    public Marks getMarks(UUID Id)
    {
        Marks getMarks = marksRepository.getMarks(Id);
        return getMarks;
    }


    public Marks updateMarks(UUID Id,Marks mark) {
        Marks updateMarks = marksRepository.updateMarks(Id,mark);
        return updateMarks;
    }


    public Marks addMarks(Marks marks) {
        Marks addMarks = marksRepository.addMarks(marks);
        return addMarks;
        }
    }
