package com.dash.mockitoapp.demoapp.dto;

public class UserDto {

    private String name;
    private String address;

    public UserDto(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "UserDto [name=" + name + ", address=" + address + "]";
    }

}
