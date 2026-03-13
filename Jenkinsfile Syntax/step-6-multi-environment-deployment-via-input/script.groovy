// 📦 SUMMARY  
// This code builds: A Groovy helper script for Jenkins with three functions—`buildApp`, `testApp`, and `deployApp`. These functions are designed to be called from a Jenkinsfile to build, test, and deploy an application dynamically.  
// Language/Platform: Groovy (for Jenkins Pipelines)  
// What you'll learn: Creating reusable functions, using `params.VERSION` from Jenkins parameters, and returning `this` for script reusability.  
// Outcome: When loaded in a Jenkinsfile, it provides utility functions to build, test, and deploy the app, using pipeline parameters.  
// Why this matters: Keeps Jenkinsfiles clean by moving logic into helper scripts, enabling DRY (Don’t Repeat Yourself) practices in CI/CD workflows.  

// ------------------------------  
// 🧩 SECTION TITLE: Build Function  
// ------------------------------  
def buildApp() {                            // ✅ What it does: Defines a function called buildApp() with no parameters.  
                                           // 🧠 Why it matters: Provides a reusable step for building the application.  

    echo "Building application..."           // ✅ What it does: Logs a generic build message.  
                                           // 🧠 Why it matters: Helps identify in Jenkins logs when the build step begins.  

    echo "Building version ${params.VERSION}" // ✅ What it does: Logs the version of the app being built using pipeline parameter VERSION.  
                                           // 🧠 Why it matters: Shows which version is being processed—critical for tracking builds in multi-version pipelines.  
}

// ------------------------------  
// 🧩 SECTION TITLE: Test Function  
// ------------------------------  
def testApp() {                             // ✅ What it does: Defines a function called testApp() to run tests.  
                                           // 🧠 Why it matters: Provides a reusable step for executing tests in the pipeline.  

    echo "Running tests..."                  // ✅ What it does: Logs a simple message indicating test execution.  
                                           // 🧠 Why it matters: Acts as a placeholder—replace with real test commands in a real pipeline.  
}

// ------------------------------  
// 🧩 SECTION TITLE: Deploy Function  
// ------------------------------  
def deployApp(env) {                        // ✅ What it does: Defines a deployApp() function that accepts a target environment (env) as a parameter.  
                                           // 🧠 Why it matters: Lets the pipeline deploy dynamically to `dev`, `staging`, or `prod` based on user input.  

    echo "Deploying to ${env} environment..." // ✅ What it does: Logs the target deployment environment.  
                                           // 🧠 Why it matters: Provides clear feedback in Jenkins logs about where the app is being deployed.  

    echo "Deploying version ${params.VERSION}" // ✅ What it does: Logs the version being deployed, using the pipeline parameter VERSION.  
                                           // 🧠 Why it matters: Ensures teams know exactly which version is going live.  
}

// ------------------------------  
// 🔄 RETURN SCRIPT CONTEXT  
// ------------------------------  
return this                                 // ✅ What it does: Returns the current script context so all defined functions are accessible in Jenkins when loaded with `load`.  
                                           // 🧠 Why it matters: Required for reusability—without this, Jenkins won't recognize the helper functions.  
