/**
 * 
 */
package egovframework.example.auth.web;

import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import egovframework.example.auth.service.MemberService;
import egovframework.example.auth.service.MemberVO;
import lombok.extern.log4j.Log4j2;

/**
 * @author user
 *
 */
@Log4j2
@Controller
public class MemberController {
	@Autowired
	private MemberService memberService;
	
//	로그인 화면 열기
	@GetMapping("/login.do")
	public String loginView() {
		return "auth/login";
	}
	
//	로그인 처리: 보안목적(@PostMapping 사용)
//	@GetMapping: 1) 조회(로그인도) => id, 암호(주소창에 표시)
//	@PostMapping: 2) 입력/수정/삭제 => id, 암호(주소창에 표시안됨)
	@PostMapping("/loginProcess.do")
	public String login(HttpSession session,
			@ModelAttribute MemberVO loginVO) throws Exception {
//		1) DB에 입력된유저가 있는지 확인: 서비스의 로그인메소드 실행
		MemberVO memberVO=memberService.authenticate(loginVO);
//		2) 세션을 만듭니다.: 유저저장(세션: 정보를 임시로 저장하는 공간:서버컴퓨터에(스프링) 저장)
//		사용법: 세션.setAttribute("키", 값);
		session.setAttribute("memberVO", memberVO);
//		    (DB(영구적) vs 세션(임시:컴퓨터 재시작(사라짐), 웹브라우저를 꺼도 사라짐)
//		2-2) TODO: 보안코딩: CSRF(사이트 위조) 공격 방어: 인증 토큰(세션)
		session.setAttribute("CSRF_TOKEN", UUID.randomUUID().toString());
		
//		3) 통과: 이동할페이지 강제이동
		return "redirect:/";
	}
	
//	로그아웃 처리
	@GetMapping("/logout.do")
	public String logout(HttpSession session) {
//		세션 전체 삭제:
		session.invalidate();
		return "redirect:/login.do";
	}
	
//	회원가입 페이지 열기
	@GetMapping("/register.do")
	public String registerView() {
		return "auth/register";
	}
	
//	회원가입 처리
	@PostMapping("/register/addition.do")
	public String register(Model model, 
			@ModelAttribute MemberVO memberVO) throws Exception {
		log.info("테스트 : "+memberVO);
//		서비스의 회원가입 메소드 실행
		memberService.register(memberVO);
//		성공메세지 JSP 전달
		model.addAttribute("msg", "회원 가입을 성공했습니다.");
		
		return "auth/register";
	}
}













