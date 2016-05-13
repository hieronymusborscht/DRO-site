package jto;

public class UploadedImage {
	
	private int id;
	private String fileName ;
	private String contentType;
	private int sizeBytes;
	private int width;
	private byte[] thedata;
	
	public UploadedImage() {}
	
	public int getId(){return id;}
	public int getWidth(){return width;}
	public String getFileName(){return fileName;}
	public String getContentType(){ return contentType;}
	public int getSizeBytes(){return sizeBytes;	}
	public int getSizeKiloBytes(){ return (sizeBytes/1024);}
	public byte[] getThedata(){return thedata;}
	public int getLength(){ return thedata.length; }
	
	public void setId(int i ){id=i;}
	public void setFileName(String s){ fileName=s; }
	public void setContentType(String s){ contentType=s; }
	public void setSizeBytes(int i){sizeBytes=i;}
	public void setWidth(int i){width=i;}
	public void setThedata(byte[] barr){ thedata=barr;}
}
