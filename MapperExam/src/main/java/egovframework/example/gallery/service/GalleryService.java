/**
 * 
 */
package egovframework.example.gallery.service;

import java.util.List;

import egovframework.example.common.Criteria;

/**
 * @author user
 *
 */
public interface GalleryService {
	List<?> selectGalleryList(Criteria criteria);   // 전체 조회
	int selectGalleryListTotCnt(Criteria criteria); // 총 개수 구하기
	int insert(GalleryVO galleryVO);                // insert
	GalleryVO selectGallery(String uuid);           // 상세조회
}
