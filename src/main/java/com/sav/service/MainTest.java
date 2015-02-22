package com.sav.service;
import java.util.List;

import com.sav.persistance.Client;



public class MainTest {
	public static void main(String[] args) {
		ClientService ser=new ClientService ();	
		List<Client> l =ser.rechercheTousClient();
		
		System.out.println(l.size());
		
		for(int i=0;i<l.size();i++)
			System.out.println(l.get(i));
	}
}
