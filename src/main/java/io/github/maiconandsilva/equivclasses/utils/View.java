package io.github.maiconandsilva.equivclasses.utils;

public interface View {
    interface Minimal {}
    interface ShortEquivalentClass extends Minimal {}
    interface Short extends Minimal {}
    interface ExtendedCourse extends Short {}
    interface Extended extends Short {}
}
