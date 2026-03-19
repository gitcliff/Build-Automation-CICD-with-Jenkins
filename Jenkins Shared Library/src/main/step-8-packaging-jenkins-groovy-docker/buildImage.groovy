// 📦 SUMMARY  
// This Groovy function (part of a Jenkins shared library) creates a new instance of a Docker helper class and calls its method to build a Docker image.  
// Language/Platform: Groovy (Jenkins shared library)  
// What you'll learn: importing classes, defining callable steps in shared libraries, delegating logic to helper classes  
// Outcome: builds a Docker image with the provided name using shared library helper methods  
// Why this matters: keeps pipeline code clean by abstracting Docker build logic into reusable library functions  

// ------------------------------  
// 🧩 IMPORT HELPER CLASS  
// ------------------------------  
import com.example.Docker  
// ✅ What it does: imports the Docker helper class from the com.example package  
// 🧠 Why it matters: allows this script to use Docker-related methods defined elsewhere in the shared library  
// ------------------------------  
// 🧩 DEFINE CALLABLE FUNCTION  
// ------------------------------  
def call(String imageName) {  
    // ✅ What it does: Defines a Groovy function named `call` that takes a single parameter `imageName`  
    // 🧠 Why it matters: In Jenkins Shared Libraries, the `call` method allows this script to be invoked like a native pipeline step.
    //    For example, you can just write `buildImage('my-image:latest')` in your Jenkinsfile without creating an object manually.

    return new Docker(this).buildDockerImage(imageName)  
    // ✅ What it does: Executes multiple steps in one line:
    //    1. `new Docker(this)` creates a new instance of the Docker helper class, passing the current pipeline script context (`this`).  
    //       This gives the class access to pipeline methods like `sh`, `echo`, and `withCredentials`.
    //    2. `.buildDockerImage(imageName)` calls the method to build a Docker image with the specified tag.  
    // 🧠 Why it matters:  
    //    - Encapsulates Docker build logic in a reusable helper class.  
    //    - Keeps your Jenkinsfile clean and readable by delegating details to the shared library class.  
    //    - Promotes maintainability: if you need to update the Docker build steps, you only change it in the class, not every pipeline.
}  

// ------------------------------  
// ✅ NOTES / GOTCHAS / TIPS  
// ------------------------------  
// - `this` refers to the Jenkins pipeline script context, giving the helper class access to pipeline methods like `sh`, `echo`, etc.  
// - Ensure the `com.example.Docker` class exists in your shared library under `vars` or `src/com/example/Docker.groovy`.  
// - To call this step in a pipeline, you would use:  
//       buildImage('your-dockerhub-username/app:latest')  
//   Here, `buildImage` corresponds to the Groovy file name in `vars/` containing this `call` method.  
// - Follow Jenkins Shared Library structure (`vars/` for step scripts, `src/` for helper classes) for proper loading of classes and scripts.  
// - Beginner tip: Always test the shared library functions in a simple pipeline first to confirm access to credentials, Docker, and other tools.  
