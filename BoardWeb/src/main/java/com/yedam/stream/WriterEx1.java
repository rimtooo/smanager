package com.yedam.stream;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WriterEx1 {
	public static void main(String[] args) {
		// 기본스트림 - 보조스트림 - 추가적인 기능 수행.
		List<MemberVO> members = new ArrayList<>();
		try {
			FileReader fr = new FileReader("c:/temp/file3.text");
			BufferedReader br = new BufferedReader(fr); // BufferedReader : 한라인씩 읽는 기능.
			String str = "";
			String[] strAry = null;
			while (true) {
				str = br.readLine(); // 한라인 읽기. 101 홍길동 90
				if (str == null) {
					break;
				}
				// 파일의 정보를 활용 -> 컬렉션 생성.
				strAry = str.split(" ");
				MemberVO member = new MemberVO();
				member.setMemberNo(Integer.parseInt(strAry[0]));
				member.setMemberName(strAry[1]);
				member.setPoint(Integer.parseInt(strAry[2]));
				members.add(member);
				//System.out.println(str);
			}
			br.close();
			fr.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		members.forEach(System.out::println);

		System.out.println("완료!!");
	}

	static void reader1() {
		// Reader <- FileReader
		String path = WriterEx1.class.getResource("").getPath();
		System.out.println(path);
		try {
			Reader reader = new FileReader("c:/temp/file2.dat");
			while (true) {
				int read = reader.read();
				if (read == -1) {
					break;
				}
				System.out.println(read + " -> " + (char) read); // byte short int long
			}
			reader.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("완료!!");
	}

	static void writer1() {
		// 문자기반스트림 Writer <- FileWriter
		Scanner scn = new Scanner(System.in);
		String str = "";
		try {
			Writer writer = new FileWriter("c:/temp/file2.dat");
			while (true) {
				System.out.print("입력>> ");
				str = scn.nextLine();
				if (str.equals("quit"))
					break;

				writer.write(str + "\n");
			}
			writer.flush();
			writer.close();
			scn.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("완료!!");
	}
}
