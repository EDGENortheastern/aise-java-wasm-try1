# Java WebAssembly Hello

A small Java to WebAssembly project.

## Step 1

During this step, a small Java program is created, compiled, and run locally using Maven.

```text
Hello World from Java 🌸
```

### What is needed

Before running the project, install:

- [Java JDK 17 or later](https://www.oracle.com/uk/java/technologies/downloads)
- Apache [Maven](https://maven.apache.org/install.html)
- Visual Studio Code
- 'Extension Pack for Java' in VS Code

### Check installation

After installing, check everything is available:

```bash
java -version
mvn -v
```

### Project structure at this stage

```text
.
├── docs/
├── src/
│   └── main/
│       └── java/
│           └── demo/
│               └── Main.java
├── pom.xml
└── README.md
```

### Compile and run

Compiling converts Java source code (.java) into bytecode (.class) that can be executed by the Java Virtual Machine (JVM).

**To compile the project:**

```bash
mvn compile
```

**To run the code:**

```bash
mvn exec:java -Dexec.mainClass="demo.Main"
```
