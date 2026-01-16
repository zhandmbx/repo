import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author xind
 * @Date 2025/12/1
 **/
public class test {
    public static void main(String[] args) {
        Set<String> set = new HashSet<String>();

        set.add("0");
        set.add("1");
        set.add("0");
        set.add("1");
        List<String> list = new ArrayList<>(set);
        System.out.println("test.main"+list );
        }
}
