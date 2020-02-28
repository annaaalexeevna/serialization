package ru.gasu.annaaalexeevna.synchronization;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public class Singlton {
    private static final AtomicInteger counter = new AtomicInteger(0);
    final int id = 0;

    private static AtomicReference<Singlton> INSTANCE;

    public static Singlton getInstance() {
        if(INSTANCE.compareAndSet(null, new Singlton())) {
            synchronized (Singlton.class) {
                if(INSTANCE.compareAndSet(null, new Singlton())) {

                }
            }
        }
        return Singlton.INSTANCE;
    }
}
