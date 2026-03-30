# 🚀 Build Automation & CI/CD with Jenkins

> A hands-on, step-by-step learning repository for mastering modern DevOps using **Jenkins**, **Docker**, **Maven**, and related tools. Covers the full lifecycle of building, testing, packaging, and deploying Java applications through CI/CD pipelines.

---

## 📚 Project Overview

This workspace is designed to help you:

- **Understand Jenkins fundamentals** and advanced pipeline concepts
- **Automate builds, tests, and deployments** for Java (Maven) projects
- **Integrate Docker** for containerized builds and deployments
- **Dynamically manage application versions** in CI/CD pipelines
- **Leverage Jenkins Shared Libraries** for modular, reusable pipeline code
- **Configure build tools** and Jenkins environments
- **Trigger pipelines automatically** using webhooks

> ℹ️ This is a **practical Jenkins lab collection**, not a single production application. Each folder is a standalone learning path with incremental complexity — great for both beginners and experienced DevOps engineers.

---

## 🗂️ Repository Structure

Each folder contains:
- `Jenkinsfile` / `JenkinsFile` — pipeline definitions
- `Dockerfile` — container-based build/deployment examples
- `pom.xml` — Maven build automation config
- `script.groovy` — shared pipeline logic
- Sample Java application source under `src/main/java`
- HTML/static resources under `src/main/resources/static`

---

## 📦 Module Guide

### 1. 🏗️ Create Complete Pipeline
End-to-end Jenkins declarative pipeline for a Java/Maven app with Docker integration and Groovy modularization.

| Step | Description |
|------|-------------|
| `step-1` | Basic pipeline setup — build and deploy |
| `step-2` | Add Docker build/push stages |
| `step-3` | Modularize pipeline logic with external Groovy scripts |
| `step-4` | Load and use `script.groovy` from Jenkinsfile |

---

### 2. 🐳 Docker in Jenkins
Integrate Docker with Jenkins for building and pushing images, including credential management.

| Step | Description |
|------|-------------|
| `step-1` | Jenkins Docker integration basics |
| `step-2` | Build Docker images from Maven JARs |
| `step-3` | Securely push images to Docker Hub |
| `step-4` | Push images to a Nexus repository |

---

### 3. 🔢 Dynamically Increment Application Version (Parts 1 & 2)
Automate version management in Maven projects within Jenkins pipelines.

- **Part 1:** Bump and increment versions, run Maven builds, automate CI/CD versioning
- **Part 2:** Integrate versioning with GitLab and automate full CI/CD workflows with repository-based version control

---

### 4. 🔧 Install Build Tools in Jenkins
Guided notes for configuring Jenkins to use Maven and Node.js — covering tool configuration and plugin installation techniques.

---

### 5. ⚙️ Install Jenkins
Practical Jenkins installation notes including Docker-based setup and how to access the admin password.

---

### 6. 🌿 Intro to Multibranch Pipeline
Learn about Jenkins multibranch pipelines — setup, configuration, and best practices for branch-driven builds.

---

### 7. 🎯 Jenkins Basics Demo — Freestyle Job
Demonstrates the traditional Jenkins freestyle job approach for building Java and Node.js projects. Ideal for understanding build steps before moving to pipeline-as-code.

---

### 8. 📚 Jenkins Shared Library
Advanced pipeline modularization. Create reusable shared library steps with Groovy including examples for building JARs, Docker images, and secure credential usage.

---

### 9. 📝 Jenkinsfile Syntax
Reference examples for Jenkinsfile syntax and pipeline patterns including:
- Environment variables
- Parameterized stages
- Manual approvals
- External Groovy scripts

---

### 10. 🔔 Webhooks — Trigger Pipeline Jobs Automatically
Automate pipeline triggers using webhooks for seamless CI/CD integration with source control events. Includes branch stage configuration and webhook-driven multibranch pipelines.

---

## 🛠️ Prerequisites

| Tool | Notes |
|------|-------|
| [Jenkins](https://www.jenkins.io/) | Preferably running in Docker |
| [Docker](https://www.docker.com/) | Required for container-based steps |
| [Java JDK 8+](https://adoptopenjdk.net/) | Required for Maven builds |
| [Maven](https://maven.apache.org/) | Build automation |
| [Node.js](https://nodejs.org/) | Optional — for Node-related demos |

---

## 🎓 Recommended Learning Path

Follow this order for the best learning experience, from foundational to advanced:

```
1. Install Jenkins                  →  Get Jenkins running
2. Install Build Tools in Jenkins   →  Configure Maven/Node tools
3. Jenkinsfile Syntax               →  Learn core pipeline patterns
4. Create Complete Pipeline         →  Follow an end-to-end example
5. Docker in Jenkins                →  Add containerization to pipelines
6. Intro to Multibranch Pipeline    →  Expand to branch-aware builds
7. Jenkins Shared Library           →  Build reusable pipeline code
8. Webhooks                         →  Automate pipeline triggers
```

> 💡 You can also jump directly to the topic most relevant to your needs — each folder is self-contained.

---

## 📖 How to Use This Repository

**1. Clone the repository:**
```sh
git clone https://github.com/gitcliff/Build-Automation-CICD-with-Jenkins.git
```

**2. Navigate to your starting point** based on your goal:

| Goal | Start here |
|------|------------|
| Complete pipeline example | `Create complete Pipeline/` |
| Container build & push workflows | `Docker in Jenkins/` |
| Reusable Groovy pipeline code | `Jenkins Shared Library/` |
| Declarative pipeline patterns | `Jenkinsfile Syntax/` |
| Automated versioning | `Dynamically Increment Application version/` |

**3. Follow the `README.md`** in each subfolder for step-by-step instructions.

**4. Explore the key files:**
- `Jenkinsfile` — inspect pipeline stage design
- `pom.xml` — understand Maven lifecycle and dependency management
- `script.groovy` — learn how Jenkins executes external Groovy code

---

## 🚀 Key Features & Learning Outcomes

- End-to-end CI/CD pipeline examples for Java (Maven) projects
- Docker integration for containerized builds and deployments
- Dynamic versioning and release automation
- Pipeline modularization with Groovy scripts and shared libraries
- Credential management for Docker registries
- Multibranch pipeline strategies
- Webhooks for automated triggers
- Stepwise, hands-on learning with incremental complexity

---

## 🤝 Contributing

Contributions, suggestions, and improvements are welcome! Ways to extend this repo:

- Add new Jenkinsfile examples for other CI/CD patterns
- Include Kubernetes or cloud deployment scenarios
- Add advanced pipeline tests and validation stages
- Improve documentation with diagrams and usage examples

Please open issues or submit pull requests via [GitHub Issues](https://github.com/gitcliff/Build-Automation-CICD-with-Jenkins/issues).

---

## 📄 License

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.

---

Happy building and automating with Jenkins! 🚀