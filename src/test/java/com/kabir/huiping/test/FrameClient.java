package com.kabir.huiping.test;

import com.kabir.huiping.socketdemo.FrameId;
import com.kabir.huiping.socketdemo.FrameMagic;
import com.kabir.huiping.socketdemo.FramePacket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;

public class FrameClient {
    public static void main(String[] args) {
        try {
            Socket s = new Socket();
            s.connect(new InetSocketAddress("localhost",  12345));
//            s.connect(new InetSocketAddress("10.239.133.152",  12345));
            byte[] a = {(byte)'M',2};
            FramePacket fp = new FramePacket(true, FrameMagic.KEY_MAGIC, FrameId.KEY_ID, a.length, a);
            DataOutputStream dos = new DataOutputStream(s.getOutputStream());
            fp.dataOutput(dos);
            dos.flush();
            fp.setId(FrameId.EXIT_ID);
            fp.dataOutput(dos);
            s.shutdownOutput();
            DataInputStream dis = new DataInputStream(s.getInputStream());
            fp.parse(dis);
            System.out.println(fp);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
