package com.example.AlejandroSPEOI.user;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.AlejandroSPEOI.user.proyecciones.Users;

import com.example.AlejandroSPEOI.user.dto.UserDTO;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UsersService {
    private final UsersRepository usersRepo;

    List<Users> getAll() {
        return usersRepo.findBy();
    }

    public Users getById(int id) {
        Users u = usersRepo.findUserById(id);
        return u;
    }

    public Users insert(UserDTO userDTO) {
        // Crear un nuevo usuario a partir del DTO
        User user = usersRepo.save(User.fromDTO(userDTO));  // Asigna nombre y contraseña correctamente
        return usersRepo.findUserById(user.getId());
    }

    public Users update(int id, UserDTO userDTO) {
        if (!usersRepo.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuario no encontrado");
        }
        User userExists = usersRepo.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                "Error inesperado, el usuario no se ha encontrado."));
        userExists.setId(id);
        
        return usersRepo.findUserById(userExists.getId());
    }

    public void delete(int idUser) {
        usersRepo.deleteById(idUser);
    }
}
