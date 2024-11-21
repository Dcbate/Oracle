

# Starling Bank Interview Preparation Guide 🚀

---


## Key Projects to Highlight

### **1. Migration to GCP** 🚀
#### **Challenge**:
- Migrating 20+ microservices from on-premise infrastructure to **Google Cloud Platform (GCP)** while ensuring zero downtime.

#### **Solution**:
- **Containerization**: Used **Docker** and orchestrated with **Kubernetes**.
- **Infrastructure Automation**: Leveraged **Terraform** for consistent and repeatable deployments.
- **Monitoring**: Set up **Grafana** for real-time insights and alerting.

#### **Outcome**:
- Reduced deployment time by **40%** and improved scalability.
- Seamless transition with no disruption to customers.

#### **Key Points**:
- Focus on Kubernetes and GCP expertise, aligning with Starling's tech stack.
- Highlight customer-centric approach and operational excellence.

---

### **2. Production Support Rota and Documentation** 📚
#### **Challenge**:
- Inefficient handling of production incidents due to lack of documentation and process clarity.

#### **Solution**:
- Created a **standardized template** for documenting incidents.
- Implemented a **rotating support schedule** with defined escalation procedures.
- Automated alerting using **Grafana** and **Kubernetes** health checks.

#### **Outcome**:
- Reduced incident resolution time by **25%**.
- Improved onboarding and knowledge-sharing within the team.

#### **Key Points**:
- Show ownership and ability to streamline processes.
- Emphasize collaborative problem-solving.

---

### **3. New Service: Composite API with Hazelcast Cache and Reactive Programming** 🧩
#### **Challenge**:
- Build a composite API service to collect large volumes of data, process it into a cache, and serve transformed results efficiently.

#### **Solution**:
- Implemented **Hazelcast Cache** for distributed caching to handle high-throughput requests.
- Introduced **Reactive Programming** using **Project Reactor** for non-blocking data pipelines.
- Aggregated data from multiple APIs into the cache and applied transformations before serving results.

#### **Example Code**:
```java
@Service
public class CompositeApiService {

    private final HazelcastInstance hazelcastInstance;

    public CompositeApiService(HazelcastInstance hazelcastInstance) {
        this.hazelcastInstance = hazelcastInstance;
    }

    public Mono<Data> getCompositeData(String key) {
        return Mono.fromCallable(() -> hazelcastInstance.getMap("cache").get(key))
                .switchIfEmpty(fetchAndCacheData(key));
    }

    private Mono<Data> fetchAndCacheData(String key) {
        return fetchDataFromApis(key)
                .flatMap(data -> {
                    hazelcastInstance.getMap("cache").put(key, data);
                    return Mono.just(data);
                });
    }

    private Mono<Data> fetchDataFromApis(String key) {
        // Simulate data fetching and transformation
        return Mono.just(new Data(key, "Transformed Data"));
    }
}
```

#### **Outcome**:
- Improved response times by **50%** due to caching.
- Handled **high request volumes** efficiently with non-blocking I/O.

#### **Key Points**:
- Focus on scalability, performance optimization, and cutting-edge technologies.

---

## Behavioral Questions Using STAR Framework

### **Example 1: Ownership**
**S**: Faced repeated production incidents without clear processes.
**T**: Standardize incident handling and improve team efficiency.
**A**: Designed templates, trained team members, and introduced Grafana alerts.
**R**: Reduced incident resolution time by **25%** and improved response consistency.

### **Example 2: Simplicity**
**S**: A service had complex error-handling logic causing frequent bugs.
**T**: Simplify the logic for better maintainability.
**A**: Refactored error-handling into smaller, reusable methods.
**R**: Reduced defects by **15%** and enhanced code readability.

---

## Questions to Ask Starling Bank
1. How have you found the dev led teams ? Have you always have this approach ?
1. _What does success look like for this role in the first six months?_
2. _How does Starling foster collaboration between teams when scaling microservices?_
3. _What challenges does the engineering team face with rapid deployment cycles (15-20 per day)?_

---


## Final Tips
- Stay calm and composed; take time to think through answers.
- Focus on aligning your past experiences with Starling's **values**:
    - Listen, Keep It Simple, Do The Right Thing, Own It, Aim For Greatness.
- Be authentic: Share real successes and lessons learned from failures.

