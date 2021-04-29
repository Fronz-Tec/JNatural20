package ch.obvita.jnatural.campaign;

import ch.obvita.jnatural.abstracts.AbstractModel;

import javax.persistence.*;
import java.util.Set;


@Table(name = "jnatural_campaign")
@Entity
public class CampaignModel implements AbstractModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name = "";

    @OneToMany
    private Set<CampaignUserModel> participants;

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

    public String toString() {
        return "Professor id: " + getId() + " name: " + getName();
    }

    public Set<CampaignUserModel> getParticipants() {
        return participants;
    }

    public void setParticipants(Set<CampaignUserModel> participants) {
        this.participants = participants;
    }
}
