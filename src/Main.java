import java.util.Random;
import java.util.ArrayList;


public class Main {
    protected static boolean czyArytmetyczny;
    protected static int a;
    protected static int d;
    protected static int r;

    public static void main(String[] args) {
        Random random = new Random();
        czyArytmetyczny = random.nextBoolean();
        a = random.nextInt(1,10);
        d = random.nextInt(1,5);
        r = random.nextInt(1,5);
        ArrayList truePattern = generojPattern();
        printpattern(truePattern);

    }
    protected static ArrayList<Integer> generojPattern() {
        ArrayList<Integer> pattern = new ArrayList<>(a);
        if (czyArytmetyczny) {
            for (int i = 1; i <= 4; i++) {
               pattern.add(a+(i-1)*d);
            }
        }
        else {
            for (int i = 1; i <= 4; i++) {
                pattern.add((int)Math.round((a*Math.pow(r,i-1))));
            }
        }
        return pattern;
    }

    protected static ArrayList<Integer> generojFake() {
        Random random = new Random();
        ArrayList<Integer> pattern = new ArrayList<>(a);

            for (int i = 1; i <= 4; i++) {
                pattern.add(random.nextInt(1,100));
            }
            return pattern;
        }
    protected static void printpattern(ArrayList<Integer> pattern) {
        for(Integer i: pattern) {
            System.out.println(i);
        }
    }

}