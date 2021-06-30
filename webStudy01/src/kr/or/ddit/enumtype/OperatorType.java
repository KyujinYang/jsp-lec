package kr.or.ddit.enumtype;

public enum OperatorType {
	//2.기본생성자
	PLUS('+', new RealOperator() {
		//7.RealOper //익명객체 new.
		public double operate(double left, double right) {
			return left + right;
		}
	}),
	//9.람다 , 파라미터사용 left,right // 익명객체x 람다표현식 . 1.8에서부터 사용가능
	MINUS('-',(left,right)->{return left - right;}),
	MULTIPLY('*',(left,right)->{return left * right;}),
	DIVIDE('/',(left,right)->{return left / right;});
	//4행위의 조건이 똑같다.(행위의 조건 설계)
	
	//8-1. 람다표현식 - 람다인터페이스 -> 펑셔널인터페이스, - 인터페이스안에 메소드는 하나들어가야한다. 추상메소드가 있어야해
	@FunctionalInterface
	public static interface RealOperator{
		public double operate(double left, double right);
		//8.functional interface
	}
	
	//0.
	private char sign;
	//5.
	public char getSign() {
		return sign;
	}


	private RealOperator realOperator;
	
	
	
	//1.sign생성자 만들기
	//6.realOpeator
	private OperatorType(char sign, RealOperator realOperator) {
		this.sign = sign;
		this.realOperator = realOperator;
	}
	
	//3. 인스턴스메소드(객체생성필요)
	
	public double operate(double left, double right){
	//6.더하기빼기연산 하드코딩 불가
		return realOperator.operate(left, right);
	}
	
	//10
	private static final String EXPPTRN = "%f %c %f = %f";
	public String getExpression(double left, double right) {
		return String.format(EXPPTRN, left, sign, right, operate(left,right));
	}
	
}
