package imperative;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import static imperative.Main.Gender.FEMALE;

public class Main {
    public static void main(String[] args) {
        List<Person> people = List.of(
                new Person("Natalie", FEMALE),
                new Person("Anna", FEMALE),
                new Person("Max", Gender.MALE),
                new Person("Alex", Gender.MALE),
                new Person("Jessica", FEMALE),
                new Person("John", Gender.MALE)
        );

        System.out.println("Imperative approach");
        // Imperative approach
        List <Person> women = new ArrayList<>();

        for (Person person : people){
            if (FEMALE.equals(person.gender))
                women.add(person);
        }

        for (Person woman : women){
            System.out.println(woman);
        }

        System.out.println("Declarative approach");
        // Declarative approach

        Predicate<Person> personPredicate = person -> FEMALE.equals(person.gender);

        List<Person> women2 = people.stream()
                .filter(personPredicate)
                .toList();

        women2.forEach(System.out::println);
    }

    static class Person {
        private final String name;
        private final Gender gender;

        public Person(String name, Gender gender) {
            this.name = name;
            this.gender = gender;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", gender=" + gender +
                    '}';
        }
    }

    enum Gender {
        MALE, FEMALE
    }
}
