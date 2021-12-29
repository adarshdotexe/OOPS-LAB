import java.awt.*;

public class MyCalculator extends Frame {
    TextField outputScreen;
    Panel btnsPanel;

    String btnsString[] = { "1", "2", "3", "+",
            "4", "5", "6", "-",
            "7", "8", "9", "*",
            "C", "0", "=", "/" };

    Button btns[] = new Button[16];

    MyCalculator() {
        outputScreen = new TextField(10);
        outputScreen.setEditable(false);
        outputScreen.setEnabled(false);
        btnsPanel = new Panel();

        add(outputScreen, "North");
        add(btnsPanel, "Center");
        btnsPanel.setLayout(new GridLayout(4, 4));

        Color black = new Color(0, 0, 0);
        Color white = new Color(255, 255, 255);
        Color grey = new Color(33, 33, 33);
        Color green = new Color(57, 255, 20);

        btnsPanel.setBackground(grey);
        btnsPanel.setForeground(white);
        outputScreen.setForeground(green);
        outputScreen.setBackground(black);

        Font f = new Font("Digital-7", Font.PLAIN, 20);
        outputScreen.setFont(f);

        f = new Font("Cambria", Font.BOLD, 18);
        btnsPanel.setFont(f);

        for (int i = 0; i < 16; i++) {
            btns[i] = new Button(btnsString[i]);
            btnsPanel.add(btns[i]);
        }
    }

    public static void main(String[] args) {
        MyCalculator calci = new MyCalculator();
        calci.setTitle("Simple Calculator");
        calci.setSize(250, 300);
        calci.setVisible(true);
    }
}
