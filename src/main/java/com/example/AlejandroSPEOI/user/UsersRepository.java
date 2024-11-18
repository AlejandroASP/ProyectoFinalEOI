package com.example.AlejandroSPEOI.user;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.AlejandroSPEOI.user.proyecciones.Users;

@Repository
public interface UsersRepository extends JpaRepository<User, Integer> {
    List<Users> findBy();

    Users findUserById(int id);
}
