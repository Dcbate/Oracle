# Cheat Sheet: Jackson (JSON Parsing) in Java

---

## **1️⃣ Add Dependencies**

### Gradle
```gradle
implementation 'com.fasterxml.jackson.core:jackson-databind:2.15.2'
```

---

## **2️⃣ Basic Usage**

### Define a Class
```java
public class Person {
    private String name;
    private int age;

    // Constructors, Getters, and Setters
    public Person() {}
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
}
```

---

### Serialize a Class
```java
import com.fasterxml.jackson.databind.ObjectMapper;

public class Main {
    public static void main(String[] args) throws Exception {
        ObjectMapper mapper = new ObjectMapper();

        // Serialize Object to JSON
        Person person = new Person("Alice", 25);
        String json = mapper.writeValueAsString(person);
        System.out.println(json); // {"name":"Alice","age":25}
    }
}
```

---

### Deserialize JSON to a Class
```java
// Deserialize JSON to Object
String json = "{"name":"Bob","age":30}";
Person person = mapper.readValue(json, Person.class);
System.out.println(person.getName()); // Bob
System.out.println(person.getAge());  // 30
```

---

## **3️⃣ JSON Annotations**

### **1. Ignoring Fields with `@JsonIgnore`**
```java
import com.fasterxml.jackson.annotation.JsonIgnore;

public class Person {
    private String name;

    @JsonIgnore
    private int age;

    // Constructors, Getters, and Setters
}
```

- **Input JSON**: `{"name":"Alice","age":25}`
- **Serialized Output**: `{"name":"Alice"}`

**💡 Why?**  
Use `@JsonIgnore` to exclude sensitive or unnecessary fields from serialization/deserialization.

---

### **2. Renaming Fields with `@JsonProperty`**
```java
import com.fasterxml.jackson.annotation.JsonProperty;

public class Person {
    @JsonProperty("full_name")
    private String name;

    @JsonProperty("years_old")
    private int age;

    // Constructors, Getters, and Setters
}
```

- **Input JSON**: `{"full_name":"Alice","years_old":25}`
- **Serialized Output**: `{"full_name":"Alice","years_old":25}`

**💡 Why?**  
Use `@JsonProperty` to map Java fields to custom JSON property names.

---

## **4️⃣ Working with Collections**

### Convert JSON Array to List
```java
String jsonArray = "[{"name":"John","age":30},{"name":"Jane","age":25}]";
List<Person> people = mapper.readValue(jsonArray, new TypeReference<List<Person>>() {});
people.forEach(person -> System.out.println(person.getName())); // John, Jane
```

### Convert List to JSON Array
```java
List<Person> people = Arrays.asList(new Person("John", 30), new Person("Jane", 25));
String jsonArray = mapper.writeValueAsString(people);
System.out.println(jsonArray); // [{"name":"John","age":30},{"name":"Jane","age":25}]
```

---

## **5️⃣ Quick Reference for JSON Annotations**

| **Annotation**       | **Description**                                          |
|-----------------------|----------------------------------------------------------|
| `@JsonIgnore`        | Excludes a field from serialization/deserialization.     |
| `@JsonProperty`      | Maps a field to a specific JSON property.                |
