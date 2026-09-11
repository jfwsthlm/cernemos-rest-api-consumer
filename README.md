# Cernemos Consumer Web Application

A Spring Boot MVC client application that provides an interactive web frontend for testing and using the **Cernemos REST API** ciphers.

---

## Overview

`CernemosConsumer` provides a user-friendly Web UI powered by Spring MVC and Thymeleaf templates. It consumes backend cryptographic services provided by `cernemos-rest-api`, enabling users to submit text via web forms and view real-time encryption results.

### Features
* **ROT13 UI (`/encrypt`)**: Web interface to submit text and view the ROT13 encrypted response.
* **Substitution Cipher UI (`/substitution`)**: Dynamic form populated with alphabet keys (A?Z) allowing users to map character substitutions and view processed text output.
* **About Page (`/about`)**: Information page explaining the application.

---

## Tech Stack & Architecture

* **Framework:** Spring Boot Web (Spring MVC `@Controller`, `@GetMapping`, `@PostMapping`)
* **View Engine:** Thymeleaf (HTML templates: `rot13-form.html`, `substitution-form.html`, `about.html`)
* **Service Layer:** `ApiService` (handles HTTP communication with `cernemos-rest-api`)
* **Package Structure:** `se.sthlm.jfwsthlm.CernemosConsumer`

---

## Application Routes (UI)

| Route | HTTP Method | Description | Template Used |
| :--- | :--- | :--- | :--- |
| `/encrypt` | `GET` | Displays the ROT13 submission form | `rot13-form.html` |
| `/encrypt` | `POST` | Submits text to backend API and displays encrypted result | `rot13-form.html` |
| `/substitution` | `GET` | Renders dynamic A?Z character mapping form | `substitution-form.html` |
| `/substitution` | `POST` | Sends text & custom mapping key to API and displays result | `substitution-form.html` |
| `/about` | `GET` | Displays project information page | `about.html` |

---

## Prerequisites & Dependencies

Before running this application:
1. Ensure **`cernemos-rest-api`** is running.
2. JDK 17+ and Maven installed.
