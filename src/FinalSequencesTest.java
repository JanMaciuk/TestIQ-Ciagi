import javax.swing.*;
import java.awt.*;
import java.util.Random;
import java.util.ArrayList;


public class FinalSequencesTest {
    protected static Random random = new Random();
    protected static boolean czyArytmetyczny = random.nextBoolean();
    protected static int a = random.nextInt(2,10);
    protected static int d = random.nextInt(2,5);
    protected static int r = random.nextInt(2,5);
    protected static ArrayList<Integer> truePattern = generatePattern();
    protected static ArrayList<Integer> fakePattern1 = generateFake();
    protected static ArrayList<Integer> fakePattern2 = generateFake();
    protected static ArrayList<Integer> fakePattern3 = generateFake();
    protected static int actualNumber = random.nextInt(1,4);
    protected static int choosenNumber = 0;


    public static void main(String[] args) {

        printPattern(truePattern);
        createGUI();

    }

    public static void createGUI() {
        JFrame mainFrame = new JFrame("Test na ciągi");
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JTextField topText = new JTextField("Wybierz odpowiedni ciąg i podaj jego następną liczbę");
        topText.setEditable(false);
        topText.setHorizontalAlignment(JTextField.CENTER);
        mainFrame.getContentPane().add(topText, BorderLayout.PAGE_START);


        JPanel panel = new JPanel();
        mainFrame.getContentPane().add(panel, BorderLayout.CENTER);
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
    //Panel 1:
        JPanel panel1 = new JPanel();
        panel1.setLayout(new GridLayout(4,2));
        panel.add(panel1);

        // Pattern 1
        JTextField numbers1 = new JTextField("Elementy ciągu 1");
        numbers1.setEditable(false);
        panel1.add(numbers1);
        JCheckBox select1 = new JCheckBox("To jest poprawny ciąg");
        panel1.add(select1);
        //Pattern 2
        JTextField numbers2 = new JTextField("Elementy ciągu 2");
        numbers2.setEditable(false);
        panel1.add(numbers2);
        JCheckBox select2 = new JCheckBox("To jest poprawny ciąg");
        panel1.add(select2);
        //Pattern 3
        JTextField numbers3 = new JTextField("Elementy ciągu 3");
        numbers3.setEditable(false);
        panel1.add(numbers3);
        JCheckBox select3 = new JCheckBox("To jest poprawny ciąg");
        panel1.add(select3);
        //Pattern 4
        JTextField numbers4 = new JTextField("Elementy ciągu 4");
        numbers4.setEditable(false);
        panel1.add(numbers4);
        JCheckBox select4 = new JCheckBox("To jest poprawny ciąg");
        panel1.add(select4);
        panel1.setPreferredSize(new Dimension(420, 250));


    //Panel 2:
        JPanel panel2 = new JPanel();
        panel2.setLayout(new GridLayout(1,3));
        panel.add(panel2);

        JTextField nextNumber = new JTextField("Następna liczba");
        panel2.add(nextNumber);
        JCheckBox selectArithmetic = new JCheckBox("Ciąg arytmetyczny");
        panel2.add(selectArithmetic);
        JCheckBox selectGeometric = new JCheckBox("Ciąg geometryczny");
        panel2.add(selectGeometric);


    //Panel 3:
        JPanel panel3 = new JPanel();
        panel.add(panel3);
        JTextField answer = new JTextField("Ciąg arytmetyczny = u+(n-1)d. Ciąg geometryczny = u*r^(n-1)");
        answer.setEditable(false);
        answer.setPreferredSize(new Dimension(420, 50));
        answer.setHorizontalAlignment(JTextField.CENTER);
        panel3.add(answer);



        JButton submit = new JButton("Sprawdź");
        int correctAnswer = truePattern.get(truePattern.size()-1);
        truePattern.remove(truePattern.size()-1);

        mainFrame.getContentPane().add(submit, BorderLayout.PAGE_END);
        mainFrame.setSize(420, 500);
        mainFrame.setVisible(true);
        submit.addActionListener(e -> {
            if (select1.isSelected()) {choosenNumber = 1;}
            else if (select2.isSelected()) {choosenNumber = 2;}
            else if (select3.isSelected()) {choosenNumber = 3;}
            else if (select4.isSelected()) {choosenNumber = 4;}

            boolean isCorrectPattern = (choosenNumber == actualNumber);
            boolean isCorrectType = (czyArytmetyczny == selectArithmetic.isSelected());
            boolean isCorrectNumber = (Integer.parseInt(nextNumber.getText()) == correctAnswer);
            if ((selectArithmetic.isSelected() & selectGeometric.isSelected()) || (!selectArithmetic.isSelected() & !selectGeometric.isSelected())) {
                isCorrectType = false;
            }
            if (isCorrectPattern & isCorrectType & isCorrectNumber) {
                answer.setText("Wszystko poprawnie!");
            } else if (isCorrectType & isCorrectNumber) {
                answer.setText("Wybrałeś źły ciąg, ale podałeś dobry typ i wartość");
            }
            else if (isCorrectPattern & isCorrectNumber) {
                answer.setText("Wybrałeś dobry ciąg i wartość, ale podałeś zły typ");
            }
            else if (isCorrectPattern & isCorrectType) {
                answer.setText("Wybrałeś dobry ciąg, ale podałeś złą wartość");
            }
            else if (isCorrectPattern) {
                answer.setText("Wybrałeś dobry ciąg, ale podałeś zły typ i wartość");
            }
            else if (isCorrectType) {
                answer.setText("Wybrałeś zły ciąg, ale podałeś dobry typ");
            }
            else if (isCorrectNumber) {
                answer.setText("Wybrałeś zły ciąg, ale podałeś dobrą wartość");
            }
            else {
                answer.setText("aj, wszytko źle");
            }

        });


        switch (actualNumber) {
            case 1 -> {
                numbers1.setText(truePattern.toString());
                numbers2.setText(fakePattern1.toString());
                numbers3.setText(fakePattern2.toString());
                numbers4.setText(fakePattern3.toString());
            }
            case 2 -> {
                numbers1.setText(fakePattern1.toString());
                numbers2.setText(truePattern.toString());
                numbers3.setText(fakePattern2.toString());
                numbers4.setText(fakePattern3.toString());
            }
            case 3 -> {
                numbers1.setText(fakePattern1.toString());
                numbers2.setText(fakePattern2.toString());
                numbers3.setText(truePattern.toString());
                numbers4.setText(fakePattern3.toString());
            }
            case 4 -> {
                numbers1.setText(fakePattern1.toString());
                numbers2.setText(fakePattern2.toString());
                numbers3.setText(fakePattern3.toString());
                numbers4.setText(truePattern.toString());
            }
        }

    }

    protected static ArrayList<Integer> generatePattern() {
        ArrayList<Integer> pattern = new ArrayList<>(a);
        if (czyArytmetyczny) {
            for (int i = 1; i <= 5; i++) {
               pattern.add(a+(i-1)*d);
            }
        }
        else {
            for (int i = 1; i <= 5; i++) {
                pattern.add((int)Math.round((a*Math.pow(r,i-1))));
            }
        }
        return pattern;
    }



    protected static ArrayList<Integer> generateFake()  {
        ArrayList<Integer> pattern = new ArrayList<>(a);
        pattern.add(random.nextInt(2,10));
        pattern.add(random.nextInt(pattern.get(0),20));
        pattern.add(random.nextInt(pattern.get(1),50));
        pattern.add(random.nextInt(pattern.get(2),100));
        return pattern;
    }
    protected static void printPattern(ArrayList<Integer> pattern) {
        for(Integer i: pattern) {
            System.out.println(i);
        }
    }

}