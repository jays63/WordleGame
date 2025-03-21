import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Play {
    private Setup game;
    private char[][] chars=new char[6][5];
    private Scanner sc;
    private ArrayList<String> validWords;
    private int guess;
    private ArrayList<Character> ansAsArr;
    private final String ANSI_RESET = "\u001B[0m";
    private final String ANSI_BLACK_BACKGROUND = "\\u001B[40m";
    private final String ANSI_YELLOW_BACKGROUND = "\\u001B[43m";
    private final String ANSI_GREEN_BACKGROUND = "\\u001B[42m";

    public Play(){
        game=new Setup();
        for (int i = 0; i < chars.length; i++) {
            for (int j = 0; j < chars[0].length; j++) {
                chars[i][j]='_';
            }
        }
        sc=new Scanner(System.in);
        validWords=new ArrayList<>();
        try {
            File words=new File("src\\WordList.txt");
            Scanner sc=new Scanner(words);
            while (sc.hasNext()){
                validWords.add(sc.nextLine());
            }
        } catch (IOException exception){
            System.out.println(exception.getMessage());
        }
        guess=0;
        for (int i = 0; i < game.getAnswer().length(); i++) {
            ansAsArr.add(game.getAnswer().charAt(i));
        }
    }

    public void guess(){
        if (guess==6){
            System.out.println("You have lost the game! The correct word was "+game.getAnswer());
            System.exit(0);
        }
        for (int i = 0; i < chars.length; i++) {
            for (int j = 0; j < chars[0].length; j++) {
                System.out.print(chars[i][j]);
            }
            System.out.println();
        }
        boolean valid=false;
        String ans="";
        while (!valid){
            System.out.print("Enter a guess: ");
            ans=sc.nextLine();
            if (validWords.contains(ans))
                valid=true;
            else System.out.println("Not an accepted word.");
        }
        for (int i = 0; i < chars[0].length; i++) {
            chars[guess][i]=ans.charAt(i);
        }
        guess++;
        colorLetters();
    }

    public void colorLetters(){
        for (int i = 0; i < chars[0].length; i++) {
            if (chars[guess][i]==(ansAsArr.indexOf(i))){
                String green=ANSI_GREEN_BACKGROUND+chars[guess][i]+ANSI_RESET;
                chars[guess][i]=green.charAt(0);
            } else if (ansAsArr.contains(chars[guess][i])) {
                String yellow =ANSI_YELLOW_BACKGROUND+chars[guess][i]+ANSI_RESET;
                chars[guess][i]= yellow.charAt(0);
            } else {
                String black =ANSI_BLACK_BACKGROUND+chars[guess][i]+ANSI_RESET;
                chars[guess][i]= black.charAt(0);
            }
        }
    }
}