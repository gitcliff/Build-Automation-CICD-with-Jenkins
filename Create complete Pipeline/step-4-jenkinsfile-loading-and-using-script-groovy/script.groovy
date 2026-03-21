// 📦 SUMMARY  
// This code builds: A Groovy script with reusable functions to build a Java JAR, build and push a Docker image, and deploy the application.  
// Language/Platform: Groovy script used within Jenkins pipeline  
// What you'll learn: Defining functions for modular pipeline steps, using Jenkins credentials securely in scripts, and structuring deployment logic.  
// Outcome: Functions can be loaded and called from Jenkins pipelines to perform build, Docker image creation, and deployment tasks.  
// Why this matters: Promotes code reuse and cleaner pipelines by separating logic into maintainable scripts.

def buildJar() {                            // ✅ Function to build the Java application JAR.  
  echo '🔧 Building the application...'     // ✅ Logs build start message.  
  sh 'mvn package'                          // ✅ Runs Maven package command to build the app.  
}

def buildImage() {                          // ✅ Function to build and push Docker image.  
  echo '🔧 Building the Docker Image'       // ✅ Logs Docker build start message.  
  withCredentials([usernamePassword(        // ✅ Securely injects Docker Hub credentials for authentication.  
    credentialsId: 'Docker-hub-credentials',  
    passwordVariable: 'PASS',  
    usernameVariable: 'USER'  
  )]) {  
    sh 'docker build -t gcliff/demo-app:jma-3.3 .'  // ✅ Builds Docker image with specified tag.  
    sh 'echo $PASS | docker login -u $USER --password-stdin'     // ✅ Logs into Docker Hub securely using the credentials.  
    sh 'docker push gcliff/demo-app:jma-3.3'       // ✅ Pushes the Docker image to Docker Hub.  
  }  
}

def deploy() {                             // ✅ Function placeholder for deployment steps.  
  echo '🚀 Deploying the application...'    // ✅ Logs deployment message.  
  // Add deployment logic here               // 🧠 Placeholder to implement actual deployment commands.  
}

return this                                 // ✅ Returns the script’s namespace so functions can be accessed after loading this script.
