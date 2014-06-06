/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package scheduleproject;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.*;
import javax.swing.GroupLayout.ParallelGroup;
import javax.swing.GroupLayout.SequentialGroup;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;

import scheduleproject.Schedule;


/**
 *
 * @author Mitchell
 */
@SuppressWarnings("serial")
public class WeeklyCalFrame extends JFrame {
	private static final Logger logger = Logger.getLogger(WeeklyCalFrame.class.getName());
	
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

	//event labels

	public JLabel[] monEventLabels;
	public JLabel[] tuesEventLabels;
	public JLabel[] wedEventLabels;
	public JLabel[] thurEventLabels;
	public JLabel[] friEventLabels;

	// menu items
	private JMenu fileMenu;
	private JMenu editMenu;
	private JMenuBar menuCont;
	private JMenuItem newEvent;
	private JMenuItem loadSched;
	private JMenuItem saveSched;
	private JMenuItem compare;
	private JMenuItem addClass;

	protected int colorIndex;

	private Schedule mySchedule;
	private ArrayList<Events> classList;
	// end of variables declaration

	/**
	 * Creates new form WeeklyCalFrame
	 */
	public WeeklyCalFrame(Schedule s) {
		mySchedule = s;
		classList = CourseTokenizer.parseCourses();
		String name = JOptionPane.showInputDialog("What is your name?");
		mySchedule.setName(name + "'s Schedule");
		initComponents();
		this.setTitle(s.getName());
	}

	// <editor-fold defaultstate="collapsed" desc="Generated Code">                          
	private void initComponents() {        
		// initialize the menu bar and labels, and other minor details
		createMenu();
		initializeLabels();
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setBackground(new Color(200, 230, 230));

		// Initialize event labels
		monEventLabels = new JLabel[36];
		tuesEventLabels = new JLabel[36];
		wedEventLabels = new JLabel[36];
		thurEventLabels = new JLabel[36];
		friEventLabels = new JLabel[36];

		colorIndex = 0;

		for(int i = 0; i<monEventLabels.length; i++){
			monEventLabels[i] = new JLabel();
			tuesEventLabels[i] = new JLabel();
			wedEventLabels[i] = new JLabel();
			thurEventLabels[i] = new JLabel();
			friEventLabels[i] = new JLabel();     
		}

		// Monday panel initialization
		monPanel = new JPanel();
		initializePanel(monPanel);
		GroupLayout mondayLayout = (GroupLayout) monPanel.getLayout();

		ParallelGroup monHoriGroup = mondayLayout.createParallelGroup(GroupLayout.Alignment.LEADING);
		monHoriGroup.addComponent(monEventLabels[0], GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE);
		for(int i = 1; i<monEventLabels.length; i++){
			monHoriGroup.addComponent(monEventLabels[i], GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE);
		}
		System.out.println("Default:" + GroupLayout.DEFAULT_SIZE);
		mondayLayout.setHorizontalGroup(monHoriGroup);
		/*mondayLayout.setHorizontalGroup(
				mondayLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addComponent(monEventLabels[0], GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
				.addComponent(monEventLabels[1], GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
				.addComponent(monEventLabels[2], GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
				.addComponent(monEventLabels[3], GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
				.addComponent(monEventLabels[4], GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
				.addComponent(monEventLabels[5], GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
				.addComponent(monEventLabels[6], GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
				.addComponent(monEventLabels[7], GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
				.addComponent(monEventLabels[8], GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
				.addComponent(monEventLabels[9], GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
				.addComponent(monEventLabels[10], GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
				.addComponent(monEventLabels[11], GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
				.addComponent(monEventLabels[12], GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
				.addComponent(monEventLabels[13], GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
				.addComponent(monEventLabels[14], GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
				.addComponent(monEventLabels[15], GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
				.addComponent(monEventLabels[16], GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
				.addComponent(monEventLabels[17], GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
				.addComponent(monEventLabels[18], GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
				.addComponent(monEventLabels[19], GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
				.addComponent(monEventLabels[20], GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
				.addComponent(monEventLabels[21], GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
				.addComponent(monEventLabels[22], GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
				.addComponent(monEventLabels[23], GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
				.addComponent(monEventLabels[24], GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
				.addComponent(monEventLabels[25], GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
				.addComponent(monEventLabels[26], GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
				.addComponent(monEventLabels[27], GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
				.addComponent(monEventLabels[28], GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
				.addComponent(monEventLabels[29], GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
				.addComponent(monEventLabels[30], GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
				.addComponent(monEventLabels[31], GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
				.addComponent(monEventLabels[32], GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
				.addComponent(monEventLabels[33], GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
				.addComponent(monEventLabels[34], GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
				.addComponent(monEventLabels[35], GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
				);*/
		SequentialGroup monVertGroup = mondayLayout.createSequentialGroup();
		for(int i = 0; i<monEventLabels.length; i++){
			monVertGroup.addComponent(monEventLabels[i], GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE);
		}
		mondayLayout.setVerticalGroup(
				mondayLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(monVertGroup));
		/*mondayLayout.setVerticalGroup(
				mondayLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(mondayLayout.createSequentialGroup()
						.addComponent(monEventLabels[0], GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
						.addComponent(monEventLabels[1], GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
						.addComponent(monEventLabels[2], GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
						.addComponent(monEventLabels[3], GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
						.addComponent(monEventLabels[4], GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
						.addComponent(monEventLabels[5], GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
						.addComponent(monEventLabels[6], GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
						.addComponent(monEventLabels[7], GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
						.addComponent(monEventLabels[8], GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
						.addComponent(monEventLabels[9], GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
						.addComponent(monEventLabels[10], GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
						.addComponent(monEventLabels[11], GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
						.addComponent(monEventLabels[12], GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
						.addComponent(monEventLabels[13], GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
						.addComponent(monEventLabels[14], GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
						.addComponent(monEventLabels[15], GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
						.addComponent(monEventLabels[16], GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
						.addComponent(monEventLabels[17], GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
						.addComponent(monEventLabels[18], GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
						.addComponent(monEventLabels[19], GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
						.addComponent(monEventLabels[20], GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
						.addComponent(monEventLabels[21], GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
						.addComponent(monEventLabels[22], GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
						.addComponent(monEventLabels[23], GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
						.addComponent(monEventLabels[24], GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
						.addComponent(monEventLabels[25], GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
						.addComponent(monEventLabels[26], GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
						.addComponent(monEventLabels[27], GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
						.addComponent(monEventLabels[28], GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
						.addComponent(monEventLabels[29], GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
						.addComponent(monEventLabels[30], GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
						.addComponent(monEventLabels[31], GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
						.addComponent(monEventLabels[32], GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
						.addComponent(monEventLabels[33], GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
						.addComponent(monEventLabels[34], GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
						.addComponent(monEventLabels[35], GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)

						));*/

		// Tuesday panel initialization
		tuePanel = new JPanel();
		initializePanel(tuePanel);

		GroupLayout tuesdayLayout = (GroupLayout) tuePanel.getLayout();

		tuesdayLayout.setHorizontalGroup(
				tuesdayLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addComponent(tuesEventLabels[0], GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
				.addComponent(tuesEventLabels[1], GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
				.addComponent(tuesEventLabels[2], GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
				.addComponent(tuesEventLabels[3], GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
				.addComponent(tuesEventLabels[4], GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
				.addComponent(tuesEventLabels[5], GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
				.addComponent(tuesEventLabels[6], GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
				.addComponent(tuesEventLabels[7], GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
				.addComponent(tuesEventLabels[8], GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
				.addComponent(tuesEventLabels[9], GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
				.addComponent(tuesEventLabels[10], GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
				.addComponent(tuesEventLabels[11], GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
				.addComponent(tuesEventLabels[12], GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
				.addComponent(tuesEventLabels[13], GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
				.addComponent(tuesEventLabels[14], GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
				.addComponent(tuesEventLabels[15], GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
				.addComponent(tuesEventLabels[16], GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
				.addComponent(tuesEventLabels[17], GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
				.addComponent(tuesEventLabels[18], GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
				.addComponent(tuesEventLabels[19], GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
				.addComponent(tuesEventLabels[20], GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
				.addComponent(tuesEventLabels[21], GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
				.addComponent(tuesEventLabels[22], GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
				.addComponent(tuesEventLabels[23], GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
				.addComponent(tuesEventLabels[24], GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
				.addComponent(tuesEventLabels[25], GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
				.addComponent(tuesEventLabels[26], GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
				.addComponent(tuesEventLabels[27], GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
				.addComponent(tuesEventLabels[28], GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
				.addComponent(tuesEventLabels[29], GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
				.addComponent(tuesEventLabels[30], GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
				.addComponent(tuesEventLabels[31], GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
				.addComponent(tuesEventLabels[32], GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
				.addComponent(tuesEventLabels[33], GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
				.addComponent(tuesEventLabels[34], GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
				.addComponent(tuesEventLabels[35], GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
				);
		tuesdayLayout.setVerticalGroup(
				tuesdayLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(tuesdayLayout.createSequentialGroup()
						.addComponent(tuesEventLabels[0], GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
						.addComponent(tuesEventLabels[1], GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
						.addComponent(tuesEventLabels[2], GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
						.addComponent(tuesEventLabels[3], GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
						.addComponent(tuesEventLabels[4], GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
						.addComponent(tuesEventLabels[5], GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
						.addComponent(tuesEventLabels[6], GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
						.addComponent(tuesEventLabels[7], GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
						.addComponent(tuesEventLabels[8], GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
						.addComponent(tuesEventLabels[9], GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
						.addComponent(tuesEventLabels[10], GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
						.addComponent(tuesEventLabels[11], GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
						.addComponent(tuesEventLabels[12], GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
						.addComponent(tuesEventLabels[13], GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
						.addComponent(tuesEventLabels[14], GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
						.addComponent(tuesEventLabels[15], GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
						.addComponent(tuesEventLabels[16], GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
						.addComponent(tuesEventLabels[17], GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
						.addComponent(tuesEventLabels[18], GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
						.addComponent(tuesEventLabels[19], GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
						.addComponent(tuesEventLabels[20], GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
						.addComponent(tuesEventLabels[21], GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
						.addComponent(tuesEventLabels[22], GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
						.addComponent(tuesEventLabels[23], GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
						.addComponent(tuesEventLabels[24], GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
						.addComponent(tuesEventLabels[25], GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
						.addComponent(tuesEventLabels[26], GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
						.addComponent(tuesEventLabels[27], GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
						.addComponent(tuesEventLabels[28], GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
						.addComponent(tuesEventLabels[29], GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
						.addComponent(tuesEventLabels[30], GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
						.addComponent(tuesEventLabels[31], GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
						.addComponent(tuesEventLabels[32], GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
						.addComponent(tuesEventLabels[33], GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
						.addComponent(tuesEventLabels[34], GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
						.addComponent(tuesEventLabels[35], GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)

						));

		// Wednesday panel initialization
		wedPanel = new JPanel();
		initializePanel(wedPanel);

		GroupLayout wednesdayLayout = (GroupLayout) wedPanel.getLayout();

		wednesdayLayout.setHorizontalGroup(
				wednesdayLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addComponent(wedEventLabels[0], GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
				.addComponent(wedEventLabels[1], GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
				.addComponent(wedEventLabels[2], GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
				.addComponent(wedEventLabels[3], GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
				.addComponent(wedEventLabels[4], GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
				.addComponent(wedEventLabels[5], GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
				.addComponent(wedEventLabels[6], GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
				.addComponent(wedEventLabels[7], GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
				.addComponent(wedEventLabels[8], GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
				.addComponent(wedEventLabels[9], GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
				.addComponent(wedEventLabels[10], GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
				.addComponent(wedEventLabels[11], GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
				.addComponent(wedEventLabels[12], GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
				.addComponent(wedEventLabels[13], GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
				.addComponent(wedEventLabels[14], GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
				.addComponent(wedEventLabels[15], GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
				.addComponent(wedEventLabels[16], GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
				.addComponent(wedEventLabels[17], GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
				.addComponent(wedEventLabels[18], GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
				.addComponent(wedEventLabels[19], GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
				.addComponent(wedEventLabels[20], GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
				.addComponent(wedEventLabels[21], GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
				.addComponent(wedEventLabels[22], GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
				.addComponent(wedEventLabels[23], GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
				.addComponent(wedEventLabels[24], GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
				.addComponent(wedEventLabels[25], GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
				.addComponent(wedEventLabels[26], GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
				.addComponent(wedEventLabels[27], GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
				.addComponent(wedEventLabels[28], GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
				.addComponent(wedEventLabels[29], GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
				.addComponent(wedEventLabels[30], GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
				.addComponent(wedEventLabels[31], GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
				.addComponent(wedEventLabels[32], GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
				.addComponent(wedEventLabels[33], GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
				.addComponent(wedEventLabels[34], GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
				.addComponent(wedEventLabels[35], GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)

				);
		wednesdayLayout.setVerticalGroup(
				wednesdayLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(wednesdayLayout.createSequentialGroup()
						.addComponent(wedEventLabels[0], GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
						.addComponent(wedEventLabels[1], GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
						.addComponent(wedEventLabels[2], GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
						.addComponent(wedEventLabels[3], GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
						.addComponent(wedEventLabels[4], GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
						.addComponent(wedEventLabels[5], GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
						.addComponent(wedEventLabels[6], GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
						.addComponent(wedEventLabels[7], GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
						.addComponent(wedEventLabels[8], GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
						.addComponent(wedEventLabels[9], GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
						.addComponent(wedEventLabels[10], GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
						.addComponent(wedEventLabels[11], GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
						.addComponent(wedEventLabels[12], GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
						.addComponent(wedEventLabels[13], GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
						.addComponent(wedEventLabels[14], GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
						.addComponent(wedEventLabels[15], GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
						.addComponent(wedEventLabels[16], GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
						.addComponent(wedEventLabels[17], GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
						.addComponent(wedEventLabels[18], GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
						.addComponent(wedEventLabels[19], GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
						.addComponent(wedEventLabels[20], GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
						.addComponent(wedEventLabels[21], GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
						.addComponent(wedEventLabels[22], GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
						.addComponent(wedEventLabels[23], GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
						.addComponent(wedEventLabels[24], GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
						.addComponent(wedEventLabels[25], GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
						.addComponent(wedEventLabels[26], GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
						.addComponent(wedEventLabels[27], GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
						.addComponent(wedEventLabels[28], GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
						.addComponent(wedEventLabels[29], GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
						.addComponent(wedEventLabels[30], GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
						.addComponent(wedEventLabels[31], GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
						.addComponent(wedEventLabels[32], GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
						.addComponent(wedEventLabels[33], GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
						.addComponent(wedEventLabels[34], GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
						.addComponent(wedEventLabels[35], GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)

						));

		// Thursday panel initialization
		thuPanel = new JPanel();
		initializePanel(thuPanel);

		GroupLayout thursdayLayout = (GroupLayout) thuPanel.getLayout();

		thursdayLayout.setHorizontalGroup(
				thursdayLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addComponent(thurEventLabels[0], GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
				.addComponent(thurEventLabels[1], GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
				.addComponent(thurEventLabels[2], GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
				.addComponent(thurEventLabels[3], GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
				.addComponent(thurEventLabels[4], GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
				.addComponent(thurEventLabels[5], GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
				.addComponent(thurEventLabels[6], GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
				.addComponent(thurEventLabels[7], GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
				.addComponent(thurEventLabels[8], GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
				.addComponent(thurEventLabels[9], GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
				.addComponent(thurEventLabels[10], GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
				.addComponent(thurEventLabels[11], GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
				.addComponent(thurEventLabels[12], GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
				.addComponent(thurEventLabels[13], GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
				.addComponent(thurEventLabels[14], GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
				.addComponent(thurEventLabels[15], GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
				.addComponent(thurEventLabels[16], GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
				.addComponent(thurEventLabels[17], GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
				.addComponent(thurEventLabels[18], GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
				.addComponent(thurEventLabels[19], GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
				.addComponent(thurEventLabels[20], GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
				.addComponent(thurEventLabels[21], GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
				.addComponent(thurEventLabels[22], GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
				.addComponent(thurEventLabels[23], GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
				.addComponent(thurEventLabels[24], GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
				.addComponent(thurEventLabels[25], GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
				.addComponent(thurEventLabels[26], GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
				.addComponent(thurEventLabels[27], GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
				.addComponent(thurEventLabels[28], GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
				.addComponent(thurEventLabels[29], GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
				.addComponent(thurEventLabels[30], GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
				.addComponent(thurEventLabels[31], GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
				.addComponent(thurEventLabels[32], GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
				.addComponent(thurEventLabels[33], GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
				.addComponent(thurEventLabels[34], GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
				.addComponent(thurEventLabels[35], GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
				);
		thursdayLayout.setVerticalGroup(
				thursdayLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(thursdayLayout.createSequentialGroup()
						.addComponent(thurEventLabels[0], GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
						.addComponent(thurEventLabels[1], GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
						.addComponent(thurEventLabels[2], GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
						.addComponent(thurEventLabels[3], GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
						.addComponent(thurEventLabels[4], GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
						.addComponent(thurEventLabels[5], GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
						.addComponent(thurEventLabels[6], GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
						.addComponent(thurEventLabels[7], GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
						.addComponent(thurEventLabels[8], GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
						.addComponent(thurEventLabels[9], GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
						.addComponent(thurEventLabels[10], GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
						.addComponent(thurEventLabels[11], GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
						.addComponent(thurEventLabels[12], GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
						.addComponent(thurEventLabels[13], GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
						.addComponent(thurEventLabels[14], GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
						.addComponent(thurEventLabels[15], GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
						.addComponent(thurEventLabels[16], GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
						.addComponent(thurEventLabels[17], GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
						.addComponent(thurEventLabels[18], GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
						.addComponent(thurEventLabels[19], GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
						.addComponent(thurEventLabels[20], GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
						.addComponent(thurEventLabels[21], GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
						.addComponent(thurEventLabels[22], GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
						.addComponent(thurEventLabels[23], GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
						.addComponent(thurEventLabels[24], GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
						.addComponent(thurEventLabels[25], GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
						.addComponent(thurEventLabels[26], GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
						.addComponent(thurEventLabels[27], GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
						.addComponent(thurEventLabels[28], GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
						.addComponent(thurEventLabels[29], GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
						.addComponent(thurEventLabels[30], GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
						.addComponent(thurEventLabels[31], GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
						.addComponent(thurEventLabels[32], GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
						.addComponent(thurEventLabels[33], GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
						.addComponent(thurEventLabels[34], GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
						.addComponent(thurEventLabels[35], GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)

						));

		// Friday panel initialization
		friPanel = new JPanel();
		initializePanel(friPanel);

		GroupLayout fridayLayout = (GroupLayout) friPanel.getLayout();

		fridayLayout.setHorizontalGroup(
				fridayLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addComponent(friEventLabels[0], GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
				.addComponent(friEventLabels[1], GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
				.addComponent(friEventLabels[2], GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
				.addComponent(friEventLabels[3], GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
				.addComponent(friEventLabels[4], GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
				.addComponent(friEventLabels[5], GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
				.addComponent(friEventLabels[6], GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
				.addComponent(friEventLabels[7], GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
				.addComponent(friEventLabels[8], GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
				.addComponent(friEventLabels[9], GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
				.addComponent(friEventLabels[10], GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
				.addComponent(friEventLabels[11], GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
				.addComponent(friEventLabels[12], GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
				.addComponent(friEventLabels[13], GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
				.addComponent(friEventLabels[14], GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
				.addComponent(friEventLabels[15], GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
				.addComponent(friEventLabels[16], GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
				.addComponent(friEventLabels[17], GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
				.addComponent(friEventLabels[18], GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
				.addComponent(friEventLabels[19], GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
				.addComponent(friEventLabels[20], GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
				.addComponent(friEventLabels[21], GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
				.addComponent(friEventLabels[22], GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
				.addComponent(friEventLabels[23], GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
				.addComponent(friEventLabels[24], GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
				.addComponent(friEventLabels[25], GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
				.addComponent(friEventLabels[26], GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
				.addComponent(friEventLabels[27], GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
				.addComponent(friEventLabels[28], GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
				.addComponent(friEventLabels[29], GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
				.addComponent(friEventLabels[30], GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
				.addComponent(friEventLabels[31], GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
				.addComponent(friEventLabels[32], GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
				.addComponent(friEventLabels[33], GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
				.addComponent(friEventLabels[34], GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
				.addComponent(friEventLabels[35], GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
				);
		fridayLayout.setVerticalGroup(
				fridayLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(fridayLayout.createSequentialGroup()
						.addComponent(friEventLabels[0], GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
						.addComponent(friEventLabels[1], GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
						.addComponent(friEventLabels[2], GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
						.addComponent(friEventLabels[3], GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
						.addComponent(friEventLabels[4], GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
						.addComponent(friEventLabels[5], GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
						.addComponent(friEventLabels[6], GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
						.addComponent(friEventLabels[7], GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
						.addComponent(friEventLabels[8], GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
						.addComponent(friEventLabels[9], GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
						.addComponent(friEventLabels[10], GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
						.addComponent(friEventLabels[11], GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
						.addComponent(friEventLabels[12], GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
						.addComponent(friEventLabels[13], GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
						.addComponent(friEventLabels[14], GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
						.addComponent(friEventLabels[15], GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
						.addComponent(friEventLabels[16], GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
						.addComponent(friEventLabels[17], GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
						.addComponent(friEventLabels[18], GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
						.addComponent(friEventLabels[19], GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
						.addComponent(friEventLabels[20], GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
						.addComponent(friEventLabels[21], GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
						.addComponent(friEventLabels[22], GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
						.addComponent(friEventLabels[23], GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
						.addComponent(friEventLabels[24], GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
						.addComponent(friEventLabels[25], GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
						.addComponent(friEventLabels[26], GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
						.addComponent(friEventLabels[27], GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
						.addComponent(friEventLabels[28], GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
						.addComponent(friEventLabels[29], GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
						.addComponent(friEventLabels[30], GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
						.addComponent(friEventLabels[31], GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
						.addComponent(friEventLabels[32], GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
						.addComponent(friEventLabels[33], GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
						.addComponent(friEventLabels[34], GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
						.addComponent(friEventLabels[35], GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE))
				);


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
		NewEventDialog newEventDialog = new NewEventDialog(WeeklyCalFrame.this);
		if(colorIndex < 8){
			colorIndex ++;
		}
		else{
			colorIndex = 0;
		}
		newEventDialog.setVisible(true);
		newEventDialog.setSize(newEventDialog.getPreferredSize());
	}

	private void compareActionPerformed(ActionEvent e){
		Schedule otherSchedule;
		Schedule freeTime;

		// Call load method to use file picker to load in a schedule

		JFileChooser fc = new JFileChooser();
		int returnVal = fc.showOpenDialog(WeeklyCalFrame.this);

		if (returnVal == JFileChooser.APPROVE_OPTION) {
			File file = fc.getSelectedFile();
			logger.log(Level.INFO, "Opening " + file.getPath() + "/" + file.getName());
			otherSchedule = Schedule.deserialize(file.getPath());
		}
		else{
			otherSchedule = new Schedule();
		}


		// Compare the two schedules, resulting in a schedule

		freeTime = mySchedule.bothFree(otherSchedule);

		// Example comparison:

		this.setTitle(freeTime.getName());

		Events events[] = freeTime.getEvents();

		int i = 0;

		while(events[i].occursOnDay("M")){
			this.setMondayEvents(events[i], 8);
			i++;
		}
		while(events[i].occursOnDay("TU")){
			this.setTuesdayEvents(events[i], 8);
			i++;
		}
		while(events[i].occursOnDay("W")){
			this.setWednesdayEvents(events[i], 8);
			i++;
		}
		while(events[i].occursOnDay("TH")){
			this.setThursdayEvents(events[i], 8);
			i++;
		}
		while(events[i].occursOnDay("F")){
			this.setFridayEvents(events[i], 8);
			i++;
			if(events[i] == null){
				break;
			}
		}


		//throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	private void renderSchedule(){
		Events[] events = mySchedule.getEvents();
		int i = 0;
		while (events[i] != null) {
			if (events[i].occursOnDay("M")) {
				this.setMondayEvents(events[i], colorIndex);
			}
			if (events[i].occursOnDay("TU")) {
				this.setTuesdayEvents(events[i], colorIndex);
			}
			if (events[i].occursOnDay("W")) {
				this.setWednesdayEvents(events[i], colorIndex);
			}
			if (events[i].occursOnDay("TH")) {
				this.setThursdayEvents(events[i], colorIndex);
			}
			if (events[i].occursOnDay("F")) {
				this.setFridayEvents(events[i], colorIndex);
			}
			if(colorIndex < 8){
				colorIndex++;
			}
			else
				colorIndex = 0;
			i++;
		}
	}

	// create the menu bar
	private void createMenu(){
		menuCont = new JMenuBar();
		fileMenu = new JMenu();
		newEvent = new JMenuItem();
		editMenu = new JMenu();
		loadSched = new JMenuItem();
		saveSched = new JMenuItem();
		compare = new JMenuItem();
		addClass = new JMenuItem();

		fileMenu.setText("File");

		newEvent.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.CTRL_MASK));
		newEvent.setText("New Event");
		newEvent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				newEventActionPerformed(evt);
			}
		});
		editMenu.add(newEvent);


		loadSched.setText("Load a Schedule");
		loadSched.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent evt) {
				clearSchedule();
				JFileChooser fc = new JFileChooser();
				int returnVal = fc.showOpenDialog(WeeklyCalFrame.this);

				if (returnVal == JFileChooser.APPROVE_OPTION) {
					File file = fc.getSelectedFile();
					logger.log(Level.INFO, "Loading schedule from " + file.getPath() + "/" + file.getName());
					mySchedule = Schedule.deserialize(file.getPath());

					renderSchedule();
					setTitle(mySchedule.getName());
				}
			}
		});
		fileMenu.add(loadSched);


		saveSched.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_MASK));
		saveSched.setText("Save Schedule");
		saveSched.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				JFileChooser fc = new JFileChooser();
				int returnVal = fc.showSaveDialog(WeeklyCalFrame.this);

				if (returnVal == JFileChooser.APPROVE_OPTION) {
					File file = fc.getSelectedFile();
					try {
						file.createNewFile();
					} catch (IOException e) {
						e.printStackTrace();
					}
					logger.log(Level.INFO, "Saving schedule to " + file.getPath() + "/" + file.getName());
					mySchedule.serialize(file.getPath()+".sch");
				}
			}
		});
		fileMenu.add(saveSched);


		compare.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, InputEvent.CTRL_MASK));
		compare.setText("Compare to...");
		fileMenu.add(compare);
		compare.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				clearSchedule();
				compareActionPerformed(e);
			}
		});
		
		addClass.setText("Add a class");
		editMenu.add(addClass);
		addClass.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				AddClassDialog classDialog = new AddClassDialog(WeeklyCalFrame.this, classList);
				if(colorIndex < 8){
					colorIndex ++;
				}
				else{
					colorIndex = 0;
				}
				classDialog.setVisible(true);
				classDialog.setSize(classDialog.getPreferredSize());			}
		});


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
			timeLabels[i].setVerticalTextPosition(JLabel.TOP);
			timeLabels[i].setLabelFor(timeSideBarCont);
			timeLabels[i].setText(Constants.TIMES[2*i]);
		}
	}

	private void initializePanel(JPanel panel){
		panel.setBorder(new SoftBevelBorder(BevelBorder.RAISED));
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
	//fuctions that display events visually 
	private void setMondayEvents(Events event, int index){

		int begI = event.Time.getTime()/30 - 12;
		int endI = event.Time.getEnd()/30 - 12;
		boolean setTextInLabel = true;

		for(int i = begI; i < endI; i++ ){
			if(setTextInLabel){
				monEventLabels[i].setText(event.eventName);
				monEventLabels[i].setVerticalTextPosition(JLabel.TOP);
				setTextInLabel = false;
			}
			monEventLabels[i].setBackground(Color.decode(Constants.USER_COLOR[index]));
			monEventLabels[i].setOpaque(true);
		}
	}

	private void setTuesdayEvents(Events event, int index){

		int begI = event.Time.getTime()/30 - 12;
		int endI = event.Time.getEnd()/30 - 12;
		boolean setTextInLabel = true;

		for(int i = begI; i < endI; i++ ){
			if(setTextInLabel){
				tuesEventLabels[i].setText(event.eventName);
				tuesEventLabels[i].setVerticalTextPosition(JLabel.TOP);
				setTextInLabel = false;
			}
			tuesEventLabels[i].setBackground(Color.decode(Constants.USER_COLOR[index]));
			tuesEventLabels[i].setOpaque(true);
		}
	}

	private void setWednesdayEvents(Events event, int index){

		int begI = event.Time.getTime()/30 - 12;
		int endI = event.Time.getEnd()/30 - 12;
		boolean setTextInLabel = true;

		for(int i = begI; i < endI; i++ ){
			if(setTextInLabel){
				wedEventLabels[i].setText(event.eventName);
				wedEventLabels[i].setVerticalTextPosition(JLabel.TOP);
				setTextInLabel = false;
			}
			wedEventLabels[i].setBackground(Color.decode(Constants.USER_COLOR[index]));
			wedEventLabels[i].setOpaque(true);
		}
	}

	private void setThursdayEvents(Events event, int index){

		int begI = event.Time.getTime()/30 - 12;
		int endI = event.Time.getEnd()/30 - 12;
		boolean setTextInLabel = true;

		for(int i = begI; i < endI; i++ ){
			if(setTextInLabel){
				thurEventLabels[i].setText(event.eventName);
				thurEventLabels[i].setVerticalTextPosition(JLabel.TOP);
				setTextInLabel = false;
			}
			thurEventLabels[i].setBackground(Color.decode(Constants.USER_COLOR[index]));
			thurEventLabels[i].setOpaque(true);
		}
	}

	private void setFridayEvents(Events event, int index){

		int begI = event.Time.getTime()/30 - 12;
		int endI = event.Time.getEnd()/30 - 12;
		boolean setTextInLabel = true;

		for(int i = begI; i < endI; i++ ){
			if(setTextInLabel){
				friEventLabels[i].setText(event.eventName);
				friEventLabels[i].setVerticalTextPosition(JLabel.TOP);
				setTextInLabel = false;
			}
			friEventLabels[i].setBackground(Color.decode(Constants.USER_COLOR[index]));
			friEventLabels[i].setOpaque(true);
		}
	}

	protected void clearSchedule(){

		for(int i = 0; i < 36; i++){
			monEventLabels[i].setBackground(Color.decode("#D6D9DF"));
			monEventLabels[i].setText("");
			tuesEventLabels[i].setBackground(Color.decode("#D6D9DF"));
			tuesEventLabels[i].setText("");
			wedEventLabels[i].setBackground(Color.decode("#D6D9DF"));
			wedEventLabels[i].setText("");
			thurEventLabels[i].setBackground(Color.decode("#D6D9DF"));
			thurEventLabels[i].setText("");
			friEventLabels[i].setBackground(Color.decode("#D6D9DF"));
			friEventLabels[i].setText("");

		}
	}
	
	public void addEvent(Events evt, int colorI){
        if(evt.getDays().contains("M")){
            this.setMondayEvents(evt,colorI);
        }
        if(evt.getDays().contains("TU")){
            this.setTuesdayEvents(evt,colorI);
        }
        if(evt.getDays().contains("W")){
            this.setWednesdayEvents(evt,colorI);
        }
        if(evt.getDays().contains("Th")){
            this.setThursdayEvents(evt,colorI);
        }
        if(evt.getDays().contains("F")){
            this.setFridayEvents(evt,colorI);
        }
	}
	
	public Schedule getScheduleFromFrame(){
		return mySchedule;
	}
}
