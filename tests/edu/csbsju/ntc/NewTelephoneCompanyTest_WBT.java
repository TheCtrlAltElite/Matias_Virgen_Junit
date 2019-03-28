package edu.csbsju.ntc;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class NewTelephoneCompanyTest_WBT {
	private NewTelephoneCompany ntc;
	
	@Before
	public void setUp() throws Exception {
	    this.ntc = new NewTelephoneCompany();
	}

	@Test(expected=UnsupportedOperationException.class)
	public void testTestComputeCharge_InvalidStartTime_Case1() {
		ntc.setStartTime(-5);
		ntc.setDuration(10);
		ntc.computeCharge();
		
	}

	@Test(expected=UnsupportedOperationException.class)
	public void testTestComputeCharge_InvalidDuration_Case1() {
		ntc.setStartTime(1801);
		ntc.setDuration(0);
		ntc.computeCharge();
	}

	

	@Test
	public void testTestComputeCharge_BothDiscounts() {
		ntc.setStartTime(759);
		ntc.setDuration(61);
		assertTrue("Charge is discounted",ntc.computeCharge()==1078.48);
	}
	
	@Test
	public void testTestComputeCharge_StartTimeDiscount() {
		ntc.setStartTime(759);
		ntc.setDuration(1);
		assertTrue("Charge is discounted",ntc.computeCharge()==20.8);
	}


	@Test
	public void testTestComputeCharge_DurationDiscount() {
		ntc.setStartTime(800);
		ntc.setDuration(65);
		assertTrue("Charge is discounted",ntc.computeCharge()==2298.4);
	}

	@Test
	public void testTestComputeCharge_NoDiscounts() {
		ntc.setStartTime(800);
		ntc.setDuration(1);
		assertTrue("Charge is discounted",ntc.computeCharge()==41.6);
	}
}
