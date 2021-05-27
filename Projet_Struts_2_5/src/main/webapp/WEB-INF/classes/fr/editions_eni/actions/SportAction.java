package fr.editions_eni.actions;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.interceptor.validation.SkipValidation;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.validator.annotations.*;

import fr.editions_eni.javaee.models.Sport;
import fr.editions_eni.javaee.models.Surface;
import fr.editions_eni.javaee.models.Terrain;

public class SportAction extends ActionSupport implements SessionAware {

	private Sport nouveauSport;
//	private List<Terrain> terrains;
	
	public Sport getNouveauSport() {
		return nouveauSport;
	}

	public void setNouveauSport(Sport nouveauSport) {
		this.nouveauSport = nouveauSport;
	}

//	public List<Terrain> getTerrains() {
//		return terrains;
//	}
//
//	public void setTerrains(List<Terrain> terrains) {
//		this.terrains = terrains;
//	}
	
	//GESTION DES ATTRIBUTS DE SESSION
	private Map<String,Object> session;
	@Override
	public void setSession(Map<String, Object> session) {
		this.session=session;
	}
	
	
	@Override
	public void validate() {
		if(this.nouveauSport.getTerrainsCompatibles().size()==0)
		{
			//this.addFieldError("nouveauSport.terrainsCompatibles", "La sélection d'au moins un terrain est obligatoire (méthode validate())");
			this.addFieldError("nouveauSport.terrainsCompatibles", getText("validation.terrains.obligatoire"));
		}
	}

	@SkipValidation
	@Action(value="/editSport", 
			results={@Result(name=ActionSupport.INPUT,location="/WEB-INF/content/sport.jsp")})
	public String chargement()
	{
		this.nouveauSport=new Sport();
		this.nouveauSport.setNom("nouveau sport");
//		this.terrains=new ArrayList<>();
//		this.terrains.add(new Terrain("T1", Surface.BETON));
//		this.terrains.add(new Terrain("T2", Surface.PARQUET));
//		this.terrains.add(new Terrain("T3", Surface.BETON));
		List<Terrain> terrains=new ArrayList<>();
		terrains.add(new Terrain("T1", Surface.BETON));
		terrains.add(new Terrain("T2", Surface.PARQUET));
		terrains.add(new Terrain("T3", Surface.BETON));
		this.session.put("terrains", terrains);
		return ActionSupport.INPUT;
	}
	
	@Validations
	(
		requiredStrings=
		{
				@RequiredStringValidator(fieldName="nouveauSport.nom",/*message="Le nom est obligatoire"*/message="%{getText('validation.champ.obligatoire',{getText('champ.nom')})}")
		},
		intRangeFields=
		{
				@IntRangeFieldValidator(fieldName="nouveauSport.nombreJoueurs",min="1",max="10",/*message="Le nombre de joueurs doit être compris entre 1 et 10"*/key="validation.nombreJoueurs.plage")
		}
//		,
//		expressions=
//		{
//				@ExpressionValidator(expression="nouveauSport.terrainsCompatibles.size()>0",message="Au moins un terrain doit être sélectionné")
//		}
		,
		fieldExpressions=
		{
				@FieldExpressionValidator(fieldName="nouveauSport.terrainsCompatibles",expression="nouveauSport.terrainsCompatibles.size()>0",/*message="Au moins un terrain doit être sélectionné"*/key="validation.terrains.obligatoire")
		}
	)
	@Action(value="/addSport",
			interceptorRefs={@InterceptorRef("defaultStack")},
			results={
					 @Result(name=ActionSupport.INPUT,location="/WEB-INF/content/sport.jsp"),
					 @Result(name=ActionSupport.SUCCESS,location="/WEB-INF/content/ok.jsp"),
					})
	public String ajouterSport()
	{
		//Traitement métier
		return ActionSupport.SUCCESS;
	}

	
}
