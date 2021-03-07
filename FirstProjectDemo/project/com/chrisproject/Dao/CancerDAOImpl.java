package com.chrisproject.Dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.chrisproject.Bean.CancerBean;

public class CancerDAOImpl implements CancerDAO {
	
	private Connection editCancer() {
		try{
			Context context = new InitialContext();
			DataSource ds = (DataSource)context.lookup("java:/comp/env/jdbc/servdb"); 
			return ds.getConnection();
			}catch (SQLException e) {
				e.printStackTrace();
			}
			catch (NamingException e) {
				e.printStackTrace();
			}
			return null;
		   }
	
	
	public int deleteall() {
		int result=0;
		String sql="DELETE [ChrisPower].[dbo].[CancerInvestigate] DBCC CHECKIDENT([CancerInvestigate], RESEED, 0)";
		Connection con =editCancer();
		try(PreparedStatement  pstmt = con.prepareStatement(sql)){
			pstmt.execute();
			result=1;
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	
	
	@Override
	public int uploadfile() {
		int result=0;
		String sql = "INSERT INTO[ChrisPower].[dbo].[CancerInvestigate]([],[],[抖],[计璸]"
				   + ",[计╧],[计],[瞯璸[/窾]]],[瞯/╧[/窾]]]"
				   + ",[瞯/[/窾]]])"
				   + "VALUES(?,?,?,?,?,?,?,?,?)";
		Connection con =editCancer();
		try(PreparedStatement  pstmt = con.prepareStatement(sql)){
			URL url =new URL("https://data.taipei/api/getDatasetInfo/downloadResource?id=04324b43-5f80-4c96-87d3-a0a746a6b27d&rid=efc9ca1d-56da-486b-9a60-1e7209d28547");
			URLConnection urlConnection=url.openConnection();
			HttpURLConnection connection = null;        
		if(urlConnection instanceof HttpURLConnection)
            connection = (HttpURLConnection) urlConnection;         	
		BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
		String str = null;
		str = br.readLine();
		String ss = str.substring(67);
			while ((str = br.readLine())!=null) {
			ss = str.replaceAll("--"," ").replaceAll("-","0");
			String[] temparray = ss.split(",");
			pstmt.setString(1,temparray[0]);
			pstmt.setString(2,temparray[1]);
			pstmt.setString(3,temparray[2]);
			pstmt.setInt(4,Integer.valueOf(temparray[3]));
			pstmt.setInt(5,Integer.parseInt(temparray[4]));
			pstmt.setInt(6,Integer.parseInt(temparray[5]));
			pstmt.setFloat(7, Float.parseFloat(temparray[6]));
			pstmt.setFloat(8,Float.parseFloat(temparray[7]));
			pstmt.setFloat(9,Float.parseFloat(temparray[8]));
			pstmt.execute();
			}
		result = pstmt.getUpdateCount();
		br.close();
		con.close();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		return result;
		}
		
	@Override
	public int downloadfile(List<CancerBean> canr) {
		int result=0;
		try {
			BufferedWriter f1 =new BufferedWriter(new FileWriter("D:\\CancerData.txt"));
			String s1 = null;
			for(int i=0;i<canr.size();i++) {
				s1=canr.get(i).toString();
				f1.write(s1);
			}
			f1.flush();
			f1.close();
			result =1 ;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	
	@Override
	public int addCancer(CancerBean cancerbean) {
		int result=0;
		String sql ="INSERT INTO [ChrisPower].[dbo].[CancerInvestigate]"
				   +"([],[],[抖],[计璸],[计╧],[计],[瞯璸[/窾]]],[瞯/╧[/窾]]],[瞯/[/窾]]])\r\n"
				   + "VALUES('"+cancerbean.getYear()+"','"+cancerbean.getCauseOfDeath()+"','"+cancerbean.getRank()
				   + "',"+Integer.valueOf(cancerbean.getDeathTotal())+","+Integer.valueOf(cancerbean.getDeathMan())+","+Integer.valueOf(cancerbean.getDeathWoman())
				   + ","+Float.parseFloat(cancerbean.getDeathRate())+","+Float.parseFloat(cancerbean.getDeathRateMan())+","+Float.parseFloat(cancerbean.getDeathWoman())+")";
		Connection con =editCancer();
		try(PreparedStatement pstmt = con.prepareStatement(sql)){
			pstmt.executeUpdate();
			con.close();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public int updateCancer(CancerBean cancerbean) {
		int result=0;
		String sql = "UPDATE [ChrisPower].[dbo].[CancerInvestigate]\r\n"
				   + "SET [] = '"+cancerbean.getYear()
				   + "',[] = '"+cancerbean.getCauseOfDeath()
				   + "',[抖] = '"+cancerbean.getRank()
				   + "',[计璸] = "+Integer.valueOf(cancerbean.getDeathTotal())
				   + ",[计╧] = "+Integer.valueOf(cancerbean.getDeathMan())
				   + ",[计] = "+Integer.valueOf(cancerbean.getDeathWoman())
				   + ",[瞯璸[/窾]]] = "+Float.parseFloat(cancerbean.getDeathRate())
				   + ",[瞯/╧[/窾]]] = "+Float.parseFloat(cancerbean.getDeathRateMan())
				   + ",[瞯/[/窾]]] = "+Float.parseFloat(cancerbean.getDeathWoman())
				   + " WHERE [戈絪腹] = "+ cancerbean.getCanno() ;
		Connection con =editCancer();
		try(PreparedStatement pstmt = con.prepareStatement(sql)){
			pstmt.executeUpdate();
			con.close();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public int deleteCancer(int id) {
		int result = 0;
		String sql ="DELETE FROM [ChrisPower].[dbo].[CancerInvestigate]"
				   + "WHERE [戈絪腹] = "+id;
		Connection con =editCancer();
		try(PreparedStatement pstmt = con.prepareStatement(sql)){
			pstmt.executeUpdate();
			con.close();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public List<CancerBean> findCancer(String name) { 
		List<CancerBean> canr=new ArrayList<>();
		Connection con =editCancer();
		try(Statement  pstmt = con.createStatement()){
			ResultSet rs =pstmt.executeQuery("Select * FROM [ChrisPower].[dbo].[CancerInvestigate]"
					                         + "where [] like  '%"+name+"%'");
			CancerBean can = null;
			while (rs.next()) {
				can = new CancerBean();
				can.setCanno(rs.getString("戈絪腹"));
				can.setYear(rs.getString(""));
				can.setCauseOfDeath(rs.getString(""));
				can.setRank(rs.getString("抖"));
				can.setDeathTotal(rs.getString("计璸"));
				can.setDeathMan(rs.getString("计╧"));
				can.setDeathWoman(rs.getString("计"));
				can.setDeathRate(rs.getString("瞯璸[/窾]"));
				can.setDeathRateMan(rs.getString("瞯/╧[/窾]"));
				can.setDeathRateWoman(rs.getString("瞯/[/窾]"));
				canr.add(can);
			}
			con.close();
		}
		catch (SQLException e) {
				e.printStackTrace();
		}
		return canr;
		
	}
	public CancerBean findCancerbyid(int id) {
		CancerBean can = null;
		Connection con =editCancer();
		try(Statement  pstmt = con.createStatement()){
			ResultSet rs =pstmt.executeQuery("Select * FROM [ChrisPower].[dbo].[CancerInvestigate]"
					                        +"where[戈絪腹]="+id);
			while (rs.next()) {
				can = new CancerBean();
				can.setCanno(rs.getString("戈絪腹"));
				can.setYear(rs.getString(""));
				can.setCauseOfDeath(rs.getString(""));
				can.setRank(rs.getString("抖"));
				can.setDeathTotal(rs.getString("计璸"));
				can.setDeathMan(rs.getString("计╧"));
				can.setDeathWoman(rs.getString("计"));
				can.setDeathRate(rs.getString("瞯璸[/窾]"));
				can.setDeathRateMan(rs.getString("瞯/╧[/窾]"));
				can.setDeathRateWoman(rs.getString("瞯/[/窾]"));
			}
			con.close();
		}
		catch (SQLException e) {
				e.printStackTrace();
		}
		return can;
	}
	@Override
	public List<CancerBean> findAllCancer() {
		String sql = "Select * FROM [ChrisPower].[dbo].[CancerInvestigate]";
		List<CancerBean> canr=new ArrayList<>();
		Connection con =editCancer();
		try(PreparedStatement pstmt = con.prepareStatement(sql)){
			ResultSet rs = pstmt.executeQuery();
			CancerBean can = null;
			while (rs.next()) {
				can = new CancerBean();
				can.setCanno(rs.getString("戈絪腹"));
				can.setYear(rs.getString(""));
				can.setCauseOfDeath(rs.getString(""));
				can.setRank(rs.getString("抖"));
				can.setDeathTotal(rs.getString("计璸"));
				can.setDeathMan(rs.getString("计╧"));
				can.setDeathWoman(rs.getString("计"));
				can.setDeathRate(rs.getString("瞯璸[/窾]"));
				can.setDeathRateMan(rs.getString("瞯/╧[/窾]"));
				can.setDeathRateWoman(rs.getString("瞯/[/窾]"));
				canr.add(can);
			}
		con.close();	
		}
		catch (SQLException e) {
				e.printStackTrace();
		}
		return canr;
	}
}
