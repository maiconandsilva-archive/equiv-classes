package io.github.maiconandsilva.equivclasses.data.entities;

import com.fasterxml.jackson.annotation.JsonView;
import io.github.maiconandsilva.equivclasses.utils.View;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Course extends BaseEntity<Long> {

    @NotNull
    @NotBlank
    @JsonView(View.Short.class)
    private String code;

    @NotNull
    @NotBlank
    @JsonView(View.Short.class)
    private String name;
}
