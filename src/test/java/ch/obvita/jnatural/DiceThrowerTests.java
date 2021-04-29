package ch.obvita.jnatural;

import ch.obvita.jnatural.diceThrower.DiceThrowerModel;
import ch.obvita.jnatural.diceThrower.DiceThrowerResult;
import ch.obvita.jnatural.diceThrower.DiceThrowerService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DiceThrowerTests {

    @Autowired
    DiceThrowerService diceThrowerService;

    @Test
    public void rangeTest() {

        int range = 2;

        DiceThrowerModel throwerModel = new DiceThrowerModel();

        throwerModel.setDiceAmount(10);

        throwerModel.setDiceSides(range);

        throwerModel.setDiceModifier(3);

        throwerModel = diceThrowerService.throwDice(throwerModel);

        for (DiceThrowerResult res: throwerModel.getDiceThrowerResultList() ) {

            assertEquals(res.getMod(), res.getRaw() + throwerModel.getDiceModifier());

            assertTrue(res.getRaw() <= range);

            assertTrue(res.getRaw() >= 1);

        }

    }

}
