package util;

import org.apache.commons.lang.SerializationUtils;

import java.io.Serializable;

public class Util {

    public static <T extends Serializable> T clone(T t) {
        return (T) SerializationUtils.clone(t);
    }
}
