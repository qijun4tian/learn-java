package 其他;

/**
 * @author qijun
 * @Description
 * @Date 20:45 2022/5/29
 */
public class 验证IP地址 {
    public static String validIPAddress(String queryIP) {
        if (queryIP.length() == 0) {
            return "Neither";
        }

        if (queryIP.split("\\.").length == 4) {
            String[] strings = queryIP.split("\\.");
            for (String temp : strings) {
                if (temp.length() > 3) {
                    return "Neither";
                }
                for (int i = 0; i < temp.length(); i++) {
                    if (i == 0 && temp.length() > 1 && temp.charAt(i) == '0') {
                        return "Neither";
                    }
                    if (temp.charAt(i) < '0' || temp.charAt(i) > '9') {
                        return "Neither";
                    }
                }
                if (Integer.parseInt(temp) < 0 || Integer.parseInt(temp) > 255) {
                    return "Neither";
                }

            }
            return "IPv4";

        } else if (queryIP.split(":").length == 8) {
            String[] strings = queryIP.split(":");
            for (String temp : strings) {
                if (temp.length() == 0 || temp.length() > 4) {
                    return "Neither";
                }
                for (int i = 0; i < temp.length(); i++) {
                    if (!((temp.charAt(i) >= '0' && temp.charAt(i) <= '9')
                            || (temp.charAt(i) >= 'A' && temp.charAt(i) <= 'z'))) {
                        return "Neither";
                    }
                }

            }
            return "IPv6";
        } else {

            return "Neither";
        }
    }

    public static void main(String[] args) {
        System.out.println(validIPAddress("192.0.0.1"));
    }
}
