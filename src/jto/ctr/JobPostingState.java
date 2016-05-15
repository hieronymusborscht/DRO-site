package jto.ctr;

public class JobPostingState {
	
	public JobPostingState(){}
	
	
	private java.util.ArrayList<jto.ent.JobPosting> postings;
	private jto.ent.JobPosting temp_posting;
	
	
	
	public java.util.ArrayList<jto.ent.JobPosting> getPostings() {
		return postings;
	}
	public jto.ent.JobPosting getTemp_posting() {
		return temp_posting;
	}
	public void setPostings(java.util.ArrayList<jto.ent.JobPosting> postings) {
		this.postings = postings;
	}
	public void setTemp_posting(jto.ent.JobPosting temp_posting) {
		this.temp_posting = temp_posting;
	}

}
