import javax.swing.*;
import java.lang.Math;
import javax.swing.JFrame;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ScreenWindow extends JFrame{





         ScreenWindow() {

             JLabel label1 = new JLabel("Enter your height in inches: ");
             JLabel label2 = new JLabel("Enter your weight in pounds: ");
             JLabel label3 = new JLabel("Are you a male or female?");
             JLabel label4 = new JLabel("How old are you?");
             JLabel label6 = new JLabel("Enter calories burned from exercise daily, on average?");


             JTextField height = new JTextField();
             height.setColumns(8);

             JTextField weight = new JTextField();
             weight.setColumns(8);

             JTextField age = new JTextField();
             age.setColumns(8);

             JTextField dailyCB = new JTextField();
             dailyCB.setColumns(8);

             JRadioButton male = new JRadioButton("Male");
             JRadioButton female = new JRadioButton("Female");
             male.setSelected(true);
             female.setSelected(true);

             ButtonGroup g = new ButtonGroup();
             g.add(male);
             g.add(female);

             JButton enter = new JButton("Enter"); /// tried to use setbounds to move the button to bottom of screen but doesnt work because of flowlayout


             JFrame window = new JFrame("Calories to Gain Weight Calculator");
             window.add(label3);
             window.add(male);
             window.add(female);
             window.add(label1);
             window.add(height);
             window.add(label2);
             window.add(weight);
             window.add(label4);
             window.add(age);
             window.add(label6);
             window.add(dailyCB);
             window.add(enter);


             window.setLayout(new FlowLayout());
             window.setVisible(true);
             window.setSize(400, 400);
             window.setResizable(false);
             window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

             enter.addActionListener(new ActionListener() {




                 @Override
                 public void actionPerformed(ActionEvent e) {

                        double BasalMetabolicRate = 0.0;
                        double TotalCaloriesBurned = 0.0;
                        double CaloriesEatSlow1 = 0.0;
                        double CaloriesEatSlow2 = 0.0;
                        double CaloriesEatQuick1 = 0.0;
                        double CaloriesEatQuick2 = 0.0;






                        String text1 = height.getText();
                        if(text1.trim().equals("")) {
                            JOptionPane.showMessageDialog(window, "Please Enter Your Height", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                        int heightInput = Integer.parseInt(text1);
                        if(heightInput<48) {
                         JOptionPane.showMessageDialog(window, "Sorry. Too Short.", "Error", JOptionPane.ERROR_MESSAGE);
                        } else if(heightInput>108) {
                         JOptionPane.showMessageDialog(window, "Sorry. Too Tall.","Error",JOptionPane.ERROR_MESSAGE);
                     }


                     String text2 = weight.getText();
                     if(text2.trim().equals("")) {
                         JOptionPane.showMessageDialog(window, "Please Enter Your Weight", "Error", JOptionPane.ERROR_MESSAGE);
                     }
                     int weightInput = Integer.parseInt(text2);
                     if(weightInput<80) {
                         JOptionPane.showMessageDialog(window, "Sorry. Enter a Weight Higher Than 80lbs.", "Error", JOptionPane.ERROR_MESSAGE);
                     } else if(weightInput>300) {
                         JOptionPane.showMessageDialog(window, "Sorry. Enter a Weight Less Than 300lbs.", "Error", JOptionPane.ERROR_MESSAGE);
                     }


                        String text3 = age.getText();
                     if(text3.trim().equals("")) {
                         JOptionPane.showMessageDialog(window, "Please Enter Your Age", "Error", JOptionPane.ERROR_MESSAGE);
                     }
                        int ageInput = Integer.parseInt(text3);
                     if(ageInput<16) {
                         JOptionPane.showMessageDialog(window, "Sorry. Enter An Age Older Than 16.", "Error", JOptionPane.ERROR_MESSAGE);
                     } else if(ageInput>60) {
                         JOptionPane.showMessageDialog(window, "Sorry. Enter An Age Younger Than 60.", "Error", JOptionPane.ERROR_MESSAGE);
                     }



                        String text5 = dailyCB.getText();
                     if(text5.trim().equals("")) {
                         JOptionPane.showMessageDialog(window, "Please Enter Your Average Calories Burned in a Day", "Error", JOptionPane.ERROR_MESSAGE);
                     }
                        int dailyCBInput = Integer.parseInt(text5);
                     if(dailyCBInput<=0) {
                         JOptionPane.showMessageDialog(window, "Sorry. If You're Living, Then Your Burning Calories.", "Error", JOptionPane.ERROR_MESSAGE);
                     }

                     if(male.isSelected()) {
                        BasalMetabolicRate = 66.47 + (6.24*weightInput) + (12.7*heightInput) - (6.75*ageInput);


                     } else if(female.isSelected()) {
                         BasalMetabolicRate = 655.1 + (4.35*weightInput) + (4.7*heightInput) - (4.7*ageInput);

                     }

                     if(!text1.trim().equals("") && !(heightInput <48) &&!(heightInput>108)&&!text2.trim().equals("")&&!(weightInput<80)&&!(weightInput>300)&&!text3.trim().equals("")&&!(ageInput<16)&&!(ageInput>60)&&!text5.trim().equals("")&&!(dailyCBInput<=0)) {
                         TotalCaloriesBurned = BasalMetabolicRate + dailyCBInput;
                         CaloriesEatSlow1 = TotalCaloriesBurned + 300;
                         CaloriesEatSlow2 = TotalCaloriesBurned + 500;
                         CaloriesEatQuick1 = TotalCaloriesBurned + 700;
                         CaloriesEatQuick2 = TotalCaloriesBurned + 1000;


                         JFrame finalwindow = new JFrame("Results");
                         finalwindow.setSize(500, 200);
                         finalwindow.setResizable(false);
                         finalwindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                         finalwindow.setVisible(true);
                         finalwindow.setLayout(new FlowLayout());

                         JLabel BMR = new JLabel("This is your Basal Metabolic Rate: " + Math.round(BasalMetabolicRate));
                         JLabel TotalCaloriesBurnedLabel = new JLabel("This is how many calories you burn in a day: " + Math.round(TotalCaloriesBurned));
                         JLabel CaloriesToGainWeightSlowly = new JLabel("Calories Needed to Gain Weight Slowly per Day: " + Math.round(CaloriesEatSlow1) + " - " + Math.round(CaloriesEatSlow2));
                         JLabel CaloriesToGainWeightQuick = new JLabel("Calories Needed to Gain Weight Quick per Day: " + Math.round(CaloriesEatQuick1) + " - " + Math.round(CaloriesEatQuick2));

                         finalwindow.add(BMR);
                         finalwindow.add(TotalCaloriesBurnedLabel);
                         finalwindow.add(CaloriesToGainWeightSlowly);
                         finalwindow.add(CaloriesToGainWeightQuick);


                     }


                 }
             });




         }



}
