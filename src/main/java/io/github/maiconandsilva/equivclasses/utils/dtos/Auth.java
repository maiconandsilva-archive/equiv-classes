package io.github.maiconandsilva.equivclasses.utils.dtos;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Auth {
    private Long courseId;
    private String username;
    private String password;
    private String passwordConfirmation;
}
