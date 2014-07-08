package objects;

import static objects.Format.*;

public class Context {
	Representation /*set of references*/ references;
	Context(Object... parameters){
		int length = parameters.length/2;
		Reference[] reference_array = new Reference[length];
		for(int i = 0; i < length; i++){
			reference_array[i] = new Reference((String)parameters[2*i], (Representation)parameters[2*i+1]);
		}
		references = new Representation(FArray, reference_array);
	}
	public static Representation context(Object... parameters){
		return new Representation(FContext, new Context(parameters));
	}
	
	public static class Reference{
		String name;
		Representation handle;
		Reference(String name, Representation handle){
			this.name = name;
			this.handle = handle;
		}
	}
}
