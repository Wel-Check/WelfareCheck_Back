package Welfare.WelfareCheck;

import Welfare.DB.dbConnecter;
import Welfare.WelfareCheck.domain.Facilitie.BusanWelfareFacilitie;
import Welfare.WelfareCheck.domain.Facilitie.JDBCFacilitieRepository;
import Welfare.WelfareCheck.domain.Facilitie.WelfareOpenAPIConnecter;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

import java.util.List;

import static Welfare.WelfareCheck.domain.Facilitie.WelfareOpenAPIConnecter.getFacilitiesXml;

@ServletComponentScan
@SpringBootApplication
public class WelfareCheckApplication {

	public static void main(String[] args) throws JSONException {

		SpringApplication.run(WelfareCheckApplication.class, args);
		/*
		//api To DB 0
		WelfareOpenAPIConnecter welfareOpenAPIConnecter = new WelfareOpenAPIConnecter();
		welfareOpenAPIConnecter.saveDB();*/

		//JDBCFacilitieRepository jdbcFacilitieRepository = JDBCFacilitieRepository.getInstance();
		//숫자 검색
		/*BusanWelfareFacilitie busanWelfareFacilitie = jdbcFacilitieRepository.findByNum("224");
		System.out.println(busanWelfareFacilitie);*/

		/*//search
		List<BusanWelfareFacilitie>list = jdbcFacilitieRepository.facilityNameSearch("장애인" );*/

		//findAll
		/*List<BusanWelfareFacilitie> list = jdbcFacilitieRepository.findAll();*/
		//System.out.println(list);
	}
}
