// 📦 SUMMARY  
// This code builds: A simple Jenkins shared library function that builds a Java application using Maven.  
// Language/Platform: Jenkins Pipeline (Groovy)  
// What you'll learn: How to define a reusable pipeline function, use environment variables, and run shell commands in Jenkins.  
// Outcome: Prints the branch name being built and runs `mvn package` to compile and package the Java project.  
// Why this matters: Modularizes build logic so it can be reused in multiple Jenkins pipelines, improving maintainability and clarity.

// ------------------------------  
// 🧩 FUNCTION DEFINITION: call()  
// ------------------------------  
def call() {                                    // ✅ What it does: Defines a function named `call` to be used in Jenkins pipelines or shared libraries.  
                                                // 🧠 Why it matters: This standard function name allows Jenkins to invoke this build logic easily.

  echo "building the application for branch $GIT_BRANCH"  
                                                // ✅ What it does: Prints the current Git branch name to Jenkins console output.  
                                                // 🧠 Why it matters: Gives visibility into which branch the build is running for troubleshooting and auditing.

  sh 'mvn package'                              // ✅ What it does: Runs the Maven `package` goal in a shell environment on the Jenkins agent.  
                                                // 🧠 Why it matters: Compiles the Java source code and packages it into a distributable format (e.g., a jar file).  
}  

// ------------------------------  
// ▶️ HOW TO RUN / EXECUTE THIS CODE  
// ------------------------------  
// call()                                        // ✅ What it does: Call this function inside a Jenkins pipeline script or shared library to run the build.  
                                                // 🧠 Why it matters: Triggers the Maven build process with branch info displayed in the logs.

// 🔄 Equivalent Linux/bash explanation:  
// Runs the command `mvn package` in the shell, which compiles and packages your Java app.

// 🔄 Equivalent PowerShell explanation:  
// Runs `mvn package` in PowerShell, performing the same Maven build step.

// ------------------------------  
// ✅ NOTES / GOTCHAS / TIPS  
// ------------------------------  
// - Make sure the Jenkins agent has Maven installed and configured correctly in the PATH.  
// - `$GIT_BRANCH` is typically set by Jenkins when using SCM plugins like Git. If not set, consider passing branch name as a parameter.  
// - Using `sh` executes commands in a shell environment; Windows agents might require different handling or tools like PowerShell.
