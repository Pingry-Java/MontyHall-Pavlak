/**
* Monty Hall Class Problem
* @author Mitchell Pavlak
* @author Orndorff AP Comp Sci Class
**/

//model the doors as ints
import java.util.Scanner;



public class MontyHall 
{

public static Scanner keys = new Scanner(System.in);


	public static void main(String[] args) 
	{
	int numOfDoors = 3; 
	//my version should still work even if this is changed as long as numOfDoors >2
	int carDoor = (int) ((Math.random() * numOfDoors) + 1); 
	//Random door between one and three
	int userDoor = getUserDoor(numOfDoors); //gets the door the user is picking
	int doorToReveal = revealDoor(userDoor, carDoor, numOfDoors);
	System.out.println("There is a goat behind door number: " + doorToReveal);
    //Ask whether you want to swap
    boolean swap = getUserSwap();
    if (swap == true) 
    {
    	System.out.println("Which door would you like to switch to: ");
    	int doorToSwapWith = getDoorSwitch(numOfDoors,userDoor,doorToReveal);
    	userDoor = doorToSwapWith;
    } 
    boolean prize = checkWin(userDoor, carDoor);
    winScreen(prize,userDoor);
	}
	/**
	* Method asks the user whether they want to swap their door or not 
	* @return boolean that says whether the user would like to switch or not
	**/
	public static boolean getUserSwap() {
	System.out.println("Do you want to swap \'yes\' or \'no\'?");
	String answer = keys.nextLine();
	if (answer.equals("yes") || answer.equals("Yes") || answer.equals("YES")) {
	return true;
	} else 
	return false;
	}
	/**
	* Method gets the door the user would like to switch (uses getUserDoor, but handles errors)
	* @param numOfDoors the number of doors the program is using
	* @param userDoor the door the user picked (can't switch to the same door)
	* @param doorToReveal the door that was already revealed as a goat door
	**/
	public static int getDoorSwitch(int numOfDoors,int userDoor,int doorToReveal) 
	{
		int newDoor = getUserDoor(numOfDoors);
		while ((newDoor == userDoor)||(newDoor == doorToReveal))
		{
			System.out.println("Oops, looks like there was an error. Please enter a valid door.");
			System.out.println("Doors " +userDoor + " and " + doorToReveal +" are invalid.");
			newDoor = getUserDoor(numOfDoors);
		}
		return newDoor;
	
	}
	
	
	/**
	*This method is used to get the choice of the user regarding door, and checks to make
	*sure it is a door.
	* @param numOfDoors takes in how many doors there should be
	* @return the door choice of the user
	**/
	public static int getUserDoor(int numOfDoors) 
	{
		System.out.println("Please enter a door from 1-" + numOfDoors + " (i.e. \'1\')" );
		int userInput = keys.nextInt();
		keys.nextLine();
		while ((userInput > numOfDoors) || (userInput < 1)) {
			userInput = getUserDoor(numOfDoors);
		}
		return userInput;
	}
	
	/**
	* This method calculates an acceptable door to return to the user.
	* @param invalidDoor1 A door that the host cannot open
	* @param invalidDoor2 Another door that the host cannot open (may be the same as invalidDoor1)
	* @param numOfDoors the number of doors the program is using (so it can use more doors)
	* @return The number of a door containing a goat. 
	**/
	public static int revealDoor(int invalidDoor1, int invalidDoor2, int numOfDoors) 
	{
		int validDoor = (int) ((Math.random() * numOfDoors) + 1.0); //making it as random
		// as possible
		while ((validDoor == invalidDoor1) || (validDoor == invalidDoor2))
		{
			validDoor = (int) ((Math.random() * numOfDoors) + 1.0);
			// making it random 
		}
		return validDoor;
		// I should never reach this line it is just to make the compiler feel better
		// return -1; I'm getting an error saying unreachable statement so I will assume
		// that for the way done above the compiler does not have a program
	}
	/**
	* Quick method to check win
	* @param playerDoor the player's door as of the win checking
	* @param carDoor the door the car is behind
	* @return boolean did the player win the car
	**/
	public static boolean checkWin(int playerDoor,int carDoor)	
	{
	boolean prize = false;
	if (playerDoor == carDoor)
		prize = true; 
		
	return prize;
	}
	/**
	* Displays the winscreen to the player to show what they won 
	* @param prize boolean that is true if the player won the car
	*
	**/
	public static void winScreen(boolean prize, int userDoor)
	{
		System.out.println("Now, for the moment we've all been waiting for... Finding out what is behind door number "+userDoor+"...");
		waitWorkAround();
		System.out.println("DRUM ROLL PLEASE!");
		waitWorkAround();
		System.out.println("YOU ARE NOW");
		waitWorkAround();
		System.out.println("THE PROUD OWNER OF A NEW");
		waitWorkAround();
		System.out.println("2016");
		waitWorkAround();
		System.out.println("Insured");
		waitWorkAround();
		if (prize == true) 
		{
			System.out.println("CAAAARRRRRRRRR!!!!!!!!");
		} else
		System.out.println("GOOOOOOOAAAAAAAAATTTTTTTTTTT!!! (Insured against disease)");		
		}
	public static void waitWorkAround()
	{
	double count = 0;
	while (count <= 1000000000.0) {
	count = count + 1;
	}
	
	}
	
}