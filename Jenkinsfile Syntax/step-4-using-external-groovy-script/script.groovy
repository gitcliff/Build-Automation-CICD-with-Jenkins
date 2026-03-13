// ------------------------------
// 🧩 SECTION: Build Function
// ------------------------------
def buildApp() {
    echo "Building application..."  // Placeholder for actual build commands
    echo "Building version ${params.VERSION}"  // Prints selected version parameter
}

// ------------------------------
// 🧩 SECTION: Test Function
// ------------------------------
def testApp() {
    echo "Running tests..."  // Placeholder for test commands, e.g., mvn test
}

// ------------------------------
// 🧩 SECTION: Deploy Function
// ------------------------------
def deployApp() {
    echo "Deploying..."  // Inform about deployment start
    echo "Deploying version ${params.VERSION}"  // Print version being deployed
}

// ------------------------------
// ⚙️ SECTION: Return Script Context
// ------------------------------
return this  // Makes these functions accessible when loaded via Jenkins `load` step
