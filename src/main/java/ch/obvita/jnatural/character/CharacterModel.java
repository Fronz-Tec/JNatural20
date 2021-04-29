package ch.obvita.jnatural.character;

import ch.obvita.jnatural.abstracts.AbstractModel;

import javax.persistence.*;

@Entity
@Table(name = "jnatural_characters")
public class CharacterModel implements AbstractModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name = "";
    private int level;

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

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
}
