package com.rays.JBean;

import java.util.ArrayList;
import java.util.Iterator;

public class TestMarksheetModel {
	
	public static void main(String[] args) throws Exception {
		//testAddMark();
		//testUpdatemark();
		//testDelete();
		//testRollno();
		testGetMeritList();
		//testSearch();
	}

	
	  public static void testSearch() throws Exception{
		  MarksheetBean bean = new  MarksheetBean();
		  bean.setName("RahulGoyal"); 
		  MarksheetModel model = new MarksheetModel();
		  model.search(bean);
	  }


	public static void testGetMeritList() throws Exception{
		ArrayList aL = new ArrayList();  
		MarksheetBean bean = new MarksheetBean();
		MarksheetModel model = new MarksheetModel();
		aL = model.getMeritList(bean);
		if(aL.size()<0) {
		System.out.println("failed");
		}
		Iterator it = aL.iterator();
		while(it.hasNext()) {
			bean = (MarksheetBean)it.next();
			System.out.print(bean.getId());
			System.out.print("	\t"+bean.getRollno());
			System.out.print("	\t"+bean.getName());
			System.out.print("	\t"+bean.getPhy());
			System.out.print("	\t"+bean.getChe());
			System.out.println("	\t"+bean.getMat());
		
		}
		}
		  
		  
	  
	 

	
	  public static void testRollno() throws Exception
	  { 
		  MarksheetBean bean = new  MarksheetBean();
		  bean.setRollno("R104"); 
		  MarksheetModel model = new MarksheetModel();
		  model.getrollN(bean);
	  
	  }
	  
	
	  public static void testDelete() throws Exception {
		  MarksheetBean bean = new MarksheetBean();
		  bean.setRollno("R103"); 
		  MarksheetModel model = new MarksheetModel();
		  model.delete(bean);
	  
	  }
	  
	  public static void testUpdatemark() throws Exception {
	MarksheetBean bean =  new MarksheetBean();
		bean.setRollno("3003"); 
		bean.setName("Vijay");
	  bean.setPhy(99); bean.setChe(98); bean.setMat(89); bean.setId(3);
	  MarksheetModel model = new MarksheetModel(); model.update(bean); }
	 

	
	  public static void testAddMark() throws Exception { 
		  MarksheetBean bean = new MarksheetBean();
	  bean.setId(7);
	  bean.setRollno("R107");
	  bean.setName("SunnyGangwal");
	  bean.setPhy(37);
	  bean.setChe(27);
	  bean.setMat(13);
	  
	  MarksheetModel model = new MarksheetModel(); model.add(bean); }
	 

}
