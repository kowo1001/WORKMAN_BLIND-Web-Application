package workman.model.dto;


import java.lang.reflect.Member;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Parttimelist {
	
	@Id @GeneratedValue
	@Column(name="text_list")
	private Long textlist;
	
	@OneToMany
	@JoinColumn(name="user_id")
	private List<Member> members;
	
	@ManyToOne
	@JoinColumn(name="company_name")
	private Company company;
	
	@Column(name="review_num")
	private int reviewnum;
	
	@Column(name="review_score")
	private int reviewscore;
	
	@Column(name="recruit_status")
	private String recruitstatus;
	
	@Column(name="date")
	private String date;
	
	@Column(name="emp_period")
	private String empperiod;
	
	@OneToMany(mappedBy="parttimelist")
	private List<Parttimeeval> parttimeeval = new ArrayList<>();

}

