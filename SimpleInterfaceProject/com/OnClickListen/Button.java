package com.OnClickListen;

public class Button {

	public Button() {}
	
	public void setOnClickListener(OnClickListener onClickListener) {
		
		onClickListener.onClick();
	}
}
