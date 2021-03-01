package com.piloto.autenticacao.config;

import com.piloto.autenticacao.model.Role;
import com.piloto.autenticacao.model.User;
import com.piloto.autenticacao.repository.RoleRepository;
import com.piloto.autenticacao.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class DataInitializer implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    PasswordEncoder passwordEncoder;


    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        List<User> users = userRepository.findAll();

        if (users.isEmpty()) {
            createUser("10781735408", passwordEncoder.encode("12345678"), Roles.ROLE_ADMIN);
        }
    }

    public void createUser(String cpf, String password, String roleName) {

        Role role = new Role(roleName);

        User user = new User(cpf,password);
        user.setRoles(Arrays.asList(role));

        this.roleRepository.save(role);
        userRepository.save(user);
    }

}
