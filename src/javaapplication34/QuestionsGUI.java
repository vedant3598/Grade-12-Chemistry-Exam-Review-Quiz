package javaapplication34;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.*;
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
 * @author Vedant
 */
public class QuestionsGUI extends JFrame{

    static String[][] questions = {
                                {"How much heat in kJ must be removed from 175 grams of water to lower its temeperature from 25.0°C to 15.0°C?", "What is the rate law of the following reaction?", 
                                "Benzene, C6H6, burns according to the following reaction:<br>     2 C6H6(l) + 15 O2(g) → 12 CO2(g) + 6 H2O(l)     ΔH° = -6542 kJ<br>What is the ΔH° for the combustion of 1.500 mol of benzene?", "What is the sign of ΔS for the following reaction?<br>                       PCl3(g) + Cl2(g) → PCl5(g)", "For a collision to effective, the molecules must collide with the proper:"}, 
                                {"How will the equilibrium be affected with the addition of NO2 in the following reaction: <br> N2O9(g) + NO2(g) ↔ 3 NO(g)?", "The water in which a soil sample had soaked overnight was found to have [OH-] = 1.47 x 10^-9 M. What is the pH?", 
                                "What is the pH of a 0.01 M HNO3 solution?", "What is the molar solubility of AgCl in pure water at 25°C when Ksp = 1.8 x 10^-10?", "At 60°C, the pH of 0.0100 M butyric acid is 2.98. Calculate the pKa of butyric acid at this temperature."}, 
                                {"What is the VSEPR diagram for CH3Cl?", "What is the lowest energy level that contains d orbitals?",
                                "What is the abbreviated electron configuration for Radium?", "Which one of the Lewis Structures is true for SeO3?", "What is the geometric name for the VSEPR diagram of NF3?"},
                                {"Which of the following organic compounds is the correct drawing for the following organic compound: 3,3,6-tribromo-2-chloro-2-ethyl-5-fluoroheptanedial?", "What IUPAC name for the following organic compound is correct?", 
                                "Hydration reactions result in the formation of...", "Which of the following functional groups has the highest priority?", "What is the dominant type of intermolecular force of propan-1-ol?"}
    };
    
    static char[][] answers = {{'A', 'C', 'B', 'C', 'D'}, {'E', 'D', 'D', 'D', 'B'}, {'C', 'B', 'A', 'D', 'B'}, {'A', 'E', 'C', 'D', 'E'}};
    
    static String[][][] choices = {
                               {{"7.35 kJ", "7.30 kJ", "8000 J", "4.50 kJ", "7.25 kJ"}, {"rate = k[A] x [B]", "rate = k[A]^3 x [B]^2", "rate = k[A]^2 x [B]^2", "rate = k[A]^2 x [B]^3", "rate = k[A]^3 x [B]^3"}, {"4907 kJ", "-4907 kJ", "-5147 kJ", "-4907 J", "4907 J"}, {"Positive", "Neutral", "Negative", "Two of the above", "None of the above"}, {"Orientation", "Kinetic energy", "Temperature", "(A) and (B)", "Catalyst"}},
                               {{"Shifts left", "Shifts down", "Shifts up", "No shift", "Shifts right"}, {"4.17", "4.27", "5.07", "5.17", "5.27"}, {"5", "4", "3", "2", "1"}, {"1.3 x 10^-8 M", "1.8 x 10^-8 M", "1.3 x 10^-11 M", "1.3 x 10^-5 M", "1.5 x 10^-5 M"}, {"4.54", "3.91", "1.2 x 10^-4", "2.45",  "1.4 x 10^-5"}},
                               {{"", "", "", "", ""}, {"2", "3", "4", "1", "None of the above"}, {"[Rn] 7s^2", "[Xe] 7s^2", "[Rn] 7p^2", "[Rn] 7s^4", "[Rn] 7f^2"}, {"", "", "", "", ""}, {"Trigonal Planar", "Trigonal Pyramidal", "Tetrahedral", "Linear", "Trigonal-bipyramidal"}},
                               {{"", "", "", "", ""}, {"Ethanol", "Butanol", "Ethene", "But-3-yne", "None of the above"}, {"Ethers", "Esters", "Alcohols", "Carboxylic Acid", "Alkylhalide"}, {"Alkanes", "Amides", "Alcohols", "Esters", "Thiols"}, {"LDF", "Ionic Bonding", "Covalent Bonding", "Dipole-dipole Attraction", "Hydrogen Bonding"}}
    };
      
    static String[][] images = {{"", "Image1.gif", "", "", ""}, {"", "", "", "", ""}, {"VSEPRImages.PNG", "", "", "LEWISImages.PNG", ""}, {"organicImage.PNG", "IUPACNaming.PNG", "", "", ""}};
    
    int rightAnswer = 0;
    int userMark = 0;
    static Timer myTimer = new Timer();
    static final int TOTALQUESTIONS = 20;
    static final int TOTALMARKS = 20;
    static ImageIcon checkmark = new ImageIcon("checkmark.PNG");
    static ImageIcon incorrect = new ImageIcon("incorrect.PNG");    
    
    
    JLabel questionLabel;
    JLabel chemistryImages;
    JLabel endingPage;
    JPanel questionsPanel = new JPanel();
    JLabel questionImage1 = new JLabel();
    JLabel questionImage2 = new JLabel();
    JLabel questionImage3 = new JLabel();
    JLabel questionImage4 = new JLabel();
    JLabel questionImage5 = new JLabel();
    JButton aBtn, bBtn, cBtn, dBtn, eBtn;
    int curCat = 0, curQst = 0;
    
    long startTime;
        
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
    
    public int add1Mark(String correctAnswer){
        rightAnswer++;
        return rightAnswer;
    }
    
    public int subtract1Mark(String correctAnswer){
        rightAnswer--;
        return rightAnswer;
    }
    
    
    private void answerClicked(char answer) {        
        if(answer == answers[curCat][curQst]){
            userMark = add1Mark("Correct Answer");
            JOptionPane.showMessageDialog(null, "You are correct! \tScore: " + userMark + "/" + TOTALMARKS, "Input Dialog", JOptionPane.PLAIN_MESSAGE, checkmark);
        }  
        else{
            userMark = subtract1Mark("Wrong Answer");
            JOptionPane.showMessageDialog(null, "You are incorrect! The correct answer was (" + answers[curCat][curQst] + "). \tScore: " + userMark + "/" + TOTALMARKS, "Input Dialog", JOptionPane.PLAIN_MESSAGE, incorrect);
        }
        curQst++;
        
        if(curQst >= 5) {
            curQst = 0;
            curCat++;
        }
        if(curCat == 4 & curQst == 0){
            setVisible(false);
            new PostQuizGUI(userMark, startTime);
        }
        else
            loadQuestion(curCat, curQst);
    };
    
    private void loadQuestion(int cat, int qst) {
        questionLabel.setText("<html><center>" + questions[cat][qst] + "</center></html>");
        questionLabel.setHorizontalAlignment(JLabel.CENTER);
        questionLabel.setBounds(350, -350, 1350, 910);
        
        if(!images[cat][qst].equals("")) {
            ImageIcon image = new ImageIcon(images[cat][qst]);
            chemistryImages.setIcon(image);
        } else {
            chemistryImages.setIcon(null);
        }
        

        aBtn.setText("(A) " + choices[cat][qst][0]);
        aBtn.setFont(new Font("Monospaced Bold", Font.BOLD, 20));
        aBtn.setForeground(java.awt.Color.ORANGE);
        bBtn.setText("(B) " + choices[cat][qst][1]);
        bBtn.setFont(new Font("Monospaced Bold", Font.BOLD, 20));
        bBtn.setForeground(java.awt.Color.BLUE);
        cBtn.setText("(C) " + choices[cat][qst][2]);
        cBtn.setFont(new Font("Monospaced Bold", Font.BOLD, 20));
        cBtn.setForeground(java.awt.Color.GREEN);
        dBtn.setText("(D) " + choices[cat][qst][3]);
        dBtn.setFont(new Font("Monospaced Bold", Font.BOLD, 20));
        dBtn.setForeground(java.awt.Color.PINK);
        eBtn.setText("(E) " + choices[cat][qst][4]);
        eBtn.setFont(new Font("Monospaced Bold", Font.BOLD, 20));
        eBtn.setForeground(java.awt.Color.RED);
        
        aBtn.addMouseListener(new java.awt.event.MouseAdapter(){
            public void mouseEntered(java.awt.event.MouseEvent evt){
                aBtn.setForeground(java.awt.Color.MAGENTA);
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                aBtn.setForeground(java.awt.Color.ORANGE);
            }
        });
        
        bBtn.addMouseListener(new java.awt.event.MouseAdapter(){
            public void mouseEntered(java.awt.event.MouseEvent evt){
                bBtn.setForeground(java.awt.Color.CYAN);
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                bBtn.setForeground(java.awt.Color.BLUE);
            }
        });
        
        cBtn.addMouseListener(new java.awt.event.MouseAdapter(){
            public void mouseEntered(java.awt.event.MouseEvent evt){
                cBtn.setForeground(java.awt.Color.RED);
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                cBtn.setForeground(java.awt.Color.GREEN);
            }
        });
        
        dBtn.addMouseListener(new java.awt.event.MouseAdapter(){
            public void mouseEntered(java.awt.event.MouseEvent evt){
                dBtn.setForeground(java.awt.Color.BLUE);
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                dBtn.setForeground(java.awt.Color.PINK);
            }
        });
        
        eBtn.addMouseListener(new java.awt.event.MouseAdapter(){
            public void mouseEntered(java.awt.event.MouseEvent evt){
                eBtn.setForeground(java.awt.Color.darkGray);
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                eBtn.setForeground(java.awt.Color.RED);
            }
        });
    }
    
    public QuestionsGUI(){
        JPanel loginPanel1 = new JPanel();
        JPanel image1 = new JPanel();    
        setContentPane(questionsPanel);
        setSize(2200, 1400);
        setTitle("Grade 12 Chemistry Exam Review Quiz Questions");
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        
        questionLabel = new JLabel();
        questionLabel.setFont(new Font("Monospaced Bold", Font.BOLD, 25));
        questionLabel.setForeground(java.awt.Color.RED);
        
        JPanel options = new JPanel();
        
        aBtn = new JButton();
        aBtn.setBounds(325, 425, 300, 100);
        aBtn.setText("Option A");
        aBtn.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent e) { 
                answerClicked('A');
            }
        });
        
        bBtn = new JButton();
        bBtn.setBounds(1300, 425, 300, 100);
        bBtn.setText("Option B");
        bBtn.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent e) { 
                answerClicked('B');
            }
        });
        
        cBtn = new JButton();
        cBtn.setBounds(825, 625, 300, 100);
        cBtn.setText("Option C");
        cBtn.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent e) { 
                answerClicked('C');
            }
        });
        
        dBtn = new JButton();
        dBtn.setBounds(325, 825, 300, 100);
        dBtn.setText("Option D");
        
        dBtn.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent e) { 
                answerClicked('D');
            }
        });
        
        eBtn = new JButton();
        eBtn.setBounds(1300, 825, 300, 100);
        eBtn.setText("Option E");
        eBtn.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent e) { 
                answerClicked('E');
            }
        });
        
        chemistryImages = new JLabel();
        chemistryImages.setBounds(500, -150, 1090, 850);
        
        questionsPanel.add(questionLabel);
        questionsPanel.add(aBtn);
        questionsPanel.add(bBtn);
        questionsPanel.add(cBtn);
        questionsPanel.add(dBtn);
        questionsPanel.add(eBtn);
        questionsPanel.add(chemistryImages);
        
        setLayout(new BorderLayout());
	JLabel background = new JLabel(new ImageIcon("chemistryBackgroundImage.jpg"));
	add(background);
        
        loadQuestion(curCat, curQst);
        startTime = System.nanoTime();
    }
}