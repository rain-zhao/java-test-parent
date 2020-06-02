import com.rain.zhao.service.HelloService;

import java.util.ServiceLoader;

public class ServiceLoaderTest {
    public static void main(String[] args) {
        ServiceLoader<HelloService> serviceLoader = ServiceLoader.load(HelloService.class);
        for (HelloService service : serviceLoader) {
            System.out.println(service.sayHello());
        }

    }
}
