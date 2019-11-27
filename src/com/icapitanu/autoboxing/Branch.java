package com.icapitanu.autoboxing;

import java.util.ArrayList;

public  class Branch {
    private String name;
    private ArrayList<Customer> branchCustomers;

    public Branch(String name ) {
        this.name = name;
        this.branchCustomers = new ArrayList<Customer>();
    }

    private boolean findCustomerByName (String custName) {
        for (int i=0; i<branchCustomers.size(); i++){
            if (branchCustomers.get(i).getName().equals(custName)) return true;
        }
        return false;
    }

    public Customer getCustomerByName (String custName) {
        for (int i=0; i<branchCustomers.size(); i++){
            Customer checkedCustomer = branchCustomers.get(i);
            if (checkedCustomer.getName().equals(custName))
                return checkedCustomer;
        }
        return null;
    }

    public boolean addCustomer(Customer cust) {
        if (findCustomerByName(cust.getName())) return false; // Demo already exists
          else {
              branchCustomers.add(cust);
              return true;
               }
     }


    public String getName() {
        return name;
    }

    public ArrayList<Customer> getBranchCustomers() {
        return branchCustomers;
    }
}
