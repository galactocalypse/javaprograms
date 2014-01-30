import java.util.*;
public class JosephusTrial {

    public static void main(String[] args) {
        //Initiates the variables N and M for later use.
	int N = 0;
	int M = 0;

	//Initiates index variable to use in later "for" loop.
	int index = 0;

        //Inputs Scanner object.
        Scanner cmd = new Scanner(System.in);

        //Asks user for input regarding the number of knights.
	System.out.println("How many knights will be participating?");
        String people = cmd.nextLine();
        System.out.println("There will be " + people + " knights.");

        //Asks user for input regarding the number of knights
        //that must touch the potato before elimination.
        System.out.println("Who will be the last person to touch the ball?");
        String touch = cmd.nextLine();

        System.out.println("Every " + touch + "nd " +
                "person to touch the ball " + "will die.");

	//Converts String inputs to integers.
	N = Integer.parseInt(people);
        M = Integer.parseInt(touch);

	//Initiates Array to store the values of each killed knight.
	int[] deleted = new int[N-1];
        
	//Creates a new StringBuffer for the program.
	//Since program must work for values 1 to 63,536, I added and set String
        //Buffer capacity equal to total characters of all the numbers: 316,574.
        int buffersize = 316574;
        StringBuffer josephus = new StringBuffer(buffersize);
        //int testbuffersize = josephus.capacity();
        //System.out.println(testbuffersize);

        //Creates each knight from N as a separate value.
	for(int i = 0; i < N; i++) {
		josephus.append((char)(i + 1));
		}
        //Starts loops that solves Josephus problem.
        for(int i = 0; i < N-1; i++) {
            if((index + M) > josephus.length()) {
                index = (index + M) % (N);
                //Calls the value of the killed knight from StringBuffer, stores
                //it into Array, and then removes it from StringBuffer
                deleted[i] = (int)josephus.charAt(index);
                josephus.delete(index, (index+1));

        } else{
               index = (index + M);
               deleted[i] = (int)josephus.charAt(index);
               josephus.delete(index, (index+1));
            }
        }
        System.out.println("Therefore, Knight No. " + " is the lone survivor.");
    }
}