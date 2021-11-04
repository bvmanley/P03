//**************************************************************************************************
// CLASS: Roster
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
 * The Roster class encapsulates an ArrayList<Student> object named mStudentList
 * which stores the information for each student that was read from
 * "gradebook.dat" when the app started.
 */
public class Roster {

    /**
     * Declare mStudentList as ArrayList<Student>
     */
    private ArrayList<Student> mStudentList;

    /**
     * PSEUDOCODE: method Roster() -- Note that mStudentList was already
     * declared so we do not need to declare it here. -- What we need to do here
     * is create the ArrayList<Student> object that mStudentList -- will refer
     * to. create an ArrayList<Student> object and then pass that object as the
     * argument to setStudentList() to make mStudentList refer to the ArrayList
     */
    public Roster() {

        mStudentList = new ArrayList<>();
        setStudentList(new ArrayList<Student>()); //needs work
    }

    /**
     * Adds pstudent to the ArrayList
     */
    public void addStudent(Student pStudent) {
        mStudentList.add(pStudent);
    }

    /**
     * Searches mStudentList for a Student with pLastName. PSEUDOCODE: method
     * getStudent(pLastName : String) : Student -- Get the index of the student
     * in the student list index = call Searcher.search(getStudentList(),
     * pLastName) -- If index is -1 then no student with that last name could be
     * found so we return -- null. Otherwise, we get the Student from the
     * student list at the index and return -- the Student. if index == -1 then
     * return null else return the Student object in getStudentList() at index
     * 'index' end getStudent
     */
    public Student getStudent(String pLastName) {
        int index = Searcher.search(getStudentList(), pLastName); //index = call Searcher.search(getStudentList(), pLastName)
        if (index == -1) {          //if index == -1 then return null
            return null;
        } else {
            return mStudentList.get(index);    //else return the Student object in getStudentList() at index 'index'
        }
    }

    /**
     * Accessor method for mStudentList.
     */
    public ArrayList<Student> getStudentList() {
        return mStudentList;
    }

    /**
     * Mutator method for mStudentList.
     */
    private void setStudentList(ArrayList<Student> pStudentList) {
        mStudentList = pStudentList;
    }

    /**
     * sortRoster() Called to sort the roster by last name.
     *
     * PSEUDOCODE: method sortRoster() -- Note that all of the methods in Sorter
     * are class methods, so we call the sort() -- method on the class Sorter.
     * call Sorter.sort() passing the list of students returned from
     * getStudentList() end sortRoster
     */
    public void sortRoster() {
        Sorter.sort(getStudentList());
    }

    /**
     * Returns a String representation of this Roster. toString() methods are
     * very handy for debugging because given access to a Roster object, say
     * named roster, then you can print the entire roster in one statement:
     * System.out.println(roster);
     */
    @Override
    public String toString() {
        String result = "";
        for (Student student : getStudentList()) {
            result += student + "\n";
        }
        return result;
    }
}
