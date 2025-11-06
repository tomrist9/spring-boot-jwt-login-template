package com.walletwave.jwtlogintemplate.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;



public record LoginResponseDTO(String status, String jwtToken) {

}