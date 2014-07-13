package objects;

import java.lang.reflect.*;
import java.util.*;

import static objects.Context.*;
import static objects.Format.*;

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
	
	public _Method(Representation... operations){
		
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
					 cone_evaluate("method.evaluate(set.nth(i))", context("method", method, "set", set, "i", i));
				}
			}
			
			return null;
		}
	};
	public static _Method quick_java_evaluate = new _Method(){	
		@Override
		public Representation evaluate(Representation... arguments){
			return quick_java_evaluate((String)arguments[0].translate(FString).data, arguments[1].data, Arrays.copyOfRange(arguments, 2, arguments.length));
		}
	};
	
	/** 
	 * This is different from a normal minimum/maximum finding method in the detail that
	 * not less and not greater doesn't necessarily mean equivalent 
	 * the main difference is that equivalence is typically transitive 
	 * whereas not less and not greater is not necessarily transitive
	 * If we let === denote this kind of "intransitive equivalence", the following situation is possible
	 * a > b, a === c, b === c 
	 */
	public static Representation find_optimal_set(Representation set, Representation comparator/*Representation property Transitive Property/Comparative Trait*/){
		ArrayList<Representation> optimal_set = new ArrayList<Representation>();
//		for(Representation element: set){
//			boolean b = true;
//			boolean c = true;
//			for(Representation match: optimal_set) 
//				if(!element matches match))
//					c = false;
//				else if(match matches element))
//					b = false;
//			if(b){
//				if(c)
//					closest.clear();
//				closest.add(element);
//			}
//		}
		return new Representation(optimal_set);
	}
	/** Returns a set of ways [that a sequence can be partitioned into a disjoint sequence of subsequences that matches format] **/
	public static Representation cone_parse_sequence(String expression, Representation format){
		//set the last keyword index to the beginning of the line
		//get the next keyword index from the template
		//all the variables in the template between the two keywords are looked for in the string between the two keywords
		//all interpretations are added to a priority queue sorted by assumptions made
		//a word that you're familiar with as common is unlikely to have a meaning that you don't know, use that to deal with ties
		int last_index = 0;
		int index = 0;
		
		//set the last keyword index to the beginning of the line
		//read through checking if each word might be a keyword
		//all the variables in the template between the two keywords are looked for in the string between the two keywords
		//if valid they are added to a list of possible interpretations specific to the current template
		//a dumb search is something like O(n^2) to line length
		return null;
	}
	public static Representation cone_evaluate(String expression, Representation... arguments){
		return null;
	}
	
	/**A quick way to evaluate a java expression dynamically
	 * 
	 * Had to hard-code some helper methods so that this can be used independently of cone
	 */
	public static Representation quick_java_evaluate(String path, Object context, Representation... arguments){
		try
		{
			MethodData currentMethod = new MethodData();
			String s = path;
			Object co = context;
			int index = 0;
			String className = null;
			boolean new_flag = false;
			boolean doubleQuotes = false;
			ArrayList<Object> parameters = new ArrayList<Object>();
			Stack<MethodData> methodStack = new Stack<MethodData>();
			for(int i = 0; i < s.length(); i++){
				char g = s.charAt(i);
				if(!doubleQuotes){
					if(g=='.'){
						if(index!=i){
							if(className==null)
								co = co.getClass().getField(s.substring(index, i)).get(co);
							else{
								co = Class.forName(className).getField(s.substring(index, i)).get(null);
								className = null;
							}
						}
						index = i+1;
					}else if(g==':'){ //used to refer to a static field or method
						className = s.substring(index, i);
						index = i+1;
					}else if(g==','){
						String cs = s.substring(index, i);
						parameters.add(co = readParameter(cs, co, className, arguments));
						className = null;
						index = i+1;
					}else if(g=='\"'){
						doubleQuotes = true;
					}
					else if(g=='('){
						currentMethod.index = index;
						currentMethod.activeContext = co;
						currentMethod.parameters = parameters;
						currentMethod.className = className;
						methodStack.push(currentMethod);
						currentMethod = new MethodData();
						currentMethod.methodName = s.substring(index,i);
						co = context;
						className = null;
						parameters = new ArrayList<Object>();
						index = i+1;
					}
					else if(g==')'){
						String cs = s.substring(index, i);
						if(cs.length()!=0){
							parameters.add(co = readParameter(cs, co, className, arguments));
							className = null;
						}
						String methodName = currentMethod.methodName;
						currentMethod = methodStack.pop();
						co = currentMethod.activeContext;
						className = currentMethod.className;
						Object[] parameter_array = parameters.toArray();
						if(new_flag){
							Class[] classes = getClasses(parameter_array);
							new_flag = false;
							if(parameter_array.length==0)
								co = Class.forName(methodName).newInstance();
							else
								co = determineConstructor(className, methodName, parameter_array).newInstance(parameter_array);
						}
						else {
							Method method = determineMethod(co, className, methodName, parameter_array);
							if(method.isVarArgs()){
								Class[] parameter_types = method.getParameterTypes();
								if(!(parameter_array[parameter_types.length-1] instanceof Object[])){
									Object[] parameters_for_varargs = new Object[parameter_types.length];
									for(int j = 0; j < parameters_for_varargs.length-1; j++)
										parameters_for_varargs[j] = parameter_array[j];
									Object[] varargs = (Object[]) Array.newInstance(parameter_types[parameters_for_varargs.length-1], parameter_array.length-parameters_for_varargs.length+1);
									for(int j = 0; j < varargs.length; j++)
										varargs[j] = parameter_array[j+parameters_for_varargs.length-1];
									parameters_for_varargs[parameters_for_varargs.length-1] = varargs;
									parameter_array = parameters_for_varargs;
								}
							}
							co = method.invoke((className==null)?co:null, parameter_array);
						}
						parameters = currentMethod.parameters;
						index = i+1;
					}else if(g==' '){
						if(s.substring(index, i).equals("new")){
							new_flag = true;
						}
						index = i+1;
					}
				}else if(g=='\"'){
					doubleQuotes = false;
				}
			}
			if(index!=s.length())
				if(className==null)
					co = co.getClass().getField(s.substring(index)).get(co);
				else{
					co = Class.forName(className).getField(s.substring(index)).get(null);
					className = null;
				}
			return new Representation(co);
		}
		catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException | InvocationTargetException | ClassNotFoundException | InstantiationException e)
		{
			e.printStackTrace();
		}
		return null;
	}
	private static Object readParameter(String cs, Object co, String className, Representation... arguments){
		if('\"'==cs.charAt(0)&&'\"'==cs.charAt(cs.length()-1))
			return cs.substring(1, cs.length()-1);
		else if('\''==cs.charAt(0)&&'\''==cs.charAt(cs.length()-1))
			return cs.charAt(1);
		else if(cs.charAt(0)=='*')
			return arguments[Integer.parseInt(cs.substring(1))];
		else 
			try {
				if(className==null)
					return co.getClass().getField(cs).get(co);
				else
					return Class.forName(className).getField(cs).get(null);
			} catch (IllegalArgumentException | IllegalAccessException| NoSuchFieldException | SecurityException | ClassNotFoundException e) {
				e.printStackTrace();
			}
		return null;
	}
	private static Class[] getClasses(Object[] parameters){
		Class[] classes = new Class[parameters.length];
		for(int j = 0; j < parameters.length; j++){
			classes[j] = parameters[j].getClass();
			if(classes[j]==Integer.class)classes[j] = int.class;
			else if(classes[j]==Double.class)classes[j] = double.class;
			else if(classes[j]==Float.class)classes[j] = float.class;
			else if(classes[j]==Long.class)classes[j] = long.class;
			else if(classes[j]==Short.class)classes[j] = short.class;
			else if(classes[j]==Character.class)classes[j] = char.class;
			else if(classes[j]==Byte.class)classes[j] = byte.class;
			else if(classes[j]==Boolean.class)classes[j] = boolean.class;
		}
		return classes;
	}
	private static boolean matchesParameterTypes(Class[] classes, Object m){
		Class[] parameter_types = null;
		boolean is_varargs = false;
		if(m instanceof Method){
			parameter_types = ((Method)m).getParameterTypes();
			is_varargs = ((Method)m).isVarArgs();
		}else if (m instanceof Constructor){
			parameter_types = ((Constructor)m).getParameterTypes();
			is_varargs = ((Constructor)m).isVarArgs();
		}
		
		if(is_varargs&&(classes.length != parameter_types.length||classes[classes.length-1]==Object[].class/*Bad, multi-level arrays*/)){
			for(int i = 0; i < parameter_types.length-1; i++)
				if(!parameter_types[i].isAssignableFrom(classes[i]))
					return false;
			for(int i = parameter_types.length-1; i < classes.length; i++)
				if(!parameter_types[parameter_types.length-1].getComponentType().isAssignableFrom(classes[i]))
					return false;
		}
		else {
			if(classes.length != parameter_types.length) 
				return false;
			for(int i = 0; i < classes.length; i++)
				if(!parameter_types[i].isAssignableFrom(classes[i]))
					return false;
		}
		return true;
	}
	private static Method determineMethod(Object context, String className, String name, Object[] parameters){
		Class[] classes = getClasses(parameters);
		try
		{
			Method[] methods = (className != null) ? Class.forName(className).getMethods() : context.getClass().getMethods();
			ArrayList<Method> matches = new ArrayList<Method>(); //The best match so far
			for(Method met: methods)
				if(met.getName().equals(name) && matchesParameterTypes(classes, met)){
					boolean b = true;
					boolean c = true;
					for(Method match: matches) 
						if(!matchesParameterTypes(met.getParameterTypes(), match))
							c = false;
						else if(matchesParameterTypes(match.getParameterTypes(), met))
							b = false;
					if(b){
						if(c)
							matches.clear();
						matches.add(met);
					}
				}
			return (matches.size()==1)?matches.get(0):null;
		}
		catch (SecurityException | ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		return null;
	}
	private static Constructor determineConstructor(String className, String name, Object[] parameters){
		Class[] classes = getClasses(parameters);
		try
		{
			Constructor[] constructors = (className != null) ? Class.forName(className+'$'+name).getConstructors() : Class.forName(name).getConstructors();
			ArrayList<Constructor> matches = new ArrayList<Constructor>();
			for(Constructor constructor: constructors)
				if(constructor.getName().equals(name)&&matchesParameterTypes(classes, constructor)){
					boolean b = true;
					boolean c = true;
					for(Constructor match: matches) 
						if(!matchesParameterTypes(constructor.getParameterTypes(), match))
							c = false;
						else if(matchesParameterTypes(match.getParameterTypes(), constructor))
							b = false;
					if(b){
						if(c)
							matches.clear();
						matches.add(constructor);
					}
				}
			return (matches.size()==1)?matches.get(0):null;
		}
		catch (SecurityException | ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		return null;
	}
	private static class MethodData{
		Object activeContext;
		ArrayList<Object> parameters;
		String methodName;
		String className;
		int index;
	}
	
	public static Object ternaryIf(Representation condition, Object trueReturn, Object falseReturn){
		return (true/*condition*/) ? trueReturn : falseReturn;
	}
//	public static Representation[] group(Object... o){
//		for(int i = 0; i < o.length; i++){
//			
//		}
//	}
}
