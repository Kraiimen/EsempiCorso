package org.generation.italy.capstoneProject.models.npc;

public abstract class NPC {
    protected String nome;
    protected int hp;
    protected int str;
    protected boolean isHostile;

    // COSTRUTTORE
    public NPC(String nome, int hp, int str, boolean isHostile) {
        this.nome = nome;
        this.hp = hp;
        this.str = str;
        this.isHostile = isHostile;
    }

    // METODI
    public String getNome() {
        return nome;
    }

    public boolean isHostile() {
        return isHostile;
    }

    public abstract void takeAction();

    public void talk() {
        System.out.println(nome + " says: Hello adventurer.");
    }
}

