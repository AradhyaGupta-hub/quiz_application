import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Score extends JFrame implements ActionListener {

    JButton submit,cancel;

    Score(String name, int score){
        setBounds(400,150,750,550);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/score.png"));
        Image i2 = i1.getImage().getScaledInstance(300,250,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(30,230,300,250);
        add(image);

        JLabel heading = new JLabel("Thank  you  "+ name+ "  for  playing");
        heading.setBounds(100,50,700,30);
        heading.setFont(new Font("Viner Hand ITC",Font.PLAIN,26));
        heading.setForeground(new Color(13, 27, 42));
        add(heading);

        JLabel subheading = new JLabel("Hope  you  like  this  Quiz ");
        subheading.setBounds(250,100,700,30);
        subheading.setFont(new Font("Viner Hand ITC",Font.PLAIN,26));
        subheading.setForeground(new Color(13, 27, 42));
        add(subheading);


        JLabel lblscore = new JLabel("Your Score is "+ score);
        lblscore.setBounds(400,180,300,30);
        lblscore.setFont(new Font("Mongolian Baiti",Font.BOLD,26));
        add(lblscore);

        submit = new JButton("Play Again");
        submit.setBounds(440,240,120,30);
        submit.setBackground(new Color(96, 175, 255));
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        add(submit);

        cancel = new JButton("Cancel");
        cancel.setBounds(440,280,120,30);
        cancel.setBackground(new Color(96, 175, 255));
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        add(cancel);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        if (ae.getSource() == submit){
            setVisible(false);
            new Login();
        }else {
            setVisible(false);
        }
    }
    public static void main(String[] args) {
        new Score("User",0);
    }
}
