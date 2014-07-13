package objects;

import java.util.ArrayList;
import java.util.Arrays;
//A multistate is basically an element which is one of the elements in templates
public class Multistate {
	ArrayList<Object> templates = new ArrayList<Object>();
	Multistate(Object... templates){
		this.templates = new ArrayList<Object>(Arrays.asList(templates));
	}
}
