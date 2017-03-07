package lambschool;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Student {

    private String name;
    private float gpa;
    private List<String> courses;

    private Student() {
    }

    public int length() { // FAKED for lambda inference investigation!!!
        return courses.size();
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

    public static Criterion<Student> getSmartnessCriterion(final float threshold) {
        return (s) -> {
                return s.getGpa() > threshold;
            };
    }

    public static Criterion<Student> getEnthusiasmCriterion(int threshold) {
        return s -> s.getCourses().size() > threshold;
    }

    public static Comparator<Student> getGpaOrdering() {
        return (o1, o2) -> { return Float.compare(o1.gpa, o2.gpa);};
    }
//    public static Comparator<Student> getGpaOrdering() {
//        return /*new Comparator<Student>() {
//            @Override
//            public int compare*/(/*Student*/ o1, /*Student*/ o2) -> {
//                return Float.compare(o1.gpa, o2.gpa);
//            }
//        /*}*/;
//    }
}
