import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        System.out.println("What mode would you like to play? \n1. Normal game\n2. Hard (Vowels will be expunged)");
        int mode=s.nextInt();
        WordleBase play;
        switch (mode){
            case 1:
                play=new NormalGame();
                break;
            case 2:
                play=new NoVowels();
        }
    }
}
