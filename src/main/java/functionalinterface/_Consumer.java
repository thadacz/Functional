package functionalinterface;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class _Consumer {
    public static void main(String[] args) {

        Customer anna = new Customer("Anna", "999777333");
        // Normal java function
        greetCustomer(anna);
        greetCustomerV2(anna, false);

        // Consumer Functional interface
        greetCustomerConsumer.accept(anna);
        greetBiCustomerConsumer.accept(anna, false);
    }

    static BiConsumer<Customer, Boolean> greetBiCustomerConsumer = (customer, showPhoneNumber) ->
            System.out.println("Hello " + customer.customerName +
                    ", thanks for registering phone number "
                    + (showPhoneNumber ? customer.customerNumber : "*********"));

    static Consumer<Customer> greetCustomerConsumer = customer ->
            System.out.println("Hello " + customer.customerName +
                    ", thanks for registering phone number "
                    + customer.customerNumber);

    static void greetCustomer(Customer customer) {
        System.out.println("Hello " + customer.customerName +
                ", thanks for registering phone number "
                + customer.customerNumber);
    }

    static void greetCustomerV2(Customer customer , boolean showPhoneNumber) {
        System.out.println("Hello " + customer.customerName +
                ", thanks for registering phone number "
                + (showPhoneNumber ? customer.customerNumber : "*********"));

    }

    static class Customer {
        private final String customerName;
        private final String customerNumber;

        public Customer(String customerName, String customerNumber) {
            this.customerName = customerName;
            this.customerNumber = customerNumber;
        }
    }
}
