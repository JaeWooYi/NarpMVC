package kr.inflearn.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.inflearn.model.BoardVO;

//영속 계층
@Mapper
public interface BoardMapper {

// 게시물 리스트 가져오기	
public List<BoardVO> getList();

// 게시물 등록
public void insert(BoardVO boardVO);

// 게시물 상세 보기
public BoardVO read(int bno);	// bno -> 게시물 번호

// 게시물 삭제
public int delete(int bno);

// 게시물 수정
public int update(BoardVO boardVO);

}
