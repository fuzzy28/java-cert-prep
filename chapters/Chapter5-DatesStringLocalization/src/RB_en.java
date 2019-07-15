
import java.util.ListResourceBundle;

public class RB_en extends ListResourceBundle {

	@Override
	protected Object[][] getContents() {
		Object[][] object = { { "name", "name from java bundle" }, { "middle name", "middle name from java bundle" },
				{ "last name", "last name from java bundle" } };
		return object;
	}

}
