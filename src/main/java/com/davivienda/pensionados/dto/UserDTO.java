package com.davivienda.pensionados.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * DTO para transferir información de usuario y roles
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    private String username;
    private String displayName;
    private String role;
    private String roleDisplayName;
    private List<String> permissions;
}
