package com.muthukumarasamy.chatbox;

import com.muthukumarasamy.chatbox.stack.StackView;

public class ChatBox {

	public static void main(String[] args) {
		
		ChatBox c = new ChatBox();
		c.init();
	}

	private void init() {
		
		StackView stack= new StackView();
		try {
			stack.start();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
