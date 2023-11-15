package combinatorpattern;

import java.time.LocalDate;
import java.time.Period;
import java.util.function.Function;
import java.util.regex.Pattern;

import static combinatorpattern.CustomerRegistrationValidator.*;
import static combinatorpattern.CustomerRegistrationValidator.ValidationResult.*;

public interface CustomerRegistrationValidator
        extends Function<Customer, ValidationResult> {
    String PHONE_NUMBER_REGEX = "^(\\+\\d{1,4})?\\s?\\d{3}[-\\s]?\\d{3}[-\\s]?\\d{3}$";
    String EMAIL_REGEX = "^(.+)@(\\S+)$";

    static CustomerRegistrationValidator isEmailValid () {
        return  customer -> Pattern.compile(EMAIL_REGEX)
                .matcher(customer.getEmail())
                .matches() ?
                SUCCESS : EMAIL_NOT_VALID;
    }

    static CustomerRegistrationValidator isPhoneNumberValid () {
        return  customer -> Pattern.compile(PHONE_NUMBER_REGEX)
                .matcher(customer.getPhoneNumber())
                .matches() ?
                SUCCESS : PHONE_NUMBER_NOT_VALID;
    }

    static CustomerRegistrationValidator isAnAdult () {
        return  customer ->
                Period.between(customer.getDob(), LocalDate.now()).getYears() > 18 ?
                SUCCESS : IS_NOT_AN_ADULT;
    }

    default CustomerRegistrationValidator and (CustomerRegistrationValidator other) {
        return customer -> {
            ValidationResult result = this.apply(customer);
            return result.equals(SUCCESS) ? other.apply(customer) : result;
        };

    }

    enum ValidationResult {
        SUCCESS,
        PHONE_NUMBER_NOT_VALID,
        EMAIL_NOT_VALID,
        IS_NOT_AN_ADULT
    }
}
