package com.encore.model;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class EncoreService {
	EncoreDAO dao = new EncoreDAO();

	public StudentVO loginCheck(String userid, String userpass) {
		return dao.loginCheck(userid, userpass);
	}

	public String initData(String majorFile, String studentFile) {
		List<MajorVO> majorList = fileMajorUpload(majorFile);
		List<StudentVO> studentList = fileStudentUpload(studentFile);

		if (dao.initMajorData(majorList) && dao.initStudentData(studentList))
			return "upload성공";
		else
			return "upload실패";
	}

	private List<StudentVO> fileStudentUpload(String studentFile) {
		List<StudentVO> sList = new ArrayList<>();
		try (BufferedReader br = new BufferedReader(
				new InputStreamReader(new FileInputStream(studentFile), "utf-8"));) {
			String line;
			br.readLine();
			while ((line = br.readLine()) != null) {
				String[] data = line.split(",", 7);
				StudentVO std = new StudentVO(Integer.parseInt(data[0]), data[1], Integer.parseInt(data[2]), data[3],
						data[4], data[5], data[6]);
				sList.add(std);
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} finally {
			//
		}

		return sList;
	}

	private List<MajorVO> fileMajorUpload(String majorFile) {
		List<MajorVO> majorList = new ArrayList<>();
		try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(majorFile), "utf-8"))) {
			String line;
			br.readLine();
			while ((line = br.readLine()) != null) {
				String[] data = line.split(",", 2);
				MajorVO major = new MajorVO(Integer.parseInt(data[0]), data[1]);
				majorList.add(major);
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} finally {
			//
		}

		return majorList;
	}

	public List<StudentVO> retrieve(Map<String, String> job) {
		return dao.retrieve(job);

	}

	public List<MajorVO> selectAllMajor() {
		return dao.sellectAllMajor();
	}

	public List<StudentVO> selectAllStudent() {
		return dao.sellectAllStudent();
	}

	public int insertMajor(MajorVO major) {
		return dao.insertMajor(major);
	}

	public int insertStudent(StudentVO std) {
		return dao.insertStudent(std);
	}

	public int deleteMajor(int major_id) {
		return dao.deleteMajor(major_id);
	}

	public MajorVO selectByMajor(int major_id) {
		return dao.selectByMajor(major_id);
	}

	public int majorUpdate(MajorVO major) {
		return dao.majorUpdate(major);
	}

	public int deleteStudent(int studentID) {
		return dao.deleteStudent(studentID);
	}

	public StudentVO selectByStudent(int studentID) {
		return dao.selectByStudent(studentID);
	}

	public int studentUpdate(StudentVO student) {
		return dao.studentUpdate(student);
	}

	public  List<StudentVO> selectByIDs(int studentID, int majorid) {
		return dao.selectByIDs(studentID, majorid);
	}

	

}
