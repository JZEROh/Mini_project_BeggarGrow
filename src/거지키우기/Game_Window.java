package 거지키우기;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import Music.Error_BGM;
import Music.Game_Win;
import Music.GetCoin_BGM;
import Music.LevelUp_BGM;
import 아스키아트.Home;
import 아스키아트.LevelUp;
import 아스키아트.googul;

public class Game_Window extends JFrame {
	private JButton Click_Begging;
	private JButton Click_Begging_Upgrade;
	private JButton Click_Buy_home;
	private JButton Click_Save;
	private JLabel walletLabel; 
	private JLabel CostLabel;
	
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}

	// 현재 가지고 있는 금액: wallet
	private int wallet = 0;
	// 구걸 업그레이드 시 값이 변경될 변수
	private int Upgrade_Status = 1;
	private int Upgrade_cost = 10;
	private int home_cost = 300;
	private String ID;
	

	public void setWallet(int wallet) {
		this.wallet = wallet;
	}
	public void setUpgrade_Status(int upgrade_Status) {
		Upgrade_Status = upgrade_Status;
	}
	public void setUpgrade_cost(int upgrade_cost) {
		Upgrade_cost = upgrade_cost;
	}

	boolean visible = true;
	
	//구걸 클릭시 돈 추가되는 메서드
	private int addMoney() {
		// 클릭 한번 하면 1원 추가
		this.wallet += Upgrade_Status;
		updateWalletLabel(); // wallet 값 업데이트
		
		// 구걸 시 구걸하는 아스키아트 나오는 부분
		int click=0;
		if(click%10 == 0) {
			googul gg = new googul();
			gg.Googul();
			click++;
		}
		
		return wallet;
	}
	// 구걸 업그레이드 클릭시 돈 업그레이드 및 가진 돈 차감
	private int Upgrade_Begging() {
		if(this.wallet<Upgrade_cost) {
			System.out.println("업그레이드 할 돈이 부족합니다");
			// 업그레이드 하지 못했을때 Error BGM
			new Error_BGM();
		}else {
			this.wallet -= this.Upgrade_cost;
			this.Upgrade_cost += 30;
			System.out.println("업그레이드 완료!");
			this.Upgrade_Status += 1;
			upgradeCostLabel(); //gui에서 업그레이드 비용 나타내는 부분 새로고침
			//레벨업 시 나타날 아스키 아트
			LevelUp lp = new LevelUp();
			lp.Levelup();
			//레벨업 시 나오는 BGM
			new LevelUp_BGM();
		}
		updateWalletLabel(); // wallet 값 업데이트
		return this.Upgrade_Status;
	}
	
	//집 사기 버튼 클릭시 게임 종료
	private void buy_home() {
		if(this.wallet < home_cost) {
			System.out.println("아직 집 살돈이 부족해요 ㅠㅠ");
			System.out.println("열심히 모으세요!!");
			//집을 사지 못했을때 Error BGM 소리내기
			new Error_BGM();
		}else {
			wallet -= home_cost;
			Home home = new Home();
			home.MyHome();
			System.out.println("거지 탈출!!");
			System.out.println("게임을 종료합니다.");
			//집 사는것을 성공했을때 win BGM
			new Game_Win();
		}
		updateWalletLabel(); // wallet 값 업데이트
	}
	// GUI 창에서 지갑에 얼마 있는지 나타내는 곳을 업데이트 해주는 메서드
	private void updateWalletLabel() {
		String formattedString = String.format("지갑: %d원", wallet);
        walletLabel.setText(formattedString);
        }
	
	// GUI 창에서 업그레이드 가격을 표시해주곳을 업데이트 해주는 메서드
	private void upgradeCostLabel() {
		String formattedCostString = String.format("업그레이드 비용: %d원",Upgrade_cost);
		CostLabel.setText(formattedCostString);
	}
	
	//생성자
	public Game_Window() {
		setTitle("거지키우기_기능");
		setSize(500,250);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(4,2));
		
		walletLabel = new JLabel("지갑: 0"); // 초기값 설정
		CostLabel = new JLabel("업그레이드 비용: 10원");
//		String formattedString = String.format("지갑: %d",wallet);
//		JLabel bank = new JLabel(formattedString);
		//구걸하기 버튼 추가
		Click_Begging = new JButton("구걸하기");
		//구걸 업그레이드 버튼 추가
		Click_Begging_Upgrade = new JButton("구걸 업그레이드!!");
		//집 사기 버튼 추가
		Click_Buy_home = new JButton("집을 사자!!!!!\n가격: 300원");
		//저장하기 버튼 추가
		Click_Save = new JButton("저장하기");
		
		//패널에 컴포넌트 추가
//		panel.add(bank);
		panel.add(walletLabel);
		panel.add(CostLabel);
		panel.add(Click_Begging);
		panel.add(Click_Begging_Upgrade);
		panel.add(Click_Buy_home);
		panel.add(Click_Save);
		
		//버튼 누를 시 상호작용 구현
		//구걸하기 버튼 -> 돈 1원 벌기
		Click_Begging.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				addMoney();
				System.out.printf("%d원을 벌었습니다.\n지갑:%d\n",Upgrade_Status,wallet);
				//구걸하면 나는 코인소리
				new GetCoin_BGM();
			}
		});
		
		//구걸 업그레이드 버튼 -> Upgrade_Begging 메서드 사용
		Click_Begging_Upgrade.addActionListener(new  ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Upgrade_Begging();
				System.out.printf("현재 업그레이드에 필요한 비용: %d원\n",Upgrade_cost);
				
			}
		});
		
		// 최종목표 집을 사자 버튼 -> 사는것과 동시에 콘솔창에 집 그려주며 게임끝
		Click_Buy_home.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				buy_home();
				
			}
		});
		
		// 저장하기 버튼 -> 빈리스트에 id,wallet,Upgrade_Status,Upgrade_cost 집어넣기
		Click_Save.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ArrayList<Integer> list = new ArrayList<Integer>();
				list.add(wallet);
				list.add(Upgrade_Status);
				list.add(Upgrade_cost);
				
				int currentMoney = list.get(0);
				int UpgradeSTAT = list.get(1);
				int UpgradeCOST = list.get(2);
				
				Money mo = new Money();
				mo.money(ID,currentMoney,UpgradeSTAT,UpgradeCOST);
				
				System.out.println("저장완료!~~");
			}
		});
		
		// 패널 프레임에 추가, 화면에 표시
		setLocationRelativeTo(null); // 화면 가운데로 띄우기
		add(panel);
		setVisible(visible);
	}
	
	//메인 메소드
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				new Game_Window();
				
			}
		});
	}
}
