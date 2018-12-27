package com.kabir.huiping.socketdemo;

import java.io.DataOutputStream;
import java.util.Random;

public class FrameSendThread extends Thread {
    private FrameCallBack cb;

    public FrameSendThread(FrameCallBack cb) {
        this.cb = cb;
    }

    @Override
    public void run() {
        try {
            cb.getLock().lock();
            cb.getC().await();
            cb.getLock().unlock();

            System.out.println(cb.getClient().isInputShutdown());
            DataOutputStream dos = new DataOutputStream(cb.getClient().getOutputStream());
            byte[] a = new byte[4];
            Random rad = new Random();
            rad.nextBytes(a);
            FramePacket fp = new FramePacket(cb.isFlags(), FrameMagic.KEY_MAGIC, FrameId.DATA_ID, a.length, a);
            fp.dataOutput(dos);
            System.out.println(fp);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}


