package com.dom.utils;

import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

/**
 * Created with IntelliJ IDEA.
 * Description:分布式锁的使用
 * User: chendom
 * Date: 2018-05-18
 * Time: 11:34
 */
public class RedissonUtil {
    private static final RedissonUtil util = new RedissonUtil();
    private static final TimeUnit DEFAULT_TIME_UNIT = TimeUnit.MILLISECONDS;
    private static final long DEFAULT_TIME_OUT = 5 * 1000;
    private static final Logger logger = LoggerFactory.getLogger(RedissonUtil.class);

    public static RedissonUtil getInstance() {
        return util;
    }

    /**
     * 获取分布式锁
     *
     * @param key 分布式锁的key值
     * @return 返回分布式锁
     */
    public RLock getRLock(String key) {
        RLock rLock = getRedissonClient().getLock(key);
        return rLock;
    }

    /**
     * 给分布式锁上锁
     *
     * @param key       key
     * @param leaseTime 超时时间
     * @param unit      时间单位
     */
    public void lock(String key, long leaseTime, TimeUnit unit) {
        RLock rlock = getRLock(key);
        rlock.lock(leaseTime, unit);
    }

    /**
     * 给分布式锁上锁，默认时间为5秒
     *
     * @param key key
     */
    public void lock(String key) {
        RLock rlock = getRLock(key);
        rlock.lock(DEFAULT_TIME_OUT, DEFAULT_TIME_UNIT);
    }

    /**
     * 给分布式锁上锁，默认时间为时间单位为毫秒
     *
     * @param key       key
     * @param leaseTime 超时时间
     */
    public void lock(String key, long leaseTime) {
        RLock rlock = getRLock(key);
        rlock.lock(leaseTime, DEFAULT_TIME_UNIT);
    }


    /**
     * 给分布式锁解锁。
     *
     * @param key key
     */
    public void unlock(String key) {
        RLock rlock = getRLock(key);
        rlock.unlock();
    }


    /**
     * 给分布式锁强制解锁
     *
     * @param key key
     */
    public void forceUnlock(String key) {
        RLock rlock = getRLock(key);
        rlock.forceUnlock();
    }

    /**
     * 尝试获取锁，如果获取到，返回true
     *
     * @param key       key
     * @param waitTime  最大等待时间
     * @param leaseTime 剩余时间
     * @param unit
     * @return
     */
    public boolean tryLock(String key, long waitTime, long leaseTime, TimeUnit unit) {
        RLock rLock = getRLock(key);
        try {
            return rLock.tryLock(waitTime, leaseTime, unit);
        } catch (InterruptedException e) {
            logger.error(e.getMessage(), e);
            return false;
        }
    }


    /**
     * 尝试获取锁，如果获取到，返回true
     *
     * @param key       key
     * @param waitTime  最大等待时间
     * @param leaseTime 剩余时间
     * @return
     */
    public boolean tryLock(String key, long waitTime, long leaseTime) {
        return this.tryLock(key, waitTime, leaseTime, DEFAULT_TIME_UNIT);
    }

    /**
     * 获取RedissonClient客户端
     *
     * @return
     */
    public RedissonClient getRedissonClient() {
        return SpringUtils.getBean("redissonClient", RedissonClient.class);
    }


}
