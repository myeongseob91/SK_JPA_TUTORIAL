package hellojpa.entity;

import javax.persistence.*;

@Entity
public class Member {

    @javax.persistence.Id @GeneratedValue
    private Long Id;
    private String name;
    private int age;

    @ManyToOne
    @JoinColumn(name="TEAM_ID")
    private Team team;

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }
}
