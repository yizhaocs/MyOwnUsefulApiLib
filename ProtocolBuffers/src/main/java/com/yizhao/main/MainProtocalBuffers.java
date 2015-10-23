package main.java.com.yizhao.main;


import static com.yizhao.proto.PersonProto.Person;

public class MainProtocalBuffers {
    /* Reference: https://developers.google.com/protocol-buffers/docs/javatutorial */
    public static void main(String[] args) {
        Person yizhao = Person.newBuilder().setFirstName("Yi").setLastName("Zhao").build();
        System.out.println(yizhao.getFirstName());
        System.out.println(yizhao.getLastName());
    }
}

