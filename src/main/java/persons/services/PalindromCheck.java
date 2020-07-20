package persons.services;



public  class PalindromCheck {


    private String resultPalindrom;


   public void chekWord(String word) {
        String clean = word.replaceAll("\\s+", "").toLowerCase();
        recursivePalindrome(clean, 0, clean.length() - 1);
    }

    private boolean recursivePalindrome(String text, int forward, int backward) {
        if (forward == backward) {
            setResultPalindrom("Palindrome");
            return true;
        }
        if ((text.charAt(forward)) != (text.charAt(backward))) {
            setResultPalindrom("Not palindrome");
            return false;
        }
        if (forward < backward + 1) {
            return recursivePalindrome(text, forward + 1, backward - 1);
        }

        return true;


    }

    public String getResultPalindrom() {
        return resultPalindrom;
    }

    private void setResultPalindrom(String resultPalindrom) {
        this.resultPalindrom = resultPalindrom;
    }



    @Override
    public String toString() {
        return "PalindromCheck{" +
                "resultPalindrom='" + resultPalindrom + '\'' +
                ", resultNoPalindrome='"  + '\'' +
                '}';
    }
}
