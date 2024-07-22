package com.kyungmin.service;

import java.util.List;

import com.kyungmin.domain.boardVO;

public interface boardService {
    public void write(boardVO vo) throws Exception;
    
	//목록
	public List<boardVO> list() throws Exception; 
	
	//목록에서 하나 조회
	public boardVO read(int bno) throws Exception;
	
	//목록조회한걸 수정
	public void update(boardVO vo) throws Exception;
	
	//삭제
		public void delete(int bno) throws Exception;
    
}
