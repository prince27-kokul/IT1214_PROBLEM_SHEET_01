import java.util.*;

class Student
{
	private String name;
	private int exam1;
	private int exam2;
	private int exam3;
	
	boolean validateMarks(int marks)
	{
		if(marks<=100 && marks>=0)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	Student(String name,int exam1,int exam2,int exam3)
	
	{
		this.name=name;
		
		if(validateMarks(exam1)&&validateMarks(exam2)&&validateMarks(exam3))
		{
			this.exam1=exam1;
			this.exam2=exam2;
			this.exam3=exam3;
		}
		else
		{
			System.out.println("Invalid Marks!");
		}
		
		
	}
		
	String getName()
	{
		return name;
	}
	int getExam1()
	{
		return exam1;
	}
	int getExam2()
	{
		return exam2;
	}
	int getExam3()
	{
		return exam3;
	}
	
	
}

 
 class StudentDemo
 {
	 public static void main(String[] args)
	 {
		 
		 
		Student s1=new Student("Adam",50,60,50);
		
		 
		System.out.println("Name of Student01: "+s1.getName());
		System.out.println("Marks for Exam 01:"+s1.getExam1());
		System.out.println("Marks for Exam 02:"+s1.getExam2());
		System.out.println("Marks for Exam 03:"+s1.getExam3());
		System.out.println();
		   
		Student s2=new Student("john",60,150,90);
		  
		System.out.println("Name of Student02: "+s2.getName());
		System.out.println("Marks for Exam 01:"+s2.getExam1());
		System.out.println("Marks for Exam 02:"+s2.getExam2());
		System.out.println("Marks for Exam 03:"+s2.getExam3());
		 
		 
	 }
 }