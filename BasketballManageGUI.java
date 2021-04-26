import java.util.*;
import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
/**
 * This is the Basketball Managing Program for managers
 * 
 * @author (Christopher Tae Hwan Kim) 
 * @version (Created: October 11th, 2017  Last Modified: December 16th, 2017)
 */
public class BasketballManageGUI extends JPanel 
{
   private JPanel bench;
   private JPanel addRoster;
   private JPanel onCourt;
   //private JPanel facePanel;
   //lists
   private DefaultListModel default_Roster;
   private DefaultListModel default_onCourt;
   
   //labels
   
   
   private JLabel label_grade;
   private JLabel label_name;
   private JLabel label_number;
   private JLabel label_onCourtTitle;
   private JLabel label_position;
   
   private JLabel label_showAssists;
   private JLabel label_showFouls;
   private JLabel label_showName;
   private JLabel label_showNum;
   private JLabel label_showPoints;
   private JLabel label_showPos;
   private JLabel label_showRebounds;
   private JLabel label_tagAssists;
   private JLabel label_tagFouls;
   private JLabel label_tagName;
   private JLabel label_tagNum;
   private JLabel label_tagPoints;
   private JLabel label_tagPosition;
   private JLabel label_tagRebound;
   //Buttons
   private JButton button_add; //add athlete
  
   private JButton button_add2;
   private JButton button_addAssist;
   private JButton button_addFoul;
   private JButton button_addRebound;
  
   private JButton button_stop; //stop adding athlete
   private JButton button_subtract1; //subtract 1 point
   private JButton button_subtract2;
   private JButton button_subtractAssist;
   private JButton button_subtractFoul;
   private JButton button_subtractRebound;
   
   //TextField
   private JTextField input_grade;
   private JTextField input_name;
   private JTextField input_number;
   private JTextField input_position;
   //Scroll
   
   
   public BasketballManageGUI()
   {
       super();
       //setting up lists
       default_Roster = new DefaultListModel();
       default_onCourt = new DefaultListModel();
       
       
       
       //list_onCourt.addListSelectionListener(this);
       
       
       //Button
       button_add = new JButton("Add");
      
       button_add2 = new JButton("2 Point");
       button_addAssist = new JButton("1 Assist");
       button_addFoul = new JButton("1 Foul");
       button_addRebound = new JButton("1 Rebound");
       
       button_stop = new JButton("Stop");
       button_subtract1 = new JButton("-1 Point");
       button_subtract2 = new JButton("-2 Points");
       button_subtractAssist = new JButton("-1 Assist");
       button_subtractFoul = new JButton("-1 Foul");
       button_subtractRebound = new JButton("-1 Rebound");
       
       //Label
       
      
       label_grade = new JLabel("Grade:");
       label_name = new JLabel("Name:");
       label_onCourtTitle = new JLabel("On Court");
       label_position = new JLabel("Position:");
       
       label_showAssists = new JLabel("");
       label_showFouls = new JLabel("");
       label_showName = new JLabel("");
       label_showNum = new JLabel("");
       label_showPoints = new JLabel("");
       label_showPos = new JLabel("");
       label_showRebounds = new JLabel("");
       label_tagAssists = new JLabel("Assists");
       label_tagFouls = new JLabel("Fouls");
       label_tagName = new JLabel("Name:");
       label_tagNum = new JLabel("Number:");
       label_tagPoints = new JLabel("Points:");
       label_tagPosition = new JLabel("Position:");
       label_tagRebound = new JLabel("Rebounds:");
       label_number = new JLabel("Number:");
       
       input_grade = new JTextField(5);
       input_name = new JTextField(5);
       input_number = new JTextField(5);
       input_position = new JTextField(5);
       
       onCourt = new Court();  
       addRoster = new AddRoster();
       bench = new Bench();
       //facePanel
       
       GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(addRoster, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(bench, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
                .addComponent(onCourt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(onCourt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(bench, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 57, Short.MAX_VALUE)
                        .addComponent(addRoster, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
       
  }
  private class Bench extends JPanel implements ListSelectionListener
  {
        private JList list_roster;
        private JLabel label_rostertitle;
        private JLabel label_deploybutton;
        private JButton button_deploy; //move to onCourt
        private JScrollPane scroll_roster;
        public Bench()
        {
            list_roster = new JList(default_Roster);
            list_roster.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
            list_roster.setLayoutOrientation(JList.VERTICAL_WRAP);
            list_roster.addListSelectionListener(this);
            scroll_roster = new JScrollPane(list_roster);
            label_rostertitle = new JLabel("Roster");
            label_deploybutton = new JLabel("Deploy");
            button_deploy = new JButton("To Court");
            button_deploy.setEnabled(false); //disable button when not selected
            button_deploy.addActionListener(new deployListener());
        
            GroupLayout benchLayout = new javax.swing.GroupLayout(this);
            this.setLayout(benchLayout);
            benchLayout.setHorizontalGroup(
                benchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(benchLayout.createSequentialGroup()
                    .addGroup(benchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(benchLayout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(benchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(scroll_roster, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(benchLayout.createSequentialGroup()
                                    .addGap(126, 126, 126)
                                    .addComponent(label_rostertitle))))
                                    .addGroup(benchLayout.createSequentialGroup()
                        .addGap(136, 136, 136)
                        .addComponent(label_deploybutton)))
                .addContainerGap(129, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, benchLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(button_deploy)
                .addGap(118, 118, 118))
                );
                benchLayout.setVerticalGroup(
                benchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(benchLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(label_rostertitle)
                    .addGap(12, 12, 12)
                    .addComponent(scroll_roster, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addComponent(label_deploybutton)
                    .addGap(41, 41, 41)
                    .addComponent(button_deploy)
                    .addContainerGap(30, Short.MAX_VALUE))
                );
                
            setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        }
        public void valueChanged(ListSelectionEvent e)   //required method - must define abstract method = equivalent functionality to even listener
        {
            if(e.getValueIsAdjusting() == false)
            {
                if(list_roster.getSelectedIndex() == -1)  //if not selected, then disable button
                {
                    button_deploy.setEnabled(false); 
                }
                else
                {
                    button_deploy.setEnabled(true);
                }
            }
        }
        private class deployListener implements ActionListener
        {
            public void actionPerformed(ActionEvent e)  //moves the athlete from bench to court 
            {
                Athlete summonToCourt = (Athlete)default_Roster.remove(list_roster.getSelectedIndex());
                default_onCourt.add(0,summonToCourt); 
                //default_Roster.remove(list_roster.getSelectedIndex());
            }
        }
  }
  private class Court extends JPanel implements ListSelectionListener
  {
      private JList list_onCourt;
      private JScrollPane scroll_onCourt;
      private JLabel label_face;  //student face image will appear here
      private JButton button_toBench; //move athlete to bench
      private JButton button_add1; //add 1 point
      
      public Court()
      {
          super();
          list_onCourt = new JList(default_onCourt);
          list_onCourt.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
          list_onCourt.setLayoutOrientation(JList.VERTICAL_WRAP);
          list_onCourt.addListSelectionListener(this);
          scroll_onCourt = new JScrollPane(list_onCourt);
          
          button_toBench = new JButton("To Bench");
          button_toBench.setEnabled(false); //disable button and later enable when selected someone on the court
          button_toBench.addActionListener(new toBenchListener());
          
          button_add1 = new JButton("1 Point");
          button_add1.addActionListener(new add1Listener());
          
          JPanel facePanel = new JPanel();
          facePanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
          
          label_face = new JLabel("");
          label_face.setIcon(new ImageIcon("Images/Logo.jpg"));  //Calls up the picture named Logo.jpg under the folder Image in this project folder
          
          GroupLayout onCourtLayout = new javax.swing.GroupLayout(this);
          this.setLayout(onCourtLayout);
          onCourtLayout.setHorizontalGroup(
            onCourtLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(onCourtLayout.createSequentialGroup()
                .addGroup(onCourtLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(onCourtLayout.createSequentialGroup()
                        .addGap(170, 170, 170)
                        .addComponent(label_onCourtTitle))
                    .addGroup(onCourtLayout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addGroup(onCourtLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(onCourtLayout.createSequentialGroup()
                                .addComponent(label_tagRebound)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(label_showRebounds))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, onCourtLayout.createSequentialGroup()
                                .addComponent(label_tagAssists)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(label_showAssists))
                            .addComponent(label_showName, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(scroll_onCourt, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, onCourtLayout.createSequentialGroup()
                                .addComponent(label_tagPosition)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(label_showPos))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, onCourtLayout.createSequentialGroup()
                                .addComponent(label_tagPoints)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(label_showPoints))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, onCourtLayout.createSequentialGroup()
                                .addComponent(label_tagFouls)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(label_showFouls))
                            .addComponent(label_tagName)
                            .addGroup(onCourtLayout.createSequentialGroup()
                                .addGap(98, 98, 98)
                                .addComponent(button_toBench))
                            .addGroup(onCourtLayout.createSequentialGroup()
                                .addComponent(label_tagNum)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(label_showNum)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 131, Short.MAX_VALUE)
                        .addGroup(onCourtLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(onCourtLayout.createSequentialGroup()
                                .addGroup(onCourtLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(onCourtLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(button_addFoul)
                                        .addComponent(button_addAssist)
                                        .addComponent(button_addRebound))
                                    .addGroup(onCourtLayout.createSequentialGroup()
                                        .addGroup(onCourtLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(button_add1)
                                            .addComponent(button_add2, javax.swing.GroupLayout.Alignment.LEADING))
                                        .addGap(20, 20, 20)))
                                .addGap(45, 45, 45)
                                .addGroup(onCourtLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(button_subtractAssist)
                                    .addComponent(button_subtract1)
                                    .addComponent(button_subtractFoul)
                                    .addComponent(button_subtractRebound)
                                    .addComponent(button_subtract2)))
                            .addComponent(facePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(62, 62, 62))
            );
           onCourtLayout.setVerticalGroup(
            onCourtLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(onCourtLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(label_onCourtTitle)
                .addGap(21, 21, 21)
                .addGroup(onCourtLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scroll_onCourt, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(facePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(button_toBench)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(onCourtLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(button_add2)
                    .addComponent(button_subtract2))
                .addGroup(onCourtLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(onCourtLayout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(onCourtLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(label_tagName)
                            .addComponent(label_showName)))
                    .addGroup(onCourtLayout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(onCourtLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(button_add1)
                            .addComponent(button_subtract1))))
                .addGroup(onCourtLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(onCourtLayout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(onCourtLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(button_addAssist)
                            .addComponent(button_subtractAssist)))
                    .addGroup(onCourtLayout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(onCourtLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(label_tagPosition)
                            .addComponent(label_showPos))
                        .addGap(27, 27, 27)
                        .addGroup(onCourtLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(label_tagNum)
                            .addComponent(label_showNum))))
                .addGap(24, 24, 24)
                .addGroup(onCourtLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(button_addFoul)
                    .addComponent(button_subtractFoul)
                    .addComponent(label_tagPoints)
                    .addComponent(label_showPoints))
                .addGap(18, 18, 18)
                .addGroup(onCourtLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label_tagFouls)
                    .addComponent(label_showFouls))
                .addGap(8, 8, 8)
                .addGroup(onCourtLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(button_subtractRebound)
                    .addComponent(button_addRebound))
                .addGap(5, 5, 5)
                .addGroup(onCourtLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label_showAssists)
                    .addComponent(label_tagAssists))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(onCourtLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label_tagRebound)
                    .addComponent(label_showRebounds))
                .addGap(88, 88, 88))
           );
           //facePanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
               
              //label_face.setText("jLabel1");

              javax.swing.GroupLayout facePanelLayout = new javax.swing.GroupLayout(facePanel);
              facePanel.setLayout(facePanelLayout);
                facePanelLayout.setHorizontalGroup(
                facePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(facePanelLayout.createSequentialGroup()
                    .addGap(50, 50, 50)
                    .addComponent(label_face)
                    .addContainerGap(99, Short.MAX_VALUE))
                    );
              facePanelLayout.setVerticalGroup(
              facePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addGroup(facePanelLayout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addComponent(label_face)
                .addContainerGap(100, Short.MAX_VALUE))
                );
                
                setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

      }
      public void valueChanged(ListSelectionEvent e)
      {
          if(e.getValueIsAdjusting() == false)
            {
                if(list_onCourt.getSelectedIndex() == -1)  //if not selected, then disable buttons
                {
                    button_toBench.setEnabled(false);
                    button_add1.setEnabled(false);
                    button_add2.setEnabled(false);
                    button_addAssist.setEnabled(false);
                    button_addFoul.setEnabled(false);
                    button_addRebound.setEnabled(false);
                    button_subtract1.setEnabled(false); 
                    button_subtract2.setEnabled(false);
                    button_subtractAssist.setEnabled(false);
                    button_subtractFoul.setEnabled(false);
                    button_subtractRebound.setEnabled(false); 
                    clear(); //when athelte is not selected, or is removed, clear the information section
                }
                else       //if selected, enable button, and show athlete info
                {
                    button_toBench.setEnabled(true);
                    
                    button_add1.setEnabled(true); 
                    button_add2.setEnabled(true);
                    button_addAssist.setEnabled(true);
                    button_addFoul.setEnabled(true);
                    button_addRebound.setEnabled(true);
                    button_subtract1.setEnabled(true); 
                    button_subtract2.setEnabled(true);
                    button_subtractAssist.setEnabled(true);
                    button_subtractFoul.setEnabled(true);
                    button_subtractRebound.setEnabled(true); 
                    Athlete onSpotLight = (Athlete)default_onCourt.getElementAt(list_onCourt.getSelectedIndex());
                    showInfo(onSpotLight); //when athlete is selected, show info
                }
            }
      }
      public void showInfo(Athlete onSpot)  //shows athlete info on screen 
      {
          label_showName.setText(onSpot.accName());
          label_showFouls.setText(Integer.toString(onSpot.accFoul()));
          label_showNum.setText(Integer.toString(onSpot.accNumber()));
          label_showAssists.setText(Integer.toString(onSpot.accAssist()));
          label_showPoints.setText(Integer.toString(onSpot.accPoints()));
          label_showPos.setText(onSpot.accPosition());
          label_showRebounds.setText(Integer.toString(onSpot.accRebound()));
          
      }
      public void clear()    //clear information section
      {
         label_showAssists.setText("");
         label_showFouls.setText("");
         label_showName.setText("");
         label_showNum.setText("");
         label_showPoints.setText("");
         label_showPos.setText("");
         label_showRebounds.setText("");
      }  
      //button actionlisteners
      private class toBenchListener implements ActionListener
      {
          public void actionPerformed(ActionEvent e)
          {
              Athlete getBenched = (Athlete)default_onCourt.remove(list_onCourt.getSelectedIndex());
              default_Roster.add(0,getBenched);
          
          }
      }
     public class add1Listener implements ActionListener
      {
          public void actionPerformed(ActionEvent e)
          {
              Athlete theOne = (Athlete)default_onCourt.getElementAt(list_onCourt.getSelectedIndex());
              theOne.addPoints(1);
          }
      }
              
      /*public class Face extends JPanel
      {
          
          public Face()
          {
              super();
              facePanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
               
              label_face.setText("jLabel1");

              javax.swing.GroupLayout facePanelLayout = new javax.swing.GroupLayout(facePanel);
              facePanel.setLayout(facePanelLayout);
                facePanelLayout.setHorizontalGroup(
                facePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(facePanelLayout.createSequentialGroup()
                    .addGap(98, 98, 98)
                    .addComponent(label_face)
                    .addContainerGap(99, Short.MAX_VALUE))
                    );
              facePanelLayout.setVerticalGroup(
              facePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addGroup(facePanelLayout.createSequentialGroup()
                .addGap(95, 95, 95)
                .addComponent(label_face)
                .addContainerGap(127, Short.MAX_VALUE))
                );
          }
        }*/
              
  }
  private class AddRoster extends JPanel
  {
      public AddRoster()
      {
        GroupLayout addRosterLayout = new javax.swing.GroupLayout(this);
        this.setLayout(addRosterLayout);
        addRosterLayout.setHorizontalGroup(
            addRosterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addRosterLayout.createSequentialGroup()
                .addGroup(addRosterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(addRosterLayout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(addRosterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(label_position)
                            .addGroup(addRosterLayout.createSequentialGroup()
                                .addGroup(addRosterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(label_name)
                                    .addComponent(label_grade)
                                    .addComponent(label_number))
                                .addGap(47, 47, 47)
                                .addGroup(addRosterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(input_number, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(input_grade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(input_position, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(input_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(addRosterLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(button_add, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(button_stop)))
                .addContainerGap())
        );
        addRosterLayout.setVerticalGroup(
            addRosterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addRosterLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(addRosterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label_name)
                    .addComponent(input_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(addRosterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label_grade)
                    .addComponent(input_grade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(addRosterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label_position)
                    .addComponent(input_position, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(addRosterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label_number)
                    .addComponent(input_number, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(58, 58, 58)
                .addGroup(addRosterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(button_add)
                    .addComponent(button_stop))
                .addContainerGap(40, Short.MAX_VALUE))
        );
        
        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        
        button_add.addActionListener(new addListen());
    }
    private class addListen implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            try    //If the user did not complete the information to add to roster, then catch the excpetion show a pop up message 
            {
                String getName = input_name.getText();
                String getPos = input_position.getText();
                int tempNum = Integer.parseInt(input_number.getText());
                int tempGrade = Integer.parseInt(input_grade.getText());
                default_Roster.addElement(new Athlete(getName, getPos, tempNum, tempGrade));
            } catch(NumberFormatException n) {    
                //button_add.setEnabled(false);
                JOptionPane.showMessageDialog(null, "Please complete filling the information");  //popup message
            }
        }
   }
}
  public class Athlete
    {
        private String name;
        private String position;
        private int number;
        private int points;
        private int FGattempted;   //Field goal
        private int FGmade;
        private int fouls;
        private int FTattempted;      //Freethrow
        private int FTmade;
        private int assist;
        private int rebound;
        private int grade;
        public Athlete()
        {
            name = "Default";
            position = "Undecided";
            number = 0;
            points = 0;
            FGattempted = 0;
            FGmade  = 0;
            fouls = 0;
            FTattempted = 0; 
            FTmade = 0;
            assist = 0;
            rebound = 0;
            grade = 0;
            
        }
        public Athlete(String n, String pos, int num, int grad)
        {
            name = n;
            position = pos;
            number = num;
            grade = grad;
            points = 0;
            FGattempted = 0;
            FGmade  = 0;
            fouls = 0;
            FTattempted = 0; 
            FTmade = 0;
            assist = 0;
            rebound = 0;
        }
            
        /*public void getInfo()
        {
            Scanner sc = new Scanner(System.in);
            System.out.println("The name of the athlete: ");
            name = sc.nextLine();
            System.out.println("The back number of your athlete: ");
            number = sc.nextInt();
            System.out.println("The position of your athlete G - Guard F - Forward C - Center: ");
            position = sc.next().charAt(0);
        }*/
        //accessor
        public String accName()
        {
            return name;
        }
        public String accPosition()
        {
            return position;
        }
        public int accNumber()
        {
            return number;
        }
        public int accPoints()
        {
            return points;
        }
        public int accFGattempted()
        {
            return FGattempted;
        }
        public int accFGmade()
        {
            return FGmade;
        }
        public int accFoul()
        {
            return fouls;
        }
        public int accFTattempted()
        {
            return FTattempted;
        }
        public int accFTmade()
        {
            return FTmade;
        }
        public int accAssist()
        {
            return assist;
        }
        public int accRebound()
        {
            return rebound;
        }
        public String toString()
        {
            return("Name: "+name+" Grade: "+grade+" Position: "+position);
        }
        //modifier
        public void modNumber(int n)
        {
            number = n;
        }
        public void addPoints(int p)
        {
            points += p;
        }
        public void addFGattempted()
        {
            FGattempted++;
        }
        public void addFGmade()
        {
            FGmade++;
        }
        public void addFTattempted()
        {
            FTattempted++;
        }
        public void addFTmade()
        {
            FTmade++;
        }
        public void addAssist()
        {
            assist++;
        }
        public void addRebound()
        {
            rebound++;
        }
    }
  
    public static void main()
    {
        JFrame frame = new JFrame("Basketball Manage Program - Chris Kim");      
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new BasketballManageGUI());
        frame.setSize(1266,900);
        frame.setVisible(true);
    }
}
