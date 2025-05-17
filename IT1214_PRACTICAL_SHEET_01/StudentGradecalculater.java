import java.util.*;
class Student
{
    private String name;
    private int exam1;
    private int exam2;
    private int exam3;

    public Student(String name, int exam1, int exam2, int exam3) 
	{
        this.name = name;
        setExam1(exam1);
        setExam2(exam2);
        setExam3(exam3);
    }

    private void validateScore(int score) 
	{
        if (score < 0 || score > 100) 
		{
            throw new IllegalArgumentException("Exam scores must be between 0 and 100.");
        }
    }

    public void setExam1(int exam1) 
	{
        validateScore(exam1);
        this.exam1 = exam1;
    }

    public void setExam2(int exam2) 
	{
        validateScore(exam2);
        this.exam2 = exam2;
    }

    public void setExam3(int exam3)
	{
        validateScore(exam3);
        this.exam3 = exam3;
    }

    public String getName() 
	{
        return name;
    }

    public int getExam1() 
	{
        return exam1;
    }

    public int getExam2() 
	{
        return exam2;
    }

    public int getExam3() 
	{
        return exam3;
    }

    public double calculateAverage() 
	{
        return (exam1 + exam2 + exam3) / 3.0;
    }
}
class Main 
{
    public static void main(String[] args) 
	{
        try {
            Student student = new Student("John", 75, 100, 90); // 110 is invalid
            double average = student.calculateAverage();
            System.out.printf("Student: %s, Average Score: %.2f%n", student.getName(), average);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}