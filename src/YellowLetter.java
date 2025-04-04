public class YellowLetter extends Letter{
    String yellow;
    public YellowLetter(String x){
        super(x);
        yellow="\u001B[43m"+x+reset();
    }

    @Override
    public String toString(){
        return yellow;
    }
}
