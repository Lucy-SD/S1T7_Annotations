# 🎓 Java Annotations Exercises

**👨‍💻 Author**: Lucy Castro  
**🧠 Learning Focus**: Java Annotations and Reflection  
**🛠️ IDE**: IntelliJ IDEA  
**💡 Java SDK**:  21  

## 📄 Description
This repository contains Java exercises focused on:

- Core Java annotations (@Override, @Deprecated, @SuppressWarnings)

- Custom annotation creation

- Runtime annotation processing with Reflection

- JSON serialization through annotations

## 💻 Technologies Used
- ☕ Java 21

- 🧠 IntelliJ IDEA

- 📜 JSON processing (Jackson recommended)

- 🔍 Reflection API

- 🗃️ Git & GitHub
  
- ⌨️ Command Line Tools

## 📋 Requirements
- ✅ Java JDK 21
- ✅ IntelliJ IDEA
- ✅ Git
- ✅ Internet connection


## 🛠️ Installation

git clone https://github.com/Lucy-SD/S1T7_Annotations

Open in IntelliJ: File > Open > S1T7_Annotations

Set SDK: File > Project Structure > Project SDK > JDK 21


## 📚 Exercise Catalog

Note: For Level 2-3 exercises, you'll need to:

Add a JSON library (like Jackson) to your project

Implement the actual JSON serialization logic in the processor

Handle all edge cases (null values, circular references, etc.)

### 📂 Level 1: Core Annotations

<summary><strong>Exercise 1: Worker Hierarchy</strong></summary>
<details>

Create an object hierarchy with three classes: Worker, Online Worker and Face-to-face Worker.

The Worker class has the attributes first name, last name, price/hour, and the method calcarSou() that receives as a parameter the number of hours worked and multiplies it by the price/hour. Child classes must override it, using @Override. 

From the main() of the Main class, make the necessary invocations to demonstrate the operation of the @Override annotation.

For on-site workers, the method to calculate their salary will receive as a parameter the number of hours worked per month. When calculating the salary, the number of hours worked will be multiplied by the price/hour, plus the value of a static attribute called gasoline that we will add to this class.

For online workers, the method to calculate their salary will receive as a parameter the number of hours worked per month. When calculating the salary, the number of hours worked will be multiplied by the price/hour and the price of the flat Internet rate will be added, which will be a constant of the TreballadorOnline class.

</details>

<summary><strong>Exercise 2: Deprecated Methods</strong></summary>
<details>
  
Add some obsolete (deprecated) methods to the child classes, and use the corresponding annotation. Invoke the obsolete methods from an external class, suppressing the “warnings” for being obsolete using the corresponding annotation.
</details>

### 📂 Level 2: Custom Annotation

<summary><strong>EExercise 1: JSON Serialization Annotation</strong></summary>

<details>
Create a custom annotation that should allow serializing a Java object into a JSON file. The annotation should receive the directory where the resulting file will be placed.
</details>

### 📂 Level 3: Runtime Processing

<summary><strong>Exercise 1: Reflection Processing</strong></summary>
<details>
Adds the possibility that the annotation created in the previous level is registered by the Virtual Machine at runtime. Demonstrates that the annotation reading is executed using  Java Reflection.
</details>


## 🎯 Learning Goals

✅ Core annotation usage

✅ Custom annotation creation

✅ Runtime annotation processing

✅ Reflection API fundamentals

✅ JSON serialization through annotations

## 🏆 Best Practices Implemented

✔ Proper annotation retention policies

✔ Correct target selection for custom annotations

✔ Clean separation between annotation declaration and processor

✔ Comprehensive exception handling

✔ Proper build configuration

## 🤝 Contributions

⭐ Star the repository

🍴 Fork the project

📥 Create a pull request

## 🌐 Deployment

For educational purposes only.

### 🚀 Thanks for Visiting!
