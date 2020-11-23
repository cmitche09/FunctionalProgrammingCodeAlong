package imperative;


import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Person> people = List.of(
                new Person("John", Gender.MALE),
                new Person("Maria", Gender.FEMALE),
                new Person("Aisha", Gender.FEMALE),
                new Person("Alex", Gender.MALE),
                new Person("Alice", Gender.FEMALE)
        );
        System.out.println("// Imperative Approach");
        // Imperative Approach
        List<Person> females = new ArrayList<>();

        for (Person person: people) {
            if(person.gender == Gender.FEMALE){
                females.add(person);
            }
        }

        for (Person female: females) {
            System.out.println(female);
        }

        System.out.println("// Declarative Approach");
        // Declarative approach

        Predicate<Person> personPredicate = person -> Gender.FEMALE.equals(person.gender);

        List<Person> females2 = people.stream()// stream() -> goes into abstract mode
                .filter(person -> person.gender == Gender.FEMALE)
                .collect(Collectors.toList());
//                .forEach(System.out::println);
        females2.forEach(System.out::println);

    }

    static class Person{
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
