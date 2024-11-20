# Understanding `@Transactional` in Spring

## What is a Transaction?  

A **transaction** is a series of operations performed on a database that must either be completed fully or not at all. This ensures **data consistency** and **integrity**.  

For example:  
- Transferring money from one bank account to another requires **deducting money from one account** and **adding it to another**. Both operations must succeed, or neither should occur.

Key properties of a transaction:  
1. **Atomicity**: All steps must complete successfully or none will.
2. **Consistency**: The database must remain in a consistent state before and after the transaction.
3. **Isolation**: Transactions are isolated from each other to prevent conflicts.
4. **Durability**: Once a transaction is committed, the changes are permanent.

---

## What is `@Transactional`?  

`@Transactional` is a Spring annotation used to manage database transactions. It tells Spring that the methods or classes it is applied to should be executed within a transactional context.  

When a method is annotated with `@Transactional`, Spring:  
1. **Starts a transaction** when the method is called.  
2. **Executes the method** and any associated database operations.  
3. **Commits** the transaction if the method completes successfully.  
4. **Rolls back** the transaction if an exception occurs.

---

## How to Use `@Transactional`

### 1. **Method-Level Transaction Management**
You can apply `@Transactional` to individual methods.  

```java
@Service
public class BankService {

    @Transactional
    public void transferMoney(Long fromAccountId, Long toAccountId, Double amount) {
        accountRepository.debit(fromAccountId, amount);
        accountRepository.credit(toAccountId, amount);
    }
}
```

### What Happens Here:  
- **Transaction Start**: When `transferMoney` is called, a transaction begins.  
- **Database Operations**: The `debit` and `credit` methods execute within the same transaction.  
- **Commit or Rollback**: If both methods succeed, the transaction commits. If any exception occurs (e.g., insufficient balance), the transaction rolls back.

---

### 2. **Class-Level Transaction Management**
You can apply `@Transactional` to an entire class.  

```java
@Service
@Transactional
public class OrderService {

    public void createOrder(Order order) {
        orderRepository.save(order);
    }

    public void updateOrder(Order order) {
        orderRepository.update(order);
    }
}
```

### What Happens Here:  
- All methods in `OrderService` are transactional by default.
- If `createOrder` or `updateOrder` fails, changes will roll back.

---

## Advanced Usage of `@Transactional`

### 1. **Propagation**  
Propagation defines how transactions relate to each other.  

#### Example:

```java
@Transactional(propagation = Propagation.REQUIRED)
public void parentMethod() {
    childMethod();
}

@Transactional(propagation = Propagation.REQUIRES_NEW)
public void childMethod() {
    // This creates a new transaction
}
```

#### Propagation Types:
- **REQUIRED (default)**: Uses the existing transaction or creates a new one.
- **REQUIRES_NEW**: Suspends the current transaction and creates a new one.
- **MANDATORY**: Requires an existing transaction; throws an exception if none exists.
- **SUPPORTS**: Participates in the existing transaction; otherwise, runs without one.
- **NOT_SUPPORTED**: Runs without a transaction, suspending any existing one.
- **NEVER**: Ensures no transaction exists; throws an exception if one exists.
- **NESTED**: Runs within a nested transaction.

---

### 2. **Rollback Rules**  
By default, Spring rolls back transactions only for **unchecked exceptions** (`RuntimeException` or `Error`).  

You can customize this behavior:  

```java
@Transactional(rollbackFor = Exception.class)
public void processOrder(Order order) throws Exception {
    // Rolls back even for checked exceptions
}
```

---

### 3. **Isolation Levels**  
Isolation levels define how transactions interact with each other.  

#### Example:

```java
@Transactional(isolation = Isolation.SERIALIZABLE)
public void processOrder() {
    // Highest isolation level to avoid conflicts
}
```

#### Isolation Levels:
- **READ_UNCOMMITTED**: Transactions can read uncommitted changes.
- **READ_COMMITTED (default)**: Transactions can only read committed changes.
- **REPEATABLE_READ**: Ensures data consistency for repeated reads.
- **SERIALIZABLE**: Strictest level; prevents conflicts but may reduce performance.

---

### 4. **Timeout**  
Set a timeout to limit how long a transaction can run.  

```java
@Transactional(timeout = 10) // 10 seconds
public void processOrder() {
    // Transaction will fail if it exceeds 10 seconds
}
```

---

## Impact on the Database
- **Commit**: Changes are permanently saved to the database.
- **Rollback**: Changes are undone, leaving the database unchanged.
- Transactions ensure **data consistency**, especially in multi-user or multi-threaded environments.

---

## Common Pitfalls  

1. **Transactional on Private Methods**: `@Transactional` works only on public methods.  
   **Solution**: Always use it on public methods.

2. **Transactional on Methods in the Same Class**: Spring proxies `@Transactional` methods. If you call one method from another within the same class, the annotation won't work.  
   **Solution**: Use a service layer to separate logic.

3. **Unchecked Exceptions**: By default, only unchecked exceptions trigger rollbacks.  
   **Solution**: Use `rollbackFor` to include checked exceptions.

---

## Example Project  

```java
@Service
public class PaymentService {

    @Transactional
    public void processPayment(Order order) {
        paymentRepository.charge(order.getPaymentDetails());
        inventoryRepository.reduceStock(order.getItems());

        if (someConditionFails) {
            throw new RuntimeException("Payment failed!");
        }
    }
}
```

- **Successful Transaction**: Payment and inventory updates commit.  
- **Failed Transaction**: Changes are rolled back, and the database remains consistent.

---
