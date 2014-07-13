package objects;

/**Basically just a function whose output is a boolean value (whether or not the relationship is had between the objects)
 * @author Nikita
 */
public class Relationship {
	Representation /*list*/ roles; //input 
	public static Relationship is_literally = new Relationship(); //is_equivalent with respect to all fields
	public static Relationship is_equivalent = new Relationship(); //this requires a set of fields according to which it is to be determined if objects are equivalent
	public static Relationship is_trait = new Relationship();
	public static Relationship is_a = new Relationship();
	public static Relationship has_field = new Relationship();
	public static Relationship matches = new Relationship();
	public static Relationship iff = new Relationship();
	public static Relationship _if = new Relationship();
	public static Relationship only_if = new Relationship();
	public static Relationship evaluates_to = new Relationship();
	public static Relationship logical_or = new Relationship();
	public static Relationship logical_and = new Relationship();
	public static Relationship logical_not = new Relationship();
}
