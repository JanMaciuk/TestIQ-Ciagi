import javax.swing.*;
import java.awt.*;
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
        ArrayList fakePattern = generojFake();
        printpattern(truePattern);
        printpattern(fakePattern);

    }

    public static void createGUI() {
        JFrame mainFrame = new JFrame("Test na ciągi");
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.getContentPane().setLayout(new GridLayout(1, 3));

        //Panel 1
        JPanel panel1 = new JPanel();
        mainFrame.getContentPane().add(panel1);
        panel1.setLayout(new GridLayout(3,4));

        //Panel 2
        JPanel panel2 = new JPanel();
        mainFrame.getContentPane().add(panel2);
        panel2.setLayout(new GridLayout(2,2));

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
        pattern.add(random.nextInt(1,10));
            for (int i = 1; i <= 3; i++) {
                int r = random.nextInt(1,100);
                if (r > pattern.get(pattern.size()-1)) {pattern.add(r);}
                else {
                    i--;
                }

            }
            return pattern;
        }
    protected static void printpattern(ArrayList<Integer> pattern) {
        for(Integer i: pattern) {
            System.out.println(i);
        }
    }

}