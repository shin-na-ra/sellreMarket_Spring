package com.springlec.auth.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder // 오브젝트 생성을 위한 디자인 패턴
@NoArgsConstructor // 매개변수 없는 생성자를 구현
@AllArgsConstructor // 클래스의 모든 멤버 변수를 매개변수로 받는 생성자를 구현
@Getter // 클래스 멤버 변수의 Getter/Setter 메서드를 구현
@Setter
public class User {
	private String id;
	private String password;
	private String name;
	
}
