package methrefs;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class Student {

    private String name;
    private float gpa;
    private List<String> courses;

    private Student() {
    }

    public static Student ofNameGpaCourses(String name, float gpa, String... courses) {
        Student self = new Student();
        self.name = name;
        self.gpa = gpa;
        self.courses = Arrays.asList(courses);
        return self;
    }

    public String getName() {
        return name;
    }

    public float getGpa() {
        return gpa;
    }

    public List<String> getCourses() {
        return courses;
    }

    @Override
    public String toString() {
        return "Student{" + "name=" + name + ", gpa=" + gpa + ", courses=" + courses + '}';
    }

    public static Predicate<Student> getSmartnessPredicate(final float threshold) {
        return s -> s.getGpa() > threshold;
    }

    public static Predicate<Student> getEnthusiasmPredicate(int threshold) {
        return s -> s.getCourses().size() > threshold;
    }

    public static Comparator<Student> getGpaOrdering() {
        return (o1, o2) -> Float.compare(o1.gpa, o2.gpa);
    }
}
