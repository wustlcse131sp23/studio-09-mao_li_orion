package studio9;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import assignment9.Drawable;
import support.cse131.NotYetImplementedException;

public class NameToHeight {
	/**
	 * Construct and fill a map with your studio group members' names, each
	 * associated with his or her height.
	 * 
	 * Construct an ArgsProcessor and loop asking the args processor for a name to
	 * lookup the height. When the user cancels (that is: when args processor
	 * returns null), break from the loop. Otherwise, loop up the name in the map
	 * and output the results. Be sure to handle the case where the map does not
	 * contain a specified name.
	 */
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		Map<String, Integer> heights = new HashMap<>();
		heights.put("Han", 173);
		heights.put("Harry", 190);
		heights.put("Orion", 169);
		
		boolean quit = false;
		
		while (quit == false) {
			System.out.println("Enter name.");
			String name = in.nextLine();
			
			if (name.equals("quit")) {
				quit = true;
				System.out.println("Bye bye.");
				break;
			} else if(heights.get(name) == null) {
				System.out.println("Dunno.");
			} else {
				System.out.println(heights.get(name));
			}
			
		}

	}
}
