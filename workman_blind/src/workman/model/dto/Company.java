package workman.model.dto;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

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
	private List<Parttimelist> parttimelists;
	
	@OneToMany(mappedBy = "companyname")
	private List<Parttimeeval> parttimeevals;
	

}