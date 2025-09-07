import java.util.HashMap;
import java.util.ArrayList;
import java.util.Random;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;

public class WordStore {
    private HashMap<Character, LinkedList> map;   //Contains key-value pairs where values are linked lists

    public WordStore() {   //Without file input
        this.map = new HashMap<>();
    }

    //Input: String filename
    //Purpose: Load the file and read the values into the hashmap along with the keys
    //Output: Hashmap with values stored in key-value pairs
    public WordStore(String filename) throws IOException {   //With file input
        this.map = new HashMap<>();
        BufferedReader br = new BufferedReader(new FileReader(filename));  //Loading file
        String newLine = "";
        String temp = "";
        while ((newLine = br.readLine()) != null){  //Read while next line exists
            int length = newLine.length();
            for (int x = 0; x < length-1; x++) {  //Looping through the line
                char chr = newLine.charAt(x);
                if (!(chr == ',')) {
                    temp = temp + chr;  //Loading the characters of the word into temp
                }
                else {
                    this.add(newLine.charAt(x+1), temp);
                    temp = "";
                }

            }
        }
        br.close();
    }

    //Input: char key, String item
    //Purpose: Add the key and item in the hashmap as a pair
    //Output: Value and key added to the hashmap
    public void add(char key, String item) {
        if (!(this.map.containsKey(key))) {
            Node newNode = new Node(item, null);
            LinkedList newList = new LinkedList(newNode);
            this.map.put(key, newList);
        }
        else {
            LinkedList currentList = this.map.get(key);
            Node newNode = new Node(item);
            currentList.insert(newNode);
        }
        
    }

    //Input: char key
    //Purpose: Return a random word associated with given key
    //Output: Random word of key/null
    public String getRandomItem(char key) {
        if (this.map.containsKey(key)) {
            LinkedList currentLinkedList = this.map.get(key);  //Getting the linked list
            ArrayList<String> allItems = currentLinkedList.getAll();
            Random rand = new Random();
            int index = rand.nextInt(allItems.size());  //Getting random index
            String retrievedString = allItems.get(index); 
            return retrievedString;
        }
        else {
            return null;
        }
    }

    //Input: char key, String word
    //Purpose: To check if the word is associated with given key
    //Output: true/false
    public boolean isWordInKey(char key, String word) {
        LinkedList tempList = this.map.get(key);
        ArrayList<String> tempArray = tempList.getAll();
        if (tempArray.contains(word)) {
            return true;
        }
        return false;
    }

    //Input: String word
    //Purpose: Decrypt the given word back into key
    //Output: Character key/'0'
    public char wordToKey(String word) {
        String chars = "abcdefghijklmnopqrstuvwxyz";
        for (int x = 0; x < 26; x++) {  //Looping through all possible key letters
            char character = chars.charAt(x);
            if (this.map.containsKey(character)) {
                boolean doesContain = this.isWordInKey(character, word);  //Checking if word is associated with key
                if (doesContain) {
                    return character;
                }
            }
        }
        return '0';  //Word doesn't belong to any key
    }
}