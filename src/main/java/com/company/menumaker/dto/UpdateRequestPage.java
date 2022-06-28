package com.company.menumaker.dto;


import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class UpdateRequestPage extends BasePageRequest{
    private Integer id;

}
