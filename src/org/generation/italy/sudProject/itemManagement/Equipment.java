package org.generation.italy.sudProject.itemManagement;

import org.generation.italy.sudProject.items.Item;

public class Equipment{
    private Item head = null;
    private Item body = null;
    private Item arms = null;
    private Item legs = null;
    private Item rightHand = null;
    private Item leftHand = null;

    // /--METHODS--/
    public void showEquip(){
        System.out.println("Equipaggiamento attuale:");
        System.out.print("HEAD:"+head+"\n"+
                         "BODY:"+body+"\n"+
                         "ARMS:"+arms+"\n"+
                         "LEGS:"+legs+"\n"+
                         "RIGHT HAND:"+rightHand+"\n"+
                         "LEFT HAND:"+leftHand+"\n");
    }
    // /--GETTER-&-SETTER--/

    public Item getHead() {
        return head;
    }

    public void setHead(Item head) {
        this.head = head;
    }

    public Item getBody() {
        return body;
    }

    public void setBody(Item body) {
        this.body = body;
    }

    public Item getArms() {
        return arms;
    }

    public void setArms(Item arms) {
        this.arms = arms;
    }

    public Item getLegs() {
        return legs;
    }

    public void setLegs(Item legs) {
        this.legs = legs;
    }

    public Item getRightHand() {
        return rightHand;
    }

    public void setRightHand(Item rightHand) {
        this.rightHand = rightHand;
    }

    public Item getLeftHand() {
        return leftHand;
    }

    public void setLeftHand(Item leftHand) {
        this.leftHand = leftHand;
    }
}
