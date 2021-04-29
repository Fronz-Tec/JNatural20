package ch.obvita.jnatural.diceThrower;

import javax.persistence.Embeddable;

@Embeddable
public class DiceThrowerResult {

    //Is the raw value of the rolled dice
    private  int raw = 0;

    //Is the modified value of the rolled dice
    private int mod = 0;

    public DiceThrowerResult() {
    }

    public DiceThrowerResult(int raw, int mod) {
        this.raw = raw;
        this.mod = mod;
    }

    public int getRaw() {
        return raw;
    }

    public void setRaw(int raw) {
        this.raw = raw;
    }

    public int getMod() {
        return mod;
    }

    public void setMod(int mod) {
        this.mod = mod;
    }
}
