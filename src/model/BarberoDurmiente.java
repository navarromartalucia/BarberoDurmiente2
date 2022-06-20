package model;

import static java.lang.Thread.sleep;
import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BarberoDurmiente {

    public static void main(String[] args) {
        Barbero barbero = new Barbero(false);
        for (int i = 0; i < 4; i++) {
            Cliente c = new Cliente( barbero);
            c.start();
        }
    }
}