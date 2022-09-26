package io.github.maiconandsilva.equivclasses.utils.requests;

import io.github.maiconandsilva.equivclasses.utils.exceptions.NotFoundException;

import java.util.Optional;

public class RequestErrorHandler {
    public static <T> T getOr404(Optional<T> optionalObject) {
        return optionalObject.orElseThrow(NotFoundException::new);
    }
}
