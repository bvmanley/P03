//**************************************************************************************************
// CLASS: Student
//
// AUTHOR
// Kevin R. Burger (burgerk@asu.edu)
// Computer Science & Engineering Program
// Fulton Schools of Engineering
// Arizona State University, Tempe, AZ 85287-8809
// (c) Kevin R. Burger 2014-2019
//**************************************************************************************************
package proj3;

import java.util.ArrayList;

/**
 * The Student class stores the gradebook information for one Student.
 *
 * Note that Student implements the java.lang.Comparable<Student> interface
 * because we are going to be sorting the roster of students by last name so we
 * need to be able to compare the last names of two students A and B to
 * determine if A < B, or if A = B, or if A > B. See the compareTo() method.
 */
public class Student implements Comparable<Student> {

    /**
     * mCurrStudent is a reference to the Student object which is currently
     * being displayed and edited in the View. It should only be accessed via
     * accessor/mutator methods.
     */
    private static Student mCurrStudent;
    /**
     * mExamList is an ArrayList of Integers storing the student's exam scores.
     */
    private ArrayList<Integer> mExamList;
    /**
     * The student's first name.
     */
    private String mFirstName;
    /**
     * mHomework List is an ArrayList of Integers storing the student's homework
     * scores.
     */
    private ArrayList<Integer> mHomeworkList;
    /**
     * The student's lst name.
     */
    private String mLastName;

    public Student(String pFirstName, String pLastName) {
        setFirstName(pFirstName);                  //save parameters to instance variables by calling mutatios
        setLastName(pLastName);
//need to check if these set up the Examlist and HomeworkList without error
        setExamList(new ArrayList<Integer>());     //create an ArrayList<Integer> and pass it off to setExamList()
        setHomeworkList(new ArrayList<Integer>()); //create an ArrayList<Integer> and pass it off to setHomeworkList()

    }

    public void addExam(int pScore) { //Adds an exam score pScore to the exam list
        getExamList().add(pScore);        //call add(pScore) on getExamList() to add a new exam score to the list of exam scores.
    }

    public void addHomework(int pScore) { //Adds a homework score pScore to the homework list
        getHomeworkList().add(pScore);  //call add(pScore) on getHomeworkList()
    }

    /**
     * compareTo()
     *
     * @param pStudent is a Student
     *
     * This method compares the last name of 'this' Student to the last name of
     * pStudent to determine if the last name of 'this' Student is <, =, or >
     * the last name of pStudent. It is called during the quick sort routine in
     * Sorter.partition().
     *
     * PSEUDOCODE: method compareTo(pStudent : Student) : int return: negative
     * int if the last name of this Student is < the last name of pStudent
     *     return: zero if the last name of this Student is = the last name of pStudent
     *     return: positive int if the last name of this Student is > the last name
     * of pStudent hint: the last names are Strings and String already
     * implements compareTo(). end compareTo
     */
    @Override
    public int compareTo(Student pStudent) {
        return this.mLastName.compareTo(pStudent.getLastName());
    }

    public static Student getCurrStudent() { //Accessor method for mCurrStudent.
        return mCurrStudent;
    }

    /**
     * getExam()
     *
     * Accessor method to retrieve an exam score from the list of exams.
     *
     * @param pNum The exam number for which we wish to retrieve the score.
     *
     * @return The exam score.
     *
     * Hint: Call getExamList() to get the ArrayList<Integer> object storing the
     * exam scores. Since that object is an ArrayList<Integer>, we next call the
     * get(index) method to retrieve the correct exam score.
     */
    public int getExam(int pNum) {
        return getExamList().get(pNum);
    }

    /**
     * Accessor method for mExamList.
     */
    private ArrayList<Integer> getExamList() {
        return mExamList;
    }

    /**
     * Accessor method for mFirstName.
     */
    public String getFirstName() {
        return mFirstName;
    }

    /**
     * Returns the student's full name in the format: "lastname, firstname".
     */
    public String getFullName() {
        return getLastName() + ", " + getFirstName();
    }

    /**
     * Accessor method to retrieve a homework score from the list of homeworks.
     *
     * @return The homework score. Call getHomeworkList() to get the
     * ArrayList<Integer> object storing the hw scores. Since that object is an
     * ArrayList<Integer>, we next call the get(index) method to retrieve the
     * correct hw score.
     */
    public int getHomework(int pNum) {
        return getHomeworkList().get(pNum);
    }

    /**
     * getHomeworkList()
     *
     * Accessor method for mHomeworkList.
     */
    private ArrayList<Integer> getHomeworkList() {
        return mHomeworkList;
    }

    /**
     * getLastname()
     *
     * Accessor method for mLastName.
     */
    public String getLastName() {
        return mLastName;
    }

    /**
     * Mutator method for mCurrStudent.
     */
    public static void setCurrStudent(Student pCurrStudent) {
        mCurrStudent = pCurrStudent;
    }

    /**
     * setExam()
     *
     * Mutator method to store an exam score into the list of exam scores.
     *
     * @pNum is the index into the list of exams, where 0 is the index of the
     * first exam score.
     *
     * See the hint for getExam(). This method will be similar, but rather than
     * calling get() on the ArrayList<Integer> object to get a score, we need to
     * call set(index, value) method to set the value in the ArrayList<Integer>
     * at index 'index' to 'value'.
     */
    public void setExam(int pNum, int pScore) {
        getExamList().set(pNum, pScore);
    }

    /**
     * setExamList()
     *
     * Mutator method for mExamList.
     */
    private void setExamList(ArrayList<Integer> pExamList) {
        mExamList = pExamList;
    }

    /**
     * setFirstName()
     *
     * Mutator method for mFirstName.
     */
    public void setFirstName(String pFirstName) {
        mFirstName = pFirstName;
    }

    /**
     * setHomework()
     *
     * Mutator method to store a homework score into the list of homework
     * scores.
     *
     * @pNum is the index into the list of homeworks, where 0 is the index of
     * the first hw score.
     *
     * See the hint for getHomework(). This method will be similar, but rather
     * than calling get() on the ArrayList<Integer> object to get a score, we
     * need to call set(index, value) method to set the value in the
     * ArrayList<Integer> at index 'index' to 'value'.
     */
    public void setHomework(int pNum, int pScore) {
        getHomeworkList().set(pNum, pScore);
    }

    /**
     * setHomeworkList()
     *
     * Mutator method for mHomeworkList.
     */
    private void setHomeworkList(ArrayList<Integer> pHomeworkList) {
        mHomeworkList = pHomeworkList;
    }

    /**
     * setLastname()
     *
     * Mutator method for mLastName.
     */
    public void setLastName(String pLastName) {
        mLastName = pLastName;
    }

    /**
     * toString()
     *
     * Returns a String representation of this Student. The format of the
     * returned string shall be such that the Student information can be printed
     * to the output file in this format:
     *
     * lastname firstname exam1 exam2 exam2 hw1 hw2 hw3 hw4 hw5
     *
     * where the fields are separated by spaces, except there is not space
     * following hw5.
     *
     * Hint: The String class has a method named trim() that removes leading and
     * trailing white- space from a string.
     *
     * Hint: use enhanced for loops
     */
    @Override
    public String toString() {
        String result = getLastName() + " " + getFirstName() + " ";
        for (Integer exam : getExamList()) {
            result += exam + " ";
        }
        for (Integer hw : getHomeworkList()) {
            result += hw + " ";
        }
        return result.trim();
    }
}
