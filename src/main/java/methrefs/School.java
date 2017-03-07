package methrefs;

import lambschool.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import static lambschool.School.getByCriterion;

class ShortStringPredicate implements Predicate<String> {

    @Override
    public boolean test(String s) {
        return s.length() < 7;
    }

}

public class School {

    public static <E> void doStuff(Predicate<E> ce) {}
    
    public static <E> List<E> getByPredicate(List<E> ls, Predicate<E> criterion) {
        List<E> rv = new ArrayList<>();
        for (E s : ls) {
            if (criterion.test(s)) {
                rv.add(s);
            }
        }
        return rv;
    }

    public static void main(String[] args) {
        List<Student> school = Arrays.asList(
                Student.ofNameGpaCourses("Fred", 2.7F, "Art", "History", "Journalism"),
                Student.ofNameGpaCourses("Wendy", 3.2F, "Art", "History", "Journalism"),
                Student.ofNameGpaCourses("Jim", 3.7F, "Math", "Physics"),
                Student.ofNameGpaCourses("Alison", 3.8F, "Math", "Physics", "Organic Chemistry", "Astronomy"),
                Student.ofNameGpaCourses("Jeremy", 3.2F, "Math", "Statistics", "Mechanics of Solids"),
                Student.ofNameGpaCourses("Melissa", 2.7F, "Art", "History"),
                Student.ofNameGpaCourses("Sheila", 3.9F, "Engineering", "Tribology", "Statistics", "Astronomy")
        );
        school.forEach(System.out::println);
        System.out.println("----------very smart:---------");
        getByPredicate(school, Student.getSmartnessPredicate(3.6F)).forEach(System.out::println);
        System.out.println("----------fairly smart:---------");
        getByPredicate(school, Student.getSmartnessPredicate(3.0F)).forEach(System.out::println);
        System.out.println("----------enthusiastic:---------");
        getByPredicate(school, Student.getEnthusiasmPredicate(2)).forEach(System.out::println);
        System.out.println("----------order by gpa ------------");
        school.sort(Student.getGpaOrdering());
        school.forEach(System.out::println);
        System.out.println("------------ all strings ------------------");
        List<String> strings = Arrays.asList("Fred", "Jim", "Orinoco", "Aeroplane");
        strings.forEach(System.out::println);
        System.out.println("------------ short strings ------------------");
        Predicate<String> shortCrit = new ShortStringPredicate();
        getByPredicate(strings, shortCrit).forEach(System.out::println);
        System.out.println("------------ not short strings ------------------");
        getByPredicate(strings, shortCrit.negate()).forEach(System.out::println);

        Predicate<String> firstHalf = s -> s.toUpperCase().charAt(0) <= 'M';
        System.out.println("------------ first half strings ------------------");
        getByPredicate(strings, firstHalf).forEach(System.out::println);
        System.out.println("------------ short, first half strings ------------------");
        strings = getByPredicate(strings, firstHalf.and(shortCrit));
        strings.replaceAll(s->s.toUpperCase());
        strings.forEach(s->System.out.println(s));
    }
}
