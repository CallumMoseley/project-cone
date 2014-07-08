package objects;

import java.util.*;
import static objects.Context.*;

public class _Method {
	Function function;
	
	Representation /*set of references*/ alterable; //This is what this method may alter
	
	/**
	 * 
	 * @return
	 */
	public Representation evaluate(Representation... arguments){
		return null;
	}
	
	public _Method(Object... operations){
		
	}
	public static _Method _while = new _Method(){
		/**
		 * 
		 */
		@Override
		public Representation evaluate(Representation... arguments){
			Object condition = arguments[0];
			Representation method = arguments[1];
//			while(condition){
//				cone_evaluate("method.evaluate(arguments)", arguments[1], Arrays.copyOfRange(arguments, 2, arguments.length));
//			}
			return null;
		}
	};
	public static _Method _for = new _Method(){
		/**
		 * 
		 */
		@Override
		public Representation evaluate(Representation... arguments){
			Representation set = arguments[0];
			Representation method = arguments[1];
			if(true/*set is_a sequence and set is_trait finite*/){
				/*Bad, assumes int*/
				int length = (int)cone_evaluate("set.length", context("set", set)).data;
				for(int i = 1; i <= length; i++){
					 //cone_evaluate("method.evaluate()")
				}
			}
			
			return null;
		}
	};
	public static _Method quick_java_evaluate = new _Method(){
		class MethodData{
			Object activeContext;
			ArrayList<Object> parameters;
			String methodName;
			String className;
			int index;
		}
		/**A quick way to evaluate a java expression dynamically
		 */
		
	};
	public static Representation cone_evaluate(String expression, Representation... arguments){
		return null;
	};
}
