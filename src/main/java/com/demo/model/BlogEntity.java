package com.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Blogs")
public class BlogEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name="Blog_Title")
    private String BlogTitle;
    
    @Column(name="Blog_Date_Created")
    private int BlogDate;
    
    @Column(name="Blog_Content", nullable=false, length=200)
    private String BlogContent;

	public Long getId() {
		return id;
	}

	public int getBlogDate() {
		return BlogDate;
	}

	public void setBlogDate(int blogDate) {
		BlogDate = blogDate;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getBlogTitle() {
		return BlogTitle;
	}

	public void setBlogTitle(String blogTitle) {
		BlogTitle = blogTitle;
	}



	public String getBlogContent() {
		return BlogContent;
	}

	public void setBlogContent(String blogContent) {
		BlogContent = blogContent;
	}

	@Override
	public String toString() {
		return "BlogEntity{" +
				"id=" + id +
				", BlogTitle='" + BlogTitle + '\'' +
				", BlogDate='" + BlogDate + '\'' +
				", BlogContent='" + BlogContent + '\'' +
				'}';
	}
}