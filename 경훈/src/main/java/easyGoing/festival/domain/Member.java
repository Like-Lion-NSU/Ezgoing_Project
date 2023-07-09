package easyGoing.festival.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
@NoArgsConstructor
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long id;

    private String name;
    private String password;
    private String location;
    private LocalDate date;

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<Festival> festivals = new ArrayList<>();

    public Member(String name, String password, String location, LocalDate date) {
        this.name = name;
        this.password = password;
        this.location = location;
        this.date = date;
    }
}
