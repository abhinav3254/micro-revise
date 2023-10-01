package com.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Book {
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    private String title;
	    private String isbn;
	    private Integer pageCount;

	    @Embedded
	    public PublishedDate publishedDate;

	    private String thumbnailUrl;

	    @Column(length = 4000)
	    private String shortDescription;

	    @Column(length = 4000)
	    private String longDescription;

	    private String status;

	    @ElementCollection
	    private List<String> authors = new ArrayList<>();

	    @ElementCollection
	    private List<String> categories = new ArrayList<>();

	    
	    public Book() {}


		public Long getId() {
			return id;
		}


		public void setId(Long id) {
			this.id = id;
		}


		public String getTitle() {
			return title;
		}


		public void setTitle(String title) {
			this.title = title;
		}


		public String getIsbn() {
			return isbn;
		}


		public void setIsbn(String isbn) {
			this.isbn = isbn;
		}


		public Integer getPageCount() {
			return pageCount;
		}


		public void setPageCount(Integer pageCount) {
			this.pageCount = pageCount;
		}

		public PublishedDate getPublishedDate() {
			return publishedDate;
		}


		public void setPublishedDate(PublishedDate publishedDate) {
			this.publishedDate = publishedDate;
		}


		public String getThumbnailUrl() {
			return thumbnailUrl;
		}


		public void setThumbnailUrl(String thumbnailUrl) {
			this.thumbnailUrl = thumbnailUrl;
		}


		public String getShortDescription() {
			return shortDescription;
		}


		public void setShortDescription(String shortDescription) {
			this.shortDescription = shortDescription;
		}


		public String getLongDescription() {
			return longDescription;
		}


		public void setLongDescription(String longDescription) {
			this.longDescription = longDescription;
		}


		public String getStatus() {
			return status;
		}


		public void setStatus(String status) {
			this.status = status;
		}


		public List<String> getAuthors() {
			return authors;
		}


		public void setAuthors(List<String> authors) {
			this.authors = authors;
		}


		public List<String> getCategories() {
			return categories;
		}


		public void setCategories(List<String> categories) {
			this.categories = categories;
		}

	    // Getters and setters...
		@Embeddable
		public static class PublishedDate {
		    private Date date;

		    public PublishedDate() {
		        // Default constructor
		    }

		    public Date getDate() {
		        return date;
		    }

		    public void setDate(Date date) {
		        this.date = date;
		    }
		}
    
}
