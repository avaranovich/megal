tool = eclipse/megal

nope:
	@echo Want to build, test, or what?

# Generate parser with ANTLR
generate: ${tool}/megal/parser/MegaLParser.java

# Compile MegaL tool
build: 
	cd ${tool}; mvn package

# Run a bunch of tests
test: build
	make models/java.tool
	make models/extern.tool
	make models/intern.tool
	make models/mvc.tool

# Rule for running the MegaL tool
%.tool:
	java \
		-cp "${tool}:${antlrjar}:${gsonjar}" \
		megal.Tool \
		${tool} \
		$*.megal
	diff $*.json $*.log

