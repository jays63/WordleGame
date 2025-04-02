import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        System.out.println("What mode would you like to play? \n1. Normal game\n2. Dordle (2 boards)\n3. " +
                "The vowels are missing (Vowels will not be colored)");
        int mode=s.nextInt();
        WordleBase play;
        switch (mode){
            case 1:
                play=new NormalGame();
                break;
            case 2:
                play=new Dordle();
                break;
            case 3:
                play=new NoVowels();
        }
    }
}
