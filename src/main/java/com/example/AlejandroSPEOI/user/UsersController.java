package com.example.AlejandroSPEOI.user;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.AlejandroSPEOI.user.dto.ResponseUserDTO;
import com.example.AlejandroSPEOI.user.dto.ResponseUsersDTO;
import com.example.AlejandroSPEOI.user.dto.UserDTO;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UsersController {
    private final UsersService usersService;

    @GetMapping
    public ResponseUsersDTO getAll() {
        return new ResponseUsersDTO(usersService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseUserDTO getById(@PathVariable int id) {
        return new ResponseUserDTO(usersService.getById(id));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseUserDTO insert(@RequestBody @Valid UserDTO u) {
        return new ResponseUserDTO(usersService.insert(u));  // Pasa el DTO al servicio
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseUserDTO update(@PathVariable int id, @RequestBody @Valid UserDTO u) {
        return new ResponseUserDTO(usersService.update(id, u));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable int id){
        usersService.delete(id);
    }
}

