import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
//import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;

import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
//import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
//import org.mockito.Mockito;


class TestDemoTest {	
	
	TestDemo testDemo;
	@BeforeEach
	void setUp() throws Exception {
		testDemo = new TestDemo();
	}
	@ParameterizedTest
	@MethodSource("TestDemoTest#argumentForAddPositive")
	void assertThatTwoPositiveNumbersdAreAddedCorrectly(
			int a, int b, int expected, boolean expectException) {
		
		if (!expectException) {
			assertThat(testDemo.addPositive(a, b)).isEqualTo(expected);
		}else {
			assertThatThrownBy(()->
			testDemo.addPositive(a, b))
			.isInstanceOf(IllegalArgumentException.class);
		}
	}	
	@ParameterizedTest
	@MethodSource("TestDemoTest#argumentsForAddPositive")	
	static Stream<Object> argumentsForAddPositive() {
		return Stream.of(2, 4, 6, false);			
	}
	
//	@Test
//	void randomNumberSquared() {
//		
//	}
	@Test
	void assertThatNumberSquaredIsCorrect() {
		TestDemo mockDemo = spy(testDemo);
		doReturn(5).when(mockDemo).getRandomInt();
		int fiveSquared = mockDemo.randomNumberSquared();
		
		assertThat(fiveSquared).isEqualTo(25);
	}
	
}


