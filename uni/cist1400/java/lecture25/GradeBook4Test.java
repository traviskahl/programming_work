public class GradeBook4Test {
    public static void main(String[] args) {
        GradeBook4 gb1 = new GradeBook4("CIST1400: Intro to Comp Prog");
        GradeBook4 gb2 = new GradeBook4("CIST1404: Programming Lab");

        System.out.printf("gb1 course name is: %s\n\n", gb1.getCourseName());
        System.out.printf("gb2 course name is: %s\n\n", gb2.getCourseName());
    }
}