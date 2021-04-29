package ch.obvita.jnatural.npc;



import ch.obvita.jnatural.abstracts.AbstractModel;

import javax.persistence.*;
import javax.validation.constraints.Min;

@Entity
@Table(name = "jnatural_npc")
public class NpcModel implements AbstractModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name = "";

    private int age = 0;

    private String specialLook = "None";

    private String profession  = "Testing";

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getSpecialLook() {
        return specialLook;
    }

    public void setSpecialLook(String specialLook) {
        this.specialLook = specialLook;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }
}
