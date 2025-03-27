package org.generation.italy.gryffindor.mud.game;

public class Npc extends Entity{
    // /-----------/ ATTRIBUTI (FIELDS) /-----------/
    private int earnedXP;
    private boolean canBeAttacked;
    private NpcInstruction instruction;

    // /-----------/ CONSTRUCTORS /-----------/
    public Npc(String name, int maxHealthPoint, int damage, int xp, boolean canBeAttacked, NpcInstructions instructions) {
        super(name, maxHealthPoint, damage);
        earnedXP = xp;
        this.canBeAttacked = canBeAttacked;
        this.instruction = instructions;
    }

    // /-----------/ METHODS /-----------/
    public void giveInstructions() {
        System.out.println(instruction.name());
    }


    // /-----------/ METHODS - GETTER & SETTER /-----------/
    public int getEarnedXP() {
        return earnedXP;
    }
    public void setEarnedXP(int earnedXP) {
        if (earnedXP >= 0) {
            this.earnedXP = earnedXP;
        }
    }
    public boolean getCanBeAttacked() {
        return canBeAttacked;
    }
    public void setCanBeAttacked(boolean canBeAttacked) {
        this.canBeAttacked = canBeAttacked;
    }
    public NpcInstruction getInstruction() {
        return instruction;
    }
    public void setInstruction(NpcInstruction instruction) {
        this.instruction = instruction;
    }
}
