package CadenzaWork2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class MathGame {
    public static void main(String[] args) {
        loadingPage load = new loadingPage();
        GameMenu menu = new GameMenu();
    }
}

class loadingPage extends  JFrame{

    JProgressBar proBar;

    public loadingPage(){
        setTitle("Game With Math");
        setBounds(450,25,900,600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        //set frame icon as cadenza logo
        ImageIcon logo = new ImageIcon("Cadenzalogo.jpg");
        setIconImage(logo.getImage());

        //set a background image
        JLabel backImg = new JLabel();
        backImg.setIcon(new ImageIcon("loadingpagebg.jpg"));
        add(backImg);

        //set 'loading' word on background
        JLabel loadingWord = new JLabel("Loding....");
        loadingWord.setBounds(0,450,200,50);
        loadingWord.setFont( new Font("MV Boli",Font.BOLD,35));
        loadingWord.setForeground(Color.blue);
        backImg.add(loadingWord);

        //set progress bar
        proBar = new JProgressBar();
        proBar.setValue(0);
        proBar.setBounds(0,500,900,15);
        proBar.setStringPainted(true);
        proBar.setForeground(Color.white);
        proBar.setBackground(Color.CYAN);
        backImg.add(proBar);
        setVisible(true);

        fill(); // process of progress bar
        dispose();
    }

    public void fill(){
        int counter=0;

        while(counter<=100){
            proBar.setValue(counter);
            try {
                Thread.sleep(50);
            } catch(InterruptedException e){
                e.printStackTrace();
            }
            counter += 1;
        }
    }
}

class GameMenu extends JFrame {
    JButton easy, medium, hard;

    public GameMenu(){
        setTitle("Menu");
        setBounds(450,25,900,600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        //set frame icon as cadenza logo
        ImageIcon logo = new ImageIcon("Cadenzalogo.jpg");
        setIconImage(logo.getImage());

        JLabel backImg = new JLabel();
        backImg.setIcon(new ImageIcon("menuBg.png"));
        add(backImg);

        Font myfont = new Font("MV Boli",Font.BOLD,40);
        JLabel levels = new JLabel("--Game Level--");
        levels.setBounds(250,50,600,50);
        levels.setFont(new Font("MV Boli",Font.BOLD,50));
        levels.setForeground(Color.blue);
        backImg.add(levels);

        easy = new JButton("Easy");
        easy.setFont(myfont);
        easy.setBounds(350,150,200,50);
        backImg.add(easy);
        easy.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                EasyLevel es = new EasyLevel();
                dispose();
            }
        });

        medium = new JButton("Medium");
        medium.setFont(myfont);
        medium.setBounds(350,225,200,50);
        backImg.add(medium);
        medium.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MediumLevel es = new MediumLevel();
                dispose();
            }
        });

        hard = new JButton("Hard");
        hard.setFont(myfont);
        hard.setBounds(350,300,200,50);
        backImg.add(hard);
        hard.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                HardLevel es = new HardLevel();
                dispose();
            }
        });

        JButton exit = new JButton("EXIT");
        exit.setBounds(650,450,150,50);
        exit.setFont(myfont);
        exit.setBackground(Color.orange);
        backImg.add(exit);
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        setVisible(true);
    }
}

class EasyLevel extends JFrame{
    int answer;
    String stringAnswer;
    Font myfont = new Font("MV Boli",Font.BOLD,40);

    EasyLevel() {
        setTitle("Easy Level");
        setBounds(450,25,900, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        //set frame icon as cadenza logo
        ImageIcon logo = new ImageIcon("Cadenzalogo.jpg");
        setIconImage(logo.getImage());

        Font myfont = new Font("MV Boli", Font.BOLD, 40);
        Font myfont2 = new Font("MV Boli", Font.BOLD, 25);

        JLabel backImg = new JLabel();
        backImg.setIcon(new ImageIcon("levelbkg.png"));
        add(backImg);

        JLabel getValue = new JLabel("Get Values");
        getValue.setBounds(400, 25, 300, 50);
        getValue.setFont(myfont);
        getValue.setBackground(Color.magenta);
        backImg.add(getValue);

        JLabel num1 = new JLabel("00");
        num1.setBounds(350, 100, 100, 50);
        num1.setFont(myfont);
        num1.setForeground(Color.blue);
        backImg.add(num1);

        JLabel op = new JLabel("+");
        op.setBounds(475, 100, 50, 50);
        op.setFont(myfont);
        op.setForeground(Color.blue);
        backImg.add(op);

        JLabel num2 = new JLabel("00");
        num2.setBounds(550, 100, 100, 50);
        num2.setFont(myfont);
        num2.setForeground(Color.blue);
        backImg.add(num2);

        JLabel inst = new JLabel("Type Your Answer Here : ");
        inst.setBounds(300,175,400,50);
        inst.setFont(myfont2);
        inst.setForeground(Color.white);
        backImg.add(inst);

        JTextField txt1 = new JTextField(" ");
        txt1.setBounds(650,175,100,50);
        txt1.setBackground(Color.pink);
        txt1.setFont(myfont2);
        backImg.add(txt1);

        JButton checkBtn = new JButton("Check");
        checkBtn.setBounds(400,250,200,50);
        checkBtn.setFont(myfont);
        backImg.add(checkBtn);

        JLabel status = new JLabel(" ");
        status.setBounds(350,325,500,50);
        status.setFont(myfont2);
        status.setForeground(Color.BLUE);
        backImg.add(status);

        JButton back = new JButton("Back");
        back.setBounds(650,400,150,50);
        back.setFont(myfont);
        backImg.add(back);

        JButton exit = new JButton("EXIT");
        exit.setBounds(650,475,150,50);
        exit.setFont(myfont);
        exit.setBackground(Color.orange);
        backImg.add(exit);

        getValue.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                int min = 1, max = 50;

                int rd1 = (int) Math.floor(Math.random() * (max - min - 1) + min);
                int rd2 = (int) Math.floor(Math.random() * (max - min - 1) + min);

                num1.setText(String.valueOf(rd1));
                num2.setText(String.valueOf(rd2));

                Random ranOperator = new Random();
                char oparetor = '?';
                if (rd1 > rd2) {
                    switch (ranOperator.nextInt(2)) {
                        case 0:
                            oparetor = '-';
                            op.setText("-");
                            answer = rd1 - rd2;
                            break;

                        case 1:
                            if(rd1%rd2 == 0) {
                                oparetor = '/';
                                op.setText("÷");
                                answer = rd1 / rd2;
                                break;
                            }

                        default:
                            oparetor = '?';
                    }
                    txt1.setText(" ");
                    status.setText(" ");
                }
                else{
                    switch (ranOperator.nextInt(2)){
                        case 0:
                            oparetor = '+';
                            op.setText("+");
                            answer = rd1 + rd2;
                            break;

                        case  1:
                            oparetor = '*';
                            op.setText("×");
                            answer = rd1 * rd2;
                            break;

                        default:
                            oparetor = '?';
                    }
                    txt1.setText(" ");
                    status.setText(" ");
                }
            }
        });

        checkBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                stringAnswer = Integer.toString(answer);
                if(txt1.getText().contains(stringAnswer)){
                    status.setText("Congrats!! you are correct :-) ");
                }
                else{
                    status.setText(":-( Correct answer is "+stringAnswer);
                }
            }
        });

        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GameMenu menu = new GameMenu();
                dispose();
            }
        });

        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        setVisible(true);
    }
}

class MediumLevel extends JFrame{
    int answer;
    String stringAnswer;
    Font myfont = new Font("MV Boli",Font.BOLD,40);

    MediumLevel() {
        setTitle("Medium Level");
        setBounds(450,25,900, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        //set frame icon as cadenza logo
        ImageIcon logo = new ImageIcon("Cadenzalogo.jpg");
        setIconImage(logo.getImage());

        Font myfont = new Font("MV Boli", Font.BOLD, 40);
        Font myfont2 = new Font("MV Boli", Font.BOLD, 25);

        JLabel backImg = new JLabel();
        backImg.setIcon(new ImageIcon("levelbkg.png"));
        add(backImg);

        JLabel getValue = new JLabel("Get Values");
        getValue.setBounds(400, 25, 300, 50);
        getValue.setFont(myfont);
        getValue.setBackground(Color.magenta);
        backImg.add(getValue);

        JLabel num1 = new JLabel("00");
        num1.setBounds(350, 100, 100, 50);
        num1.setFont(myfont);
        num1.setForeground(Color.blue);
        backImg.add(num1);

        JLabel op = new JLabel("+");
        op.setBounds(475, 100, 50, 50);
        op.setFont(myfont);
        op.setForeground(Color.blue);
        backImg.add(op);

        JLabel num2 = new JLabel("00");
        num2.setBounds(550, 100, 100, 50);
        num2.setFont(myfont);
        num2.setForeground(Color.blue);
        backImg.add(num2);

        JLabel inst = new JLabel("Type Your Answer Here : ");
        inst.setBounds(300,175,400,50);
        inst.setFont(myfont2);
        inst.setForeground(Color.white);
        backImg.add(inst);

        JTextField txt1 = new JTextField(" ");
        txt1.setBounds(650,175,100,50);
        txt1.setBackground(Color.pink);
        txt1.setFont(myfont2);
        backImg.add(txt1);

        JButton checkBtn = new JButton("Check");
        checkBtn.setBounds(400,250,200,50);
        checkBtn.setFont(myfont);
        backImg.add(checkBtn);

        JLabel status = new JLabel(" ");
        status.setBounds(350,325,500,50);
        status.setFont(myfont2);
        status.setForeground(Color.BLUE);
        backImg.add(status);

        JButton back = new JButton("Back");
        back.setBounds(650,400,150,50);
        back.setFont(myfont);
        backImg.add(back);

        JButton exit = new JButton("EXIT");
        exit.setBounds(650,475,150,50);
        exit.setFont(myfont);
        exit.setBackground(Color.orange);
        backImg.add(exit);

        getValue.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                int min = 1, max = 150;

                int rd1 = (int) Math.floor(Math.random() * (max - min - 1) + min);
                int rd2 = (int) Math.floor(Math.random() * (max - min - 1) + min);

                num1.setText(String.valueOf(rd1));
                num2.setText(String.valueOf(rd2));

                Random ranOperator = new Random();
                char oparetor = '?';
                if (rd1 > rd2) {
                    switch (ranOperator.nextInt(2)) {
                        case 0:
                            oparetor = '-';
                            op.setText("-");
                            answer = rd1 - rd2;
                            break;

                        case 1:
                            if(rd1%rd2 == 0) {
                                oparetor = '/';
                                op.setText("÷");
                                answer = rd1 / rd2;
                                break;
                            }

                        default:
                            oparetor = '?';
                    }
                    txt1.setText(" ");
                    status.setText(" ");
                }
                else{
                    switch (ranOperator.nextInt(2)){
                        case 0:
                            oparetor = '+';
                            op.setText("+");
                            answer = rd1 + rd2;
                            break;

                        case  1:
                            oparetor = '*';
                            op.setText("×");
                            answer = rd1 * rd2;
                            break;

                        default:
                            oparetor = '?';
                    }
                    txt1.setText(" ");
                    status.setText(" ");
                }
            }
        });

        checkBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                stringAnswer = Integer.toString(answer);
                if(txt1.getText().contains(stringAnswer)){
                    status.setText("Congrats!! you are correct :-) ");
                }
                else{
                    status.setText(":-( Correct answer is "+stringAnswer);
                }
            }
        });

        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GameMenu menu = new GameMenu();
                dispose();
            }
        });

        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        setVisible(true);
    }
}

class HardLevel extends JFrame{
    int answer;
    String stringAnswer;
    Font myfont = new Font("MV Boli",Font.BOLD,40);

    HardLevel() {
        setTitle("Hard Level");
        setBounds(450,25,900, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        //set frame icon as cadenza logo
        ImageIcon logo = new ImageIcon("Cadenzalogo.jpg");
        setIconImage(logo.getImage());

        Font myfont = new Font("MV Boli", Font.BOLD, 40);
        Font myfont2 = new Font("MV Boli", Font.BOLD, 25);

        JLabel backImg = new JLabel();
        backImg.setIcon(new ImageIcon("levelbkg.png"));
        add(backImg);

        JLabel getValue = new JLabel("Get Values");
        getValue.setBounds(400, 25, 300, 50);
        getValue.setFont(myfont);
        getValue.setBackground(Color.magenta);
        backImg.add(getValue);

        JLabel num1 = new JLabel("00");
        num1.setBounds(350, 100, 100, 50);
        num1.setFont(myfont);
        num1.setForeground(Color.blue);
        backImg.add(num1);

        JLabel op = new JLabel("+");
        op.setBounds(475, 100, 50, 50);
        op.setFont(myfont);
        op.setForeground(Color.blue);
        backImg.add(op);

        JLabel num2 = new JLabel("00");
        num2.setBounds(550, 100, 100, 50);
        num2.setFont(myfont);
        num2.setForeground(Color.blue);
        backImg.add(num2);

        JLabel inst = new JLabel("Type Your Answer Here : ");
        inst.setBounds(300,175,400,50);
        inst.setFont(myfont2);
        inst.setForeground(Color.white);
        backImg.add(inst);

        JTextField txt1 = new JTextField(" ");
        txt1.setBounds(650,175,100,50);
        txt1.setBackground(Color.pink);
        txt1.setFont(myfont2);
        backImg.add(txt1);

        JButton checkBtn = new JButton("Check");
        checkBtn.setBounds(400,250,200,50);
        checkBtn.setFont(myfont);
        backImg.add(checkBtn);

        JLabel status = new JLabel(" ");
        status.setBounds(350,325,500,50);
        status.setFont(myfont2);
        status.setForeground(Color.BLUE);
        backImg.add(status);

        JButton back = new JButton("Back");
        back.setBounds(650,400,150,50);
        back.setFont(myfont);
        backImg.add(back);

        JButton exit = new JButton("EXIT");
        exit.setBounds(650,475,150,50);
        exit.setFont(myfont);
        exit.setBackground(Color.orange);
        backImg.add(exit);

        getValue.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                int min = 1, max = 500;

                int rd1 = (int) Math.floor(Math.random() * (max - min - 1) + min);
                int rd2 = (int) Math.floor(Math.random() * (max - min - 1) + min);

                num1.setText(String.valueOf(rd1));
                num2.setText(String.valueOf(rd2));

                Random ranOperator = new Random();
                char oparetor = '?';
                if (rd1 > rd2) {
                    switch (ranOperator.nextInt(2)) {
                        case 0:
                            oparetor = '-';
                            op.setText("-");
                            answer = rd1 - rd2;
                            break;

                        case 1:
                            if(rd1%rd2 == 0) {
                                oparetor = '/';
                                op.setText("÷");
                                answer = rd1 / rd2;
                                break;
                            }

                        default:
                            oparetor = '?';
                    }
                    txt1.setText(" ");
                    status.setText(" ");
                }
                else{
                    switch (ranOperator.nextInt(2)){
                        case 0:
                            oparetor = '+';
                            op.setText("+");
                            answer = rd1 + rd2;
                            break;

                        case  1:
                            oparetor = '*';
                            op.setText("×");
                            answer = rd1 * rd2;
                            break;

                        default:
                            oparetor = '?';
                    }
                    txt1.setText(" ");
                    status.setText(" ");
                }
            }
        });

        checkBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                stringAnswer = Integer.toString(answer);
                if(txt1.getText().contains(stringAnswer)){
                    status.setText("Congrats!! you are correct :-) ");
                }
                else{
                    status.setText(":-( Correct answer is "+stringAnswer);
                }
            }
        });

        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GameMenu menu = new GameMenu();
                dispose();
            }
        });

        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        setVisible(true);
    }
}