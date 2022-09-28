import java.util.Scanner;

public class Main {

    // Class Vote
    public static class Vote {
        private String name;
        private int age;
        private String generation;
        private Boolean canVote;
        public Vote(String nameInput, int ageInput){ //constructor
            name = nameInput;
            age = ageInput;
            generation = setGeneration(ageInput);
            canVote = setCanVote(ageInput);
        }

        public String setGeneration(int age){
            if (age < 18){
                canVote = false;
            }
            if (age < 20){
                return "iKid";
            }else if (age < 40){
                return "millennial";
            }else if (age < 60){
                return "generation X";
            }else if (age < 80){
                return "baby boomers";
            }else{
                return "greatest generation";
            }
        }

        public Boolean setCanVote(int age){
            if (age < 18){
                return false;
            }else{
                return true;
            }
        }

    }


    public static void main(String[] args)
    {
        // Print Hello World
        System.out.println("Hello world!");

        // Array of 10 ints and Print Sum
        int[] myArray = {1,2,3,4,5,6,7,8,9,10};
        int sumInt = 0;
        for (int i = 0; i < myArray.length; i++){
            System.out.println(myArray[i]+" ");
            sumInt += myArray[i];
        }
        System.out.println("Sum of numbers in myArray:" + sumInt);

        // Vote and Generation
        System.out.println("Enter your name and age:");

        Scanner s = new Scanner (System.in);    // read input
        String nameInput = s.next();
        int ageInput = s.nextInt();

        Vote myVote = new Vote (nameInput, ageInput); // create object constructor

        System.out.println("Vote? " + myVote.canVote);
        System.out.println("Generation? " + myVote.generation);
    }
}