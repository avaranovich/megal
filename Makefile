tool = eclipse/megal
antlr = antlr-4.0-complete.jar

nope:
	@echo Want to build, test, or what?

# Download ANTLR if needed
download: ${tool}/${antlr}

# Generate parser with ANTLR
generate: ${tool}/megal/parser/MegaLParser.java

# Compile MegaL tool
build: ${tool}/megal/Tool.class

# Run a bunch of tests
test: build
	make models/java.tool
	make models/extern.tool
	make models/intern.tool
	make models/mvc.tool
	make models/prelude.tool

# Helper for ANTLR download
${antlr}:
	cd ${tool}; curl -O http://www.antlr4.org/download/${antlr}

# Helper for parser generation
${tool}/megal/parser/MegaLParser.java: ${tool}/${antlr} ${tool}/megal/parser/MegaL.g4 ${tool}/megal/model/*.java Makefile
	cd ${tool}/megal/parser; java \
		-cp ".:../../${antlr}" \
		org.antlr.v4.Tool \
		MegaL.g4

# Rule for tool compilation
${tool}/megal/Tool.class: ${tool}/${antlr} ${tool}/megal/parser/*.java Makefile
	cd ${tool}; \
	javac \
		-cp ".:${antlr}" \
		megal/model/*.java \
		megal/entities/*.java \
		megal/relationships/*.java \
		megal/analysis/*.java \
		megal/parser/*.java \
		megal/trivia/*.java \
		megal/*.java

# Rule for running the MegaL tool
%.tool:
	java \
		-cp "${tool}:${tool}/${antlr}" \
		megal.Tool \
		$*.megal
