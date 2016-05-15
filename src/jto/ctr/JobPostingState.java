package jto.ctr;

public class JobPostingState {
	
	private java.util.ArrayList<jto.ent.JobPosting> postings;
	private jto.ent.JobPosting temp_posting;
	private java.util.ArrayList<jto.ent.WorkType> work_types;
	
	
	public JobPostingState(){
		
		temp_posting = new jto.ent.JobPosting();
		
		work_types = new java.util.ArrayList<jto.ent.WorkType>();
		work_types.add(new jto.ent.WorkType(1,"Labour","manual labor"));
		work_types.add(new jto.ent.WorkType(1,"Phone Sales","phone sales"));
		work_types.add(new jto.ent.WorkType(1,"Skilled Trades","costruction, residential commercial"));
	}
	
	
	
	
	
	
	public java.util.ArrayList<jto.ent.JobPosting> getPostings() {
		return postings;
	}
	public jto.ent.JobPosting getTemp_posting() {
		if(temp_posting==null){temp_posting = new jto.ent.JobPosting();}
		return temp_posting;
	}
	public void setPostings(java.util.ArrayList<jto.ent.JobPosting> postings) {
		this.postings = postings;
	}
	public void setTemp_posting(jto.ent.JobPosting temp_posting) {
		this.temp_posting = temp_posting;
	}

	
	public String getWorkTypeOptions(){
		StringBuilder sb = new StringBuilder();
		
		for(int i=0; i<work_types.size(); i++){
			jto.ent.WorkType wt = work_types.get(i);
			
			sb.append("<option value=\"");
			sb.append(wt.getWt_id());
			sb.append("\"");
			if(temp_posting.getWork_type_id()==wt.getWt_id()){
				sb.append(" selected=\"selected\" ");
			}
			sb.append(">");
			sb.append(wt.getWt_name());
			sb.append("</option>");
		}
		
		return sb.toString();
	}
	
	
	
	
	
}
