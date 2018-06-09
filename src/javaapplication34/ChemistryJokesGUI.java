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
    
public class ChemistryJokesGUI extends JFrame{
        JPanel chemistryJokesPanel = new JPanel();
        
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

        public ChemistryJokesGUI(){
        JPanel image1 = new JPanel();    
        setContentPane(chemistryJokesPanel);
        setSize(2200, 1400);
        setTitle("Chemistry Jokes");
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        
        JLabel chemistryImage1 = new JLabel();
        ImageIcon chemistryJoke1 = new ImageIcon("chemistryJokes1.PNG");
        chemistryImage1.setIcon(chemistryJoke1);
        chemistryImage1.setBounds(300, 0, 2000, 800);
        
        JButton yesPlayAgain = new JButton();
        yesPlayAgain.setBounds(325, 850, 300, 100);
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
        noPlayAgain.setBounds(625, 850, 300, 100);
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
        goToHomeScreen.setBounds(925, 800, 300, 200);
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
        chemistryJokes.setBounds(1225, 850, 300, 100);
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
        
        chemistryJokesPanel.add(yesPlayAgain);
        chemistryJokesPanel.add(noPlayAgain);
        chemistryJokesPanel.add(goToHomeScreen);
        chemistryJokesPanel.add(chemistryJokes);
        chemistryJokesPanel.add(chemistryImage1);
        
        setLayout(new BorderLayout());
	JLabel background = new JLabel(new ImageIcon("chemistryBackgroundImage1.jpg"));
	add(background);
    }
}
