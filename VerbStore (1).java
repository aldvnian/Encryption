import java.io.IOException;

public class VerbStore extends WordStore {

    VerbStore() {
        super();  //Calling and inheriting parent class 
    }

    VerbStore(String filename) throws IOException  {
        super(filename);  //Passing in filename and letting parent class do the work
    }

    //Input: key, item
    //Purpose: Convert verbs into present continuous and adding them in
    //Output: Verbs added to hashmap as present continuous
    public void add(char key, String item) {
        int length = item.length();
        String temp = "";
        if (item.charAt(length - 1) == 'e') {
            temp = item.substring(0, length - 1);
        }
        else {
            temp = item.substring(0, length);
        }
        temp = temp + "ing";
        super.add(key, temp);
    }
}
