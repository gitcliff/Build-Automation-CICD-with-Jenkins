// 📦 SUMMARY  
// This code builds: A Jenkins shared library function to build, login, and push a Docker image to Docker Hub using a parameterized image name.  
// Language/Platform: Jenkins Pipeline (Groovy)  
// What you'll learn: Passing parameters to pipeline functions, securely handling credentials, and automating Docker image workflows.  
// Outcome: Builds a Docker image with the given name, logs into Docker Hub securely, and pushes the image to the specified Docker repository.  
// Why this matters: Parameterizing the image name makes this function reusable for different Docker images, improving pipeline flexibility and security.

// ------------------------------  
// 🧩 FUNCTION DEFINITION: call(String imageName)  
// ------------------------------  
def call(String imageName) {                         // ✅ What it does: Defines a function that accepts a Docker image name as a parameter.  
                                                    // 🧠 Why it matters: Enables reuse of this function for different Docker images by passing different names.

  echo '🔧 Building the Docker Image'                 // ✅ What it does: Logs a message indicating the start of the Docker image build.  
                                                    // 🧠 Why it matters: Provides feedback in the Jenkins console for easier tracking.

  withCredentials([                                   // ✅ What it does: Securely injects Docker Hub credentials into the pipeline environment.  
      usernamePassword(                               // 🧠 Why it matters: Protects sensitive Docker Hub credentials by not exposing them in plain text.  
          credentialsId: 'docker-hub-repo',    // ✅ What it does: References stored Jenkins credentials by ID.  
          passwordVariable: 'PASS',                    // ✅ What it does: Stores password in environment variable `PASS`.  
          usernameVariable: 'USER'                     // ✅ What it does: Stores username in environment variable `USER`.  
      )  
  ]) {  

    sh "docker build -t $imageName ."                  // ✅ What it does: Builds the Docker image using the given name from the current directory.  
                                                      // 🧠 Why it matters: Packages the app as a Docker image ready for deployment or sharing.

    sh 'echo $PASS | docker login -u $USER --password-stdin'  
                                                      // ✅ What it does: Logs into Docker Hub securely using the credentials via stdin.  
                                                      // 🧠 Why it matters: Authenticates the pipeline to Docker Hub without exposing the password in logs.

    sh "docker push $imageName"                         // ✅ What it does: Pushes the built Docker image to the remote Docker Hub repository.  
                                                      // 🧠 Why it matters: Publishes the image for use by deployment systems or other developers.

  }  
}  

// ------------------------------  
// ▶️ HOW TO RUN / EXECUTE THIS CODE  
// ------------------------------  
// call('your-dockerhub-username/demo-app:jma-3.2')     // ✅ What it does: Calls the function with the full Docker image name and tag to build and push.  
                                                      // 🧠 Why it matters: Runs the Docker build and push steps for the specified image.

// 🔄 Equivalent Linux/bash breakdown:  
// - `docker build -t your-dockerhub-username/demo-app:jma-3.2 .` builds the image locally.  
// - `echo $PASS | docker login -u $USER --password-stdin` logs into Docker Hub securely.  
// - `docker push your-dockerhub-username/demo-app:jma-3.2` pushes the image to Docker Hub.

// 🔄 Equivalent PowerShell breakdown:  
// - `docker build -t your-dockerhub-username/demo-app:jma-3.2 .` same Docker build command.  
// - `$env:PASS | docker login -u $env:USER --password-stdin` securely logs in.  
// - `docker push your-dockerhub-username/demo-app:jma-3.2` pushes the image.

// ------------------------------  
// ✅ NOTES / GOTCHAS / TIPS  
// ------------------------------  
// - Replace `Docker-hub-credentials` with your Jenkins credential ID for Docker Hub.  
// - Ensure Jenkins agent has Docker installed and configured properly.  
// - Use parameterized image names to support building different images without code changes.  
// - Avoid printing sensitive info like passwords in logs by using `withCredentials`.
