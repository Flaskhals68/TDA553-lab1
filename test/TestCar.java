package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import org.junit.Test;

import main.Car;
import main.Saab95;
import main.Volvo240;

public class TestCar {
    @Test
    public void move() {
        Volvo240 volvo = new Volvo240(0, 0);
        // volvo.setCurrentSpeed(1);
        volvo.gas(1);
        volvo.move();
        System.out.println(volvo.getDirection());
        assertEquals(1.25, volvo.getY(), 0.01);

        volvo.turnRight();
        volvo.move();
        assertEquals(1.25, volvo.getX(), 0.01);

        Saab95 saab = new Saab95(0, 0);
        saab.gas(0.5);
        saab.turnRight();
        saab.turnRight();
        saab.move();
        assertEquals(-0.625, saab.getY(), 0.001);

        saab.turnRight();
        saab.move();
        assertEquals(-0.625, saab.getX(), 0.001);
    }
    
    public void turnRight() {
        Volvo240 volvo = new Volvo240(0, 0);
        volvo.turnRight();
        assertEquals(Car.Direction.RIGHT, volvo.getDirection());
        volvo.turnRight();
        assertEquals(Car.Direction.DOWN, volvo.getDirection());
        volvo.turnRight();
        assertEquals(Car.Direction.LEFT, volvo.getDirection());
        volvo.turnRight();
        assertEquals(Car.Direction.UP, volvo.getDirection());
    }

    @Test
    public void turnLeft() {
        Volvo240 volvo = new Volvo240(0, 0);
        volvo.turnLeft();
        assertEquals(Car.Direction.LEFT, volvo.getDirection());
        volvo.turnLeft();
        assertEquals(Car.Direction.DOWN, volvo.getDirection());
        volvo.turnLeft();
        assertEquals(Car.Direction.RIGHT, volvo.getDirection());
        volvo.turnLeft();
        assertEquals(Car.Direction.UP, volvo.getDirection());
    }
    
    @Test
    public void brake(){
        Volvo240 volvo = new Volvo240(0, 0);
        volvo.gas(1);
        volvo.brake(1);
        assertEquals(0, volvo.getCurrentSpeed(), 0.01);

        Saab95 saab = new Saab95(0, 0);
        saab.gas(0.5);
        saab.brake(0.25);
        assertEquals(0.3125, saab.getCurrentSpeed(), 0.0001);
    }
    
    @Test
    public void gas() {
        Volvo240 volvo = new Volvo240(0, 0);
        volvo.gas(1);
        assertEquals(1.25, volvo.getCurrentSpeed(), 0.01);

        Saab95 saab = new Saab95(0, 0);
        saab.gas(0.75);
        assertEquals(0.9375, saab.getCurrentSpeed(), 0.0001);

        assertThrows(IllegalArgumentException.class,
            ()->{
            volvo.gas(-1);
            });
        assertThrows(IllegalArgumentException.class,
            ()->{
            saab.gas(-1);
            });
    }
}
