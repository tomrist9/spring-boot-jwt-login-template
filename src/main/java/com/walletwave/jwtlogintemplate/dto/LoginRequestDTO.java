package com.walletwave.jwtlogintemplate.dto;

import lombok.Getter;
import lombok.Setter;



public record LoginRequestDTO(String username, String password) {

}