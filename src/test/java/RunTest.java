import com.mikandpost.obstacles.Treadmill;
import com.mikandpost.participants.Cat;
import com.mikandpost.participants.Human;
import com.mikandpost.participants.Robot;
import com.mikandpost.participants.Runner;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class RunTest {

    @ParameterizedTest
    @MethodSource("data")
    public void testRun(Treadmill treadmill, Runner runner, boolean isSuccessful) {
        boolean check = treadmill.check(runner);
        Assertions.assertEquals(isSuccessful, check);
    }

    private static Stream<Arguments> data() {
        Treadmill shortTreadmill = new Treadmill(5);
        Treadmill longTreadmill = new Treadmill(10);

        Cat molly = new Cat("Molly", 6,2);
        Cat holly = new Cat("Holly", 4,7);
        Human andrey = new Human("Andrey", 7,4);
        Robot riko = new Robot("Riko", 10, 7);

        return Stream.of(
                Arguments.of(shortTreadmill, molly, true),
                Arguments.of(longTreadmill, molly, false),
                Arguments.of(shortTreadmill, holly, false),
                Arguments.of(longTreadmill, holly, false),
                Arguments.of(shortTreadmill, andrey, true),
                Arguments.of(longTreadmill, andrey, false),
                Arguments.of(shortTreadmill, riko, true),
                Arguments.of(longTreadmill, riko, true)
        );
    }
}
