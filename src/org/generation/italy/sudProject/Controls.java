package org.generation.italy.sudProject;

import java.util.List;

public enum Controls {
    MOVE("MOVE"),
    ATTACK("ATTACK"),
    PICK_FROM_CORPSE("PICKFROMCORPSE"),
    PICK_UP("PICKUP"),
    BUY("BUY"),
    EAT("EAT"),
    EQUIP("EQUIP"),
    QUIT("QUIT");

    private final String string;

    Controls(String controlState){
        this.string = controlState;
    }
    public String getControlState() {
        return string;
    }
}

