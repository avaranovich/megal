tool = eclipse/megal

nope:
	@echo Want to build, test, or what?

# Compile MegaL tool
build: 
	pushd ${tool}; mvn package; popd; 

dist: build
	rm -r ./dist
	mkdir -p dist
	cp -r eclipse/megal/target/lib ./dist
	cp eclipse/megal/target/*jar ./dist
	cp eclipse/megal/target/*.megal ./dist
	cp eclipse/megal/target/*.conf ./dist

# Run a bunch of tests
test: build
	make ../models/java.tool
	#make models/extern.tool
	#make models/intern.tool
	#make models/mvc.tool

# Rule for running the MegaL tool
%.tool: dist
	cd ./dist; java -cp ".:megal-0.0.1-SNAPSHOT.jar:lib/*.jar" megal.Tool $*.megal
