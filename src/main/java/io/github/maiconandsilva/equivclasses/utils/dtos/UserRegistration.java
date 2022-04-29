package io.github.maiconandsilva.equivclasses.utils.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserRegistration {
    private Long courseId;
    private String username;
    private String password;
    private String passwordConfirmation;
}
