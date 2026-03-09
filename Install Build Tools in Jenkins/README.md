#    Install Build Tools in Jenkins


# 📖 Summary

Worked on **Lab - Install Build Tools in Jenkins** (branch: *feature/Install-Build-Tools-Jenkins*), focusing on **enhancing Jenkins with essential build tools and plugins**.
Tasks included **configuring Maven, installing Node.js & npm inside Jenkins Docker container, and setting up the Stage View plugin** to solve **the challenge of supporting both Java and JavaScript build pipelines in a containerized Jenkins setup**.
Set up **toolchains and plugins** within Jenkins to enable diverse CI/CD workflows covering backend and frontend projects.

---

# 🛠️ Tools Used

* **Jenkins Global Tool Configuration**: ✨ *Added Maven 3.9 for Java project builds*
* **Dockerized Jenkins Server**: ⚙️ *Installed Node.js and npm inside the Jenkins container for frontend builds*
* **Stage View Jenkins Plugin**: 🚀 *Enhanced pipeline UI visualization for better stage monitoring*

---

# 🎯 Skills Gained

* **Jenkins Toolchain Management**: 💡 *Learned to configure global tools like Maven for use in pipelines*
* **Container-Level Package Management**: 🔍 *Installed Node.js and npm directly inside the Jenkins container for project flexibility*
* **Plugin Management and UI Enhancements**: 🚀 *Used Jenkins plugin manager to add Stage View for pipeline stage visualization*

---

# ⚠️ Challenges Faced

* **Installing Node.js in a Minimal Jenkins Container**: 🛠️ *Resolved by adding NodeSource repo and using apt inside container as root*
* **Jenkins Container Stopped Unexpectedly**: 🔄 *Restarted the container and ensured persistence of installed tools and plugins*

---

# 💡 Why It Matters

This lab builds expertise in **extending Jenkins for multi-language CI/CD support**, demonstrating how tools like Maven and Node.js integrate into a containerized Jenkins setup.
Mastering these configurations allows developers and DevOps engineers to handle complex pipelines involving both Java and JavaScript projects while leveraging Jenkins' powerful visualization plugins. 🚀🌐

---
