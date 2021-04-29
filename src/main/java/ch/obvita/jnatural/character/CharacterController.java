package ch.obvita.jnatural.character;

import ch.obvita.jnatural.npc.NPCService;
import ch.obvita.jnatural.npc.NpcModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@EnableAutoConfiguration
@PreAuthorize("hasRole('ROLE_USER')")
public class CharacterController {

    @Autowired
    CharacterService service;

    @GetMapping("/character")
    private String getNPC(Model model){

        model.addAttribute("charactermodel", new CharacterModel());

        return "character";
    }

    @PostMapping("/character")
    public String postNPC (CharacterModel characterModel, Model model){


        model.addAttribute("charactermodel", characterModel);

        return "character";

    }
}
