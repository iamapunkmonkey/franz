package com.iamapunkmonkey.franz.framework;

import android.view.SurfaceHolder;

public class FranzGameThread extends Thread {
	private boolean isRunning, isPaused;
	private SurfaceHolder _surfaceHolder;
	private FranzGamePanel _gamePanel;
	
	public FranzGameThread(SurfaceHolder surfaceHolder, FranzGamePanel gamePanel){
		super();
		this._surfaceHolder = surfaceHolder;
		this._gamePanel = gamePanel;
	}
	
	public void startGame(){
		isRunning = true;
		isPaused = false;		
	}
	
	public void stopGame(){
		isRunning = false;
		isPaused = false;
	}
	
	public void pauseGame(){
		isPaused = true;
	}
	
	public void resumeGame(){
		isPaused = false;
	}
	
	@Override
	public void run(){
		while(isRunning){
			if(!isPaused){
				
			}
		}
	}
}