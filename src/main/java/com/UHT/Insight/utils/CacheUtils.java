package com.UHT.Insight.utils;

import java.io.ByteArrayOutputStream;
import java.io.ObjectOutputStream;

public class CacheUtils {
    public static byte[] obj2byte(Object obj) throws Exception {
        byte[] ret = null;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream out = new ObjectOutputStream(baos);
        out.writeObject(obj);
        out.close();
        ret = baos.toByteArray();
        baos.close();
        return ret;
    }
}
