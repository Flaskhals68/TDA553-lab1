package main;
import java.awt.*;

import org.junit.Test;

public class Saab95 extends Car{

    public boolean turboOn;
    
    public Saab95(double x, double y) {
        super(x, y, 4, 125, Color.red, "Saab95");
	    turboOn = false;
    }
    
    public void setTurboOn(){
	    turboOn = true;
    }

    public void setTurboOff(){
	    turboOn = false;
    }
    
    @Override
    protected double speedFactor(){
        double turbo = 1;
        if(turboOn) turbo = 1.3;
        return getEnginePower() * 0.01 * turbo;
    }

    @Override
    protected void incrementSpeed(double amount){
        double currentSpeed = getCurrentSpeed() + speedFactor() * amount;
        setCurrentSpeed(currentSpeed);
    }

    @Override
    protected void decrementSpeed(double amount){
        double currentSpeed = getCurrentSpeed() - speedFactor() * amount;
        setCurrentSpeed(currentSpeed);
    }
}