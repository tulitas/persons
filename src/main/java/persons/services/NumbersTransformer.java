package persons.services;

public class NumbersTransformer {
    private int numFromWeb;
    private int numForWeb;
    private String text;
    private static final String[] belowTwenty = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight",
            "nine", "ten",
            "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"};
    private static final String[] tens = {"hundred", "ten", "twenty", "thirty", "fourty", "fifty", "sixty", "seventy",
            "eighty", "ninety"};

    void transfer() {
        if (getNumFromWeb() < 20) {
//            System.out.println(belowTwenty[getNumFromWeb()]);
            setText(belowTwenty[getNumFromWeb()]);
        } else if (getNumFromWeb() < 100) {
            int hight = getNumFromWeb() / 10;
            int low = getNumFromWeb() % 10;
            text = tens[hight];
            if (low != 0) {
                text = text + " " + belowTwenty[low];
                setText(text);
//                System.out.println(text);
            } else
                System.out.println(tens[0]);
        }
    }

    public int getNumForWeb() {
        return numForWeb;
    }

    public void setNumForWeb(int numForWeb) {
        this.numForWeb = numForWeb;
    }

    private int getNumFromWeb() {
        return numFromWeb;
    }

    void setNumFromWeb(int numFromWeb) {
        this.numFromWeb = numFromWeb;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
