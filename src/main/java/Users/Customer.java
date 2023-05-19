package Users;

import Products.Menu;

public class Customer extends User {
    private Menu menu;

    public Customer(){
        super();
        this.menu = new Menu();
    }



}