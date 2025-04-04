public class Letter {
    private String x;
    private String ANSI_RESET = "\u001B[0m";
    public Letter (String stored){
        x=stored;
    }

    public String reset(){
        return ANSI_RESET;
    }

    public String toString(){
        return x;
    }
}
