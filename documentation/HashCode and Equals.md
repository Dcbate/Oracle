# 🎯 **Understanding `hashCode()` and `equals()` in Java** 🖥️

In Java, the `hashCode()` and `equals()` methods play a critical role when working with objects, especially in data structures like `HashMap`, `HashSet`, or any collection that relies on hashing. They ensure that objects are compared and stored efficiently. Let’s dive deeper into what these methods do and how to implement them correctly.

## 🧩 **What is `equals()`?**

The `equals()` method is used to **compare two objects** for equality. By default, this method checks if two references point to the same object (i.e., **reference equality**), but it can be overridden to check **value equality** instead.

### 🔹 **Syntax**:
- The `equals(Object obj)` method is overridden to compare objects for value equality.


```java
@Override
public boolean equals(Object obj) {
    // Custom comparison logic
}
```
### 📘 **Default Behavior**:
- By default, the `equals()` method in the `Object` class compares memory locations to check if two object references are the same.

```java

public boolean equals(Object obj) {
return this == obj;
}
```



### ✅ **Best Practices** for Overriding `equals()`:
1. **Reflexive**: An object must be equal to itself, i.e., `x.equals(x)` should return `true`.
2. **Symmetric**: If `x.equals(y)` returns `true`, then `y.equals(x)` must also return `true`.
3. **Transitive**: If `x.equals(y)` and `y.equals(z)`, then `x.equals(z)` should also return `true`.
4. **Consistent**: Multiple invocations of `x.equals(y)` should consistently return the same result.
5. **Non-nullity**: For any non-null object `x`, `x.equals(null)` should return `false`.

### 🔑 **Example**:
- A typical `equals()` method compares fields of the object to determine equality, like checking IDs or names of objects.

``` java
@Override
public boolean equals(Object obj) {
if (this == obj) return true;
if (obj == null || getClass() != obj.getClass()) return false;
MyObject that = (MyObject) obj;
return this.id == that.id && this.name.equals(that.name);
}
```



## 🧩 **What is `hashCode()`?**

The `hashCode()` method returns an **integer** that represents the object's memory address (by default) or can be overridden to provide a unique code based on the object's data. It’s used in hashing-based collections like `HashMap` or `HashSet` to efficiently locate objects.

### 🔹 **Syntax**:
- The `hashCode()` method can be overridden to provide custom hash codes based on the object's fields.

### 📘 **Default Behavior**:
- By default, `hashCode()` provides a unique identifier for an object based on its memory address.

```java
@Override
public int hashCode() {
// Custom hash code logic
}
```

### ✅ **Best Practices** for Overriding `hashCode()`:
1. If `x.equals(y)` is `true`, then `x.hashCode()` **must** equal `y.hashCode()`.
2. If `x.equals(y)` is `false`, it's not required that `x.hashCode()` and `y.hashCode()` be different, but different hash codes improve performance in hash-based collections.
3. Always override `hashCode()` when you override `equals()` to ensure consistent behavior.

### 🔑 **Example**:
- A typical `hashCode()` method generates an integer based on important fields of the object, ensuring objects with the same values produce the same hash code.

```java
@Override
public int hashCode() {
return Objects.hash(id, name);
}
```


### 🔄 **The Relationship Between `equals()` and `hashCode()`**:

- Objects that are considered equal using the `equals()` method **must** have the same hash code.
- However, objects with the same hash code are **not necessarily** equal.

### ⚠️ **Common Mistakes**:
1. Failing to override both `equals()` and `hashCode()` when checking for value equality.
2. Returning a constant value in `hashCode()` — this can severely degrade performance in hash-based collections.

---

## 🏁 **Conclusion** 🎉
- The `equals()` method ensures that two objects are logically equivalent based on their values.
- The `hashCode()` method ensures that objects are efficiently stored and retrieved in hash-based collections.

By overriding both methods properly, you guarantee that your objects behave as expected in collections like `HashMap` and `HashSet`. Always remember to follow the **contract** between `equals()` and `hashCode()` to avoid unexpected behavior in your Java applications. 🔐