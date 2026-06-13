# ZCAS Student Software Engineering Portfolio

A multi-language backend development portfolio showcasing foundational enterprise architecture principles and data processing systems. Designed for global technology infrastructure standards.

## 1. Java Spring Boot E-Commerce API
A robust, relational e-commerce backend mapping transactions across multiple relational entities.
* **Architecture**: Model-View-Controller (MVC) layers cleanly separating database queries from business rules.
* **Features**: Dynamic product catalogs, transactional shopping carts, and automated checkout engines with inventory clearouts.
* **Tech Stack**: Java 17, Spring Boot, Spring Data JPA, H2 In-Memory Database, Maven.

### How to Run:
1. Navigate to directory: `cd java-ecommerce-api`
2. Launch application server: `mvn spring-boot:run`
3. Access API Catalog: http://localhost:8080/api/products
4. Access Database Panel: http://localhost:8080/h2-console

---

## 2. Python FastAPI Web Scraper API
An asynchronous data processing service that dynamically extracts web metadata and serves it over a custom REST pipeline.
* **Features**: Low-latency web scraping, custom HTTP request headers to bypass security rules, and automated JSON payload structures.
* **Tech Stack**: Python 3, FastAPI, Uvicorn, BeautifulSoup4, Requests.

### How to Run:
1. Navigate to directory: `cd python-scraper-api`
2. Activate environment: `source venv/bin/activate`
3. Launch routing engine: `uvicorn app.main:app --reload`
4. Access Live Data: http://localhost:8000/api/news
5. Access Interactive API Docs: http://localhost:8000/docs
