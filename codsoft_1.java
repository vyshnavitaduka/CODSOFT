import java.util.Random;
import java.util.Scanner;
public class codsoft_1 {
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        Random random = new Random();
        boolean PlayAgain=true;
        int totalScore=0;
        while(PlayAgain){
            int numberToGuess=random.nextInt(100)+1;
            int attempts=0;
            boolean guessedCorrectly=false;
            int maxAttempts=10;
            System.out.println("I have chosen a number between 1 and 100.try to guess it !");
            while(attempts<maxAttempts && !guessedCorrectly){
                System.out.print("Enter your guess");
                int userGuess=sc.nextInt();
                attempts++;
                if(userGuess==numberToGuess){
                    guessedCorrectly=true;
                    System.out.println("congratulations! you guessed in" + attempts + "attempts.");
                    totalScore+=(maxAttempts-attempts+1);
                }
                else if(userGuess<numberToGuess){
                    System.out.println("Too low!try again");
                } else {
                    System.out.println("too high! try again");
                }
            }
                if(!guessedCorrectly){
                    System.out.println("you have used all your attempts!The number was:"+numberToGuess);
                }         
            System.out.println("your current score:"+totalScore);
            System.out.println("do you want to play again?(yes/no):");
            String response=sc.next().toLowerCase();
            PlayAgain=response.equals("yes");

        }
        System.out.println("thanks for playing! your final score:"+totalScore);
        sc.close();
    }
}

