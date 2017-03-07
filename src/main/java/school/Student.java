package school;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

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

    public static Criterion<Student> getSmartnessCriterion(final float threshold) {
//        float mythreshold = threshold - 0.4F;
        return new Criterion<Student>() {

            @Override
            public boolean test(Student s) {
//                float yourthreshold = threshold +2;
                return s.getGpa() > threshold;
            }
        };
    }

    public static Criterion<Student> getEnthusiasmCriterion(int threshold) {
        return new Criterion<Student>() {

            @Override
            public boolean test(Student s) {
                return s.getCourses().size() > threshold;
            }
        };
    }

//    private static StudentCriterion smartnessCriterion = new SmartStudentCriterion();
//    
//    public static StudentCriterion getSmartnessCriterion() {
//        return smartnessCriterion;
//    }
//    
//    private static class SmartStudentCriterion implements StudentCriterion {
//
//        @Override
//        public boolean test(Student s) {
//            return s.getGpa() > 3.0F;
//        }
//    }
    
    public static Comparator<Student> getGpaOrdering() {
        return new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return Float.compare(o1.gpa, o2.gpa);
            }
        };
    }
}
