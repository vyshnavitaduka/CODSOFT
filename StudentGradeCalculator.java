import java.util.Scanner;
public class StudentGradeCalculator{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.print("enter the number of subjects");
        int numSubjects=sc.nextInt();
        int totalMarks=0;
        for(int i=1;i<=numSubjects;i++){
            System.out.print("enter marks for subject "+ i +"(out of 100):");
            int marks=sc.nextInt();
            totalMarks+=marks;
        }
        double average=(double)totalMarks/numSubjects;
        String grade;
        if(average >=90){
            grade = "A";
        }else if(average >=80){
            grade = "B";
        }else if(average >=70){
            grade = "C";
        }else if(average >=60){
            grade = "D";
        }else{
            grade = "F";
        }
        System.out.println("\nTotal marks:"+totalMarks);
        System.out.println("average percentage:"+ average);
        System.out.println("grade:"+ grade);
        sc.close();

    }
}