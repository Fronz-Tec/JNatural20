package ch.obvita.jnatural.security.user;

import ch.obvita.jnatural.diceThrower.DiceThrowerResult;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Embeddable;

@Embeddable
public class UserRoleModel {

String roleName;


    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

}
