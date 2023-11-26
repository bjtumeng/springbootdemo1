package com.dudu.springbootdemo1.check;

import com.dudu.springbootdemo1.domain.User;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @Description:
 * @author:zhaomeng
 * @date:2023/11/16 11:31 上午
 */
@RestController
@RequestMapping("/senior/user")
@Slf4j
@Validated
public class UserController {
//    @Autowired
//    private UserRepository userRepository;


    @PostMapping
    public User createUser(@UniqueUser @Valid User user){
//        User savedUser = userRepository.save(user);
//        log.info("save user id is {}",savedUser.getId());
//        return savedUser;
        return  null;
    }

    @SneakyThrows
    @PutMapping
    public User updateUser(@NotConflictUser @Valid @RequestBody User user){
//        User editUser = userRepository.save(user);
//        log.info("update user is {}",editUser);
//        return editUser;
          return null;
    }
}
