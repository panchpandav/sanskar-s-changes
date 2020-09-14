package models;

import java.util.List;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.immutables.value.Value.Immutable;

import javax.annotation.Nullable;
import javax.validation.constraints.NotNull;


@JsonSerialize
@JsonDeserialize(as = ImmutableStudent.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@Immutable
public interface Student extends User {

    /**
     *
     * @return
     */
    @Nullable
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
    @Nullable
    String getEmail();

    /**
     *
     * @return
     */
    @Nullable
    UUID getSemesterId();

    /**
     *
     * @return
     */
    @Nullable
    List<UUID> getSubjectIds();

    /**
     *
     * @return
     */
    @Nullable
    List<Marks> getMarks();
}
