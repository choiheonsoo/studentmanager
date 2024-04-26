package com.student.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder

public class StudentDto {
	private int studentNo;
	private String studentName;
	private int age;
	private int grade;
	private int classsNumber;
	private double height;
	private String address;
	private String phone;
	private char gender;
}
