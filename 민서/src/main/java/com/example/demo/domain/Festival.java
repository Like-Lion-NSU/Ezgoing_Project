//package com.example.demo.domain;
//
//import jakarta.persistence.*;
//import lombok.Getter;
//import lombok.Setter;
//
//import java.time.LocalDate;
//
//@Entity
//@Getter
//@Setter
//public
//class Festival{
//    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long fe_id;
//
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "m_id")
//    private User user;
//
//    private String fe_name;
//    private String fe_location;
//    private LocalDate fe_date;
//
//    public Festival(String name, String location, LocalDate date ){
//        fe_name = name;
//        fe_location = location;
//        fe_date = date;
//    }
//
//    public Festival() {
//
//    }
//
//    public void setUser(User user){
//        this.user = user;
//        user.getFestivals().add(this);
//    }
//}