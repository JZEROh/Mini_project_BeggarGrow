package 거지키우기;

import java.awt.event.ActionListener;

// 거지 키우기 게임 인터페이스 
public interface interface_baggarGame{
	
	// UI 초기화 메서드
	void initializeUI();
	
	// 현재 돈 업데이트 메서드
	void updateMoney(double money);
	
	// 경과 시간 업데이트 메서드 
	void updateTime(int seconds);
	
	// 클릭 버튼에 ActionListener 추가하는 메서드
	void addEarnPerClickButtonActionListener(ActionListener listener);
	
	// 클릭당 돈 벌기 업그레이드 버튼에 ActionListener 추가하는 메서드
	void addUpgradePerClickButtonActionListener(ActionListener Listener);
	
	// 시간당 돈 벌기 업그레이드 버튼에 ActionListener 추가하는 메서드
	void addUpgradePerSecButtonActionListener(ActionListener listener);
}