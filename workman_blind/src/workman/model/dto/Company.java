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
	private List<Parttimelist> parttimelists;
	
	@OneToMany(mappedBy = "companyname")
	private List<Parttimeeval> parttimeevals;

	public String getCompanyname() {
		return companyname;
	}

	public void setCompanyname(String companyname) {
		this.companyname = companyname;
	}

	public String getCompanystory() {
		return companystory;
	}

	public void setCompanystory(String companystory) {
		this.companystory = companystory;
	}

	public String getCompanyloc() {
		return companyloc;
	}

	public void setCompanyloc(String companyloc) {
		this.companyloc = companyloc;
	}

	public String getCompanynum() {
		return companynum;
	}

	public void setCompanynum(String companynum) {
		this.companynum = companynum;
	}

	public List<Member> getMembers() {
		return members;
	}

	public void setMembers(List<Member> members) {
		this.members = members;
	}

	public List<Parttimelist> getParttimelists() {
		return parttimelists;
	}

	public void setParttimelists(List<Parttimelist> parttimelists) {
		this.parttimelists = parttimelists;
	}

	public List<Parttimeeval> getParttimeevals() {
		return parttimeevals;
	}

	public void setParttimeevals(List<Parttimeeval> parttimeevals) {
		this.parttimeevals = parttimeevals;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Company [companyname=");
		builder.append(companyname);
		builder.append(", companystory=");
		builder.append(companystory);
		builder.append(", companyloc=");
		builder.append(companyloc);
		builder.append(", companynum=");
		builder.append(companynum);
		builder.append(", members=");
		builder.append(members);
		builder.append(", parttimelists=");
		builder.append(parttimelists);
		builder.append(", parttimeevals=");
		builder.append(parttimeevals);
		builder.append("]");
		return builder.toString();
	}

	


}