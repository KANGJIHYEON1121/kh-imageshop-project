package com.kh.imageshop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.kh.imageshop.common.CodeLabelValue;
import com.kh.imageshop.domain.CodeDetail;
import com.kh.imageshop.service.CodeDetailService;
import com.kh.imageshop.service.CodeService;

@Controller
@RequestMapping("/codedetail")
public class CodeDetailController {
    @Autowired
    private CodeDetailService codeDetailService;

    @Autowired
    private CodeService codeService;

    // 등록 페이지
    @GetMapping("/register")
    public void registerForm(Model model) throws Exception {
        CodeDetail codeDetail = new CodeDetail();
        model.addAttribute(codeDetail);
        // 그룹코드 목록을 조회하여 뷰에 전달
        List<CodeLabelValue> groupCodeList = codeService.getCodeGroupList();
        model.addAttribute("groupCodeList", groupCodeList);
    }

    // 등록 처리
    @PostMapping("/register")
    public String register(CodeDetail codeDetail, RedirectAttributes rttr)
            throws Exception {
        codeDetailService.register(codeDetail);
        rttr.addFlashAttribute("msg", "SUCCESS");
        return "redirect:/codedetail/list";
    }

    // 목록 페이지
    @GetMapping("/list")
    public void list(Model model) throws Exception {
        model.addAttribute("list", codeDetailService.list());
    }
}
