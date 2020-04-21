package pythagorasTable;

public class ZodiacHoroscope {

	public enum ZodiacElements {
		WATER,
		FIRE,
		EARTH,
		AIR
	}

	public enum ZodiacHoroscopeSigns {
	    ARIES      ("01"),
	    TAURUS     ("02"),
	    GEMINI     ("03"),
	    CANCER     ("04"),
	    LEO        ("05"),
	    VIRGO      ("06"),
	    LIBRA      ("07"),
	    SCORPIO    ("08"),
	    SAGITTARIUS("09"),
	    CAPRICORN  ("10"),
	    AQUARIUS   ("11"),
	    PISCES     ("12");
	    private String value;
	    
	    private ZodiacHoroscopeSigns(String value){
	    	this.value = value;
	    }

		public String getValue() {
			return value;
		}
	}

	public static ZodiacHoroscopeSigns defineZodiac(int bDay, int bMonth) {
		ZodiacHoroscopeSigns horoscopeSign = ZodiacHoroscopeSigns.ARIES;

		if ((bMonth == 3 && bDay >= 21) || (bMonth == 4 && bDay <= 19)) {
			 horoscopeSign = ZodiacHoroscopeSigns.ARIES;
		} else if ((bMonth == 4 && bDay >= 20) || (bMonth == 5 && bDay <= 20)) {
			 horoscopeSign = ZodiacHoroscopeSigns.TAURUS;
		} else if ((bMonth == 5 && bDay >= 21) || (bMonth == 6 && bDay <= 20 )) {
			horoscopeSign = ZodiacHoroscopeSigns.GEMINI;
		} else if ((bMonth == 6 && bDay >= 21) || (bMonth == 7 && bDay <= 22 )) {
			 horoscopeSign = ZodiacHoroscopeSigns.CANCER;
		} else if ((bMonth == 7 && bDay >= 23) || (bMonth == 8 && bDay <= 22 )) {
			 horoscopeSign = ZodiacHoroscopeSigns.LEO;
		} else if ((bMonth == 8 && bDay >= 23) || (bMonth == 9 && bDay <= 22 )) {
			 horoscopeSign = ZodiacHoroscopeSigns.VIRGO;
		} else if ((bMonth == 9 && bDay >= 23) || (bMonth == 10 && bDay <= 22 )) {
			 horoscopeSign = ZodiacHoroscopeSigns.LIBRA;
		} else if ((bMonth == 10 && bDay >= 23) || (bMonth == 11 && bDay <= 21 )) {
			 horoscopeSign = ZodiacHoroscopeSigns.SCORPIO;
		} else if ((bMonth == 11 && bDay >= 22) || (bMonth == 12 && bDay <= 21 )) {
			 horoscopeSign = ZodiacHoroscopeSigns.SAGITTARIUS;
		} else if ((bMonth == 12 && bDay >= 22) || (bMonth == 1 && bDay <= 19 )) {
			 horoscopeSign = ZodiacHoroscopeSigns.CAPRICORN;
		} else if ((bMonth == 1 && bDay >= 20) || (bMonth == 2 && bDay <= 18)) {
			 horoscopeSign = ZodiacHoroscopeSigns.AQUARIUS;
		} else if ((bMonth == 2 && bDay >= 19) || (bMonth == 3 && bDay <= 20)) {
			 horoscopeSign = ZodiacHoroscopeSigns.PISCES;
		}
		return horoscopeSign;
	}

	public static ZodiacElements defineElement(ZodiacHoroscopeSigns horoscopeSign) {
		ZodiacElements element;
		switch(horoscopeSign) {
		    case ARIES:
		    case LEO:
		    case SAGITTARIUS:
			   element = ZodiacElements.FIRE;
			   break;
		    case CANCER:
		    case SCORPIO:
		    case PISCES:
		    	element = ZodiacElements.WATER;
		    	break;
		    case TAURUS:
		    case VIRGO:
		    case CAPRICORN:
		    	element = ZodiacElements.EARTH;
		    default:  element = ZodiacElements.AIR;
		}
		return element;
	}
}
