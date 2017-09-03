package test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

public class HashMapTest {
	/**
     * The default initial capacity - MUST be a power of two.
     */
    static final int DEFAULT_INITIAL_CAPACITY = 1 << 4; // aka 16

    /**
     * The maximum capacity, used if a higher value is implicitly specified
     * by either of the constructors with arguments.
     * MUST be a power of two <= 1<<30.
     */
    static final int MAXIMUM_CAPACITY = 1 << 30;
	static final int tableSizeFor(int cap) {
		int n = cap - 1;
		n |= n >>> 1;
		n |= n >>> 2;
		n |= n >>> 4;
		n |= n >>> 8;
		n |= n >>> 16;
		return (n < 0) ? 1 : (n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(1<<10);
		System.out.println(1<<12);
		System.out.println(1<<16);
		System.out.println(1<<18);
		System.out.println(1<<19);
		System.out.println(1<<20);
		System.out.println(1<<21);
		
		int s = tableSizeFor(1024);
		System.out.println(s);
		AtomicInteger a = new AtomicInteger(0);
		ArrayList<Object> array = null;
		ConcurrentHashMap<String,Object> conMap = new ConcurrentHashMap<String, Object>();
		Boolean boolVar;
		ThreadLocal<Integer> local = new ThreadLocal<Integer>();
		LinkedList<Object> list = null;
		TreeMap<String,String> tree = null;
		ClassLoader cl = null;
		AtomicLong al = null;
	}

}
