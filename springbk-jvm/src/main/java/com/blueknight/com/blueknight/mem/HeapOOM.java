package com.blueknight.com.blueknight.mem;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by liuyang on 2017/9/11.
 * vm args -Xms20M -Xmx20M -XX:+HeapDumpOnOutOfMemoryError
 */
public class HeapOOM {


    static class OOMObject{

    }
    public static void main(String[] args) {

        List<OOMObject> list =new ArrayList<OOMObject>();
        while (true){
            try {
                Thread.sleep(100l);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            list.add(new OOMObject());
        }
    }
}
