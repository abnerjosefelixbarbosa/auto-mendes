package com.org.auto_mendes_back_end_spring_boot_java.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ExchangeType {
	MANUAL("Manual"), AUTOMATIC("Automatic"), AUTOMATED("Automated"), CVT("CVT"), SEMI_AUTOMATIC("SemiAutomatic"), DCT("DCT"), QUICK_SHIFTER("QuickShifter");
	
	private String value;
}