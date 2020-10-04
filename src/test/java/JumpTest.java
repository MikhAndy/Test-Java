import com.mikandpost.Competition;
import com.mikandpost.obstacles.Wall;
import com.mikandpost.participants.Cat;
import com.mikandpost.participants.Human;
import com.mikandpost.participants.Runner;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class JumpTest {
    Competition competition = new Competition();

    @ParameterizedTest
    @MethodSource("data")
    public void testJump(Wall wall, Runner runner, boolean isSuccessful) {
        boolean check = wall.check(runner);
        Assertions.assertEquals(isSuccessful, check);
    }

    private static Stream<Arguments> data() {
        Wall shortWall = new Wall(5);
        Wall longWall = new Wall(10);

        Cat barsik = new Cat("Barsik", 2, 2);
        Cat holly = new Cat("Holly", 2, 6);
        Cat molly = new Cat("Molly", 5, 10);
        Human pasha = new Human("Pasha", 7, 2);

        return Stream.of(
                Arguments.of(shortWall, barsik, false),
                Arguments.of(longWall, barsik, false),
                Arguments.of(shortWall, barsik, false),
                Arguments.of(longWall, holly, false),
                Arguments.of(shortWall, holly, true),
                Arguments.of(longWall, molly, true),
                Arguments.of(shortWall, molly, true),
                Arguments.of(longWall, pasha, false),
                Arguments.of(shortWall, pasha, false)
        );
    }
}
