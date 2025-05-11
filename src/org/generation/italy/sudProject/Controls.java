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
    QUIT("QUIT"),
    REST("REST");

    private final String value;

    Controls(String value){
        this.value = value;
    }
    public String getValue() {
        return value;
    }
}

