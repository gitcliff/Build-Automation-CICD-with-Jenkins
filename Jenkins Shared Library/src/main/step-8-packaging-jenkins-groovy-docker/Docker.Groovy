// 📦 SUMMARY  
// This code defines a Groovy class for Jenkins pipelines to manage Docker operations. 
// It allows building Docker images, logging into DockerHub, and pushing images to a registry.  
// Language/Platform: Groovy (Jenkins Pipeline)  
// What you'll learn: Classes, methods, Docker commands in Jenkins, credentials handling, pipeline scripting.  
// Outcome: After running this code in a Jenkins pipeline, a Docker image can be built and pushed to DockerHub.  
// Why this matters: Automates Docker image management in CI/CD pipelines, reducing manual steps and errors.

// ------------------------------  
// 🧩 SECTION TITLE: Package and Class Definition  
// ------------------------------  
package com.example  // ✅ Declares the package this class belongs to  
// 🧠 Why it matters: Organizes code and avoids name conflicts, useful for larger projects

class Docker implements Serializable {  // ✅ Defines a class named Docker and makes it Serializable  
    // 🧠 Why it matters: Serializable allows Jenkins to save the class state across pipeline steps

// ------------------------------  
// 🧩 SECTION TITLE: Script Variable Initialization  
// ------------------------------  
    def script  // ✅ Declares a variable to hold the Jenkins pipeline script context  
    // 🧠 Why it matters: This allows the class to call pipeline steps like `echo`, `sh`, or `withCredentials`

    Docker(script) {  // ✅ Constructor method for the class, accepting the pipeline script context  
        this.script = script  // ✅ Assigns the passed script to the class variable  
        // 🧠 Why it matters: Enables class methods to access Jenkins pipeline commands
    }

// ------------------------------  
// 🧩 SECTION TITLE: Build Docker Image Method  
// ------------------------------  
    def buildDockerImage(String imageName) {  // ✅ Defines a method that builds a Docker image using the given name
        // 🧠 Why it matters: Automates Docker image creation within the Jenkins pipeline
        script.echo "building the docker image..."  // ✅ Prints a message to the Jenkins console
        // 🧠 Why it matters: Provides feedback in the pipeline log for transparency
        script.sh "docker build -t $imageName ."   // ✅ Executes shell command to build Docker image with tag
        // 🧠 Why it matters: Automates image build instead of manually typing commands
    }

// ------------------------------  
// 🧩 SECTION TITLE: Docker Login Method  
// ------------------------------  
    def dockerLogin() {  // ✅ Defines a method to log into DockerHub
        // 🧠 Why it matters: Required before pushing images to private Docker registries
        script.withCredentials([script.usernamePassword(
                credentialsId: 'dockerhub-credentials',  // ✅ Jenkins credential ID (no spaces)
                passwordVariable: 'PASS',
                usernameVariable: 'USER')]) {
            // ✅ Fetches stored Jenkins credentials securely
            // 🧠 Avoids exposing usernames/passwords in logs; integrates with Jenkins credential store
            script.sh "echo \$PASS | docker login -u \$USER --password-stdin"
            // ✅ Logs into DockerHub using the retrieved credentials
            // 🧠 Necessary for authenticated Docker operations; avoids hardcoding sensitive info
        }
    }

// ------------------------------  
// 🧩 SECTION TITLE: Docker Push Method  
// ------------------------------  
    def dockerPush(String imageName) {  // ✅ Defines a method to push a Docker image to a registry
        // 🧠 Why it matters: Automates deployment of built images to DockerHub or other registries
        script.sh "docker push $imageName"  // ✅ Executes shell command to push the image
        // 🧠 Why it matters: Ensures the built image is available in the remote registry for use
    }
}
