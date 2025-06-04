package com.devjoliveira.challenge3_devsuperior.entities;

import java.time.LocalDate;

import com.devjoliveira.challenge3_devsuperior.dto.ClinetDto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_client")
public class Client {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String name;
  private String cpf;
  private Double income;
  private LocalDate birthDate;
  private Integer children;

  public Client() {
  }

  public Client(ClinetDto dto) {
    this.id = dto.id();
    this.name = dto.name();
    this.cpf = dto.cpf();
    this.income = dto.income();
    this.birthDate = dto.birthDate();
    this.children = dto.children();
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getCpf() {
    return cpf;
  }

  public void setCpf(String cpf) {
    this.cpf = cpf;
  }

  public Double getIncome() {
    return income;
  }

  public void setIncome(Double income) {
    this.income = income;
  }

  public LocalDate getBirthDate() {
    return birthDate;
  }

  public void setBirthDate(LocalDate birth_date) {
    this.birthDate = birth_date;
  }

  public Integer getChildren() {
    return children;
  }

  public void setChildren(Integer children) {
    this.children = children;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((id == null) ? 0 : id.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Client other = (Client) obj;
    if (id == null) {
      if (other.id != null)
        return false;
    } else if (!id.equals(other.id))
      return false;
    return true;
  }

  @Override
  public String toString() {
    return "Client [id=" + id + ", name=" + name + ", cpf=" + cpf + ", income=" + income + ", birth_date=" + birthDate
        + ", children=" + children + "]";
  }

}
