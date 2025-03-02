# Chat Application

This is a simple chat application built using Java, Spring Boot, Maven, and JavaScript. The application allows users to join a chatroom, see online users, and send messages to each other in real-time.

## Features

- User authentication with nickname and real name
- Real-time messaging using WebSockets
- Display of online users
- Private messaging between users
- User status management (online/offline)

## Technologies Used

- Java
- Spring Boot
- Maven
- JavaScript
- SockJS and STOMP for WebSocket communication
- HTML/CSS for the frontend

## Prerequisites

- Java 11 or higher
- Maven 3.6.0 or higher
- Node.js and npm (for frontend dependencies)

## Getting Started

### Clone the Repository

```bash
git clone https://github.com/OmarAlhaj10/chat-application.git
cd chat-application
```

### Backend Setup

1. **Build the project:**

   ```bash
   mvn clean install
   ```

2. **Run the Spring Boot application:**

   ```bash
   mvn spring-boot:run
   ```

### Frontend Setup

1. **Navigate to the `src/main/resources/static` directory:**

   ```bash
   cd src/main/resources/static
   ```

2. **Install frontend dependencies:**

   ```bash
   npm install
   ```

3. **Build the frontend assets:**

   ```bash
   npm run build
   ```

## Usage

1. Open your web browser and navigate to `http://localhost:8080`.
2. Enter your nickname and real name to join the chatroom.
3. You will see a list of online users on the left side.
4. Click on a user to start a private chat.
5. Type your message in the input field and press "Send" to send the message.

## Project Structure

- `src/main/java`: Contains the Java source code for the Spring Boot application.
- `src/main/resources/static`: Contains the static resources (HTML, CSS, JavaScript) for the frontend.
- `src/main/resources/static/index.html`: The main HTML file for the chat application.
- `src/main/resources/static/js/main.js`: The main JavaScript file for handling frontend logic.
- `src/main/resources/static/css/main.css`: The main CSS file for styling the application.

## WebSocket Endpoints

- `/ws`: WebSocket endpoint for establishing connections.
- `/app/user.addUser`: Endpoint for registering a new user.
- `/app/user.disconnectUser`: Endpoint for disconnecting a user.
- `/app/chat`: Endpoint for sending chat messages.

## API Endpoints

- `/users`: GET endpoint to fetch the list of connected users.
- `/messages/{senderId}/{recipientId}`: GET endpoint to fetch chat messages between two users.

## License

This project is licensed under the MIT License. See the `LICENSE` file for details.

## Acknowledgements

- [Spring Boot](https://spring.io/projects/spring-boot)
- [SockJS](https://github.com/sockjs/sockjs-client)
- [STOMP](https://stomp.github.io/)

## Contact

For any inquiries or issues, please contact [OmarAlhaj10](https://github.com/OmarAlhaj10).
