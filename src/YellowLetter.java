public class YellowLetter extends Letter{
    public YellowLetter(String x){
        super(x);
    }

    @Override
    public String getLetter(){
        return "\u001B[43m"+super.getLetter();
    }
}
