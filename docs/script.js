function helloName(name) {
    if (!name || name.trim() === "") {
        return "Hello World from Java 🌸";
    }

    return "Hello " + name + " from Java 🌸";
}

document.getElementById("helloButton").addEventListener("click", function () {
    const name = document.getElementById("nameInput").value;
    document.getElementById("output").textContent = helloName(name);
});