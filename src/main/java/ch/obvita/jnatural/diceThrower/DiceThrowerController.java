package ch.obvita.jnatural.diceThrower;

import ch.obvita.jnatural.security.SecurityIUserController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.security.Principal;

@Controller
@EnableAutoConfiguration

public class DiceThrowerController extends SecurityIUserController {

    @Autowired
    DiceThrowerService diceThrowerService;

    @GetMapping("/dicethrower")
    public String getDiceThrower (Model model){

        model.addAttribute("dicethrower", new DiceThrowerModel());

        return "dicethrower";

    }


    @PostMapping("/dicethrower")
    public String postDiceThrower (DiceThrowerModel diceThrower, BindingResult result, Model model, Principal principal){

        diceThrower = diceThrowerService.throwDice(diceThrower);

        model.addAttribute("dicethrower", diceThrower);
        model.addAttribute("name", principal.getName());


        return "dicethrower";

    }


}
