package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import org.junit.Test;

import main.Car;
import main.Saab95;
import main.Volvo240;

public class TestCar {
    @Test
    public void volvo_should_move_to_coordiantes() {
        Volvo240 volvo = new Volvo240(0, 0);
        // volvo.setCurrentSpeed(1);
        volvo.gas(1);
        volvo.move();
        System.out.println(volvo.getDirection());
        assertEquals(1.25, volvo.getY(), 0.01);
        assertEquals(0, volvo.getX(), 0.01);

        volvo.turnRight();
        volvo.move();
        assertEquals(1.25, volvo.getY(), 0.01);
        assertEquals(1.25, volvo.getX(), 0.01);
    }

    @Test
    public void saab_should_move_to_coordinates() {
        Saab95 saab = new Saab95(0, 0);
        saab.gas(0.5);
        saab.turnRight();
        saab.turnRight();
        saab.move();
        assertEquals(-0.625, saab.getY(), 0.001);
        assertEquals(0, saab.getX(), 0.001);

        saab.turnRight();
        saab.move();
        assertEquals(-0.625, saab.getY(), 0.001);
        assertEquals(-0.625, saab.getX(), 0.001);
    }
    
    public void volvo_should_face_correct_direction_after_each_right_turn() {
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
    public void volvo_should_face_correct_direction_after_each_left_turn() {
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
    public void volvo_should_stop_completely_after_braking() {
        Volvo240 volvo = new Volvo240(0, 0);
        volvo.gas(1);
        volvo.brake(1);
        assertEquals(0, volvo.getCurrentSpeed(), 0.01);
    }

    @Test
    public void saab_should_have_correct_speed_after_braking() {
        Saab95 saab = new Saab95(0, 0);
        saab.gas(0.5);
        saab.brake(0.25);
        assertEquals(0.3125, saab.getCurrentSpeed(), 0.0001);
    }
    
    @Test
    public void volvo_should_have_correct_speed_after_gassing() {
        Volvo240 volvo = new Volvo240(0, 0);
        volvo.gas(1);
        assertEquals(1.25, volvo.getCurrentSpeed(), 0.01);
    }

    @Test
    public void saab_should_have_correct_speed_after_gassing() {
        Saab95 saab = new Saab95(0, 0);
        saab.gas(0.75);
        assertEquals(0.9375, saab.getCurrentSpeed(), 0.0001);
    }

    @Test
    public void volvo_should_throw_exception_when_given_negative_argument() {
        Volvo240 volvo = new Volvo240(0, 0);
        assertThrows(IllegalArgumentException.class,
            ()->{
            volvo.gas(-1);
            });
    }

    @Test
    public void saab_should_throw_exception_when_given_negative_argument() {
        Saab95 saab = new Saab95(0, 0);
        assertThrows(IllegalArgumentException.class,
            ()->{
            saab.gas(-1);
            });
    }
}
