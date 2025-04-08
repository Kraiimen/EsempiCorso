package org.generation.italy.gryffindor.parkingProject.parking;

public abstract class Car implements Vehicle{
    private boolean isOn;
    private boolean isHandBrakeOn;

    public Car(){
        isOn = false;
        isHandBrakeOn = true;
    }

    @Override
    public void startEngine() {
        if(isOn == false){
            changeEngineState("accensione");
        }
    }
    @Override
    public void turnOffEngine() {
        if(isOn){
            changeEngineState("spegnimento");
        }
    }

    private void changeEngineState(String message){
        System.out.println(message);
        isOn = !isOn;
        useHandBrake();
        System.out.println();
    }

    public void useHandBrake(){     //al momento la logica di isHandBrakeOn non è gestita
        isHandBrakeOn = !isHandBrakeOn;
        if (isHandBrakeOn){
            System.out.println("ho messo il freno a mano");
        }else{
            System.out.println("ho tolto il freno a mano");
        }
    }

    public boolean getIsOn(){
        return isOn;
    }
    public boolean getIsHandBrakeOn(){
        return isHandBrakeOn;
    }
}
