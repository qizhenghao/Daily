package com.bruce.java.thread.Producer_Consumer;

/**
 * Created by qizhenghao on 17/5/18.
 */
public class Consumer extends Thread {

    private AbstractStorage storage;

    private int consumeNum;

    private boolean isStop = false;

    public Consumer(AbstractStorage storage, int consumeNum) {
        if (storage == null || consumeNum < 0)
            throw new IllegalArgumentException("storage is null || consumeNum < 0");
        this.storage = storage;
        this.consumeNum = consumeNum;
    }

    @Override
    public void run() {
        super.run();
        while (!isStop)
            storage.consume(consumeNum);
    }

    public AbstractStorage getStorage() {
        return storage;
    }

    public void setStorage(AbstractStorage storage) {
        this.storage = storage;
    }

    public int getConsumeNum() {
        return consumeNum;
    }

    public void setConsumeNum(int consumeNum) {
        this.consumeNum = consumeNum;
    }

    public boolean isStop() {
        return isStop;
    }

    public void setStop(boolean stop) {
        isStop = stop;
    }
}
