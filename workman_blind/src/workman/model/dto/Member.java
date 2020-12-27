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
	private String user_id;
	
	@ManyToOne
	@JoinColumn(name = "company_name")
	private Company companyname;
	
	@Column(name = "user_pw")
	private String user_pw;
	
	@Column(name = "user_name")
	private String user_name;
	
	@Column(name = "user_email")
	private String user_email;
	
	@OneToMany(mappedBy = "userid")
	private List<Parttimeeval> parttimeeval;
	
	@OneToMany(mappedBy = "userid")
	private List<Parttimelist> parttimelists;
	


}