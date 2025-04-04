public class GreenLetter extends Letter{
    String green;
    public GreenLetter(String x){
        super(x);
        green="\u001B[42m"+x+reset();
    }

    @Override
    public String toString(){
        return green;
    }
}
