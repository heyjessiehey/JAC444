import java.util.Arrays;
import java.util.List;
import java.util.Comparator;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;
import java.util.stream.Collectors;
import java.util.Optional;

public class StudnetProcess {

    public static void main(String[] args){
        Student[] students = {
                new Student("Jack", "Smith", 50.0, "IT"),
                new Student("Aaron", "Johnson", 76.0, "IT"),
                new Student("Maaria", "White", 35.8, "Business"),
                new Student("John", "White", 47.0, "Media"),
                new Student("Laney", "White", 62.0, "IT"),
                new Student("Jack", "Jones", 32.9, "Business"),
                new Student("Wesley", "Jones", 42.89, "Media")
        };
        List<Student> list = Arrays.asList(students); // creating List Collection

        System.out.println("Task 1: ");
        System.out.println("Complete Student list:");
        // using forEach and reference method to print all list
        list.forEach(System.out::println); System.out.println();

        System.out.println("Task 2: ");
        System.out.println("Students who got 50.0-100.0 sorted by grade:");
        list.stream()
                .filter(l -> l.getGrade() >= 50.0 && l.getGrade() <= 100.0) // lambda
                .sorted(Comparator.comparing(Student::getGrade))
                .collect(Collectors.toList())
                .forEach(System.out::println); System.out.println();

        System.out.println("Task 3: ");
        System.out.println("First Student who got 50.0-100.0:");
        Optional<Student> result = list.stream() // returing value wrapping by Optional method
                .filter(l -> l.getGrade() >= 50.0 && l.getGrade() <= 100.0) //lambda
                .findFirst();
        System.out.println(result.get()); System.out.println(); // unwrapping to get value

        System.out.println("Task 4: ");
        System.out.println("Students in ascending order by last name then first:");
        list.stream()
                .sorted(Comparator.comparing(Student::getLastName).thenComparing(Student::getFirstName))
                .collect(Collectors.toList())
                .forEach(System.out::println); System.out.println();
        System.out.println("Students in descending order by last name then first:");
        list.stream()
                .sorted(Comparator.comparing(Student::getLastName).thenComparing(Student::getFirstName).reversed())
                .collect(Collectors.toList())
                .forEach(System.out::println); System.out.println();

        System.out.println("Task 5: ");
        System.out.println("Unique Student last names:");
        //extract last names only using map
        list.stream()
                .map(Student::getLastName)
                .distinct()
                .sorted()
                .collect(Collectors.toList())
                .forEach(System.out::println);





    }
}
