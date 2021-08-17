package com.example.work.service;

import com.example.work.domain.Role;
import com.example.work.domain.User;
import com.example.work.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Collections;
import java.util.UUID;

@Service
public class UserService implements UserDetailsService {
    @Autowired
    private UserRepo userRepo;   //инжектим поле!
    // 2 способ без @Autowired
//    private final UserRepo userRepo;
//
//    public UserService(UserRepo userRepo) { Спринг видит что есть конструктор будет пытаться заинжектить все это
//        this.userRepo = userRepo;}
    @Autowired
    private MailSender mailSender;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepo.findByUsername(username);
    }
    public boolean addUser(User user){
        User userFromDb = userRepo.findByUsername(user.getUsername());
        if(userFromDb !=null){
            return false;
        }
        user.setActive(true);
        user.setRoles(Collections.singleton(Role.USER));
        user.setActivationCode(UUID.randomUUID().toString());
        userRepo.save(user);
        if (!StringUtils.isEmpty(user.getEmail())){
            String message =String.format(
                    "Hello, %s! \n"+
                            "Welcome to Journal STO, Please, visit next link: http://localhost:8080/activate/%s",
                    user.getUsername(),user.getActivationCode()
            );
              mailSender.send(user.getEmail(),"Activation code",message);
        }
        return true;
    }

    public boolean activateUser(String code) {
       User user = userRepo.findByActivationCode(code);

       if (user ==null){
           return false;
       }
       user.setActivationCode(null);

       userRepo.save(user);

        return true;
    }
}
