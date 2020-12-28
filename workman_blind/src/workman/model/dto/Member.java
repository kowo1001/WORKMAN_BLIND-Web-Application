package workman.model.dto;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder

@Entity
public class Member {
	
	@Id 
	@Column(name = "user_id")
	private String userid;
	
	@ManyToOne
	@JoinColumn(name = "company_name")
	private Company companyname;
	
	@Column(name = "user_pw")
	private String userpw;
	
	@Column(name = "user_name")
	private String username;
	
	@Column(name = "user_email")
	private String useremail;
	
	@OneToMany(mappedBy = "userid")
	private List<ParttimeEval> parttimeevals;
	
	@OneToMany(mappedBy = "userid")
	private List<ParttimeList> parttimelists;
	


}