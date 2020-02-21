package test.java.tests;

public class Del {
    public static void main(String[] args) {
        String str = "+3 8(050)123 456 789";
        String result = str
                .substring(3)
                .replaceAll("[\\(\\) ]", "");

        System.out.println(result);
    }
}
