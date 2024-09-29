# 🚢 Kubernetes (K8s)

Kubernetes, also known as **K8s**, is an open-source platform designed to automate the deployment, scaling, and management of containerized applications. Originally developed by Google, Kubernetes is now maintained by the Cloud Native Computing Foundation (CNCF). It allows you to run applications reliably and at scale while reducing manual tasks.

---

## 🌟 **Why Kubernetes?**

Kubernetes addresses several challenges related to deploying and managing applications:

- **Scaling:** It automatically adjusts the number of running application instances based on demand.
- **Resilience:** Kubernetes detects and replaces failed containers, ensuring that applications are highly available.
- **Automation:** It handles repetitive tasks like deployment, scaling, and monitoring.
- **Portability:** Kubernetes works across cloud providers, on-premise data centers, and even hybrid cloud setups, offering flexibility in infrastructure choices.

By orchestrating containers across clusters of machines, Kubernetes allows developers to focus more on building applications rather than managing infrastructure.

---

## 🧩 **Key Concepts in Kubernetes**

### 1. **Cluster**
A **cluster** is the core structure in Kubernetes, consisting of:

- **Master Node (Control Plane):** The central part of Kubernetes, which manages the cluster and orchestrates the applications running within it.
- **Worker Nodes:** These nodes are where the actual applications (packaged in containers) run.

### 2. **Nodes**
A **node** is a machine within the Kubernetes cluster. It can be a physical or virtual machine and is responsible for running application workloads.

### 3. **Pods**
A **pod** is the smallest deployable unit in Kubernetes. It can contain one or more containers that work closely together, sharing resources like networking and storage.

### 4. **Services**
A **service** is an abstraction that defines how pods are exposed to the network. Services enable applications to communicate with each other, balancing traffic between pods, and providing a stable endpoint even as pods are created or destroyed.

### 5. **Deployments**
A **deployment** defines the desired state of an application, including how many replicas should be running. Deployments also manage the rollout of updates to ensure zero downtime.

### 6. **Namespaces**
**Namespaces** allow you to divide your cluster resources among multiple environments, users, or teams. Each namespace can be seen as a virtual cluster, isolating resources such as applications, services, and configurations.

---

## ⚙️ **How Kubernetes Works**

### 1. **Containers**
Kubernetes uses containers to package applications. Containers bundle the application code, configurations, and dependencies, ensuring that the application runs consistently across different environments.

### 2. **Scheduling and Orchestration**
Kubernetes automatically assigns applications (pods) to different nodes based on available resources. The platform ensures that the right number of containers are running, where they are needed.

### 3. **Scaling**
Kubernetes scales applications based on demand. It can automatically increase or decrease the number of running instances to handle varying levels of traffic.

### 4. **Self-Healing**
If a pod or container fails, Kubernetes automatically restarts or replaces it, ensuring that your application remains available. This self-healing feature improves reliability and uptime.

---

## 🛠️ **Basic Kubernetes Commands**

To effectively manage a Kubernetes cluster, you'll interact with it using the `kubectl` command-line tool. Below are some basic Kubernetes commands, described in words:

### 1. **Check the Nodes in Your Cluster**
To view all the available worker nodes in your cluster, you can use a command that fetches a list of nodes. This helps you see the physical or virtual machines running your application containers.

```bash 
kubectl get nodes
```
This shows the nodes currently participating in the Kubernetes cluster.

### 2. **View Running Pods**
To list the running pods (which are the units containing your application containers), you can use a command that retrieves this information for the current namespace.


```bash 
kubectl get pods
```
This provides a list of all active pods within the default namespace of your cluster.

### 3. **Deploy an Application**
To deploy an application using Kubernetes, you create a configuration file (usually a `.yaml` file) that describes how the application should be run. The command tells Kubernetes to apply the configuration and deploy the application.

```bash 
kubectl apply -f <your-file.yaml>
```
This reads the YAML file and creates the necessary resources to deploy your application in the cluster.

### 4. **Scale an Application**
To increase or decrease the number of running instances (replicas) of your application, you can use a command that specifies how many replicas you want. This is important for scaling your application to handle more traffic or reducing resource usage.

```bash 
kubectl scale --replicas=<number> deployment/<your-deployment
```
 
This tells Kubernetes how many replicas you want running for a specific deployment.

### 5. **View Logs from a Pod**
To check the logs of a specific pod (useful for debugging or monitoring), you can use a command that retrieves the output from the pod's containers.


```bash 
kubectl logs <pod-name>
```

This shows the logs generated by the application inside the specified pod, helping you troubleshoot issues.

### 6. **Delete an Application**
To completely remove an application and all its resources (such as pods, services, and deployments) from the cluster, you can use a command that deletes the application described by a configuration file.


```bash 
kubectl delete -f <your-file.yaml>
```

This removes the resources defined in the YAML file from your cluster.

---

## 📦 **Kubernetes Architecture**

A Kubernetes cluster consists of two main components:

### 1. **Master Node (Control Plane)**
- **API Server:** The central access point for managing the Kubernetes cluster.
- **Scheduler:** Responsible for assigning pods to specific nodes based on resource availability.
- **Controller Manager:** Monitors the state of the cluster and ensures that the desired number of pods are running.
- **etcd:** A distributed key-value store that holds the entire cluster’s configuration and state.

### 2. **Worker Nodes**
- **Kubelet:** The component that ensures containers are running correctly on each node.
- **Kube-proxy:** Manages networking within the cluster, including load balancing.
- **Container Runtime:** The software that actually runs containers (e.g., Docker or containerd).

---

## 🛡️ **Security in Kubernetes**

Kubernetes includes several features to enhance security:

- **RBAC (Role-Based Access Control):** Defines permissions for users and services within the cluster, allowing administrators to control access based on roles.
- **Secrets:** Kubernetes allows you to store sensitive information like passwords and API tokens securely.
- **Network Policies:** Control the traffic between pods and external services, improving security by enforcing communication rules.

---

## 🚀 **Kubernetes Workflow Overview**

Here’s a simplified workflow of how Kubernetes is used in practice:

1. **Build a container:** Package your application with its dependencies in a container.
2. **Push the container:** Upload the container image to a container registry.
3. **Write configuration files:** Create YAML configuration files that define how your application should be deployed (such as the number of replicas, resources, and networking).
4. **Deploy the application:** Use Kubernetes to deploy your application across the cluster.
5. **Monitor and manage:** Kubernetes takes care of monitoring the application, automatically scaling it, and replacing failed instances.

---

## 🔄 **Kubernetes Ecosystem**

Kubernetes integrates with many tools to extend its functionality:

- **Helm:** A package manager for Kubernetes that simplifies the deployment of complex applications.
- **Prometheus:** A monitoring system that helps you observe your applications in real-time.
- **Istio:** A service mesh that adds advanced networking, security, and observability features.
- **Kustomize:** A tool that allows you to customize Kubernetes configuration files for different environments.

---


# 🛠 Kubernetes Workload Types

Kubernetes offers several workload types for running applications and tasks in containers. Each workload type serves a specific purpose, depending on your application's requirements.

## 🎯 Key Kubernetes Workload Types

### 1. **Deployment**
Manages stateless applications by maintaining the desired number of Pod replicas and providing rolling updates.

- **Use case**: Web services, APIs.
- **Features**: Rolling updates, self-healing, scaling.

---

### 2. **ReplicaSet**
Ensures a specified number of Pod replicas are running at all times. Typically used within Deployments.

- **Use case**: Maintaining Pod replicas.
- **Features**: Pod replication and replacement.

---

### 3. **StatefulSet**
Manages stateful applications that require stable identities and persistent storage.

- **Use case**: Databases, distributed systems.
- **Features**: Ordered deployments, stable network identities, persistent storage.

---

### 4. **DaemonSet**
Ensures a Pod runs on every (or selected) Node in the cluster.

- **Use case**: System-level processes like logging and monitoring.
- **Features**: Runs one Pod per Node.

---

### 5. **Job**
Runs a task to completion and terminates once successful.

- **Use case**: One-off batch processing tasks.
- **Features**: Runs tasks to completion, ensures success.

---

### 6. **CronJob**
Schedules Jobs to run periodically at specified intervals.

- **Use case**: Regularly scheduled tasks like backups or cleanups.
- **Features**: Cron-like scheduling for Jobs.

---

### 7. **Pod**
The basic Kubernetes object representing a single instance of a container. Typically managed by higher-level resources like Deployments.

- **Use case**: Single application instance or task.
- **Features**: Simplest workload type.

---

## 🧠 When to Use Which Workload Type

- **Deployment**: Use when managing stateless applications that require rolling updates, scaling, and high availability (e.g., web services, REST APIs).
  
- **StatefulSet**: Use when managing stateful applications that need stable network identities and persistent storage (e.g., databases, message brokers).

- **DaemonSet**: Use when running system-level services on all (or some) Nodes, like log collection or monitoring agents (e.g., Fluentd, Prometheus Node Exporter).

- **Job**: Use when you have short-lived tasks that need to run to completion (e.g., data processing, batch jobs).

- **CronJob**: Use when tasks need to run at regular intervals, like scheduled backups or recurring reports (e.g., daily data backup, weekly cleanup).

- **ReplicaSet**: Use if you need to manage a set of replicas but do not require the advanced features of a Deployment (rarely used directly).

- **Pod**: Use if you are running a single instance of a container, but it’s generally better to manage Pods via Deployments or Jobs.

---

## 🐳 **Where Docker Fits in Kubernetes**

Docker is a popular containerization platform, and it plays a crucial role in the Kubernetes ecosystem. To understand where Docker fits into Kubernetes, it's important to grasp the relationship between containers and orchestration.

### **Containers with Docker**
At its core, Docker is used to package applications and their dependencies into lightweight, standalone containers. These containers run consistently across any environment, whether it's your local machine or a cloud server.

In a typical Docker workflow:
1. **Build**: You create a Docker image, which contains your application code and dependencies.
2. **Run**: You launch the container based on the image, running the application in an isolated environment.
3. **Push**: You push the Docker image to a **Docker Registry** like Docker Hub or a private registry for storage and distribution.

### **Docker and Kubernetes: How They Work Together**

While Docker is responsible for creating and running containers, Kubernetes handles the orchestration of these containers at scale. Here's how they complement each other:

- **Kubernetes uses Docker**: Kubernetes can use Docker (or any container runtime) to run the containers. When you define a pod, Kubernetes interacts with Docker to pull the container image from a registry and run it on a node.

- **Kubernetes as the orchestrator**: While Docker manages individual containers, Kubernetes ensures that these containers run in the desired state across a cluster of machines. Kubernetes takes care of load balancing, scaling, and restarting failed containers, tasks that Docker alone does not handle efficiently.

### **Docker in Kubernetes Architecture**

- **Node Components**: On each worker node in a Kubernetes cluster, the **container runtime** (like Docker) is responsible for managing the containers. The **kubelet** on the node communicates with Docker to ensure the right containers are running in each pod.

- **Building and Pushing Images**: Docker is commonly used during the development process to create and test container images. These images are then pushed to a container registry, and Kubernetes uses them to deploy the application across the cluster.

### **Docker vs. Other Container Runtimes**
While Docker is the most widely known container runtime, Kubernetes supports other container runtimes like **containerd** and **CRI-O**. Kubernetes is designed to be container runtime-agnostic, meaning it can work with any container runtime that implements the Container Runtime Interface (CRI).

---

### **Summary: How Docker Fits into Kubernetes**

1. **Docker**: Creates and manages containers.
2. **Kubernetes**: Orchestrates and manages the lifecycle of these containers across a distributed cluster.

In short, Docker provides the containers, and Kubernetes manages them at scale. Kubernetes interacts with Docker (or another runtime) to deploy, scale, and manage containerized applications.

---

## 🌐 **Kubernetes in the Cloud**

Many cloud providers offer **managed Kubernetes services**, allowing you to deploy a Kubernetes cluster without managing the underlying infrastructure. Examples include:

- **Google Kubernetes Engine (GKE)**
- **Amazon Elastic Kubernetes Service (EKS)**
- **Azure Kubernetes Service (AKS)**

These services handle the control plane for you, making it easier to focus on deploying and managing applications.

---

## 🚀 **Conclusion**

Kubernetes is a powerful tool for automating the deployment and management of containerized applications. While it has a learning curve, understanding the core concepts such as clusters, pods, and services will help you take full advantage of its capabilities. With Kubernetes, you can ensure that your applications are scalable, resilient, and easy to manage in any environment.
