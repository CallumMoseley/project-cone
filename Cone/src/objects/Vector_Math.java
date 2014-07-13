package objects;

import static objects.CObject.*;
public class Vector_Math {
	public static CObject vector = new CObject();
	public static CObject matrix = new CObject();
	public static CObject n_vector = new CObject();
	public static CObject k_blade = new CObject();
	public static CObject space = new CObject();
	
	public static Relationship spans = new Relationship();
	
	public static Function scalar_product = new Function();
	public static Function dot_product = new Function();
	public static Function wedge_product = new Function();
	public static Function determinant = new Function();
	
	static{
		//a number is unsigned iff 
		//vector has_field length is_a unsigned real_number
		//vector has_field direction is_a direction
		
		//vector has_field size is_a real_number
		
		//a set, on whose elements scalar multiplication is defined
		//a linear combination of a set <c> is 
		//rank
		//dimension
		//determinant
		//a space has a dimension
		
		//dependent
		//independent
		
		//basis
		
		//dot_product.input = set of 2 vectors
		//dot_product.output is_a real_number = set
		//dot_product(vector represented by a sequence)
	}
}
