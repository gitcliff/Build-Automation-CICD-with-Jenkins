#  Docker in Jenkins


# 📖 Summary

Worked on **Lab Docker in Jenkins**, focusing on **integrating Docker with Jenkins to automate building, tagging, and pushing Docker images**.
Tasks included **setting up Jenkins with Docker access, building a containerized Java application from a Maven-built JAR, and pushing the resulting Docker images to both Docker Hub and a private Nexus repository**.
Configured **Jenkins Docker plugin, Docker daemon, and authentication for Docker Hub and Nexus** to automate CI/CD pipelines for containerized apps, ensuring consistent and portable deployments across environments.

---

# 🛠️ Tools Used

* **Jenkins**: ✨ *Configured with Docker socket access to orchestrate container builds and pushes*
* **Docker**: 🐳 *Built container images for Java apps, managed image tagging and registry pushes*
* **Docker Hub**: 🌐 *Hosted public Docker images for sharing and deployment*
* **Nexus Repository**: 🗃 *Hosted private Docker registry for secure internal image storage*

---

# 🎯 Skills Gained

* **Docker Integration with Jenkins**: 💡 *Learned to enable Docker commands inside Jenkins containers by mounting Docker socket and installing Docker*
* **Containerizing Java Applications**: 🔍 *Created Dockerfiles to package Maven-built JARs into runnable Docker images*
* **Docker Registry Management**: 🚀 *Pushed images securely to both public Docker Hub and private Nexus repositories, managing credentials and insecure registries*

---

# ⚠️ Challenges Faced

* **Granting Jenkins Proper Docker Socket Permissions**: 🛠️ *Resolved by adjusting socket permissions (`chmod 666`) inside Jenkins container to enable Docker commands*
* **Configuring Nexus as an Insecure Docker Registry**: 🔄 *Added Nexus IP to Docker daemon’s insecure registries and restarted Docker daemon for smooth pushes*

---

# 💡 Why It Matters

This lab deepens DevOps expertise by demonstrating how to incorporate containerization into CI/CD pipelines.
Integrating Docker with Jenkins enables automated, environment-consistent builds and deployments, while pushing images to Docker Hub and Nexus ensures accessibility and security of artifacts in public and private registries.
Mastering these skills is essential for modern cloud-native DevOps workflows and container-based application delivery. 🚀🐳

---