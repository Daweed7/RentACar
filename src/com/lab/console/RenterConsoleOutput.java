package com.lab.console;

import com.lab.domain.Renter;
import com.lab.service.RenterService;

public class RenterConsoleOutput {

    RenterService renterService=new RenterService();

    public void outputRenter(int id){
        System.out.println(renterService.get(id));
    }
    public void outputAllRenters(){
        for (Renter r:renterService.getAll())
            System.out.println(r);
    }

}
