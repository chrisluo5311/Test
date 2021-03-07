package com.chrisproject.Bean;

public class CancerBean  implements java.io.Serializable{
	private static final long serialVersionUID = 1L;
	
	private String canno;
	private String year;
	private String CauseOfDeath;
	private String rank;
	private String deathTotal;
	private String deathMan;
	private String deathWoman;
	private String deathRate;
	private String deathRateMan;
	private String deathRateWoman;
	private int count ;
	private String Deletebyname;

	public CancerBean() {super();}
	
	public void setDeletebyname(String deletebyname) {Deletebyname = deletebyname;}
	public void setCount(int count) {this.count = count;}
	public void setCanno(String canno) {this.canno = canno;}
	public void setYear(String year) {this.year = year;}
	public void setCauseOfDeath(String causeOfDeath) {CauseOfDeath = causeOfDeath;}
	public void setRank(String rank) {this.rank = rank;}
	public void setDeathTotal(String deathTotal) {this.deathTotal = deathTotal;}
	public void setDeathMan(String deathMan) {this.deathMan = deathMan;}
	public void setDeathWoman(String deathWoman) {this.deathWoman = deathWoman;}
	public void setDeathRate(String deathRate) {this.deathRate = deathRate;}
	public void setDeathRateMan(String deathRateMan) {this.deathRateMan = deathRateMan;}
	public void setDeathRateWoman(String deathRateWoman) {this.deathRateWoman = deathRateWoman;}
	
	public int getCount() {return count;}
	public String getCanno() {return canno;}
	public String getYear() {return year;}
	public String getCauseOfDeath() {return CauseOfDeath;}
	public String getRank() {return rank;}
	public String getDeathTotal() {return deathTotal;}
	public String getDeathMan() {return deathMan;}
	public String getDeathWoman() {return deathWoman;}
	public String getDeathRate() {return deathRate;}
	public String getDeathRateMan() {return deathRateMan;}
	public String getDeathRateWoman() {return deathRateWoman;}
	public String getDeletebyname() {return Deletebyname;}
	
	public String toString(){
	return String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s,%s%n",
						canno,year,CauseOfDeath,rank, 
						deathTotal,deathMan,deathWoman,
						deathRate,deathRateMan,deathRateWoman);
	}
}
