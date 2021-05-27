package fr.editions_eni.actions;

import java.util.Random;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class SportAuHasardAction extends ActionSupport {
	
	private String unSport;
	
	public String getUnSport() {
		return unSport;
	}
	public void setUnSport(String unSport) {
		this.unSport = unSport;
	}

	@Override
	public String execute() throws Exception {
		String[] sports = {"Badminton","Squash","Padel","Tennis"};
		Random rd = new Random();
		this.unSport = sports[rd.nextInt(sports.length)];
		return "succesHasard";
	}
	
//	@Action(value="/url-personnalisee")
//	@Action(
//			value="/url/personnalisee/vers/action",
//			results={
//						@Result(name="succesHasard",location="/resultSuccesHasard.jsp")
//					}
//			)
	@Action(
	value="/url/personnalisee/vers/action",
	results={
				@Result(name="success",location="/resultSuccesHasard.jsp")
			}
	)
	public String traiter()
	{
		this.unSport="Football";
		//return "succesHasard";
		return ActionSupport.SUCCESS;
	}
}
