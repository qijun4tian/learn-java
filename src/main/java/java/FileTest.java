package java;

import java.io.File;
import java.util.Arrays;
import java.util.regex.Pattern;

/**
 * Created by qijun123 on 2017/5/8.
 */

public class FileTest {
    public static void main(String[] args) {

        File path = new File("C:\\Users\\qijun123\\Desktop\\计算机语言常识");

        String[] fileList = path.list((a,b)-> {
            Pattern pattern = Pattern.compile(".*txt.*");
            return pattern.matcher(b).matches();

        });
        Arrays.stream(fileList).forEach(System.out::println);

    }
}
