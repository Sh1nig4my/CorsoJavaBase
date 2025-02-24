package com.esercizio.venerdi21febbraio.controller;

import com.esercizio.venerdi21febbraio.dto.bookDto.BookRegisterDto;
import com.esercizio.venerdi21febbraio.dto.bookDto.BookResponseDto;
import com.esercizio.venerdi21febbraio.dto.userDto.UserBaseResponseDto;
import com.esercizio.venerdi21febbraio.dto.userDto.UserRegisterDto;
import com.esercizio.venerdi21febbraio.service.UsersService;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;
@RequestMapping("/api/user")
@RestController
public class UserController {

    @Autowired
    UsersService usersService;
    //READ
    @GetMapping("/{id}")
    public ResponseEntity<UserBaseResponseDto> createUser(@PathVariable BigInteger id){
        return usersService.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<UserBaseResponseDto>> getALlUser(){
        return ResponseEntity.ok(usersService.findAll());
    }

    @GetMapping("/")
    public ResponseEntity<UserBaseResponseDto> getFromEmail(@RequestParam String email){
        return usersService.findByEmail(email).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }


    //CREATE
    @PostMapping
    public ResponseEntity<UserBaseResponseDto> postUser(@RequestBody UserRegisterDto dto){
        Optional<UserBaseResponseDto> opt = usersService.insertNewUser(dto);
        return opt.map(ResponseEntity::ok).orElse(ResponseEntity.badRequest().build());
    }

    //UPDATE
    @PutMapping("/{id}")
    public ResponseEntity<UserBaseResponseDto> updateOneBook(@RequestBody UserRegisterDto registerDto, @PathVariable BigInteger userId){
        return  usersService.updateUser(registerDto, userId).map(ResponseEntity::ok).get() ;
    }

    // DELETE
    @DeleteMapping("/{id}")
    public void deleteUserById(@PathVariable BigInteger id){
        usersService.deleteUserById(id);
    }
}
