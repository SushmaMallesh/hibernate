package com.workz.pencil.dao;

import com.workz.pencil.dao.PencilDAO;
import com.workz.pencil.dao.PencilDAOImpl;

public class PencilTester {
	public static void main(String[] args) {
		PencilDAO pencilDAOImpl=new PencilDAOImpl();
		//pencilDAOImpl.savePencilEntity();
		//pencilDAOImpl.getPencilEntity();
		pencilDAOImpl.updatePencilEntity();
		//pencilDAOImpl.deletePencilEntity();
	}
	
}
