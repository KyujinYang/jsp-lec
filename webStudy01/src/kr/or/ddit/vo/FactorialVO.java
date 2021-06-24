package kr.or.ddit.vo;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@XmlRootElement(name="result")
@XmlAccessorType(XmlAccessType.NONE)
public class FactorialVO implements Serializable {
   @XmlElement
   private int left;
   @JsonIgnoreProperties
   private final char SIGN = '!';
   private int result;
   private String expression;
   
   public FactorialVO(int left) {
      super();
      this.left = left;
      
      //getter호출 또는 expression에 대한 getter호출 될때 생성자 실행
      
      /*//이렇게 해주면 연산이 수행되고 그 결과가 넘어온다.
      this.result = factorial(left);*/
      
   }
   
   public FactorialVO() {
	   super();
   }
   
   
   public int factorial(int left) {
      
//      연산수행할 수 있는 피연산자인지 체크
      if(left <= 0) {
         //연산 못하는 이유: 잘못된 파라미터(argument)의 전달--> 이때 exception사용
         throw new IllegalArgumentException("음수는 연산 불가"); 
                     //unchecked >> 상위에 runtimeException있다
      }
      
      if(left == 1) {
         //1이 되면 연산 종료시킨다.
         return 1;
      }else {
         //재귀호출구조 사용
         return left * factorial(left -1); 
         //하나씩 차감하면서 계속 곱하기 위해 이렇게 설정
      }
      
   }

   public int getLeft() {
      return left;
   }

   public void setLeft(int left) {
      this.left = left;
   }

   public int getResult() {
      return factorial(left);
   }


  public void setResult(int result) {
      this.result = result;
   }
 /*result는 임의로 바꿀 대상이 아닌 연산결과가 들어가야할 곳이니 지워준다.*/
   @XmlElement
   public String getExpression() {
      return String.format("%d%c = %d", left, SIGN, getResult());
   }
 
   
	public void setExpression(String expression) {
		this.expression = expression;
	}
   
   
//   public char getSIGN() {
//      return SIGN;
//   }

   @Override
   public String toString() {
      return "FactorialVO [left=" + left + ", SIGN=" + SIGN + ", result=" +  getResult() + ", expression=" + getExpression()
            + "]";
   }
   
   
   
}

