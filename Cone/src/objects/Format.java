package objects;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;

import static objects.CObject.*;
import static objects._Field.*;
import static objects._Method.*;

public class Format {
	
	HashMap<_Field, _Method> getMap = new HashMap<_Field, _Method>();
	HashMap<_Field, _Method> setMap = new HashMap<_Field, _Method>();
	CObject template;
	Class _class;
	Representation /*set of references*/ field_basis; //These fields will be stored in memory, other fields will be computed from them.
	
	Format(CObject template){
		this.template = template;
	}
	Format(CObject template, Class _class){
		this.template = template;
		this._class = _class;
	}
	void setField(_Field field, _Method method){
		this.getMap.put(field, method);
	}
	void setGetter(_Field field, _Method method){
		
	}
	//object <-> set(object)
	
	public static Format FFormat = new Format(format, Format.class);
	public static Format FCObject = new Format(object, CObject.class);
	public static Format F_Method = new Format(method, _Method.class);
	public static Format FContext = new Format(context, Context.class);
	public static Format FRepresentation = new Format(representation, Representation.class);
	
	public static Format FHashMap = new Format(map, HashMap.class);
	public static Format FString = new Format(string, String.class);
	public static Format FArray = new Format(sequence);
	public static Format FArrayList = new Format(sequence, ArrayList.class);
	
	public static Format FComparator = new Format(comparator, Comparator.class);
	
	public static Format Fint = new Format(integer, int.class);
	public static Format Fchar = new Format(character, char.class);
	
	public static HashMap<Class, Format> default_formats = new HashMap<Class, Format>();
	public static HashMap<Pair<Format, Format>, _Method> default_translations = new HashMap<Pair<Format, Format>, _Method>();
	
	static{
		//FString.getMap.put(nth, new _Method(quick_java_evaluate, "this.charAt(n)", new String[]{"this", "n"}));
		//FHashMap.getMap.put();
		//FArray.getMap.put(subsequences), new _Method("Arrays.copyOfRange(this, start_index, end_index)", )
		//FString.getMap.put(subsequences), new _Method("this.substring(start_index, end_index)")
		//FArrayList.getMap.put(subsequences), new _Method("this.subList(start_index, end_index)")
		//start_index and end_index as_a subsequence of a sequence
		//default_translations.put(new Pair<Format, Format>(FArray, FArrayList), new _Method(quick_java_evaluate, "Arrays.asList(array)")));
		//default_translations.put(new Pair<Format, Format>(Fchar, Fint), new _Method
		//'0'..'9' ---((int)c-'0')---> 0 .. 9
		
		
	}
}
