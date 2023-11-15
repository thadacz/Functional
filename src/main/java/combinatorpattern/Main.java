package combinatorpattern;

import java.time.LocalDate;

import static combinatorpattern.CustomerRegistrationValidator.*;

public class Main {

    public static void main(String[] args) {
        Customer customer = new Customer(
                "Bob",
                "bob@gmail.com",
                "+48 512 223 123",
                LocalDate.of(2000, 3,23)
        );

//        System.out.println(new CustomerValidatorService().isValid(customer));

        // if valid we can store customer in db


        // Using combinator pattern
        ValidationResult result = isEmailValid()
                .and(isPhoneNumberValid())
                .and(isAnAdult())
                .apply(customer);

        System.out.println(result);

        if (result != ValidationResult.SUCCESS) {
            throw new IllegalStateException(result.name());
        }
    }
}
