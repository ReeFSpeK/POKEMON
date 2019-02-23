import java.util.Scanner;

import org.json.*;

public class Launch {
	
	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		// User Input for which stage he want's go for.
		// To finish, enter 0.
		boolean flag = true;
		while(flag) {
			System.out.println("Please Choose the stage you'd like to go for (1-3) {To finish, 0}");
			int stage = Integer.parseInt(sc.nextLine());
					
			switch (stage) {
				case 1: stage1(); 	break;
				case 2: stage2(); 	break;
				case 3: stage3(); 	break;
				case 0: flag=false; break;
			}
		}
	}
	
	private static void stage1() {
		
		// Print Usage
		printUsage(false);
		
		// Get User Input
		String input = sc.nextLine();
		
		// Split the types from the user input
		String attackType = input.split("->")[0];
		String[] defenseTypes = input.split("->")[1].split(" ");
		
		// Calculate the total damage amp for the attack
		String damageAmp = TypesTable.calcDamageAmp(attackType, defenseTypes);
		
		// Print result
		System.out.println(damageAmp);
	}

	private static void stage2() {
		
		// Print Usage
		printUsage(false);
		
		// Get User Input
		String input = sc.nextLine();
		
		// Split the types from the user input
		String attackType = input.split("->")[0];
		String[] defenseTypes = input.split("->")[1].split(" ");
		
		// Calculate the total damage amp for the attack		
		String damageAmp = PokeAPI.calcDamageAmp(attackType, defenseTypes);
		
		// Print result
		System.out.println(damageAmp);
	}
	
	private static void stage3() {
		
		// Print Usage
		printUsage(true);
		
		// Get User Input
		String input = sc.nextLine();
		
		// Split the types from the user input
		String moveName = input.split("->")[0];
		String pokemonName = input.split("->")[1];
		
		// Get the attack type of the Move name
		String url = "https://pokeapi.co/api/v2/move/"+moveName;
		JSONObject json = PokeAPI.request(url);
		JSONObject typeJson = json.getJSONObject("type");
		String attackType = typeJson.getString("name");
				
		// Get the attack type of the Pokemon name
		url = "https://pokeapi.co/api/v2/pokemon/"+pokemonName;
		json = PokeAPI.request(url);
		JSONArray typesArray = json.getJSONArray("types");
		String defenseType = "";
		for (int i = 0; i < typesArray.length(); ++i) {
		    JSONObject slot = typesArray.getJSONObject(i);
		    if(slot.getInt("slot") == 1) { //Assuming that we should always get the first slot..
		    	defenseType = slot.getJSONObject("type").getString("name");
		    }		    
		}
	
		//Calculate damage amp
		String damageAmp = PokeAPI.calcDamageAmp(attackType, new String[] {defenseType});
		
		System.out.println(damageAmp);
	}

	private static void printUsage(boolean isStage3) {
		
		// Print Usage
		System.out.println("USAGE: "
				+ (!isStage3 ?
				  "[attacking_type]->"
				+ "[defensive_type1] [defensive_type2] ... "
				+ "[defensive_typeN]" :
				  "[move_name]->"
				+ "[pokemon_name]" ));
	}
}
