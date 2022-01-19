import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;

public class MyCalculator extends Frame implements ActionListener{
    TextField outputScreen;
    Panel btnsPanel;

    String btnsString[] = { "1", "2", "3", "+",
            "4", "5", "6", "-",
            "7", "8", "9", "*",
            "C", "0", "=", "/" };

    Button btns[] = new Button[16];

    int num1 = 0, num2 = 0, result = 0;
    char op;

    public MyCalculator() {
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

        try {
            //create the font to use. Specify the size!
            f = Font.createFont(Font.TRUETYPE_FONT, new File("./digital-7.ttf")).deriveFont(40f);
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            //register the font
            ge.registerFont(f);
        } catch (IOException e) {
            e.printStackTrace();
        } catch(FontFormatException e) {
            e.printStackTrace();
        }

        outputScreen.setFont(f);

        f = new Font("Cambria", Font.BOLD, 18);
        btnsPanel.setFont(f);

        for (int i = 0; i < 16; i++) {
            btns[i] = new Button(btnsString[i]);
            btns[i].addActionListener(this);
            btnsPanel.add(btns[i]);
        }

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });
    }

    public void actionPerformed(ActionEvent ae) {
  
        String str = ae.getActionCommand();
        
        if(str.equals("+")) {
         
         op = '+';
         num1 = Integer.parseInt(outputScreen.getText());
         outputScreen.setText("");
        }
        else if(str.equals("-")) {
         op = '-';
         num1 = Integer.parseInt(outputScreen.getText());
         outputScreen.setText("");
        }
        else if(str.equals("*")) {
         op = '*';
         num1 = Integer.parseInt(outputScreen.getText());
         outputScreen.setText("");
        }
        else if(str.equals("/")) {
         op = '/';
         num1 = Integer.parseInt(outputScreen.getText());
         outputScreen.setText("");
        }
        else if(str.equals("=")) {
         
         num2 = Integer.parseInt(outputScreen.getText());
         
         switch(op) {
          
          case '+' : result = num1 + num2;
           break;
          case '-' : result = num1 - num2;
           break;
          case '*' : result = num1 * num2;
           break;
          case '/' : result = num1 / num2;
           break;
         }
         outputScreen.setText(result + "");
         result = 0;
        }
        else if(str.equals("C")) {
         
         outputScreen.setText("");
         num1 = num2 = result = 0;
        }
        else {
         outputScreen.setText(outputScreen.getText() + str);
        }
       }

    public static void main(String[] args) {
        MyCalculator calci = new MyCalculator();
        calci.setTitle("Simple Calculator");
        calci.setSize(250, 300);
        calci.setVisible(true);
    }
}
