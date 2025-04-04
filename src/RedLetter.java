public class RedLetter extends Letter{
    String red;
    public RedLetter(String x){
        super(x);
        red="\u001B[41m"+x+reset();
    }

    @Override
    public String toString(){
        return red;
    }
}
