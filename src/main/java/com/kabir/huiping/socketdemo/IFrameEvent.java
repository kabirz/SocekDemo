package com.kabir.huiping.socketdemo;

public interface IFrameEvent {
    public void parse(byte[] data);
    public int doWork();
}
