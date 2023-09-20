public class HelloJava {

    public HelloJava(int a, boolean b) {

    }

    public HelloJava(boolean a, int b) {

    }
    
    public static void main(String[] args) {
        if (args.length > 0) {
            for (String arg: args) {
                System.out.println(arg);
            }
        }
    }


}