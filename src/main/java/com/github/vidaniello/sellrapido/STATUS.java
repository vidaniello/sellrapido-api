package com.github.vidaniello.sellrapido;

/**
 * Order Sellrapido status.
 * @author Vincenzo D'Aniello (vidaniello@gmail.com) github.com/vidaniello
 *
 */
public enum STATUS {
	standby,accepted,sent,cancelled,not_specified;
	
	public static STATUS parse(String status) {
		if(status!=null)
			if(!status.isEmpty())
				try {
					return STATUS.valueOf(status);
				} catch (IllegalArgumentException e) {
					return STATUS.not_specified;
				}
		return STATUS.not_specified;
	}
}
