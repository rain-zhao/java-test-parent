import io.lettuce.core.RedisClient;
import io.lettuce.core.RedisURI;
import io.lettuce.core.api.StatefulRedisConnection;
import io.lettuce.core.api.sync.RedisCommands;

import java.util.Arrays;

import static io.lettuce.core.ScriptOutputType.*;

public class RedisBloomFilterDemo {

    private static int size = 1000000;//预计要插入多少数据

    private static double fpp = 0.01;//期望的误判率

    public RedisClient client() {
        RedisURI redisUri = RedisURI.Builder.redis("127.0.0.1", 6379)
                .withDatabase(1)
                .build();
        return RedisClient.create(redisUri);
    }

    public static void main(String[] args) {
        //client
        RedisBloomFilterDemo demo = new RedisBloomFilterDemo();
        RedisClient client = demo.client();


        StatefulRedisConnection<String, String> connect = client.connect();
        RedisCommands<String, String> commands = connect.sync();

        //create bloom filter
        commands.eval("redis.call('BF.RESERVE', 'myFilter' , 0.01, 100000);", STATUS);

        //add value
        for (int i = 0; i < 100000; i++) {
            commands.eval("redis.call('BF.ADD',KEYS[1],ARGV[1]);", STATUS,new String[]{"myFilter"},""+i);
        }
        //check value
        int count = 0;
        for (int i = 100000; i < 200000; i++) {
            boolean success = commands.eval("return redis.call('BF.EXISTS',KEYS[1],ARGV[1]);", BOOLEAN, new String[]{"myFilter"}, "" + i);
            if (success) {
                count++;
                System.out.println(i + "误判了");
            }
        }
        System.out.println("总共的误判数:" + count);

        connect.close();

        client.shutdown();

    }
}
