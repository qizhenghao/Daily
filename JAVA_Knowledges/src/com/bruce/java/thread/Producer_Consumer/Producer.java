package com.bruce.java.thread.Producer_Consumer;

/**
 * Created by qizhenghao on 17/5/18.
 */
public class Producer extends Thread {

    private AbstractStorage storage;

    private int produceNum;
    private boolean isStop = false;

    public Producer(AbstractStorage storage, int produceNum) {
        if (storage == null || produceNum < 0)
            throw new IllegalArgumentException("storage is null || produceNum < 0");
        this.storage = storage;
        this.produceNum = produceNum;
    }

    @Override
    public void run() {
        super.run();
        while (!isStop)
            storage.produce(produceNum);
    }

    public AbstractStorage getStorage() {
        return storage;
    }

    public void setStorage(AbstractStorage storage) {
        this.storage = storage;
    }

    public int getProduceNum() {
        return produceNum;
    }

    public void setProduceNum(int produceNum) {
        this.produceNum = produceNum;
    }

    public boolean isStop() {
        return isStop;
    }

    public void setStop(boolean stop) {
        isStop = stop;
    }
}
