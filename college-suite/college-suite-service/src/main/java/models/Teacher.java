package models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.immutables.value.Value;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.UUID;

@JsonSerialize
@JsonDeserialize(as=ImmutableTeacher.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@Value.Immutable
public interface Teacher extends User{

    /**
     *
     * @return
     */
    UUID getId();

    /**
     *
     * @return
     */
    @NotNull
    String getFirstName() ;
    /**
     *
     * @return
     */
    @NotNull

    String getLastName() ;
    /**
     *
     * @return
     */
    @NotNull
    String getEmail();

    /**
     * @return
     *
     */
    Department getDepartment();

    /**
     *
     * @return
     */
    @NotNull
    List<Subject> getSubjects();
}
