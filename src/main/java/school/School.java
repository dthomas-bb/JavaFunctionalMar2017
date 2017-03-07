package school;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

interface StudentCriterion {

    boolean test(Student s);
}

class SmartStudentCriterion implements StudentCriterion {

    @Override
    public boolean test(Student s) {
        return s.getGpa() > 3.0F;
    }
}

public class School {

    public static List<Student> getStudentsByCriterion(List<Student> ls, StudentCriterion criterion) {
        List<Student> rv = new ArrayList<>();
        for (Student s : ls) {
            if (criterion.test(s)) {
                rv.add(s);
            }
        }
        return rv;
    }

//    public static List<Student> getSmartStudents(List<Student> ls, float threshold) {
//        List<Student> rv = new ArrayList<>();
//        for (Student s : ls) {
//            if (s.getGpa() > threshold) {
//                rv.add(s);
//            }
//        }
//        return rv;
//    }
//    
//    public static List<Student> getEnthousiasticStudents(List<Student> ls, int threshold) {
//        List<Student> rv = new ArrayList<>();
//        for (Student s : ls) {
//            if (s.getCourses().size() > threshold) {
//                rv.add(s);
//            }
//        }
//        return rv;
//    }
    public static void show(List<Student> ls) {
        for (Student s : ls) {
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
//        System.out.println("----------smart:---------");
//        show(getSmartStudents(school, 2.8F));
//        System.out.println("----------enthusiastic:---------");
//        show(getEnthousiasticStudents(school, 3));
        System.out.println("----------smart:---------");
        show(getStudentsByCriterion(school, new SmartStudentCriterion()));
    }
}
