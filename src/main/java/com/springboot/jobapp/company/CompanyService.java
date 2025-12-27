package com.springboot.jobapp.company;



import java.util.List;

public interface CompanyService {

    List<Company> getAllCompanies();

    //Company updateCompany(Company company);
    boolean updateCompany(Company company, Long id);

    void createCompany(Company company);

    boolean deleteCompanyById(Long id);


}
