package objects;

import java.util.ArrayList;
import static objects._Field.*;
/**
 * A standard conceptual representation of an object
 * @author Nikita
 */
public class CObject {
	ArrayList<_Field> fields;
	//fields contains all of the fields of the templates of every class
	public Representation get(Representation field, Representation... arguments){
		//_Method.select_closest_match(fields, );
		return null;
	}
	
	public static CObject format = new CObject();
	public static CObject representation = new CObject();
	public static CObject method = new CObject();
	public static CObject field = new CObject();
	public static CObject object = new CObject();
	public static CObject context = new CObject();
	public static CObject _class = new CObject();
	public static CObject relationship = new CObject();
	public static CObject reference = new CObject();
	public static CObject comparator = new CObject();
	public static CObject multistate = new CObject();
	
	public static CObject map = new CObject();
	public static CObject function = new CObject();
	public static CObject set = new CObject();
	public static CObject sequence = new CObject();
	public static CObject string = new CObject();
	
	public static CObject number = new CObject();
	public static CObject real_number = new CObject();
	public static CObject integer = new CObject();
	public static CObject u_integer = new CObject();
	public static CObject character = new CObject();
	public static CObject _boolean = new CObject();
	
	public static CObject less_than = new CObject();
	public static CObject more_than = new CObject();
	public static CObject equal_to = new CObject();
	
	public static CObject template = new CObject();
	
	public static CObject direction = new CObject();
	
	public static CObject _byte = new CObject();
	public static CObject _bit = new CObject();
	static{
		//_boolean is_literally multistate(true, false)
		//
		//comparator.template is_a map from pair to multistate(less_than, equal_to, more_than)
		//
		//the <a, is_a class> <b> //<b> as_a <a>
		//each of <a, is_a set> refers to <a>.template
		//<a, is_a set> of <b, is_a _class> means that <a>.template is_a <b>
		//_byte.template is_a sequence of _bit with length 8;
		//_class.template has_field template
		//
		//set.fields.add(size);
		//set.fields.add(cardinality);
	}
}
