package bz.pock.restcontroller.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DateValidator implements ConstraintValidator<Date, String> {

    /**
     * The Constant DATE_PATTERN.
     */
    private static final Pattern DATE_PATTERN = Pattern.compile("^(\\d{4})-(\\d{2})-(\\d{2})$");

    /**
     * The Constant MONTHS.
     */
    private static final int MONTHS = 0x15AA;

    @Override
    public void initialize(Date constraintAnnotation) {
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null || value.trim().isEmpty()) {
            return true;
        }
        final Matcher m = DATE_PATTERN.matcher(value);
        return m.find() && validate(Integer.parseInt(m.group(1)), Integer.parseInt(m.group(2)), Integer.parseInt(m.group(3)));

    }

    /**
     * Validate.
     *
     * @param day   the day
     * @param month the month
     * @param year  the year
     * @return true, if successful
     */
    protected boolean validate(int day, int month, int year) {
        int maxDay = 31;

        if (year <= 1970 || year >= 2037) {
            return false;
        }
        if (month > 12 || month <= 0) {
            return false;
        }
        if ((MONTHS & (1 << month)) == 0) {
            maxDay = 30;
        }
        if (month == 2) {
            if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {
                maxDay = 29;
            } else {
                maxDay = 28;
            }
        }
        return day > 0 && day <= maxDay;
    }
}
