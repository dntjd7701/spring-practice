package com.douzone.container.soundsystem;

import org.springframework.beans.factory.annotation.Autowired;

public class CDPlayer {
	@Autowired
	private CompactDisc cd;
	
	
	public void play() { 
		cd.play();
	}
}
