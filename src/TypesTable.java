import java.util.HashMap;

public class TypesTable {

    protected static HashMap<String, Integer> types = initTypes();
    protected static double[][] table = initTable();
    
	/*
	 * Function the initialize the HashTable of the types.
	 */
	private static HashMap<String, Integer> initTypes() {
		
		HashMap<String, Integer> types = new HashMap<String, Integer>();
		
		types.put("NORMAL", 0);
		types.put("FIGHTING", 1);
		types.put("FLYING", 2);
		types.put("POISON", 3);
		types.put("GROUND", 4);
		types.put("ROCK", 5);
		types.put("BUG", 6);
		types.put("GHOST", 7);
		types.put("STEEL", 8);
		types.put("FIRE", 9);
		types.put("WATER", 10);
		types.put("GRASS", 11);
		types.put("ELECTRIC", 12);
		types.put("PSYCHIC", 13);
		types.put("ICE", 14);
		types.put("DRAGON", 15);
		types.put("DARK", 16);
		types.put("FAIRY", 17);
		
		return types;
	}
	
	/*
	 * Function the initialize the Table of the Damage Amp.
	 */
	private static double[][] initTable() {
		
		/*
		 * Python script to take the table from: https://bulbapedia.bulbagarden.net/wiki/Type
		 * And make it into a Java compatible 2D Array:
		 * (Script is attached as 'matrix.py', also the table I used for as 'Table.txt')
		*/
    	
		double[][] table = new double[18][18];
		
		table[0][0] = 1;
		table[0][1] = 1;
		table[0][2] = 1;
		table[0][3] = 1;
		table[0][4] = 1;
		table[0][5] = 0.5;
		table[0][6] = 1;
		table[0][7] = 0;
		table[0][8] = 0.5;
		table[0][9] = 1;
		table[0][10] = 1;
		table[0][11] = 1;
		table[0][12] = 1;
		table[0][13] = 1;
		table[0][14] = 1;
		table[0][15] = 1;
		table[0][16] = 1;
		table[0][17] = 1;
		table[1][0] = 2;
		table[1][1] = 1;
		table[1][2] = 0.5;
		table[1][3] = 0.5;
		table[1][4] = 1;
		table[1][5] = 2;
		table[1][6] = 0.5;
		table[1][7] = 0;
		table[1][8] = 2;
		table[1][9] = 1;
		table[1][10] = 1;
		table[1][11] = 1;
		table[1][12] = 1;
		table[1][13] = 0.5;
		table[1][14] = 2;
		table[1][15] = 1;
		table[1][16] = 2;
		table[1][17] = 0.5;
		table[2][0] = 1;
		table[2][1] = 2;
		table[2][2] = 1;
		table[2][3] = 1;
		table[2][4] = 1;
		table[2][5] = 0.5;
		table[2][6] = 2;
		table[2][7] = 1;
		table[2][8] = 0.5;
		table[2][9] = 1;
		table[2][10] = 1;
		table[2][11] = 2;
		table[2][12] = 0.5;
		table[2][13] = 1;
		table[2][14] = 1;
		table[2][15] = 1;
		table[2][16] = 1;
		table[2][17] = 1;
		table[3][0] = 1;
		table[3][1] = 1;
		table[3][2] = 1;
		table[3][3] = 0.5;
		table[3][4] = 0.5;
		table[3][5] = 0.5;
		table[3][6] = 1;
		table[3][7] = 0.5;
		table[3][8] = 0;
		table[3][9] = 1;
		table[3][10] = 1;
		table[3][11] = 2;
		table[3][12] = 1;
		table[3][13] = 1;
		table[3][14] = 1;
		table[3][15] = 1;
		table[3][16] = 1;
		table[3][17] = 2;
		table[4][0] = 1;
		table[4][1] = 1;
		table[4][2] = 0;
		table[4][3] = 2;
		table[4][4] = 1;
		table[4][5] = 2;
		table[4][6] = 0.5;
		table[4][7] = 1;
		table[4][8] = 2;
		table[4][9] = 2;
		table[4][10] = 1;
		table[4][11] = 0.5;
		table[4][12] = 2;
		table[4][13] = 1;
		table[4][14] = 1;
		table[4][15] = 1;
		table[4][16] = 1;
		table[4][17] = 1;
		table[5][0] = 1;
		table[5][1] = 0.5;
		table[5][2] = 2;
		table[5][3] = 1;
		table[5][4] = 0.5;
		table[5][5] = 1;
		table[5][6] = 2;
		table[5][7] = 1;
		table[5][8] = 0.5;
		table[5][9] = 2;
		table[5][10] = 1;
		table[5][11] = 1;
		table[5][12] = 1;
		table[5][13] = 1;
		table[5][14] = 2;
		table[5][15] = 1;
		table[5][16] = 1;
		table[5][17] = 1;
		table[6][0] = 1;
		table[6][1] = 0.5;
		table[6][2] = 0.5;
		table[6][3] = 0.5;
		table[6][4] = 1;
		table[6][5] = 1;
		table[6][6] = 1;
		table[6][7] = 0.5;
		table[6][8] = 0.5;
		table[6][9] = 0.5;
		table[6][10] = 1;
		table[6][11] = 2;
		table[6][12] = 1;
		table[6][13] = 2;
		table[6][14] = 1;
		table[6][15] = 1;
		table[6][16] = 2;
		table[6][17] = 0.5;
		table[7][0] = 0;
		table[7][1] = 1;
		table[7][2] = 1;
		table[7][3] = 1;
		table[7][4] = 1;
		table[7][5] = 1;
		table[7][6] = 1;
		table[7][7] = 2;
		table[7][8] = 1;
		table[7][9] = 1;
		table[7][10] = 1;
		table[7][11] = 1;
		table[7][12] = 1;
		table[7][13] = 2;
		table[7][14] = 1;
		table[7][15] = 1;
		table[7][16] = 0.5;
		table[7][17] = 1;
		table[8][0] = 1;
		table[8][1] = 1;
		table[8][2] = 1;
		table[8][3] = 1;
		table[8][4] = 1;
		table[8][5] = 2;
		table[8][6] = 1;
		table[8][7] = 1;
		table[8][8] = 0.5;
		table[8][9] = 0.5;
		table[8][10] = 0.5;
		table[8][11] = 1;
		table[8][12] = 0.5;
		table[8][13] = 1;
		table[8][14] = 2;
		table[8][15] = 1;
		table[8][16] = 1;
		table[8][17] = 2;
		table[9][0] = 1;
		table[9][1] = 1;
		table[9][2] = 1;
		table[9][3] = 1;
		table[9][4] = 1;
		table[9][5] = 0.5;
		table[9][6] = 2;
		table[9][7] = 1;
		table[9][8] = 2;
		table[9][9] = 0.5;
		table[9][10] = 0.5;
		table[9][11] = 2;
		table[9][12] = 1;
		table[9][13] = 1;
		table[9][14] = 2;
		table[9][15] = 0.5;
		table[9][16] = 1;
		table[9][17] = 1;
		table[10][0] = 1;
		table[10][1] = 1;
		table[10][2] = 1;
		table[10][3] = 1;
		table[10][4] = 2;
		table[10][5] = 2;
		table[10][6] = 1;
		table[10][7] = 1;
		table[10][8] = 1;
		table[10][9] = 2;
		table[10][10] = 0.5;
		table[10][11] = 0.5;
		table[10][12] = 1;
		table[10][13] = 1;
		table[10][14] = 1;
		table[10][15] = 0.5;
		table[10][16] = 1;
		table[10][17] = 1;
		table[11][0] = 1;
		table[11][1] = 1;
		table[11][2] = 0.5;
		table[11][3] = 0.5;
		table[11][4] = 2;
		table[11][5] = 2;
		table[11][6] = 0.5;
		table[11][7] = 1;
		table[11][8] = 0.5;
		table[11][9] = 0.5;
		table[11][10] = 2;
		table[11][11] = 0.5;
		table[11][12] = 1;
		table[11][13] = 1;
		table[11][14] = 1;
		table[11][15] = 0.5;
		table[11][16] = 1;
		table[11][17] = 1;
		table[12][0] = 1;
		table[12][1] = 1;
		table[12][2] = 2;
		table[12][3] = 1;
		table[12][4] = 0;
		table[12][5] = 1;
		table[12][6] = 1;
		table[12][7] = 1;
		table[12][8] = 1;
		table[12][9] = 1;
		table[12][10] = 2;
		table[12][11] = 0.5;
		table[12][12] = 0.5;
		table[12][13] = 1;
		table[12][14] = 1;
		table[12][15] = 0.5;
		table[12][16] = 1;
		table[12][17] = 1;
		table[13][0] = 1;
		table[13][1] = 2;
		table[13][2] = 1;
		table[13][3] = 2;
		table[13][4] = 1;
		table[13][5] = 1;
		table[13][6] = 1;
		table[13][7] = 1;
		table[13][8] = 0.5;
		table[13][9] = 1;
		table[13][10] = 1;
		table[13][11] = 1;
		table[13][12] = 1;
		table[13][13] = 0.5;
		table[13][14] = 1;
		table[13][15] = 1;
		table[13][16] = 0;
		table[13][17] = 1;
		table[14][0] = 1;
		table[14][1] = 1;
		table[14][2] = 2;
		table[14][3] = 1;
		table[14][4] = 2;
		table[14][5] = 1;
		table[14][6] = 1;
		table[14][7] = 1;
		table[14][8] = 0.5;
		table[14][9] = 0.5;
		table[14][10] = 0.5;
		table[14][11] = 2;
		table[14][12] = 1;
		table[14][13] = 1;
		table[14][14] = 0.5;
		table[14][15] = 2;
		table[14][16] = 1;
		table[14][17] = 1;
		table[15][0] = 1;
		table[15][1] = 1;
		table[15][2] = 1;
		table[15][3] = 1;
		table[15][4] = 1;
		table[15][5] = 1;
		table[15][6] = 1;
		table[15][7] = 1;
		table[15][8] = 0.5;
		table[15][9] = 1;
		table[15][10] = 1;
		table[15][11] = 1;
		table[15][12] = 1;
		table[15][13] = 1;
		table[15][14] = 1;
		table[15][15] = 2;
		table[15][16] = 1;
		table[15][17] = 0;
		table[16][0] = 1;
		table[16][1] = 0.5;
		table[16][2] = 1;
		table[16][3] = 1;
		table[16][4] = 1;
		table[16][5] = 1;
		table[16][6] = 1;
		table[16][7] = 2;
		table[16][8] = 1;
		table[16][9] = 1;
		table[16][10] = 1;
		table[16][11] = 1;
		table[16][12] = 1;
		table[16][13] = 2;
		table[16][14] = 1;
		table[16][15] = 1;
		table[16][16] = 0.5;
		table[16][17] = 0.5;
		table[17][0] = 1;
		table[17][1] = 2;
		table[17][2] = 1;
		table[17][3] = 0.5;
		table[17][4] = 1;
		table[17][5] = 1;
		table[17][6] = 1;
		table[17][7] = 1;
		table[17][8] = 0.5;
		table[17][9] = 0.5;
		table[17][10] = 1;
		table[17][11] = 1;
		table[17][12] = 1;
		table[17][13] = 1;
		table[17][14] = 1;
		table[17][15] = 2;
		table[17][16] = 2;
		table[17][17] = 1;
	    
	    return table;
	}
	
	/*
	* function to calculate damage amp using attack type and an array of defense types
	* @returns amp damage result
	*/
	protected static String calcDamageAmp(String attackType, String[] defenseTypes) {
		
		double result = 1;
		int attackIndex = TypesTable.getTypeIndex(attackType.toUpperCase());
		
		for(String type : defenseTypes) 
		{
			int defenseIndex = TypesTable.getTypeIndex(type.toUpperCase());
			
			result *= TypesTable.getDamageAmp(attackIndex, defenseIndex);
		}
		
		return "x"+result;
	}

	/*
	 * function to get Damage amp from the "damage amp table" using attack and defense indexes.
	 */
	private static double getDamageAmp(int attackIndex, int defenseIndex) {
		
		return TypesTable.table[attackIndex][defenseIndex];
	}

	/*
	 * function to get type index from the types HashTable.
	 */
	protected static int getTypeIndex(String type) {
		return types.get(type);
	}
}
