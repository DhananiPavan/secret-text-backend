



# 🔐 Secret Text Backend (Spring Boot + MongoDB)

A secure backend service that allows users to store secret text using a **PIN** and retrieve it using the same PIN.
The secret data **automatically expires after 24 hours** using MongoDB TTL (Time-To-Live).

---

## 🚀 Features

* 🔑 Store secret text with a **unique PIN**
* 🔍 Retrieve secret using only the PIN
* ⏳ **Automatic deletion after 24 hours** (MongoDB TTL)
* ❌ Prevents duplicate PINs
* 🌐 RESTful APIs
* ⚡ Built with **Spring Boot (Java 21)** and **MongoDB Atlas**
* 🧼 Clean architecture (Controller → Service → Repository)

---

## 🛠 Tech Stack

* **Java 21**
* **Spring Boot**
* **Spring Data MongoDB**
* **MongoDB Atlas**
* **Lombok**
* **Maven**

---

## 📁 Project Structure

```
secret-text-backend
│
├── controller
│   └── SecretController.java
│
├── service
│   └── SecretService.java
│
├── repository
│   └── SecretRepository.java
│
├── model
│   └── Secret.java
│
├── config
│   └── MongoConfig.java
│
├── application.properties
└── SecretTextBackendApplication.java
```

---

## ⚙️ Configuration

### `application.properties`

```properties
spring.application.name=secret-text-backend
server.port=8080

spring.data.mongodb.uri=mongodb+srv://<username>:<password>@cluster0.wkrsfvg.mongodb.net/secret_db?retryWrites=true&w=majority
```

> ⚠️ Replace `<username>`, `<password>`, and `secret_db` with your MongoDB Atlas credentials.

---

## 🧩 MongoDB TTL Configuration

Secrets are automatically deleted after **24 hours** using TTL.

```java
@Indexed(expireAfterSeconds = 86400)
private Instant createdAt;
```

MongoDB handles deletion automatically — no scheduler required.

---

## 📌 API Endpoints

### 1️⃣ Save Secret

**POST** `/api/secret`

#### Request Body

```json
{
  "pin": "1234",
  "content": "This is my confidential message"
}
```

#### Responses

* `201 CREATED` – Secret saved successfully
* `400 BAD REQUEST` – Invalid input
* `409 CONFLICT` – PIN already exists

---

### 2️⃣ Get Secret

**GET** `/api/secret/{pin}`

#### Example

```
GET /api/secret/1234
```

#### Responses

* `200 OK` – Returns secret content
* `404 NOT FOUND` – Invalid PIN or secret expired

---

## 🧪 Testing

You can test APIs using:

* Postman
* Thunder Client
* curl

Example:

```bash
curl http://localhost:8080/api/secret/1234
```

---

## ✅ Status

✔ Backend complete
✔ MongoDB connected
✔ TTL working
✔ APIs tested

---

## 📌 Future Enhancements (Optional)

* 🔐 Hash PIN for extra security
* 🗑 Delete secret after first read
* 🌍 Frontend integration
* 🚀 Deployment (Render / Railway / AWS)

---

## 👨‍💻 Author

**Pavan**
B.Tech Student | Full Stack Trainee
Spring Boot • MongoDB • Backend Development




