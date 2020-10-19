import java.nio.file.*;
 
public class Wrapper {
  public static void main(String[] args) throws Exception {
    Files.write(Paths.get("Foo.class"), FooDump.dump());
  }
}
