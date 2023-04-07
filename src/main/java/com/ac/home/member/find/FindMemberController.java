package com.ac.home.member.find;

import java.security.SecureRandom;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ac.home.member.MemberDTO;
import com.ac.home.member.mail.MailSendService;

@Controller
@RequestMapping("/member/find")
public class FindMemberController {

    @Autowired
    private FindMemberService findMemberService;

    // ID 찾기
    @GetMapping("/findId")
    public ModelAndView findId() {
        return new ModelAndView("member/find/findId");
    }

    @PostMapping("/findId")
    public ModelAndView findIdResult(String name, String email, String emaildomain) throws Exception {
        ModelAndView modelAndView = new ModelAndView("member/find/findId");
        MemberDTO memberDTO = new MemberDTO();
        memberDTO.setName(name);
        memberDTO.setEmail(email);
        memberDTO.setEmaildomain(emaildomain);
        
        //데이터 확인용
        System.out.println("Name: " + name);
        System.out.println("Email: " + email + emaildomain);

        memberDTO = findMemberService.getMemberId(memberDTO);

        if (memberDTO != null) {
            modelAndView.addObject("successMessage", "찾으시는 아이디는 " + memberDTO.getId() + " 입니다.");
        } else {
            modelAndView.addObject("errorMessage", "일치하는 회원 정보가 없습니다.");
        }

        return modelAndView;
    }

    // 비밀번호 찾기
    @GetMapping("/findPassword")
    public ModelAndView findPassword() {
        return new ModelAndView("member/find/findPassword");
    }

    @PostMapping("/findPassword")
    public ModelAndView findPasswordProcess(HttpServletRequest request, String id, String email, String emaildomain) {
        ModelAndView modelAndView = new ModelAndView("member/find/findPassword");
        MemberDTO memberDTO = new MemberDTO();
        memberDTO.setId(id);
        memberDTO.setEmail(email);
        memberDTO.setEmaildomain(emaildomain);
        
        //결합 데이터 확인용
        System.out.println("ID: " + id);
        System.out.println("Email: " + email + emaildomain);

        try {
            MemberDTO foundMember = findMemberService.findMemberByIdAndEmail(memberDTO);
            if (foundMember != null) {
                String tempPassword = generateTempPassword(6);

                foundMember.setPw(tempPassword);
                findMemberService.updatePassword(foundMember);

                sendEmailWithTempPassword(email, emaildomain, tempPassword);

                modelAndView.addObject("successMessage", "임시 비밀번호가 이메일로 전송되었습니다.");
            } else {
                modelAndView.addObject("errorMessage", "일치하는 회원 정보가 없습니다.");
            }
        } catch (Exception e) {
            modelAndView.addObject("errorMessage", "비밀번호 찾기 처리 중 오류가 발생했습니다.");
            e.printStackTrace();
        }
        return modelAndView;
    }

    // 임시 비밀번호 생성 메소드
    private String generateTempPassword(int length) {
        if (length < 1) {
            throw new IllegalArgumentException("length must be a positive number");
        }
        
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        SecureRandom random = new SecureRandom();
        StringBuilder tempPassword = new StringBuilder();
        
        for (int i = 0; i < length; i++) {
            int index = random.nextInt(chars.length());
            char randomChar = chars.charAt(index);
            tempPassword.append(randomChar);
        }
        
        return tempPassword.toString();
    }

 // 이메일로 임시 비밀번호 전송 메소드
    @Autowired
    private MailSendService mailSendService;

    private void sendEmailWithTempPassword(String email, String emaildomain, String tempPassword) {
        String combinedEmail = email + emaildomain;
        String setFrom = mailSendService.getSenderEmail();
        String subject = "임시 비밀번호 발급 안내";
        String content = 
			"귀하의 임시 비밀번호는 다음과 같습니다." +
	        "<br><br>" + 
		    "임시 비밀번호는 " + tempPassword + "입니다." + 
		    "<br>" + 
		    "임시 비밀번호로 로그인 한 후, 비밀번호를 변경해 주시기 바랍니다.";
        
        mailSendService.mailSend(setFrom, combinedEmail, subject, content);
    }
}
