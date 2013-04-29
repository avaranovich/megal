package megal;

import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import megal.model.RDecl;

import org.reflections.Reflections;

public class Runtime {

	public class Relationship{
		private Class<?> typedRelationship;

		public Relationship(Class<?> clazz){
			typedRelationship = clazz;
		}

		public boolean isCore(){
			ParameterizedType t = (ParameterizedType) typedRelationship.getGenericSuperclass();	
			return (t.getRawType() == megal.Relationship.class);
		}

		/**
		 * Get the underlying class for a type, or null if the type is a variable type.
		 * @param type the type
		 * @return the underlying class
		 */
		public  Class<?> getClass(Type type) {
			if (type instanceof Class) {
				return (Class) type;
			}
			else if (type instanceof ParameterizedType) {
				return getClass(((ParameterizedType) type).getRawType());
			}
			else if (type instanceof GenericArrayType) {
				Type componentType = ((GenericArrayType) type).getGenericComponentType();
				Class<?> componentClass = getClass(componentType);
				if (componentClass != null ) {
					return Array.newInstance(componentClass, 0).getClass();
				}
				else {
					return null;
				}
			}
			else {
				return null;
			}
		}

		public RDecl toRDecl(){
			Class<?> coreRel = getClass(typedRelationship);
			String name = getCore().typedRelationship.getSimpleName();

			ParameterizedType ptString = (ParameterizedType) coreRel.getGenericSuperclass();

			RDecl rdecl = new RDecl(
					name, 
					getClass(ptString.getActualTypeArguments()[0]).getSimpleName(), 
					getClass(ptString.getActualTypeArguments()[1]).getSimpleName(),
					false);

			return rdecl;
		}

		private Class<?> getSuperClass(Class<?> c){
			return c.getSuperclass();
		}

		public Relationship getCore(){
			Class<?> superClass = getSuperClass(typedRelationship);
			Runtime.Relationship rel = this;
			do{
				rel = new Runtime.Relationship(superClass);
				superClass = getSuperClass(superClass);
			} while (superClass != megal.Relationship.class);

			return rel;			
		}
	}

	private List<Relationship> coreRels;
	private List<Relationship> customRels;

	public Runtime(){
		coreRels = new ArrayList<Relationship>();
		customRels = new ArrayList<Relationship>();

		Reflections reflections = new Reflections("megal.relationships");
		@SuppressWarnings("rawtypes")
		Set<Class<? extends megal.Relationship>> subTypes = reflections.getSubTypesOf(megal.Relationship.class);

		for(Class<?> c: subTypes){
			ParameterizedType t = (ParameterizedType) c.getGenericSuperclass();

			if (t.getRawType() == megal.Relationship.class){
				//System.out.println("Core relationship: " + c);
				coreRels.add(new Relationship(c));
			} else {
				//System.out.println("Custom relationship: " + c);
				customRels.add(new Relationship(c));
			}
		}
	}

	public List<Relationship> getCoreRels(){
		return this.coreRels;
	}

	public List<Relationship> getCustomRels(){
		return this.customRels;
	}

	/*
	 * Convers all custom relationships in a form of realtionship delaration
	 */
	public List<RDecl> getCustomRDecls(){
		List<RDecl> decls = new ArrayList<RDecl>();
		for(Relationship r: customRels){
			decls.add(r.toRDecl());
		}

		return decls;
	}
}
