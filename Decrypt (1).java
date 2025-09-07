import java.io.IOException;

public class Decrypt {

    //Input: String[] args
    //Purpose: To decrypt all the words back into keys
    //Output: Words converted back into keys and stored in password which is then printed out
    public static void main(String[] args) {
        try { //Initialising all the stores
            WordStore adjectives = new WordStore("adjectives.txt");
            WordStore adverbs = new WordStore("adverbs.txt");
            WordStore nouns = new WordStore("nouns.txt");
            VerbStore verbs = new VerbStore("verbs.txt");
            StringBuilder password = new StringBuilder();
            boolean on = false;
            for (int x = 0; x < args.length; x++) { //Going through each word from args
                String currentWord = args[x];
                if (x == 0) { //First word has to be from the VerbStore verbs
                    char key = verbs.wordToKey(currentWord); //Returns the key associated with the word
                    password.append(key);
                }
                else if (x == args.length - 2) { //Second last word has to be from WordStore adjectives
                    char key = adjectives.wordToKey(currentWord);
                    password.append(key);
                }
                else if (x == args.length - 1) { //Last word has to be from WordStore nouns
                    char key = nouns.wordToKey(currentWord);
                    password.append(key);
                }
                else { //Other words are from alternating sequences of adverbs and verbs
                    if (!(on)) {
                        char key = adverbs.wordToKey(currentWord);
                        password.append(key);
                        on = true; //Using a boolean to keep alternating between adverbs and verbs
                    }
                    else {
                        char key = verbs.wordToKey(currentWord);
                        password.append(key);
                        on = false;
                    }
                }
            }
            
            System.out.println(password.toString());
        } catch (IOException e) {
            System.err.println("Error loading word lists: " + e.getMessage());
        }
    }
}
