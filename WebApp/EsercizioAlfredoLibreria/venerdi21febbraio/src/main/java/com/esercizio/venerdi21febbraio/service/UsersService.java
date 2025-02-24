package com.esercizio.venerdi21febbraio.service;

import com.esercizio.venerdi21febbraio.dto.bookDto.BookRegisterDto;
import com.esercizio.venerdi21febbraio.dto.bookDto.BookResponseDto;
import com.esercizio.venerdi21febbraio.dto.bookDto.DtoMapperBook;
import com.esercizio.venerdi21febbraio.dto.userDto.DtoMapperUser;
import com.esercizio.venerdi21febbraio.dto.userDto.UserBaseResponseDto;
import com.esercizio.venerdi21febbraio.dto.userDto.UserRegisterDto;
import com.esercizio.venerdi21febbraio.entities.Book;
import com.esercizio.venerdi21febbraio.entities.Users;
import com.esercizio.venerdi21febbraio.repository.UserRepository;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

@Service
public class UsersService {


    @Autowired
    UserRepository userRepository;

    // READ
    public Optional<UserBaseResponseDto> findById(BigInteger id) {
    return userRepository.findById(id).map(DtoMapperUser::fromEntityToDto);
    }

    public List<UserBaseResponseDto> findAll(){
        return DtoMapperUser.fromUserListToDtoList(userRepository.findAll());
    }

    public Optional<UserBaseResponseDto> findByEmail(String email) {
        return userRepository.findByEmail(email).map(DtoMapperUser::fromEntityToDto);
    }

    // CREATE
    public Optional<UserBaseResponseDto> insertNewUser(UserRegisterDto dto) {
        Optional<Users> userResponse = Optional.of(userRepository.save(DtoMapperUser.fromRegisterDtoToUser(dto)));
        return userResponse.map(DtoMapperUser::fromEntityToDto);
    }

    //UPDATE
    public Optional<UserBaseResponseDto> updateUser(UserRegisterDto registerDto, BigInteger userId) {
        userRepository.findById(userId).ifPresent(
                (users)->{
                    Users newUser = Users.builder()
                            .id(userId)
                            .nome(registerDto.getNome())
                            .email(registerDto.getEmail())
                            .password(registerDto.getPassword())
                            .build();
                    userRepository.save(newUser);
                }
        );
        return userRepository.findById(userId).map(DtoMapperUser::fromEntityToDto);
    }

    //DELETE
    public void deleteUserById(BigInteger id) {
        userRepository.deleteById(id);
    }
}
