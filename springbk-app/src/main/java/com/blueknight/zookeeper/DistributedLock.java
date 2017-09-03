package com.blueknight.zookeeper;

import java.util.concurrent.TimeUnit;

/**
 * Created by liuyang on 2017/8/21.
 */
public interface DistributedLock {
    void lock() throws LockingException;

    boolean tryLock(Long timeout, TimeUnit unit);

    void unlock() throws LockingException;

    public static class LockingException extends RuntimeException{
        public LockingException(String message, Exception e) {
            super(message, e);
        }

        public LockingException(String message) {
            super(message);
        }
    }
}
