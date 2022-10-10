package javaexp.z03_vo;

import java.util.ArrayList;

public class BTeam {
	//팀명, ArrayList<BPlayer>
	private String tName;
	private ArrayList<BPlayer> blist;
	public BTeam() {
		blist = new ArrayList<BPlayer>();
	}
	public BTeam(String tName) {
		this.tName = tName;
		blist = new ArrayList<BPlayer>();
	}
	// 구성원 한명씩 추가.
	public void addPlayer(BPlayer bp) {
		blist.add(bp); // 동적배열.add(객체) : 객체가 추가 처리
		System.out.println(bp.getName()+"팀에 등록");
	}
	//팀명과 등록된 선수 정보 출력
	public void showTeamList() {
		System.out.println(tName+" 등록된 선수들의 정보");
		if(blist.size()>0) { // 크기가 0초과 확인
			for(BPlayer bp:blist) {
				bp.show();
			}
		}else {
			System.out.println("등록된 선수가 없습니다.");
		}
	}
	
	public String gettName() {
		return tName;
	}
	public void settName(String tName) {
		this.tName = tName;
	}
	public ArrayList<BPlayer> getBlist() {
		return blist;
	}
	public void setBlist(ArrayList<BPlayer> blist) {
		this.blist = blist;
	}
	
	
	

}
