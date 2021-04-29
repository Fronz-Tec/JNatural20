package ch.obvita.jnatural.security.user;

import ch.obvita.jnatural.campaign.CampaignModel;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class UserRepo {

    @PersistenceContext
    EntityManager entityManager;


    public UserModel getByName(String username){
        Query q = entityManager.createQuery("SELECT user from UserModel user where user.username = :username");


        q.setParameter("username",username);

        List<UserModel> users = q.getResultList();

        if(users.size()>0){
            return users.get(0);
        }

        return null;

    }


    public UserModel getCurrentUser(){

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();


        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            String currentUserName = authentication.getName();
            UserModel user = this.getByName(currentUserName);

            return  user;
        }

        return null;

    }

}
