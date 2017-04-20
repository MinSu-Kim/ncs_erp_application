package kr.or.dgit.ncs.common;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class DigitKeyListener extends KeyAdapter {

	@Override
	public void keyTyped(KeyEvent e) {
		char c = e.getKeyChar();
		if (!Character.isDigit(c)) {
			e.consume(); // 숫자가 아닌 값이 들어오면 입력안됨
			return;
		}
	}
	
}
