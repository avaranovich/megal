tool = eclipse/megal
antlruri = http://www.antlr4.org/download/antlr-4.0-complete.jar
antlrjar = ${tool}/libs/antlr-4.0-complete.jar
gsonuri = https://google-gson.googlecode.com/files/google-gson-2.2.2-release.zip
gsonjar = ${tool}/libs/google-gson-2.2.2/gson-2.2.2.jar

nope:
	@echo Want to build, test, or what?

# Download deps if needed
download: ${antlrjar} ${gsonjar}

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

# Helper for ANTLR download
${antlrjar}:
	cd ${tool}/libs; curl -O ${antlruri}

${gsonjar}:
	cd ${tool}/libs; curl -O ${gsonuri}; unzip google-gson-2.2.2-release.zip; rm google-gson-2.2.2-release.zip

# Helper for parser generation
${tool}/megal/parser/MegaLParser.java: ${tool}/megal/parser/MegaL.g4 ${tool}/megal/model/*.java Makefile download
	cd ${tool}/megal/parser; java \
		-cp ".:../../../../${antlrjar}" \
		org.antlr.v4.Tool \
		MegaL.g4

# Rule for tool compilation
${tool}/megal/Tool.class: ${tool}/megal/parser/*.java Makefile download
	cd ${tool}; \
	javac \
		-cp ".:../../${antlrjar}:../../${gsonjar}" \
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
		-cp "${tool}:${antlrjar}:${gsonjar}" \
		megal.Tool \
		${tool} \
		$*.megal
	diff $*.json $*.log

