package models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.immutables.value.Value.Immutable;

import javax.annotation.Nullable;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@JsonSerialize
@JsonDeserialize(as = ImmutableDepartment.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@Immutable
public interface Department {

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
    String getName();
    
    /**
     *
     * @return
     */
    @NotNull
    College getCollege();
}
