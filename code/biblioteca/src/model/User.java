package model;

public class User {
  private String name;
  private String username;
  private String type;
  private String address;
  private String email;
  private String phone;
  private String status;

  public User(String username, String name, String type, String address,
      String email, String phone, String status) {
    this.username = username;
    this.name = name;
    this.type = type;
    this.address = address;
    this.email = email;
    this.status = status;
    this.phone = phone;
  }

  public User(String username, String name, String type) {
    this.username = username;
    this.name = name;
    this.type = type;
  }

  public User(String name, String username) {
    this.name = name;
    this.username = username;
  }

  public boolean isAdmin() {
    if (this.type.equals("ADMINISTRADOR"))
      return true;
    return false;
  }

  public boolean isMember() {
    if (this.type.equals("MEMBRO"))
      return true;
    return false;
  }

  public String getUsername() {
    return this.username;
  }

  public String getName() {
    return this.name;
  }

  public String getType() {
    return this.type;
  }

  public String getAddress() {
    return this.address;
  }

  public String getEmail() {
    return this.email;
  }

  public String getPhone() {
    return this.phone;
  }

  public String getStatus() {
    return status;
  }
}