package org.example.websocket.user;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final SimpMessagingTemplate messagingTemplate;


    @MessageMapping("/user.addUser")
    @SendTo("/user/public")
    public User addUser(
            @Payload User user
    ) {
        userService.saveUser(user);
        return user;
    }

    @PostMapping("/users")
    public ResponseEntity<User> addUserRest(@RequestBody User user) {
        userService.saveUser(user);
        // Broadcast the new user to all connected WebSocket clients
        messagingTemplate.convertAndSend("/user/public", user);
        return ResponseEntity.ok(user);
    }


    @MessageMapping("/user.disconnectUser")
    @SendTo("/user/public")
    public User disconnectUser(
            @Payload User user
    ) {
        userService.disconnect(user);
        return user;
    }

    @PostMapping("/users/{userId}/disconnect")
    public ResponseEntity<User> disconnectUserRest(@PathVariable String userId) {
        User user = userService.findUserById(userId); // Fetch the user instead of creating a new one
        if (user == null) {
            return ResponseEntity.notFound().build();
        }
        userService.disconnect(user);

        // Broadcast the disconnection to all WebSocket clients
        messagingTemplate.convertAndSend("/topic/public", user);

        return ResponseEntity.ok(user);
    }

    @GetMapping("/users")
    public ResponseEntity<List<User>> findConnectedUsers() {
        return ResponseEntity.ok(userService.findConnectedUsers());
    }
}