import java.util.*;
public class number {
    @SuppressWarnings("resource")
    public static void numbergame() {
        Scanner sc=new Scanner(System.in);
        int number = 1 + (int)(100 * Math.random());
        int L=3;
        int i;
        int guess;
        System.out.println("Number ranges from 1 to 100");
        for(i=0;i<L;i++){
            System.out.print("Guess the number:");
            guess=sc.nextInt();
            if(number==guess){
                System.out.println("Correct guess");
                break;
            }
            else if(number>guess){
                System.out.println("The target number is greater than guessed number");
            }
            else if(number<guess){
                System.out.println("The target number is less than guessed number");
            }
        }
        if(i==L){
            System.out.println("You have exhausted 3 trials");
            System.out.println("The number was"+" "+number);
        }
    }
        public static void main(String[] args) {
            numbergame();
        }
    }
