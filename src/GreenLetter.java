public class GreenLetter extends Letter{
    public GreenLetter(String x){
        super(x);
    }

    @Override
    public String getLetter(){
        return "\u001B[42m"+super.getLetter();
    }
}
