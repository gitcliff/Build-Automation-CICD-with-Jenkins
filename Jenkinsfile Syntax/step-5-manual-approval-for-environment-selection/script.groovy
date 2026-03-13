// 📦 SUMMARY  
// This code builds: A Groovy helper function for Jenkins that accepts an environment name (`dev`, `staging`, or `prod`) as an argument and prints a deployment message for that environment.  
// Language/Platform: Groovy (for Jenkins pipelines)  
// What you'll learn: Passing parameters to functions, using string interpolation in Groovy, returning `this` for script reuse.  
// Outcome: When called from a Jenkinsfile, it logs which environment is being deployed to.  
// Why this matters: Lets your deployment logic dynamically adapt based on user input or pipeline parameters—essential in multi-environment CI/CD workflows.  

// ------------------------------  
// 🧩 SECTION TITLE: Deploy Function  
// ------------------------------  
def deployApp(env) {                        // ✅ What it does: Declares a function called deployApp() that takes one parameter: env.  
                                           // 🧠 Why it matters: Makes the function reusable so you can deploy to different environments ('dev', 'staging', 'prod') by passing them in as arguments.  

  echo "Deploying to ${env} environment..."  // ✅ What it does: Logs a message showing which environment is being deployed to.  
                                           // 🧠 Why it matters: Confirms to the user/team in Jenkins console logs where the deployment is happening.  
                                           // 📌 Tip: Replace this placeholder echo with actual deployment logic (e.g., shell commands, API calls).  

  return this                                // ✅ What it does: Returns the script object so other functions in this file are accessible when loaded into Jenkins.  
                                           // 🧠 Why it matters: Required by Jenkins when using `load` to import external Groovy scripts.  
}
