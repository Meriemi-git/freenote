package fr.aboucorp.freenote.utils;

import android.util.Log;

public abstract class BackgroundRunner {
    private final Object lock1 = new Object();
    private final Object lock2 = new Object();

    protected abstract void execute();

    public void start() {
        new Thread(() -> {
                try {
                    this.execute();
                } catch (Exception ex) {
                    Log.e("FreeNote", ex.getMessage());
                } finally {
                    synchronized (this.lock2) {
                        this.lock2.notify();
                    }
                }

            synchronized (this.lock2) {
                try {
                    this.lock2.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            synchronized (this.lock1) {
                this.lock1.notify();
            }
        }).start();
        synchronized (this.lock1) {
            try {
                this.lock1.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void startAsync() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    BackgroundRunner.this.execute();
                } catch (Exception ex) {
                    Log.e("FreeNote", ex.getMessage());
                    ex.printStackTrace();
                }
            }
        }).start();
    }
}
