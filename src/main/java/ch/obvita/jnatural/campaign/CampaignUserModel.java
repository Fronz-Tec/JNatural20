package ch.obvita.jnatural.campaign;

import ch.obvita.jnatural.abstracts.AbstractModel;
import ch.obvita.jnatural.security.user.UserModel;

import javax.persistence.*;


@Table(name = "jnatural_campaign_user")
@Entity
public class CampaignUserModel implements AbstractModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne
    private UserModel user;

//    private boolean trolling = false;

    public UserModel getUser() {
        return user;
    }

    public void setUser(UserModel user) {
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

//    public boolean isTrolling() {
//        return trolling;
//    }
//
//    public void setTrolling(boolean trolling) {
//        this.trolling = trolling;
//    }
}
