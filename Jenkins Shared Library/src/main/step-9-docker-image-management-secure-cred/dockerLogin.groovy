// 📦 SUMMARY  
// This Groovy script defines a Jenkins Shared Library step that performs a Docker login using a helper class.  
// Language/Platform: Groovy (Jenkins Shared Library)  
// What you'll learn: importing helper classes, defining `call()` for shared library steps, passing Jenkins pipeline context  
// Outcome: logs into Docker Hub (or other registry) from within a Jenkins pipeline using shared library logic  
// Why this matters: abstracts authentication logic for Docker into reusable, clean shared library functions  

// ------------------------------  
// 🧩 IMPORT HELPER CLASS  
// ------------------------------  
import com.example.Docker  
// ✅ What it does: imports the Docker helper class from the `com.example` package in the shared library  
// 🧠 Why it matters: allows this script to create Docker helper objects and access their methods like `dockerLogin()`  

// ------------------------------  
// 🧩 DEFINE CALLABLE STEP  
// ------------------------------  
def call() {  
    // ✅ What it does: defines a Groovy function named `call` without parameters  
    // 🧠 Why it matters: Jenkins Shared Libraries use `call()` to expose this file as a pipeline step (e.g., dockerLogin())  

    return new Docker(this).dockerLogin()  
    // ✅ What it does:  
    //   1️⃣ Creates a new instance of the Docker helper class, passing `this` (the pipeline script context)  
    //   2️⃣ Calls the helper method `dockerLogin()` which contains the logic for authenticating with Docker  
    // 🧠 Why it matters: centralizes Docker login logic for reusability across multiple Jenkins pipelines  
}  

// ------------------------------  
// ✅ NOTES / GOTCHAS / TIPS  
// ------------------------------  
// - `this` passes the pipeline script context, so helper methods can use Jenkins steps like `sh`, `withCredentials`, etc.  
// - Place this script in `vars/dockerLogin.groovy` to make it callable in pipelines as `dockerLogin()`  
// - Ensure the `Docker.groovy` helper class exists in `src/com/example/Docker.groovy` with a `dockerLogin()` method implemented.  
// - Example pipeline usage:  
//     dockerLogin()  // Logs into Docker registry as part of CI/CD flow  
