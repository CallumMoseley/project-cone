package objects;

import static objects._Method.*;

/**
 * Two methods may perform the same function
 * A function has an input, an output and nothing else
 * @author Nikita
 *
 */
public class Function {
	Representation /*list of formats*/ input;
	Representation /*format*/ output;
	
	Representation /*list of methods*/ methods;
	public Representation evaluate(Representation... arguments){
		return cone_evaluate("determine_method_to_use.evaluate(arguments)", arguments);
	}
	
	public Representation substitute(){
		return null;
	}
	
	public static Function factorial = new Function();
	public static Function sine = new Function();
	public static Function cosine = new Function();
}
