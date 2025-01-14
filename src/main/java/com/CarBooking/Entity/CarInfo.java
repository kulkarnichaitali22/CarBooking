package com.CarBooking.Entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class CarInfo {
	
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    private String brandName;

	    private Double price;

	    private LocalDate createdDate;

	    private LocalDate modifiedDate;

	    private Boolean isAvailable;

		public CarInfo() {
			super();
			// TODO Auto-generated constructor stub
		}

		public CarInfo(String brandName, Double price, LocalDate createdDate, LocalDate modifiedDate,
				Boolean isAvailable) {
			super();
			this.brandName = brandName;
			this.price = price;
			this.createdDate = createdDate;
			this.modifiedDate = modifiedDate;
			this.isAvailable = isAvailable;
		}

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getBrandName() {
			return brandName;
		}

		public void setBrandName(String brandName) {
			this.brandName = brandName;
		}

		public Double getPrice() {
			return price;
		}

		public void setPrice(Double price) {
			this.price = price;
		}

		public LocalDate getCreatedDate() {
			return createdDate;
		}

		public void setCreatedDate(LocalDate createdDate) {
			this.createdDate = createdDate;
		}

		public LocalDate getModifiedDate() {
			return modifiedDate;
		}

		public void setModifiedDate(LocalDate modifiedDate) {
			this.modifiedDate = modifiedDate;
		}

		public Boolean getIsAvailable() {
			return isAvailable;
		}

		public void setIsAvailable(Boolean isAvailable) {
			this.isAvailable = isAvailable;
		}
	    
	    

}
