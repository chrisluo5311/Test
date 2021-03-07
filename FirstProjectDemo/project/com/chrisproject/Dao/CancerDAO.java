package com.chrisproject.Dao;

import java.util.List;
import com.chrisproject.Bean.CancerBean;

public interface CancerDAO {
	
	public int deleteall();
	
	//upload file
	public int uploadfile();
	
	//download file
	public int downloadfile(List<CancerBean> canr);

	//CUD
	public int addCancer(CancerBean can);//C
		
	public int updateCancer(CancerBean can);//U
		
	public int deleteCancer(int id);//D
		
		
	//R
	public CancerBean findCancerbyid(int id);
	
	public List<CancerBean> findCancer(String name);//id=>可查詢的欄位值  
		
	public List<CancerBean> findAllCancer();
}
