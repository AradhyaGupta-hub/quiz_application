import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Rules extends JFrame implements ActionListener{

    String name;
    JButton back,start;
    Rules(String name){

        this.name = name;
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel heading = new JLabel("Welcome  "+name+"  to  Simple  Minds");
        heading.setBounds(50,20,700,30);
        heading.setFont(new Font("Viner Hand ITC",Font.BOLD,28));
        heading.setForeground(new Color(30,144,254));
        add(heading);

        JLabel subheading = new JLabel("Read  the  rules  very  carefully  before  starting");
        subheading.setBounds(50,90,700,30);
        subheading.setFont(new Font("Viner Hand ITC",Font.BOLD,28));
        subheading.setForeground(new Color(30,144,254));
        add(subheading);

        JLabel rules = new JLabel();
        rules.setBounds(20,160,700,350);
        rules.setFont(new Font("Tahoma",Font.PLAIN,16));
        rules.setText(
                "<html>"+
                        "1. There are 10 Questions in total." + "<br><br>" +
                        "2. For every question you will get 15 seconds." + "<br><br>" +
                        "3. For every correct answer you will get 10 points." + "<br><br>" +
                        "4. There will be a lifeline called 50-50 which you can use only once." + "<br><br>" +
                        "5. If you know the answer,click the answer and then press Next Button to go to next question. " + "<br><br>" +
                        "6. After go to the next question you can not go back to previous one. " + "<br><br>" +
                        "7. In the last(10) question you can submit the quiz. " + "<br><br>" +
                        "8. If you accidentally entered the wrong name, you can press back button." + "<br><br>" +
                        "9. If you like the Quiz make sure to say nice quiz to Aradhya." + "<br><br>" +
                        "<html>"

        );
        add(rules);

        back = new JButton("Back");
        back.setBounds(250,550,100,30);
        back.setBackground(new Color(128, 147, 241));
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);

        start = new JButton("Start");
        start.setBounds(400,550,100,30);
        start.setBackground(new Color(128, 147, 241));
        start.setForeground(Color.WHITE);
        start.addActionListener(this);
        add(start);




        setSize(800,650);
        setLocation(350,100);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == start){
            setVisible(false);
            new Quiz(name);
        }else {
            setVisible(false);
            new Login();
        }
    }


    public static void main(String[] args) {
        new Rules("User");
    }
}
