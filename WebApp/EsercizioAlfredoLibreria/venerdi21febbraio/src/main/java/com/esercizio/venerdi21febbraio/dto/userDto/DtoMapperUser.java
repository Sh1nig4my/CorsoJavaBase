package com.esercizio.venerdi21febbraio.dto.userDto;

import com.esercizio.venerdi21febbraio.entities.Users;

import java.util.List;


public class DtoMapperUser {


    public static UserBaseResponseDto fromEntityToDto(Users user){
        return UserBaseResponseDto.builder()
                .id(user.getId())
                .email(user.getEmail())
                .nome(user.getNome())
                .build();
    }

    public static Users fromRegisterDtoToUser(UserRegisterDto dto){
        return Users.builder()
                .nome(dto.getNome())
                .email(dto.getEmail())
                .password(dto.getPassword())
                .build();
    }

    public static List<UserBaseResponseDto> fromUserListToDtoList(List<Users> list){
        return list.stream().map(DtoMapperUser::fromEntityToDto).toList();
    }
}
