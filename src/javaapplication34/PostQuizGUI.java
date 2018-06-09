package javaapplication34;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.*;
import java.text.DecimalFormat;
import javafx.scene.paint.Color;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import sun.audio.*;
import java.util.*;
import static javaapplication34.CulminatingProject.playMusic;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.text.StyledDocument;
/**
 *
 * @author Vedant
 */
public class PostQuizGUI extends JFrame{
    
    JLabel playAgainText = new JLabel();
    static final int TOTALQUESTIONS = 20;
    static final int TOTALMARKS = 20;
    
    JPanel postQuizPanel = new JPanel();
    
    public static JLabel generateUserFeedback(int userMark, long timePassed){
        JLabel userAdvice = new JLabel();
        userAdvice.setFont(new Font("Monospaced Bold", Font.BOLD, 25));
        userAdvice.setForeground(java.awt.Color.RED);
        userAdvice.setOpaque(false);
        
        double userMarkPercentage = (userMark * 100) / TOTALMARKS;
        if(userMark == 20){
            userAdvice.setText("<html><center>Congratulations! You have obtained " + userMarkPercentage + "%! Great job!<br>" + "Time Taken: " + timePassed + " seconds <br> The mark you have obtained is " + userMark + "/" + TOTALMARKS + ".</center></html>");
            userAdvice.setHorizontalAlignment(JLabel.CENTER);
            userAdvice.setBounds(350, -350, 1400, 1000);
        }
        else if(userMark >= 15 && userMark < 20){
            userAdvice.setText("<html><center>Good job! You have obtained " + userMarkPercentage + "%! Nice work!<br>" + "Time Taken: " + timePassed + " seconds <br> The mark you have obtained is " + userMark + "/" + TOTALMARKS + ".</center></html>");
            userAdvice.setHorizontalAlignment(JLabel.CENTER);
            userAdvice.setBounds(350, -350, 1400, 1000);
        }
        else if(userMark >= 12 && userMark < 15){
            userAdvice.setText("<html><center>Average! You have obtained " + userMarkPercentage + "%! You must study harder for your exam!<br>" + "Time Taken: " + timePassed + " seconds <br> The mark you have obtained is " + userMark + "/" + TOTALMARKS + ".</center></html>");
            userAdvice.setHorizontalAlignment(JLabel.CENTER);
            userAdvice.setBounds(350, -350, 1400, 1000);
        }
        else if (userMark >= 0 && userMark < 12){
            userAdvice.setText("<html><center>Sorry! You have not done well! You have obtained " + userMarkPercentage + "%! You must study harder for your exam! Try better next time!<br>" + "Time Taken: " + timePassed + " seconds <br> The mark you have obtained is " + userMark + "/" + TOTALMARKS + ".</center></html>");
            userAdvice.setHorizontalAlignment(JLabel.CENTER);
            userAdvice.setBounds(350, -350, 1400, 1000);
        }
        else{
            userAdvice.setText("<html><center>You have done a poor job! You do not get a percentage as negative percentages do not exist! Please review all of your past tests, quizzes, homework, and assignments!<br>" + "Time Taken: " + timePassed + " seconds <br> The mark you have obtained is " + userMark + "/" + TOTALMARKS + ".</center></html>");
            userAdvice.setHorizontalAlignment(JLabel.CENTER);
            userAdvice.setBounds(350, -350, 1400, 1000);
        }
       return userAdvice;
    }
    
    private void doQuizAgain(String userInput){
        if(userInput == "Yes"){
            setVisible(false);
            new QuestionsGUI();
        }
        else if(userInput == "No")
            System.exit(0);
        
        else if(userInput == "Go Home"){
            setVisible(false);
            new CulminatingProjectGUI();
        }
        
        else if(userInput.equals("Chemistry Jokes")){
            setVisible(false);
            new ChemistryJokesGUI();
        }
    };
    
    public static JLabel userAdvice(){
        JLabel morePractice = new JLabel();
        morePractice.setBounds(250, 150, 1500, 350);
        morePractice.setFont(new Font("Monospaced Bold", Font.BOLD, 25));
        morePractice.setForeground(java.awt.Color.ORANGE);
        morePractice.setOpaque(false);
        morePractice.setText("<html><center>If you want more practice for your Chemistry exam, below are a few websites and Youtube channels that can help you better prepare for your exam! Good luck studying!<br>"
                + "1. https://www.khanacademy.org/science/chemistry <br>2. https://www.acs.org/content/acs/en/education/resources/highschool.html <br>3. http://www.acdlabs.com/resources/freeware/chemsketch/ <br>4. http://www.chemcollective.org/ <br>5. http://www.thecatalyst.org/</center></html>");
        morePractice.setHorizontalAlignment(JLabel.CENTER);
        return morePractice;
    }
    
    public PostQuizGUI (int userMark, long startTime) {
        JPanel image1 = new JPanel();    
        setContentPane(postQuizPanel);
        setSize(2200, 1400);
        setTitle("Post-Quiz");
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        
        long deltaT = (System.nanoTime() - startTime) / 1000000000;
        
        JTextPane quizAgain = new JTextPane();
        quizAgain.setBounds(200, 100, 1500, 350);
        quizAgain.setFont(new Font("Monospaced Bold", Font.BOLD, 25));
        quizAgain.setForeground(java.awt.Color.RED);
        quizAgain.setOpaque(false);
        quizAgain.setText("Would you like to do the Grade 12 Chemistry Exam Review Quiz again?");
        playAgainText.add(quizAgain);
        
        JButton yesPlayAgain = new JButton();
        yesPlayAgain.setBounds(325, 750, 300, 100);
        yesPlayAgain.setFont(new Font("Monospaced Bold", Font.BOLD, 20));
        yesPlayAgain.setForeground(java.awt.Color.MAGENTA);
        yesPlayAgain.setText("Yes! I want to play again!");
        yesPlayAgain.addMouseListener(new java.awt.event.MouseAdapter(){
            public void mouseEntered(java.awt.event.MouseEvent evt){
                yesPlayAgain.setForeground(java.awt.Color.darkGray);
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                yesPlayAgain.setForeground(java.awt.Color.MAGENTA);
            }
        });
        yesPlayAgain.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent e) { 
                doQuizAgain("Yes");
            }
        });
        
        JButton noPlayAgain = new JButton();
        noPlayAgain.setBounds(625, 750, 300, 100);
        noPlayAgain.setFont(new Font("Monospaced Bold", Font.BOLD, 20));
        noPlayAgain.setForeground(java.awt.Color.MAGENTA);
        noPlayAgain.setText("No! I am going to prepare for the exam now!");
        noPlayAgain.addMouseListener(new java.awt.event.MouseAdapter(){
            public void mouseEntered(java.awt.event.MouseEvent evt){
                noPlayAgain.setForeground(java.awt.Color.darkGray);
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                noPlayAgain.setForeground(java.awt.Color.MAGENTA);
            }
        });
        noPlayAgain.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent e) { 
                doQuizAgain("No");
            }
        });
        
        JButton goToHomeScreen = new JButton();
        goToHomeScreen.setBounds(925, 700, 300, 200);
        goToHomeScreen.setFont(new Font("Monospaced Bold", Font.BOLD, 20));
        goToHomeScreen.setForeground(java.awt.Color.MAGENTA);
        goToHomeScreen.setText("Go Home");
        JLabel goHome = new JLabel();
        ImageIcon goHomeIcon = new ImageIcon("goHome.png");
        goHome.setBounds(1025, 800, 300, 250);
        goToHomeScreen.setIcon(goHomeIcon);
        goToHomeScreen.addMouseListener(new java.awt.event.MouseAdapter(){
            public void mouseEntered(java.awt.event.MouseEvent evt){
                goToHomeScreen.setForeground(java.awt.Color.darkGray);
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                goToHomeScreen.setForeground(java.awt.Color.MAGENTA);
            }
        });
        goToHomeScreen.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent e) { 
                doQuizAgain("Go Home");
            }
        });
        
        JButton chemistryJokes = new JButton();
        chemistryJokes.setBounds(1225, 750, 300, 100);
        chemistryJokes.setFont(new Font("Monospaced Bold", Font.BOLD, 20));
        chemistryJokes.setForeground(java.awt.Color.MAGENTA);
        chemistryJokes.setText("Chemistry Jokes");
        chemistryJokes.addMouseListener(new java.awt.event.MouseAdapter(){
            public void mouseEntered(java.awt.event.MouseEvent evt){
                chemistryJokes.setForeground(java.awt.Color.darkGray);
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                chemistryJokes.setForeground(java.awt.Color.MAGENTA);
            }
        });
        chemistryJokes.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent e) { 
                doQuizAgain("Chemistry Jokes");
            }
        });
        
        postQuizPanel.add(generateUserFeedback(userMark, deltaT));
        postQuizPanel.add(userAdvice());
        postQuizPanel.add(playAgainText);
        postQuizPanel.add(yesPlayAgain);
        postQuizPanel.add(noPlayAgain);
        postQuizPanel.add(goToHomeScreen);
        postQuizPanel.add(chemistryJokes);
        
        setLayout(new BorderLayout());
	JLabel background = new JLabel(new ImageIcon("chemistryBackgroundImage1.jpg"));
	add(background);
    }
}