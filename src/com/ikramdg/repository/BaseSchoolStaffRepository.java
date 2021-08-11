package com.ikramdg.repository;

import com.ikramdg.model.Address;
import com.ikramdg.model.BaseSchoolStaff;

public interface BaseSchoolStaffRepository<S extends BaseSchoolStaff> extends  CrudRepository<S>{

    Address findAddressById(Long id);

}
