package 거지키우기;

import javax.swing.SwingUtilities;

import DAO_DTO.FirstWindowDAO;

public class Game_Main {
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				FirstWindowDAO fw = new FirstWindowDAO();
				fw.first_windowMethod();
			}
		});
		
	}
}
