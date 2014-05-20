/*
 * GUI for the scheduler app
 * basic calendar view of a schedule, with ability to add a new event
 */

package WeeklyViewCalendar;

import java.awt.event.ActionEvent;

import javax.swing.*;

/**
 *
 * @author Mitchell
 */
@SuppressWarnings("serial")
public class WeeklyCalFrame extends JFrame {
	// Variables declaration - do not modify   
    
    private JPanel dayNamesCont;
    private JPanel timeSideBarCont;
    
    //day panels/columns
    private JPanel monPanel;
    private JPanel tuePanel;
    private JPanel wedPanel;
    private JPanel thuPanel;
    private JPanel friPanel;
 
    private JLabel[] dayLabels;
    private JLabel[] timeLabels;
    
    private JSeparator[] separators;
    
    // menu items
    private JMenu fileMenu;
    private JMenu editMenu;
    private JMenuBar menuCont;
    private JMenuItem newEvent;
    // end of variables declaration

    /**
     * Creates new form WeeklyCalFrame
     */
    public WeeklyCalFrame() {
        initComponents();
    }
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {        
        // initialize the menu bar and labels, and other minor details
        createMenu();
        initializeLabels();
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(200, 230, 230));
        
        // Initialize separators
        separators = new JSeparator[17];
        for(int i = 0; i<separators.length; i++){
        	separators[i] = new JSeparator();
        }

        // Monday panel initialization
        monPanel = new JPanel();
        initializePanel(monPanel);
        GroupLayout mondayLayout = (GroupLayout) monPanel.getLayout();

        //TODO make this cleaner
        mondayLayout.setHorizontalGroup(
            mondayLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(separators[0], GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
            .addComponent(separators[1], GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
            .addComponent(separators[2], GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
            .addComponent(separators[3], GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
            .addComponent(separators[4], GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
            .addComponent(separators[5], GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
            .addComponent(separators[6], GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
            .addComponent(separators[7], GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
            .addComponent(separators[8], GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
            .addComponent(separators[9], GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
            .addComponent(separators[10], GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
            .addComponent(separators[11], GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
            .addComponent(separators[12], GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
            .addComponent(separators[13], GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
            .addComponent(separators[14], GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
            .addComponent(separators[15], GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
            .addComponent(separators[16], GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
        );
        mondayLayout.setVerticalGroup(
            mondayLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(mondayLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(separators[0], GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(separators[1], GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(separators[2], GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(separators[3], GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(separators[4], GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(separators[5], GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(separators[6], GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(separators[7], GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(separators[8], GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(separators[9], GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(separators[10], GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(separators[11], GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(separators[12], GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(separators[13], GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(separators[14], GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(separators[15], GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(separators[16], GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(34, Short.MAX_VALUE))
        );

        // Tuesday panel initialization
        tuePanel = new JPanel();
        initializePanel(tuePanel);

        // Wednesday panel initialization
        wedPanel = new JPanel();
        initializePanel(wedPanel);

        // Thursday panel initialization
        thuPanel = new JPanel();
        initializePanel(thuPanel);
        
        // Friday panel initialization
        friPanel = new JPanel();
        initializePanel(friPanel);
        

        dayNamesCont = new JPanel();
        GroupLayout dayNamesContLayout = new GroupLayout(dayNamesCont);
        dayNamesCont.setLayout(dayNamesContLayout);
        dayNamesContLayout.setHorizontalGroup(
            dayNamesContLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(dayNamesContLayout.createSequentialGroup()
                .addGap(110, 110, 110)
                .addComponent(dayLabels[0], GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE)
                .addGap(62, 62, 62)
                .addComponent(dayLabels[1], GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE)
                .addGap(63, 63, 63)
                .addComponent(dayLabels[2], GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE)
                .addGap(60, 60, 60)
                .addComponent(dayLabels[3], GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                .addComponent(dayLabels[4], GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44))
        );
        dayNamesContLayout.setVerticalGroup(
            dayNamesContLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(dayLabels[0], GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE)
            .addComponent(dayLabels[1], GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(dayLabels[2], GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(dayLabels[3], GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(dayLabels[4], GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        timeSideBarCont = new JPanel();
        GroupLayout timeSideBarContLayout = new GroupLayout(timeSideBarCont);
        timeSideBarCont.setLayout(timeSideBarContLayout);
        timeSideBarContLayout.setHorizontalGroup(
            timeSideBarContLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(timeLabels[0], GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(timeLabels[1], GroupLayout.DEFAULT_SIZE, 72, Short.MAX_VALUE)
            .addComponent(timeLabels[2], GroupLayout.DEFAULT_SIZE, 72, Short.MAX_VALUE)
            .addComponent(timeLabels[3], GroupLayout.DEFAULT_SIZE, 72, Short.MAX_VALUE)
            .addComponent(timeLabels[4], GroupLayout.DEFAULT_SIZE, 72, Short.MAX_VALUE)
            .addComponent(timeLabels[5], GroupLayout.DEFAULT_SIZE, 72, Short.MAX_VALUE)
            .addComponent(timeLabels[6], GroupLayout.DEFAULT_SIZE, 72, Short.MAX_VALUE)
            .addComponent(timeLabels[7], GroupLayout.DEFAULT_SIZE, 72, Short.MAX_VALUE)
            .addComponent(timeLabels[8], GroupLayout.DEFAULT_SIZE, 72, Short.MAX_VALUE)
            .addComponent(timeLabels[9], GroupLayout.DEFAULT_SIZE, 72, Short.MAX_VALUE)
            .addComponent(timeLabels[10], GroupLayout.DEFAULT_SIZE, 72, Short.MAX_VALUE)
            .addComponent(timeLabels[11], GroupLayout.DEFAULT_SIZE, 72, Short.MAX_VALUE)
            .addComponent(timeLabels[12], GroupLayout.DEFAULT_SIZE, 72, Short.MAX_VALUE)
            .addComponent(timeLabels[13], GroupLayout.DEFAULT_SIZE, 72, Short.MAX_VALUE)
            .addComponent(timeLabels[14], GroupLayout.DEFAULT_SIZE, 72, Short.MAX_VALUE)
            .addComponent(timeLabels[15], GroupLayout.DEFAULT_SIZE, 72, Short.MAX_VALUE)
            .addComponent(timeLabels[16], GroupLayout.DEFAULT_SIZE, 72, Short.MAX_VALUE)
            .addComponent(timeLabels[17], GroupLayout.DEFAULT_SIZE, 72, Short.MAX_VALUE)
        );
        timeSideBarContLayout.setVerticalGroup(
            timeSideBarContLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(timeSideBarContLayout.createSequentialGroup()
                .addComponent(timeLabels[0], GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(timeLabels[1], GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(timeLabels[2], GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(timeLabels[3], GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(timeLabels[4], GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(timeLabels[5], GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(timeLabels[6], GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(timeLabels[7], GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(timeLabels[8], GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(timeLabels[9], GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(timeLabels[10], GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(timeLabels[11], GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(timeLabels[12], GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(timeLabels[13], GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(timeLabels[14], GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(timeLabels[15], GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(timeLabels[16], GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(timeLabels[17], GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
                
                .addGap(0, 0, Short.MAX_VALUE))
        );

        
        // this is code that was auto generated by netbeans gui editor
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(timeSideBarCont, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(monPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addGap(8, 8, 8)
                        .addComponent(tuePanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(wedPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(thuPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(friPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addComponent(dayNamesCont, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(dayNamesCont, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(wedPanel, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(thuPanel, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(friPanel, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tuePanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(monPanel, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(timeSideBarCont, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        // end auto generated code

        pack();
    }// </editor-fold>

    
    // action to be executed when the "new event" menu button is selected
    private void newEventActionPerformed(ActionEvent evt) {
    	NewEventDialog newEventDialog = new NewEventDialog();
        newEventDialog.setVisible(true);
        newEventDialog.setSize(newEventDialog.getPreferredSize());
    }                                                                                   

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(WeeklyCalFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(WeeklyCalFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(WeeklyCalFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(WeeklyCalFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new WeeklyCalFrame().setVisible(true);
            }
        });
    }
    
    private void createMenu(){
        menuCont = new JMenuBar();
        fileMenu = new JMenu();
        newEvent = new JMenuItem();
        editMenu = new JMenu();
        
        fileMenu.setText("File");

        newEvent.setAccelerator(KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_MASK));
        newEvent.setText("New Event");
        newEvent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newEventActionPerformed(evt);
            }
        });
        fileMenu.add(newEvent);

        menuCont.add(fileMenu);

        editMenu.setText("Edit");
        menuCont.add(editMenu);

        setJMenuBar(menuCont);
    }
   
    // initialization of the arrays of labels
    private void initializeLabels(){
    	// Initialize day labels
        dayLabels = new JLabel[5];
        for(int i = 0; i<dayLabels.length; i++){
        	dayLabels[i] = new JLabel();
            dayLabels[i].setLabelFor(dayNamesCont);
        }
        dayLabels[0].setText("Monday");
        dayLabels[1].setText("Tuesday");
        dayLabels[2].setText("Wednesday");
        dayLabels[3].setText("Thursday");
        dayLabels[4].setText("Friday");
        
        // Initialize time labels
        timeLabels = new JLabel[18];
        for(int i = 0; i<timeLabels.length; i++){
        	timeLabels[i] = new JLabel();
        	timeLabels[i].setHorizontalAlignment(SwingConstants.TRAILING);
        	timeLabels[i].setLabelFor(timeSideBarCont);
        	timeLabels[i].setText(":"+i);
        }
    }
    
    private void initializePanel(JPanel panel){
        panel.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        GroupLayout layout = new GroupLayout(panel);
        panel.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 140, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
    }
}