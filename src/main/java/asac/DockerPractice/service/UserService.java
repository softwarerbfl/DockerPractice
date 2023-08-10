package asac.DockerPractice.service;

import asac.DockerPractice.controller.UserController;
import asac.DockerPractice.dto.UserDto;
import asac.DockerPractice.entity.User;
import asac.DockerPractice.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public ResponseEntity join(UserDto dto){
        User user = new User().createUser(dto);
        userRepository.save(user);
        return ResponseEntity.ok().body(user);
    }

    public ResponseEntity findById(Integer id){
        Optional<User> user = userRepository.findById(id);
        if(user.isPresent()){
            return ResponseEntity.ok().body(user);
        }
        else{
            return ResponseEntity.badRequest().body("아이디에 해당하는 유저가 존재하지 않습니다.");
        }
    }
}
