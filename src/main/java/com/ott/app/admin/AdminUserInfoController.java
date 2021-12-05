package com.ott.app.admin;


import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ott.Util.Paging_admin;
import com.ott.dao.UserDAO;
import com.ott.user.vo.UserVO;


@Controller
public class AdminUserInfoController {
	
	@Autowired
	private UserDAO u_dao;
	
	int nowPage;
	int rowTotal;
	int blockList = 10; //한 페이지당 표현될 게시물 수
	int blockPage = 5;//한 블럭당 표현될 페이지 수
	
	String pageName = "/admin_userinfo";
	@RequestMapping("/admin_userinfo")
	public ModelAndView userinfo(String cPage) {	
		ModelAndView mv = new ModelAndView();
		
		if(cPage == null)
			nowPage = 1;
		else
			nowPage = Integer.parseInt(cPage);
		
		rowTotal =u_dao.getTotalCount();//전체 유저수
		
		//페이징 처리를 위한 객체 생성
		Paging_admin page = new Paging_admin(nowPage, rowTotal, blockList, blockPage, pageName);
		
		int begin = page.getBegin();
		int end = page.getEnd();
		
		UserVO[] ar = u_dao.getList(begin, end);
		
		
		//JSP에서 표현해야 하므로 ar을 mv에 저장한다.
		mv.addObject("ar", ar);
		mv.addObject("nowPage", nowPage);
		mv.addObject("blockList", blockList);
		mv.addObject("rowTotal", rowTotal);
		mv.addObject("pageCode", page.getSb().toString());
		
		mv.setViewName("admin/admin_userinfo");
		
		return mv;
		
	}
	
	@RequestMapping("/admin_update")
	public ModelAndView User_stop(HttpServletRequest request) {
		
		ModelAndView mv = new ModelAndView();
		Map<String, String> map = new HashMap<String, String>();
		String dataList = request.getParameter("dataList");
		String result = "";
		// 5,0|42,1|41,1

		try {

			String[] rowData = dataList.split("\\|");

			if (rowData.length < 0) {
				result = "수정할 값이 없습니다.";
			} else {
				// 선택된 행의 값을 가지고온다.
				for (int i = 0; i < rowData.length; i++) {
					// 5,0
					String[] tdData = rowData[i].split(",");

					String u_idx = tdData[0]; // u_idx
					String is_stop = tdData[1]; // 정지/탈퇴

					map.put("u_idx", u_idx);
					map.put("is_stop", is_stop);

					// **** 회원데이터 수정 ****
					result = u_dao.updateUser_stop(map);

				}

				if (result.equals("SUCC")) {
					result = "수정되었습니다.";
				} else {
					result = "실패했습니다";
				}
			}

		} catch (Exception e) {
			result = "[예외발생!!]";
		}

		mv.addObject("RESULT", result);
		mv.setViewName("redirect:/admin_userinfo");    // URL을 호출한다.
		return mv;

	}
}
