package com.opencvcamera;

import org.opencv.core.Core;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Dimension;
import java.awt.EventQueue;

public class Camera extends JFrame{
	public Camera() {
		setSize(new Dimension(1280,720));
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	public static void main(String[] args) {
		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
		System.out.println("Load Success");
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				Camera camera = new Camera();
			}
		});

	}
	
}
