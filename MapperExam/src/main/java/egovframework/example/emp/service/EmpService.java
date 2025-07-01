/**
 * 
 */
package egovframework.example.emp.service;

import java.util.List;

import egovframework.example.common.Criteria;
import egovframework.example.dept.service.DeptVO;

/**
 * @author user
 *
 */
public interface EmpService {
	List<?> selectEmpList(Criteria criteria);   // 전체 조회 
	int selectEmpListTotCnt(Criteria criteria); // 총 개수 구하기
	int insert(EmpVO empVO);                    // 사원 insert 
	EmpVO selectEmp(int eno);                   // 상세조회
	int update(EmpVO empVO);                    // update 메소드
	int delete(EmpVO empVO);                    // delete 메소드
}
