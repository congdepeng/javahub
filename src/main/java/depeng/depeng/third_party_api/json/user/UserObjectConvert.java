package depeng.depeng.third_party_api.json.user;

import org.codehaus.jackson.map.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class UserObjectConvert {
    public static void main(String[] args) throws IOException {
        ObjectMapper mapper = new ObjectMapper(); // can reuse, share globally
        User user = mapper.readValue(new File("/home/depeng/github/javahub/java7_lang/src/main/resources/user.json"), User.class);
        System.out.println(user.getGender());
        System.out.println(user.getName());
        System.out.println(user.getUserImage());
    }
}
