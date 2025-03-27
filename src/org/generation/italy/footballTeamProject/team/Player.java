package org.generation.italy.footballTeamProject.team;

public class Player {
    private String name;
    private int goal;

    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    public int getGoal(){
        return goal;
    }
    public boolean setGoal(int goal){
        if(goal > 0) {
            this.goal = goal;
            return true;
        }
        return false;
    }
}

