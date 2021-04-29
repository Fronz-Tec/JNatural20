package ch.obvita.jnatural.diceThrower;


import ch.obvita.jnatural.abstracts.AbstractModel;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "jnatural_dice_thrower")
public class DiceThrowerModel implements AbstractModel {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @ElementCollection
    @CollectionTable(
            name="jnatural_dice_thrower_result",
            joinColumns=@JoinColumn(name="dice_thrower_id")
    )
    private List<DiceThrowerResult> diceThrowerResultList = new ArrayList<>();

    private int diceSides = 20;

    private int diceAmount = 1;

    private int diceModifier = 0;

    @ColumnDefault(value = "false")
    private boolean calculateSum = false;


    public DiceThrowerModel() {

    }

    public int getDiceSides() {
        return diceSides;
    }

    public void setDiceSides(int diceSides) {
        this.diceSides = diceSides;
    }

    public int getDiceAmount() {
        return diceAmount;
    }

    public void setDiceAmount(int diceAmount) {
        this.diceAmount = diceAmount;
    }

    public int getDiceModifier() {
        return diceModifier;
    }

    public void setDiceModifier(int diceModifier) {
        this.diceModifier = diceModifier;
    }

    public boolean isCalculateSum() {
        return calculateSum;
    }

    public void setCalculateSum(boolean calculateSum) {
        this.calculateSum = calculateSum;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public List<DiceThrowerResult> getDiceThrowerResultList() {
        return diceThrowerResultList;
    }

    public void setDiceThrowerResultList(List<DiceThrowerResult> diceThrowerResultList) {
        this.diceThrowerResultList = diceThrowerResultList;
    }
}
