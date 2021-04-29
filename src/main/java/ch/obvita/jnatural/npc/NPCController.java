package ch.obvita.jnatural.npc;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
@EnableAutoConfiguration
public class NPCController {

    @Autowired
    NPCService service;

    @GetMapping("/npc")
    private String getNPC(Model view){

        view.addAttribute("npcmodel", new NpcModel());

        return "npc";
    }

    @PostMapping("/npc")
    public String postNPC (NpcModel npcModel, BindingResult result, Model view){

        NpcModel npc = service.generateRandom(npcModel);

        view.addAttribute("npcmodel", npc);

        return "npc";

    }

}
