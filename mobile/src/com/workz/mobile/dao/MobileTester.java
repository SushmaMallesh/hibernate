package com.workz.mobile.dao;
import com.workz.mobile.dao.MobileDAO;
import com.workz.mobile.dao.MobileDAOImpl;
public class MobileTester{
	public static void main(String[] args) {
		MobileDAO mobileDAOImpl=new MobileDAOImpl();
		//mobileDAOImpl.saveMobileEntity();
		mobileDAOImpl.getMobileEntity();
	}
}

