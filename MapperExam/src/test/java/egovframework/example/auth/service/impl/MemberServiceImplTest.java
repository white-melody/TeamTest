package egovframework.example.auth.service.impl;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import egovframework.example.auth.service.MemberService;
import egovframework.example.auth.service.MemberVO;
import lombok.extern.log4j.Log4j2;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = {
		"classpath:/egovframework/spring/context-aspect.xml",
	    "classpath:/egovframework/spring/context-common.xml",
	    "classpath:/egovframework/spring/context-datasource.xml",
	    "classpath:/egovframework/spring/context-idgen.xml",
	    "classpath:/egovframework/spring/context-mapper.xml",
	    "classpath:/egovframework/spring/context-sqlMap.xml",
	    "classpath:/egovframework/spring/context-transaction.xml"
	})
@Log4j2
class MemberServiceImplTest {

	@Autowired
	MemberService memberService;
	
	@Test
	void testAuthenticate() throws Exception {
//		1) 테스트 조건(given):
		MemberVO loginVO=new MemberVO("forbob@naver.com","123456","");
//		2) 실제 메소드실행(when)
		MemberVO memberVO=memberService.authenticate(loginVO);
//		3) 검증(확인)(then): 로그 , DB 확인, assert~ (DB확인)	
		log.info(memberVO);
	}
	
	@Test
	void testRegister() throws Exception {
//		1) 테스트 조건: 
		MemberVO loginVO=new MemberVO("forbob2@naver.com","123456","홍길동");
//		2) 실제 메소드실행
		memberService.register(loginVO);
//		3) 검증(확인): 로그 , DB 확인, assert~ (DB확인)
	}

}
