public class Letter {
    private String x;
    private final String ANSI_RESET = "\u001B[0m";
    public Letter (String stored){
        x=stored;
        colorLetter();
    }

    public String colorLetter(){
        return x+ANSI_RESET;
    }

    public String getLetter(){
        return x;
    }
}
