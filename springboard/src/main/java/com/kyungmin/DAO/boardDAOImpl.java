package com.kyungmin.DAO;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.kyungmin.domain.boardVO;
@Repository
public class boardDAOImpl implements boardDAO {
	@Inject
	private SqlSession sql;
	
	private static String namespace = "com.kyugmin.mappers.boardMapper";
	
	

	@Override
	public void write(boardVO vo) throws Exception {
	  sql.insert(namespace + ".write" , vo);
		
	
		
	}



	@Override
	public List<boardVO> list() throws Exception {
		return sql.selectList(namespace +".list");
		
	}



	@Override
	public boardVO read(int bno) throws Exception {
		// TODO Auto-generated method stub
		return sql.selectOne(namespace + ".read" ,bno);
	}



	@Override
	public void update(boardVO vo) throws Exception {
		// TODO Auto-generated method stub
		 sql.update(namespace + ".update" ,vo);
	}



	@Override
	public void delete(int bno) throws Exception {
		sql.delete(namespace + ".delete" , bno);
		
	}
	
	
	

}
