/**
 * 
 */
package egovframework.example.dept.service;

import egovframework.example.common.Criteria;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * @author user
 * DB 부서 테이블의 정보를 임시 저장하는 클래스(1번)
 * 자바 표기법: 카멜표기법(컬럼명): 단어(소문자)+단어(첫글자대문자)
 * 자바 필드==테이블 컬럼
 * 메소드: Getter, Setter, 생성자들(모든 필드, 모두 없는 2개) => 롬북어노테이션으로 사용
 * 부가기능: ToString() 오버라이딩, Equals, HashCode 오버라이딩
 * (참고) : @EqualsAndHashCode(callSuper = false): 상속했을때 부모필드 제외하는 옵션
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode(callSuper = false)
public class DeptVO extends Criteria {
	private int dno;       // 부서번호(기본키,시퀀스)
	private String dname;  // 부서명
	private String loc;    // 부서위치
}


