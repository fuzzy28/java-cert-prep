package i18n;

import java.util.Locale;

public class LocaleUsage {

	static void create() {
		System.out.println("--------Create local--------");
		System.out.println("Default: " + Locale.getDefault());
		System.out.println("Locale german: " + Locale.GERMAN); // Language only
		System.out.println("Locale germany: " + Locale.GERMANY); // Language + Country
		System.out.println("Custom locale: " + new Locale("joel"));
		System.out.println("Custom locale: " + new Locale("joel", "ruelos"));

		Locale l = new Locale.Builder()
//				.setRegion("testing") // throws runtime exception if not valid, throws Ill-formed
				.setRegion("DE").setLanguage("joel").build();
		System.out.println("Locale from builder: " + l);
	}

	static void setDefaultLocale() {
		System.out.println("--------Set default locale--------");
		Locale l = new Locale("JOEL");
		Locale.setDefault(l);
		System.out.println("Locale default set to custom: " + l);
		System.out.println("Locale get default language: " + Locale.getDefault().getLanguage());
		System.out.println("Locale get default country: " + Locale.getDefault().getCountry());
	}

	public static void main(String[] args) {
		create();
		setDefaultLocale();
	}
}
