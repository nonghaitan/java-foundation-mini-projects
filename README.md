# Java Foundation Mini Projects

## Overview
Mini projects for **Month 1 – Java SE 8–17 Foundation + OCA Logic**.  
Learn Java syntax, OOP, Collections, Stream API, Unit Testing, and QA Automation mindset.

---

## Week 1 Summary

### Day 1 – Core Syntax & Logic
- Java basics, control flow, methods
- **Project:** Calculator CLI (add, subtract, multiply, divide)
- Unit tests for operations & exceptions

### Day 2 – Testing & Refactor
- JUnit 5, Clean Code, Exception Handling
- Refactor Calculator for readability & maintainability
- Focus on TDD and test-driven thinking

### Day 3 – Collections & OOP
- OOP, ArrayList, HashMap, Stream API, Optional
- **Project:** Library Manager
    - `Book` class, `LibraryManager` implements `LibraryService`
    - Level 1: Basic operations (add, remove, update, find, count, clear)
    - Level 2: Functional (find by author, hasBook, Optional)
    - Level 3: Refactor to HashMap + console app (`LibraryApp`) with menu
- Unit tests: Level 1 & 2
- Manual testing: Level 3 console menu

---

## How to Run
1. Run JUnit tests for Level 1 & 2
2. Run `LibraryApp.main()` for Level 3
3. Interact via console menu

---

## Project Structure
src/
└─ com/tan/library/
├─ Book.java
├─ LibraryManager.java
├─ LibraryService.java
└─ LibraryApp.java
test/
└─ com/tan/library/
└─ LibraryManagerTest.java

---

