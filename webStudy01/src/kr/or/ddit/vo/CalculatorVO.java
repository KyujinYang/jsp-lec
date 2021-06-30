package kr.or.ddit.vo;

import java.io.Serializable;

public class CalculatorVO implements Serializable {
	private int left;
	private int result;
	private String expression;
	private char operator = '+';
}
	
