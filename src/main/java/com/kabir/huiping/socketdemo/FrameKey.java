package com.kabir.huiping.socketdemo;

public class FrameKey implements IFrameEvent {
    private char value;
    @Override
    public void parse(byte[] data) {
       value = (char)data[0];
    }

    @Override
    public int doWork() {
        System.out.println("The key is " + value);
        return 0;
    }
}
