package com.blueknight.zookeeper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

/**
 * Created by liuyang on 2017/8/21.
 */
public class DistributedLockImpl implements DistributedLock {

    private static final Logger LOG = LoggerFactory.getLogger(DistributedLockImpl.class);

    //private final Zookeeper

    @Override
    public void lock() throws LockingException {

    }

    @Override
    public boolean tryLock(Long timeout, TimeUnit unit) {
        return false;
    }

    @Override
    public void unlock() throws LockingException {

    }
}
