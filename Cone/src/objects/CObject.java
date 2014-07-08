package objects;

import java.util.ArrayList;
import static objects._Field.*;
/**
 * A standard conceptual representation of an object
 * @author Nikita
 */
public class CObject {
	ArrayList<_Field> fields;
	
	public static CObject format = new CObject();
	public static CObject representation = new CObject();
	public static CObject method = new CObject();
	public static CObject object = new CObject();
	public static CObject context = new CObject();
	
	public static CObject map = new CObject();
	public static CObject function = new CObject();
	public static CObject set = new CObject();
	public static CObject sequence = new CObject();
	public static CObject string = new CObject();
	
	public static CObject number = new CObject();
	public static CObject integer = new CObject();
	public static CObject u_integer = new CObject();
	public static CObject character = new CObject();
	public static CObject _boolean = new CObject();
	
	public static CObject _byte = new CObject();
	public static CObject _bit = new CObject();
	static{
		//_byte.template isA sequence of _bit with length 8;
		set.fields.add(size);
		set.fields.add(cardinality);
	}
}
