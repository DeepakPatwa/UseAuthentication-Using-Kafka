package com.stackroute.pie.userlogin.listner;

import com.stackroute.pie.userlogin.Model.Role;
import com.stackroute.pie.userlogin.Model.RoleName;
import com.stackroute.pie.userlogin.Model.User;
import com.stackroute.pie.userlogin.repository.RoleRepository;
import com.stackroute.pie.userlogin.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class KafkaConsumer {
    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @KafkaListener(topics = "deepak", groupId = "group_id")
    public void consume(String message) {
        System.out.println("String wala method");
        System.out.println("Consumed message1: " + message);
    }
//    @KafkaListener(topics = "Kafka_Example_json", groupId = "group_json",
//            containerFactory = "userKafkaListenerFactory")

    @KafkaListener(topics = "userreg_json", groupId = "group_json", containerFactory = "userKafkaListenerFactory")
    public void consumeJson(User user) {
        System.out.println("yoyoyoyoyo");
        System.out.println("Consumed JSON Message: " + user);


        Set<Role> roles = new HashSet<>();


        Role insurerRole = roleRepository.findByName(RoleName.ROLE_USER)
                .orElseThrow(() -> new RuntimeException("Fail! -> Cause: User Role not find."));
        roles.add(insurerRole);
        user.setRoles(roles);
        userRepository.save(user);



    }



}
