package com.ott.app;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.input.SAXBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ott.dao.PlatFormDAO;
import com.ott.movie.vo.MovieListVO;
import com.ott.platform.vo.PlatFormVO;

@Controller
public class MainController {
	
	@Autowired
	private PlatFormDAO n_dao;
	
	@RequestMapping(value = "/" , method = RequestMethod.GET)
	public ModelAndView service_data() throws Exception {
		ModelAndView mv = new ModelAndView();
		
		StringBuffer sb = new StringBuffer();
		sb.append("http://www.kobis.or.kr/kobisopenapi/webservice/rest/movie/searchMovieList.xml");
		sb.append("?key=88aadd02552e7cb68fb81746ad737386");
		sb.append("&openStartDt=2021");
		sb.append("&itemPerPage=100");
		
		URL url = new URL(sb.toString());
		
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		
		conn.setRequestProperty("Content-Type", "applicaiton/xml");
		conn.connect();
		
		SAXBuilder builder = new SAXBuilder();
		
		Document document = builder.build(conn.getInputStream());
		Element root = document.getRootElement();
		Element movieList = root.getChild("movieList");
		List<Element> movie = movieList.getChildren("movie");
		//System.out.println(movie.size()); //10
		
		MovieListVO[] mvo = new MovieListVO[movie.size()];
		
		int i = 0;
		for(Element vo : movie) {
			String movieNm = vo.getChildText("movieNm");
			String openDt = vo.getChildText("openDt");
			String prdtStatNm = vo.getChildText("prdtStatNm");
			String genreAlt = vo.getChildText("genreAlt");
			String repGenreNm = vo.getChildText("repGenreNm");
			
			MovieListVO m_vo = new MovieListVO(movieNm, openDt, prdtStatNm, repGenreNm, genreAlt);
			
			mvo[i++] = m_vo;
		}
		
		/* 테스트 코드 */
		PlatFormVO[] netflix =  n_dao.ott_All(1, 10);
		PlatFormVO[] watcha =  n_dao.ott_All(11, 20);
		PlatFormVO[] wavve =  n_dao.ott_All(21, 30);
		mv.addObject("netflix",netflix);
		mv.addObject("watcha",watcha);
		mv.addObject("wavve",wavve);
		mv.addObject("mvo",mvo);
		mv.setViewName("index");
		
		System.out.println("Test.");
	
		return mv;
	}
	
}
