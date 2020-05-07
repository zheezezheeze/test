package org.parkjieun.test;

import java.util.HashMap;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.parkjieun.test.board.bean.Board;
import org.parkjieun.test.board.service.IBoardService;
import org.parkjieun.test.member.bean.Member;
import org.parkjieun.test.member.service.IMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {
	@Autowired
	private IMemberService memberService;
	@Autowired
	private IBoardService boardService;
	
	@RequestMapping("/")
	public String home(HttpServletRequest request) {
		Cookie[] cookies = request.getCookies();
		if(cookies != null) {
			for(Cookie tempCookie : cookies){
				if(tempCookie.getName().equals("id")){
					HttpSession session = request.getSession();
					Member member = memberService.getMember(tempCookie.getValue());
					if(member != null) {
						session.setAttribute("loginUser", member);
					}
					return "redirect:/goList";
				}
			}
		}
		return "login";
	}
	
	@RequestMapping(value= {"/cancleWrite", "goList"})
	public String replaceList(Model model) {
		Board[] list = boardService.getBoards();
		for(Board board : list) {
			String id = board.getM_id();
			String name = memberService.getName(id);
			board.setM_id(name);
		}
		model.addAttribute("list", list);
		return "list";
	}
	
	@RequestMapping("/doLogin")
	public String doLogin(String m_id, String m_password, boolean auto_login, HttpServletResponse response, HttpServletRequest request, Model model) {
		Member member = memberService.getMember(m_id);
		if(member == null) {
			model.addAttribute("msg", "존재하지 않는 아이디 입니다.");
			return "login";
		} else {
			if(!memberService.isPasswordRight(member, m_password)) {
				model.addAttribute("msg", "비밀번호가 일치하지 않습니다.");
				return "login";
			}
		}
		if(auto_login) {
			Cookie idCookie = new Cookie("id", m_id);
			idCookie.setMaxAge(60*60*5);
			response.addCookie(idCookie);
		}
		HttpSession session = request.getSession();
		session.setAttribute("loginUser", member);
		return "redirect:/goList";
	}
	
	@RequestMapping("/goWrite")
	public String goWrite() {
		return "write";
	}
	
	@RequestMapping("detail")
	public String goDetail(
		@RequestParam("b_num")int b_num,
		Model model
	) {
		boardService.updateCount(b_num);
		Board board = boardService.getABoard(b_num);
		model.addAttribute(board);
		return "detail";
	}
	
	@RequestMapping("/doWrite")
	public String doWrite(Board board) {
		if(boardService.insertBoard(board) != 0) {
			return "redirect:/goList";
		}
		return "write";
	}
	
	@RequestMapping("/setting")
	public String goSetting() {
		return "board_password/setting";
	}
	
	@RequestMapping("/confirm")
	public String goConfirm() {
		return "board_password/confirm";
	}
	
	
	@RequestMapping("/ajax_setting_password")
	@ResponseBody
	public String setPassword(int b_num, String b_password, String b_retry) {
		if(b_password.equals(b_retry)) {
			boardService.updatePassword(b_num, b_password);
			return "설정성공";
		}
		return "비밀번호가 일치하지 않습니다.";
	}
	
	@RequestMapping("/ajax_confirm_password")
	@ResponseBody
	public String confirmPassword(int b_num, String b_password, Model model) {
		Board board = boardService.getABoard(b_num);
		if(board.getB_password().equals(b_password)) {
			return "detail?b_num=" + b_num;
		} else {
			model.addAttribute("error", "올바르지 않은 비밀번호 입니다");
			return "goList";
		}
	}
}
