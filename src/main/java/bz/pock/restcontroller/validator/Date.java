package bz.pock.restcontroller.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


@Constraint(validatedBy = DateValidator.class)
@Target(value = ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Date {

    /**
     * Message.
     */
    String message() default "{validation.date}";

    /**
     * Groups.
     */
    Class<?>[] groups() default {};

    /**
     * Payload.
     */
    Class<? extends Payload>[] payload() default {};
}

