package ch.obvita.jnatural.diceThrower;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class DiceThrowerService {

    @Autowired
    private DiceThrowerRepo repo;

    public DiceThrowerModel throwDice(DiceThrowerModel dice) {


        for (int i = 0; i < dice.getDiceAmount(); i++) {

            int raw = (int) (Math.random() * dice.getDiceSides()) + 1;

            int mod = raw + dice.getDiceModifier();

            dice.getDiceThrowerResultList().add(new DiceThrowerResult(raw, mod));

        }

        if (dice.isCalculateSum()) {
            int raw = 0;

            for (int i = 0; i < dice.getDiceThrowerResultList().size(); i++) {

                raw += dice.getDiceThrowerResultList().get(i).getRaw();

            }

            int mod = raw + dice.getDiceModifier();

            dice.getDiceThrowerResultList().add(new DiceThrowerResult(raw, mod));
        }

        repo.save(dice);

        return dice;
    }


}
