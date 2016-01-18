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
     *
     * @return the string
     */
    String message() default "{validation.date}";

    /**
     * Groups.
     *
     * @return the class[]
     */
    Class<?>[] groups() default {};

    /**
     * Payload.
     *
     * @return the class<? extends payload>[]
     */
    Class<? extends Payload>[] payload() default {};
}

