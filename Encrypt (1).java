import java.io.IOException;
import java.util.List;
import java.util.ArrayList;

public class Encrypt {
    private WordStore adjectives;
    private WordStore adverbs;
    private WordStore nouns;
    private VerbStore verbs;

    public static void main(String[] args) {
        Encrypt encryptClass = new Encrypt();
        List<String> encrypted = encryptClass.encrypt(args[0]);
        for (String x : encrypted) { //Going through each encrypted word and printing out
            System.out.println(x);
        }
    }

    Encrypt() {
        try { //Initialising all the stores
            this.adjectives = new WordStore("adjectives.txt");
            this.adverbs = new WordStore("adverbs.txt");
            this.nouns = new WordStore("nouns.txt");
            this.verbs = new VerbStore("verbs.txt");
        }
        catch(IOException e) {
            System.out.println(e);
        }
    }

    //Input: String input
    //Purpose: To encrypt each character of input as a word from a certain group
    //Output: ArrayList<String> encryptedList - this contains all the encrypted words
    public List<String> encrypt(String input) {
        ArrayList<String> encryptedList = new ArrayList<String>();
        boolean temp = false;
        for (int x = 0; x < input.length(); x++) { //Goes through each character of input
            char key = input.charAt(x);
            if (x == 0) { //The first character is meant to be converted into a verb
                String verbWord = this.verbs.getRandomItem(key); //Returns a random word associated with key
                encryptedList.add(verbWord);
            }
            else if (x == input.length() - 2) { //The second last character is an adjective
                String adjectiveWord = this.adjectives.getRandomItem(key);
                encryptedList.add(adjectiveWord);
            }
            else if (x == input.length() - 1) { //The last character is a noun
                String nounWord = this.nouns.getRandomItem(key);
                encryptedList.add(nounWord);
            }
            else { //Alternating sequences of adverbs and verbs using the boolean variable temp
                if (!(temp)) {
                    String verbWord = this.adverbs.getRandomItem(key);
                    encryptedList.add(verbWord);
                    temp = true;
                }
                else {
                    String adverbWord = this.verbs.getRandomItem(key);
                    encryptedList.add(adverbWord);
                    temp = false;
                }
            }
        }
        return encryptedList;
    }
}