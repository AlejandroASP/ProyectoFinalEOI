package com.example.AlejandroSPEOI.user.dto;

import java.util.List;

import com.example.AlejandroSPEOI.user.proyecciones.Users;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data @AllArgsConstructor
public class ResponseUsersDTO {
    private List<Users> users;
}
