import java.util.Random;

public class SortingHat{

	private static String[] HOUSE_NAMES = {"Gryffindor", "Hufflepuff", "Slytherin", "Ravenclaw"};
	private static final int GRYF_POS = 0;
	private static final int HUF_POS = 1;
	private static final int SLYT_POS = 2;
	private static final int RAVE_POS = 3;

	private static final String STUDENTS[][] = {

            {"Ilario Vasco Palaia",HOUSE_NAMES[SLYT_POS]},
            {"Elvis La fata", HOUSE_NAMES[RAVE_POS]},
            {"Regina Ghering",HOUSE_NAMES[HUF_POS]},
            {"Luca Formica",HOUSE_NAMES[SLYT_POS]},
            {"Davide Mazzitelli",HOUSE_NAMES[RAVE_POS]},
            {"Piero Scarcina",HOUSE_NAMES[GRYF_POS]},
            {"Vittorio Aquila",HOUSE_NAMES[RAVE_POS]},
            {"Emanuele Giustiniani","HOUSE_NAMES[SLYT_POS]"},
            {"Gaspare Maione",HOUSE_NAMES[GRYF_POS]},
            {"Camilla Marchioro",HOUSE_NAMES[GRYF_POS]},
            {"Eugenio Manganelli",HOUSE_NAMES[HUF_POS]},
            {"Edoardo Bognanni",HOUSE_NAMES[RAVE_POS]},
            {"Lorenzo Coretti",HOUSE_NAMES[HUF_POS]},
            {"Sabrina Salerno", HOUSE_NAMES[HUF_POS]},
            {"Marcello Coppolino", HOUSE_NAMES[SLYT_POS]},
            {"Stefano Pio Lorato", HOUSE_NAMES[GRYF_POS]},
            {"Nicolo Casertano", HOUSE_NAMES[GRYF_POS]},
            {"Alessio Basili",HOUSE_NAMES[RAVE_POS]}
        };
	
	

	private static final int HOUSE_SIZE = (int) Math.ceil((STUDENTS.length+4)/4);
	private static final String[][] HOUSES = new String[4][HOUSE_SIZE];
	private static final int[] COUNTERS = new int[4]; //Conta quanti studenti occupano ogni casa
	
	private static final Random DICE = new Random();

	public static void main(String[] args){
	
		randomize();
//		for(String[] s : STUDENTS){
//			System.out.println(Arrays.toString(s));
//		}
	
		for(int i = 0; i < (STUDENTS.length+4)/4*4; i++	){
			int luck = DICE.nextInt(4);
			String studentName = STUDENTS[i][0];
			String favouriteHouse = STUDENTS[i][1];
			boolean housHasSpace = hasRoom(favouriteHouse, false);
			if(luck == 0 && houseHasSpace){
				assignStudentToHouse(studentName, favouriteHouse);
				System.out.println(studentName + "..." + favouriteHouse + " come da sua preferenza.");
			}
		}	

	}

	public static void randomize(){
		for(int i = 0; i < 100; i++){
			int n1 = DICE.nextInt(STUDENTS.length);
			int n2;
			do{
				n2 = DICE.nextInt(STUDENTS.length);
			} while(n2 == n1);
				
			String[] temp = STUDENTS[n1];
			STUDENTS[n1] = STUDENTS[n2];
			STUDENTS[n2] = temp;
		} 
	}
	
	private static boolean hasRoom(String houseName, boolean fullCapacity){
		int housePos = Arrays.asList(HOUSE_NAMES).indexOf(houseName); //Crea una lista temporanea dellìarray e chiede lìindice dei valori al suo interno
		if(fullCapacity){
			return COUNTERS[housePos] < HOUSE_SIZE;
		}else{
			return COUNTERS[housePos] < HOUSE_SIZE-1;
		}
	}

	private static void assignStudentToHouse(String studentName, houseName){
		int housePos = Arrays.asList(HOUSE_NAMES).indexOf(houseName);
		int studentPos = COUNTERS[housePos];
		HOUSES[housePos][studentPos] = studentName;
	}

}