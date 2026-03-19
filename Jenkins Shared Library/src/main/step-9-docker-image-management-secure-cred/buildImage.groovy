// 📦 SUMMARY  
// This Groovy script defines a Jenkins Shared Library step that builds a Docker image using a helper class.  
// Language/Platform: Groovy (Jenkins Shared Library)  
// What you'll learn: importing custom classes, defining `call()` for shared library steps, passing Jenkins pipeline context  
// Outcome: builds a Docker image with the provided tag by invoking a reusable helper method  
// Why this matters: encapsulates Docker build logic for clean, reusable pipelines  

// ------------------------------  
// 🧩 IMPORT HELPER CLASS  
// ------------------------------  
import com.example.Docker  
// ✅ What it does: imports the custom Docker helper class from the com.example package inside the shared library  
// 🧠 Why it matters: allows this script to create Docker objects and call their methods (like buildDockerImage)  

// ------------------------------  
// 🧩 DEFINE CALLABLE STEP  
// ------------------------------  
def call(String imageName) {  
    // ✅ What it does: defines a Groovy function named `call` that takes a single parameter (imageName)  
    // 🧠 Why it matters: in Jenkins Shared Libraries, defining `call()` makes this script callable as a pipeline step (e.g., buildImage('tag'))  

    return new Docker(this).buildDockerImage(imageName)  
    // ✅ What it does:  
    //   1️⃣ Creates a new instance of the Docker helper class, passing `this` (the current pipeline script context)  
    //   2️⃣ Calls the helper class method `buildDockerImage` with the provided image name  
    // 🧠 Why it matters: abstracts Docker CLI logic into a reusable class, keeping pipeline code clean and DRY  
}  

// ------------------------------  
// ✅ NOTES / GOTCHAS / TIPS  
// ------------------------------  
// - `this` gives the Docker helper access to Jenkins pipeline steps like `sh`, `echo`, etc.  
// - Place this file in `vars/buildImage.groovy` to make it callable in pipelines as buildImage('my-image:tag')  
// - Ensure the helper class `Docker.groovy` is in `src/com/example/Docker.groovy` and contains a method `buildDockerImage(String)`  
// - Example pipeline usage:  
//     buildImage('my-dockerhub-user/my-app:latest')  
