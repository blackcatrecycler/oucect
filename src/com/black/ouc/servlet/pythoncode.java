package com.black.ouc.servlet;

import java.io.IOException;

public class pythoncode {
	
	public void update() throws IOException{
		Process proc = Runtime.getRuntime().exec("cmd /c  F:\\javaproject\\oucect\\WebContent\\view\\user\\oucectquery.py");
	}
	
}
