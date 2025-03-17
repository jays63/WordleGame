import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Setup {
    private ArrayList<String> wordList;
    private String word;
    private char[][] guesses;

    public Setup(){
        guesses=new char[6][5];
    }

    public void setWORD(){
        wordList =new ArrayList<>();
        try {
            File words=new File("src\\ValidAnswers.txt");
            Scanner sc=new Scanner(words);
            while (sc.hasNext()){
                wordList.add(sc.nextLine());
            }
            word =wordList.get((int)(Math.random()*wordList.size()));
        } catch (IOException exception){
            System.out.println(exception.getMessage());
        }
    }

    public String getWord(){
        return word;
    }
}