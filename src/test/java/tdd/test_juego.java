package tdd;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class test_juego {

    private Juego juego;

    @BeforeAll
    public void setUp() throws Exception{
        juego = new Juego();
    }

    @Test
    public void testGuterGame() throws Exception {
        rollMany(28,0);
        assertEquals(0, Juego.score());
    }
    @Test
    public void testAllOnes() throws Exception{
        rollMany(28,1);
        assertEquals(20, Juego.score());
    }

    @Test
    public void testOneSpare() throws Exception{
        rollSpare();
        juego.roll(3);
        rollMany(17,0);
        assertEquals(16, juego.score());
    }
    @Test
    public void testOneStrike() throws Exception {
        juego.roll(10);
        juego.roll(3);
        juego.roll(4);
        rollMany(16, 0);
        assertEquals(24, juego.score());
    }
    @Test
    public void testPerfectGame() throws Exception {
        rollMany(12, 10);
        assertEquals(300, juego.score());
    }
    private void rollMany(int n, int pins){
        for (int i = 0; i < n; i++) {
            juego.roll(pins);
        }
    }
    private void rollSpare(){
        juego.roll(5);
        juego.roll(5);
    }
}