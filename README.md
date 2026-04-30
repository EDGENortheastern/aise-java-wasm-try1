# Java to Browser with TeaVM

This project shows how to write a Java method and run it in a web browser, step by step.

Java cannot run in a browser directly. This project uses [TeaVM](https://teavm.org/) to compile Java into JavaScript that the browser can load. The project is built incrementally so each stage is understandable on its own.

---

## Prerequisites

Before starting, install the following:

- [Java JDK 17 or later](https://www.oracle.com/uk/java/technologies/downloads)
- [Apache Maven](https://maven.apache.org/install.html)
- [Visual Studio Code](https://code.visualstudio.com/) with the **Extension Pack for Java**

To verify your installation:

```bash
java -version
mvn -v
```

---

## Step 1 — Create and run a Java program locally

A minimal Java program is created and run on your machine using Maven.

**Project structure at this stage:**

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

Maven compiles `.java` source files into `.class` bytecode files that the Java Virtual Machine (JVM) can execute.

**Compile the project:**

```bash
mvn compile
```

**Run the program:**

```bash
mvn exec:java -Dexec.mainClass="demo.Main"
```

**Expected output:**

```text
Hello World from Java 🌸
```

---

## Step 2 — Refactor into a reusable method

The greeting logic is moved into a method called `helloName(name)`. This makes it possible to call the same logic from a web page later.

```java
package demo;

public class Main {

    public static String helloName(String name) {
        if (name == null || name.trim().isEmpty()) {
            return "Hello World from Java 🌸";
        }
        return "Hello " + name + " from Java 🌸";
    }

    public static void main(String[] args) {
        System.out.println(helloName("You"));
    }
}
```

At this stage the name is still hard-coded (`"You"`). The user cannot enter their own name yet.

---

## Step 3 — Add a web page

A simple HTML page is added to the `docs/` folder. It contains an input field and a button for displaying a personalised greeting.

**File added:**

```text
docs/index.html
```

The page is served via GitHub Pages (from the `docs/` folder). At this stage the greeting logic is not yet connected to Java — that comes in later steps.

**Preview:**

![Hello Java output](docs/assets/helloJava.png)

---

## Step 4 — Add temporary JavaScript greeting logic

A JavaScript file is added to make the page interactive. It duplicates the greeting logic from the Java method so the page works before the Java compilation is set up.

**File added:**

```text
docs/script.js
```

This is a temporary stand-in. The JavaScript version of `helloName` will be replaced once TeaVM compiles the real Java method for the browser.

---

## Step 5 — Compile Java for the browser using TeaVM

TeaVM is added to the Maven project. It reads the compiled Java bytecode and produces a JavaScript file that the browser can load.

**Why TeaVM?**

Browsers cannot run Java bytecode. TeaVM acts as a compiler that translates your Java classes into JavaScript. The `@JSExport` annotation on `helloName` tells TeaVM to make that method available as a global JavaScript function.

**TeaVM Maven plugin — [documentation](https://teavm.org/docs/tooling/maven.html)**

The plugin is configured in `pom.xml` to output a file called `classes.js` into the `docs/` folder:

```xml
<targetType>JAVASCRIPT</targetType>
<targetDirectory>docs</targetDirectory>
<targetFileName>classes.js</targetFileName>
```

**Run TeaVM:**

```bash
mvn teavm:compile
```

**File produced:**

```text
docs/classes.js
```

This file contains the entire Java runtime and your compiled `helloName` method. When `index.html` loads it, `helloName` becomes available as a global function — so the button on the page calls your Java code, running inside the browser.

The temporary `script.js` version is no longer needed once `classes.js` is in place.
