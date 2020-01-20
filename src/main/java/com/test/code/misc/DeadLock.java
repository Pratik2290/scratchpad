package com.test.code.misc;

public class DeadLock {

    static class Animal {

        private final String name;

        public Animal(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public synchronized void bite(Animal bitter) {
            //synchronized (this.name) {
            System.out.format("%s:%s has bitten me!%n", this.name, bitter.name);
            bitter.runAway(this);
            //}
        }

        private synchronized void runAway(Animal bitter) {
            System.out.format("%s:%s has run away! I am still hundry%n", this.name, bitter.name);
        }
    }

    final public static void main(String[] args) throws InterruptedException {
        final Animal wolf = new Animal("wolf");
        final Animal fox = new Animal("fox");

        Object mutex = new Object();

        Thread thread1 = new Thread(new Runnable() {

            @Override
            public void run() {
                synchronized (mutex) {
                    try {
                        wolf.bite(fox);
                        mutex.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                        mutex.notify();
                    }
                }

            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {

                synchronized (mutex) {
                    try {
                        fox.bite(wolf);
                        mutex.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                        mutex.notify();
                    }
                }


            }
        });

        thread1.start();
        thread2.start();
    }
}
