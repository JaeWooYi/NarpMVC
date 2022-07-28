package kr.inflearn.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.inflearn.mapper.BoardMapper;
import kr.inflearn.model.BoardVO;

@Service
public class BoardServiceImpl implements BoardService{

	@Autowired
	private BoardMapper mapper;	// DI
	
	@Override
	public List<BoardVO> getList() {
		return mapper.getList();
	}

	@Override
	public void register(BoardVO boardVO) {
		mapper.insert(boardVO);
	}

	@Override
	public BoardVO get(int bno, String mode) {
		if(mode.equals("get")) {
			mapper.count(bno);
		}
		return mapper.read(bno);
	}

	@Override
	public int remove(int bno) {
		return mapper.delete(bno);
	}

	@Override
	public int modify(BoardVO boardVO) {
		return mapper.update(boardVO);
	}

}
