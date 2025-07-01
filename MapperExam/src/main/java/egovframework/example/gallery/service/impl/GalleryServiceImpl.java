/**
 * 
 */
package egovframework.example.gallery.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import egovframework.example.common.Criteria;
import egovframework.example.fileDb.service.impl.FileDbMapper;
import egovframework.example.gallery.service.GalleryService;
import egovframework.example.gallery.service.GalleryVO;

/**
 * @author user
 *
 */
@Service
public class GalleryServiceImpl implements GalleryService{
	@Autowired
	GalleryMapper galleryMapper;

//	전체조회
	@Override
	public List<?> selectGalleryList(Criteria criteria) {
		// TODO Auto-generated method stub
		return galleryMapper.selectGalleryList(criteria);
	}

//	총 개수 구하기
	@Override
	public int selectGalleryListTotCnt(Criteria criteria) {
		// TODO Auto-generated method stub
		return galleryMapper.selectGalleryListTotCnt(criteria);
	}

//	추가
	@Override
	public int insert(GalleryVO galleryVO) {
		// TODO Auto-generated method stub
		return galleryMapper.insert(galleryVO);
	}

//	상세조회
	@Override
	public GalleryVO selectGallery(String uuid) {
		// TODO Auto-generated method stub
		return galleryMapper.selectGallery(uuid);
	}
	
	
	
}
