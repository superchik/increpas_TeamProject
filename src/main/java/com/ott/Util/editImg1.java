package com.ott.Util;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import com.ott.user.vo.UserVO;

public class editImg1 {
	
	private String img_path = "/resources/user_img/";
	private UserVO vo;
	private Map<String, String> map = new HashMap<String, String>();
	
	
	public editImg1() {}
	
	public editImg1(UserVO vo) {
		this.vo = vo;
	}

	public Map<String, String> getMap() {
		return map;
	}

	public void setMap(Map<String, String> map) {
		this.map = map;
	}

	public UserVO getVo() {
		System.out.println("MultiFile 에디터에들어오냐? =====> "+vo.getS_file());
		System.out.println("u_idx=========================> "+vo.getU_idx());
		System.out.println("아이디 받아지냐?===================>"+vo.getU_id());
		System.out.println("u_name ========================> "+vo.getU_name());
		System.out.println("about_me ========================> "+vo.getAbout_me());
		System.out.println("실재 파일 저장 ===================> "+vo.getFilePath());
		System.out.println("DB 파일경로 받아지냐================>"+vo.getFname());
		
		StringBuffer sb = new StringBuffer();
		
		if (vo.getS_file() != null && vo.getS_file().getSize() > 0) {
//			System.out.println("실재 파일 저장 = "+ application.getRealPath(img_path));
//			oname = f.getOriginalFilename();
			vo.setOname(vo.getS_file().getOriginalFilename());
//			System.out.println("실재 파일 이름 = "+ vo.getOname());
			
//			fname = FileRenameUtil.checkSameFileName(oname, realPath);
			
			vo.setFname(FileRenameUtil.checkSameFileName(vo.getOname(),img_path));
//			System.out.println("DB 저장 파일 이름 = "+ vo.getFname());
			try {
				vo.getS_file().transferTo(new File(vo.getFilePath(), vo.getFname()));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		if(vo.getFname() == null) {
			sb.append(img_path);
			sb.append(vo.getFname());
			vo.setFname(sb.toString());
		}else if (vo.getS_file() != null) {
			sb.append(img_path);
			sb.append(vo.getFname());
			vo.setFname(sb.toString());
		}
		
		if(vo.getFname() == null ) {
			vo.setIdImg(vo.getU_id().substring(0,1));
		}
		
		if(vo.getAbout_me() == null && vo.getAbout_me().trim().length() < 0)
			vo.setAbout_me("내용이 없다");
		
//		System.out.println("뭔가 여러번 실행 한다=======>>>"+vo.getFname());


		map.put("path", vo.getFname());
		
		return vo;
	}

	public void setVo(UserVO vo) {
		this.vo = vo;

		
		
	}
	
}
