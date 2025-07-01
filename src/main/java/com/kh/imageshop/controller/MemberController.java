package com.kh.imageshop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.kh.imageshop.common.domain.CodeLabelValue;
import com.kh.imageshop.domain.Member;
import com.kh.imageshop.service.CodeService;
import com.kh.imageshop.service.MemberService;

@Controller
@RequestMapping("/user")
public class MemberController {
    @Autowired
    private MemberService service;

    @Autowired
    private CodeService codeService;

    // 스프링 시큐리티의 비밀번호 암호처리기
    @Autowired
    private PasswordEncoder passwordEncoder;

    // 회원가입 화면요청 페이지
    @GetMapping("/register")
    public String registerForm(Member member, Model model) throws Exception {
        // 직업코드 목록을 조회하여 뷰에 전달
        String groupCode = "A00";
        List<CodeLabelValue> jobList = codeService.getCodeList(groupCode);
        model.addAttribute("jobList", jobList);
        model.addAttribute("member", member);
        return "user/register";
    }

    // 등록 처리
    @PostMapping("/register")
    public String register(@Validated Member member, BindingResult result,
            Model model, RedirectAttributes rttr) throws Exception {
        if (result.hasErrors()) {
            // 직업코드 목록을 조회하여 뷰에 전달
            String groupCode = "A00";
            List<CodeLabelValue> jobList = codeService.getCodeList(groupCode);
            model.addAttribute("jobList", jobList);
            return "user/register";
        }

        // 비밀번호 암호화
        String inputPassword = member.getUserPw();
        member.setUserPw(passwordEncoder.encode(inputPassword));

        service.register(member);

        rttr.addFlashAttribute("userName", member.getUserName());
        return "redirect:/user/registerSuccess";
    }

    // 등록 성공 페이지
    @GetMapping("/registerSuccess")
    public String registerSuccess(Model model) throws Exception {
        return "user/registerSuccess";
    }

    // 목록 페이지(관리자 가능)
    @GetMapping("/list")
    public String list(Model model) throws Exception {
        model.addAttribute("list", service.list());
        return "user/list";
    }
}
