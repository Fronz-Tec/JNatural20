package ch.obvita.jnatural.campaign;

import ch.obvita.jnatural.security.user.UserModel;
import ch.obvita.jnatural.security.user.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class CampaignService {

    @Autowired
    CampaignRepo repo;

    @Autowired
    private UserRepo userRepo;

    public List<CampaignModel> getList(){


        List<CampaignModel> ret = null;
        try {
            ret = repo.getAll();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return ret;
    }

    public CampaignModel save(CampaignModel campaignModel){

        repo.save(campaignModel);

        return campaignModel;

    }

    public CampaignUserModel save(CampaignUserModel campaignUserModel){

        repo.save(campaignUserModel);

        return campaignUserModel;

    }

}