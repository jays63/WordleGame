import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public abstract class WordleBase {
    private WordSelect game;
    private String[][] chars=new String[6][5];
    private Scanner sc;
    private ArrayList<String> validWords;
    private int guess;
    private final String ANSI_RESET = "\u001B[0m";
    private final String ANSI_BLACK_BACKGROUND = "\u001B[40m";
    private final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";
    private final String ANSI_GREEN_BACKGROUND = "\u001B[42m";

    public WordleBase(){
        game=new WordSelect();
        for (int i = 0; i < chars.length; i++) {
            for (int j = 0; j < chars[0].length; j++) {
                chars[i][j]="_";
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
        guess();
    }

    public void guess(){
        for (int i = 0; i < chars.length; i++) {
            for (int j = 0; j < chars[0].length; j++) {
                System.out.print(chars[i][j]);
            }
            System.out.println();
        }
        if (this.guess==6){
            System.out.println("You have lost the game! The correct word was "+game.getAnswer());
            System.exit(0);
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
        for (int i = 0; i < chars[guess].length; i++) {
            chars[guess][i]=ans.substring(i, i+1);
        }
        colorLetters(ans);
        guess++;
        if (ans.equals(game.getAnswer())){
            for (int i = 0; i < chars.length; i++) {
                for (int j = 0; j < chars[0].length; j++) {
                    System.out.print(chars[i][j]);
                }
                System.out.println();
            }
            System.out.println("Congratulations, you won in "+guess+" guesses!");
            System.exit(0);
        }
        guess();
    }

    public void colorLetters(String ans){
        for (int i = 0; i < ans.length(); i++) {
            if (chars[guess][i].equals(game.getAnswer().substring(i, i+1))){
                String green=ANSI_GREEN_BACKGROUND+chars[guess][i]+ANSI_RESET;
                chars[guess][i]=green;
            } else if (game.getAnswer().contains(chars[guess][i])) {
                String yellow=ANSI_YELLOW_BACKGROUND+chars[guess][i]+ANSI_RESET;
                chars[guess][i]=yellow;
            } else {
                String black=ANSI_BLACK_BACKGROUND+chars[guess][i]+ANSI_RESET;
                chars[guess][i]=black;
            }
        }
    }

    public void setCharsIdx(int col, String input){
        chars[guess][col]=input;
    }
}