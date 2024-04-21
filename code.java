import java.util.*;
public class code {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int Chemistry,Physics,Mathematics,English;
        //taking input serial wise
        do{
            System.out.println("Enter marks of Chemistry (out of 100)");
            Chemistry=sc.nextInt();
        }while(Chemistry<0 || Chemistry>100);
        
        //taking input of subject2
        do{
            System.out.println("Enter marks of Physics (out of 100)");
            Physics=sc.nextInt();
        } while(Physics<0 || Physics>100);
        //taking input from subject 3,4 and 5
        do{
            System.out.println("Enter marks of Mathematics(out of 100)");
            Mathematics=sc.nextInt();
        }while(Mathematics<0 || Mathematics>100);
        //
        do{
            System.out.println("Enter marks of English(out of 100)");
            English=sc.nextInt();
        }while (English<0 || English>100);
        //summing all marks 
        int totalmarks=Chemistry+Physics+Mathematics+English;
        //using float for accurate division
        float percentage=(float) totalmarks/400 *100;
        char grade;
        if(percentage>=90){
            grade='S';
        }else if(percentage>=80){
            grade='A';
        }else if(percentage>=70){
            grade='B';
        }else if(percentage>=60){
            grade='C';
        }else if(percentage>=50){
            grade='D';
        }else{
            grade='F';
        }
        System.out.println("Total Marks are:"+totalmarks+" " +("out of 400"));
        System.out.println("Percentage is:"+percentage+"%");
        System.out.println("Grade obtained is:"+grade);
        //for preventing resource leak close method is preferred
        sc.close();
}
}