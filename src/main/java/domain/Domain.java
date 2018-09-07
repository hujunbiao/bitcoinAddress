package domain;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import repository.*;
import entity.*;


/**
 * Created by Jesus on 21.09.2017.
 */
public class Domain {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        AddressRepository addressRepository = context.getBean(AddressRepository.class);

        Address address = new Address();
        //address.setId(1L);
        address.setCountry("Ukraine");
        address.setCity("Kyiv");
        address.setStreet("Pidvysotskogo");
        address.setPostCode("01014");

        addressRepository.save(address);

    }
}
