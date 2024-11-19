
# **📮 HTTP Verbs Cheat Sheet**

---

## **1️⃣ Overview of HTTP Verbs**

| **HTTP Verb** | **Purpose**                                      | **Idempotent** | **Safe** |
|---------------|--------------------------------------------------|----------------|----------|
| `GET`         | Retrieve data from the server                   | ✅ Yes         | ✅ Yes   |
| `POST`        | Create a new resource on the server             | ❌ No          | ❌ No    |
| `PUT`         | Update or replace a resource                    | ✅ Yes         | ❌ No    |
| `PATCH`       | Partially update a resource                     | ❌ No          | ❌ No    |
| `DELETE`      | Delete a resource                               | ✅ Yes         | ❌ No    |
| `HEAD`        | Retrieve metadata without the body of the response | ✅ Yes      | ✅ Yes   |
| `OPTIONS`     | Describe available communication options for a resource | ✅ Yes | ✅ Yes   |

---

## **2️⃣ What Do "Safe" and "Idempotent" Mean?**

### **Safe**
- A request is **safe** if it does **not modify server state**.
- Examples: `GET`, `HEAD`.

### **Idempotent**
- **Idempotent** methods produce the same result no matter how many times you repeat the request.
- Examples: `GET`, `PUT`, `DELETE`.
- **Non-idempotent** methods may create or modify resources with each request.
- Example: `POST`.

---

## **3️⃣ Key HTTP Verbs**

### **GET**
- **Purpose**: Retrieve information from the server.

#### Example 1: Fetching a List of Users
```http
GET /users HTTP/1.1
Host: api.example.com
Accept: application/json
```

**Response:**
```json
[
  {
    "id": 1,
    "name": "Alice",
    "email": "alice@example.com"
  },
  {
    "id": 2,
    "name": "Bob",
    "email": "bob@example.com"
  }
]
```

#### Example 2: Fetching a Specific User
```http
GET /users/1 HTTP/1.1
Host: api.example.com
Accept: application/json
```

**Response:**
```json
{
  "id": 1,
  "name": "Alice",
  "email": "alice@example.com"
}
```

---

### **POST**
- **Purpose**: Create a new resource on the server.
- **Non-idempotent**: Multiple identical requests create new resources.

#### Example: Creating a New User
```http
POST /users HTTP/1.1
Host: api.example.com
Content-Type: application/json

{
  "name": "Alice",
  "email": "alice@example.com"
}
```

**Response:**
```http
HTTP/1.1 201 Created
Location: /users/3
```

---

### **PUT**
- **Purpose**: Update or replace an existing resource.
- **Idempotent**: Repeating the request has no additional effect.

#### Example: Updating a User's Profile
```http
PUT /users/1 HTTP/1.1
Host: api.example.com
Content-Type: application/json

{
  "name": "Alice Updated",
  "email": "alice.updated@example.com"
}
```

**Response:**
```http
HTTP/1.1 200 OK
```

---

### **PATCH**
- **Purpose**: Partially update a resource.
- **Non-idempotent**: Repeated requests may have cumulative effects.

#### Example: Updating a User's Email
```http
PATCH /users/1 HTTP/1.1
Host: api.example.com
Content-Type: application/json

{
  "email": "new.email@example.com"
}
```

**Response:**
```http
HTTP/1.1 200 OK
```

---

### **DELETE**
- **Purpose**: Delete a resource.
- **Idempotent**: Repeating the request does not change the state after the first deletion.

#### Example: Deleting a User
```http
DELETE /users/1 HTTP/1.1
Host: api.example.com
```

**Response:**
```http
HTTP/1.1 204 No Content
```

---

## **4️⃣ Differences Between PUT, POST, and PATCH**

| **Aspect**        | **PUT**                                      | **POST**                       | **PATCH**                        |
|-------------------|----------------------------------------------|--------------------------------|----------------------------------|
| **Purpose**       | Replace an entire resource                  | Create a new resource          | Partially update a resource      |
| **Idempotence**   | ✅ Yes                                       | ❌ No                          | ❌ No                            |
| **Example**       | Replace all user details                    | Add a new user                 | Update a single user field       |

---

## **5️⃣ Quick Summary**

- **GET**: Retrieve data without modifying the server.
- **POST**: Create new resources, not idempotent.
- **PUT**: Replace resources, idempotent.
- **PATCH**: Partially update resources, not idempotent.
- **DELETE**: Remove resources, idempotent.

---

