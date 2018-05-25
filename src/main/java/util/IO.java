package util;

import java.io.File;
import java.io.IOException;

import static java.lang.String.format;

public class IO {

    /**
     * Prints the given String or Object convertible to String with args filling its formatting arguments.
     * @param obj
     * @param args If not given, obj will be printed as is, without filling in "%s" etc.
     */
    public static void printf(Object obj, Object... args) {
        if((args != null) && (args.length == 0)) {
            System.out.println(obj);
        } else {
            System.out.println(format(obj.toString(), args));
        }
    }

    public static String read(File file) throws IOException {
        return org.apache.commons.io.FileUtils.readFileToString(file, (String) null);
    }
}
