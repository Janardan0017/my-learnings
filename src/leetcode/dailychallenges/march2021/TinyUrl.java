package leetcode.dailychallenges.march2021;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

/**
 * Copyright © FieldCircle. All rights Reserved. by Jovanta Consultants Private Limited.
 * <p>
 * Created by emp350 on 15/03/21
 */
public class TinyUrl {

    public static void main(String[] args) {
        byte[] encode = Base64.getEncoder().encode("http://localhost:8080/login".getBytes(StandardCharsets.UTF_8));
        String str = encode.toString();
        System.out.println(str);
        System.out.println(Base64.getDecoder().decode(str));
    }
}
