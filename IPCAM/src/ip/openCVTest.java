	package ip;


	import java.io.IOException;


	import javax.swing.JFrame;
    import javax.swing.JInternalFrame;

    import org.opencv.core.Core;
    import org.opencv.videoio.*;
    
    public class openCVTest
    {
    	static videoCamera cam1;
    	static videoCamera cam2;
    public static void main(String[] args) throws IOException
    {
        System.load("C://Users//user//eclipse-workspace//opencv/build//x64/vc15//bin//opencv_videoio_ffmpeg460_64.dll");
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);

        JFrame jf=new JFrame();
        jf.setLayout(null);
        jf.setSize(1280, 720);
        jf.setVisible(true);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JInternalFrame jInternalFrame=new JInternalFrame();
        jInternalFrame.setLocation(100, 100);
        jInternalFrame.setSize(500, 300);
        jInternalFrame.setTitle("Internal frame");
        jInternalFrame.setVisible(true);
        jInternalFrame.setClosable(true);
        jInternalFrame.setResizable(true);
        jf.add(jInternalFrame);
        
        JInternalFrame jInternalFrame2=new JInternalFrame();
        jInternalFrame2.setLocation(700, 100);
        jInternalFrame2.setSize(500, 300);
        jInternalFrame2.setTitle("Internal frame");
        jInternalFrame2.setVisible(true);
        jInternalFrame2.setClosable(true);
        jInternalFrame2.setResizable(true);
        jf.add(jInternalFrame2);
        jf.repaint();

        VideoCapture camera = new VideoCapture("http://114.152.150.34:8082/nphMotionJpeg?Resolution=320x240&Quality=Standard");
	    openCVTest.cam1 = new videoCamera(camera);
        VideoCapture camera2 = new VideoCapture("http://114.152.150.34:8081/nphMotionJpeg?Resolution=320x240&Quality=Standardx?.mjpg");
	    openCVTest.cam2 = new videoCamera(camera2);
	    
	    jInternalFrame.add(cam1);
	    jInternalFrame2.add(cam2);
	    
	    new IP1().start();
	    new IP2().start();
	    
    }
}    
    
    class IP1 extends Thread {
        public IP1() {
            // super: Allocates a new Thread object.
            // This constructor has the same effect as Thread (null, null, name).
            super();
        }
        public void run() {
        	System.out.println("Video is run");
    	while(true)
        {
    		openCVTest.cam1.repaint();
        }
    }
    }
    class IP2 extends Thread {
        public IP2() {
            // super: Allocates a new Thread object.
            // This constructor has the same effect as Thread (null, null, name).
            super();
        }
        public void run() {
        	System.out.println("Video is run 2");
    	while(true)
        {
    		openCVTest.cam2.repaint();
        }
    }
    }
