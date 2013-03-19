package megal.model;

import java.lang.reflect.InvocationTargetException;
import java.net.URI;
import java.util.List;

import megal.Entity;

public class EDecl extends Decl {
	private Modifier modifier;
	private EType type;
	private List<String> name;
	public EDecl(Modifier modifier, EType type, List<String> name) {
		this.modifier = modifier;
		this.type = type;
		this.name = name;
	}
	public Modifier getModifier() { return modifier; }
	public EType getType() { return type; }
	public List<String> getName() { return name; }

	public Entity getEntity(){
		Entity entity = null;
		
		try {
			Object[] params = {this};
			Class[] types = {this.getClass()};
			try {
				entity = (Entity)Class.forName(type.getName()).getConstructor(types).newInstance(params);
				
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (SecurityException e) {
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				e.printStackTrace();
			} catch (NoSuchMethodException e) {
				e.printStackTrace();
			}
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} 
		
		if (entity == null){
			//TODO: Resolver not found exception
		}
		return entity;
	}
}
