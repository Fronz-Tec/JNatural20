package ch.obvita.jnatural.campaign;

import ch.obvita.jnatural.security.SecurityIUserController;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@EnableAutoConfiguration
public class CampaignController  {

    @Autowired
    private static CampaignService ss;

    @Autowired
    CampaignService service;

    @GetMapping("/campaign")
    private String getCampaign(Model view){

        List<CampaignModel> campaign = ss.getList();

        CampaignController.addCampaignList(view,campaign);

        view.addAttribute("campaignmodel", new CampaignModel());

        return "campaign";
    }

    @PostMapping("/campaign")
    private String postCampaign(CampaignModel campaignModel, Model view){
        CampaignModel campaign = service.save(campaignModel);

        view.addAttribute("campaignmodel", campaign);

        List<CampaignModel> campaignl = service.getList();

        CampaignController.addCampaignList(view,campaignl);

        return "campaign";
    }


    public static void addCampaignList(Model view, List<CampaignModel> campaignModels){


        view.addAttribute("campaignList", campaignModels);

    }



}
