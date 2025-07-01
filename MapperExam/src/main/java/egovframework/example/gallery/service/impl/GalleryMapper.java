package egovframework.example.gallery.service.impl;

import java.util.List;

import org.egovframe.rte.psl.dataaccess.mapper.Mapper;

import egovframework.example.common.Criteria;
import egovframework.example.fileDb.service.FileDbVO;
import egovframework.example.gallery.service.GalleryVO;

/**
 * 
 * @author user
 * 코딩 순서: VO(1번) - Mapper(인터페이스, xml(별명등록(선택)) - Service(ServiceImpl)
 */

@Mapper
public interface GalleryMapper {
	public List<?> selectGalleryList(Criteria criteria);   // 전체 조회
	public int selectGalleryListTotCnt(Criteria criteria); // 총 개수 구하기
	public int insert(GalleryVO galleryVO);                // insert
	public GalleryVO selectGallery(String uuid);           // 상세조회
}






