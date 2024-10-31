# Spring Data JPA Query Method Cheatsheet

Spring Data JPA allows you to create queries using method names based on the entity field names. These method names automatically translate to SQL queries, providing a convenient and readable way to query your database.

---

## 1. **Basic Queries**

- **`findByName(String name)`**
    - **Description:** This query method retrieves all entities where the `name` field matches the provided string exactly. This is case-sensitive.
    - **Generated SQL:**
      ```sql
      SELECT * FROM entity_table WHERE name = 'provided_name';
      ```
    - **Example:** If you search for `findByName("Alice")`, it will only return entries where the `name` is exactly "Alice".

- **`findByNameIgnoreCase(String name)`**
    - **Description:** Similar to `findByName`, but it ignores case sensitivity. It will return results regardless of whether the `name` is uppercase, lowercase, or a combination.
    - **Generated SQL:**
      ```sql
      SELECT * FROM entity_table WHERE LOWER(name) = LOWER('provided_name');
      ```
    - **Example:** `findByNameIgnoreCase("Alice")` will return "alice", "ALICE", or "AlIcE".

---

## 2. **Comparison Operators**

- **`findByAgeGreaterThan(int age)`**
    - **Description:** Retrieves all entities where the `age` field is greater than the provided value.
    - **Generated SQL:**
      ```sql
      SELECT * FROM entity_table WHERE age > provided_age;
      ```

- **`findByAgeLessThan(int age)`**
    - **Description:** Retrieves all entities where the `age` field is less than the provided value.
    - **Generated SQL:**
      ```sql
      SELECT * FROM entity_table WHERE age < provided_age;
      ```

- **`findBySalaryBetween(int minSalary, int maxSalary)`**
    - **Description:** Retrieves all entities where the `salary` is between the specified minimum and maximum values.
    - **Generated SQL:**
      ```sql
      SELECT * FROM entity_table WHERE salary BETWEEN provided_minSalary AND provided_maxSalary;
      ```

---

## 3. **Logical Operators**

- **`findByFirstNameAndLastName(String firstName, String lastName)`**
    - **Description:** This query will return entities where both the `firstName` and `lastName` fields match the provided values.
    - **Generated SQL:**
      ```sql
      SELECT * FROM entity_table WHERE first_name = 'provided_firstName' AND last_name = 'provided_lastName';
      ```

- **`findByFirstNameOrLastName(String firstName, String lastName)`**
    - **Description:** This query returns entities where either the `firstName` or `lastName` field matches the provided values.
    - **Generated SQL:**
      ```sql
      SELECT * FROM entity_table WHERE first_name = 'provided_firstName' OR last_name = 'provided_lastName';
      ```

---

## 4. **Null Checks**

- **`findByEmailIsNull()`**
    - **Description:** Retrieves entities where the `email` field is `null`.
    - **Generated SQL:**
      ```sql
      SELECT * FROM entity_table WHERE email IS NULL;
      ```

- **`findByEmailIsNotNull()`**
    - **Description:** Retrieves entities where the `email` field is **not** `null`.
    - **Generated SQL:**
      ```sql
      SELECT * FROM entity_table WHERE email IS NOT NULL;
      ```

---

## 5. **Like and Containment**

- **`findByUsernameLike(String usernamePattern)`**
    - **Description:** This query method uses SQL-like pattern matching to search for entities where the `username` matches the provided pattern. Use `%` as a wildcard.
    - **Generated SQL:**
      ```sql
      SELECT * FROM entity_table WHERE username LIKE 'provided_pattern';
      ```

- **`findByUsernameContaining(String substring)`**
    - **Description:** This retrieves entities where the `username` contains the specified substring.
    - **Generated SQL:**
      ```sql
      SELECT * FROM entity_table WHERE username LIKE '%provided_substring%';
      ```

- **`findByUsernameStartsWith(String prefix)`**
    - **Description:** Retrieves entities where the `username` starts with the provided prefix.
    - **Generated SQL:**
      ```sql
      SELECT * FROM entity_table WHERE username LIKE 'provided_prefix%';
      ```

- **`findByUsernameEndsWith(String suffix)`**
    - **Description:** Retrieves entities where the `username` ends with the provided suffix.
    - **Generated SQL:**
      ```sql
      SELECT * FROM entity_table WHERE username LIKE '%provided_suffix';
      ```

---

## 6. **Order and Pagination**

- **`findByAgeOrderByLastNameAsc(int age)`**
    - **Description:** Retrieves entities where the `age` matches the provided value and orders the result by `lastName` in ascending order.
    - **Generated SQL:**
      ```sql
      SELECT * FROM entity_table WHERE age = provided_age ORDER BY last_name ASC;
      ```

- **`findByAgeOrderByLastNameDesc(int age)`**
    - **Description:** Similar to the above but sorts the result by `lastName` in descending order.
    - **Generated SQL:**
      ```sql
      SELECT * FROM entity_table WHERE age = provided_age ORDER BY last_name DESC;
      ```

---

## 7. **Distinct and Limiting Results**

- **`findDistinctByLastName(String lastName)`**
    - **Description:** This query returns distinct (unique) entities based on the `lastName`.
    - **Generated SQL:**
      ```sql
      SELECT DISTINCT last_name FROM entity_table WHERE last_name = 'provided_lastName';
      ```

- **`findTop3ByOrderByAgeDesc()`**
    - **Description:** This query limits the results to the top 3 entities, ordered by `age` in descending order.
    - **Generated SQL:**
      ```sql
      SELECT * FROM entity_table ORDER BY age DESC LIMIT 3;
      ```

---

## 8. **In Clause**

- **`findByIdIn(List<Long> ids)`**
    - **Description:** This query retrieves entities where the `id` is within the provided list of ids.
    - **Generated SQL:**
      ```sql
      SELECT * FROM entity_table WHERE id IN (provided_id_list);
      ```

---

## 9. **Date and Time Queries**

- **`findByCreatedDateAfter(LocalDate date)`**
    - **Description:** Retrieves entities that were created after the specified date.
    - **Generated SQL:**
      ```sql
      SELECT * FROM entity_table WHERE created_date > 'provided_date';
      ```

- **`findByCreatedDateBefore(LocalDate date)`**
    - **Description:** Retrieves entities that were created before the specified date.
    - **Generated SQL:**
      ```sql
      SELECT * FROM entity_table WHERE created_date < 'provided_date';
      ```

---
