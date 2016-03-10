package addressbook.service;

import addressbook.model.Address;

public class PhoneAddressService {
    public String convertInputPhone (String input, int countryId){
        String phone = null;
        String[] temp = input.trim().split("-");
        for (String aTemp : temp) {
            phone = phone + temp;
        }
    }
    public String showPhone (String phone, int countryId){}
    public String showAddress (Address address, int countryId) {}
}
