package asac.DockerPractice.controller;

import asac.DockerPractice.dto.UserDto;
import asac.DockerPractice.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("/join")
    public ResponseEntity join(@RequestBody UserDto dto) {
        return userService.join(dto);
    }

    @GetMapping("/user/{id}")
    public ResponseEntity findById(@PathVariable Integer id){
        return userService.findById(id);
    }
}
