package com.company.menumaker.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BaseUserRequest {
    private String email;
    private String password;
    private String phone;
    private Integer state;
}
