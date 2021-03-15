package RescueAnimals.src;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Scanner;

@SuppressWarnings("unused")
public class Driver {
    private static ArrayList<Dog> dogList = new ArrayList<Dog>();
    private static ArrayList<Monkey> monkeyList = new ArrayList<Monkey>();
    private static ArrayList<String> monkeySpecies = new ArrayList<String>();
    // Instance variables (if needed)
    Object listDogs = new Object();

    public static void main(String[] args) {

        initializeDogList();
        initializeMonkeyList();
        initializeMonkeySpecies();

        // Add a loop that displays the menu, accepts the users input
        // and takes the appropriate action.
	// For the project submission you must also include input validation
        // and appropriate feedback to the user.
        // Hint: create a Scanner and pass it to the necessary
        // methods 
	// Hint: Menu options 4, 5, and 6 should all connect to the printAnimals() method.
        Scanner scnr = new Scanner(System.in);
        displayMenu();
        
        String userIn = scnr.nextLine();
        

        while (!userIn.equalsIgnoreCase("Q")) {
        	
        	if (userIn.equals("1")) {
        		intakeNewDog(scnr);
        		userIn = scnr.nextLine();
        	}
        	
        	if (userIn.equals("2")) {
        		intakeNewMonkey(scnr);
        		userIn = scnr.nextLine();
        	}
        	
        	if (userIn.equals("3")) {
        		reserveAnimal(scnr);
        		userIn = scnr.nextLine();
        	}
        	
        	if (userIn.equals("4")) {
        		printAnimals("dog");
        		userIn = scnr.nextLine();
        	}
        	
        	if (userIn.equals("5")) {
        		printAnimals("monkey");
        		userIn = scnr.nextLine();
        	}
        	
        	if (userIn.equals("6")) {
        		printAnimals("available");
        		userIn = scnr.nextLine();
        	}
        	

        	
        	else {
        		System.out.println("Invalid input");
        		displayMenu();
        		userIn = scnr.nextLine();
        	}
        }
        
        
        if (userIn.equalsIgnoreCase("q")) {
        	System.out.println("Exiting program");
        	scnr.close();
        	System.exit(0);
        }
    }

    // This method prints the menu options
    public static void displayMenu() {
        System.out.println("\n\n");
        System.out.println("\t\t\t\tRescue Animal System Menu");
        System.out.println("[1] Intake a new dog");
        System.out.println("[2] Intake a new monkey");
        System.out.println("[3] Reserve an animal");
        System.out.println("[4] Print a list of all dogs");
        System.out.println("[5] Print a list of all monkeys");
        System.out.println("[6] Print a list of all animals that are not reserved");
        System.out.println("[q] Quit application");
        System.out.println();
        System.out.println("Enter a menu selection\n");
    }
    


    // Adds dogs to a list for testing
    public static void initializeDogList() {
        Dog dog1 = new Dog("Spot", "German Shepherd", "male", "1", "25.6", "05-12-2019", "United States", "intake", false, "United States");
        Dog dog2 = new Dog("Rex", "Great Dane", "male", "3", "35.2", "02-03-2020", "United States", "Phase I", false, "United States");
        Dog dog3 = new Dog("Bella", "Chihuahua", "female", "4", "25.6", "12-12-2019", "Canada", "in service", true, "Canada");

        dogList.add(dog1);
        dogList.add(dog2);
        dogList.add(dog3);
    }


    // Adds monkeys to a list for testing
    //Optional for testing
    public static void initializeMonkeyList() {
    	Monkey monkey1 = new Monkey("Billy", "male", "1", "25.6", "05-12-2019", "United States", "intake", false, "United States", "2", "3", "6", "Capuchin");
    	
    	monkeyList.add(monkey1);
    }
    
    // Adding a new list for available species for monkey
    public static void initializeMonkeySpecies() {
    	String species1 = new String("capuchin");
    	String species2 = new String("guenon");
    	String species3 = new String("macaque");
    	String species4 = new String("marmoset");
    	String species5 = new String("squirrel monkey");
    	String species6 = new String("tamarin");
    	
    	monkeySpecies.add(species1);
    	monkeySpecies.add(species2);
    	monkeySpecies.add(species3);
    	monkeySpecies.add(species4);
    	monkeySpecies.add(species5);
    	monkeySpecies.add(species6);
    }


    // Complete the intakeNewDog method
    // The input validation to check that the dog is not already in the list
    // is done for you
    public static void intakeNewDog(Scanner scanner) {
        System.out.println("What is the dog's name?");
        String name = scanner.nextLine();
        for(Dog dog: dogList) {
            if(dog.getName().equalsIgnoreCase(name)) {
                System.out.println("\n\nThis dog is already in our system\n\n");
                return; //returns to menu
            }
            else {
            	try {
	            	dog.setName(name);
	            	System.out.println("What is the dog's breed?");
	            	dog.setBreed(scanner.nextLine());
	            	
	            	System.out.println("What is the dog's gender?");
	            	dog.setGender(scanner.nextLine());
	            	
	            	System.out.println("What is the dog's age?");
	            	dog.setAge(scanner.nextLine());
	            	
	            	System.out.println("What is the dog's weight");
	            	dog.setWeight(scanner.nextLine());
	            	
	            	System.out.println("When was the dog aquisitioned?");
	            	dog.setAcquisitionDate(scanner.nextLine());
	            	
	            	System.out.println("Where was the dog aquisitioned?");
	            	dog.setAcquisitionLocation(scanner.nextLine());
	            	
	            	System.out.println("What is the dog's training status?");
	            	dog.setTrainingStatus(scanner.nextLine());
	            	
	            	System.out.println("Is the dog reserved?");
	            	dog.setReserved(scanner.nextBoolean());
	            	
	            	if (dog.getReserved() == true) {
	            		System.out.println("What country is the dog in service?");
	                	dog.setInServiceCountry(scanner.nextLine());
	            	}
	            	System.out.println("\n\nDog created\n\n");
	            	
	            	displayMenu();
	            	return;
            	}
            	
            	catch (Exception excpt) {
            		System.out.println(excpt.getMessage());
            		System.out.println("Please try again.");
            		displayMenu();
            		return;
            	}
            }
        }

        // Add the code to instantiate a new dog and add it to the appropriate list

    }


        // Complete intakeNewMonkey
	//Instantiate and add the new monkey to the appropriate list
        // For the project submission you must also  validate the input
	// to make sure the monkey doesn't already exist and the species type is allowed
        public static void intakeNewMonkey(Scanner scanner) {
            System.out.println("What is the monkey's name?");
            String name = scanner.nextLine();
            for(Monkey monkey: monkeyList) {
            	
            	
                if(monkey.getName().equalsIgnoreCase(name)) {
                    System.out.println("\n\nThis monkey is already in our system\n\n");
                    return; //returns to menu
                }
                
                else {
                	try {
	                	monkey.setName(name);
	                	System.out.println("What is the monkey's species?");
	                	String species = scanner.nextLine().toLowerCase();
	                	if (!monkeySpecies.contains(species)) {
	                		throw new Exception("Invalid species");
	                	}
	                	else {
	                		monkey.setSpecies(species);
	                	}
	                	
	                	System.out.println("What is the monkey's gender?");
	                	monkey.setGender(scanner.nextLine());
	                	
	                	System.out.println("What is the monkey's age?");
	                	monkey.setAge(scanner.nextLine());
	                	
	                	System.out.println("What is the monkey's weight?");
	                	monkey.setWeight(scanner.nextLine());
	                	
	                	System.out.println("What is the monkey's tail length?");
	                	monkey.setTailLength(scanner.nextLine());
	                	
	                	System.out.println("What is the monkey's height?");
	                	monkey.setHeight(scanner.nextLine());
	                	
	                	System.out.println("What is the monkey's body length?");
	                	monkey.setBodyLength(scanner.nextLine());
	                	
	                	System.out.println("When was the monkey aquisitioned?");
	                	monkey.setAcquisitionDate(scanner.nextLine());
	                	
	                	System.out.println("Where was the monkey aquisitioned?");
	                	monkey.setAcquisitionLocation(scanner.nextLine());
	                	
	                	System.out.println("What is the monkey's training status?");
	                	monkey.setTrainingStatus(scanner.nextLine());
	                	
	                	System.out.println("Is the monkey reserved?");
	                	monkey.setReserved(scanner.nextBoolean());
	                	
	                	if (monkey.getReserved() == true) {
	                		System.out.println("What country is the monkey in service?");
	                		monkey.setInServiceCountry(scanner.nextLine());
	                	}
	                	System.out.println("\n\nMonkey created\n\n");
	                	displayMenu();
	                	return;
                	}
                	catch (Exception excpt) {
                		System.out.println(excpt.getMessage());
                		System.out.println("Please try again.");
                		displayMenu();
                		return;
                	}
                }
            }
        }

        // Complete reserveAnimal
        // You will need to find the animal by animal type and in service country
        public static void reserveAnimal(Scanner scanner) {
            System.out.println("Select species.");
            String species = scanner.nextLine();
            
            if (species.equalsIgnoreCase("dog")) {
            	for (Dog dog: dogList) {
            		
            		System.out.println("Enter name of dog.");
                	String name = scanner.nextLine();

                	if(dog.getName().equalsIgnoreCase(name)) {
                		System.out.println("Set dog reserved true or false?");
                		dog.setReserved(scanner.nextBoolean());
                		return;
                	}
                	else {
                		System.out.println("Dog does not exist.");
                		return;
                	}
            	}
            }
            else if (species.equalsIgnoreCase("monkey")) {
            	for (Monkey monkey: monkeyList) {
            		
            		System.out.println("Enter name of monkey.");
            		String name = scanner.nextLine();
            		
            		if(monkey.getName().equalsIgnoreCase(name)) {
            			System.out.println("Set monkey reserved true or false?");
            			monkey.setReserved(scanner.nextBoolean());
            			return;
            		}
            		else {
                		System.out.println("Monkey does not exist.");
                		return;
            		}
            	}
            }

        }

        // Complete printAnimals

        // Include the animal name, status, acquisition country and if the animal is reserved.
	// Remember that this method connects to three different menu items.
        // The printAnimals() method has three different outputs
        // based on the listType parameter
        // dog - prints the list of dogs
        // monkey - prints the list of monkeys
        // available - prints a combined list of all animals that are
        // fully trained ("in service") but not reserved 
	// Remember that you only have to fully implement ONE of these lists. 
	// The other lists can have a print statement saying "This option needs to be implemented".
	// To score "exemplary" you must correctly implement the "available" list.
        
        
        public static void printAnimals(String choice) {
        	
        	if (choice.equalsIgnoreCase("dog")) {
        		for (Dog dog: dogList) {
        			System.out.println(dog.getName());
        		}
        	}
        	
        	if (choice.equalsIgnoreCase("monkey")) {
        		for (Monkey monkey: monkeyList) {
        			System.out.println(monkey.getName());
        		}
        	}
        	
        	// Gets each animal from its respective list, checks if they are reserved, and if false prints their name and species/breed.
        	if (choice.equalsIgnoreCase("available")) {
        		for (Dog dog: dogList){
        			if (dog.getReserved() == false) {
        				System.out.println(dog.getName() + ", " + dog.getBreed());
        			}
        		}
        		
        		for (Monkey monkey: monkeyList) {
        			if (monkey.getReserved() == false) {
        				System.out.println(monkey.getName() + ", " + monkey.getSpecies());
        			}
        		}
        		System.out.println("Press any key to continue.");
        	}
        	
        	
        }
        
        
        
}

