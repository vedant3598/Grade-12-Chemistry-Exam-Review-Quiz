package javaapplication34;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.*;
import javafx.scene.paint.Color;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import sun.audio.*;
import java.util.*;
import static javaapplication34.CulminatingProject.playMusic;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.text.StyledDocument;
import java.nio.file.*;
/**
 *
 * @author Vedant
 */
public class CulminatingProjectGUI extends JFrame{
    
    static ArrayList<String[]> usernamePassword;

    static String[][] questions = {
                                {"How much heat in kJ must be removed from 175 grams of water to lower its temeperature from 25.0°C to 15.0°C?", "What is the rate law of the following reaction?", 
                                "Benzene, C6H6, burns according to the following reaction:\n     2 C6H6(l) + 15 O2(g) → 12 CO2(g) + 6 H2O(l)     ΔH° = -6542 kJ\nWhat is the ΔH° for the combustion of 1.500 mol of benzene?", "What is the sign of ΔS for the following reaction?\n PCl3(g) + Cl2(g) → PCl5(g)", "For a collision to effective, the molecules must collide with the proper:"}, 
                                {"How will the equilibrium be affected with the addition of N2O in the following reaction: N2O9(g) + NO2(g) ↔ 3 NO(g)?", "The water in which a soil sample had soaked overnight was found to have [OH-] = 1.47 x 10 -9 M. What is the pH?", 
                                "What is the pH of a 0.01 M HNO3 solution?", "What is the molar solubility of AgCl in pure water at 25°C when Ksp = 1.8 x 10^-10?", "At 60°C, the pH of 0.0100 M butyric acid is 2.98. Calculate the pKa of butyric acid at this temperature."}, 
                                {"What is the VSEPR diagram for CH3Cl?", "What is the lowest energy level that contains d orbitals?",
                                "What is the abbreviated electron configuration for Radium?", "Which one of the Lewis Structures is true for SeO3?", "What is the geometric name for the VSEPR diagram of NF3?"},
                                {"Which of the following organic compounds is the correct drawing for the following organic compound: 3,3,6-tribromo-2-chloro-2-ethyl-5-fluoroheptanedial?", "What IUPAC name for the following organic compound is correct?", 
                                "Hydration reactions result in the formation of...", "Which of the following functional groups has the highest priority?", "What is the dominant type of intermolecular force of propan-1-ol?"}
    };
    
    static char[][] answers = {{'A', 'C', 'B', 'C', 'D'}, {'E', 'D', 'D', 'D', 'B'}, {'C', 'B', 'A', 'D', 'B'}, {'A', 'E', 'C', 'D', 'E'}};
    
    static String[][] choices = {
                               {"A. 7.35 kJ B. 7.30 kJ C. 8000 J D. 4.50 kJ E. 7.25 kJ", "A.  B.  C.  D.  E. ", "A. 4907 kJ B. -4907 kJ C. -5147 kJ D. -4907 J E. 4907 J", "A. Positive B. Neutral C. Negative D. Two of the above E. None of the above", "A. Orientation B. Kinetic energy C. Temperature D. (A) and (B) E. Catalyst"},
                               {"A. Shifts left kJ B. Shifts down C. Shifts up D. No shift E. Shifts right", "A. 4.17 B. 4.27 C. 5.07 D. 5.17 E. 5.27", "A. 5 B. 4 C. 3 D. 2 E. 1", "A. 1.3 x 10^-8 M B. 1.8 x 10^-8 M C. 1.3 x 10^-11 M D. 1.3 x 10^-4 M E. 1.5 x 10^-4 M", "A. 4.54 B. 3.91 C. 1.2 x 10^-4 D. 2.45 E. 1.4 x 10^-5"},
                               {"A. B. C. D. E. ", "A. 2 B. 3 C. 4 D. 1 E. None of the above", "A. [Rn] 7s^2 B. [Xe] 7s^2 C. [Rn] 7p^2 D. [Rn] 7s^4 E. [Rn] 7f^2", "A. B. C. D. E. ", "A. Trigonal Planar B. Trigonal Pyramidal C. Ttrahedral  D. Linear E. Trigonal-bipyramidal"},
                               {"A. B. C. D. E. ", "A. 7.35 kJ B. 7.30 kJ C. 8000 J D. 4.50 kJ E. 7.25 kJ", "A. Ethers B. Esters C. Alcohols D. Carboxylic Acid E. Alkylhalide", "A. Alkanes B. Amides C. Alcohols D. Esters E. Thiols", "A. London Dispersion Force B. Ionic Bonding C. Covalent Bonding D. Dipole-dipole Attraction E. Hydrogen Bonding"}
    };
        
    static int rightAnswer = 0;
    static int userMark = 0;
    static Timer myTimer = new Timer();
    static final int TOTALQUESTIONS = 20;
    static final int TOTALMARKS = 20;
    static Boolean run = true;
    static Scanner sc1 = new Scanner(System.in);
        
    public static void playMusic(String musicFile){
        InputStream music; 
        try{
            music = new FileInputStream(new File(musicFile));
            AudioStream audio = new AudioStream(music);
            AudioPlayer.player.start(audio);
        }
        catch(Exception error){
            JOptionPane.showMessageDialog(null, "Error in playing music. Sorry!");
        }
    }
    
    public static void loadAccounts() {
        usernamePassword = new ArrayList<String[]>();
        try
        {
            Scanner input = new Scanner(new File("account.txt"));
            while (input.hasNext()){
                String line = input.nextLine();
                usernamePassword.add(line.split(","));
            }
        }
        catch(FileNotFoundException fnfe){
            System.out.println("File not found");
        } 
   }
    
    public static void main(String[] args) {
        playMusic("Music.wav");
        loadAccounts();
        new CulminatingProjectGUI();
    }
    
    public CulminatingProjectGUI(){
        //Welcome Page
        JPanel welcomePanel1 = new JPanel();
        JPanel loginPanel1 = new JPanel();
        JPanel image1 = new JPanel();
        
        JTextPane welcomeTextPane1 = new JTextPane();
        welcomeTextPane1.setText("\t\t\t\t\t\t\tWelcome to the Chemistry Exam Review Quiz!\n\nThis quiz is aimed to help YOU sharpen your Chemistry knowledge and skills to help you get the best possible mark you can on your Chemistry exam! You will be given 20 questions that will cover all five units of the Ontario Grade 12 Chemistry Curriculum! "
                + "Your job is to get as many questions you can right! Here is a little bit about me: My name is Vedant Shah and I am the creator of this review quiz program. In the near future, this Java GUI will be turned into an Android app. I hope this helps you get a great mark on Chemistry exam! Remember, review your past tests, quizzes, and notes as well to prepare you for the Chemistry exam!\n\n\t\t");
        welcomeTextPane1.setBounds(200, 100, 1500, 350);
        welcomeTextPane1.setFont(new Font("Monospaced Bold", Font.BOLD, 25));
        welcomeTextPane1.setForeground(java.awt.Color.RED);
        welcomeTextPane1.setOpaque(false);
        
        //How to get Image Outputted
        JLabel image_1 = new JLabel();
        ImageIcon goodLuck = new ImageIcon("goodLuck.jpg");
        image_1.setIcon(goodLuck);
        image_1.setBounds(600, 350, 900, 300);
        
        JLabel loginImageLabel = new JLabel();
        ImageIcon loginImage = new ImageIcon("loginImage.PNG");
        loginImageLabel.setIcon(loginImage);
        loginImageLabel.setBounds(135, 750, 200, 100);
        
        JLabel signUpImageLabel = new JLabel();
        ImageIcon signUpImage = new ImageIcon("signUpImage.PNG");
        signUpImageLabel.setIcon(signUpImage);
        signUpImageLabel.setBounds(1550, 750, 200, 100);
        
        JLabel forwardArrowImageLabel = new JLabel();
        ImageIcon forwardArrowImage = new ImageIcon("forwardArrow.PNG");
        forwardArrowImageLabel.setIcon(forwardArrowImage);
        forwardArrowImageLabel.setBackground(java.awt.Color.red);
        forwardArrowImageLabel.setBounds(300, 750, 200, 100);
        
        JLabel backwardArrowImageLabel = new JLabel();
        ImageIcon backwardArrowImage = new ImageIcon("backwardArrow.PNG");
        backwardArrowImageLabel.setIcon(backwardArrowImage);
        backwardArrowImageLabel.setBackground(java.awt.Color.red);
        backwardArrowImageLabel.setBounds(1400, 750, 200, 100);
                
        JTextArea userInput = new JTextArea();
        userInput.setFont(new Font("Monospaced Bold", Font.BOLD, 25));
        userInput.setForeground(java.awt.Color.BLUE);
        userInput.setBounds(650, 700, 200,50);
        JTextArea passInput = new JTextArea();
        passInput.setFont(new Font("Monospaced Bold", Font.BOLD, 25));
        passInput.setForeground(java.awt.Color.BLUE);
        passInput.setBounds(650, 800, 200,50);
        
        JLabel userLabel = new JLabel();
        userLabel.setBounds(500, 700, 200,50);
        userLabel.setText("Username:");
        userLabel.setFont(new Font("Monospaced Bold", Font.BOLD, 25));
        userLabel.setForeground(java.awt.Color.RED);
        JLabel passLabel = new JLabel();
        passLabel.setBounds(500, 800, 200,50);
        passLabel.setText("Password:");
        passLabel.setFont(new Font("Monospaced Bold", Font.BOLD, 25));
        passLabel.setForeground(java.awt.Color.RED);
        
        JButton loginBtn = new JButton();
        loginBtn.setBounds(650, 900, 200, 50);
        loginBtn.setFont(new Font("Monospaced Bold", Font.BOLD, 20));
        loginBtn.setForeground(java.awt.Color.CYAN);
        loginBtn.setText("Login");
        loginBtn.addMouseListener(new java.awt.event.MouseAdapter(){
            public void mouseEntered(java.awt.event.MouseEvent evt){
                loginBtn.setForeground(java.awt.Color.darkGray);
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                loginBtn.setForeground(java.awt.Color.MAGENTA);
            }
        });
        
        //How to do read text file
        loginBtn.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent e) { 
                Boolean isWrong = false;
                for(int counter1 = 0; counter1 < usernamePassword.size(); counter1++){
                    for(int counter2 = 0; counter2 < usernamePassword.get(counter1).length; counter2++)
                        if(userInput.getText().equals(usernamePassword.get(counter1)[0]) && passInput.getText().equals(usernamePassword.get(counter1)[1]))
                            isWrong = true;
                }

                if(isWrong){
                    JOptionPane.showMessageDialog(null, "Username and password are valid! You are set to do the quiz!.");
                    setVisible(false);
                    new QuestionsGUI();
                }
                else {
                    JOptionPane.showMessageDialog(null, "Username and password are invalid! Please enter the correct username and password or sign up if you have not already signed up! Thank you!\n\n");
                    isWrong = false;
                }
            }
        });
        
        JTextArea userSignUp = new JTextArea();
        userSignUp.setFont(new Font("Monospaced Bold", Font.BOLD, 25));
        userSignUp.setForeground(java.awt.Color.BLUE);
        userSignUp.setBounds(1150, 700, 200,50);
        JTextArea passSignUp = new JTextArea();
        passSignUp.setFont(new Font("Monospaced Bold", Font.BOLD, 25));
        passSignUp.setForeground(java.awt.Color.BLUE);
        passSignUp.setBounds(1150, 800, 200, 50);
        
        JLabel userSignUpLabel = new JLabel();
        userSignUpLabel.setBounds(950, 700, 200, 50);
        userSignUpLabel.setText("New Username:");
        userSignUpLabel.setFont(new Font("Monospaced Bold", Font.BOLD, 25));
        userSignUpLabel.setForeground(java.awt.Color.RED);
        JLabel passSignUpLabel = new JLabel();
        passSignUpLabel.setBounds(950, 800, 200, 50);
        passSignUpLabel.setText("New Password:");
        passSignUpLabel.setFont(new Font("Monospaced Bold", Font.BOLD, 25));
        passSignUpLabel.setForeground(java.awt.Color.RED);
        
        JButton signUpBtn = new JButton();
        signUpBtn.setBounds(1150, 900, 200, 50);
        signUpBtn.setFont(new Font("Monospaced Bold", Font.BOLD, 20));
        signUpBtn.setForeground(java.awt.Color.CYAN);
        signUpBtn.setText("Sign Up");
        signUpBtn.addMouseListener(new java.awt.event.MouseAdapter(){
            public void mouseEntered(java.awt.event.MouseEvent evt){
                signUpBtn.setForeground(java.awt.Color.darkGray);
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                signUpBtn.setForeground(java.awt.Color.MAGENTA);
            }
        });
        signUpBtn.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent e) { 
                Boolean isWrong = false;
                for(int counter1 = 0; counter1 < usernamePassword.size(); counter1++){
                    for(int counter2 = 0; counter2 < usernamePassword.get(counter1).length; counter2++)
                        if(userSignUp.getText().equals(usernamePassword.get(counter1)[0]))
                            isWrong = true;
                }
                         
                if(isWrong){
                    JOptionPane.showMessageDialog(null, "You have already signed up or this username is already in use. Please login.");
                    
                }
                else {
                    usernamePassword.add(new String[] {userSignUp.getText(), passSignUp.getText()});
                    try {
                        Files.write(Paths.get("account.txt"), ("\r\n" + userSignUp.getText() + "," + passSignUp.getText()).getBytes(), StandardOpenOption.APPEND);
                    } catch (IOException ee) {
                        System.out.println("File not found");
                    }
                    JOptionPane.showMessageDialog(null, "Thank you for signing up! You will now proceed to the quiz!");
                    setVisible(false);
                    new QuestionsGUI();
                }
            }
        });
        
        setContentPane(welcomePanel1);
        setSize(2200, 1400);
        setTitle("Grade 12 Chemistry Exam Review Quiz");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setResizable(true);
        welcomePanel1.add(welcomeTextPane1);
        welcomePanel1.add(userInput);
        welcomePanel1.add(passInput);
        welcomePanel1.add(userLabel);
        welcomePanel1.add(passLabel);
        welcomePanel1.add(loginBtn);
        welcomePanel1.add(userSignUp);
        welcomePanel1.add(passSignUp);
        welcomePanel1.add(userSignUpLabel);
        welcomePanel1.add(passSignUpLabel);
        welcomePanel1.add(signUpBtn);
        welcomePanel1.add(loginImageLabel);
        welcomePanel1.add(forwardArrowImageLabel);
        welcomePanel1.add(signUpImageLabel);
        welcomePanel1.add(backwardArrowImageLabel);
        welcomePanel1.add(image_1);
                
        setLayout(new BorderLayout());
	JLabel background = new JLabel(new ImageIcon("PeriodicTable-Space.png"));
	add(background);
    }
}