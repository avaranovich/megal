package megal;

import java.util.List;

/**
 * 
 * <code>
 * {"relationships":[{
 * 				    "relationship": "megal.relationships.custom.FileElementOfLanguage",
 * 					"config":{
 * 						"type": "class",
 * 						"resource": "http://101companies.org/resources/languages/Java",
 * 						"checker": "megal.checkers.languages.Java" 
 * 					}
 * 				]}}
 * </code>
 *
 */
public class Config {
	static class CheckerConfig {
		private String relationship;
		private String type;
		private String checker;
		
		public CheckerConfig() {}
		
		public String getRelationship() {
			return relationship;
		}
		public void setRelationship(String relationship) {
			this.relationship = relationship;
		}
		public String getType() {
			return type;
		}
		public void setType(String type) {
			this.type = type;
		}
		public String getChecker() {
			return checker;
		}
		public void setChecker(String resolver) {
			this.checker = resolver;
		}
	}
	
	private List<CheckerConfig> checkers;
	
	public List<CheckerConfig> getCheckers() { return checkers; }
}
