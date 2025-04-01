import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class WordSelect {
    private ArrayList<String> wordList;
    private String answer;

    public WordSelect(){
        setWORD();
    }

    public void setWORD(){
        wordList =new ArrayList<>();
        try {
            File words=new File("src\\ValidAnswers.txt");
            Scanner sc=new Scanner(words);
            while (sc.hasNext()){
                wordList.add(sc.nextLine());
            }
            answer=wordList.get((int)(Math.random()*wordList.size()));
        } catch (IOException exception){
            System.out.println(exception.getMessage());
        }
    }

    public String getAnswer(){
        return answer;
    }
}