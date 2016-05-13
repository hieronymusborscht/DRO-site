package jto.obj;

public class ImageLibrary {
	
	int load_from;
	int single_img_id;
	
	

	java.util.ArrayList<jto.UploadedImage> theupimages;
	
	public ImageLibrary(){
		theupimages = new java.util.ArrayList<jto.UploadedImage>();
		load_from=0;
		single_img_id=0;
	}
	
	public int prevIndex(){
		int i=0;
		int sze = theupimages.size();
		if(sze>0){
		 i = ((jto.UploadedImage)theupimages.get(sze-1)).getId();
		}
		return i;
	}
	
	public int nextIndex(){
		int i=0;
		int sze = theupimages.size();
		if(sze>0){
		 i = ((jto.UploadedImage)theupimages.get(sze-1)).getId();
		}
		return i+18;
	}
	
	

	
	
	public void setLoad_from(int i){
		load_from=i;
	}
	public int getLoad_from(){return load_from;};
	
	public int getSingleId(){
		return single_img_id;
	}
	public void setSingleId(int i){
		single_img_id=i;
	}
	
	
	
	public void setTheUpImages(java.util.ArrayList<jto.UploadedImage> theimages){
		theupimages = theimages;
	}
	public java.util.ArrayList<jto.UploadedImage> getTheUpImages(){
		return theupimages;
	}
	

	public jto.UploadedImage getOneUpImage(int i){
		return theupimages.get(i);
	}

	
	public int getArraySize(){
		return theupimages.size();
	}
	
	
	

	
	
	
}
