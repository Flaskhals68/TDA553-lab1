package test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import main.Car;
import main.Saab95;
import main.Volvo240;
import main.Car.Direction;

public class TestCar {

    // private enum Direction {
    //     UP,
    //     LEFT,
    //     RIGHT,
    //     DOWN,
    // }

    @Test
    public void move() {
        Volvo240 volvo = new Volvo240(0, 0);
        volvo.setCurrentSpeed(1);
        volvo.move();
        System.out.println(volvo.getDirection());
        assertEquals(1, volvo.getY(), 0.01);

        volvo.setDierction(Car.Direction.RIGHT);
        volvo.move();
        assertEquals(1, volvo.getX(), 0.01);

        Saab95 saab = new Saab95(0, 0);
        saab.setCurrentSpeed(1);
        saab.setDierction(Car.Direction.DOWN);
        saab.move();
        assertEquals(-1, saab.getY(), 0.01);

        saab.setDierction(Car.Direction.LEFT);
        saab.move();
        assertEquals(-1, saab.getX(), 0.01);
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
        volvo.setCurrentSpeed(1);
        volvo.brake(1);
        assertEquals(0, volvo.getCurrentSpeed(), 0.01);

        Saab95 saab = new Saab95(0, 0);
        saab.setCurrentSpeed(1);
        saab.brake(1);
        assertEquals(-0.25, saab.getCurrentSpeed(), 0.01);
    }
    
    @Test
    public void gas() {
        Volvo240 volvo = new Volvo240(0, 0);
        volvo.setCurrentSpeed(1);
        volvo.gas(0.2);
        assertEquals(1.25, volvo.getCurrentSpeed(), 0.01);

        Saab95 saab = new Saab95(0, 0);
        saab.setCurrentSpeed(1);
        saab.gas(0.75);
        assertEquals(1.9375, saab.getCurrentSpeed(), 0.0001);
    }
}
