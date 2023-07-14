package com.example.demo.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter

public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long member_id;

    private String name;
    private int password;
    private LocalDate m_date;
    private String m_location;

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<Festival> festivals = new ArrayList<>();

    @Builder
    public Member(String userName, int password, String location, LocalDate date) {
        this.name = name;
        this.password = password;
        this.m_location = location;
        this.m_date = date;
    }

    public Member() {

    }
}
