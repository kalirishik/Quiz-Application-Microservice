# 🎯 Quiz Application - Microservices with Eureka & Feign

A **Quiz Application** built using **Spring Boot Microservices**, designed with **Eureka Server, Eureka Discovery Client, Feign Client, Spring Data JPA, Hibernate, and MySQL**.  
The system is split into independent microservices with centralized routing via API Gateway, enabling scalability, modularity, and seamless service communication.

---
## 📖 Project Description

This project is a Microservices-based Quiz Application built using Spring Boot and Spring Cloud.
It provides a scalable and modular solution for managing quiz questions, generating quizzes, and evaluating user responses.

The system includes:

 - Eureka Server for service discovery.

 - API Gateway for centralized routing, load balancing, and filtering.

- Feign Client for internal service-to-service communication.

Each service is independently deployable, ensuring flexibility, scalability, and easier maintenance.
The project follows a layered architecture (Controller → Service → Repository) and integrates with a MySQL database for persistence.

---

## 🚀 Features
- 📌 **Service Discovery** – Eureka Server for service registration and discovery.
- 📌 **API Gateway** – Central entry point for routing all client requests.
- 📌 **Question Service** – Add, update, delete, and fetch quiz questions with pagination and filters.  
- 📌 **Quiz Service** – Generate quizzes dynamically, manage assignments, and scoring.
- 📌 **Answer Submission** – Submit responses and calculate scores instantly.  
- 📌 **Feign Client Integration** – Quiz Service communicates with Question Service via Feign.  
- 📌 **Pagination Support** – Retrieve questions efficiently using pageable endpoints.  
- 📌 **Database Integration** – MySQL with `data.sql` preloaded questions.  
- 📌 **Swagger UI** – API documentation for all services.  
- 📌 **Layered Architecture** – Follows Controller → Service → Repository design pattern.  
---

## 🛠️ Tech Stack
- **Backend Framework:** Spring Boot (Microservices + REST APIs)  
- **Service Registry:** Eureka Server
- **API Gateway:** Spring Cloud Gateway
- **Communication:** Feign Client (Declarative REST Client)  
- **Database:** MySQL + JPA/Hibernate  
- **Utilities:** Lombok  
- **API Docs:** Swagger UI  
- **Build Tool:** Maven  

--- 
## 📂 Microservice Architecture
```
quiz-microservices/
├─ eureka-server/         # Service registry
│   └─ EurekaServerApplication.java
│
├─ api-gateway/           # Central API Gateway for routing
│   └─ ApiGatewayApplication.java
│
├─ question-service/      # Manages questions
│   ├─ controller/QuestionController.java
│   ├─ service/QuestionService.java
│   ├─ repository/QuestionRepository.java
│   └─ model/Question.java
│
├─ quiz-service/          # Manages quizzes & scoring
│   ├─ controller/QuizController.java
│   ├─ service/QuizService.java
│   ├─ feign/QuestionClient.java  # Feign client to call Question Service
│   └─ model/{Quiz, QuestionWrapper, Response}.java
│
└─ pom.xml
```

---

## 🔌 API Overview
### **🌐 API Gateway Endpoints**

- `http://localhost:8082/question/** → Question Service`
- `http://localhost:8082/quiz/** → Quiz Service`

### **📘Question Service APIs** (`/question-service/question`)
- `GET /allquestions` – list all (no pagination)  
- `GET /viewQuestions?page={p}&size={s}` – paginated list  
- `GET /category/{category}` – by category  
- `GET /difficulty/{level}` – by difficulty (Easy/Medium/Hard)  
- `GET /random/{category}/{numQ}` – random by category  
- `POST /addQuestion` – add one  
- `POST /addQuestions` – add many  
- `PUT /updateQuestion/{id}` – update  
- `DELETE /deleteQuestion/{id}` – delete  
- `GET /countByCategory/{category}` – analytics count  

---

### **📘 Quiz Service APIs** (`/quiz-service/quiz`)
- `POST /createQuiz?category={c}&numQ={n}&title={t}` – create quiz (calls Question Service via Feign)  
- `GET /getQuizQuestionsById/{id}` – get quiz questions (wrapped, no answers)  
- `POST /submitQuiz/{id}` – submit answers → score  
- `GET /getAllQuizzes` – list quizzes  
- `DELETE /deleteQuiz/{id}` – delete quiz  

---

## 🧩 Implementation Notes
- **Eureka Server**: Runs on port `8761` (service registry dashboard).
- **API Gateway:** Runs on port 8082 (routes all requests).
- **Question Service**: Registers with Eureka as `QUESTION-SERVICE`.  
- **Quiz Service**: Registers with Eureka as `QUIZ-SERVICE`. Uses Feign to fetch questions.  
- **Feign Client**: `@FeignClient(name="QUESTION-SERVICE")` connects services seamlessly.  
- **Load Balancing**: Future-ready with Spring Cloud LoadBalancer.  

---

## 🚀 Getting Started

### Prerequisites
- Java 17+  
- Maven 3.9+  
- MySQL 8.x  

### Steps
1. Start **Eureka Server** (`eureka-server`).  
2. Run **Question Service** (`question-service`).  
3. Run **Quiz Service** (`quiz-service`).
4. Start **API Gateway** (`api-gateway`).
5. Access **Eureka Dashboard** → `http://localhost:8761`.  
6. Use **Swagger UI** for APIs:  
   - Question Service → `http://localhost:8081/swagger-ui.html`  
   - Quiz Service → `http://localhost:8082/swagger-ui.html`  

---

## 📸 Screenshots

<img width="1815" height="834" alt="Screenshot 2025-09-03 000503" src="https://github.com/user-attachments/assets/167e5838-b08a-44df-b8db-5e11f523098f" />

<img width="1835" height="445" alt="Screenshot 2025-09-03 000515" src="https://github.com/user-attachments/assets/97045c39-a3f2-42c2-a53d-12b0d7767fe5" />

<img width="1832" height="1030" alt="Screenshot 2025-09-03 000547" src="https://github.com/user-attachments/assets/dc8f96de-d978-4ff7-b858-a7b3073f9502" />

<img width="1838" height="1015" alt="Screenshot 2025-09-03 000636" src="https://github.com/user-attachments/assets/cd4170f5-d485-40f1-b23d-dbc20b4ef30b" />

<img width="1439" height="270" alt="image" src="https://github.com/user-attachments/assets/7038d998-f577-47bf-8182-aa5ac709c752" />

---
