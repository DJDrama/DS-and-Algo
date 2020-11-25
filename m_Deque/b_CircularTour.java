import java.util.ArrayDeque;
import java.util.Deque;

public class CircularTour {

    // Consider an arrangement where n petrol pumps are arranged in a circular manner.
    // We need to find the first petrol pump from where we can visit all petrol pumps
    // and come back to the petrol pump without ever going out of the petrol.
    // pet[] = {4, 8, 7, 4} --> dist[] = {6, 5, 3, 5} : 2
    // {8, 9, 4} --> {5, 10, 12} : -1
    // {4, 8} --> {5, 6} : 2
    int firstPetrolPump(int[] petrol, int[] dist) {
        int start = 0;
        int currPet = 0;
        int prevPet = 0;
        for (int i = 0; i < petrol.length; i++) {
            currPet += (petrol[i] - dist[i]);
            if (currPet < 0) {
                start = i + 1;
                prevPet += currPet;
                currPet = 0;
            }
        }
        return currPet + prevPet >= 0 ? start + 1 : -1;
    }
}

class Main {
    public static void main(String[] args) {
        CircularTour c = new CircularTour();
        int[] pet = {4, 8, 7, 4};
        int[] dist = {6, 5, 3, 5};
        // start=0, currPet=0, prevPet=0
        // i=0
        // currPet = 4 - 6 = -2
        // if() --> start=1, prevPet=-2, currPet=0
        // i=1
        // currPet = -2 + (8-5) = 1
        // i=2
        // currPet = 1 + (7-3) = 5
        // i=3
        // currPet = 5 + (4-5) = 4
        // END LOOP
        // currPet=4, prevPet=-2 --> currPet+prevPet = 2 >=0 --> start+1 = 2(return 2)
        System.out.println(c.firstPetrolPump(pet, dist)); //2
    }
}
