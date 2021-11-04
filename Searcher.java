package proj3;

import java.util.ArrayList;

public class Searcher {

    //implement binary search algorithm: iterative (loop) or recursive
    //searches the roster for a student with the specified last name
    //the roster is sorted into ascending order by last name
    //the method returns the index of the student in the list or -1 if the student is not found
    public static int search(ArrayList<Student> pList, String pKey) {
        int low = 0;
        int high = pList.size() - 1;
        while (low <= high) {
            int middle = (low + high) / 2;
            if (pKey.equals(pList.get(middle).getLastName())) { //found pkey
                return middle;
            } else if (pKey.compareTo(pList.get(middle).getLastName()) < 1) {
                high = middle - 1;
            } else {
                low = middle + 1;
            }
        }
        return -1;  //not found
    }

}
