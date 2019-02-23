import java.util.Scanner;

import org.json.*;

public class Launch {
	
	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		// User Input for which stage he want's go for.
		System.out.println("Please Choose the stage you'd like to go for (1-4)");
		int stage = Integer.parseInt(sc.nextLine());
				
		switch (stage) {
			case 1: stage1(); break;
			case 2: stage2(); break;
			case 3: stage3(); break;
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
		String damageAmp = calcDamageAmp(attackType, defenseTypes);
		
		// Print result
		System.out.println(damageAmp);
	}
	/*
	* function to calculate damage amp using attack type and an array of defense types
	* @returns amp damage result
	*/
	private static String calcDamageAmp(String attackType, String[] defenseTypes) {
		
		double result = 1;
		int attackIndex = TypesTable.getTypeIndex(attackType.toUpperCase());
		
		for(String type : defenseTypes) 
		{
			int defenseIndex = TypesTable.getTypeIndex(type.toUpperCase());
			
			result *= TypesTable.getDamageAmp(attackIndex, defenseIndex);
		}
		
		return "x"+result;
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
		String damageAmp = calcDamageAmpAPI(attackType, defenseTypes);
		
		// Print result
		System.out.println(damageAmp);
	}
	/*
	* function to calculate damage amp using attack type and an array of defense types (PokeAPI!)
	* @returns amp damage result
	*/
	private static String calcDamageAmpAPI(String attackType, String[] defenseTypes) {
		
		double result = 1;
		
		// Get from PokeAPI the damage_ralations object of the relevant attack type
		String url = PokeAPI.types.get(attackType);
		JSONObject json = PokeAPI.request(url);
		JSONObject damage_relations = json.getJSONObject("damage_relations");
		
		JSONArray double_damage_array = damage_relations.getJSONArray("double_damage_to");
		JSONArray half_damage_array = damage_relations.getJSONArray("half_damage_to");
		JSONArray no_damage_array = damage_relations.getJSONArray("no_damage_to");
		
		result*= getDamageAmpFromArray(double_damage_array, defenseTypes, 2);
		result*= getDamageAmpFromArray(half_damage_array, defenseTypes, 0.5);
		result*= getDamageAmpFromArray(no_damage_array, defenseTypes, 0);
		
		
		return "x"+result;
	}
	private static double getDamageAmpFromArray(JSONArray array, String[] defenseTypes, double damage_amp) {
		
		double result = 1;
		
		for (int i = 0; i < array.length(); ++i) {
		    JSONObject rec = array.getJSONObject(i);
		    String id = rec.getString("name");
		    
		    for(String type : defenseTypes) {
		    	if(id.equals(type.toLowerCase()))
		    		result*=damage_amp;
		    }
		}
		
		return result;
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
		String damageAmp = calcDamageAmpAPI(attackType, new String[] {defenseType});
		
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
