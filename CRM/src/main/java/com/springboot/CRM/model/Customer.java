package com.springboot.CRM.model;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
@Entity
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	 private String name;
	    private String email;
	    private String phone;
	    private String address;
	    private LocalDateTime createdAt;
	    private LocalDateTime updatedAt;

	    @ManyToOne
	    private User manager;

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getPhone() {
			return phone;
		}

		public void setPhone(String phone) {
			this.phone = phone;
		}

		public String getAddress() {
			return address;
		}

		public void setAddress(String address) {
			this.address = address;
		}

		public LocalDateTime getCreatedAt() {
			return createdAt;
		}

		public void setCreatedAt(LocalDateTime createdAt) {
			this.createdAt = createdAt;
		}

		public LocalDateTime getUpdatedAt() {
			return updatedAt;
		}

		public void setUpdatedAt(LocalDateTime updatedAt) {
			this.updatedAt = updatedAt;
		}

		public User getManager() {
			return manager;
		}

		public void setManager(User manager) {
			this.manager = manager;
		}

		@Override
		public String toString() {
			return "Customer [id=" + id + ", name=" + name + ", email=" + email + ", phone=" + phone + ", address="
					+ address + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + ", manager=" + manager + "]";
		}
		
}
