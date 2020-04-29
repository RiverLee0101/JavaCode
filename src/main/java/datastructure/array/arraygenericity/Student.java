package datastructure.array.arraygenericity;

public class Student {

    private String name;
    private int score;

    public Student(String studentName, int studentScore) {
        name = studentName;
        score = studentScore;
    }

    @Override
    public String toString(){
        return String.format("Student(name: %s, score: %d)", name, score);
    }

    public static void main(String[] args) {
        ArrayGenericity<Student> arrGen = new ArrayGenericity<>();
        arrGen.addLast(new Student("Alice", 100));
        arrGen.addLast(new Student("Bob", 66));
        arrGen.addLast(new Student("Charlie", 88));
        System.out.println(arrGen);
    }
}
