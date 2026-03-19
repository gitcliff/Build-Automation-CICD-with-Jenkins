// 📦 SUMMARY  
// This Groovy script defines a Jenkins Shared Library step that pushes a Docker image to a registry using a helper class.  
// Language/Platform: Groovy (Jenkins Shared Library)  
// What you'll learn: importing custom classes, defining reusable steps with `call()`, delegating logic to helper classes  
// Outcome: pushes the specified Docker image (by name/tag) to a container registry (e.g., Docker Hub, GitHub Container Registry)  
// Why this matters: abstracts Docker push logic for cleaner Jenkins pipelines and promotes code reuse across projects  

// ------------------------------  
// 🧩 IMPORT HELPER CLASS  
// ------------------------------  
import com.example.Docker  
// ✅ What it does: imports the Docker helper class from the `com.example` package in the shared library  
// 🧠 Why it matters: allows access to reusable Docker-related methods like dockerPush()  

// ------------------------------  
// 🧩 DEFINE CALLABLE STEP  
// ------------------------------  
def call(String imageName) {  
    // ✅ What it does: defines a Groovy function named `call` that accepts a single parameter: the Docker image name (with tag)  
    // 🧠 Why it matters: in Jenkins Shared Libraries, the `call()` function makes this script callable directly as a pipeline step  

    def docker = new Docker(this)  
    // ✅ What it does: creates a new instance of the Docker helper class, passing the current Jenkins pipeline script context (`this`)  
    // 🧠 Why it matters: gives the helper class access to pipeline methods like `sh`, `echo`, and credentials bindings  

    return docker.dockerPush(imageName)  
    // ✅ What it does: calls the helper class’s `dockerPush` method to push the Docker image to a container registry  
    // 🧠 Why it matters: centralizes and simplifies Docker push logic, enabling pipelines to just call `dockerPush('my-image:tag')`  
}  

// ------------------------------  
// ✅ NOTES / GOTCHAS / TIPS  
// ------------------------------  
// - `this` passes the Jenkins pipeline script context so the helper class can interact with Jenkins steps.  
// - Place this file in `vars/dockerPush.groovy` to use it as `dockerPush('my-image:tag')` in pipelines.  
// - Ensure `Docker.groovy` exists under `src/com/example/Docker.groovy` and implements a `dockerPush(String)` method.  
// - Example pipeline usage:  
//     dockerPush('my-dockerhub-user/my-app:latest')  // Pushes image to Docker Hub or configured registry  
