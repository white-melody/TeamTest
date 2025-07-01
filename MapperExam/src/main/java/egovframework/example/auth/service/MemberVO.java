/**
 * 
 */
package egovframework.example.auth.service;

import egovframework.example.common.Criteria;
import egovframework.example.dept.service.DeptVO;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * @author user
 *	VO == 테이블
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode(callSuper = false)
public class MemberVO extends Criteria {
	private String email;     // 기본키, 로그인ID
	private String password;  // 암호
	private String name;      // 이름
}


