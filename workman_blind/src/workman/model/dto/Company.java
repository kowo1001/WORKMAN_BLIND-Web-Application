package workman.model.dto;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder


@Entity
public class Company {

	@Id
	@Column(name = "company_name")
	private String companyname;
	
	@Column(name = "company_story")
	private String companystory;
	
	@Column(name = "company_loc")
	private String companyloc;
	
	@Column(name = "company_num")
	private String companynum;
	
	@OneToMany(mappedBy = "companyname")
	private List<Member> members;
	
	@OneToMany(mappedBy = "companyname")
	private List<ParttimeList> parttimelists;
	
	@OneToMany(mappedBy = "companyname")
	private List<ParttimeEval> parttimeevals;

	
}