package org.generation.italy.gryffindor.mud.game;

public class Npc extends Entity{
    private int earnedXP;
    private boolean canBeAttacked;
    private NpcInstruction instruction;


    public void giveInstructions() {
        System.out.println(instruction.name());
    }



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
