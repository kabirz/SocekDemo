package com.kabir.huiping.socketdemo;

import java.net.Socket;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class FrameCallBack {
    private Socket client;
    private boolean flags;
    private Condition c;
    private ReentrantLock lock;

    public boolean isFlags() {
        return flags;
    }

    public void setFlags(boolean flags) {
        this.flags = flags;
    }

    public Condition getC() {
        return c;
    }

    public void setC(Condition c) {
        this.c = c;
    }

    public ReentrantLock getLock() {
        return lock;
    }

    public void setLock(ReentrantLock lock) {
        this.lock = lock;
    }

    public Socket getClient() {
        return client;
    }

    public void setClient(Socket client) {
        this.client = client;
    }

    public FrameCallBack(Socket client) {
        flags = false;
        this.client = client;
        lock =  new ReentrantLock();
        c = lock.newCondition();
    }
}
