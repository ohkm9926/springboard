package com.kyungmin.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.kyungmin.DAO.boardDAO;
import com.kyungmin.domain.boardVO;
@Service
public class boardServiceImpl implements boardService {
	
	@Inject
	private boardDAO dao;

	@Override
	public void write(boardVO vo) throws Exception {
		dao.write(vo);
		
		
	}

	@Override
	public List<boardVO> list() throws Exception {
		// TODO Auto-generated method stub
		return dao.list();
	}

	@Override
	public boardVO read(int bno) throws Exception {
		// TODO Auto-generated method stub
		return dao.read(bno);
	}

	@Override
	public void update(boardVO vo) throws Exception {
		dao.update(vo);
		
	}

	@Override
	public void delete(int bno) throws Exception {
	      dao.delete(bno);
		
	}

}
