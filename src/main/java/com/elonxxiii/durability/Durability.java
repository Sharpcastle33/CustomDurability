package com.elonxxiii.durability;

public class Durability {

	//constants
		//config file for customizing would be nice
		//constants for Lore
	  int LORE_DURABILITY = 1;
      String STR_DURABILITY = "Durability: ";
	  String STR_DELIMITER = " / ";
		//constants for integer placement here: durability: cur / max
     int CURRENT_DURABILITY = 0;
     int MAX_DURABILITY = 1;
    
    public Durability(int current, int max){
    	CURRENT_DURABILITY = current;
    	MAX_DURABILITY = max;
    }
		
}
