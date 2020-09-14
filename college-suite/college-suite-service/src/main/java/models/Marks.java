package models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.immutables.value.Value.Immutable;

import javax.annotation.Nullable;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.UUID;

@JsonSerialize
@JsonDeserialize(as = ImmutableMarks.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@Immutable
public interface Marks {

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
    Integer getMarks();

    /**
     *
     * @return
     */
    @Nullable
    List<UUID> getSubjectIds();

}
