/*
 * Copyright (C) 2015 Mohamed Boullouz.
 * contact: <mohamed.boullouz@gmail.com>
 * This file is part of equinooxe Project
 */
package com.equinooxe.domain;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Mohamed
 */
@Entity
@Table()
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "@id")
public class Permission extends BaseEntity {

    @Column(name = "name", unique = true)
    private String name;

    @OneToMany(mappedBy = "permission", targetEntity = RolePermission.class)
    private Collection<RolePermission> rolePermissions;

    public Permission() {
        super();
    }

    public Permission(String name) {
        super();
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Collection<RolePermission> getRolePermissions() {
        return rolePermissions;
    }

    public void setRolePermissions(Collection<RolePermission> rolePermissions) {
        this.rolePermissions = rolePermissions;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Permission)) {
            return false;
        }
        Permission other = (Permission) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Permission[ id=" + id + " ]";
    }

}
