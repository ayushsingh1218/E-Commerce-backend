package com.Ecommerce.Signnup.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



    @Entity
    @Table(name="User")
    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    public class User {
    
        @Id
        @Column(name = "User_ID", length = 45 )
        @GeneratedValue(strategy = GenerationType.AUTO)
        private Long id;

        @Column(name = "User_name", length = 200)
        private String name;

        @Column(name = "Email", length = 200)
        private String email;

        @Column(name = "Password", length = 200)
        private String password;
    }

    

