package easyGoing.festival.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

import static jakarta.persistence.FetchType.LAZY;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Festival {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "festival_id")
    private Long id;

    private String fe_name;
    private String fe_location;
    private LocalDate fe_date;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    public Festival(String fe_name, String fe_location, LocalDate fe_date) {
        this.fe_name = fe_name;
        this.fe_location = fe_location;
        this.fe_date = fe_date;
    }

    //==연관관계 메서드==//
    public void setMember(Member member) {
        this.member = member;
        member.getFestivals().add(this);
    }
}
