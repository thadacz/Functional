package functionalinterface;

import java.util.function.BiPredicate;
import java.util.function.Predicate;

public class _Predicate {

    public static void main(String[] args) {
        System.out.println(isPhoneNumberValid("999888777"));
        System.out.println(isPhoneNumberValid("9998887774"));

        System.out.println("With predicate");
        System.out.println(isPhoneNumberValidPredicate.test("999888777"));
        System.out.println(isPhoneNumberValidPredicate.test("9998887774"));
        System.out.println( "Is phone number valid and contains number 7 = " +
                isPhoneNumberValidPredicate.and(containsNumber7).test("999888777"));
        System.out.println( "Is phone number valid and contains number 7 = " +
                isPhoneNumberValidPredicate.and(containsNumber7).test("999888444"));
        System.out.println( "Is phone number valid or contains number 7 = " +
                isPhoneNumberValidPredicate.or(containsNumber7).test("999888444"));

        System.out.println(isPhoneNumberValidAndContainsNumber7BiPredicate.test("999888777","7"));
    }

    static boolean isPhoneNumberValid (String phoneNumber) {
        return phoneNumber.length() == 9;
    }

    static Predicate<String> isPhoneNumberValidPredicate = phoneNumber ->
            phoneNumber.length() == 9;

    static Predicate<String> containsNumber7 = phoneNumber ->
            phoneNumber.contains("7");

    static BiPredicate<String, String> isPhoneNumberValidAndContainsNumber7BiPredicate = (phoneNumber, seven) ->
            phoneNumber.length() == 9 && phoneNumber.contains(seven);

}
