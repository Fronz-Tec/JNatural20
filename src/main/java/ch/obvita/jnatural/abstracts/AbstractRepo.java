package ch.obvita.jnatural.abstracts;

import ch.obvita.jnatural.campaign.CampaignModel;
import ch.obvita.jnatural.security.user.UserModel;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class AbstractRepo {

    @PersistenceContext
    public EntityManager entityManager;

    public AbstractModel save(AbstractModel model) {

        if(model.getId() == null){
            entityManager.persist(model);
        }else{
            entityManager.merge(model);
        }


        return model;
    }



}
