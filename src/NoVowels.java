public class NoVowels extends WordleBase{
    public NoVowels(){
        super();
    }

    @Override
    public void colorLetters(String ans) {
        super.colorLetters(ans);
        for (int i = 0; i < ans.length(); i++) {
            if (ans.substring(i, i+1).equals("a")||ans.substring(i, i+1).equals("e")||ans.substring(i, i+1).equals("i")||ans.substring(i, i+1).equals("o")
            ||ans.substring(i, i+1).equals("u")){
                setCharsIdx(i, "_");
            }
        }
    }
}
