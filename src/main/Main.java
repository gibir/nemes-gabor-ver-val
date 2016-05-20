package main;

public class Main {

    public static void main(String[] args) {
	    if(endsWithStr(args[1])) {
            System.out.println("The entered string ends with \"str\"");
        } else {
            System.out.println("The entered string doesn't end with \"str\"");
        }
    }

    public static boolean endsWithStr(String value) {
        return value.toLowerCase().endsWith("str");
    }
}
