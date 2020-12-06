package io.github.ronvohra;

import io.quarkus.test.junit.NativeImageTest;
import org.junit.jupiter.api.Disabled;

@NativeImageTest
@Disabled
public class NativeHomeResourceIT extends HomeResourceTest {

  // Execute the same tests but in native mode.
}
