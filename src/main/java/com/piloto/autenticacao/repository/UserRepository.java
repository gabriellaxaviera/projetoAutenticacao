package com.piloto.autenticacao.repository;

import com.piloto.autenticacao.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
    User findByCpf(String cpf);
}
