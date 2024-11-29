import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Quiz extends JFrame implements ActionListener {
    String questions[][] = new String[10][5];
    String answers[][] = new String[10][2];
    String userans[][] = new String[10][1];
    JLabel qno,question;
    JRadioButton opt1,opt2,opt3,opt4;
    JButton next,lifeline,submit;
    ButtonGroup groupoptions;

    public static int timer = 15;
    public static int ans_given = 0;
    public static int count = 0;
    public static int score = 0;


    String name;
    Quiz(String name){
        this.name = name;
        setBounds(50,0,1440,830);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/quiz.jpg"));
        JLabel image = new JLabel(i1);
        image.setBounds(0,0,1440,390);
        add(image);

        qno = new JLabel();
        qno.setBounds(100,450,50,30);
        qno.setFont(new Font("Tahoma",Font.PLAIN,24));
        add(qno);

        question = new JLabel();
        question.setBounds(150,450,900,30);
        question.setFont(new Font("Tahoma",Font.PLAIN,24));
        add(question);

        questions[0][0] = "How many countries are there in the world?";
        questions[0][1] = "199";
        questions[0][2] = "195";
        questions[0][3] = "193";
        questions[0][4] = "205";

        questions[1][0] = "Which planet is known as the Red Planet?";
        questions[1][1] = "Jupiter";
        questions[1][2] = "Venus";
        questions[1][3] = "Mars";
        questions[1][4] = "Mercury";

        questions[2][0] = "Which river is the longest in the world?";
        questions[2][1] = "Amazon";
        questions[2][2] = "Ganga";
        questions[2][3] = "Congo";
        questions[2][4] = "Nile";

        questions[3][0] = "Largest gland in the human body?";
        questions[3][1] = "Pancreas";
        questions[3][2] = "Pituitary gland";
        questions[3][3] = "Liver";
        questions[3][4] = "Pineal gland";

        questions[4][0] = "Largest organ in human body?";
        questions[4][1] = "Heart";
        questions[4][2] = "Brain";
        questions[4][3] = "Stomach";
        questions[4][4] = "Skin";

        questions[5][0] = "Capital of Singapore?";
        questions[5][1] = "New York";
        questions[5][2] = "Singapore";
        questions[5][3] = "Rome";
        questions[5][4] = "Kuala Lump";

        questions[6][0] = "Where can't you buy Coca-Cola?";
        questions[6][1] = "Cuba";
        questions[6][2] = "Angora";
        questions[6][3] = "Iran";
        questions[6][4] = "SouthKorea";

        questions[7][0] = "Which animal is known for having the longest lifespan?";
        questions[7][1] = "Elephant";
        questions[7][2] = "Blue Whale";
        questions[7][3] = "Tortoise";
        questions[7][4] = "Hippopotamus";

        questions[8][0] = "Largest island in the world?";
        questions[8][1] = "Greenland";
        questions[8][2] = "Ireland";
        questions[8][3] = "Madagascar";
        questions[8][4] = "Australia";

        questions[9][0] = "Smallest Country in the world by land area?";
        questions[9][1] = "Vatican City";
        questions[9][2] = "Liechtenstein";
        questions[9][3] = "Maldives";
        questions[9][4] = "Monaco";


        answers[0][1] = "195";
        answers[1][1] = "Mars";
        answers[2][1] = "Nile";
        answers[3][1] = "Liver";
        answers[4][1] = "Skin";
        answers[5][1] = "Singapore";
        answers[6][1] = "Cuba";
        answers[7][1] = "Tortoise";
        answers[8][1] = "Greenland";
        answers[9][1] = "Vatican City";

        opt1 = new JRadioButton();
        opt1.setBounds(170,520,700,30);
        opt1.setBackground(Color.white);
        opt1.setFont(new Font("Dialog",Font.PLAIN,20));
        add(opt1);

        opt2 = new JRadioButton();
        opt2.setBounds(170,560,700,30);
        opt2.setBackground(Color.white);
        opt2.setFont(new Font("Dialog",Font.PLAIN,20));
        add(opt2);

        opt3 = new JRadioButton();
        opt3.setBounds(170,600,700,30);
        opt3.setBackground(Color.white);
        opt3.setFont(new Font("Dialog",Font.PLAIN,20));
        add(opt3);

        opt4 = new JRadioButton();
        opt4.setBounds(170,640,700,30);
        opt4.setBackground(Color.white);
        opt4.setFont(new Font("Dialog",Font.PLAIN,20));
        add(opt4);

        groupoptions = new ButtonGroup();
        groupoptions.add(opt1);
        groupoptions.add(opt2);
        groupoptions.add(opt3);
        groupoptions.add(opt4);

        next = new JButton("Next");
        next.setBounds(1100,550,200,40);
        next.setFont(new Font("Tahoma",Font.PLAIN,22));
        next.setBackground(new Color(30,144,255));
        next.setForeground(Color.WHITE);
        next.addActionListener(this);
        add(next);

        lifeline = new JButton("50-50 LifeLine");
        lifeline.setBounds(1100,630,200,40);
        lifeline.setFont(new Font("Tahoma",Font.PLAIN,22));
        lifeline.setBackground(new Color(30,144,255));
        lifeline.setForeground(Color.WHITE);
        lifeline.addActionListener(this);
        add(lifeline);

        submit = new JButton("Submit");
        submit.setBounds(1100,710,200,40);
        submit.setFont(new Font("Tahoma",Font.PLAIN,22));
        submit.setBackground(new Color(30,144,255));
        submit.setForeground(Color.WHITE);
        submit.setEnabled(false);
        submit.addActionListener(this);
        add(submit);

        start(count);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        if (ae.getSource() == next){
            repaint();
            opt1.setEnabled(true);
            opt2.setEnabled(true);
            opt3.setEnabled(true);
            opt4.setEnabled(true);

            ans_given = 1;
            if (groupoptions.getSelection() == null){
                userans[count][0] ="";
            }else {
                userans[count][0] =groupoptions.getSelection().getActionCommand();
            }
            if (count == 8){
                next.setEnabled(false);
                submit.setEnabled(true);
            }

            count++;
            start(count);
        } else if (ae.getSource() == lifeline) {
            if(count==2 || count==4 || count==6 || count==8 || count==9){
                opt2.setEnabled(false);
                opt3.setEnabled(false);
            }else {
                opt1.setEnabled(false);
                opt4.setEnabled(false);
            }
            lifeline.setEnabled(false);
        }else {
            ans_given = 1;
            if (groupoptions.getSelection() == null){
                userans[count][0] ="";
            }else {
                userans[count][0] =groupoptions.getSelection().getActionCommand();
            }
            for (int i=0; i<userans.length; i++){
                if(userans[i][0].equals(answers[i][1])){
                    score += 10;
                }
            }
            setVisible(false);
            new Score(name,score);
        }
    }

    public void paint(Graphics g){
        super.paint(g);

        String time = "Time Left : " + timer + " seconds";
        g.setColor(Color.RED);
        g.setFont(new Font("Tahoma",Font.BOLD,20));

        if(timer > 0){
            g.drawString(time,1100,500);
        }else {
            g.drawString("Times Up ",1100,500);
        }
        timer--;

        try{
            Thread.sleep(1000);
            repaint();
        }catch (Exception e){
            e.printStackTrace();
        }

        if (ans_given == 1){
            ans_given = 0;
            timer = 15;
        } else if (timer < 0) {
            timer = 15;

            opt1.setEnabled(true);
            opt2.setEnabled(true);
            opt3.setEnabled(true);
            opt4.setEnabled(true);

            if (count == 8){
                next.setEnabled(false);
                submit.setEnabled(true);
            }
            if (count == 9){
                if (groupoptions.getSelection() == null){
                    userans[count][0] ="";
                }else {
                    userans[count][0] =groupoptions.getSelection().getActionCommand();
                }
                for (int i=0; i<userans.length; i++){
                    if(userans[i][0].equals(answers[i][1])){
                        score += 10;
                    }
                }
                setVisible(false);
                new Score(name,score);
            }else {
                if (groupoptions.getSelection() == null){
                    userans[count][0] ="";
                }else {
                    userans[count][0] =groupoptions.getSelection().getActionCommand();
                }
                count++;
                start(count);
            }


        }
    }
    public void start(int count){
        qno.setText(""+(count+1)+".");
        question.setText(questions[count][0]);
        opt1.setText(questions[count][1]);
        opt1.setActionCommand(questions[count][1]);
        opt2.setText(questions[count][2]);
        opt2.setActionCommand(questions[count][2]);
        opt3.setText(questions[count][3]);
        opt3.setActionCommand(questions[count][3]);
        opt4.setText(questions[count][4]);
        opt4.setActionCommand(questions[count][4]);

        groupoptions.clearSelection();
    }



    public static void main(String[] args) {
        new Quiz("User");
    }
}
