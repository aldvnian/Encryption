public class AssignmentTest {
    public static void main(String[] args) {
        //Test1
        String[] store = {"masculine"};
        System.out.println("The encrypted words are:");
        Encrypt.main(store);
        String[] array = {"wending", "uneventfully", "gining", "instantaneously", "telling", 
        "unusually", "whooping", "outclassed", "piper"};
        System.out.println("");
        System.out.println("The decrypted word is:");
        Decrypt.main(array);
        System.out.println("----------------------------------------------");

        //Test2
        String[] store2 = {"tension"};
        System.out.println("The encrypted words are:");
        Encrypt.main(store2);
        String[] array2 = {"carjacking", "dandily", "paring", "typically", "wheelbarrowing", "desegrated", "subcompact"};
        System.out.println("");
        System.out.println("The decrypted word is:");
        Decrypt.main(array2);
        System.out.println("----------------------------------------------");

        //Test3
        String[] store3 = {"gym"};
        System.out.println("The encrypted words are:");
        Encrypt.main(store3);
        String[] array3 = {"consonating", "tenured", "pericallis"};
        System.out.println("");
        System.out.println("The decrypted word is:");
        Decrypt.main(array3);
        System.out.println("----------------------------------------------");

        //Test4
        String[] store4 = {"blockchain"};
        System.out.println("The encrypted words are:");
        Encrypt.main(store4);
        String[] array4 = {"tackling", "yea", "surveiling", "haply", "boosting", "irrationally", "strolling", 
        "listlessly", "aftershafted", "afterpiece"};
        System.out.println("");
        System.out.println("The decrypted word is:");
        Decrypt.main(array4);
        System.out.println("----------------------------------------------");

        //Test5
        String[] store5 = {"cheese"};
        System.out.println("The encrypted words are:");
        Encrypt.main(store5);
        String[] array5 = {"transaminating", "inscrutably", "alienating", "validly", "bankrupt", "nirvana"};
        System.out.println("");
        System.out.println("The decrypted word is:");
        Decrypt.main(array5);
        System.out.println("----------------------------------------------");
    }
}