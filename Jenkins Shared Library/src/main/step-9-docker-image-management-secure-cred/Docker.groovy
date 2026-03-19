// 📦 SUMMARY  
// This code builds: A Jenkins shared library Groovy class `Docker` with reusable methods to build a Docker image, login to Docker Hub, and push images separately.  
// Language/Platform: Jenkins Pipeline (Groovy) with Shared Library class structure  
// What you'll learn: Organizing Docker operations into modular methods, using secure credentials with Jenkins pipeline, and calling shell commands via pipeline context.  
// Outcome: Provides methods to build a Docker image, login once, and push an image separately, enabling flexible Docker workflows in Jenkins pipelines.  
// Why this matters: Splitting login and push allows more control in pipelines (e.g., login once, push multiple images), improving modularity and reuse.

// ------------------------------  
// 🧩 DOCKER CLASS DEFINITION (com.example.Docker)  
// ------------------------------  
package com.example                        // ✅ Defines package namespace for modularity and code organization.

class Docker implements Serializable {    // ✅ Defines a serializable class to enable Jenkins pipeline compatibility.

  def script                            // ✅ Holds pipeline script context, enabling access to pipeline steps like `echo`, `sh`, and `withCredentials`.

  Docker(script) {                      // ✅ Constructor assigns the pipeline script context for method usage.
    this.script = script
  }

  def buildDockerImage(String imageName) {  
    script.echo "🔧 Building Docker image..."                         // ✅ Logs the start of the build process.

    script.withCredentials([                                           // ✅ Securely loads Docker Hub credentials from Jenkins.
      script.usernamePassword(                                       
        credentialsId: "docker-hub-credentials",                     // Jenkins credential ID to use for Docker Hub login.
        passwordVariable: 'PASS',                                    // Password environment variable.
        usernameVariable: 'USER'                                     // Username environment variable.
      )  
    ]) {  
      script.sh "docker build -t ${imageName} ."                    // ✅ Builds the Docker image locally with the given name.

      script.sh "echo \$PASS | docker login -u \$USER --password-stdin"  // ✅ Logs into Docker Hub securely using credentials.

      script.sh "docker push ${imageName}"                            // ✅ Pushes the built image to Docker Hub.
    }  
  }

  def dockerLogin() {  
    script.withCredentials([                                           // ✅ Secure login method separated for reusability.
      script.usernamePassword(
        credentialsId: "docker-hub-credentials",
        passwordVariable: 'PASS',
        usernameVariable: 'USER'
      )  
    ]) {
      script.sh "echo \$PASS | docker login -u \$USER --password-stdin"  // ✅ Runs Docker Hub login securely.
    }
  }

  def dockerPush(String imageName) {  
    script.sh "docker push $imageName"                               // ✅ Pushes an already built Docker image by name.
  }
}

// ------------------------------  
// ▶️ HOW TO RUN / EXECUTE THIS CODE  
// ------------------------------  
// In a Jenkins shared library pipeline script:  
// def docker = new com.example.Docker(this)                           // Instantiate Docker class with pipeline script context.  
// docker.buildDockerImage('your-docker-user/app:tag')                 // Build, login, and push image in one call.  
// docker.dockerLogin()                                                // Or login separately once.  
// docker.dockerPush('your-docker-user/app:tag')                      // Push images separately after login or build.

// ------------------------------  
// ✅ NOTES / GOTCHAS / TIPS  
// ------------------------------  
// - Use `\$` in the shell commands to escape `$` so Jenkins doesn't interpolate environment variables prematurely.  
// - `withCredentials` securely injects secrets for commands without exposing them in logs.  
// - Splitting login and push allows advanced workflows, e.g., push multiple tags after one login.  
// - Jenkins agents must have Docker installed and properly configured.  
