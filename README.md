# 💬 Java Real-Time Chat Application

A simple **CLI Based**, Full-Duplex real-time console chat application built using **Java Sockets** and **Multithreading**.Where both the Server and multiple Clients can communicate simultaneously in a shared chat room.

---

## 📖 Project Overview

This is a **client-server chat application** where:
- **Multiple clients** can connect to a central server.
- **Any client** can send a message, and it is **broadcasted** to all other connected clients.
- The **Server Admin** can also send messages that appear to all clients.
- All messages are displayed with the **sender's name** for easy identification.

This project was built as my first hands-on application after learning **Object-Oriented Programming (OOP)** and **Exception Handling** in Java.

---

## 🚀 Features

| Feature | Description |
| :--- | :--- |
| **Real-time Messaging** | Messages appear instantly on all connected clients. |
| **Server Admin Chat** | The server terminal can send messages to all clients (with its own custom name). |
| **Client-to-Client Communication** | All connected clients broadcast messages to everyone. |
| **Multiple Client Support** | Handles unlimited concurrent clients using threads. |
| **Name Identification** | Each client and the server choose a name, displayed with every message. |
| **Automatic Disconnection Handling** | When a client disconnects, they are removed from the active list. |
| **Console-Based UI** | Simple, clean terminal interface – no GUI required. |

---

## 🛠️ Java Concepts Used

This project demonstrates the following core Java concepts:

| Concept | How It's Used |
| :--- | :--- |
| **Socket Programming** | `ServerSocket` and `Socket` for network communication between client and server. |
| **Multithreading** | Each client runs on a separate `Thread` so the server can handle multiple clients simultaneously. |
| **I/O Streams** | `BufferedReader`, `PrintWriter`, `InputStreamReader`, `OutputStream` for reading/writing data over the network. |
| **Collections Framework** | `ArrayList` to store and manage connected client threads. |
| **Exception Handling** | `try-catch-finally` blocks to handle network errors, disconnections, and resource cleanup. |
| **Inner Classes** | `ClientHandling` is an inner class of `Server` to encapsulate client-specific logic. |
| **Runnable Interface** | Used for creating threads (`implements Runnable` with lambda expressions). |
| **Static Methods & Variables** | Shared resources like `allClients` list and `sendAdminMessage()` are static. |
| **Scanner for Input** | Reading user input from the console for both server and client. |

---

## 📁 Project Structure
```
Chat_Application/
├── Server.java          # Main server application
└── Client.java          # Client application (for users)
```
## ⚙️ How to Run

### Prerequisites
- Java Development Kit (JDK) 8 or higher installed.
- Terminal / Command Prompt access.

### Step-by-Step Instructions

### Step 1: Compile the Server
```bash
javac Server.java
```

### Step 2: Compile the Client
```bash
javac Client.java
```

### Step 3: Start the Server
```bash
java Server
```

### Step 4: Start the Client (in a new terminal)
```bash
java Client
```

## 📚 Technologies Used

- **Java 8+** – Core programming language.
- **Java.net** – For Socket and ServerSocket classes.
- **Java.io** – For BufferedReader, PrintWriter, and stream handling.
- **Java.util** – For Scanner, ArrayList, and Collections.

---

## ⭐ Show Your Support

If you found this project helpful, please **star** it on GitHub! ⭐

---
