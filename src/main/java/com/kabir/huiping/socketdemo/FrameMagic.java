package com.kabir.huiping.socketdemo;

public final class FrameMagic {
    public final static int KEY_MAGIC = 0xdeaddead;
    public final static int DATA_MAGIC = 0xdeaddaed;
    public final static int PYTHON_MAGIC = 0x12345678;

    public static boolean isValidMagic(int magic) {
        switch (magic) {
            case KEY_MAGIC:
            case DATA_MAGIC:
            case PYTHON_MAGIC:
                return true;
            default:
                return false;
        }
    }
}
