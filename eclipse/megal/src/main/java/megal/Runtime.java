package megal;

import java.lang.annotation.Annotation;
import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import megal.entities.Entity;
import megal.model.RDecl;
import megal.model.RTypeDecl;
import megal.relationships.WeakRel;

import org.reflections.Reflections;

public class Runtime {

	public class Relationship{
		private Class<?> typedRelationship;

		public Relationship(Class<?> clazz){
			typedRelationship = clazz;
		}

		/*
		 * Checks if the relationship is weak, i.e. it cannot be evaluated.
		 */
		public boolean isWeak(){
			return typedRelationship.isAnnotationPresent(WeakRel.class);
		}
		
		/*
		 * Creates a new instance of the relationship, parametrized with two entities and current relationship type declaration.
		 */
		public megal.relationships.Relationship<?,?> newInstance(Entity first, Entity second, RTypeDecl rTypeDecl) throws IllegalArgumentException, SecurityException, InstantiationException, IllegalAccessException, InvocationTargetException, NoSuchMethodException{
			@SuppressWarnings("rawtypes")
			Class[] types = {first.getClass(), second.getClass(), rTypeDecl.getClass()};
			
			Object[] params = {first, second, rTypeDecl};
			

			return (megal.relationships.Relationship<?, ?>) typedRelationship.getConstructor(types).newInstance(params);
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
		
		private ParameterizedType getGenericSuperClass(Class clazz){
			Type superClass = clazz.getGenericSuperclass();
			try{
				return (ParameterizedType) superClass;
			}
			catch(ClassCastException ex){
				return this.getGenericSuperClass(clazz.getSuperclass());
			}			
		}

		public RTypeDecl toRTypeDecl(){
			Class<?> coreRel = getClass(typedRelationship);
			String name = getCore().typedRelationship.getSimpleName();

			ParameterizedType ptString = getGenericSuperClass(coreRel); //(ParameterizedType) coreRel.getGenericSuperclass();

			RTypeDecl rdecl = new RTypeDecl(
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
			} while (superClass != megal.relationships.Relationship.class);

			return rel;			
		}
	}

	private List<Relationship> weakRels;
	private List<Relationship> customRels;

	public Runtime(){
		weakRels = new ArrayList<Relationship>();
		customRels = new ArrayList<Relationship>();

		Reflections reflections = new Reflections("megal.relationships");
		@SuppressWarnings("rawtypes")
		Set<Class<? extends megal.relationships.Relationship>> subTypes = reflections.getSubTypesOf(megal.relationships.Relationship.class);

		@SuppressWarnings("unchecked")
		Set<Class<?>> wr = reflections.getTypesAnnotatedWith(WeakRel.class);
		
		for(Class<?> c: subTypes){

			if (wr.contains(c)){
				System.out.println("Weak relationship: " + c);
				weakRels.add(new Relationship(c));
			} else {
				System.out.println("Custom relationship: " + c);
				customRels.add(new Relationship(c));
			}
		}
	}
	
	public List<Relationship> getAllRels(){
		List<Relationship> allRels = new ArrayList<Relationship>(this.weakRels);
		allRels.addAll(customRels);
		return allRels;
	}

	public List<Relationship> getWeakRels(){
		return this.weakRels;
	}

	public List<Relationship> getCustomRels(){
		return this.customRels;
	}

	/*
	 * Converts all custom relationships in a form of realtionship delaration
	 */
	public List<RTypeDecl> getCustomRDecls(){
		List<RTypeDecl> decls = new ArrayList<RTypeDecl>();
		for(Relationship r: customRels){
			decls.add(r.toRTypeDecl());
		}

		return decls;
	}
}
