package main;
import java.awt.*;

public class Saab95 extends Car{

    private boolean turboOn;
    
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

    
}
