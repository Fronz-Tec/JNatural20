package ch.obvita.jnatural.npc;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Transactional //TODO: test import
@Service
public class NPCService  {

    @Autowired
    private NpcRepo repo;


    //Wäre hier ein Decoration Pattern nicht besser gewesen?
    private List<String> professions = new ArrayList<>(Arrays.asList(
            "Blacksmith","Beggar","Bard","Farmer","Butcher","Soldier","Guard","Knight","Magician"
    ));

    //Wäre hier ein Decoration Pattern nicht besser gewesen?
    private List<String> specialLook = new ArrayList<>(Arrays.asList(
            "Missing Teeth","Different Colored Eyes","Missing Arm","Missing Leg","Missing Eye","No Hair","Long Nose"
    ));


    public NpcModel generateRandom(){

        NpcModel ret = generateRandom(new NpcModel());



        return ret;

    }

    public NpcModel generateRandom(NpcModel model){

        generateName(model);
        generateAge(model);
        generateProfession(model);
        generateSpecial(model);

        repo.save(model);

        return model;
    }


    private void generateName(NpcModel model){

        //TODO: Rewrite in Java
         //Name is generated in JS on client-Side
         //generateNameFromList();

    }

    private void generateAge(NpcModel model){

        model.setAge((int)(Math.random() * 100) + 20);

    }

    private void generateProfession(NpcModel model){

        int index = (int)(Math.random() * professions.size());

        model.setProfession(professions.get(index));

    }

    private void generateSpecial(NpcModel model){

        int index = (int)(Math.random() * specialLook.size());

        model.setSpecialLook(specialLook.get(index));

    }

}
