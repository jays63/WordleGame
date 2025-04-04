public class BlackLetter extends Letter{
    public BlackLetter(String x){
        super(x);
    }

    @Override
    public String getLetter(){
        return "\u001B[40m"+super.getLetter();
    }
}
