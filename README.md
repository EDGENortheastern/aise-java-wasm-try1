# Java WebAssembly Hello

A small Java to WebAssembly project. To check what version of Java you have you might use:

```bash
java -version
```

or

```bash
java --version
```

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

## Step 2

During this step, the Java program is updated so that the greeting is produced by a reusable method `helloName(name)`.

This prepares the project for the next stage, where the greeting can be called from a web page.

### Goal

Create a method that can return a greeting using a name.

```text
Hello [Learner] from Java 🌸
```

The code:

```java
package demo; // groups classes together under a name demo

public class Main {

    public static String helloName(String name) {
        if (name == null || name.trim().isEmpty()){
            return "Hello World from Java 🌸";
        }
        return "Hello " + name + " from Java 🌸";
    }

    public static void main(String[] args) {
        System.out.println(helloName("You"));
    }
}

```

### Current limitation

At this stage, the name is hard-coded in the program:

```java
helloName("You")
```

This means the user cannot enter their own name yet.

## Step 3

During this step, a simple web page is added in the `docs/` folder.

The page lets the user enter a name and click a button to display a greeting.

At this stage, the greeting logic is still written in JavaScript. This allows the web page and GitHub Pages deployment to be tested before adding WebAssembly.

**Add a file to:**

```text
docs/index.html
```

### Output preview

You should see the following when viewing the page using Live Server:

![Hello Java output](docs/assets/helloJava.png)