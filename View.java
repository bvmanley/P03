//**************************************************************************************************
// CLASS: View
//
// AUTHOR
// Kevin R. Burger (burgerk@asu.edu)
// Computer Science & Engineering Program
// Fulton Schools of Engineering
// Arizona State University, Tempe, AZ 85287-8809
// (c) Kevin R. Burger 2014-2019
//**************************************************************************************************
package proj3;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * The View class implements the GUI. It is a subclass of JFrame and implements
 * the ActionListener interface so that we can respond to user-initiated GUI
 * events.
 */
public class View extends JFrame implements ActionListener {

    public static final int FRAME_WIDTH = 525; // Width of the View frame.
    public static final int FRAME_HEIGHT = 225; // Height of the View frame.

    /**
     * When the View() ctor is called from Main.run() to create the View, run()
     * passes a reference to the Main object as the argument to View(). We save
     * that reference into mMain and then later we can use mMain to communicate
     * with the Main class.
     *
     * mMain is made accessible within this class via accessor/mutator methods
     * getMain() and setMain(). It shall not be directly accessed.
     */

    /*
     * Declare GUI related instance variables for the buttons and text fields.
     */
    private Main mMain;
    private JButton mClearButton;
    private JTextField[] mExamText;
    private JButton mExitButton;
    private JTextField[] mHomeworkText;
    private JButton mSaveButton;
    private JButton mSearchButton;
    private JTextField mStudentName;

    /**
     * View()
     *
     * The View constructor creates the GUI interface and makes the frame
     * visible at the end.
     *
     * @param pMain is an instance of the Main class. This links the View to the
     * Main class so they may communicate with each other.
     */
    public View(Main pMain) {
        setMain(pMain);                                // Save a reference to the Main object pMain into instance var mMain by calling setMain().
        JPanel panelSearch = new JPanel();             // Create a JPanel named panelSearch which uses the FlowLayout
        panelSearch.add(new JLabel("Student Name: ")); // Add a JLabel "Student Name: " to panelSearch
        mStudentName = new JTextField(25);             // Create mStudentName and make the field 25 cols wide
        panelSearch.add(mStudentName);                 // Add mStudentName to the panel
        mSearchButton = new JButton("Search");         // Create mSearchButton with the label "Search"
        //Make this View the action listner for the button ??
        mSearchButton.addActionListener(this);
        panelSearch.add(mSearchButton);                 // Add the button to the panel

        JPanel panelHomework = new JPanel();           // Create a JPanel named panelHomework which uses the FlowLayout
        panelHomework.add(new JLabel("Homework: "));   // Add a JLabel "Homework: " to the panel
        mHomeworkText = new JTextField[Main.getNumHomeworks()]; // Create mHomeworkText which is an array of JTextFields, one for each homework assignment
        for (int i = 0; i < Main.getNumHomeworks(); i++) { // For i = 0 to the number of homework assignments
            mHomeworkText[i] = new JTextField(5);      //Create a textfield mHomeworkText[i] displaying 5 cols
            panelHomework.add(mHomeworkText[i]);       //Add mHomeworkText[i] to the panel
        }

        JPanel panelExam = new JPanel();               // Create the exam panel which contains the "Exam: " label and the two exam text fields.
        panelExam.add(new JLabel("Exam: "));       // and the two exam text fields?? The pseudocode is very similar to the code abve
        mExamText = new JTextField[Main.getNumExams()];
        for (int i = 0; i < Main.getNumExams(); i++) { // For i = 0 to the number of homework assignments
            mExamText[i] = new JTextField(5);          //Create a textfield mHomeworkText[i] displaying 5 cols
            panelExam.add(mExamText[i]);              //Add mHomeworkText[i] to the panel
        }
        JPanel panelButtons = new JPanel();            // Create a JPanel named panelButtons using FlowLayout
        mClearButton = new JButton("Clear");                  // Create the Clear button mClearButton labeled "Clear"
        mClearButton.addActionListener(this); //not sure if correct
        panelButtons.add(mClearButton);                // Add the  Clear button to the panel
        mSaveButton = new JButton("Save");
        mSaveButton.addActionListener(this);  //same thing but for Save, not sure if correct
        panelButtons.add(mSaveButton);
        mExitButton = new JButton("Exit");
        mExitButton.addActionListener(this);  //same thing but for Exit, not sure if correct
        panelButtons.add(mExitButton);
        JPanel panelMain = new JPanel();               // Create a JPanel named panelMain using a vertical BoxLayout
        panelMain.setLayout(new BoxLayout(panelMain, BoxLayout.Y_AXIS));
        panelMain.add(panelSearch);                    // Add panelSearch to panelMain.
        panelMain.add(panelHomework);                  // Add panelHomework to panelMain
        panelMain.add(panelExam);                      // Add panelExam to panelMain
        panelMain.add(panelButtons);                   // Add panelButtons to panelMain
        setTitle("Gred :: Gradebook Editor");          // Set the title of the View to whatever you want by calling setTitle()
        setSize(FRAME_WIDTH, FRAME_HEIGHT);            // Set the size of the View to FRAME_WIDTH x FRAME_HEIGHT
        setResizable(false);                           // Make the View non-resizable
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE); // Set the default close operation
        add(panelMain);                                // Add panelMain to the View.
        pack();                                        // Calling the pack() method encase its run on a Mac(Apple)
        setVisible(true);                              // Now display the View by calling setVisible().
    }

    @Override
    public void actionPerformed(ActionEvent pEvent) {       // Called when one of the JButtons is clicked. Detects which button was clicked and handles it.
        if (pEvent.getSource() == mSearchButton) {          // If the source of the event was the Search button
            clearNumbers();                                 // Clear the numbers in the homework and exam fields
            String lastName = mStudentName.getText();       // lastName = the text from the mStudentName text field
            if ("".equals(lastName)) {                      // If lastName is the empty string
                messageBox("Please enter the student's last name.");// Then:Call messageBox() to display "Please enter the student's last name."
            } else {
                // Main contains a method named search() which given the last name of a student will search the Roster for the student.
                // search() either returns the Student object if found, or if there is no student with that last name in the Roster,
                // then search() returns null.
                Student.setCurrStudent(getMain().search(lastName)); // Call getMain().search(lastName) and pass the return value to Student.setCurrStudent()
                if (Student.getCurrStudent() == null) { // if the curr student object saved in the Student class is null
                    messageBox("Student not found. Try again.");    // Call messageBox() to display "Student not found. Try again."
                } else {
                    displayStudent(Student.getCurrStudent());       //Retrieve the curr student from the Student class and pass it to displayStudent()
                }
            }
        } else if (pEvent.getSource() == mSaveButton) {         // if the source of the event was the Save button
            if (Student.getCurrStudent() != null) {             // if Student.getCurrStudent() is not null
                saveStudent(Student.getCurrStudent());          // Call saveStudent(Student.getCurrStudent())
            }
        } else if (pEvent.getSource() == mClearButton) {        // if the source of the event was the Clear button
            clear();                                            //call clear
        } else if (pEvent.getSource() == mExitButton) {         // if the source of the event was the Exit button
            if (Student.getCurrStudent() != null) {             // If Student.getCurrStudent() is not null
                saveStudent(Student.getCurrStudent());          // Call saveStudent(Student.getCurrStudent())
             getMain().exit();                                  //Call getMain().exit() to terminate the application
            }
        }
    }

    /**
     * clear()
     *
     * Called when the Clear button is clicked. Clears all of the text fields by
     * setting the contents of each to the empty string.
     *
     * After clear() returns, no student information is being edited or
     * displayed and mStudent has been set to null.
     *
     */
    private void clear() {
        mStudentName.setText("");//Set the mStudentName text field to ""
        clearNumbers();          //clearNumbers() Set the current Student object in the Student class to null
    }

    /**
     * clearNumbers()
     *
     * Clears the homework and exam fields.
     */
    private void clearNumbers() {
        for (int i = 0; i < Main.getNumHomeworks(); i++) {
            mHomeworkText[i].setText("");
        }
        for (int i = 0; i < Main.getNumExams(); i++) {
            mExamText[i].setText("");
        }
    }

    /**
     * Displays the homework and exam scores for a student in the mHomeworkText
     * and mExamText text fields.
     *
     * @param pStudent is the Student who's scores we are going to use to
     * populate the text fields.
     */
    private void displayStudent(Student pStudent) {
        for (int i = 0; i < Main.getNumHomeworks() - 1; i++) {
            int hw = pStudent.getHomework(i);
            String hwstr = Integer.toString(hw); //convert hw to a String (Hint: Integer.toString());
            mHomeworkText[i].setText(hwstr);
        }
        for (int i = 0; i < Main.getNumExams() - 1; i++) { //loop to place the student's exam scores into the text fields
            int exam = pStudent.getExam(i);
            String examstr = Integer.toString(exam);
            mExamText[i].setText(examstr);
        }
    }

    /**
     * Accessor method for mMain.
     */
    private Main getMain() {
        return mMain;
    }

    /**
     * messageBox()
     *
     * Displays a message box containing some text. Note: read the Java 8 API
     * page for JOptionPane to see what the constructor arguments are to
     * showMessageDialog(). You want to pass the appropriate "thing" for the
     * first argument so your message dialog window will be centered in the
     * middle of the View frame. If your View frame is centered in the middle of
     * your screen then you did not pass the right "thing".
     *
     * PSEUDOCODE: method messageBox(pMessage : String) : void Call
     * JOptionPane.showMessageDialog() to display pMessage. end messageBox
     */
    public void messageBox(String pMessage) {
        JOptionPane.showMessageDialog(this, pMessage, "Message", JOptionPane.PLAIN_MESSAGE);
    }

    /**
     * saveStudent()
     *
     * Retrieves the homework and exam scores for pStudent from the text fields
     * and writes the results to the Student record in the Roster.
     */
    private void saveStudent(Student pStudent) {
        for (int i = 0; i < Main.getNumHomeworks(); i++) {
            String hwstr = mHomeworkText[i].getText();
            int hw = Integer.parseInt(hwstr);
            pStudent.setHomework(i, hw);
        }
        for (int i = 0; i < Main.getNumExams(); i++) {
            String examstr = mExamText[i].getText();
            int exam = Integer.parseInt(examstr);
            pStudent.setExam(i, exam);
        }
    }

    /**
     * Mutator method for mMain.
     */
    private void setMain(Main pMain) {
        mMain = pMain;
    }
}
