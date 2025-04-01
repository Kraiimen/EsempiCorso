package org.generation.italy.gryffindor.parkingProject.parking;

public abstract class MotorCycle implements Vehicle {
    private boolean isOn;
    private boolean isKickStandingOn;

    public MotorCycle(){
        isOn = false;
        isKickStandingOn = true;
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
        useKickStanding();
        System.out.println();
    }
    public void useKickStanding(){     //al momento la logica di isKickStandingOn non è gestita
        isKickStandingOn = !isKickStandingOn;
        if (isKickStandingOn){
            System.out.println("ho messo il cavalletto");
        }else{
            System.out.println("ho tolto il cavalletto");
        }
    }

    public boolean getIsOn(){
        return isOn;
    }
    public boolean getKickStandingOn(){
        return isKickStandingOn;
    }
}
