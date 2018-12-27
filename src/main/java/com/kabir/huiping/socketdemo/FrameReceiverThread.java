package com.kabir.huiping.socketdemo;

import java.io.DataInputStream;
import java.io.IOException;

public class FrameReceiverThread extends Thread {
    private FrameCallBack cb;

    public FrameReceiverThread(FrameCallBack cb) {
        this.cb = cb;
    }

    @Override
    public void run() {
        while (true) {
            try {
                DataInputStream dis = new DataInputStream(cb.getClient().getInputStream());
                FramePacket fp = new FramePacket();
                fp.parse(dis);
                fp.handle();
                System.out.println(fp);
                if (fp.getId() == FrameId.EXIT_ID) {
                    cb.setFlags(fp.isByteorder());
                    cb.getLock().lock();
                    cb.getC().signal();
                    cb.getLock().unlock();
                    break;
                }
            } catch (IOException e) {
                e.printStackTrace();
                return;
            }

        }
    }
}
