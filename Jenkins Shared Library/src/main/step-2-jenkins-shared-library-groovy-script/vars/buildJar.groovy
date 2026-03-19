// 📦 SUMMARY  
// This code builds: A simple Jenkins Pipeline shared library function to build a Java application using Maven.  
// Language/Platform: Jenkins Pipeline (Groovy)  
// What you'll learn: Defining reusable pipeline functions, printing messages, and running shell commands.  
// Outcome: When called, this function logs the branch being built and executes a Maven package command to build the app.  
// Why this matters: Helps modularize Jenkins pipelines by encapsulating build logic for reuse across multiple pipelines or branches.  

// ------------------------------  
// 🧩 FUNCTION DEFINITION: call()  
// ------------------------------  
def call() {                              // ✅ What it does: Defines a Groovy function named `call` that Jenkins can invoke.  
                                         // 🧠 Why it matters: This makes the build logic reusable in Jenkins shared libraries or scripted pipelines.

    echo "building the application for branch $GIT_BRANCH"  
                                         // ✅ What it does: Prints a message showing which Git branch is currently being built.  
                                         // 🧠 Why it matters: Provides clear feedback in the Jenkins console log about the build context.

    sh 'mvn package'                      // ✅ What it does: Runs the shell command to build the Java project using Maven's package lifecycle phase.  
                                         // 🧠 Why it matters: Executes the actual build process, creating compiled binaries and packages.  

}  
 
// ------------------------------  
// ▶️ HOW TO RUN / EXECUTE THIS CODE  
// ------------------------------  
// call()                                // ✅ What it does: Invokes this function from a Jenkins pipeline script or shared library.  
                                        // 🧠 Why it matters: Executes the build steps defined above.  

// 🔄 Equivalent Bash/Linux explanation:  
// Running `sh 'mvn package'` calls Maven’s package goal to compile and package your Java app in a Linux shell inside Jenkins.  

// 🔄 Equivalent PowerShell explanation:  
// PowerShell equivalent command: `mvn package`  
// This runs Maven’s package lifecycle phase to build your Java project, just like in Bash.  

// ------------------------------  
// ✅ NOTES / GOTCHAS / TIPS  
// ------------------------------  
// - Ensure the Jenkins agent has Maven installed and configured in PATH for `mvn` to run successfully.  
// - `$GIT_BRANCH` is a Jenkins environment variable automatically set when the pipeline runs with SCM integration.  
// - Use this function inside a pipeline script or shared library for modular and clean pipeline design.  
// - If `$GIT_BRANCH` is not set, consider passing it as a parameter for more control.  
