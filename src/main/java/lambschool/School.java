package lambschool;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class ShortStringCriterion implements Criterion<String> {

    @Override
    public boolean test(String s) {
        return s.length() < 7;
    }

}

interface Weird<E> {
    boolean doStuff(E e);
}

public class School {

    public static <E> void doStuff(Criterion<E> ce) {}
    public static <E> void doStuff(Weird<E> ce) {}
    
    public static <E> List<E> getByCriterion(List<E> ls, Criterion<E> criterion) {
        List<E> rv = new ArrayList<>();
        for (E s : ls) {
            if (criterion.test(s)) {
                rv.add(s);
            }
        }
        return rv;
    }

    public static <E> void show(List<E> ls) {
        for (E s : ls) {
            System.out.println(s);
        }
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
        show(school);
        System.out.println("----------very smart:---------");
        show(getByCriterion(school, Student.getSmartnessCriterion(3.6F)));
        System.out.println("----------fairly smart:---------");
        show(getByCriterion(school, Student.getSmartnessCriterion(3.0F)));
        System.out.println("----------enthusiastic:---------");
        show(getByCriterion(school, Student.getEnthusiasmCriterion(2)));
        System.out.println("----------order by gpa ------------");
        school.sort(Student.getGpaOrdering());
        show(school);
        System.out.println("------------ all strings ------------------");
        List<String> strings = Arrays.asList("Fred", "Jim", "Orinoco", "Aeroplane");
        show(strings);
        System.out.println("------------ short strings ------------------");
        Criterion<String> shortCrit = new ShortStringCriterion();
        show(getByCriterion(strings, shortCrit));
        System.out.println("------------ not short strings ------------------");
        show(getByCriterion(strings, Criterion.invert(shortCrit)));

//        Criterion<Student> cs = s->s.length() > 3;
//        doStuff((Weird<Student>)(s->true));

        Criterion<String> firstHalf = s -> s.toUpperCase().charAt(0) <= 'M';
        System.out.println("------------ first half strings ------------------");
        show(getByCriterion(strings, firstHalf));
        System.out.println("------------ short, first half strings ------------------");
//        show(getByCriterion(strings, firstHalf.and(shortCrit)));
        strings = getByCriterion(strings, firstHalf.and(shortCrit));
        strings.replaceAll(s->s.toUpperCase());
        strings.forEach(s->System.out.println(s));


    }
}
