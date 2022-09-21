package lambda;

import java.util.Arrays;
import java.util.List;

public class Ex3 {

	public static void main(String[] args) {
		/*
		 * < 람다식 사용의 장점 >
		 * 1. 코드의 간결성
		 * 	- 기본적으로 "익명의 내부클래스" 형태보다 간결함
		 * 	- 실행문이 간단할 경우 그 효과가 더욱 부각됨
		 *    => 어떤 로직인지 바로바로 알아보기 편하다. (가독성이 좋다)
		 *    
		 * 2. "지연 연산" (Lazy Evaluation)을 이용하여 향상된 퍼포먼스를 보여줄 수 있다.
		 * 	- 연산은 나중으로 미루어 두었다가 한꺼번에 연산하는 방식
		 *  - 메모리상의 효율성 및 불필요한 연산은 배제가 가능   
		 * 
		 * < 람다식 사용의 단점 >
		 * 1. 모든 원소를 순회하는 경우 어떤방법으로 작성하더라도 람다식이 조금 느릴 수 밖에 없다.
		 *    (최종 출력되는 bytecode는 단순 반복문 보다 몇단계를 더 거칠수 밖에 없다.)
		 * 
		 * 2.* 디버깅 시 추적이 극도로 어렵다. 
		 * 		(거의 불가능에 가깝다
		 * 		  -> 람다식으로 작성한 로직은 실수없이 완벽해야한다.
		 * 		  -> 간단한 로직이어야한다.)
		 * 
		 * 3. 람다식이 남용되면 오히려 코드를 이해하기 어려울 수 있다. (가독성이 떨어진다.)
		 * 
		 * < 최종 결론 >
		 * - 단순하고 간결한 로직이 그때 그때(일회성) 사용될 경우 람다식 (O)
		 * 
		 * - 로직이 조금 복잡하거나(실행문이 많을 경우) 가독성이 떨어지는 경우 람다식 (X)
		 *   => 복잡한 로직 = 가독성이 안좋음
		 *   => 실행문이 많다 = 디버깅할 일이 생긴다! 
		 * */
		
		// 지연 연산 예
		
		// 6보다 작은값 > 짝수인 것만 > 결과에 모두 10을 곱한다. > 제일 첫번째 요소
		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
		int n = list.stream().filter(i -> i < 6)
					 		 .filter(i -> i%2 == 0)
					 		 .map(i -> i * 10)
					 		 .findFirst().get();
		System.out.println(n);
		int n2 = list.stream().filter(i -> {System.out.println(i + " < 6"); return i < 6;})
		 		 .filter(i -> {System.out.println(i + " % 2 == 0"); return i%2 == 0;})
		 		 .map(i -> { System.out.println(i + " * 10"); return i * 10;})
		 		 .findFirst().get();
		
		
		
		
	}

}
