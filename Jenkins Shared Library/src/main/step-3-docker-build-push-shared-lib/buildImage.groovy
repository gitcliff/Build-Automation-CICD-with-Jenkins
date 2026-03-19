// 📦 SUMMARY  
// This code builds: A Jenkins shared library function to build, login, and push a Docker image to Docker Hub.  
// Language/Platform: Jenkins Pipeline (Groovy)  
// What you'll learn: Using Docker commands in Jenkins, handling credentials securely, and automating Docker image deployment.  
// Outcome: When executed, this function builds a Docker image, authenticates to Docker Hub using stored credentials, and pushes the image to a Docker Hub repository.  
// Why this matters: Automates container image builds and deployments in CI/CD pipelines, ensuring secure and consistent delivery of Docker images.  

// ------------------------------  
// 🧩 FUNCTION DEFINITION: call()  
// ------------------------------  
def call() {                                         // ✅ What it does: Defines a reusable Jenkins Pipeline function named `call`.  
                                                    // 🧠 Why it matters: Allows this Docker build-and-push logic to be reused across multiple pipelines.

    echo '🔧 Building the Docker Image'               // ✅ What it does: Prints a log message indicating the start of the Docker image build.  
                                                    // 🧠 Why it matters: Provides clear feedback in Jenkins console logs about pipeline progress.

    withCredentials([                                 // ✅ What it does: Securely injects Docker Hub credentials into the pipeline environment.  
        usernamePassword(                             // 🧠 Why it matters: Avoids hardcoding passwords, keeping credentials safe using Jenkins Credential Store.  
            credentialsId: 'Docker-hub-credentials', // ✅ What it does: References stored credentials by ID (replace with your Jenkins credential ID).  
            passwordVariable: 'PASS',                 // ✅ What it does: Exposes the password as environment variable `PASS`.  
            usernameVariable: 'USER'                  // ✅ What it does: Exposes the username as environment variable `USER`.  
        )  
    ]) {  

        sh 'docker build -t your-dockerhub-username/demo-app:jma-3.4 .'  
                                                    // ✅ What it does: Builds a Docker image with the specified tag from the current directory.  
                                                    // 🧠 Why it matters: Packages the application into a container image ready for deployment.  

        sh 'echo $PASS | docker login -u $USER --password-stdin'  
                                                    // ✅ What it does: Logs into Docker Hub securely using username and password piped into `docker login`.  
                                                    // 🧠 Why it matters: Enables authenticated Docker operations without exposing the password in logs.  

        sh 'docker push your-dockerhub-username/demo-app:jma-3.4'  
                                                    // ✅ What it does: Pushes the tagged Docker image to Docker Hub repository.  
                                                    // 🧠 Why it matters: Publishes the container image for use in deployments or sharing.  

    }  
}  

// ------------------------------  
// ▶️ HOW TO RUN / EXECUTE THIS CODE  
// ------------------------------  
// call()                                             // ✅ What it does: Invokes this function inside a Jenkins pipeline to build and push the Docker image.  
                                                    // 🧠 Why it matters: Automates container build and deployment as part of CI/CD.  

// 🔄 Equivalent Bash/Linux command breakdown:  
// - `docker build -t your-dockerhub-username/demo-app:jma-3.2 .`  
//   Builds the Docker image locally using the Dockerfile in the current directory.  
// - `echo $PASS | docker login -u $USER --password-stdin`  
//   Logs into Docker Hub using credentials passed securely via stdin.  
// - `docker push your-dockerhub-username/demo-app:jma-3.2`  
//   Pushes the built image to the Docker Hub repository.  

// 🔄 Equivalent PowerShell command breakdown:  
// - `docker build -t your-dockerhub-username/demo-app:jma-3.2 .`  
//   Same Docker build command in PowerShell.  
// - `$env:PASS | docker login -u $env:USER --password-stdin`  
//   Pipes the password environment variable into Docker login securely.  
// - `docker push your-dockerhub-username/demo-app:jma-3.2`  
//   Pushes the image to Docker Hub.  

// ------------------------------  
// ✅ NOTES / GOTCHAS / TIPS  
// ------------------------------  
// - Replace `your-dockerhub-username` with your actual Docker Hub username or organization.  
// - Ensure Jenkins agent running this has Docker installed and user permissions to run Docker commands.  
// - Use Jenkins Credentials plugin to securely manage Docker Hub credentials; never hardcode passwords.  
// - The tag `jma-3.2` is hardcoded here; consider parameterizing it for flexibility across versions.  
// - `withCredentials` ensures sensitive info like passwords do not appear in build logs.  
