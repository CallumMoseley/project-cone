package objects;
/**
 * A base object class 
 * Almost everything should be a representation
 * @author Nikita
 */
public class Representation {
	Format format;
	Object data;
	public Representation(){
		
	}
	public Representation(Format format, Object data) {
		this.format = format;
		this.data = data;
	}
	Representation translate(Format format){
		Representation result = new Representation();
		//create a new object to return
		try {
			result.data = format._class.newInstance();
		} catch (InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
			return null;
		}
//		for(_Field field: format.field_basis){
//			if(this.format.fields.contains(field)){
//				result.set(field, get(field));
//			}
//		}
		return null;
	}
	Representation get(_Field field){
		return null;
	}
	void set(_Field field, Representation value){
	}
	//A representation of a representation of x is also a representation of x
}
