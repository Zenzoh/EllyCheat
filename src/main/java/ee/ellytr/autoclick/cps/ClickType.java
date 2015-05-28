package ee.ellytr.autoclick.cps;

import org.apache.commons.lang.WordUtils;

public enum ClickType {

	LEFT(), RIGHT();

	@Override
	public String toString() {
		return WordUtils.capitalizeFully(name());
	}

}
