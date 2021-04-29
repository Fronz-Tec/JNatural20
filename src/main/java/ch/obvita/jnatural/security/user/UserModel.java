package ch.obvita.jnatural.security.user;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "jnatural_user")
public class  UserModel {

    String password;
    boolean enabled;

    @Id
    String username;

    @ElementCollection
    @CollectionTable(
            name="jnatural_user_role",
            joinColumns=@JoinColumn(name="username")
    )
    private List<UserRoleModel> userRoleList = new ArrayList<>();


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }



    public List<UserRoleModel> getUserRoleList() {
        return userRoleList;
    }

    public void setUserRoleList(List<UserRoleModel> userRoleList) {
        this.userRoleList = userRoleList;
    }
}
