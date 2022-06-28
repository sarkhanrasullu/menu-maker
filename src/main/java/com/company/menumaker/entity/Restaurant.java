package com.company.menumaker.entities;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "restaurant")
public class Restaurant implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "image")
    private String image;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "phone", nullable = false)
    private String phone;

    @Column(name = "address", nullable = false)
    private String address;

    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "qr_code")
    private String qrCode;

    @Column(name = "state", nullable = false)
    private Integer state;

}
